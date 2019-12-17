package model;

public class PersonDetails 
{
private String fName;
private String lName;
private String uName;
private String password;
private String cnformPass;
private String emailId;
private String phnNum;

public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
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
public String getCnformPass() {
	return cnformPass;
}
public void setCnformPass(String cnformPass) {
	this.cnformPass = cnformPass;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPhnNum() {
	return phnNum;
}
public void setPhnNum(String phnNum) {
	this.phnNum = phnNum;
}
@Override
public String toString() {
	return "PersonDetails [fName=" + fName + ", lName=" + lName + ", uName=" + uName + ", password=" + password
			+ ", cnformPass=" + cnformPass + ", emailId=" + emailId + ", phnNum=" + phnNum + "]";
}


}
