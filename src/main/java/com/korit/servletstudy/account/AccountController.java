package com.korit.servletstudy.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;

@WebServlet("/api/accounts")
public class AccountController extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("delete요청 들어옴");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("put요청 들어옴");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청 들어옴");
        String p1 =req.getParameter("age");
        String p2 =req.getParameter("address");
        String p3 =req.getParameter("year");
        String[] p4 =req.getParameterValues("ages");

        Map<String, String[]> p5 = req.getParameterMap();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(Arrays.toString(p4));
        System.out.println(p5.entrySet());
        System.out.println(p5.entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), Arrays.asList(entry.getValue()))).toList()
        );
        System.out.println(p5.keySet());
        String[] p5Values = p5.get("year");//파라미터는 무조건 여러개가 들어온다 가정해서 배열로 반환시킨다
        String p5Vlaues = p5.get("year")[0];

        req.setAttribute("name", "권민주");//정의한적 없는 key와 value
        req.getRequestDispatcher("/account.jsp")//연결해줘라
                .forward(req, resp);//각 객체를 전달해줘라 -> jsp쪽으로 넘어감

        String hostHeader = req.getHeader("Host");//설정값들이 들어가있음
        System.out.println(hostHeader);//localhost:8080


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("요청들어옴!!!!!!!");
        BufferedReader bufferedReader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
           stringBuilder.append(line);
        }
        System.out.println(stringBuilder);
    }
}
