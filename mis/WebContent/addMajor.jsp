<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="bean.*" %>
<div id="enter">
	<form id='' name='entermajor' action="AddMajor" method="post">
		<div>
			<label>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</label>
			<input type="text" id="mname" name="mname" placeholder="请输入学生专业">
		</div>
		<div>
			<label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院：</label>
			<input type="text" id="college" name="college" placeholder="请输入学生所在学院">
		</div>
			
		<div class="addbt" style="border:0;">
			<input type="submit" value="添加" style="width:65px;"/>
			<input type="reset" value="重置" style="width:65px;"/>
		</div>
	</form>
</div>
