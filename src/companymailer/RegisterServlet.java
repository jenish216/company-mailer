package companymailer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		try {
			
		
		String  url="jdbc:mysql://localhost:3306/company_mailer_message";
		String user="root";
		String pass="";
		Class.forName("com.mysql.jdbc.Driver");
		System.out.print("Connected");
		Connection con=DriverManager.getConnection(url, user, pass);
		Statement st=con.createStatement();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		/*SimpleDateFormat formatter=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");*/
		String dob=request.getParameter("dob");
		String addressLine=request.getParameter("addressLine");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String contact=request.getParameter("contact");
		
		String query="insert into users (name,password,email,gender,dob,addressLine,city,state,country,contact) values('"+name+"','"+password+"','"+email+"','"+gender+"','"+dob+"','"+addressLine+"','"+city+"','"+state+"','"+country+"','"+contact+"')";
		int i=st.executeUpdate(query);
		response.sendRedirect("index.html");
		out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
