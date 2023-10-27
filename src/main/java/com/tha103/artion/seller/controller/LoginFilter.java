package com.tha103.artion.seller.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(filterName = "LoginFilter", 
urlPatterns = {"/seller/sel_order.jsp",
                  "/seller/sel_orderDetail.jsp",
                  "/seller/sel_profile.jsp",
                  "/seller/sel_profileRevise.jsp",
                  "/sel_signup.jsp",
                  "/activity/sel_actadd.jsp",
                  "/activity/sel_actrevise.jsp",
                  "/activity/sel_index.jsp",
                })
public class LoginFilter implements Filter {

    private FilterConfig config;

    public void init(FilterConfig config) {
        this.config = config;
    }

    public void destroy() {
        config = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
       
        // 检查 "sel_id" 而不是 "account"
        Object selAccount = session.getAttribute("selAccount");

        if (selAccount == null) {
            System.out.println("LoginFilter: Request not allowed. Redirecting to login page.");

            session.setAttribute("location", req.getRequestURI());
            res.sendRedirect(req.getContextPath() + "/seller/sel_login.jsp");	
   
            return;
        } else {
            System.out.println("LoginFilter: Request allowed. Proceeding with the request.");

            chain.doFilter(request, response);
        }
    }
}
