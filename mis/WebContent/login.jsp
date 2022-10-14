<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="bean.*" %>
<img alt="" src="img/hrbuc.jpg">
<div style="margin-top: 50px; margin-left: 370px;">
<font size="5" color="red">欢迎使用哈尔滨商业大学图书馆书包柜预约系统</font>

</div>

<div id="enter" style="margin-top: 50px; margin-left: 500px;">
	<form id='login' name='login' action="Login" method="post">
		<div>
			<label>用户名：</label>
			<input type="text" id="username" name="username" placeholder="请输入用户名" >
		</div>
		<br><br><br>
		<div>
			<label>密&emsp;码：</label>
			<input type="password" id="password" name="password" placeholder="请输入密码">
		</div>
			<br><br><br>
		<div class="addbt" style="border:0;">
			<input type="submit" value="登录" style="width:65px;"/>
			&emsp;&emsp;&emsp;&emsp;&emsp;
			<input type="reset" value="取消" style="width:65px;"/>
		</div>
	</form>
</div>
