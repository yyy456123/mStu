package cm.stu.dao;

import cm.stu.bean.ApplicationApproval;
import cm.stu.bean.Course;

import java.util.List;

public interface ApplicationApprovalDao {
    List<Course> getAllCourse();//

    List<Course> getSearchCourse(String matchText);//

    List<ApplicationApproval> getSearchApplicationApproval(String matchText);

    List<ApplicationApproval> getAllApplication();

    List<ApplicationApproval> getMyApplication(String userAccount);//

    List<ApplicationApproval> getMyApproval(String userAccount);

    void applicationCourse(String userAccount, int courseID, String applicationReason);//

    void cancelApplication(String userAccount, int courseID);//

    int getTeacherRole(String teaAccount);

    void agreeApplication(String userAccount, int courseID, String teaAccount, String approvalComment);

    void rejectApplication(String userAccount, int courseID, String teaAccount, String approvalComment);

    void confirmApproval(String userAccount, int courseID);

}
