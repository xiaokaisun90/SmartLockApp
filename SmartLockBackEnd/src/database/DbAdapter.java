package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
					   
      
      String sqlProperty =" CREATE TABLE PROPERTY (" +
			    		   "PROPERTY_ID int    NOT NULL, " +
			    		   "USER_ID int		NOT NULL" +
			    		   "DESCRIPTION varchar()    NOT NULL ," +
			    		   "ADDRESS varchar()    NOT NULL ," +
			    		   "CITY varchar()    NOT NULL ," +
			    		   "ZIP_CODE int    NOT NULL ," +
			    		   "STATE varchar()    NOT NULL ," +
			    		   "COUNTRY varchar()    NOT NULL ," +
			    		   "OWNERSHIP varchar()    NOT NULL), " +
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
					"IS_MOBILE_VERIFIED=" + user.getIsMobileVerified() + "," +
					"COUNTRY=" + user.getCountry() + "," +
					"DATE_OF_BIRTH=" + user.getDataOfBirth() + "," +
					"GENDER=" + user.getGender() + "," +
					"EMAIL_ADDRESS=" + user.getEmailAddress() + "," +
					"ZIP_CODE=" + user.getZipCode() + "," +
					"ICON=" + user.getIcon() + 
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

	public static String createProperty(Property property) {
		   String query = "INSERT INTO PROPERTY " + 
				   		"VALUES(" + property.getPropertyId() + "," +
				   		property.getUserId() + "," +
				   		property.getDescription() + "," +
				   		property.getAddress() + "," + 
				   		property.getCity() + "," +
				   		property.getZipCode() + "," +
				   		property.getState()+ ","  +
				   		property.getCountry() + "," +
				   		property.getOwnership()+ ")";
		   try {
			stmt.executeUpdate(query);
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
	}
	
	public static String updateProperty(Property property) {
		String query = "UPDATE PROPERTY" + 
				"(SET USER_ID=" + property.getUserId() + "," +
				"DESCRIPTION=" + property.getDescription() + "," +
				"ADDRESS=" + property.getAddress() + "," +
				"CITY=" + property.getCity() + "," +
				"ZIP_CODE=" + property.getZipCode() + "," +
				"STATE=" + property.getState() + "," +
				"COUNTRY=" + property.getCountry() + "," +
				"OWNERSHIP=" + property.getOwnership() + 
				"WHERE PROPERTY_ID=" + property.getPropertyId() + ")";
		 try {
				stmt.executeUpdate(query);
				return "success";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "failure";
			}
	}
	
public static Property readProperty(Property property) {
		String query = "SELECT * FROM USER " +
				"WHERE PROPERTY_ID=" + property.getPropertyId() + ")";
		 try {
			 ResultSet rs = stmt.executeQuery(query);
			 Property propertyInfo = new Property();
			 while(rs.next()){ 
				 propertyInfo.setUserId(rs.getInt("USER_ID"));
				 propertyInfo.setDescription(rs.getString("DESCRIPTION"));
				 propertyInfo.setAddress(rs.getString("ADDRESS"));
				 propertyInfo.setCity(rs.getString("CITY"));
				 propertyInfo.setZipCode(rs.getInt("ZIP_CODE"));
				 propertyInfo.setState(rs.getString("STATE"));
				 propertyInfo.setCountry(rs.getString("COUNTRY"));
				 propertyInfo.setOwnership(rs.getString("OWNERSHIP"));
			 }
			 rs.close();
			 return propertyInfo;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	
public static String deleteProperty(Property property) {
	String query = "DELETE FROM PROPERTY" + 
					"WHERE PROPERTY_ID=" + property.getPropertyId();
	try {
		stmt.executeUpdate(query);
		return "success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "failure";
	}
}
public static String createLock(Lock lock) {
	   String query = "INSERT INTO LOCK " + 
			   		"VALUES(" + lock.getLockId() + "," +
			   		lock.getDescription()+ "," +
//			   		lock.getIsLocked+ "," +
			   		lock.getLockPower() + "," + 
			   		lock.getLockStartAngle()+ "," +
			   		lock.getLockEndAngle() + "," +
			   		lock.getRotationDirection()+ ","  +
			   		lock.getRotationEndPoints() + ")";
	   try {
		stmt.executeUpdate(query);
		return "success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "failure";
		}
	}
public static String updateLock(Lock lock) {
	String query = "UPDATE LOCK" + 
			"(SET DESCRIPTION=" + lock.getDescription() + "," +
			"IS_LOCKED=" + lock.isLocked() + "," +
			"LOCK_POWER=" + lock.getLockPower() + "," +
			"LOCK_START_ANGLE=" + lock.getLockStartAngle() + "," +
			"LOCK_END_ANGLE=" + lock.getLockEndAngle() + "," +
			"ROTATION_DIRECTION=" + lock.getRotationDirection() + "," +
			"ROTATION_END_POINTS=" + lock.getRotationEndPoints() + 
			"WHERE LOCK_ID=" + lock.getLockId() + ")";
	 try {
			stmt.executeUpdate(query);
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
}

public static Lock readLock(Lock lock) {
	String query = "SELECT * FROM LOCK" + 
				"WHERE LOCK_ID =" + lock.getLockId() + ")";
	 try {
		 ResultSet rs = stmt.executeQuery(query);
		 Lock lockInfo = new Lock();
		 while(rs.next()){ 
			lockInfo.setLockId(rs.getInt("LOCK_ID"));
			lockInfo.setDescription(rs.getString("DESCRIPTION"));
			lockInfo.setIsLocked(rs.getBoolean("IS_LOCKED"));
			lockInfo.setLockPower(rs.getDouble("LOCK_POWER"));
			lockInfo.setLockStartAngle(rs.getDouble("LOCK_START_ANGLE"));
			lockInfo.setLockEndAngle(rs.getDouble("LOCK_END_ANGLE"));
			lockInfo.setRotationDirection(rs.getString("ROTATION_DIRECTION"));
			lockInfo.setRotationEndPoints(rs.getDouble("ROTATION_END_POINTS"));
		 }
		 rs.close();
		 return lockInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
}
public static String deleteLock(Lock lock) {
	String query = "DELETE FROM LOCK" + 
					"WHERE LOCK_ID=" + lock.getLockId();
	try {
		stmt.executeUpdate(query);
		return "success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "failure";
	}
}
public static String createLockActivity(LockActivity lockActivity) {
	   String query = "INSERT INTO LOCK_ACTIVITY " + 
			   		"VALUES(" + lockActivity.getLockId() + "," +
			   		lockActivity.getGuestId()+ "," +
			   		lockActivity.getHostId()+ "," +
			   		lockActivity.getAccessStartTime() + "," + 
			   		lockActivity.getAccessEndTime()+ "," +
			   		lockActivity.getRequestAccessTimestamp() + "," +
			   		lockActivity.isRequestStatus()+ ","  +
			   		lockActivity.getAlert() + ")";
	   try {
		stmt.executeUpdate(query);
		return "success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "failure";
		}
	}
public static String updateLockActivity(LockActivity lockActivity) {
	String query = "UPDATE LOCK_ACTIVITY" + 
			"(SET GUEST_ID=" + lockActivity.getGuestId() + "," +
			"HOST_ID=" + lockActivity.getHostId() + "," +
			"ACCESS_START_TIME=" + lockActivity.getAccessStartTime() + "," +
			"ACCESS_END_TIME=" + lockActivity.getAccessEndTime() + "," +
			"REQUEST_ACCESS_TIMESTAMP=" + lockActivity.getRequestAccessTimestamp() + "," +
			"REQUEST_STATUS=" + lockActivity.isRequestStatus() + 
			"ALERT=" + lockActivity.getAlert() + 
			"WHERE LOCK_ID=" + lockActivity.getLockId() + ")";
	 try {
			stmt.executeUpdate(query);
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
}
public static LockActivity readLockActivity(LockActivity lockActivity) {
	String query = "SELECT * FROM LOCK_ACTIVITY" + 
				"WHERE LOCK_ID =" + lockActivity.getLockId() + ")";
	 try {
		 ResultSet rs = stmt.executeQuery(query);
		 LockActivity lockActivityInfo = new LockActivity();
		 while(rs.next()){ 
			 lockActivityInfo.setLockId(rs.getInt("LOCK_ID"));
			 lockActivityInfo.setGuestId(rs.getInt("GUEST_ID"));
			 lockActivityInfo.setHostId(rs.getInt("HOST_ID"));
			 lockActivityInfo.setAccessStartTime(rs.getString("ACCESS_START_TIME"));
			 lockActivityInfo.setAccessEndTime(rs.getString("ACCESS_END_TIME"));
			 lockActivityInfo.setRequestAccessTimestamp(rs.getString("REQUEST_ACCESS_TIMESTAMP"));
			 lockActivityInfo.setRequestStatus(rs.getBoolean("REQUEST_STATUS"));
			 lockActivityInfo.setAlert(rs.getInt("ALERT"));
		 }
		 rs.close();
		 return lockActivityInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
}
public static String deleteLockActivity(LockActivity lockActivity) {
	String query = "DELETE FROM LOCK_ACTIVITY" + 
					"WHERE LOCK_ID=" + lockActivity.getLockId();
	try {
		stmt.executeUpdate(query);
		return "success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "failure";
	}
}
public static String createGuestLock(User user, Lock lock) {
	   String query = "INSERT INTO GUEST_LOCK " + 
			   		"VALUES(" + user.getUserId() + "," +
			   		lock.getLockId() + ")";
	   try {
		stmt.executeUpdate(query);
		return "success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "failure";
		}
	}
public static String updateGuestLock(User user, Lock lock)  {
	return null;
}
public static List<Lock> readGuestLock(User user) {
	String query = "SELECT * FROM GUEST_LOCK" + 
			"WHERE USER_ID =" + user.getUserId() + ")";
 try {
	 ResultSet rs = stmt.executeQuery(query);
	 List<Lock> lockList = new ArrayList<Lock>();
	 while(rs.next()){ 
		Lock lockInfo = new Lock();
		lockInfo.setLockId(rs.getInt("LOCK_ID"));
		lockList.add(lockInfo);
	 }
	 rs.close();
	 return lockList;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
public static List<User> readGuestLock(Lock lock) {
	String query = "SELECT * FROM GUEST_LOCK" + 
			"WHERE LOCK_ID =" + lock.getLockId() + ")";
 try {
	 ResultSet rs = stmt.executeQuery(query);
	 List<User> userList = new ArrayList<User>();
	 while(rs.next()){ 
		User userInfo = new User();
		userInfo.setUserId(rs.getInt("USER_ID"));
		userList.add(userInfo);
	 }
	 rs.close();
	 return userList;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
public static String deleteGuestLock(Lock lock) {
	String query = "DELETE FROM GUEST_LOCK" + 
					"WHERE LOCK_ID=" + lock.getLockId();
	try {
		stmt.executeUpdate(query);
		return "success";
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "failure";
	}
}
public static String deleteGuestLock(User user) {
	String query = "DELETE FROM GUEST_LOCK" + 
					"WHERE USER_ID=" + user.getUserId();
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
   
   
   
   
   
   
   
   
