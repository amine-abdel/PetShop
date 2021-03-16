import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.servlet.http.HttpSession;

//import com.mysql.cj.xdevapi.Statement;

public class Registerdata {

	private static String dtUrl="jdbc:mysql://localhost:3306/petshop";
	private static String dtUname="root";
	private static String dtPassword="latitudee7440";
	private static String dbDriver="com.mysql.cj.jdbc.Driver";
	static int c2;
	static int c;
	static int c3;
	static int id ;
	public static void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		Connection con=null;
		try {
			con= DriverManager.getConnection(dtUrl,dtUname,dtPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return con;
	}
       public String insert(Member member) {
		
		loadDriver(dbDriver);
		Connection con =getConnection();
		
		String result="the data entered successfully";
		String sql="insert into clients values(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,c);
			ps.setString(2,member.getUname());
			ps.setString(3,member.getPassword());
			ps.setString(4,member.getEmail());
			ps.setString(5,member.getPhone());
			ps.setString(6,member.getCompany());
			ps.setString(7,member.getAdress());
			ps.executeUpdate();
			c++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="data not entered";
		}
		
		return result;
	}
       
       public String insertpanier(Panier panier) {
   		
   		loadDriver(dbDriver);
   		Connection con =getConnection();
   		
   		String result="the data entered successfully";
   		String sql="insert into demands values(?,?,?,?,?,?,?)";
   		PreparedStatement ps;
   		try {
   			ps = con.prepareStatement(sql);
   			ps.setInt(1,c3);
   			ps.setInt(2,panier.getIdclient());
   			ps.setInt(3,panier.getIdproduit());
   			ps.setDate(4,(Date) panier.getDate_demand());
   			ps.setInt(5,panier.getQuantite());
   			ps.setInt(6,panier.getPrix());
   			ps.setString(7,panier.getImage());
   			ps.executeUpdate();
   			c3++;
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   			result="data not entered";
   		}
   		
   		return result;
   	}
    public static boolean validate(String name,String pass){ 

		   loadDriver(dbDriver);
    	   boolean status=false;  
    	   try{  
    			Connection con2=getConnection();
    	   PreparedStatement ps=con2.prepareStatement(  
    	   "select * from clients where nom=? and password=?");  
    	   ps.setString(1,name);  
    	   ps.setString(2,pass);  
    	         
    	   ResultSet rs=ps.executeQuery();  
    	   status=rs.next();  
    	             
    	   }catch(Exception e){System.out.println(e);}  
    	   return status;  
    	   }  
    
    public static int idclient(String n){ 
    	
		   loadDriver(dbDriver);
 	   boolean status=false;  
 	   
 	   try{  
 			Connection con2=getConnection();
 			 java.sql.Statement ps=con2.createStatement();
 			
	   ResultSet rs=ps.executeQuery("select idclients from clients where nom=\""+n+"\"");  
	   while(rs.next())
	   {
		  
		   id=rs.getInt(1);
	   }
      
 	  
 	   }catch(Exception e){System.out.println(e);}  
 	   return id;  
 	   }  
    
    public static void panier(String n){ 
    	
		   loadDriver(dbDriver);
	   boolean status=false;  
	   
	   try{  
			Connection con2=getConnection();
			 java.sql.Statement ps=con2.createStatement();
			
			 int i=ps.executeUpdate("DELETE FROM demands WHERE idclients=(select idclients from clients where nom=\""+n+"\")");
			
			 }
   
	  
	   catch(Exception e){System.out.println(e);}  
	   
	   } 
	public String contact(Contact con)
	{
		
		loadDriver(dbDriver);
		Connection con2=getConnection();
		String resultat="Data entered successfully";
		String sql="insert into contact values(?,?,?,?,?,?)";
		PreparedStatement ps;
			try {
				
			ps=con2.prepareStatement(sql);
			ps.setInt(1, c2);
			ps.setString(2,con.getName());
			ps.setString(3,con.getEmail());
			ps.setString(4,con.getPhone());
			ps.setString(5,con.getCompany());
			ps.setString(6,con.getMessage());
			ps.executeUpdate();
			
			c2++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultat="Data not enterred";
		}

		return resultat;
	}
	
}
