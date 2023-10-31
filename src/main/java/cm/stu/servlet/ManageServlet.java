package cm.stu.servlet;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.service.ManageService;
import cm.stu.service.ManageServiceImpl;
import cm.stu.util.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/man.action")
public class ManageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        ManageService ms = new ManageServiceImpl();
        if (action.equals("userList") || action.equals("searchAllUser") || action.equals("delThisPerson")) {
            //man.action?action=delThisPerson&userAccount="+userAccount+"&userIdentify="+userIdentify
            List<Person> arr;
            if (action.equals("userList") || action.equals("delThisPerson")) {
                if (action.equals("delThisPerson")) {
                    String delAccount = req.getParameter("userAccount");
                    String userIdentify = req.getParameter("userIdentify");
                    ms.delThisPerson(delAccount, userIdentify);
                }
                arr = ms.getAllPerson();
            } else {
                String matchText = (req.getParameter("matchText")).trim();
                arr = ms.getStudentSearch(matchText);
            }
            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "person.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("courseList") || action.equals("searchAllCourse") || action.equals("delThisCourse")) {
            List<Course> arr;
            if (action.equals("courseList") || action.equals("delThisCourse")) {
                if (action.equals("delThisCourse")) {
                    String delCourseID = req.getParameter("courseID");
                    ms.delThisCourse(delCourseID);
                }
                arr = ms.getAllCourse();
            } else {
                String matchText = (req.getParameter("matchText")).trim();
                arr = ms.getCourseSearch(matchText);
            }
            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "course.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);

        } else if (action.equals("goAddPerson")) {
            req.setAttribute("mainRight", "addPerson.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("addThisPerson")) {
            String newUserAccount = Test.getPersonAccount();
            String userName = req.getParameter("userName");
            String userSex = req.getParameter("userSex");
            String userBirthday = req.getParameter("userBirthday");
            String userIdCard = req.getParameter("userIdCard");
            String userPassword = req.getParameter("userPassword");
            int userIdentify = Integer.parseInt(req.getParameter("userIdentify"));
            String userOtherName = req.getParameter("userOtherName");
            Person newPerson = new Person(newUserAccount, userName, userSex, userBirthday, userIdCard, userPassword, userIdentify, userOtherName);
            ms.addPerson(newPerson);
            req.setAttribute("tip", "添加完成");
            req.setAttribute("mainRight", "blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);

        } else if (action.equals("goAddCourse")) {
            req.setAttribute("mainRight", "addCourse.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("addThisCourse")) {
            int newCourseID = Test.getCourseID();
            String courseName = req.getParameter("courseName");
            String courseDescription = req.getParameter("courseDescription");
            String applyCondition = req.getParameter("applyCondition");
            Course newCourse = new Course(newCourseID, courseName, courseDescription, applyCondition);
            ms.addCourse(newCourse);
            req.setAttribute("tip", "添加完成");
            req.setAttribute("mainRight", "blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);

        }
    }
}
