package servlet;

import dao.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author dailiwen
 * @date 2018/05/29
 */
public class LoginServlet extends HttpServlet {
    private AccountDao accountDao = AccountDao.getAccountDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            if (accountDao.login(userName, password)) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", userName);
                resp.sendRedirect("../ListServlet");
            } else {
                resp.sendRedirect("../login.jsp");
            }
        } catch (Exception e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
    }
}
