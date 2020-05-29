package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class UserFilterServlet implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String role = (String) req.getSession().getAttribute("role");
        if(role.equals("admin")){
            chain.doFilter(servletRequest, servletResponse);
        }
        else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/user/");
            dispatcher.forward(servletRequest, servletResponse);
        }
    }
}
