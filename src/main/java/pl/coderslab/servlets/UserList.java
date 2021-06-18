package pl.coderslab.servlets;

import pl.coderslab.entity.User;
import pl.coderslab.utils.DaoMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/list")
public class UserList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoMethods daoMethods = new DaoMethods();
        User users[] = daoMethods.findAll();
        req.setAttribute("userList", users);
        getServletContext().getRequestDispatcher("/jsp/jspList.jsp").forward(req,resp);

    }
}
