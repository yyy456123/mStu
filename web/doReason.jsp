<%--
  Created by IntelliJ IDEA.
  User: 30890
  Date: 2023/4/26
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #content {
            width: 100%;
            height: 600px;
            margin-right: 40px;
            border: saddlebrown 1px solid;
        }

        #innerAddTaskFrame {
            width: 100%;
            height: 400px;
            margin-left: 50px;
            color: mediumslateblue;
            margin-top: 50px;
            font-size: 20px;
        }

    </style>
</head>
<body>
<div id="content">


    <div id="innerAddTaskFrame">
        请说明申请原因：<br><br>
        <form action="student.action?action=dealReason&courseID=${courseID}" method="post" onsubmit="return isDeal()">
            <textarea id="comment" style="width: 600px;height: 160px;font-size: 25px;color: grey" rows="4"
                      name="comment">

            </textarea>
            <br> <br> <br>
            <input style="margin-left: 350px" type="submit" value="点击添加">

        </form>
        <span style="margin-left: 320px;font-size: 15px;color: red">${tip}</span>


    </div>

</div>
<script>
    function isDeal() {
        let text = document.getElementById("comment").value;
        if (text.trim() == "" || text == null) {
            alert("原因不能为空");
            return false;
        } else {
            return true;
        }
    }
</script>


</body>
</html>
<script>


</script>
