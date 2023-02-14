//all post 
//video,photo
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
interface Post
{
public void addPost()throws Exception;
public void editPost()throws Exception;
public void addLike();
public void setVisibility();
public String getPath();
public void setPath(String s);
public void addViews();
public int getViews();
public int getLikes();
public static ResultSet updatePost(int userid,ResultSet r) throws Exception
{
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	Connection con = DriverManager.getConnection(url,userName,passWord);
	
	String query = "SELECT* FROM post ORDER BY postdate WHERE userid="+userid;
	while(r.next()) {
		query = query +" or userid="+r.getInt(1);
	}
	query = query+";";
	
	Statement p= con.createStatement();
	ResultSet rs = p.executeQuery(query);
	
	return rs;
}
public static void searchPost(String name) throws Exception{
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "SELECT* FROM post WHERE postname LIKE '"+name+"%';";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	Statement p= con.createStatement();
	ResultSet rs = p.executeQuery(query);
}
public static void deletePost(String name) throws Exception {
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "DELETE FROM post where postname="+name+";";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	Statement p= con.createStatement();
	
	if(1==p.executeUpdate(query))
	con.close();
}
}