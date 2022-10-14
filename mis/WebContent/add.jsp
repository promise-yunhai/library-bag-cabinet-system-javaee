<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="bean.*" %>
<h1>欢迎使用书包柜预约系统</h1>
<div id="enter">
	<form id='' name='enterstudent' action="Add" method="post">
	
		<div>
			<label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
			<input type="text" id="no" name="no" placeholder="请输入你的学号">
		</div>
		<div>
			<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
			<input type="text" id="name" name="name" placeholder="请输入你的姓名">
		</div>
		<div>
			<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
			男<input type="radio" id="sex" name="sex" value="男"
				style="width:15px;vertical-align:-3px;margin-right:100px;">
			女<input type="radio" id="sex" name="sex" value="女"
				style="width:15px;vertical-align:-3px;">
		</div>
		<div>
			<label>出生日期：</label>
			<input type="text" id="birthday" name="birthday" readonly="readonly"
				onclick="new Calendar().show(this);" placeholder="请选择你的出生日期">
		</div>
		<div>
			<label>联系方式：</label>
			<input type="text" id="phone" name="phnoe" maxlength="4" placeholder="请输入你的联系方式">	
		</div>
		<div>
			<label>楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;层：</label>
			<input type="text" id="origin" name="origin" maxlength="4" placeholder="请输入你的理想楼层">
		</div>		
		<div>
			<label>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：</label>
			<input type="text" id="grade" name="grade" maxlength="4" placeholder="请输入你的年级">	
		</div>
<!-- 		<div> -->
<!-- 			<label>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院：</label> -->
<!-- 			<select id="mname" name="mname"> -->
<!-- 			     <option value="-2">--请选择你的学院--</option> -->
<%-- 			     <%=Major.getMajorforSelect2()%> --%>
			    		      
<!-- 			</select>			 -->
<!-- 		</div> -->
		<div>
			<label>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</label>
			<select id="major" name="major">
			     <option value="-1">--请选择你所学专业--</option>
			     <%=Major.getMajorforSelect()%>
			    		      
			</select>			
		</div>
		
		
		<div class="addbt" style="border:0;">
			<input type="submit" value="添加" style="width:65px;"/>
			<input type="reset" value="重置" style="width:65px;"/>
		</div>
	</form>
</div>
