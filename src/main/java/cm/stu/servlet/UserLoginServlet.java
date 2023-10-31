package cm.stu.servlet;

import cm.stu.bean.Person;
import cm.stu.service.UserLoginService;
import cm.stu.service.UserLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //首先去拿到前端传过来的信息
        String userAccount = req.getParameter("userAccount");
        String userPassword = req.getParameter("userPassword");
        Person person = new Person(userAccount, userPassword);
        System.out.println(person);
        UserLoginService ul = new UserLoginServiceImpl();
        Person newPerson = ul.getLogin(person);
        System.out.println(newPerson);
        if (newPerson != null) {
//            req.getSession().setAttribute("session-person",newPerson);
            HttpSession session = req.getSession();
            session.setAttribute("session_person", newPerson);


            req.setAttribute("mainRight", "blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else {
            //继续回到登陆注册界面
            req.setAttribute("tip", "账户密码不一致");
            req.getRequestDispatcher("userLogin.jsp").forward(req, resp);
        }


    }
}
