package in.co.rays.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.spi.ResolveResult;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.xdevapi.Statement;

public final class JDBCDataSource {
	
	private static JDBCDataSource  jds = null;
	
	private ComboPooledDataSource cpds = null;
	
     private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");
     
     private JDBCDataSource() {
    	 
    	 try {
			
    		 cpds = new ComboPooledDataSource();
    		 cpds.setDriverClass(rb.getString("driver"));
    		 cpds.setJdbcUrl(rb.getString("url"));
    		 cpds.setUser(rb.getString("username"));
    		 cpds.setPassword(rb.getString("password"));
    		 cpds.setInitialPoolSize(Integer.parseInt(rb.getString("initialpoolsize")));
    		 cpds.setAcquireIncrement(Integer.parseInt(rb.getString("acquireincrement")));
    		 cpds.setMaxPoolSize(Integer.parseInt(rb.getString("maxpoolsize")));
    		 
  
		} catch (Exception e) {
		
			e.printStackTrace();
		}
     }
     public static JDBCDataSource getInstance() {
    	 if(jds == null) {
    		 
    		 jds = new JDBCDataSource();
    		 
    	 }
    	 return jds;
     }
     
     public static Connection getConnection() {
    	 try {
			return getInstance().cpds.getConnection();
			
		} catch (SQLException e) {
			return null;
			
			
		}
    	 
    	 
     }
     
     public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
    	
    	 try {
			  if (rs != null) {
				  rs.close();
			  }
			  if (stmt != null) {
				  ((Connection) stmt).close();   
				    
			  }
			  if (conn != null) {
				  
				  conn.close();
			  }   
				  
					  
		} catch (Exception e) {
		e.printStackTrace();
		}
     }
    	 
    	public static void closeConnection(Connection conn, Statement stmt) {
    		closeConnection(conn, stmt, null);
    	}
    	
    	public static void closeConnection(Connection conn) {
    		closeConnection(conn, null);
    		
    	 
		
		
	}

}
