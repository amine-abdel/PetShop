package com.controller;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.traitementDB.ProductDB;
import com.module.Products;

/**
 * Servlet implementation class servelet
 */
@WebServlet("/servelet")
public class servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	this.getServletContext().getRequestDispatcher("/WEB-INF/ProductsViews.jsp").forward
//		  (request, response);
		 response.sendRedirect("/PetShop_WebProjet/dashboard/tables.jsp");
	
//		try{  
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");  
//			java.sql.Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/magbuy","root","latitudee7440");  
//			//here sonoo is database name, root is username and password  
//			Statement stmt=con.createStatement();  
//			ResultSet rs=stmt.executeQuery("select * from products"); 
//			
//			  
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println("DOGET");
//
//		response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter outp=response.getWriter();
//        outp.println("<!DOCTYPE html>");
//        outp.println("<html>");
//        outp.println("<head>");
//        outp.println("   <title>WEB_APP</title>");
//        outp.println("</head>");
//        outp.println("<body style='background-color:tomato'>");
//        outp.println("   <h1>Enregistrement de vos coordonnees</h1>");
//        outp.println("   <table id=\"customers\">");
//        outp.println("<tr> ");
//        outp.println(" <th>Company</th>");
//        outp.println("<th>Contact</th> ");
//        outp.println(" <th>Country</th> ");
//        outp.println("<th>Company</th> ");
//        outp.println("  <th>Contact</th> ");
//        outp.println(" <th>Country</th>");
//        outp.println(" <th>Country</th> ");
//        outp.println(" </tr>");
//        while(rs.next()) { 
//        	outp.println("   <tr>");
//            outp.println("   <td>"+rs.getInt(1)+"</td>");
//            outp.println("   <td>"+rs.getString(2)+"</td>");
//            outp.println("   <td>"+rs.getString(3)+"</td>");
//            outp.println("   <td>"+rs.getFloat(4)+"</td>");
//            outp.println("   <td>"+rs.getString(5)+"</td>");
//            outp.println("   <td>"+rs.getInt(6)+"</td>");
//            outp.println("   <td>"+rs.getString(7)+"</td>");
//            outp.println("   </tr>");
//        }
//        
//        outp.println("</body>");
//        outp.println("</html>");
//     
//		 
//	
//		
//        outp.close();
//		}catch(Exception e){ System.out.println(e+"  takhwira");}
			} 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		 String AddSubmit=request.getParameter("add");
		 String DeletSubmit=request.getParameter("delete");
		 Products p=new Products();
		 if ("add".equals(AddSubmit)){
		 String  ProductName=request.getParameter("Nproduit");
		 String  Description=request.getParameter("description");
		 
		 float   Prix=Float.parseFloat( request.getParameter("prix"));
		 String  Category=request.getParameter("categories");
		 int     Quantity=Integer.parseInt( request.getParameter("quantite"));
		// boolean  Is_Visible=Boolean.parseBoolean(request.getParameter("is_visible"));
		 String Ajouter_Le=request.getParameter("date");
		 String Image1=request.getParameter("img1");
		 String Image2=request.getParameter("img2");
		 String Image3=request.getParameter("img3");
		 System.out.println(Image1);
		 System.out.println(Image2);
		 System.out.println(Prix+":"+Quantity+":"+Description+":"+Category+":"+ProductName+":"+Ajouter_Le);
		HttpSession session=request.getSession();
		session.setAttribute("ses", ProductName);
	     p.setProductName(ProductName);
	     p.setDescription(Description);
	     p.setPrix(Prix);
		 p.setCategory(Category);
		 p.setQuantity(Quantity);
	     p.setImage1(Image1);
	     p.setImage2(Image2);
	     p.setImage3(Image3);
//		// p.setIs_Visible(Is_Visible);
    	 p.setAjouter_Le(Ajouter_Le);
    	 System.out.println(p.getDescription());
    	 try {
			ProductDB.AddProducts(p);
    	 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	 }
		 }
		 
		 if ("delete".equals(DeletSubmit)){
			 String  ProductName=request.getParameter("pname");
			 p.setProductName(ProductName);
			 try {
					ProductDB.DeleteProducts(p);
		    	 } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		    	 }
		 }
//		 com.products.dao.testConnection.test();
		 doGet( request, response);
		
	}
	
}
