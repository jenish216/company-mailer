package companymailer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

import companymailer.ConProvider;
import companymailer.Formatter;

public class ComposeDao {
	public static int save(String sender,String receiver,String subject,String message){
		int status=0;
		try{
			Connection con=ConProvider.getConnection();
			Statement st=con.createStatement();
			String trash="no";
		
			Date messagedate=Formatter.getCurrentDate();
			String query="insert into company_mailer_message (sender,receiver,subject,message,trash,messagedate) values('"+sender+"','"+receiver+"','"+subject+"','"+message+"','"+trash+"','"+messagedate+"')";
			
			
			status=st.executeUpdate(query);
						
		}catch(Exception e){System.out.println(e);}
				
		return status;
	}
}