//sharing purpose 
//posting purpose
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
class Video implements Post,Share
{
	private int videoId;
	private String videoName;
	private String videType;
	private String videoDescription;
	private int videoDuration;
	private boolean isOpened;
	private Date videoDate;
	private boolean visibility=false;
	private int likes;
	private int views;
	private String videoPath;
	private String videoReply;
	
public void playVideo() {
	this.isOpened = true;
	}

public void pauseVideo(){
}

public int getVideoId() {
	return videoId;
}

public void setVideoId(int videoId) {
	this.videoId = videoId;
}

public String getVideoName() {
	return videoName;
}

public void setVideoName(String videoName) {
	this.videoName = videoName;
}

public String getVideType() {
	return videType;
}

public void setVideType(String videType) {
	this.videType = videType;
}

public String getVideoDescription() {
	return videoDescription;
}

public void setVideoDescription(String videoDescription) {
	this.videoDescription = videoDescription;
}

public int getVideoDuration() {
	return videoDuration;
}

public void setVideoDuration(int videoDuration) {
	this.videoDuration = videoDuration;
}


@Override
public void addPost() throws Exception {

	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "INSERT INTO post(postname,posttype,postdesciption,postlikes,postviews,postdate,postpath)VALUES(?,?,?,?,?,?,?);";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	PreparedStatement p= con.prepareStatement(query);
	
	p.setString(1,this.getVideoName());
	p.setString(2,"Video");
	p.setString(3, this.getVideoDescription());
	p.setInt(4, this.getLikes());
	p.setInt(5, this.getViews());
	p.setDate(6, (java.sql.Date)this.getDate());
	p.setString(7, this.getPath());
	
	if(1==p.executeUpdate())
		con.close();
}

public void editPost() throws Exception {
	String url = "jdbc:mysql://localhost:3306/Socialnetwork";
	String userName = "root";
	String passWord = "Barani@2002";
	String query = "UPDATE post SET postname=?,postdescription=?,postpath=?,duration WHERE userid=? AND postid=?;";
	
	Connection con = DriverManager.getConnection(url,userName,passWord);
	PreparedStatement p= con.prepareStatement(query);
	
	p.setString(1,this.getVideoName());
	p.setString(3, this.getVideoDescription());
	p.setString(7, this.getPath());
	
	if(1==p.executeUpdate())
		con.close();
}

@Override
public void delete() {
	// TODO Auto-generated method stub
	
}
@Override
public void search() {
	// TODO Auto-generated method stub
	
}
@Override
public void addLike() {
	this.likes++;
}
@Override
public void setVisibility() {
	this.visibility = true;
}

@Override
public String getPath() {
	// TODO Auto-generated method stub
	return this.videoPath;
}

@Override
public void setPath(String s) {
	this.videoPath = s;
}

@Override
public void addViews() {
	this.views++;
}

@Override
public int getViews() {
	return this.views;
}

@Override
public int getLikes() {
	return this.likes;
}

@Override
public void setDate() {
	this.videoDate = new Date();
}

@Override
public Date getDate() {
	
	return this.videoDate;
}

@Override
public void send() {
	// TODO Auto-generated method stub
	
}

@Override
public void receive() {
	// TODO Auto-generated method stub
	
}

@Override
public void setReplay(String s) {
	this.videoReply = s;
}

@Override
public String getReplay() {
	return this.videoReply;
}


}