package com.itubuzz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;


public class RegisterUserDAO {
	
	

	private static ResultSet rs;

	public static boolean enterUserCredentials( String firstName, String middleName,
			 String lastName, String newPassword,
			String eMailId, String dob, String dept, String trimester, String yop,
			 String role ) throws ParseException {
		// TODO Auto-generated method stub
		    
		    java.sql.Date sqlDateDob = null;
    		java.sql.Date sqlDateYop = null;
    		if(!(dob.equalsIgnoreCase("0000-00-00"))){
            sqlDateDob = java.sql.Date.valueOf(dob);
    		}
    		if(!(yop.equalsIgnoreCase("0000-00-01"))){
    		sqlDateYop = java.sql.Date.valueOf(yop);
    		}
		    
		    boolean status = false;
		    Connection conn = null;  
	        PreparedStatement pst = null;  
	        rs = null;  
	  
	        final String DB_URL="jdbc:mysql://127.0.0.1:3306/itubuzz"; 
	        String driver = "com.mysql.jdbc.Driver";  
	        String userName = "root";  
	        String password = "root";  
	        try {  
	            Class.forName(driver).newInstance();  
	            conn = DriverManager  
	                    .getConnection(DB_URL, userName, password);  
	            
	            	    if(firstName != null && lastName != null && newPassword != null && eMailId != null && dept != null && trimester != null && role != null){
	            PreparedStatement ps=conn.prepareStatement(  
	            		"insert into userLogin(first_name, middle_name, last_name, password, e_mail_id, date_of_birth, department, trimester, year_of_passing, user_type) values(?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);  
	            		
	            		
	            		ps.setString(1,firstName);
	            		ps.setString(2, middleName);
	            		ps.setString(3, lastName);
	            		ps.setString(4, newPassword);
	            		ps.setString(5,eMailId);
						ps.setDate(6, sqlDateDob);
	            		ps.setString(7, dept);
	            		ps.setString(8, trimester);
						ps.setDate(9, sqlDateYop);
	            		ps.setString(10, role);
	            		
	            		ps.executeUpdate(); 
	            		
	            		
	            		rs = ps.getGeneratedKeys();
	                     if(rs != null && rs.next()){
	                         System.out.println("Generated user Id: "+rs.getInt(1));
	                         status = true;
	                     }
	                     
	        
	            	    }  
	            	    else{
	            	    	status = false;
	            	    }
		
	}
	        catch (Exception e) {  
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
	        return status;  
	} 

}