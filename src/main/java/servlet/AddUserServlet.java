package servlet;

import model.User;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/add/"})
public class AddUserServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //добавить юзера
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        User user = new User(name, lastName);
        service.saveUser(user);
        resp.sendRedirect("/");
    }

}