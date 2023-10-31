package cm.stu.dao;

import cm.stu.bean.*;
import cm.stu.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Deal {


    public static List<Person> getAllPerson(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Person> list = new ArrayList<>();
        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Person newPerson = new Person();
                //`userAccount``userName``usersex``userBirthday``userIdCard``userPassword``userIdentify``userOtherName`
                newPerson.setUserAccount(res.getString("userAccount"));
                newPerson.setUserName(res.getString("userName"));
                newPerson.setUserSex(res.getString("userSex"));
                newPerson.setUserBirthday(res.getString("userBirthday"));
                newPerson.setUserIdCard(res.getString("userIdCard"));
                newPerson.setUserPassword(res.getString("userPassword"));
                newPerson.setUserIdentify(res.getInt("userIdentify"));
                newPerson.setUserOtherName(res.getString("userOtherName"));
                list.add(newPerson);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<Course> getAllCourse(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Course> list = new ArrayList<>();
        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Course newCourse = new Course();
                newCourse.setCourseID(res.getInt("courseID"));
                newCourse.setCourseName(res.getString("courseName"));
                newCourse.setCourseDescription(res.getString("courseDescription"));
                newCourse.setApplyCondition(res.getString("applyCondition"));
                list.add(newCourse);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<ApplicationApproval> getAllApplicationApproval(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<ApplicationApproval> list = new ArrayList<>();
        try {
            assert connection != null;
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                ApplicationApproval newApplicationApproval = new ApplicationApproval();
                newApplicationApproval.setCourseId(res.getInt("course_id"));
                newApplicationApproval.setCourseName(res.getString("courseName"));
                newApplicationApproval.setStudentId(res.getString("student_id"));
                newApplicationApproval.setStudentName(res.getString("studentName"));
                java.sql.Timestamp timestamp = res.getTimestamp("application_time");
                System.out.println(timestamp + "申请时间");
                LocalDateTime dateTime = timestamp.toLocalDateTime();
                newApplicationApproval.setApplicationTime(dateTime);
                newApplicationApproval.setApplicationReason(res.getString("application_reason"));
                newApplicationApproval.setInstructorId(res.getString("instructor_id"));
                newApplicationApproval.setInstructorName(res.getString("instructorName"));
                newApplicationApproval.setInstructorApproval(res.getBoolean("instructor_approval"));
                newApplicationApproval.setInstructorIsFinish(res.getInt("instructor_is_finish"));
                timestamp = res.getTimestamp("instructor_approval_time");
                System.out.println(res.getTime("application_time"));
                System.out.println(res.getTimestamp("application_time"));
                System.out.println(timestamp + "审批时间");
                if (timestamp == null) {
                    newApplicationApproval.setInstructorApprovalTime(null);
                    System.out.println("kong" + newApplicationApproval.getInstructorApprovalTime());
                } else {
                    dateTime = timestamp.toLocalDateTime();
                    newApplicationApproval.setInstructorApprovalTime(dateTime);
                }
                System.out.println(newApplicationApproval.getInstructorApprovalTime() + "time");
                newApplicationApproval.setInstructorApprovalComment(res.getString("instructor_approval_comment"));
                newApplicationApproval.setSupervisorId(res.getString("supervisor_id"));
                newApplicationApproval.setSupervisorName(res.getString("supervisorUserName"));
                newApplicationApproval.setSupervisorApproval(res.getBoolean("supervisor_approval"));
                newApplicationApproval.setSupervisorIsFinish(res.getInt("supervisor_is_finish"));
                timestamp = res.getTimestamp("supervisor_approval_time");
                if (timestamp == null) {
                    newApplicationApproval.setSupervisorApprovalTime(null);
                } else {
                    dateTime = timestamp.toLocalDateTime();
                    newApplicationApproval.setSupervisorApprovalTime(dateTime);
                }
                newApplicationApproval.setSupervisorApprovalComment(res.getString("supervisor_approval_comment"));
                newApplicationApproval.setAllIsFinish(res.getBoolean("all_is_finished"));
                list.add(newApplicationApproval);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<Task> getAllMyTask(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Task> list = new ArrayList<>();
        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                Task task = new Task();
                //`taskAccount``teacherAccount``taskDate``taskName`
                task.setTaskAccount(res.getString("taskAccount"));
                task.setTaskDate(res.getString("taskDate"));
                task.setTaskName(res.getString("taskName"));
                task.setTeacherAccount(res.getString("teacherAccount"));
                list.add(task);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static int getTeacherRole(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        Person teacher = new Person();
        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            if (res.next()) {
                teacher.setTeacherRole(res.getInt("role"));
            } else {
                // 处理没有结果的情况
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (pre != null) pre.close();
                if (res != null) res.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        int teacherRole = teacher.getTeacherRole();
        return teacherRole;
    }

    public static List<StudentAnswer> getTaskDetail(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<StudentAnswer> list = new ArrayList<>();
        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                StudentAnswer sa = new StudentAnswer();
                ////`taskAccount``studentAccount``studentAnswer``isFinish``isScore``userName``taskName`
                sa.setTaskAccount(res.getString("taskAccount"));
                sa.setStudentAccount(res.getString("studentAccount"));
                sa.setStudentAnswer(res.getString("studentAnswer"));
                sa.setIsFinish(res.getInt("isFinish"));
                sa.setIsScore(res.getInt("isScore"));
                sa.setUserName(res.getString("userName"));
                sa.setTaskName(res.getString("taskName"));
                list.add(sa);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static int isExist(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        int num = 0;
        try {
            pre = connection.prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next()) {
                num = res.getInt("num");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    public static void deal(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            pre = connection.prepareStatement(sql);
            pre.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
