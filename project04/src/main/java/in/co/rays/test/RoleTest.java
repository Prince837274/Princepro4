package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.RoleBean;
import in.co.rays.model.RoleModel;

public class RoleTest {
	
	public static void main(String[] args)throws Exception {
		
		testfindByPk();
		//testUpdate();
		//testSearch();
		// testAdd();
		// testDelete();
		testfindByName();
	}

	private static void testfindByName() throws Exception {
		
		RoleBean bean = new RoleBean();
		
		RoleModel model = new RoleModel();
		
		bean = model.findByName("admin");
		if (bean != null);
		
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());
		
	}

	private static void testfindByPk()  throws Exception{
		
		RoleBean bean = new RoleBean();
		
		RoleModel model = new RoleModel();
		
		bean = model.findByPk(1);
		
		if (bean != null);
		
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());
		
	}
	

	public static void testAdd() throws Exception {
            
		RoleBean  bean = new RoleBean();
		
		bean.setName("admin");
		bean.setDescription("admin");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		RoleModel model = new RoleModel();
		model.add(bean);	
		}
		private static void testUpdate() throws Exception {
			
			RoleModel model = new RoleModel();
			
			RoleBean bean = new RoleBean();
			 
			bean.setName("admin");
			bean.setDescription("pp");
			bean.setCreatedBy("admin@gmail.com");
			bean.setModifiedBy("qwyqh");
			bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
			
			model.update(bean);
		}

  private static void testDelete()throws Exception {
	  
	  RoleModel model = new RoleModel();
	   RoleBean bean = new RoleBean();
	  
	   bean.setId(1);
	   
	   model.delete(bean);
  }
  
    private static void testSearch() throws Exception {
    	
    	RoleBean bean = new RoleBean();
    	
    	RoleModel model = new RoleModel();
    	
    	 bean.setName("qwer");
    	 bean.setDescription("nbvg");
    	 
    	 List list = model.search(bean, 1, 5);
    	 
    	 Iterator it = list.iterator();
    	 
    	 while (it.hasNext()) {
    		 
    		 bean = (RoleBean) it.next();
    		 
    		 System.out.println(bean.getId());
    		 System.out.println("\t" + bean.getName());
    		 System.out.println("\t" + bean.getDescription());
    		 System.out.println("\t" + bean.getCreatedBy());
    		 System.out.println("\t" + bean.getModifiedBy());
    		 System.out.println("\t" + bean.getCreatedDatetime());
    		 System.out.println("\t" + bean.getModifiedDatetime());
    	 }
    	 }
}

    