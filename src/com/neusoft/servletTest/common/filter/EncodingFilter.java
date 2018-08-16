package com.neusoft.servletTest.common.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by xhbg on 2018/8/10.
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);//RegisterServlet.doGet/doPost()
    }

    @Override
    public void destroy() {

    }
}
