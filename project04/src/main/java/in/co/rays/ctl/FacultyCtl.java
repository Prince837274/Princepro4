package in.co.rays.ctl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import in.co.rays.util.PropertyReader;

@WebServlet(name =  "FacultyCtl", urlPatterns = {"/FacultyCtl"})
public class FacultyCtl  extends BaseCtl {
	
	@Override
	protected boolean validate(HttpServletRequest) {
	  boolean pass = true;
	  
	if(Datavalidator.isNull(request.getParameter("firstName"))) {
		request.setAttribute("firstName", PropertyReader.getValue("error.require","First Name"));
		pass = false;
		
	}else if (!DataValidator.isName(request.getParameter("firstName"))) {
		request.setAttribute("firstName", "Invalid First Name");
		pass = false;
		
	}
	if(DataValidator.isNull(request.getParameter("lastName"))) {
		request.setAttribute("lastName", PropertyReader.getValue("error.require", "Last Name"));
		pass = false;
		
	}else if(!DataValidator.isNull(request.getParamater("lastName"))) {
		request.setAttribute("lastName","Invalid Last Name");
		pass = false;
		
	}
	if(DataValidator.isNull(request.getParameter("email"))) {
		request.setAttribute("email",PropertyReader.getValue("error.require","Email Id"));
		pass = false;
	 
	}else if(!DataValidator.isEmail(request.getParameter("email"))) {
		request.setAttribute("email",PropertyReader.getValue("error.email","Email"));
		pass = false;
	 
	}
	if(DataValidator.isNull(request.getParameter("dob"))) {
		request.setAttribute("dob",PropertyReader.getValue("error.date", "Date of Birth"));
		pass = false;
		
	}else if (!Datavalidator.isNull(request.getParameter("dob"))) {
		request.setAttribute("dob", PropertyReader.getValue("error.date", "Date of Birth"));
		pass = false;
	}	
	 if(DataValidator.isNull(request.getParameter("gender"))) {
		 request.setAttribute("gender", PropertyReader.getValue("error.require","Gender"));
		 pass = false;
		
	}
	 if(Datavalidator.isNull(request.getParameter("mobileNo"))) {
		 request.setAttribute("gender",PropertyReader.getValue("error.require","Mobile No"));
		 pass = false;
	 }	 
		
	}else if(!DataValidator.isPhoneLength(request.getParameter("mobileNo"))) {
		request.setAttribute("mobileNo", "Mobile No must have 10 digits");
		pass = false;
		
	} else if (!DataValidator.isPhoneNo(request.getParameter("mobileNo"))) {
		request.setAttribute("mobileNo", "Invalid Mobile No");
		pass = false;
	}
	if (DataValidator.isNull(request.getParameter("collegeId"))) {
		request.setAttribute("collegeId", PropertyReader.getValue("error.require", "College Name"));
		pass = false;
	}
	if (DataValidator.isNull(request.getParameter("courseId"))) {
		request.setAttribute("courseId", PropertyReader.getValue("error.require", "Course Name"));
		pass = false;
	}
	if (DataValidator.isNull(request.getParameter("subjectId"))) {
		request.setAttribute("subjectId", PropertyReader.getValue("error.require", "Subject Name"));
		pass = false;
	}
	return pass;
}

@Override
protected BaseBean populateBean(HttpServletRequest request) {
	FacultyBean bean = new FacultyBean();
	bean.setId(DataUtility.getLong(request.getParameter("id")));
	bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
	bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
	bean.setEmail(DataUtility.getString(request.getParameter("email")));
	bean.setDob(DataUtility.getDate(request.getParameter("dob")));
	bean.setGender(DataUtility.getString(request.getParameter("gender")));
	bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
	bean.setCollegeId(DataUtility.getLong(request.getParameter("collegeId")));
	bean.setCourseId(DataUtility.getLong(request.getParameter("courseId")));
	bean.setSubjectId(DataUtility.getLong(request.getParameter("subjectId")));
	populateDTO(bean, request);
	return bean;
}

@Override
protected void preload(HttpServletRequest request) {

	CollegeModel collegeModel = new CollegeModel();
	CourseModel courseModel = new CourseModel();
	SubjectModel subjectModel = new SubjectModel();

	try {
		List collegeList = collegeModel.list();
		List courseList = courseModel.list();
		List subjectList = subjectModel.list();
		request.setAttribute("collegeList", collegeList);
		request.setAttribute("courseList", courseList);
		request.setAttribute("subjectList", subjectList);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	ServletUtility.forward(getView(), request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	ServletUtility.forward(getView(), request, response);
}

@Override
protected String getView() {
	return ORSView.FACULTY_VIEW;
}
}
	
	

}
}
