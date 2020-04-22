package org.hc.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "ChinaFilter",urlPatterns = "/*",initParams = {@WebInitParam(name="encoding",value="utf-8")})
public class ChinaFilter implements Filter {
    public ChinaFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest  request = (HttpServletRequest) req;
        HttpServletResponse  response = (HttpServletResponse) resp;
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }

    String  encoding ="";
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
    }

}
