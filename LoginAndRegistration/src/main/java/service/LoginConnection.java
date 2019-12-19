package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginDetails;

public class LoginConnection {
	public static Connection dbConnect() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver class loaded & registered");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc ? user=kavya & password=kavya123");

		System.out.println("connection established..");
		return con;
	}

	public static boolean checkingDetails(LoginDetails ld) {
		String uname = ld.getuName();
		String pwd = ld.getPassword();
		String query = "Select UserName,password from LoginAndRegistration where UserName=? and password=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = dbConnect().prepareStatement(query);
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
