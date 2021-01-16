package companymailer;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class ConProvider {

	public static Connection getConnection(){
	Connection con=null;
	try{
		String  url="jdbc:mysql://localhost:3306/company_mailer_message";
		String user="root";
		String pass="";
		Class.forName("com.mysql.jdbc.Driver");
		System.out.print("Connected");
		con=DriverManager.getConnection(url, user, pass);
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");*/
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	return con;
    }
}

