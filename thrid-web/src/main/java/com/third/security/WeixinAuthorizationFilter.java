package com.third.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.filter.GenericFilterBean;

import com.third.core.constants.CoreConstants;
import com.third.core.util.WXConstant;
import com.third.facade.customer.CustomerFacade;
import com.third.facade.customer.WeixinFacade;
import com.third.facade.data.CustomerData;
import com.third.security.exceptions.WeixinAuthenticationException;
import com.third.service.user.SessionService;

public class WeixinAuthorizationFilter extends GenericFilterBean {

	protected static final Logger LOG = Logger
			.getLogger(WeixinAuthorizationFilter.class);
	@Resource(name = "sessionService")
	private SessionService sessionService;

	@Resource(name = "customerFacade")
	private CustomerFacade customerFacade;

	@Resource(name = "weixinFacade")
	private WeixinFacade weixinFacade;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		LOG.debug("in custom filter");
		HttpServletRequest r =(HttpServletRequest) request;
		LOG.debug(r.getRequestURL());
		// session 中有open id ,证明当前页面是通过微信进入
		if (sessionService.contains(WXConstant.WX_OPENID))
		{
			// 该微信已经绑定了有效账户,且已经存在了
			if (sessionService.contains(CoreConstants.Session.CURRENT_CUSTOMER))
			{
				LOG.debug("detect customer master data");
				chain.doFilter(request, response);
			} else
			{
				// 如registerCustomer应该是这种情形,但是为了暂时保持逻辑的简单,不通过此filter实现
				LOG.debug("not exist customer suitation");
				throw new WeixinAuthenticationException(
						WXConstant.WX_ERR_NOT_BIND_CUST);
			}
		} else
		{
			String code = request.getParameter("code");

			// 该URL是在security的管控下,必须通过微信的页面来访问的
			if (StringUtils.isEmpty(code))
			{
				LOG.debug("must access via wechat client");
				throw new WeixinAuthenticationException(
						WXConstant.WX_ERR_MUST_FROM_WX);
			} else
			// 通过微信菜单初次进入此session
			{
				LOG.debug("init session context");
				final String openId = weixinFacade.getOpenId(code);
				sessionService.save(WXConstant.WX_OPENID, openId);
				LOG.debug("openID = "+sessionService.get(WXConstant.WX_OPENID));
				CustomerData customer = customerFacade.loginCustomer(openId);

				if (customer == null)
				{
					LOG.debug(openId + " openid can not find customer master data");
					throw new WeixinAuthenticationException(
							WXConstant.WX_ERR_NOT_BIND_CUST);
				}

				chain.doFilter(request, response);
			}
		}

	}

}
