package com.korit.servletstudy.login;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet("/api/auth/singin")//mapping대신해줌
public class AuthentictationController extends HttpServlet {//controller ==servlet
    private User loginUser = User.builder()
            .id(1).
            userName("abcd").
            password("1234").
            email("abc@gmail.com").
            build();

    @Override//login은 post
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String json = JsonParserUtil.getJson(req);
        Map<String, Object> requestBody = JsonParserUtil.parse(json);
        System.out.println(requestBody);

        if(!loginUser.getUserName().equals(requestBody.get("username"))) {
            ResponseEntity.builder().status(403).body("사용자정보가 일치하지 않습니다").build().response(resp);
            return;
        }

        if(!loginUser.getPassword().equals(requestBody.get("password"))) {
            ResponseEntity.builder().status(403).body("사용자정보가 일치하지 않습니다").build().response(resp);
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("authentication", loginUser);//키벨류값으로 저장
        ResponseEntity
                .builder()
                .status(200)
                .body("로그인 완료")
                .build()
                .response(resp);

    }


}
