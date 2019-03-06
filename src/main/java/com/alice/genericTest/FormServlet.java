package com.alice.genericTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FormServlet extends HttpServlet{
    private static final long serialVersionUID = -884689940866074733L;

    @RequestMapping(value = "FormServlet")
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = TokenProccessor.getInstance().makeToken();//创建令牌
        System.out.println("在FormServlet中生成的token："+token);
        request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
        request.getRequestDispatcher("/jsp/welcome.jsp").forward(request, response);//跳转到form.jsp页面
       // response.sendRedirect("/jsp/welcome.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}