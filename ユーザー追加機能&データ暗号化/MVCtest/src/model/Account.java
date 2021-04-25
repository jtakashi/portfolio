package model;

public class Account {
	private String userID;
	private String pass;
	private String mail;
	private String name;
	private int age;
	public Account(String userID, String pass, String mail, String name, int age) {
		this.userID = userID;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
		this.age = age;
	}
	public String getUserID() {
		return userID;
	}
	public String getPass() {
		return pass;
	}
	public String getMail() {
		return mail;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}


}
