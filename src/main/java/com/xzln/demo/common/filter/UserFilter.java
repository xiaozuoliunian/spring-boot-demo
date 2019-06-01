package com.xzln.demo.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebFilter(filterName = "userFilter", urlPatterns = "/user/*")
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("------------------------- init ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("------------------------- doFilter ");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("------------------------- destroy ");
    }
}
