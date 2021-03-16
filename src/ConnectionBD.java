import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnectionBD {
	 public Connection con;
	 public Statement stmt;
	 public ResultSet rs;
	 
	 public ConnectionBD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  
		this.con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/petshop?serverTimezone=UTC","root","toor");  
		//here sonoo is database name, root is username and password  
		this.stmt=con.createStatement();  
	 }
		
		public void Insert(HttpServletRequest request, HttpServletResponse response) throws SQLException {
			this.rs=stmt.executeQuery("INSERT INTO `petshop`.`produits` (`nomdeproduit`, `description`, `prix`, `categories`, `quantité`, `visible`, `ajouter_le`) VALUES ('"+request.getParameter("Nproduit")+"', '"+request.getParameter("description")+"', '"+request.getParameter("prix")+"', '"+request.getParameter("categories")+"', '"+request.getParameter("quantite")+"', '"+request.getParameter("is_visible")+"', '"+request.getParameter("date")+"');");  

		}
		public void delet(HttpServletRequest request, HttpServletResponse response) throws SQLException {
			System.out.println();
			this.rs=stmt.executeQuery("UPDATE `petshop`.`produits` SET `nomdeproduit` = 'haloo' WHERE (`nomdeproduit` = '2');");  

		}
		
		public void closeConnection() throws SQLException {
			con.close();

		}
	
}
