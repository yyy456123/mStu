package cm.stu.dao;

import cm.stu.bean.ApplicationApproval;
import cm.stu.bean.Course;
import cm.stu.bean.Person;

import java.util.List;

public class ApplicationApprovalDaoImpl implements ApplicationApprovalDao {
    public int teacherRole;

    @Override
    public List<Course> getAllCourse() {
        String sql = "select * from course";
        System.out.println(Deal.getAllCourse(sql));
        return Deal.getAllCourse(sql);
    }

    @Override
    public List<Course> getSearchCourse(String matchText) {
        String sql = "select * from course where courseID='" + matchText + "' or courseName like '%" + matchText + "%'";
        return Deal.getAllCourse(sql);
    }

    @Override
    public List<ApplicationApproval> getSearchApplicationApproval(String matchText) {
        String sql = "SELECT " +
                "                    aa.*, c.courseName, p1.userName AS studentName, p2.userName AS instructorName, p3.userName AS supervisorUserName" +
                "                FROM" +
                "                    application_approval AS aa" +
                "                       JOIN course AS c ON aa.course_id = c.courseID" +
                "                      JOIN person AS p1 ON aa.student_id = p1.userAccount" +
                "                        LEFT JOIN person AS p2 ON aa.instructor_id = p2.userAccount" +
                "                       LEFT JOIN person AS p3 ON aa.supervisor_id = p3.userAccount " +
                "where " +
                "course_id='" + matchText + "' or " +
                "c.courseName='%" + matchText + "%' or " +
                "student_id='" + matchText + "' or " +
                "p1.userName='%" + matchText + "%' or " +
                "application_time='%" + matchText + "%' or " +
                "instructor_id='" + matchText + "' or " +
                "p2.userName='%" + matchText + "%' or " +
                "instructor_approval='" + matchText + "' or " +
                "instructor_approval_time='%" + matchText + "%' or " +
                "instructor_approval_comment='%" + matchText + "%' or " +
                "supervisor_id='" + matchText + "' or " +
                "p3.userName='%" + matchText + "%' or " +
                "supervisor_approval='" + matchText + "' or " +
                "supervisor_approval_time='%" + matchText + "%' or " +
                "supervisor_approval_comment like '%" + matchText + "%'";
        return Deal.getAllApplicationApproval(sql);
    }

    @Override
    public List<ApplicationApproval> getAllApplication() {
        String sql = "SELECT\n" +
                "    aa.*, c.courseName, p1.userName AS studentName, p2.userName AS instructorName, p3.userName AS supervisorUserName\n" +
                "FROM\n" +
                "    application_approval AS aa\n" +
                "        JOIN course AS c ON aa.course_id = c.courseID\n" +
                "        JOIN person AS p1 ON aa.student_id = p1.userAccount\n" +
                "        LEFT JOIN person AS p2 ON aa.instructor_id = p2.userAccount\n" +
                "        LEFT JOIN person AS p3 ON aa.supervisor_id = p3.userAccount\n";
//        String sql = "select * from application_approval";
        return Deal.getAllApplicationApproval(sql);
    }

    @Override
    public List<ApplicationApproval> getMyApplication(String userAccount) {
//        String sql = "SELECT * FROM application_approval WHERE student_id = '"+userAccount+"'";
        String sql = "SELECT\n" +
                "    aa.*, c.courseName, p1.userName AS studentName, p2.userName AS instructorName, p3.userName AS supervisorUserName\n" +
                "FROM\n" +
                "    application_approval AS aa\n" +
                "        JOIN course AS c ON aa.course_id = c.courseID\n" +
                "        JOIN person AS p1 ON aa.student_id = p1.userAccount\n" +
                "        LEFT JOIN person AS p2 ON aa.instructor_id = p2.userAccount\n" +
                "        LEFT JOIN person AS p3 ON aa.supervisor_id = p3.userAccount\n" +
                "WHERE student_id ='" + userAccount + "'";  // 对单引号进行转义
        List<ApplicationApproval> result = Deal.getAllApplicationApproval(sql);
        System.out.println(result);
        return result;
    }

    @Override
    public List<ApplicationApproval> getMyApproval(String userAccount) {
        String sql = "SELECT aa.*, c.courseName, p1.userName AS studentName, p2.userName AS instructorName, p3.userName AS supervisorUserName FROM " +
                "application_approval AS aa" +
                "JOIN course AS c ON aa.course_id = c.courseID" +
                "JOIN person AS p1 ON aa.student_id = p1.userAccount" +
                "JOIN person AS p2 ON aa.instructor_id = p2.userAccount" +
                "JOIN person AS p3 ON aa.supervisor_id = p3.userAccount " +
                "WHERE instructor_id = '" + userAccount + "' or supervisor_id = '" + userAccount + "'";
        return Deal.getAllApplicationApproval(sql);
    }

    @Override
    public void applicationCourse(String userAccount, int courseID, String applicationReason) {
        String sql = "INSERT INTO application_approval (student_id, course_id, application_time, application_reason, all_is_finished) VALUES ('" + userAccount + "', '" + courseID + "', NOW(), '" + applicationReason + "',false)";
        Deal.deal(sql);
    }

    @Override
    public void cancelApplication(String userAccount, int courseID) {
        String sql = "DELETE FROM `application_approval` WHERE `userAccount`='" + userAccount + "' AND `courseID`='" + courseID + "'";
        Deal.deal(sql);
    }

    @Override
    public int getTeacherRole(String teaAccount) {
        String sql = "select role from teacher_role where teacher_ID = '" + teaAccount + "'";
        teacherRole = Deal.getTeacherRole(sql);
        return teacherRole;
    }

    @Override
    public void agreeApplication(String userAccount, int courseID, String teaAccount, String approvalComment) {

        String sql = "select role from teacher_role where teacher_ID = '" + teaAccount + "'";
        Person person = new Person();
        if (Deal.getTeacherRole(sql) == 1) {

            sql = "UPDATE application_approval SET instructor_approval = true, instructor_is_finish = 1, instructor_approval_time = NOW(), instructor_approval_comment = '" + approvalComment + "', instructor_id = '" + teaAccount + "' WHERE student_id = '" + userAccount + "' AND course_id = '" + courseID + "'";
            Deal.deal(sql);
        } else if (Deal.getTeacherRole(sql) == 2) {

            sql = "UPDATE application_approval SET supervisor_approval = true, supervisor_is_finish = 1, supervisor_approval_time = NOW(), supervisor_approval_comment = '" + approvalComment + "', supervisor_id = '" + teaAccount + "' WHERE student_id = '" + userAccount + "' AND course_id = '" + courseID + "'";
            Deal.deal(sql);
        }

    }

    @Override
    public void rejectApplication(String userAccount, int courseID, String teaAccount, String approvalComment) {
        String sql = "select role from teacher_role where teacher_ID = '" + teaAccount + "'";
        Person person = new Person();
        if (Deal.getTeacherRole(sql) == 1) {

            sql = "UPDATE application_approval SET instructor_approval = false, instructor_is_finish = 1, instructor_approval_time = NOW(), instructor_approval_comment = '" + approvalComment + "', instructor_id = '" + teaAccount + "' WHERE student_id = '" + userAccount + "' AND course_id = '" + courseID + "'";
            Deal.deal(sql);
        } else if (Deal.getTeacherRole(sql) == 2) {

            sql = "UPDATE application_approval SET supervisor_approval = false, supervisor_is_finish = 1, supervisor_approval_time = NOW(), supervisor_approval_comment = '" + approvalComment + "', supervisor_id = '" + teaAccount + "' WHERE student_id = '" + userAccount + "' AND course_id = '" + courseID + "'";
            Deal.deal(sql);
        }
    }

    @Override
    public void confirmApproval(String userAccount, int courseID) {
        String sql = "update application_approval set all_is_finished=true where student_id='" + userAccount + "' and course_id='" + courseID + "'";
        Deal.deal(sql);
    }
}
