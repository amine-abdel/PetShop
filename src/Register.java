

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
   if(request.getParameter("send") != null) {
	   String name=request.getParameter("name");
	String company=request.getParameter("company");
	String message=request.getParameter("message");
     String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		Contact con=new Contact(name,email,phone,company,message);
		Registerdata re=new Registerdata();

		    String resu=re.contact(con);
		   response.getWriter().print(resu);
		
   }else if(request.getParameter("register")!=null)
   {
	   String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String company=request.getParameter("company");
		String adress=request.getParameter("adress");

		Member member = new Member(uname,password,email,phone,company,adress);
		Registerdata rDao=new Registerdata();
		
		String result=rDao.insert(member);
		response.getWriter().print(result);
   }
   else if(request.getParameter("login")!=null)
   {
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		    String n=request.getParameter("uname");  
		    String p=request.getParameter("password");        
		    if(Registerdata.validate(n, p)){  
		    	  HttpSession session = request.getSession();

		          session.setAttribute("nom", n);
		          
		          this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		    	//out.println("<meta http-equiv='refresh' content='3;URL=index.jsp'>");//redirects after 3 seconds
		    	 
		    }  
		    else{  
		    	  
		        out.println("<script type=\"text/javascript\">");
		    	   out.println("alert('merci d'etre connecter');");
		    	   out.println("</script>");
		        out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("myaccount.jsp");  
		        rd.include(request,response);
		    }       
		    out.close(); 
   }  else if(request.getParameter("ordernow")!=null)
   {
	   HttpSession session = request.getSession(false);	
	   String nom=(String) session.getAttribute("nom");
	   int idproduits=Integer.parseInt( request.getParameter("idp"));
	  
	   int idclient=Registerdata.idclient(nom);
	 
	   int prix=Integer.parseInt(request.getParameter("prix"))*Integer.parseInt(request.getParameter("quantite"));
	   int quantite=Integer.parseInt(request.getParameter("quantite"));
	   String image=request.getParameter("hidden");
	   long millis=System.currentTimeMillis();  
       java.sql.Date date=new java.sql.Date(millis);  
	   Panier panier = new Panier(idclient,idproduits, date,prix,quantite,image);
		Registerdata rDao=new Registerdata();
		
		String result=rDao.insertpanier(panier);
		 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
	        rd.forward(request,response);
		   
   }
   else if(request.getParameter("checkout")!=null)
   {
	   HttpSession session = request.getSession(false);	
	   String nom=(String) session.getAttribute("nom");
        Registerdata.panier(nom);
		 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
	        rd.include(request,response);
		   
   }
   }
}
