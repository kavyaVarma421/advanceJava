package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginDetails;
import model.PersonDetails;

public class LoginConnection {
	public static Connection dbConnect() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver class loaded & registered");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc ? user=kavya & password=kavya123");

		System.out.println("connection established..");
		return con;
	}

	public static PersonDetails checkingDetails(LoginDetails ld) {
		PersonDetails pd=new PersonDetails();
		String uname = ld.getuName();
		String pwd = ld.getPassword();
		String query = "Select * from LoginAndRegistration where UserName=? and Password=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = dbConnect().prepareStatement(query);
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				pd.setfName(rs.getString("FirstName"));
				pd.setlName(rs.getString("LastName"));
				pd.setuName(rs.getString("UserName"));
				pd.setEmailId(rs.getString("EmailId"));
				pd.setPhnNum(rs.getString("MobileNumber"));
				return pd;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
}
