<%--
  /**
   *Created by IntelliJ IDEA.
   * @author 27
   * @date 2023/5/17
   * @time 14:38
   */

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #BigBodyFrame {
            width: 100%;
            height: 110px;
            /*border: gray 2px solid;*/
            background-color: deepskyblue;
        }

        #Navigation {
            width: 90%;
            margin-left: 5%;
            height: 10%;
            /*height: 100%;*/
            /*float: left;*/
            /*border: gray 2px solid;*/
            /*background-color: lightgray;*/

        }

        /*#file{*/
        /*    width: 200%;*/
        /*    height: 300px;*/
        /*    border: gray 2px solid;*/
        /*    margin-top: 2%;*/
        /*    margin-left: 2%;*/
        /*    background-color: mediumaquamarine;*/
        /*    display: inline;*/
        /*}*/
        #file {
            width: 17%;
            /* height: 50px; */
            border: gray 2px solid;
            /*margin-top: 5%;*/
            margin-left: 2%;
            background-color: mediumaquamarine;
            display: inline-block; /* 修改 */
        }

        a {
            color: white;
            font-size: 170%;
            margin-left: 25%; /*删除 */
            /* margin-top: 25px; */ /* 删除 */
        }

    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" media="screen">
</head>
<body>
<div id="BigBodyFrame">
    <h1 align="center" style="/*margin-top:-10px;*/color: black;font-size:80px">在线课程申请及审批系统</h1>

</div>
<br>
<span style="float: right;color: grey;margin-right: 120px"> 当前用户：${session_person.userName}</span><br>
<%--<c:if test="${session_person.userName=='李四'}">hahha</c:if>  --%>
<br>
<div id="Navigation">
    <c:if test="${session_person.userIdentify == 0}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <%--        <li id="file"><a href="student.action?action=tList">选择老师</a></li>--%>
        <li id="file"><a href="student.action?action=cList">选择课程</a></li>
        <%--        <li id="file"><a href="student.action?action=goMyTeacher">我的老师</a></li>--%>
        <li id="file"><a href="student.action?action=goMyApplication">我的申请</a></li>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
        <br>
    </c:if>
    <c:if test="${session_person.userIdentify == 1}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <%--        <li id="file"><a href="tea.action?action=list">学生管理</a></li>--%>
        <li id="file"><a href="tea.action?action=aalist">审批申请</a></li>
        <%--        <li id="file"><a href="tea.action?action=goMyTask">任务管理</a></li>--%>
        <%--        <li id="file"><a href="tea.action?action=goAddTask">添加任务</a></li>--%>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
        <br>
    </c:if>

    <c:if test="${session_person.userIdentify == 2}">
        <li id="file"><a href="common.action?action=index">查看首页</a></li>
        <li id="file"><a href="man.action?action=userList">人员管理</a></li>
        <li id="file"><a href="man.action?action=goAddPerson">人员添加</a></li>
        <li id="file"><a href="man.action?action=courseList">课程管理</a></li>
        <li id="file"><a href="man.action?action=goAddCourse">课程添加</a></li>
        <li id="file"><a href="tea.action?action=aalist">申请与审批</a></li>
        <li id="file"><a href="common.action?action=goMyDetail">我的信息</a></li>
        <li id="file"><a href="outLogin">退出系统</a></li>
    </c:if>
    <%--    <div id="file" onclick="clickThis()"></div>--%>


</div>

<jsp:include page="${mainRignt=null?'blank.jsp':mainRight}"></jsp:include>


</body>
</html>
