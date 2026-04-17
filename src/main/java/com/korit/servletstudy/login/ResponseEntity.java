package com.korit.servletstudy.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Data
@Builder
@AllArgsConstructor
public class ResponseEntity<T> {
    private int status;//상태코드
    private T body;

    public void response(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(status);
        httpResponse.setContentType("application/json");//응답도 제이슨으로 하겠다

        httpResponse.getWriter().println(JsonParserUtil.stringify(this));
    }

}
