package cm.stu.dao;

import cm.stu.bean.Person;
import cm.stu.bean.StudentAnswer;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Person> getAllTeacher() {
        String sql = "select * from person where userIdentify=1";
        return Deal.getAllPerson(sql);
    }

    @Override
    public List<Person> getSearchTeacher(String matchText) {
        String sql = "SELECT * FROM person WHERE userIdentify=1 AND (userAccount='" + matchText + "' OR userName LIKE'%" + matchText + "%' OR userOtherName LIKE'%" + matchText + "%')";
        return Deal.getAllPerson(sql);
    }

    @Override
    public List<Person> getMyTeacher(String userAccount) {
        String sql = "SELECT * FROM person WHERE userAccount IN (SELECT `teacherAccount` AS userAccount FROM userteacher ut WHERE ut.`userAccount`='" + userAccount + "')";
        return Deal.getAllPerson(sql);
    }

    @Override
    public void addTeacher(String userAccount, String teacherAccount) {
        //`userteacher` `userAccount``teacherAccount`
        String sql = "insert into userteacher values('" + userAccount + "','" + teacherAccount + "')";
        Deal.deal(sql);
    }

    @Override
    public List<StudentAnswer> goMyTeaTask(String userAccount, String teacherAccount) {
        String sql = "SELECT s.*,p.`userName`,`taskName` FROM `studenttask` s  INNER JOIN person p ON s.`studentAccount`=p.`userAccount` INNER JOIN task t ON s.`taskAccount`=t.taskAccount WHERE (s.`studentAccount`='" + userAccount + "' AND t.`teacherAccount`='" + teacherAccount + "')";
        return Deal.getTaskDetail(sql);
    }

    @Override
    public void deleteMyTeacher(String userAccount, String teacherAccount) {
        String sql = "DELETE FROM `userteacher` WHERE `userAccount`='" + userAccount + "' AND `teacherAccount`='" + teacherAccount + "'";
        Deal.deal(sql);
        sql = "DELETE FROM `studenttask` WHERE `taskAccount` IN(SELECT `taskAccount` FROM `task` WHERE `teacherAccount`='" + teacherAccount + "') AND studentAccount='" + userAccount + "'";
        Deal.deal(sql);
    }

    @Override
    public void doAnswer(String userAccount, String taskAccount, String answer) {
        String sql = "UPDATE studenttask SET `studentAnswer`='" + answer + "',`isFinish`=1 WHERE `taskAccount`='" + taskAccount + "' AND `studentAccount`='" + userAccount + "'";
        Deal.deal(sql);
    }

    @Override
    public void dealFenshu(String taskAccount, String studentAccount, String fenshu) {
        String sql = "UPDATE studenttask SET `isScore`='" + fenshu + "',`isFinish`=2 WHERE `taskAccount`='" + taskAccount + "' AND `studentAccount`='" + studentAccount + "'";
        Deal.deal(sql);
    }
}
