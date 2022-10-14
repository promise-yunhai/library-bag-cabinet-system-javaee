package bean;


import javax.servlet.http.HttpServletRequest;

public class Student {
	private String id,no,name,sex,major,grade,phone,origin;
	private String birthday;

	public Student(String no, String name, String sex, String birthday, String major,
			String grade, String phone, String origin) {
		super();		
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.major = major;
		this.grade = grade;
		this.phone = phone;
		this.origin = origin;
		this.birthday = birthday;		
	}	
	
	public Student(String id,String no, String name, String sex, String birthday, String major,
			String grade, String phone, String origin) {
		super();	
		this.id = id;
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.major = major;
		this.grade = grade;
		this.phone = phone;
		this.origin = origin;
		this.birthday = birthday;		
	}	
	
	public Student(HttpServletRequest request) {
		super();
		this.id = request.getParameter("id")==null?"":request.getParameter("id");
		this.no = request.getParameter("no")==null?"":request.getParameter("no");
		this.name = request.getParameter("name")==null?"":request.getParameter("name");
		this.sex = request.getParameter("sex")==null?"":request.getParameter("sex");
		this.major = request.getParameter("major")==null?"":request.getParameter("major");
		this.grade = request.getParameter("grade")==null?"":request.getParameter("grade");
		this.phone = request.getParameter("phone")==null?"":request.getParameter("phone");
		this.origin = request.getParameter("origin")==null?"":request.getParameter("origin");
		this.birthday = request.getParameter("birthday")==null?"":request.getParameter("birthday");		
	}	
	
	public Student() {
		super();
		this.id = "";
		this.no = "";
		this.name = "";
		this.sex = "";
		this.major = "";
		this.grade = "";
		this.phone = "";
		this.origin = "";
		this.birthday = "";		
	}	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;		
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrigin() {
		return origin;
	}

	public void setFrom(String origin) {
		this.origin = origin;
	}	
	
	public boolean isAllEmpty() {
		if(this.no.equals("") && this.name.equals("") && this.sex.equals("") && this.birthday.equals("") &&
			this.major.equals("") && this.grade.equals("") && this.phone.equals("") && this.origin.equals(""))
		   return true;
		else
		   return false;
		
	}
	
	public String toString() {
		return this.no+"  "+this.name+"  "+this.sex+"  "+this.birthday+"  "+ this.major+"  "+
	           this.grade+"  "+this.phone+"  "+this.origin;				
	}
}
