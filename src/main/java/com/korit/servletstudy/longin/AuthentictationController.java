package com.korit.servletstudy.longin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PrivateKey;
import java.util.*;

@WebServlet("/api/auth/singin")
public class AuthentictationController extends HttpServlet {//controller ==servlet
    private User loginUser = User.builder()
            .id(1).
            userName("abcd").
            password("1234").
            name("권민주").
            build();

    @Override//login은 post
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String json = JsonParserUtil.getJson(req);
        Map<String, Object> requestBody = JsonParserUtil.parde(json);
        System.out.println(requestBody);

        if(!loginUser.getUserName().equals(requestBody.get("username"))) {
            errorResponse(resp , "사용자정보가 일치하지 않습니다.");
        }


    }
    private void errorResponse (HttpServletResponse resp, String message) throws IOException{
        resp.setStatus(403);
        resp.setContentType("application/json");//응답도 제이슨으로 하겠다
        Map<String, Object> responseMap = Map.of(
                "code", 404,
                "message", message);
        resp.getWriter().println(JsonParserUtil.strinfy(responseMap));

    }
}
