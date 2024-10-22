package in.co.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.bean.TimeTableBean;
import in.co.rays.model.CollegeModel;
import in.co.rays.model.TimeTableModel;
import in.co.rays.util.JDBCDataSource;

public class TestTimetable {
	
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		//testDelete();
	testfindByPk();
		//testSearch();
		
	}
	public Integer nextPk() throws Exception {
		int pk = 0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_timetable");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		JDBCDataSource.closeConnection(conn);
		return pk + 1;
	}

	private static void testSearch()  throws Exception{
		
		TimeTableBean bean = new TimeTableBean();
		
		TimeTableModel model = new TimeTableModel();
		
		bean.setSemester("4");
		
		List list = model.search(bean, 1, 5);
		
		Iterator  it = list.iterator();
		
		while (it.hasNext()) {
			
			bean = (TimeTableBean) it.next();
			
			System.out.println(bean.getId());
			System.out.println(bean.getSemester());
			System.out.println(bean.getDescription());
			System.out.println(bean.getExamDate());
			System.out.println(bean.getExamTime());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getExamTime());
			System.out.println(bean.getExamTime());
			System.out.println(bean.getSubjectId());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
			
		}
	
		
	}

	private static void testfindByPk() throws Exception {
		
		TimeTableBean bean = new TimeTableBean();
		
		TimeTableModel model = new TimeTableModel();
		
		bean = model.findByPk(1);
	
		if(bean != null) {
			
			System.out.println(bean.getId());
			System.out.println(bean.getSemester());
			System.out.println(bean.getDescription());
			System.out.println(bean.getExamDate());
			System.out.println(bean.getExamTime());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getSubjectId());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
		}
		
		
		
	}

	private static void testDelete() throws Exception {
		
		TimeTableBean bean = new TimeTableBean();
		
		bean.setId(1);

		TimeTableModel model = new TimeTableModel();

		model.delete(bean);
	}

		
		
	

	private static void testUpdate()  throws Exception{
		
		TimeTableBean bean = new TimeTableBean();
		
		
		bean.setSemester("12");
		bean.setDescription("qwer");
		bean.setExamDate(new Date(2024-05-02));
		bean.setExamTime("1Pm to 4pm");
		bean.setCourseId(1);
		bean.setCourseName("wuyeg");
		bean.setSubjectId(1);
		bean.setSubjectName("qwwe");
		bean.setCreatedBy("piwuba");
		bean.setModifiedBy("bahgs");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		TimeTableModel model = new TimeTableModel();
		
		model.update(bean);
	
	
		
	}

	public  static void testAdd() throws Exception {
		
		TimeTableBean  bean = new TimeTableBean();
		
		bean.setSemester("12");
		bean.setDescription("qwer");
		bean.setExamDate(new Date(2024-05-02));
		bean.setExamTime("1Pm to 4Pm ");
		bean.setCourseId(1);
		bean.setCourseName("wuyeg");
		bean.setSubjectId(1);
		bean.setSubjectName("qwwe");
		bean.setCreatedBy("piwuba");
		bean.setModifiedBy("bahgs");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		TimeTableModel model = new TimeTableModel();
		
		model.add(bean);
		
		
		
	}
	
	

}
