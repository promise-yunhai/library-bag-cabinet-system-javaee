<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="bean.*" %>
<%
String id=request.getParameter("id")==null?"":request.getParameter("id");
Student stu = DB.getStudentByID(id);
%>


<div id="enter">
	<form id='' name='enterstudent' action="Update" method="post">
	        <input type="hidden" name="id" value=<%=stu.getId() %>>
		<div>
			<label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
			<input type="text" id="no" name="no" value=<%=stu.getNo() %>>
			<span class="spants">请输入学生学号</span>
		</div>
		<div>
			<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
			<input type="text" id="name" name="name" value=<%=stu.getName() %>>
			<span class="spants">请输入学生姓名</span>
		</div>
		<div>
			<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
			男<input type="radio" id="sex" name="sex" value="男" <%=stu.getSex().equals("男")?"checked":"" %>
				style="width:15px;vertical-align:-3px;margin-right:30px;">
			女<input type="radio" id="sex" name="sex" value="女" <%=stu.getSex().equals("女")?"checked":"" %>
				style="width:15px;vertical-align:-3px;">
		</div>
		<div>
			<label>出生日期：</label>
			<input type="text" id="birthday" name="birthday" value=<%=stu.getBirthday() %>>
			<span class="spants">请输入学生出生日期</span>
		</div>
		<div>
			<label>联系方式：</label>
			<input type="text" id="phone" name="phnoe" maxlength="4" placeholder="请输入你的联系方式">	
		</div>
		<div>
			<label>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</label>
			<input type="text" id="major" name="major" value=<%=stu.getMajor() %>>			    
			<span class="spants">请输入学生所学专业</span>
		</div>
		<div>
			<label>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：</label>
			<input type="text" id="grade" name="grade" maxlength="4" value=<%=stu.getGrade() %>>	
			<span class="spants">请输入学生年级</span>		
		</div>
		<div>
			<label>籍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贯：</label>
			<input type="text" id="origin" name="origin" value=<%=stu.getOrigin() %>>				
		</div>		
		<div class="addbt" style="border:0;">
			<input type="submit" value="修改" style="width:65px;"/>
			<input type="reset" value="取消" style="width:65px;"/>
		</div>
		
	</form>
</div>
