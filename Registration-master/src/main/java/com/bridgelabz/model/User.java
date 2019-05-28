package com.bridgelabz.model;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class User 
{
	private String uname;
	private String email;
	private String password;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", email=" + email + ", password=" + password + ", getUname()=" + getUname()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + "]";
	}
	public User(String uname, String email, String password) {
		super();
		this.uname = uname;
		this.email = email;
		this.password = password;
	}
	
}