package com.korit.servletstudy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Req {
    private String requstUrl;
}
class Resp {

}

class TestServlet {
    private static TestServlet instance;
    private TestServlet() {}
    public static TestServlet getInstance() {
        if (instance == null ) return new TestServlet();
        return instance;
    }

    public void init() {
        System.out.println("초기화");
    }
    public void service(Req req, Resp resp) {
        System.out.println(req.getRequstUrl());
    }
    public void destroy() {
        System.out.println("소멸");
    }
}


public class TomcatMain {
    public static void main(String[] args) {
        String requstUrl = "http://localhost:8080/backServer/test";
        TestServlet testServlet = TestServlet.getInstance();//static은 어디서나 존재가능하다 -> private static TestServlet getInstance; 바로 사용
        testServlet.init();
        testServlet.service(new Req(requstUrl), new Resp());
        testServlet.service(new Req(requstUrl), new Resp());
        testServlet.service(new Req(requstUrl), new Resp());
        testServlet.service(new Req(requstUrl), new Resp());
        testServlet.destroy();
    }

}
