package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entities.*;
public class DbAdapter {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   static Connection conn = null;
   static Statement stmt = null;
   public static void main(String[] args) {

   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE DATABASE IF NOT EXIST SMARTLOCK;";
	  stmt.executeUpdate(sql);
	  sql = "use SMARTLOCK;";
	  stmt.executeUpdate(sql);
	  
      String sqlUser = "CREATE TABLE USER " + 
					   "(USER_ID int    NOT NULL, " +
					   " NAME varchar    NOT NULL , " +
					   " PRIMARY_PHONE_NUMBER int    NOT NULL , " +
					   " IS_MOBILE_VERIFIED char   NOT NULL , " +
					   " COUNTRY varchar    NOT NULL , " +
					   " PASSWORD varchar    NOT NULL , " +
					   " USER_STATE char    NOT NULL , " +
					   " DATE_OF_BIRTH date    NOT NULL , " +
					   " GENDER char    NOT NULL , " +
					   " EMAIL_ADDRESS varchar    NOT NULL , " +
					   " ZIP_CODE int    NOT NULL , " +
					   " ICON varchar    NOT NULL, " +
					   "PRIMARY KEY USER_ID )";
					   
      
      String sqlProperty =" CREATE TABLE PROPERTIES (" +
			    		   "PROPERTY_ID int    NOT NULL, " +
			    		   "USER_ID int		NOT NULL" +
			    		   "DESCRIPTION varchar()    NOT NULL ," +
			    		   "ADDRESS varchar()    NOT NULL ," +
			    		   "CITY varchar()    NOT NULL ," +
			    		   "ZIP_CODE int    NOT NULL ," +
			    		   "STATE varchar()    NOT NULL ," +
			    		   "COUNTRY varchar()    NOT NULL ," +
			    		   "OWNSHIP varchar()    NOT NULL), " +
			    		   "PRIMARY KEY PROPERTY_ID, " +
			    		   "FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID))";
			    		   
	  String sqlLock = "CREATE TABLE LOCK (" +
					   "LOCK_ID int    NOT NULL," +
					   "DESCRIPTION varchar()    NOT NULL ," +
					   "IS_LOCKED bool    NOT NULL ," +
					   "LOCK_POWER double    NOT NULL ," +
					   "LOCK_START_ANGLE double()    NOT NULL ," +
					   "LOCK_END_ANGLE double()    NOT NULL ," +
					   "ROTATION_DIRECTION char()    NOT NULL ," +
					   "ROTATION_END_POINTS double()    NOT NULL, " + 
					   "PRIMARY KEY LOCK_ID, " +
					   "FOREIGN KEY (LOCK_ID) REFERENCES PROPERTIES(PROPERTY_ID))";
					  
	  String sqlLockActivity = "CREATE TABLE LOCK_ACTIVITY (" +
							   "LOCK_ID int    NOT NULL ," + 
							   "GUEST_ID int    NOT NULL ," + 
							   "HOST_ID int    NOT NULL ," +
							   "ACCESS_START_TIME date    NOT NULL ," + 
							   "ACCESS_END_TIME date    NOT NULL ," + 
							   "REQUEST_ACCESS_TIMESTAMP date    NOT NULL ," + 
							   "REQUEST_STATUS bool    NOT NULL ,"  +
							   "ALERT int NOT NULL, " +
							   "FOREIGN KEY (LOCK_ID) REFERENCES LOCK(LOCK_ID)";
	  String sqlGuestLock = "CREATE TABLE GUEST_LOCK (" +
			  				"USER_ID int    NOT NULL ," + 
							"LOCK_ID int    NOT NULL ," +
							"FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)" +
	  						"FOREIGN KEY (LOCK_ID) REFERENCES LOCK(LOCK_ID))";
							   
      stmt.executeUpdate(sqlUser);
      stmt.executeUpdate(sqlProperty);
      stmt.executeUpdate(sqlLock);
      stmt.executeUpdate(sqlLockActivity);
      stmt.executeUpdate(sqlGuestLock);
      System.out.println("Database created successfully...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
   
   public static String createUser(User user) {
	   String query = "INSERT INTO USER " + 
			   		"VALUES(" + user.getUserId() + "," +
			   		user.getName() + "," +
			   		user.getPrimaryPhoneNumber() + "," +
			   		user.getIsMobileVerified() + "," + 
			   		user.getCountry() + "," +
			   		user.getPassword() + "," +
			   		user.getUserState() + ","  +
			   		user.getDataOfBirth() + "," +
			   		user.getGender() + "," +
			   		user.getEmailAddress() + "," +
			   		user.getZipCode() + "," +
			   		user.getIcon() + ")";
	   try {
		stmt.executeUpdate(query);
		return "success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "failure";
	}
   }
	public static String updateUser(User user) {
			String query = "UPDATE USER" + 
					"(SET NAME=" + user.getName() + "," +
					"IS_MOBILE_VERIFIED" + user.getIsMobileVerified() + "," +
					"COUNTRY" + user.getCountry() + "," +
					"DATE_OF_BIRTH" + user.getDataOfBirth() + "," +
					"GENDER" + user.getGender() + "," +
					"EMAIL_ADDRESS" + user.getEmailAddress() + "," +
					"ZIP_CODE" + user.getZipCode() + "," +
					"ICON" + user.getIcon() + 
					"WHERE PRIMARY_PHONE_NUMBER=" + user.getPrimaryPhoneNumber() + ")";
			 try {
					stmt.executeUpdate(query);
					return "success";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "failure";
				}
	}
 
	public static User readUser(User user) {
		String query = "SELECT * FROM USER " +
				"FROM USER" +
				"WHERE PRIMARY_PHONE_NUMBER=" + user.getPrimaryPhoneNumber() + ")";
		 try {
			 ResultSet rs = stmt.executeQuery(query);
			 User userInfo = new User();
			 while(rs.next()){ 
				 userInfo.setName(rs.getString("NAME"));
				 userInfo.setIsMobileVerified(rs.getString("IS_MOBILE_VERIFIED"));
				 userInfo.setCountry(rs.getString("COUNTRY"));
				 userInfo.setUserState(rs.getString("USER_STATE"));
				 userInfo.setDataOfBirth(rs.getString("DATE_OF_BIRTH"));
				 userInfo.setGender(rs.getString("GENDER"));
				 userInfo.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
				 userInfo.setZipCode(rs.getInt("ZIP_CODE"));
				 userInfo.setIcon(rs.getString("ICON"));
				 
			 }
			 rs.close();
			 return userInfo;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
		
	}
	public static String deleteUser(User user) {
		String query = "DELETE FROM USER" + 
						"WHERE PRIMARY_PHONE_NUMBER=" + user.getPrimaryPhoneNumber();
		try {
			stmt.executeUpdate(query);
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
	}

}
   
   
   
   
   
   
   
   
   
