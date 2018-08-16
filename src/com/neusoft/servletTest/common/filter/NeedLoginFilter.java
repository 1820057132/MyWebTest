package com.neusoft.servletTest.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by xhbg on 2018/8/13.
 */
@WebFilter("/needLogin/*")
public class NeedLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        if (req.getSession().getAttribute("loginName") != null) {//判断是否登录map.get()
            //业务逻辑
            chain.doFilter(request, resp);//执行所请求的URI
        } else {
            resp.getWriter().print("<h1>未登录，请登录后再试</h1>");
        }

    }

    @Override
    public void destroy() {

    }
}
