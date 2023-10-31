package cm.stu.service;

import cm.stu.bean.ApplicationApproval;
import cm.stu.bean.Course;
import cm.stu.dao.ApplicationApprovalDao;
import cm.stu.dao.ApplicationApprovalDaoImpl;

import java.util.List;

public class ApplicationApprovalServiceImpl implements ApplicationApprovalService {

    ApplicationApprovalDao ad = new ApplicationApprovalDaoImpl();

    @Override
    public List<Course> getAllCourse() {
        return ad.getAllCourse();
    }

    @Override
    public List<Course> getSearchCourse(String matchText) {
        return ad.getSearchCourse(matchText);
    }

    @Override
    public List<ApplicationApproval> getSearchApplicationApproval(String matchText) {
        return ad.getSearchApplicationApproval(matchText);
    }

    @Override
    public List<ApplicationApproval> getAllApplication() {
        return ad.getAllApplication();
    }

    @Override
    public List<ApplicationApproval> getMyApplication(String userAccount) {
        return ad.getMyApplication(userAccount);
    }

    @Override
    public List<ApplicationApproval> getMyApproval(String userAccount) {
        return ad.getMyApproval(userAccount);
    }

    @Override
    public void applicationCourse(String userAccount, int courseID, String applicationReason) {
        ad.applicationCourse(userAccount, courseID, applicationReason);
    }

    @Override
    public void cancelApplication(String userAccount, int courseID) {
        ad.cancelApplication(userAccount, courseID);
    }

    @Override
    public int getTeacherRole(String teaAccount) {
        return ad.getTeacherRole(teaAccount);
    }

    @Override
    public void agreeApplication(String userAccount, int courseID, String teaAccount, String approvalComment) {
        ad.agreeApplication(userAccount, courseID, teaAccount, approvalComment);
    }

    @Override
    public void rejectApplication(String userAccount, int courseID, String teaAccount, String approvalComment) {
        ad.rejectApplication(userAccount, courseID, teaAccount, approvalComment);
    }

    @Override
    public void confirmApproval(String userAccount, int courseID) {
        ad.confirmApproval(userAccount, courseID);
    }
}
