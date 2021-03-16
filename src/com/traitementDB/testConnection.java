package com.traitementDB;


import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.servlet.http.HttpServletResponse;

public   class testConnection {
	public static void test(){  
		try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		java.sql.Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/magbuy","root","latitudee7440");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from products");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		con.close();  
		}catch(Exception e){ System.out.println(e+"  takhwira");}  
		}  
	public static void AffichDB(HttpServletResponse response){  
		try{  
		
		Class.forName("com.mysql.cj.jdbc.Driver");  
		java.sql.Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/magbuy","root","latitudee7440");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from products");  
		
		PrintWriter outp=response.getWriter();
		while(rs.next()) { 
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"Affichage");  
		outp.println("   <tr>");
		 outp.println("   <td>"+rs.getInt(1)+"</td>");
		 outp.println("   <td>"+rs.getString(2)+"</td>");
		 outp.println("   <td>"+rs.getString(3)+"</td>");
		 outp.println("   <td>"+rs.getFloat(4)+"</td>");
		 outp.println("   <td>"+rs.getString(5)+"</td>");
		 outp.println("   <td>"+rs.getInt(6)+"</td>");
		 outp.println("   <td>"+rs.getString(7)+"</td>");
        outp.println("   </tr>");
        outp.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        
        
        }
		outp.close();
		con.close();  
		}catch(Exception e){ System.out.println(e+"  takhwira");}  
		} 
}
