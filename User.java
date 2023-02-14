//user profile
import java.util.*;
import java.sql.*;
import java.sql.Date;

class User
{
	private int userId;
	private String userName;
	private String userMail;
	private int userMobile;
	private Date userDob;
	private String userAddress;
	private Photo profilePhoto;
	private String passWord;
	private ResultSet friendList;
	
	
	public User() {
	}

	public User(String name,String mobile,String mail,String dob,String address,String password) {

		this.userName = name;
		this.userMail = mail;
		this.userMobile = Integer.parseInt(mobile);
		StringTokenizer n = new StringTokenizer(dob,"-");
		
		int day = Integer.parseInt(n.nextToken());
		int mon = Integer.parseInt(n.nextToken());
		int year = Integer.parseInt(n.nextToken());
		this.userDob = new Date(day,mon,year);
		this.userAddress = address;
		this.passWord = password;
		try {
			this.addDB();
		} catch (Exception e) {
			System.out.println("Unsuccess");
		}
	}
	
	public void logOut() {
		
	}
	public ResultSet logIn(String mob,String pass) throws Exception {

		int temp = Integer.parseInt(mob);
		
		String url = "jdbc:mysql://localhost:3306/Socialnetwork";
		String userName = "root";
		String passWord = "Barani@2002";
		String query0 ="SELECT password FROM user WHERE usermobile="+mob+";";
		String query = "SELECT* FROM user WHERE usermobile="+mob+" AND password="+pass+";";
		
		
		Connection con = DriverManager.getConnection(url,userName,passWord);
		Statement p= con.createStatement();
		Statement p1= con.createStatement();
		ResultSet r = p1.executeQuery(query0);
		r.next();
		ResultSet rs = p.executeQuery(query);
		if(r.getString(1).equals(pass)) {
			while(rs.next()) {
				this.userId = rs.getInt(1);
				this.userName = rs.getString(2);
				this.userMail = rs.getString(3);
				this.userMobile = rs.getInt(4);
				this.userDob = rs.getDate(5);
				this.userAddress = rs.getString(6);
				this.passWord = rs.getString(7);
				
			}
			this.setFriendList();
			ResultSet post=Post.updatePost(this.getUserId(),this.getFriendList());
			return post;
		}
		else
		{
			return false;//change
		}
		
	}
	private void changeDB() throws Exception {
		String url = "jdbc:mysql://localhost:3306/Socialnetwork";
		String userName = "root";
		String passWord = "Barani@2002";
		String query = "UPADATE user SET username=?,usermail=?,usermobile=?,userdob=?,useraddress=?,password=? WHERE userid="+this.userId+";";
		
		Connection con = DriverManager.getConnection(url,userName,passWord);
		PreparedStatement p= con.prepareStatement(query);
		p.setString(1, this.userName);
		p.setString(2, this.userMail);
		p.setInt(3, this.userMobile);
		p.setDate(4, this.userDob);
		p.setString(5, this.userAddress);
		p.setString(6, this.passWord);
		if(1==p.executeUpdate())
			con.close();
	}
	private void addDB() throws Exception{
		String url = "jdbc:mysql://localhost:3306/Socialnetwork";
		String userName = "root";
		String passWord = "Barani@2002";
		String query = "INSERT INTO user(username,usermail,usermobile,userdob,useraddress,password)VALUES(?,?,?,?,?,?);";
		
		Connection con = DriverManager.getConnection(url,userName,passWord);
		PreparedStatement p= con.prepareStatement(query);
		p.setString(1, this.userName);
		p.setString(2, this.userMail);
		p.setInt(3, this.userMobile);
		p.setDate(4, this.userDob);
		p.setString(5, this.userAddress);
		p.setString(6, this.passWord);
		
		if(1==p.executeUpdate())
			con.close();
	}
	public void setPassword(String s) {
		this.passWord = s;
	}
	public void changeProfilePhoto()
	{
		Photo newProfile = new Photo();
	}
	public void setProfilePhoto()
	{
		this.profilePhoto = new Photo();
	}
	public void changeUserName(String name)
	{userName = name;}
	@SuppressWarnings("deprecation")
	public void changeUserDob(String dob)
	{
		StringTokenizer n = new StringTokenizer(dob,"-");
	
		userDob.setDate(Integer.parseInt(n.nextToken()));
		userDob.setMonth(Integer.parseInt(n.nextToken()));
		userDob.setYear(Integer.parseInt(n.nextToken()));
	}
	public void changeUserAddress(String add)
	{userAddress = add;}
	
	public void deleteUser() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/Socialnetwork";
		String userName = "root";
		String passWord = "Barani@2002";
		String query = "DELETE FROM user WHERE userid"+this.userId+";";
		
		Connection con = DriverManager.getConnection(url,userName,passWord);
		Statement p= con.createStatement();
		
		if(1==p.executeUpdate(query))
		con.close();
	}
	
	public int getUserId() {return userId;}
	public String getUserName() {return userName;}
	public int getUserMobile() {return userMobile;}
	public String getUserMail() {return userMail;}
	public String getUserAddress() {return userAddress;}

	public ResultSet getFriendList() {
		return friendList;
	}

	public void setFriendList() throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/Socialnetwork";
		String userName = "root";
		String passWord = "Barani@2002";
		String query = "SELECT user FROM friend;";
		
		Connection con = DriverManager.getConnection(url,userName,passWord);
		Statement p = con.createStatement();
		
		this.friendList = p.executeQuery(query);
		
	}
}