<%--/**--%>
<%-- * Created by IntelliJ IDEA.    --%>
<%-- * User: 27                    --%>
<%-- * Date: 2023/5/14             --%>
<%-- * Time: 0:54                  --%>
<%-- */--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>登录</title>

    <style>
        body {
            background-color: #F2F2F2;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
        }

        .form-wrapper {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 360px;
            padding: 40px;
            background-color: #FFFFFF;
            border-radius: 20px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            margin: 0 0 30px;
            font-size: 30px;
            letter-spacing: 2px;
            color: #4CAF50;
        }

        input[type="text"],
        input[type="password"] {
            display: block;
            width: 100%;
            margin: 30px 0;
            padding: 14px;
            border-radius: 25px;
            border: none;
            background-color: #F9F9F9;
            color: #333;
            font-size: 16px;
            text-align: center;
            outline: none;
        }

        input[type="text"]::placeholder,
        input[type="password"]::placeholder {
            color: #aaa;
        }

        input[type="submit"] {
            display: block;
            width: 100%;
            margin-top: 50px;
            padding: 14px;
            border-radius: 25px;
            border: none;
            background-color: #4CAF50;
            color: white;
            font-size: 20px;
            cursor: pointer;
            transition: all 0.3s ease-in-out;
        }

        input[type="submit"]:hover {
            transform: translateY(-5px);
            background-color: #2E8B57;
        }
    </style>
</head>

<body>

<div class="form-wrapper">
    <h1>在线课程申请及审批系统</h1>
    <form action="userLogin" method="post" onsubmit="return checkLogin()">
        <input type="text" id="userAccount" name="userAccount" placeholder="请输入账号" required>
        <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required>
        <input type="submit" value="登录">
        <span id="tip">${tip}</span>
    </form>
</div>

</body>

<script>
    function checkLogin() {
        let userAccount = document.getElementById("userAccount").value;
        let userPassword = document.getElementById("userPassword").value;
        if (userAccount == null || userAccount.trim() == "") {
            alert("账号不能为空");
            return false;
        }
        if (userPassword == null || userPassword.trim() == "") {
            alert("密码不能为空");
            return false;
        }
        return true;
    }
</script>

</html>
