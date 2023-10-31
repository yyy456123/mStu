package cm.stu.bean;

public class Course {
    private int courseID;
    private String courseName;
    private String courseDescription;
    private String applyCondition;
//    private int approvalStatus;

    public Course() {
    }

    public Course(int courseID, String courseName, String courseDescription, String applyCondition) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.applyCondition = applyCondition;
//        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", applyCondition='" + applyCondition +
                '}';
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

//    public int getApprovalStatus() {
//        return approvalStatus;
//    }

//    public void setApprovalStatus(int approvalStatus) {
//        this.approvalStatus = approvalStatus;
//    }

    public String getApplyCondition() {
        return applyCondition;
    }

    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition;
    }
// 构造函数、getter和setter方法
}

