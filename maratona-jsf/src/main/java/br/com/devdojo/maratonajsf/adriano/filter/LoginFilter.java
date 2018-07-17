package br.com.devdojo.maratonajsf.adriano.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.devdojo.maratonajsf.adriano.bean.login.LoginBean;

public class LoginFilter implements Filter {

	@Inject
	private LoginBean loginBean;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String url = request.getRequestURL().toString();
		System.out.println(url);
		if(url.contains("/restricted") && loginBean.getEstudante() == null) {
			response.sendRedirect(request.getServletContext().getContextPath()+"/login.xhtml");
		}else {
			filterChain.doFilter(servletRequest, servletResponse);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
