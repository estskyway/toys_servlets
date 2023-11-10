package com.example.toys_servlets.controls;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.toys_servlets.daos.PollDao;

@WebServlet(urlPatterns = "/main_List")
public class Main_List extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String unique_id = request.getParameter("unique_id");

            PollDao userInforsDao = new PollDao();
            ArrayList userInforList = new ArrayList<>();
            userInforList = userInforsDao.selectAll(unique_id);

            request.setAttribute("RESPONDENTS", userInforsDao);
            request.setAttribute("RESPONDENTS_ID", userInforList);

            // getWriter 전에 charset 하기
            response.setContentType("text/html;charset=UTF-8");

            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/polls/main_list.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
