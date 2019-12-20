package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.PersonDetails;

public class DeleteDetails {
	static Connection con = null;
	static PreparedStatement st = null;
	static ResultSet rs = null;

	public static int delete(PersonDetails pd) {
       String uname = pd.getuName();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("loading driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc ? user=kavya & password=kavya123");
			System.out.println("connect established");
			String qry="select Id from LoginAndRegistration where UserName= '"+ uname+"'";
			st = con.prepareStatement(qry);
			rs = st.executeQuery();
			if(rs.next()) {
				qry="delete from LoginAndRegistration where UserName= '"+ uname+"'";
				st = con.prepareStatement(qry);
				return st.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}
}
