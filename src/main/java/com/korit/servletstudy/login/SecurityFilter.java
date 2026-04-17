package com.korit.servletstudy.login;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //session에서 꺼내기
        ((HttpServletRequest) request).getSession();


        HttpServletRequest httpReq = (HttpServletRequest) request;


        String uri = httpReq.getRequestURI();
        String projectNameIgnoreUri = uri.substring(uri.indexOf("/", 1));//1번부터 찾아라


        if ( projectNameIgnoreUri.startsWith("/api/auth")) {
            chain.doFilter(request, response);//로그인 여부와상관없이 auth로 시작하면 바로 다음필터로 연결
            return;
        }

        HttpSession session = httpReq.getSession();
        Object authAttribute = session.getAttribute("authentication");
        if(authAttribute == null) {
            ResponseEntity.builder()
                    .status(403)
                    .body("로그인 후 이용가능합니다")
                    .build()
                    .response(response);

            return;// 재귀탈출 다음 필터로 안간다
        }
        chain.doFilter(request, response);return;

//        System.out.println("후처리");
    }



}
