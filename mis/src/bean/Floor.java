package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class Floor {
	private String id,floors;


	public Floor(String id, String floors) {
		super();
		this.id = id;
		this.floors = floors;
	}
	
	public Floor() {
		super();
		this.id = "";
		this.floors = "";
	}
	
	public Floor(HttpServletRequest request) {
		super();
		this.id = "";
		this.floors = request.getParameter("floors")==null?"":request.getParameter("floors");
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFloor() {
		return floors;
	}

	public void setFloor(String floors) {
		this.floors = floors;
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
				majors.add(new Major(
						             ));
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
    
    public boolean add() {
    	boolean state = false;
		Connection conn = DB.getConnection();
		if(conn==null) 
			return state;
		PreparedStatement stmt=null;
		String sql = "insert into major(mname,college) values(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, this.getFloor());			
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
