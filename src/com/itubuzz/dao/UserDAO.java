package com.itubuzz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


/**
This class contains all the Data access related methods related to User Login information
**/
public class UserDAO {

	
	public static List<Integer> retrieveUserIdsByEmailIds(String members){
		
	        Connection conn = null;  
	        PreparedStatement pst = null;  
	        ResultSet rs = null; 
	        List<Integer> userIds = new ArrayList<Integer>();
	  
	        final String DB_URL="jdbc:mysql://127.0.0.1:3306/itubuzz"; 
	        String driver = "com.mysql.jdbc.Driver";  
	        String userName = "root";  
	        String password = "root";  
	        try {  
	            Class.forName(driver).newInstance();  
	            conn = DriverManager  
	                    .getConnection(DB_URL, userName, password);  
	  
	            pst = conn  
	                    .prepareStatement("select user_id from userLogin where e_mail_id =? ");  
	            pst.setString(1, members);  
	            rs = pst.executeQuery();
	            while(rs.next()){
	            	 userIds.add(rs.getInt(1));
	            }
	        }catch (Exception e) {  
	            System.out.println(e);  
	        } finally {  
	            if (conn != null) {  
	                try {  
	                    conn.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (pst != null) {  
	                try {  
	                    pst.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (rs != null) {  
	                try {  
	                    rs.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	        return userIds;  
	    } 
		
	
	
}
