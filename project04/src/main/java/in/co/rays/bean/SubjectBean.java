package in.co.rays.bean;

public class SubjectBean extends BaseBean {
	
	private String name;
	private Long courseId;
	private String CourseName;
	private String description;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCreatedBy(String string) {
		// TODO Auto-generated method stub
		
	}
	
	public String getKey() {
		return id + "";
	}
	public String getValue() {
		return name;
	}
	
	
	
	
	

}
