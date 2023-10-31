package cm.stu.dao;

import cm.stu.bean.Course;
import cm.stu.bean.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static cm.stu.util.ConnectionFactory.getConnection;

public class ManageDaoImpl implements ManageDao {
    @Override
    public List<Person> getAllPerson() {
        String sql = "select * from person where userIdentify!=2";
        return Deal.getAllPerson(sql);
    }

    @Override
    public List<Course> getAllCourse() {
        String sql = "select * from course";
        return Deal.getAllCourse(sql);
    }

    @Override
    public List<Person> getStudentSearch(String matchText) {
        String sql = "select * from person where userIdentify!=2 and (userAccount='" + matchText + "' or userName like '%" + matchText + "%' or userIdCard='" + matchText + "')";
        return Deal.getAllPerson(sql);
    }

    @Override
    public List<Course> getCourseSearch(String matchText) {
        String sql = "select * from course where courseID='" + matchText + "' or courseName like '%" + matchText + "%' or approvalStatus='" + matchText + "'";
        return Deal.getAllCourse(sql);
    }

    @Override
    public void addPerson(Person newPerson) {
        String sql = "insert into person values('" + newPerson.getUserAccount() + "','" + newPerson.getUserName() + "','" + newPerson.getUserSex() + "','" + newPerson.getUserBirthday() + "','" + newPerson.getUserIdCard() + "','" + newPerson.getUserPassword() + "'," + newPerson.getUserIdentify() + ",'" + newPerson.getUserOtherName() + "')";
        Deal.deal(sql);
    }

    @Override
    public void addCourse(Course newCourse) {
        String sql = "INSERT INTO course (courseid, coursename, coursedescription, applycondition) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newCourse.getCourseID());
            pstmt.setString(2, newCourse.getCourseName());
            pstmt.setString(3, newCourse.getCourseDescription());
            pstmt.setString(4, newCourse.getApplyCondition());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Deal.deal(sql);
    }

    @Override
    public void sureUpPassword(String userAccount, String userPassword) {
        String sql = "update person set userPassword = '" + userPassword + "' where userAccount='" + userAccount + "'";
        Deal.deal(sql);
    }

    @Override
    public void delThisPerson(String delStudentAccount, String userIdentify) {
        if (Integer.parseInt(userIdentify) == 0) {
            //删除学生
            String sql = "DELETE FROM userteacher WHERE `userAccount` = '" + delStudentAccount + "'";
            Deal.deal(sql);
            sql = "DELETE FROM studenttask WHERE studentAccount = '" + delStudentAccount + "'";
            Deal.deal(sql);
        } else {
            //删除老师
            String sql = "DELETE FROM `studenttask` WHERE taskAccount IN (SELECT taskAccount FROM task WHERE teacherAccount='" + delStudentAccount + "')";
            Deal.deal(sql);
            sql = "DELETE FROM task WHERE teacherAccount = '" + delStudentAccount + "'";
            Deal.deal(sql);
            sql = "DELETE FROM userteacher WHERE teacherAccount = '" + delStudentAccount + "'";
            Deal.deal(sql);
        }
        String sql = "DELETE FROM person WHERE userAccount = '" + delStudentAccount + "'";
        Deal.deal(sql);
    }

    @Override
    public void delThisCourse(String delCourseID) {

        //

        String sql = "DELETE FROM course WHERE courseID = '" + delCourseID + "'";
        Deal.deal(sql);
    }
}
