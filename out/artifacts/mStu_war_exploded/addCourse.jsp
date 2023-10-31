<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/24
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

</script>
<div class="data_list">
</div>

<form method="post" action="man.action?action=addThisCourse" onsubmit="return checkThis()">

    <div class="data_form">
        <table align="center">


            <tr>
                <td><font color="red">*</font>课程名称：</td>
                <td><input type="text" id="courseName" name="courseName"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>课程描述：</td>
                <td><input type="text" id="courseDescription" name="courseDescription" style="margin-top:5px;height:30px;"/>
                </td>
            </tr>

            <tr>
                <td><font color="red">*</font>申请条件：</td>
                <td><input type="text" id="applyCondition" name="applyCondition" style="margin-top:5px;height:30px;"/>
                </td>
            </tr>



            <script>

                function checkThis() {
                    let courseID = document.getElementById("courseID").value;
                    let courseName = document.getElementById("courseName").value;
                    let courseDescription = document.getElementById("courseDescription").value;
                    let applyCondition = document.getElementById("applyCondition").value;

                    if (courseID.trim() == null || courseID.trim() == "") {
                        document.getElementById("error").innerHTML = "课程ID不能为空";
                        return false;
                    }

                    if (courseName.trim() == null || courseName.trim() == "") {
                        document.getElementById("error").innerHTML = "课程名称不能为空";
                        return false;
                    }

                    return true;


                }


            </script>


        </table>
        <div align="center">
            <input type="submit" class="btn btn-primary" value="保存"/>
            <span style="color: #dd1144" id="error">${tip}</span>
        </div>
    </div>
</form>
</div>

