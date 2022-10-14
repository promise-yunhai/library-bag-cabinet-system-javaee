<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="bean.*"%>
<%
//if(session.getAttribute("login")==null || !session.getAttribute("login").equals("success"))
  // response.sendRedirect("login.jsp");
%>
<html>
<head>
<title>图书馆书包柜管理系统</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<script type="text/javascript" src="js/calendar.js"></script>
</head>
<body>

    <div id="top"><h1 class="header">图书馆书包柜管理系统</h1></div>
    <div id="main">
        <div id="leftMenu">
             <ul>
                 <li><a href="main.jsp?operate=welcome.jsp">主页</a></li>
                 <li><a href="main.jsp?operate=find.jsp">查询</a></li>
                 <li><a href="main.jsp?operate=add.jsp">预约</a></li>
                 <li><a href="main.jsp?operate=addMajor.jsp">专业维护</a></li>
                 <li><a href="main.jsp?operate=addFloor.jsp">楼层维护</a></li>
                 <li><a href="login.jsp">退出</a></li>
            </ul>
        </div>
        <div id="content">        
        <jsp:include page=
            '<%=request.getParameter("operate")==null?"welcome.jsp":request.getParameter("operate")%>'/>                
        
           
        </div>
    </div>
    <div id="footer">版权所有:&nbsp;&nbsp;哈尔滨商业大学&nbsp;&nbsp;图书馆&nbsp;&nbsp;</div>

</body>
</html>