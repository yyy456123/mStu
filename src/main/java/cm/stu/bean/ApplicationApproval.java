package cm.stu.bean;

import java.time.LocalDateTime;

public class ApplicationApproval {
    private int aaid;
    private int courseId;
    private String courseName;
    private String studentId;
    private String studentName;
    private LocalDateTime applicationTime;
    private String applicationReason;
    private String instructorId;
    private String instructorName;
    private boolean instructorApproval;
    private int instructorIsFinish;
    private LocalDateTime instructorApprovalTime;
    private String instructorApprovalComment;
    private String supervisorId;
    private String supervisorName;
    private boolean supervisorApproval;
    private int supervisorIsFinish;
    private LocalDateTime supervisorApprovalTime;
    private String supervisorApprovalComment;
    private boolean allIsFinish;

    public ApplicationApproval() {
    }

    public boolean isAllIsFinish() {
        return allIsFinish;
    }

    public void setAllIsFinish(boolean allIsFinish) {
        this.allIsFinish = allIsFinish;
    }

    public int getAaid() {
        return aaid;
    }

    public void setAaid(int aaid) {
        this.aaid = aaid;
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDateTime getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(LocalDateTime applicationTime) {
        this.applicationTime = applicationTime;
        System.out.println(applicationTime);
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public boolean isInstructorApproval() {
        return instructorApproval;
    }

    public void setInstructorApproval(boolean instructorApproval) {
        this.instructorApproval = instructorApproval;
    }

    public LocalDateTime getInstructorApprovalTime() {
        return instructorApprovalTime;
    }

    public void setInstructorApprovalTime(LocalDateTime instructorApprovalTime) {
        this.instructorApprovalTime = instructorApprovalTime;
    }

    public String getInstructorApprovalComment() {
        return instructorApprovalComment;
    }

    public void setInstructorApprovalComment(String instructorApprovalComment) {
        this.instructorApprovalComment = instructorApprovalComment;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public boolean isSupervisorApproval() {
        return supervisorApproval;
    }

    public void setSupervisorApproval(boolean supervisorApproval) {
        this.supervisorApproval = supervisorApproval;
    }

    public LocalDateTime getSupervisorApprovalTime() {
        return supervisorApprovalTime;
    }

    public void setSupervisorApprovalTime(LocalDateTime supervisorApprovalTime) {
        this.supervisorApprovalTime = supervisorApprovalTime;
    }

    public String getSupervisorApprovalComment() {
        return supervisorApprovalComment;
    }

    public void setSupervisorApprovalComment(String supervisorApprovalComment) {
        this.supervisorApprovalComment = supervisorApprovalComment;
    }

    public int getInstructorIsFinish() {
        return instructorIsFinish;
    }

    public void setInstructorIsFinish(int instructorIsFinish) {
        this.instructorIsFinish = instructorIsFinish;
    }

    public int getSupervisorIsFinish() {
        return supervisorIsFinish;
    }

    public void setSupervisorIsFinish(int supervisorIsFinish) {
        this.supervisorIsFinish = supervisorIsFinish;
    }


}
// Getter and setter methods for all attributes





