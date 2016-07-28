package com.app.filter.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.partner.domain.Partner;
import com.app.user.domain.User;

@Component
public class SecurityFilter implements Filter {

	@Autowired
	private SecurityService securityService;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		User user = (User) ((HttpServletRequest) request).getSession().getAttribute("currentUser");

//		Partner partner = (Partner) ((HttpServletRequest) request).getSession().getAttribute("currentPartner");

		System.out.println("Thread name: " + Thread.currentThread().getName() + ", current user: "
				+ (user != null ? user.getUserEmail() : null));

//		System.out.println("Thread name: " + Thread.currentThread().getName() + ", current partner: "
//				+ (partner != null ? partner.getPartnerEmail() : null));

		securityService.setCurrentUser(user);
//		securityService.setCurrentPartner(partner);

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
