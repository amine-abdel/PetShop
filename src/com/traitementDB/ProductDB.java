package com.traitementDB;
import java.sql.*; 

import com.module.Products;



public class ProductDB {
	

public static int AddProducts(Products produit) throws ClassNotFoundException{
	int result=0,result1 =0;
	String INSERT_Producs="INSERT INTO produits"+"(nomdeproduit,description,prix,categories,quantité,visible,ajouter_le)VALUES"+"(?,?,?,?,?,1,?)";
	
	try{  
  	Class.forName("com.mysql.jdbc.Driver");
		
		String dir="images\\";
		Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/petshop","root","latitudee7440"); 
		//creqte statement using connection object
		PreparedStatement stmnt=con.prepareStatement(INSERT_Producs);
			
		stmnt.setString(1,produit.getProductName());
		stmnt.setString(2,produit.getDescription());
		stmnt.setFloat(3,produit.getPrix());
		stmnt.setString(4,produit.getCategory());
		stmnt.setInt(5,produit.getQuantity());
		//stmnt.setBoolean(6,produit.is_Visible());
		stmnt.setString(6,produit.getAjouter_Le());
		System.out.println("PreparedStatement:->"+stmnt);
		 //execute statement
		result=stmnt.executeUpdate();
		String INSERT_Producs_images="INSERT INTO images"+"(image_url,idproduits,color,visible)VALUES"+"(?,"+prodUctID(produit, con)+",\"blue\",1),"+"(?,"+prodUctID(produit, con)+",\"jaun\",0),"+"(?,"+prodUctID(produit, con)+",\"vert\",0)";
		PreparedStatement Istmnt=con.prepareStatement(INSERT_Producs_images);
		Istmnt.setString(1,dir+produit.getImage1());
		Istmnt.setString(2,dir+produit.getImage2());
		Istmnt.setString(3,dir+produit.getImage3());
		result1=Istmnt.executeUpdate();
		
		con.close();  
		}catch(SQLException e){ System.out.println(e+"ERROR"+result1);}  
		

	
	return result*result1;
}
public static int UpdateProducts(Products produit) throws ClassNotFoundException{
	String UPDATE_Producs="UPDATE products SET produit_N=? WHERE id=1";
	int result =0;
	try{  
  	Class.forName("com.mysql.jdbc.Driver");
		
		 
		java.sql.Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/magbuy","root","latitudee7440");  
		//creqte statement using connection object
		PreparedStatement stmnt=con.prepareStatement(UPDATE_Producs);
		stmnt.setString(1,produit.getProductName());
		System.out.println("HHHhHHH"+stmnt);
		 //execute statement
		result=stmnt.executeUpdate();
	
		con.close();  
		}catch(SQLException e){ System.out.println(e+"takhwira");}  
		

	
	return result;
}
public static int prodUctID(Products produit,Connection con) throws ClassNotFoundException{
	String SelectID="SELECT idproduits FROM produits WHERE nomdeproduit=\""+produit.getProductName()+"\"";
	int r=0;
	try {
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery( SelectID);
		rs.next();
		 r= rs.getInt(1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	return r;
	
}
public static int DeleteProducts(Products produit) throws ClassNotFoundException{
	String UPDATE_Producs="DELETE FROM produits WHERE nomdeproduit=?";
	int result=0 ;
	try{  
  	Class.forName("com.mysql.jdbc.Driver");
		
		 
		java.sql.Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/petshop","root","latitudee7440");  
		//creqte statement using connection object
		PreparedStatement stmnt=con.prepareStatement(UPDATE_Producs);
		stmnt.setString(1,produit.getProductName());
		System.out.println("HHHhHHH"+stmnt);
		 //execute statement
		result=stmnt.executeUpdate();
		System.out.println("fffffffffffffffffffppppppppppppppppppppppp");
		con.close();  
		}catch(SQLException e){ System.out.println(e+"takhwira");}  
		

	
	return result;
}
	
	

}
