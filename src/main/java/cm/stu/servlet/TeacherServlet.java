package cm.stu.servlet;

import cm.stu.bean.ApplicationApproval;
import cm.stu.bean.Person;
import cm.stu.bean.StudentAnswer;
import cm.stu.bean.Task;
import cm.stu.dao.ApplicationApprovalDaoImpl;
import cm.stu.service.ApplicationApprovalService;
import cm.stu.service.ApplicationApprovalServiceImpl;
import cm.stu.service.TeacherService;
import cm.stu.service.TeacherServiceImpl;
import cm.stu.util.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tea.action")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        TeacherService ts = new TeacherServiceImpl();
        ApplicationApprovalService as = new ApplicationApprovalServiceImpl();
        Person person = (Person) req.getSession().getAttribute("session_person");
        String userAccount = person.getUserAccount();
        int teacherRole = new ApplicationApprovalDaoImpl().teacherRole;
        System.out.println("++++++++++==========" + teacherRole);
        //<li id="file"><a href="tea.action?action=list">学生管理</a></li>
        if (action.equals("list") || action.equals("searchMyStudent") || action.equals("deleteThisPersonByTeacher")) {
            //"tea.action?action=deleteThisPersonByTeacher&studentAccount"+studentAccount
            List arr = null;
            //searchMyStudent matchText-
            if (action.equals("searchMyStudent")) {
                String matchText = req.getParameter("matchText");
                arr = ts.getSearchStudentByTeacherAccount(userAccount, matchText);
            } else {
                if (action.equals("deleteThisPersonByTeacher")) {
                    String studentAccount = req.getParameter("studentAccount");
                    ts.deleteThisPersonByTeacher(studentAccount, userAccount);
                }
                arr = ts.AllStudentsByTeacherAccount(userAccount);
            }

            //获取所有学生的信息

            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "person.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("aalist") || action.equals("searchApplicationApproval") || action.equals("doTComment") || action.equals("dealTComment") || action.equals("doFComment") || action.equals("dealFComment") || action.equals("getRole")) {
            //"tea.action?action=deleteThisPersonByTeacher&studentAccount"+studentAccount
            List arr = null;
            //searchMyStudent matchText-
            if (action.equals("searchApplicationApproval")) {
                String matchText = req.getParameter("matchText");
                arr = as.getSearchApplicationApproval(matchText);
                System.out.println('9');
            } else if (action.equals("getRole")) {
                String teaAccount = req.getParameter("teaAccount");
                int role = as.getTeacherRole(teaAccount);
                System.out.println("=================" + role);
                req.setAttribute("role", role);
            } else if (action.equals("doTComment")) {
                String studentAccount = req.getParameter("studentAccount");
                String courseID = req.getParameter("courseID");
                String teaAccount = req.getParameter("teaAccount");

                req.setAttribute("studentAccount", studentAccount);
                req.setAttribute("courseID", courseID);
                req.setAttribute("teaAccount", teaAccount);
                req.getRequestDispatcher("doTComment.jsp").forward(req, resp);
            } else if (action.equals("dealTComment")) {
                String studentAccount = req.getParameter("studentAccount");
                String courseID = req.getParameter("courseID");
                String teaAccount = req.getParameter("teaAccount");
                String approvalComment = (req.getParameter("comment")).trim();
                as.agreeApplication(studentAccount, Integer.parseInt(courseID), teaAccount, approvalComment);
                req.setAttribute("tip", "审批成功，请关闭页面！");
                req.getRequestDispatcher("success.jsp").forward(req, resp);
                req.setAttribute("mainRight", "applicationApproval.jsp");
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            } else if (action.equals("doFComment")) {
                String studentAccount = req.getParameter("studentAccount");
                String courseID = req.getParameter("courseID");
                String teaAccount = req.getParameter("teaAccount");
                int role = teacherRole;
                req.setAttribute("studentAccount", studentAccount);
                req.setAttribute("courseID", courseID);
                req.setAttribute("teaAccount", teaAccount);
                req.getRequestDispatcher("doFComment.jsp").forward(req, resp);
            } else if (action.equals("dealFComment")) {
                String studentAccount = req.getParameter("studentAccount");
                String courseID = req.getParameter("courseID");
                String teaAccount = req.getParameter("teaAccount");
                String approvalComment = (req.getParameter("comment")).trim();

                as.rejectApplication(studentAccount, Integer.parseInt(courseID), teaAccount, approvalComment);
                req.setAttribute("tip", "驳回成功，请关闭页面！");
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            }
            arr = as.getAllApplication();
            System.out.println(arr);


            //获取所有申请的信息

            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "applicationApproval.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("goMyTask") || action.equals("deleteTishTask")) {
            //"tea.action?action=deleteTishTask&taskAccount="+taskAccount;
            if (action.equals("deleteTishTask")) {
                String taskAccount = req.getParameter("taskAccount");
                ts.deleteThisTask(taskAccount);
            }

            List<Task> arr = ts.getAllMyTask(userAccount);
            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "task.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("goMyApproval")) {
            List<ApplicationApproval> arr = as.getMyApplication(userAccount);
            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "applicationApproval.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("goSkimDetail") || action.equals("goStudentTaskDetail")) {
            List<StudentAnswer> arr;
            //"tea.action?action=deleteTask&studentAccount=" + studentAccount + "&isFinish=" + isFinish
            if (action.equals("goSkimDetail")) {
                String taskAccount = req.getParameter("taskAccount");
                arr = ts.getTaskDetail(taskAccount);
            } else {
                req.setAttribute("sign", "goStudentTaskDetail");
                String studentAccount = req.getParameter("studentAccount");
                arr = ts.goStudentTaskDetail(userAccount, studentAccount);
            }
            //tea.action?action=goSkimDetail&taskAccount="+taskAccount;

            req.setAttribute("arr", arr);
            req.setAttribute("mainRight", "studentTask.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("deleteTask")) {
            // "&isFinish=" + isFinish
            String studentAccount = req.getParameter("studentAccount");
            String taskAccount = req.getParameter("taskAccount");
            String isFinish = req.getParameter("isFinish");
            ts.deleteTask(taskAccount, studentAccount, isFinish);
            req.setAttribute("tip", "删除成功");
            req.setAttribute("mainRight", "blank.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("goAddTask") || action.equals("addTask")) {
            if (action.equals("addTask")) {
                String taskName = req.getParameter("taskName");
                taskName = taskName.trim();
                if (taskName.equals("")) {
                    req.setAttribute("tip", "添加失败");
                } else {
                    //朝着数据库存入
                    String date = Test.getDate();
                    String taskAccount = Test.getTaskAccount();
                    Task task = new Task(taskAccount, userAccount, date, taskName);
                    ts.AddTask(task);
                    req.setAttribute("tip", "添加成功");
                }
            }

            req.setAttribute("mainRight", "addTask.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else if (action.equals("addPerson")) {
            req.setAttribute("mainRight", "addPerson.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }


    }
}
