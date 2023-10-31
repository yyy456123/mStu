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
    <%--    <style>--%>
    <%--        table{--%>
    <%--            width: 1300px;--%>
    <%--        }--%>
    <%--        tr,td{--%>
    <%--            border: grey 1px ;--%>
    <%--        }--%>
    <%--        td{--%>
    <%--            height: 40px;--%>
    <%--        }--%>

    <%--        table td{--%>
    <%--            height: 60px;--%>
    <%--            vertical-align: middle!important;  /*设置文字垂直居中*/--%>
    <%--            text-align: center;--%>
    <%--        }--%>

    <%--        tr,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}--%>

    <%--        th{font-weight:bold;background:#ccc;}--%>

    <%--        .con-b .row .lf{--%>
    <%--            width: 15%;--%>
    <%--            text-align: center;--%>
    <%--            padding: 10px;--%>
    <%--        }--%>

    <%--        .con-b tr:nth-of-type(odd){--%>
    <%--            background-color: #f2f2f2;--%>
    <%--        }--%>

    <%--        #content{--%>
    <%--            width: 1300px;--%>
    <%--            height: 70px;--%>
    <%--            float: right;--%>
    <%--            /*border: grey 1px solid;*/--%>
    <%--            margin-right: 40px;--%>
    <%--            color: grey;--%>
    <%--            font-size: 50px;--%>
    <%--        }--%>

    <%--        #page {--%>
    <%--            margin-top: 20px;--%>
    <%--            text-align: center;--%>
    <%--        }--%>

    <%--        #page a {--%>
    <%--            padding: 5px 10px;--%>
    <%--            text-decoration: none;--%>
    <%--            background-color: #f2f2f2;--%>
    <%--            border: 1px solid #ddd;--%>
    <%--            color: #888;--%>
    <%--        }--%>

    <%--        #page a:hover {--%>
    <%--            background-color: #ddd;--%>
    <%--        }--%>

    <%--        #page {--%>
    <%--            margin-top: 20px;--%>
    <%--            text-align: center;--%>
    <%--        }--%>

    <%--        #page a {--%>
    <%--            padding: 5px 10px;--%>
    <%--            text-decoration: none;--%>
    <%--            background-color: #f2f2f2;--%>
    <%--            border: 1px solid #ddd;--%>
    <%--            color: #888;--%>
    <%--        }--%>

    <%--        #page a:hover {--%>
    <%--            background-color: #ddd;--%>
    <%--        }--%>

    <%--&lt;%&ndash;    </style>&ndash;%&gt;原有css--%>
    <style>
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
    <div style="float: right;height: 70px">

        <c:if test="${session_person.getUserIdentify()==0}">
            <%--        <form action="student.action?action=searchTeacher"  method="post">--%>
        </c:if>
        <c:if test="${session_person.getUserIdentify()==1}">
        <form action="tea.action?action=searchApplicationApproval" method="post">
            </c:if>
            <c:if test="${session_person.getUserIdentify()==2}">
                <%--                <form action="man.action?action=searchAllUser"  method="post">--%>
            </c:if>
            <input type="text" name="matchText"
                   style="height: 35px;width: 500px;font-size: 28px;color: darkslateblue;border: grey solid 1px;">

            <input type="submit" style="margin-left: 6px;margin-right: 30px" value="查询">


        </form>
    </div>

</div>
<br><br>
<table border="1" cellspacing="0" align="center" class="con-b">


    <thead>

    <tr class="row" style="color: black;font-size: 25px">
        <td class="lf">课程ID</td>
        <td class="lf">课程名称</td>
        <td class="lf">学生ID</td>
        <td class="lf">学生姓名</td>
        <td class="lf">申请时间</td>
        <td class="lf">申请原因</td>
        <td class="lf">主讲教师ID</td>
        <td class="lf">主讲教师姓名</td>
        <td class="lf">是否同意</td>
        <td class="lf">是否审批</td>
        <td class="lf">审批时间</td>
        <td class="lf">审批意见</td>
        <td class="lf">主管教师ID</td>
        <td class="lf">主管教师姓名</td>
        <td class="lf">是否同意</td>
        <td class="lf">是否审批</td>
        <td class="lf">审批时间</td>
        <td class="lf">审批意见</td>
        <td class="lf">确认审批</td>
        <c:if test="${session_person.getUserIdentify()!=0}">

        </c:if>


        <c:if test="${session_person.getUserIdentify()!=0}">
            <td>操作</td>
        </c:if>

    </tr>
    </thead>
    <tbody>


    <c:forEach items="${arr}" var="ApplicationApproval" begin="${startRecord}" end="${endRecord +10000}">
        <c:if test="${ApplicationApproval.allIsFinish == false}">
            <tr>
                <td class="lf">${ApplicationApproval.courseId}</td>
                <td class="lf">${ApplicationApproval.courseName}</td>
                <td class="lf">${ApplicationApproval.studentId}</td>
                <td class="lf">${ApplicationApproval.studentName}</td>
                <td class="lf">${ApplicationApproval.applicationTime}</td>
                <td class="lf">${ApplicationApproval.applicationReason}</td>
                <td class="lf">${ApplicationApproval.instructorId}</td>
                <td class="lf">${ApplicationApproval.instructorName}</td>
                <td class="lf">${ApplicationApproval.instructorApproval}</td>
                <td class="lf">${ApplicationApproval.instructorIsFinish}</td>
                <td class="lf">${ApplicationApproval.instructorApprovalTime}</td>
                <td class="lf">${ApplicationApproval.instructorApprovalComment}</td>
                <td class="lf">${ApplicationApproval.supervisorId}</td>
                <td class="lf">${ApplicationApproval.supervisorName}</td>
                <td class="lf">${ApplicationApproval.supervisorApproval}</td>
                <td class="lf">${ApplicationApproval.supervisorIsFinish}</td>
                <td class="lf">${ApplicationApproval.supervisorApprovalTime}</td>
                <td class="lf">${ApplicationApproval.supervisorApprovalComment}</td>


                <c:if test="${session_person.getUserIdentify()==1}">
                    <td>
                        <button type="button"
                                onclick="agreeApplication('${ApplicationApproval.studentId}','${ApplicationApproval.courseId}','${session_person.getUserAccount()}','${role}' ,'${ApplicationApproval.instructorIsFinish}','${ApplicationApproval.supervisorIsFinish}','${ApplicationApproval.instructorApproval}')">
                            同意
                        </button>
                        <button type="button"
                                onclick="rejectApplication('${ApplicationApproval.studentId}','${ApplicationApproval.courseId}','${session_person.getUserAccount()}','${role}','${ApplicationApproval.instructorIsFinish}','${ApplicationApproval.supervisorIsFinish}')">
                            驳回
                        </button>
                    </td>

                </c:if>

                <c:if test="${session_person.getUserIdentify()==0}">
                    <td>
                        <button type="button"
                                onclick="confirmApproval('${ApplicationApproval.studentId}','${ApplicationApproval.courseId}','${ApplicationApproval.instructorIsFinish}','${ApplicationApproval.supervisorIsFinish}')">
                            确认
                        </button>
                    </td>
                </c:if>
            </tr>
        </c:if>
    </c:forEach>

    </tbody>

</table>


</body>

<script>
    function agreeApplication(studentAccount, courseID, teaAccount, teacherRole, instructorIsFinish, supervisorIsFinish, instructorApproval) {
        if (teacherRole === 1) {
            if (instructorIsFinish === 1) {
                alert("不能重复审批！")
                return;
            }
            window.open("tea.action?action=doTComment&studentAccount=" + studentAccount + "&courseID=" + courseID + "&teaAccount=" + teaAccount, null, "width=700,height=400,left=400,top=150");
        } else if (teacherRole === 2) {
            if (instructorApproval === false) {
                alert("主讲教师已驳回申请，您无需审批")
            } else if (instructorApproval === true) {
                if (instructorIsFinish === 1) {
                    alert("不能重复审批！")
                    return;
                }
                window.open("tea.action?action=doTComment&studentAccount=" + studentAccount + "&courseID=" + courseID + "&teaAccount=" + teaAccount, null, "width=700,height=400,left=400,top=150");
            } else if (instructorApproval == null) {
                alert("请等待主讲教师审批")
            }
        } else {

            window.open("tea.action?action=doTComment&studentAccount=" + studentAccount + "&courseID=" + courseID + "&teaAccount=" + teaAccount, null, "width=700,height=400,left=400,top=150");

        }


    }

    function rejectApplication(studentAccount, courseID, teaAccount, instructorIsFinish, supervisorIsFinish) {
        if (instructorIsFinish == 1) {
            alert("不能重复审批！")
            return;
        }
        window.open("tea.action?action=doFComment&studentAccount=" + studentAccount + "&courseID=" + courseID + "&teaAccount=" + teaAccount, null, "width=700,height=400,left=400,top=150");
    }

    function confirmApproval(studentAccount, courseID, instructorIsFinish, supervisorIsFinish) {
        if (instructorIsFinish == 1 && supervisorIsFinish == 1) {
            window.location.href = "student.action?action=confirmApproval&studentAccount=" + studentAccount + "&courseID=" + courseID

        } else {
            alert("老师尚未审批完成，您现在还不能确认审批！")
        }
    }

</script>


</html>

