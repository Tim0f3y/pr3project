package servlet;

import model.User;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/admin/update/"})
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        User user = Service.getInstance().findUser(id);
        user.setName(req.getParameter("name"));
        user.setLastName(req.getParameter("lastName"));
        user.setRole(req.getParameter("role"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        Service.getInstance().updateUser(user);
        resp.sendRedirect("/admin/");
    }

}