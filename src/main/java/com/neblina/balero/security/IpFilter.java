package com.neblina.balero.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class IpFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(IpFilter.class);

    /**
     * @author Anibal Gomez <anibalgomez@icloud.com>
     * References: spring.io/guides/gs/rest-service-cors/
     * @param req
     * @param res
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        log.debug("Loading Filter...");
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        //response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        //response.setHeader("Access-Control-Max-Age", "3600");
        //response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        log.debug(request.getRemoteAddr());
        if(request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {
            log.debug("You are banned.");
            response.setContentType("text/html");
            response.getWriter().println("You Has Been Banned For 15 Minutes.");
            return;
        }
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}