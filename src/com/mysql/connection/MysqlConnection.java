package com.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MysqlConnection
{
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	public  Connection con;
	public  Statement stmt;
	public  PreparedStatement ps;

	
	public MysqlConnection() 
	{
		try
		{ 
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/petshop","root","latitudee7440");  
		}
		catch (Exception e)
		{
			
			
		}
	}
	
	public void select() throws SQLException
	{
//		this.stmt=this.con.createStatement();
		ResultSet rs=this.con.createStatement().executeQuery("select * from produits");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	}
	public void login() {
//		 Connection connection=null;
		 boolean log =false;
		  String username="user";
		  String password="ump";
		  //variable locale pour le username et le password
		  String usrnm=new String("");
		  String pswd=new String("");
		
		  try {
		
		  // on récupére username et password dans la BDD
		   
		   
		   
		   
		   
			  this.stmt=this.con.createStatement();
			ResultSet rs=this.stmt.executeQuery("SELECT username, password FROM admins");  
		   
		  
		 
		
		  
		  while (rs.next ()){
		  usrnm=rs.getString("username");
		  pswd=rs.getString("password");
		  if(usrnm.equals(username) && pswd.equals(password)){
			     
//			  request.getSession().setAttribute("username", usrnm);
			  System.out.println("login ok");
			  log=true;
			   break;
			  }
			  
		  }
		  rs.close ();
		  if(log==false)System.out.println("login nok");

		  }catch(Exception e){
		  System.out.println("Exception is ;"+e);
		  }
		  //on compare les usernames et password entrer avec ceux de la ba BDD
		  
		  }
	public double getEarnningMonthly() throws SQLException 
	{		
		double a=0;
		ResultSet rs=this.con.createStatement().executeQuery("SELECT SUM(prix) FROM produits;");
		while(rs.next()) { 
			a= rs.getDouble(1);
		}
		return a;
		
	}
	
	public int getTotalProducts() throws SQLException 
	{		
		int a=0;
//		this.stmt=this.con.createStatement();
//		ResultSet rs=;
//		System.out.println(rs.getDouble(1));
		ResultSet rs=this.con.createStatement().executeQuery("SELECT COUNT(*) FROM produits;");
		while(rs.next()) { 
			a= rs.getInt(1);
		}
		return a;
		
		
	}
	
	public int getTotalMessages() throws SQLException 
	{		
		int a=0;
//		this.stmt=this.con.createStatement();
//		ResultSet rs=;
//		System.out.println(rs.getDouble(1));
		ResultSet rs=this.con.createStatement().executeQuery("SELECT COUNT(*) FROM avis_clients;");
		while(rs.next()) { 
			a= rs.getInt(1);
		}
		return a;
		
		
	}
	
	public double getEarnningAnnualy() throws SQLException 
	{		
		this.stmt=this.con.createStatement();
		ResultSet rs=this.stmt.executeQuery("SELECT SUM(prix) FROM produits ");
		return rs.getFloat(1);
	}
	public void ConnectToDataBase()
	{  
		
//			stmt=con.createStatement();  
//			
//			ResultSet rs=stmt.executeQuery("select * from produits");  
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
			
			
//			ps=con.prepareStatement("INSERT INTO `petshop`.`produits` (`nomdeproduit`, `description`, `prix`, `categories`, `quantité`, `visible`, `ajouter_le`) VALUES ('produit1','description1','45','ettest','15','1','01-01-2020');");
//			ps.executeUpdate();
		
//		catch(Exception e)
//		{ 
//			System.out.println(e);
//		}  
	}
	
	public static void insertprodect(HttpServletRequest request, HttpServletResponse response,PreparedStatement ps,Connection con) throws SQLException 
	{
		//rs=stmt.executeQuery("INSERT INTO `petshop`.`produits` (`nomdeproduit`, `description`, `prix`, `categories`, `quantité`, `visible`, `ajouter_le`) VALUES ('"+request.getParameter("Nproduit")+"', '"+request.getParameter("description")+"', '"+request.getParameter("prix")+"', '"+request.getParameter("categories")+"', '"+request.getParameter("quantite")+"', '"+request.getParameter("is_visible")+"', '"+request.getParameter("date")+"');");  
		ps=con.prepareStatement("INSERT INTO `petshop`.`produits` (`nomdeproduit`, `description`, `prix`, `categories`, `quantité`, `visible`, `ajouter_le`) VALUES ('produit1','description1','45','ettest','15','1','01-01-2020');");

//		 ps.setString(1,request.getParameter("Nproduit"));
//		 ps.setString(2,request.getParameter("description"));
//		 ps.setString(3,request.getParameter("prix"));
//		 ps.setString(4,request.getParameter("categories"));
//		 ps.setString(5,request.getParameter("quantite"));
//		 ps.setString(5,request.getParameter("is_visible"));
//		 ps.setString(5,request.getParameter("date"));
		 ps.executeUpdate();
		 
	}
	

	
	public void insert() throws SQLException 
	{
		this.ps=this.con.prepareStatement("INSERT INTO `petshop`.`produits` (`nomdeproduit`, `description`, `prix`, `categories`, `quantité`, `visible`, `ajouter_le`) VALUES ('produit1','description1','45','ettest','15','1','2020-06-01 00:00:00');");
		this.ps=this.con.prepareStatement("INSERT INTO `petshop`.`images` ( `image_url`, `idproduit`,`color`) VALUES ('produit1','description1','45','ettest','15','1','2020-06-01 00:00:00');");
		this.ps.executeUpdate();
	}
	
	public void update() throws SQLException 
	{
		this.ps=this.con.prepareStatement("UPDATE `petshop`.`produits` SET `image_url` = 'hfj', `idproduit` = '14',`color`='red' WHERE (`idproduits` = '3');");
		this.ps.executeUpdate();
	}
	
	public void close(Connection con) throws SQLException
	{
		con.close();  
	}
	
	public static void main(String[] args) throws SQLException {
		MysqlConnection sql = new MysqlConnection();
		sql.ConnectToDataBase();
		sql.select();
		System.out.println(sql.getTotalProducts());
		System.out.println(sql.getEarnningMonthly());
		
	}
	
	private String generateQuery(HttpServletRequest request)
	{	
		return (!request.getParameter("Nproduit").isEmpty()?"`Nproduit`='"+request.getParameter("Nproduit")+"'":"");
	}
}
