<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>学生基本信息</title>
</head>
<body>
<h3>请输入学生基本信息</h3>
<form action="output.jsp">
<p>姓名：<input type="text" name="name"/>
<p>性别：男<input type="radio" name="sex" value="男" checked/>&nbsp;&nbsp;
         女<input type="radio" name="sex" value="女"/>
<p>专业:
    <select name="major">
        <option value="computer">计算机科学与技术</option>
        <option value="software">软件工程</option>
        <option value="ecommerce">电子商务</option>
        <option value="electronic">电子信息工程</option>
    </select>
<p>年级：<input type="text" name="grade"/>
<p><input type="submit" value="提交"/>&nbsp;&nbsp;
    <input type="reset" value="重置"/>
</form>
</body>
</html>