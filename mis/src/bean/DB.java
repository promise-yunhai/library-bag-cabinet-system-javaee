package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {	
	
	public static Connection getConnection(String driver, String url, String username, String password) {
		Connection conn=null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			System.out.println("���ܼ������ݿ�������");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���ܽ������ݿ����ӡ�");
			e.printStackTrace();
		}		
		return conn;
	}
	
	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/system?characterEncoding=UTF-8&serverTimezone=GMT%2B8";
		String username = "root";
		String password = "1314520";
		Connection conn=null;
		conn = getConnection(driver,url,username,password);			
		return conn;
	}
	
	/**
	 * ��ȡָ��������ѧ����¼
	 * @param stu ѧ�������������е�ÿ������Ϊ��ѯ������������������Ĺ�ϵ
	 * @param page ҳ�ţ��ӿ�ʼ
	 * @param record ÿҳ�ļ�¼����
	 * @return
	 */
	public static List<Student> getStudents(Student stu,int page,int record){
		List<Student> students = new ArrayList<Student>();
		Connection conn = getConnection();
		ResultSet rs = null;
		if(conn==null) 
			return students;
		Statement stmt=null;		
	    String sql = "select * from student";
	    if(!stu.isAllEmpty()) {
	    	sql+=" where ";
	    	if(!stu.getNo().equals(""))
	    		sql+="no like '%"+stu.getNo()+"%' and ";
	    	if(!stu.getName().equals(""))
	    		sql+="name like '%"+stu.getName()+"%' and ";
	    	if(!stu.getSex().equals(""))
	    		sql+="sex like '%"+stu.getSex()+"%' and ";
	    	if(!stu.getBirthday().equals(""))
	    		sql+="birthday like '%"+stu.getBirthday()+"%' and ";
	    	if(!stu.getMajor().equals(""))
	    		sql+="major like '%"+stu.getMajor()+"%' and ";
	    	if(!stu.getGrade().equals(""))
	    		sql+="grade like '%"+stu.getGrade()+"%' and ";
	    	if(!stu.getPhone().equals(""))
	    		sql+="phone like '%"+stu.getPhone()+"%' and ";
	    	if(!stu.getOrigin().equals(""))
	    		sql+="origin like '%"+stu.getOrigin()+"%' and ";
	    	sql = sql.substring(0,sql.length()-5);	    	
	    }
	    sql+=" order by id";
	    if(page>0) {
    		int begin = (page-1)*record;
    		sql+=" limit "+begin+","+record;
    	}	    
	    
	   //System.out.println(sql);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {				
				students.add(new Student(rs.getString("id"),rs.getString("no"),rs.getString("name"),
			                             rs.getString("sex"),rs.getString("birthday"),
			                             rs.getString("major"),rs.getString("grade"),
			                             rs.getString("phone"),rs.getString("origin")));
			}			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return students;
	}
	
	/**
	 * ��ȡָ��������ѧ����¼
	 * @param stu ѧ�������������е�ÿ������Ϊ��ѯ������������������Ĺ�ϵ
	 * @return
	 */
	public static List<Student> getStudents(Student stu){
		return getStudents(stu,0,0);
	}
	
	/**
	 * ��ȡ����ѧ���ļ�¼
	 * @return
	 */
	public static List<Student> getStudents(){
		return getStudents(new Student(),0,0);
	}
	
	public static Student getStudentByID(String id) {		
		Connection conn = getConnection();
		Student stu = new Student();
		ResultSet rs = null;
		if(conn==null) 
			return stu;
		PreparedStatement stmt=null;
	    String sql = "select * from student where id=?";
	    try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next())
			    stu = new Student(rs.getString("id"),rs.getString("no"),rs.getString("name"),
                    rs.getString("sex"),rs.getString("birthday"),
                    rs.getString("major"),rs.getString("grade"),
                    rs.getString("phone"),rs.getString("origin"));			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return stu;
	}
	
	
		
	public static String getStuHTML(Student stu,int page,int record) {
		String html="";
		List<Student> students = getStudents(stu,page,record);
		html+="<div>\n";
		html+="<table align='center'>\n";
		html+="<tr>";
		html+="<th>ѧ��</th>";
		html+="<th>����</th>";
		html+="<th>�Ա�</th>";
		html+="<th>��������</th>";
		html+="<th>רҵ</th>";
		html+="<th>�꼶</th>";
		html+="<th>�绰</th>";
		html+="<th>����</th>";
		html+="<th></th>";
		html+="</tr>\n";
		for(int i=0;i<students.size();i++) {
			html+="<tr>";
			html+="<td>"+students.get(i).getNo()+"</td>";
			html+="<td>"+students.get(i).getName()+"</td>";
			html+="<td>"+students.get(i).getSex()+"</td>";
			html+="<td>"+students.get(i).getBirthday()+"</td>";
			html+="<td>"+students.get(i).getMajor()+"</td>";
			html+="<td>"+students.get(i).getGrade()+"</td>";
			html+="<td>"+students.get(i).getPhone()+"</td>";
			html+="<td>"+students.get(i).getOrigin()+"</td>";
			html+="<td><a href='main.jsp?operate=upedit.jsp&id="+students.get(i).getId()+"'>�޸�</a>&nbsp;&nbsp;<a href='Delete?id="+students.get(i).getId()+"'>ɾ��</a></td>";
			html+="</tr>\n";
		}
		html+="</table>\n";
		html+="<div>\n";
		//html+="<a href=''>��һҳ</a>";	
		//html+="<a href=''>��һҳ</a>";	
		//html+="<a href=''>��һҳ</a>";	
	    //html+="<a href=''>���һҳ</a>";	
		html+="</div>\n";
		html+="</div>\n";
		
		return html;
	}
	
	
	
	public static boolean add(Student stu) {
		boolean state = false;
		Connection conn = getConnection();
		if(conn==null) 
			return state;
		PreparedStatement stmt=null;
		String sql = "insert into student(no,name,sex,birthday,major,grade,phone,origin) values(?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, stu.getNo());
			stmt.setString(2, stu.getName());
			stmt.setString(3, stu.getSex());
			stmt.setString(4, stu.getBirthday());
			stmt.setString(5, stu.getMajor());
			stmt.setString(6, stu.getGrade());
			stmt.setString(7, stu.getPhone());
			stmt.setString(8, stu.getOrigin());
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
	
	public static boolean update(Student stu) {
		boolean state = false;
		Connection conn = getConnection();
		if(conn==null) 
			return state;
		PreparedStatement stmt=null;
		String sql = "update student set no=?,name=?,sex=?,birthday=?,"
				+ "major=?,grade=?,phone=?,origin=? where id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, stu.getNo());
			stmt.setString(2, stu.getName());
			stmt.setString(3, stu.getSex());
			stmt.setString(4, stu.getBirthday());
			stmt.setString(5, stu.getMajor());
			stmt.setString(6, stu.getGrade());
			stmt.setString(7, stu.getPhone());
			stmt.setString(8, stu.getOrigin());
			stmt.setString(9, stu.getId());
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
	
	public static boolean delete(String id) {
		boolean state = false;
		Connection conn = getConnection();
		if(conn==null) 
			return state;
		PreparedStatement stmt=null;
		String sql = "delete from student where id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(id));			
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
	
	
	
	
	
	public static void print(List<Student> stus) {
		for(int i=0;i<stus.size();i++) {
			System.out.println(stus.get(i));
		}
	}
	
	


	public static void main(String[] args) {
		//Student stu = new Student("8888","88888","��","1998-06-06","11","11","11","11");
		//Student stu = new Student();
		//stu.setSex("��");
		//stu.setPhone("1388888");
		//DB.add(stu);
		//print(DB.getStudents(stu,1,20));
		//System.out.println(getStuHTML(stu,1,3));
		
		DB.getConnection();
		
		

	}

}
