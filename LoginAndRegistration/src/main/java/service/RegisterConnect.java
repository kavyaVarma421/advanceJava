package service;

import java.sql.*;

import model.PersonDetails;

public class RegisterConnect {

	static Connection con = null;
	static PreparedStatement st = null;
	static String qry = "insert into jdbc.LoginAndRegistration(FirstName, LastName,UserName,password,EmailId,MobileNumber) values (?, ?, ?, ?, ?, ?)";

public  static String registeringDetails(PersonDetails detail) {
	   
		String fname =detail.getfName();
		String lname =detail.getlName();
		String uname= detail.getuName();
		String passw = detail.getPassword();
		String email = detail.getEmailId();
		String pNo=detail.getPhnNum();

		System.out.println(detail);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver class loaded & registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306 ? user=kavya & password=kavya123");
			System.out.println("connection established..");
			st = con.prepareStatement(qry);
			System.out.println("platform created..");
             st.setString(1,fname);
             st.setString(2,lname);
             st.setString(3,uname);
             st.setString(4,passw);
             st.setString(5,email);
             st.setString(6,pNo);
             
         	st.executeUpdate();
			System.out.println("data inserted..");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {

					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {

					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return "something";
	}
}
