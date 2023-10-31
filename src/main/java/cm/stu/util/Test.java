package cm.stu.util;

import cm.stu.dao.Deal;
import cm.stu.dao.Generate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {


    public static void main(String[] args) {
        Deal.deal("INSERT INTO task VALUES('11','11','11','11')");

    }

    public static String getDate() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdt.format(date);
    }

    public static String getTaskAccount() {
        String taskAccount = "";
        while (true) {
            for (int i = 0; i < 8; i++) {
                taskAccount = taskAccount + (int) (1 + Math.random() * (10 - 1 + 1));
            }
            int num = Generate.isExistTaskAccount(taskAccount);
            if (num == 0) {
                break;
            } else {
                taskAccount = "";
            }
        }
        return taskAccount;
    }

    public static String getPersonAccount() {
        String userAccount = "";
        while (true) {
            for (int i = 0; i < 8; i++) {
                userAccount = userAccount + (int) (1 + Math.random() * (10 - 1 + 1));
            }
            int num = Generate.isExistPersonAccount(userAccount);
            if (num == 0) {
                break;
            } else {
                userAccount = "";
            }
        }
        return userAccount;
    }

    public static int getCourseID() {
        int courseID = 0;
        int maxId = Generate.getMaxCourseId(); // 获取当前已生成的最大课程ID
        if (maxId == -1) { // 表示还没有生成过课程ID
            courseID = 1;
        } else {
            maxId++; // 最大课程ID加1
            courseID = maxId;
        }
        while (Generate.isExistCourseID(Integer.parseInt(String.format("%06d", courseID))) > 0) { // 如果课程ID已存在，则继续递增生成新课程ID
            maxId++;
            courseID = maxId;
        }
        return courseID;
    }


}
