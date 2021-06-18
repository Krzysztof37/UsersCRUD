package pl.coderslab.servlets;

import pl.coderslab.utils.DaoMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoMethods daoMethods = new DaoMethods();
        String id = req.getParameter("id");
        int idInt = Integer.parseInt(id);
        daoMethods.delete(idInt);
        resp.sendRedirect("/user/list");
    }
}
