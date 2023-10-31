package cm.stu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static cm.stu.util.ConnectionFactory.close;
import static cm.stu.util.ConnectionFactory.getConnection;

public class Generate {
    public static int isExistTaskAccount(String taskAccount) {
        String sql = "select count(*) num from task where taskAccount='" + taskAccount + "'";
        return Deal.isExist(sql);
    }

    public static int IsExistStuTea(String userAccount, String teacherAccount) {
        //`userteacher` `userAccount``teacherAccount`
        String sql = "select count(*) num from userteacher where userAccount='" + userAccount + "' and teacherAccount='" + teacherAccount + "'";
        return Deal.isExist(sql);

    }

    public static int IsExistStuCou(String userAccount, int courseID) {
        String sql = "select count(*) num from application_approval where student_id='" + userAccount + "' and course_id='" + courseID + "'";
        return Deal.isExist(sql);
    }

    public static int isExistPersonAccount(String userAccount) {
        String sql = "select count(*) num from person where userAccount='" + userAccount + "'";
        return Deal.isExist(sql);
    }


    public static int isExistCourseID(int courseID) {
        String sql = "select count(*) num from course where courseID='" + courseID + "'";
        return Deal.isExist(sql);
    }

    public static int getMaxCourseId() {
        int maxId = -1;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String sql = "SELECT MAX(courseid) AS maxid FROM course";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                maxId = rs.getInt("maxid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }

        return maxId;
    }

}
