package servlet;

import model.User;
import service.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {""})
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // выдать список юзеров
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = (req.getParameter("login"));
        String password = (req.getParameter("password"));
        HttpSession session = req.getSession();
        User user = Service.getInstance().findUserByLogin(login);
        if ((user != null) && (user.getPassword().equals(password))) {
            if (user.getRole().equals("admin")) {
                session.setAttribute("login",user.getLogin());
                session.setAttribute("role",user.getRole());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/");
                dispatcher.forward(req, resp);
            } else {
                session.setAttribute("login",user.getLogin());
                session.setAttribute("role",user.getRole());
                RequestDispatcher dispatcher = req.getRequestDispatcher("/user/");
                dispatcher.forward(req, resp);
            }
        } else {
            resp.sendRedirect("/");
        }
    }
}
