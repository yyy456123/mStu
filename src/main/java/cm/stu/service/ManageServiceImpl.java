package cm.stu.service;

import cm.stu.bean.Course;
import cm.stu.bean.Person;
import cm.stu.dao.ManageDao;
import cm.stu.dao.ManageDaoImpl;

import java.util.List;

public class ManageServiceImpl implements ManageService {
    ManageDao md = new ManageDaoImpl();

    @Override
    public List<Person> getAllPerson() {
        return md.getAllPerson();
    }

    @Override
    public List<Course> getAllCourse() {
        return md.getAllCourse();
    }

    @Override
    public List<Person> getStudentSearch(String matchText) {
        return md.getStudentSearch(matchText);
    }

    @Override
    public List<Course> getCourseSearch(String matchText) {
        return md.getCourseSearch(matchText);
    }

    @Override
    public void addPerson(Person newPerson) {
        md.addPerson(newPerson);
    }

    @Override
    public void addCourse(Course newCourse) {
        md.addCourse(newCourse);
    }

    @Override
    public void sureUpPassword(String userAccount, String userPassword) {
        md.sureUpPassword(userAccount, userPassword);
    }

    @Override
    public void delThisPerson(String delAccount, String userIdentify) {
        md.delThisPerson(delAccount, userIdentify);
    }

    @Override
    public void delThisCourse(String delCourseID) {
        md.delThisCourse(delCourseID);
    }
}
