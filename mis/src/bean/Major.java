package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Major {
	private String id,mname,college;

	public Major(String id, String mname, String college) {
		super();
		this.id = id;
		this.mname = mname;
		this.college = college;
	}
	
	public Major() {
		super();
		this.id = "";
		this.mname = "";
		this.college = "";
	}
	
	public Major(HttpServletRequest request) {
		super();
		this.id = "";
		this.mname = request.getParameter("mname")==null?"":request.getParameter("mname");
		this.college = request.getParameter("college")==null?"":request.getParameter("college");
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}
	
	public static List<Major> getMajors(){
		List<Major> majors = new ArrayList<Major>();
		Connection conn = DB.getConnection();
		ResultSet rs = null;
		if(conn==null) 
			return majors;
		Statement stmt=null;		
	    String sql = "select * from major";	    
	   //System.out.println(sql);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {				
				majors.add(new Major(rs.getString("id"),
						             rs.getString("mname"),
						             rs.getString("college")));
			}			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return majors;
	}
	
    public static String getMajorforSelect() {
    	String html="";
    	List<Major> majors = getMajors();
    	for(int i=0;i<majors.size();i++) {
    		html+="<option value="+majors.get(i).getId()+">"+majors.get(i).getMname()+"</option>";
    	}
    	
    	return html;		
	}
    
    public static String getMajorforSelect2() {
    	String html="";
    	List<Major> majors = getMajors();
    	for(int i=0;i<majors.size();i++) {
    		html+="<option value="+majors.get(i).getId()+">"+majors.get(i).getCollege()+"</option>";
    	}
    	
    	return html;		
	}
    
    public boolean add() {
    	boolean state = false;
		Connection conn = DB.getConnection();
		if(conn==null) 
			return state;
		PreparedStatement stmt=null;
		String sql = "insert into major(mname,college) values(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, this.getMname());
			stmt.setString(2, this.getCollege());			
			stmt.executeUpdate();
			state = true;
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return state;
    }
	
	
    

}
