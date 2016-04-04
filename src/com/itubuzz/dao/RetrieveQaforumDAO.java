package com.itubuzz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itubuzz.valueobjects.*;

public class RetrieveQaforumDAO {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<QuestionVO> retrieveQueData(){
		
	    Connection conn = null;  
	    PreparedStatement ps = null;  
	    ResultSet rs = null;

	    
	    final String DB_URL="jdbc:mysql://127.0.0.1:3306/itubuzz"; 
	    String driver = "com.mysql.jdbc.Driver";  
	    String userName = "root";  
	    String password = "root"; 
	    ArrayList<QuestionVO> q_list = new ArrayList<QuestionVO>();
	    
	    try {  
	        Class.forName(driver).newInstance();  
	        conn = DriverManager  
	                .getConnection(DB_URL, userName, password);  

	        ps=conn.prepareStatement(  
	        		"select * from questions order by question_id desc");  
	        		
	        rs = ps.executeQuery();
	       
	        while(rs.next())
	        {
	            QuestionVO q = new QuestionVO();
	            
	            q.question_id = rs.getInt(1);
	            q.question_text = rs.getString(2);
	            q.log_user_id=rs.getInt(3);
	                              
	            q_list.add(q);	        
	        }
	        
	    } catch (Exception e) {  
	        System.out.println(e);
	        
	    } finally {  
	        if (conn != null) {  
	            try {  
	                conn.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if (ps != null) {  
	            try {  
	                ps.close();  
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
	    return q_list;
	}

	public static QuestionVO retrieveQueData(String question_text){
		
	    Connection conn = null;
	    PreparedStatement ps = null;  
	    ResultSet rs = null;
	    QuestionVO q = new QuestionVO();
	    
	    final String DB_URL="jdbc:mysql://127.0.0.1:3306/itubuzz"; 
	    String driver = "com.mysql.jdbc.Driver";  
	    String userName = "root";  
	    String password = "root";
	    
	    try {  
	        Class.forName(driver).newInstance();  
	        conn = DriverManager  
	                .getConnection(DB_URL, userName, password);  

	        ps=conn.prepareStatement(  
	        		"select * from questions where question_text=?");
	        
	        ps.setString(1, question_text);		
	        rs = ps.executeQuery();
	       
	        while(rs.next())
	        {
	            q.question_id = rs.getInt(1);
	            q.question_text = rs.getString(2);
	            q.log_user_id=rs.getInt(3);             
	        }
	        
	    } catch (Exception e) {  
	        System.out.println(e);
	        
	    } finally {  
	        if (conn != null) {  
	            try {  
	                conn.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if (ps != null) {  
	            try {  
	                ps.close();  
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
	    return q;
	}

	public static QuestionVO retrieveQueData(int question_id){
		
	    Connection conn = null;
	    PreparedStatement ps = null;  
	    ResultSet rs = null;
	    QuestionVO q = new QuestionVO();
	    
	    final String DB_URL="jdbc:mysql://127.0.0.1:3306/itubuzz"; 
	    String driver = "com.mysql.jdbc.Driver";  
	    String userName = "root";  
	    String password = "root";
	    
	    try {  
	        Class.forName(driver).newInstance();  
	        conn = DriverManager  
	                .getConnection(DB_URL, userName, password);  

	        ps=conn.prepareStatement(  
	        		"select * from questions where question_id=?");
	        
	        ps.setInt(1, question_id);
	        rs = ps.executeQuery();
	       
	        while(rs.next())
	        {
	            q.question_id = rs.getInt(1);
	            q.question_text = rs.getString(2);
	            q.log_user_id=rs.getInt(3);             
	        }
	        
	    } catch (Exception e) {  
	        System.out.println(e);
	        
	    } finally {  
	        if (conn != null) {  
	            try {  
	                conn.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if (ps != null) {  
	            try {  
	                ps.close();  
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
	    return q;
	}

	public static ArrayList<AnswerVO> retrieveAnsData(){
		
	    Connection conn = null;  	
	    PreparedStatement ps = null;  
	    ResultSet rs = null;
	    
	    final String DB_URL="jdbc:mysql://127.0.0.1:3306/itubuzz"; 
	    String driver = "com.mysql.jdbc.Driver";  
	    String userName = "root";  
	    String password = "root"; 
	    ArrayList<AnswerVO> a_list = new ArrayList<AnswerVO>();
	    
	    try {  
	        Class.forName(driver).newInstance();  
	        conn = DriverManager  
	                .getConnection(DB_URL, userName, password);  

	        ps=conn.prepareStatement(  
		        		"select * from answers order by question_id desc, answer_id" );
	            
	        rs = ps.executeQuery();
	        
	            while(rs.next())
	            {
	            	AnswerVO a = new AnswerVO();
	            	
	            	a.answer_id = rs.getLong(1);
	            	a.answer_text = rs.getString(2);
	            	a.immparent_id = rs.getLong(3);
	            	a.question_id = rs.getInt(4);
	            	a.log_user_id = rs.getInt(5);
	            		            	
	            	a_list.add(a);
	            }
	                        	       	        
	    } catch (Exception e) {  
	        System.out.println(e);
	        
	    } finally {  
	        if (conn != null) {  
	            try {  
	                conn.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if (ps != null) {  
	            try {  
	                ps.close();  
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
	    return a_list;
	}
	
	public static ArrayList<AnswerVO> retrieveAnstoQueData(int question_id){
		
	    Connection conn = null;  	
	    PreparedStatement ps = null;  
	    ResultSet rs = null;
	    
	    final String DB_URL="jdbc:mysql://127.0.0.1:3306/itubuzz"; 
	    String driver = "com.mysql.jdbc.Driver";  
	    String userName = "root";  
	    String password = "root"; 
	    ArrayList<AnswerVO> a_list = new ArrayList<AnswerVO>();
	    
	    try {  
	        Class.forName(driver).newInstance();  
	        conn = DriverManager  
	                .getConnection(DB_URL, userName, password);  

	        ps=conn.prepareStatement(  
		        		"select * from answers where question_id=? order by answer_id" );
	        
	        ps.setInt(1, question_id);    
	        rs = ps.executeQuery();
	        
	            while(rs.next())
	            {
	            	AnswerVO a = new AnswerVO();
	            	
	            	a.answer_id = rs.getLong(1);
	            	a.answer_text = rs.getString(2);
	            	a.immparent_id = rs.getLong(3);
	            	a.question_id = rs.getInt(4);
	            	a.log_user_id = rs.getInt(5);
	            		            	
	            	a_list.add(a);
	            }
	                        	       	        
	    } catch (Exception e) {  
	        System.out.println(e);
	        
	    } finally {  
	        if (conn != null) {  
	            try {  
	                conn.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        if (ps != null) {  
	            try {  
	                ps.close();  
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
	    return a_list;
	}

}