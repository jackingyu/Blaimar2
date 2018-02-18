package com.third.controller.weixin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.third.controller.pages.ControllerConstants;
import com.third.core.constants.CoreConstants;
import com.third.core.util.WXConstant;
import com.third.exceptions.SubscribeException;
import com.third.facade.customer.CustomerFacade;
import com.third.facade.customer.WeixinFacade;
import com.third.facade.data.CustomerData;
import com.third.service.user.SessionService;
import com.third.web.utils.SmsVerifyCodeUtils;

@Controller
public class WeixinMemberController extends AbstractWeixinController {
	private static final Logger LOG = Logger
			.getLogger(WeixinMemberController.class);

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "sessionService")
	private SessionService sessionService;

	@Resource(name = "weixinFacade")
	private WeixinFacade weixinFacade;

	@Resource(name = "smsVerifyCodeUtils")
	SmsVerifyCodeUtils smsVerifyCodeUtils;

	
	/**wx 类型的url需要经过weixinauthrozationfilter进行检查,weixin这种url不需要进行检查
	 * @param request
	 * @param model
	 * @param code
	 * @param state
	 * @param openId
	 * @return
	 */
	@RequestMapping(value = "/weixin/member/getregisterpage")
	public String getRegisterPage(final HttpServletRequest request,
			final Model model,
			@RequestParam(value = "code", required = false) final String code,
			@RequestParam(value = "state", required = false) final String state)
	{
		if (sessionService.contains(CoreConstants.Session.CURRENT_CUSTOMER))
		{
			System.out.println("有已绑定的顾客,跳转到member页");
			return getMemberPage(request, model);
		}

		// code 必须存在,此处不在进行code 必须输入的判断,直接通过参数进行404控制

        final String openId = weixinFacade.getOpenId(code);
        sessionService.save(WXConstant.WX_OPENID, openId);

        CustomerData customer = customerFacade.loginCustomer(openId);

        if (customer == null)
        {
            return ControllerConstants.WeiXin.REGISTERPAGE;
        }else
		    return "forward:/wx/member/home";

	}

	@RequestMapping(value = "/wx/member/home")
	public String getMemberPage(final HttpServletRequest request,
			final Model model)
	{
		CustomerData customer = customerFacade.getCurrentCustomer();
		Integer numberOfOrder = customerFacade
				.countOrder(customer.getCellphone());
		Integer numberOfReservation = customerFacade
				.countReservation(customer.getCellphone());

		model.addAttribute("numberOfOrder", numberOfOrder);
		model.addAttribute("numberOfReservation", numberOfReservation);
		model.addAttribute("customer", customer);

		return ControllerConstants.WeiXin.MEMBERPAGE;
	}

	@RequestMapping(value = "/weixin/member/registercustomer")
	public String bindCustomer(final HttpServletRequest request,
			final HttpServletRequest response,
			@RequestParam(value = "vcode", required = false) final String vcode,
			@RequestParam(value = "cellphone", required = false) final String cellphone,
			@RequestParam(value = "name", required = false) final String name,
			final Model model)
	{
		System.out.println("vcode=" + vcode);
		System.out.println("cellphone=" + cellphone);
		
		System.out.println("openID = "+sessionService.get(WXConstant.WX_OPENID));
		
		if (!sessionService.contains(WXConstant.WX_OPENID))
		{
			LOG.fatal("must access via wechat client");
			model.addAttribute("wx_error_msg", "必须通过微信页面进行用户注册");
			return "forward:" + ControllerConstants.WeiXin.ERRORPAGE;
		}

		if (smsVerifyCodeUtils.verifyVcode(vcode))
		{
			try
			{
				final String openId = (String) sessionService
						.get(WXConstant.WX_OPENID);
				System.out.println("openId:" + openId);
				customerFacade.registerCustomer(openId, cellphone, name);
				// 注册成功之后执行登录才能保证之后返回的会员主页可以取到当前用户,否则应该使用redirect
				customerFacade.loginCustomer(openId);
			} catch (SubscribeException e)
			{
				e.printStackTrace();
			}

			return getMemberPage(request, model);
		}

		System.out.println("sms verify code is not correct");
		model.addAttribute("WxErrorMessage", "验证码不正确");
		return "forward:" + ControllerConstants.WeiXin.ERRORURL;
	}

	// @RequestMapping(value = "/getStoreDetail")
	public String register(
			@RequestParam(value = "code", required = true) final String storeCode,
			final Model model)
	{
		return ControllerConstants.WeiXin.STOREDETAILPAGE;
	}

}
