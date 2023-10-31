package cm.stu.service;

import cm.stu.bean.Course;
import cm.stu.bean.Person;

import java.util.List;

public interface ManageService {
    List<Person> getAllPerson();

    List<Course> getAllCourse();

    List<Person> getStudentSearch(String matchText);

    List<Course> getCourseSearch(String matchText);

    void addPerson(Person newPerson);

    void addCourse(Course newCourse);

    void sureUpPassword(String userAccount, String userPassword);

    void delThisPerson(String delAccount, String userIdentify);

    void delThisCourse(String delCourseID);
}
