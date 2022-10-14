package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class User {
	private String username,password;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User() {
		super();
		this.username = "";
		this.password = "";
	}
	
	public User(HttpServletRequest request) {
		super();		
		this.username = request.getParameter("username")==null?"":request.getParameter("username");
		this.password = request.getParameter("password")==null?"":request.getParameter("password");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean check() {
		boolean state = false;
		Connection conn = DB.getConnection();
		ResultSet rs = null;
		if(conn==null) 
			return state;
		PreparedStatement stmt=null;
	    String sql = "select * from user where username=? and password=?";
	    try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, this.getUsername());
			stmt.setString(2, this.getPassword());
			rs = stmt.executeQuery();
			if(rs.next())
				state=true;			   		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return state;
	}
	
	
	
	

}
