<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>student'information</title>
<link rel="stylesheet" type="text/css" href="css/table.css" />
</head>
<body>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://127.0.0.1:3306/mis?characterEncoding=UTF-8&serverTimezone=GMT%2B8";
String username="root";
String password = "1314520";
Connection conn  = DriverManager.getConnection(url,username,password);
String sql = "select * from student where name like ?";
PreparedStatement stmt = conn.prepareStatement(sql);
request.setCharacterEncoding("UTF-8");
String param = request.getParameter("name");
param="%"+param+"%";
stmt.setString(1, param);
ResultSet rs = stmt.executeQuery();
out.println("<table width=800 border=1 align='center'>");
out.println("<tr>");
out.println("<td>学号</td>");
out.println("<td>姓名</td>");
out.println("<td>性别</td>");
out.println("<td>出生日期</td>");
out.println("<td>专业</td>");
out.println("<td>年级</td>");
out.println("<td>电话</td>");
out.println("<td>籍贯</td>");
out.println("</tr>");
while(rs.next()){
    out.println("<tr>");
    out.println("<td>"+rs.getString("no")+"</td>");
    out.println("<td>"+rs.getString("name")+"</td>");    
    out.println("<td>"+rs.getString("sex")+"</td>");
    out.println("<td>"+rs.getString("birthday")+"</td>");
    out.println("<td>"+rs.getString("major")+"</td>");
    out.println("<td>"+rs.getString("grade")+"</td>");
    out.println("<td>"+rs.getString("phone")+"</td>");
    out.println("<td>"+rs.getString("origin")+"</td>");
    out.println("</tr>");
}
out.println("</table>");
rs.close();
stmt.close();
conn.close();  

%>


</body>
</html>