package com.third.controller.weixin;


import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.third.controller.pages.ControllerConstants;
import com.third.core.util.WXConstant;
import com.third.exceptions.BussinessException;
import com.third.exceptions.NotFoundException;
import com.third.exceptions.SubscribeException;
import com.third.facade.customer.CustomerFacade;
import com.third.facade.customer.WeixinFacade;
import com.third.facade.data.CustomerData;
import com.third.model.CoreConstants;
import com.third.service.customer.WeixinService;
import com.third.service.user.SessionService;
import com.third.web.utils.SmsVerifyCodeUtils;


@Controller
@RequestMapping("/wx/member")
public class WeixinMemberController extends AbstractWeixinController
{
	private static final Logger LOG = Logger.getLogger(WeixinMemberController.class);
	
	@Resource(name="customerFacade")
	private CustomerFacade customerFacade;
	
	@Resource(name="sessionService")
	private SessionService sessionService;
	
	@Resource(name="weixinFacade")
	private WeixinFacade weixinFacade;
	
	@Resource(name="smsVerifyCodeUtils")
	SmsVerifyCodeUtils smsVerifyCodeUtils;
	
	@RequestMapping(value = "/getRegisterPage")
	public String getRegisterPage(
			final HttpServletRequest request,
			final Model model,
			@RequestParam(value="code",required=true)final String code,
			@RequestParam(value="state",required=false)final String state)
	{
		if(sessionService.contains(CoreConstants.Session.CURRENT_CUSTOMER))
		{
			LOG.debug("有已绑定的顾客,跳转到member页");
			return ControllerConstants.WeiXin.ORDERLISTPAGE;
		}

		//code 必须存在,此处不在进行code 必须输入的判断,直接通过参数进行404控制
		
		String openId = "";
		
	   openId = weixinFacade.getOpenId(code);

	   sessionService.save(WXConstant.WX_OPENID, openId);
	
		return ControllerConstants.WeiXin.REGISTER;
		
	}
	
	@RequestMapping(value = "/registerCustomer")
	public void bindCustomer(
			@RequestParam(value="vcode",required=false) final String vcode,
			@RequestParam(value="cellphone",required=false) final String cellphone,
			@RequestParam(value="name",required=false) final String name,
			final Model model)
	{
		LOG.debug("vcode  is" +vcode);
		LOG.debug("cellphone is"+cellphone);
      
		if(!sessionService.contains(WXConstant.WX_OPENID))
		{
			LOG.fatal("必须通过微信页面进行用户注册");
			return;
		}
		
		if(smsVerifyCodeUtils.verifyVcode(vcode))
		{
				try
				{
					LOG.debug("openId:"+sessionService.get(WXConstant.WX_OPENID));
					customerFacade.registerCustomer((String)sessionService.get(WXConstant.WX_OPENID), cellphone,name);
				}
				catch (SubscribeException e)
				{
					e.printStackTrace();
				}
			
		}
	}
	
	//@RequestMapping(value = "/getStoreDetail")
	public String register(@RequestParam(value ="code",required=true)final String storeCode,final Model model)
	{
		return ControllerConstants.WeiXin.STOREDETAILPAGE;
	}

}
