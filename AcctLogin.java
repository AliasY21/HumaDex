import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.*;

/**
 * Servlet implementation class AcctLogin
 */
public class AcctLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcctLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final PrintWriter out = response.getWriter();
		
		// JDBC driver name and database URL
				 String JDBC_DRIVER = "com.mysql.jdbc.Driver";
				 //String DB_URL = "jdbc:mysql://52.26.86.130:3306/student";
				 String DB_URL = "jdbc:mysql://localhost:3306/HumaDex";

				 // Database credentials
				 String USER = "root";
				 String PASS = "";

				 Connection conn = null;
				 Statement stmt = null;
				 //STEP 2: Register JDBC driver
				 try {
					 Class.forName("com.mysql.jdbc.Driver");
					 //STEP 3: Open a connection
					 System.out.println("Connecting to database...");
					 conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					 //STEP 4: Execute a query
					 System.out.println("Creating statement...");
					 stmt = (Statement) conn.createStatement();
					 String sql;
					 //String password = request.getParameter("email");
					 //Looks for matching 
					 //if(password.equals(request.getParameter("password")))
					 //{
							 sql = "SELECT * FROM acctinfo";
							 ResultSet rs2 = (ResultSet) stmt.executeQuery(sql);
							 while(rs2.next()){
								 
							 //Retrieve by column name
							 //String myName = rs2.getString("name");
							 String myEmail = rs2.getString("email");
							 String myPassword = rs2.getString("password");
							 //String myGender = rs2.getString("gender");
							 //String Myexperience = rs2.getString("experience");
							 
							 //Display values
							 //System.out.print("name: " + myName);
							 System.out.println("email: " + myEmail);
							 System.out.println("password: " + myPassword);
							 //System.out.println(", gender: " + myGender);
							 //System.out.println(", experience: " + Myexperience);
							 
							 //return the query results to client
							 if(Desktop.isDesktopSupported())
							 {
							   Desktop.getDesktop().browse(new URI("http://52.41.78.203/HumaDex/dashboard.html"));
							 }
							 //String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
								//out.println(docType + "");
		//						"<html>\n" +
	//							"<a href= \"dashboard.html\"></a>");
	//							"<body>\n" + 
	//							"<h1 align=\"center\"><img src = 'http://52.41.78.203/MyPic/thanksgiving.jpg'> Hello " + name + ", the following is your profile info:" + "</h1>" +
	//							"<ul>\n" +
	//							" <li><b>Your name</b>: " + myName + "\n" +
	//							" <li><b>Your email</b>: " + myEmail + "\n" +
	//							" <li><b>Your location</b>: " + myLocation + "\n" +
	//							" <li><b>Your gender</b>: " + myGender + "\n" +
	//							" <li><b>Your experience</b>: " + Myexperience + "\n" +
	//							"</ul>\n" +
		//						"</html>");
						 }
				 //}
				} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}

