package companymailer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class LoginDao {

	public static boolean validate(String mail,String pswd){
		boolean status=false;
		try{
			Connection con=ConProvider.getConnection();
			System.out.print("Connected");
			Statement st=con.createStatement();
			String Query="select * from users where email='"+mail+"' and password='"+pswd+"'";
			
			ResultSet rs=st.executeQuery(Query);
			if(rs.next())
			{
				status=true;
			}
			
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
}