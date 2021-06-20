package pl.coderslab.servlets;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.entity.User;
import pl.coderslab.utils.DaoMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/read")
public class UserRead extends HttpServlet {
Integer idInt;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id");
       String name = req.getParameter("name");
       String email = req.getParameter("email");
       idInt = Integer.parseInt(id);

        req.setAttribute("id",idInt);
        req.setAttribute("name",name);
        req.setAttribute("email",email);
       getServletContext().getRequestDispatcher("/jsp/jspRead.jsp").forward(req,resp);



    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoMethods daoMethods = new DaoMethods();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String hashPassword = BCrypt.hashpw(password,BCrypt.gensalt());


        User user = daoMethods.read(idInt);
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(hashPassword);
        daoMethods.update(user);

        resp.sendRedirect("/user/list");

    }


}
