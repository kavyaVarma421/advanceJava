package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import model.PersonDetails;

//import model.Personpds;
public class UpdateConnection {
	static Connection con = null;
	static PreparedStatement st = null;
	static ResultSet rs = null;

	public static int update(PersonDetails pd) {
       String uname = pd.getuName();
		String fname = pd.getfName();
		String lname = pd.getlName();
		String email = pd.getEmailId();
		String pNo = pd.getPhnNum();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("loading driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306 ? user=kavya & password=kavya123");
			System.out.println("connect established");
			String qry = "select Id from LoginAndRegistration where  UserName  = '"	+ uname + "'";
			rs = st.executeQuery();
			if(rs.next()) {
				qry="update LoginAndRegistration set FirstName=?,LastName=?,EmailId=?,MobileNumber=? where UserName= '"+ uname+"'";
				st = con.prepareStatement(qry);
				st.setString(1, fname);
				st.setString(2, lname);
				st.setString(3, email);
				st.setString(4, pNo);
				return st.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}
}
