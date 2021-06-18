package pl.coderslab.servlets;

import pl.coderslab.entity.User;
import pl.coderslab.utils.DaoMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       getServletContext().getRequestDispatcher("/jsp/jspAdd.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        DaoMethods daoMethods = new DaoMethods();

        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);
        daoMethods.create(user);
        resp.sendRedirect("/user/list");

    }
}
