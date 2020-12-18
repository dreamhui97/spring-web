package com.bjpowernode.serverlet;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String id = req.getParameter("id");

        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

        System.out.println(ac);
        Service service = (Service) ac.getBean("myStudentService");
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        service.insertStudent(student);
        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }
}
