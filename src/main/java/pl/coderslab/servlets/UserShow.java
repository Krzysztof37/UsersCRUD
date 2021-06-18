package pl.coderslab.servlets;

import pl.coderslab.entity.User;
import pl.coderslab.utils.DaoMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoMethods daoMethods = new DaoMethods();
        String id = req.getParameter("id");
        if(id == null){
            id = "0";
        }

    int idInt = Integer.parseInt(id);
        User user = daoMethods.read(idInt);
        req.setAttribute("user",user);
        getServletContext().getRequestDispatcher("/jsp/jspShow.jsp").forward(req,resp);
    }
}
