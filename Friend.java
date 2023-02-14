import java.sql.*;
import java.util.*;
class Friend
{
	private int friendId;
	private String friendName;
	private int friendMobileNo;
	private String friendMail;
	private String friendAddress;
	private boolean bestFriend;
	private boolean request=false;
	
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public int getFriendMobileNo() {
		return friendMobileNo;
	}
	public void setFriendMobileNo(int friendMobileNo) {
		this.friendMobileNo = friendMobileNo;
	}
	public String getFriendMail() {
		return friendMail;
	}
	public void setFriendMail(String friendMail) {
		this.friendMail = friendMail;
	}
	public String getFriendAddress() {
		return friendAddress;
	}
	public void setFriendAddress(String friendAddress) {
		this.friendAddress = friendAddress;
	}
	
public void addFriend(int id,User u) throws Exception
{	
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "SELECT username,usermail,usermobile,useraddress,userid FROM user WHERE usermobile="+id+";";
	
	int friendid = 0;
	Connection con = DriverManager.getConnection(url,userName,passWord);
	Statement p= con.createStatement();
	ResultSet rs = p.executeQuery(query);
	while(rs.next()) {
		this.friendName = rs.getString(1);
		this.friendMail = rs.getString(2);
		this.friendMobileNo = rs.getInt(3);
		this.friendAddress = rs.getString(4);
		friendid = rs.getInt(5);
	}
	con.close();
	this.addDB(friendid);
	//this.sendRequest(u);
}
private void addDB(int frndid) throws Exception {
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "INSERT INTO friend(friendname,friendmail,friendmobile,friendaddress,user)VALUES(?,?,?,?,?);";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	PreparedStatement p= con.prepareStatement(query);
	p.setString(1, this.friendName);
	p.setString(2, this.friendMail);
	p.setInt(3, this.friendMobileNo);
	p.setString(4, this.friendAddress);
	p.setInt(5, frndid);
	
	if(1==p.executeUpdate())
		con.close();
}
public ResultSet updateFriend() throws Exception //set as bestFriend
{
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "SELECT friendid,friendname,friendmail,friendmobile,bestfriend FROM friend;";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	Statement p= con.createStatement();
	ResultSet rs = p.executeQuery(query);
	
	return rs;
}
public static ResultSet updateFriendList() throws Exception //set as bestFriend
{
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "SELECT user FROM friend;";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	Statement p= con.createStatement();
	ResultSet rs = p.executeQuery(query);
	
	return rs;
}
public void deleteFriend(int mobile) throws Exception
{
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "DELETE FROM friend where friendmobile"+mobile+";";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	Statement p= con.createStatement();
	
	if(1==p.executeUpdate(query))
	con.close();
}
public void searchFriend(int mobile) throws Exception
{
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "SELECT* FROM user WHERE usermobile LIKE'"+mobile+"%'";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	Statement p= con.createStatement();
	ResultSet rs = p.executeQuery(query);
	
	String name;
	String id;
	while(rs.next()) {
		
	}
	con.close();
	//this.addFriend(mobile, null);
}
public void searchFriend(String name) throws Exception
{
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "SELECT* FROM user WHERE usermobile LIKE'"+name+"%'";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	Statement p= con.createStatement();
	ResultSet rs = p.executeQuery(query);
	
	while(rs.next()) {
		
	}
	
	con.close();
	//this.addFriend()
}
public void setBestFriend() throws Exception
{
	this.bestFriend = true;
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "UPDATE friend SET bestfriend=1 where friendid="+this.friendId+";";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	Statement p= con.createStatement();
	
	if(1==p.executeUpdate(query))
	con.close();
}
public Friend sendRequest(User u) {
	Friend f = new Friend();
	f.setFriendId(u.getUserId());
	f.setFriendName(u.getUserName());
	f.setFriendMail(u.getUserMail());
	f.setFriendMobileNo(u.getUserMobile());
	f.setFriendAddress(u.getUserAddress());
	
	return f;
}
public void acceptRequest(int id) throws Exception {
	this.addDB(id);  //me as a friend for my friend
}

}
