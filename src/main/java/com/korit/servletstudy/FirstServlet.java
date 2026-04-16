package com.korit.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class FirstServlet extends HttpServlet {//<- 서블릿

//컨트롤러 서비스 레파짓토리
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = "abcd";
        System.out.println(req.getRequestURI());
        System.out.println(req.getParameter("aaa"));
        resp.getWriter().println(userName);
    }
}
