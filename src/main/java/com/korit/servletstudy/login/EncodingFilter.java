package com.korit.servletstudy.login;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {//url로 들어오면 무조건 tofilter가 실행된다
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }//이름을가지고 필터를 정리한다
}
