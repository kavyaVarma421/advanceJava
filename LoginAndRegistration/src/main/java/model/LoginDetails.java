package model;

public class LoginDetails 
{
private String uName;
private String password;

public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "LoginDetails [uName=" + uName + ", password=" + password + "]";
}

}
