package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public abstract class User {
	protected String email;
	protected String pwd;
	protected String type;
	
	public User(String e, String pwd, String t) {
		email=e;
		this.pwd=pwd;
		type=t;
	}
	
	public boolean AuthenticateUser(String e, String p) {
		 try
	        {
	            Class.forName("java.sql.DriverManager");
	            Connection con=(Connection) DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/project","root","tapeied");
	            Statement stmt=(Statement) con.createStatement();
	            String q="Select password from users where email='"+e+"';";
	            ResultSet rs=stmt.executeQuery(q);
	            if(rs.next())
	            {
	            	System.out.println(p);
	            	System.out.println(rs.getString("password"));
	            	if(p.equals(rs.getString("password")))
	            	{
	            		return true;
	            	}
	            }
	           
	        }
	        catch(Exception exp)
	        {
	        	System.out.println(exp.getMessage());
	        }
		 return false;
	}
	
	public abstract ResultSet ViewRoomBookings();

}