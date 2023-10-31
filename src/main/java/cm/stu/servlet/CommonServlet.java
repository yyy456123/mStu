package cm.stu.servlet;

import cm.stu.bean.Person;
import cm.stu.service.ManageService;
import cm.stu.service.ManageServiceImpl;
import cm.stu.service.StudentService;
import cm.stu.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/common.action")
public class CommonServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        StudentService ss = new StudentServiceImpl();
        Person person = (Person) req.getSession().getAttribute("session_person");
        String userAccount = person.getUserAccount();
        ManageService ms = new ManageServiceImpl();
        if (action.equals("index")) {
            //跳转到首页
            req.setAttribute("mainRight", "blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("goMyDetail")) {
            req.setAttribute("mainRight", "detail.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("upPassword")) {
            //upPassword

            req.getRequestDispatcher("upPassword.jsp").forward(req, resp);
        } else if (action.equals("sureUpPassword")) {
            //common.action?action=sureUpPassword
            String userPassword = req.getParameter("userPassword");
            ms.sureUpPassword(userAccount, userPassword);
            req.setAttribute("tip", "修改成功，请关闭此页面");
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        }
    }
}
