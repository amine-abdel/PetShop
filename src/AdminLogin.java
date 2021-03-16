

import java.io.IOException;

import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.connection.MysqlConnection;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected MysqlConnection sql;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        sql = new MysqlConnection();
        // TODO Auto-generated constructor stub
    }

    private ServletConfig config;
    
    public void init(ServletConfig config)
    throws ServletException{
  // this.config=config;
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
			
		
		  // "configuration" de la connexion à la base de donnée
		  
		 boolean log =false;
		  String username=request.getParameter("username");
		  String password=request.getParameter("password");
		  //variable locale pour le username et le password
		  String usrnm=new String("");
		  String pswd=new String("");
		
		  try {
		
		  // on récupére username et password dans la BDD
		   
		   
		   
		   
		   
			  this.sql.stmt=this.sql.con.createStatement();
			ResultSet rs=this.sql.stmt.executeQuery("SELECT username, password FROM admins");  
		   
		  
		 
		
		  
		  while (rs.next ()){
		  usrnm=rs.getString("username");
		  pswd=rs.getString("password");
		  if(usrnm.equals(username) && pswd.equals(password)){
			     
//			  request.getSession().setAttribute("username", usrnm);
			 
			  request.getSession().setAttribute("username", usrnm);
			  
			  log=true;
			 
		
     	  response.sendRedirect("/PetShop_WebProjet/dashboard/index.jsp");
			   break;
			  }
		  response.sendRedirect("/PetShop_WebProjet/login/loging.jsp");
		  }
		  rs.close ();
		 

		  }catch(Exception e){
		  System.out.println("Exception is ;"+e);
		  }
		  }
		  
		
		
	

}
