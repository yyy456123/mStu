<%--
  /**
   *Created by IntelliJ IDEA.
   * @author 27
   * @date 2023/5/22
   * @time 9:12
   */

--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>555</title>
    <style>
        /*table{*/
        /*    width: 1300px;*/
        /*}*/
        /*tr,td{*/
        /*    border: grey 1px ;*/
        /*}*/
        /*td{*/
        /*    height: 40px;*/
        /*}*/

        /*table td{*/
        /*    height: 60px;*/
        /*    vertical-align: middle!important;  !*设置文字垂直居中*!*/
        /*    text-align: center;*/
        /*}*/

        /*tr,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}*/

        /*th{font-weight:bold;background:#ccc;}*/

        /*.con-b .row .lf{*/
        /*    width: 15%;*/
        /*    text-align: center;*/
        /*    padding: 10px;*/
        /*}*/

        /*.con-b tr:nth-of-type(odd){*/
        /*    background-color: #f2f2f2;*/
        /*}*/

        /*#content{*/
        /*    width: 1300px;*/
        /*    height: 70px;*/
        /*    float: right;*/
        /*    !*border: grey 1px solid;*!*/
        /*    margin-right: 40px;*/
        /*    color: grey;*/
        /*    font-size: 50px;*/
        /*}*/

        /*#page {*/
        /*    margin-top: 20px;*/
        /*    text-align: center;*/
        /*}*/

        /*#page a {*/
        /*    padding: 5px 10px;*/
        /*    text-decoration: none;*/
        /*    background-color: #f2f2f2;*/
        /*    border: 1px solid #ddd;*/
        /*    color: #888;*/
        /*}*/

        /*#page a:hover {*/
        /*    background-color: #ddd;*/
        /*}*/

        /*#page {*/
        /*    margin-top: 20px;*/
        /*    text-align: center;*/
        /*}*/

        /*#page a {*/
        /*    padding: 5px 10px;*/
        /*    text-decoration: none;*/
        /*    background-color: #f2f2f2;*/
        /*    border: 1px solid #ddd;*/
        /*    color: #888;*/
        /*}*/

        /*#page a:hover {*/
        /*    background-color: #ddd;*/
        /*}*/
        table {
            border-collapse: collapse;
            margin: 20px auto;
            background-color: #f7f7f7;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            color: #555;
            font-size: 14px;
            width: 100%;
        }

        thead th {
            background-color: #fafafa;
            font-weight: bold;
            text-align: center;
            border-top: none;
            padding: 10px;
            font-size: 16px;
            color: #333;
            text-transform: uppercase;
        }

        tbody td {
            text-align: center;
            padding: 10px;
            border-top: none;
        }

        tbody tr:nth-child(even) {
            background-color: #fff;
        }

        tbody tr:hover {
            background-color: #9acfea;
            transition: background-color 0.5s ease;
        }

        input[type="text"] {
            width: 200px;
            height: 30px;
            padding: 10px;
            border-radius: 3px;
            border: none;
            background-color: #f2f2f2;
            color: #555;
        }

        button {
            background-color: #3498db;
            color: #fff;
            border: none;
            padding: 10px;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<%--<div style=" width:1300px;height:100px;margin-lef:450px;background-color: aliceblue;border: red 1px solid"></div>--%>

<div id="content">
    <%--   searchMyStudent matchText--%>
    <div  style="float: right;height: 70px">

        <c:if test="${session_person.getUserIdentify()==0}">
        <form action="student.action?action=searchCourse"  method="post">
            </c:if>
            <c:if test="${session_person.getUserIdentify()==1}">
            <form action="tea.action?action=searchMyStudent"  method="post">
                </c:if>
                <c:if test="${session_person.getUserIdentify()==2}">
                    <form action="man.action?action=searchAllCourse"  method="post">
                    </c:if>

                <form action="man.action?action=searchAllCourse"  method="post">

                    <input type="text" name="matchText" style="height: 35px;width: 500px;font-size: 28px;color: darkslateblue;border: grey solid 1px;">

                    <input type="submit" style="margin-left: 6px;margin-right: 30px" value="查询">



                </form>
    </div>

</div>
<br><br>
<table border="1" cellspacing="0" align="center" class="con-b">




    <thead>

    <%--    `userAccount``userName``userSex``userBirthday``userIdCard``userIdentify``userOtherName`--%>
    <tr class="row" style="color: black;font-size: 25px" >
        <td class="lf">课程ID</td>
        <td class="lf">课程名称</td>
        <td class="lf">课程描述</td>
        <td class="lf">申请条件</td>

        <c:if test="${session_person.getUserIdentify()!=0}">
            <td>删除</td>
        </c:if>

        <td style="width: 10%">操作</td>
    </tr>
    </thead>
    <tbody>



    <c:forEach items="${arr}" var="course" begin="${startRecord}" end="${endRecord +10000}">

        <tr>
            <td class="lf">${course.getCourseID()}</td>
            <td class="lf">${course.getCourseName()}</td>
            <td class="lf">${course.getCourseDescription()}</td>
            <td class="lf">${course.getApplyCondition()}</td>

            <c:if test="${session_person.getUserIdentify()==1}">
                <td>
                    <img src="addTeacher.png" onclick="approvalCourse('${course.getCourseID()}')">
                </td>

            </c:if>

            <c:if test="${session_person.getUserIdentify()==2}">
                <td>
                    <img src="del.png" onclick="delThisCourse('${course.getCourseID()}')">
                </td>

            </c:if>

            <c:if test="${session_person.getUserIdentify()!=0}">
                <td>
                    <c:if test="${session_person.getUserIdentify()==2}">
                        <img src="up.jpg" onclick="upThisCourse('${course.getCourseID()}')">
                    </c:if>
                </td>
            </c:if>

            <c:if test="${session_person.getUserIdentify()==0}">
                <td><img style="width:40px;height: 40px" onclick="applicationCourse('${course.getCourseID()}')" src="addTeacher.png"></td>
            </c:if>

        </tr>

    </c:forEach>

    </tbody>

</table>



</body>

<script>
    function delThisCourse(courseID) {
        window.location.href = "man.action?action=delThisCourse&courseID="+courseID
    }

    function approvalCourse(courseID) {
        window.location.href = "tea.action?action=applyCourse&courseID="+courseID
    }

    function applicationCourse(courseID) {
        window.location.href = "student.action?action=applicationCourse&courseID="+courseID
        // window.open("student.action?action=applicationCourse&courseID="+courseID, null,"width=700,height=400,left=400,top=150");

    }

    function upThisCourse(courseID) {
        alert("修改:"+courseID)
    }
</script>


</html>

