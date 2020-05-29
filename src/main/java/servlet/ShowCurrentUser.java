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

@WebServlet(urlPatterns = {"/user/"})
public class ShowCurrentUser extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        User user = Service.getInstance().findUserByLogin(login);
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("userPage.jsp");
        dispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = Service.getInstance().findUserByLogin(req.getParameter("login"));
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("userPage.jsp");
        dispatcher.forward(req, resp);

    }
}