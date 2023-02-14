//sharing 
//posting 
import java.sql.*;
import java.util.*;
import java.util.Date;
class Photo implements Post,Share
{
	
	private int userId;
	private int photoId;
	private String photoDescription;
	private String photoType;
	private String photoName;
	private String photoPath;
	private String photoSize;
	private Date photoDate;
	private int viewes;
	private boolean visibility = false;
	private int likes;
	private String photoReply;
	
	public Photo() {
		this.photoDate = new Date();
	}
	public Photo(int userid,String photoname,String phototype,String photopath,String photosize)
	{
		this.userId =userid;
		this.photoName = photoname;
		this.photoType = phototype;
		this.photoPath = photopath;
		this.photoSize = photosize;
		this.photoDate = new Date();
		this.viewes = 0;
		this.likes =0;
	}
	
	@Override
	public void addPost() throws Exception{
		String url = "jdbc:mysql://localhost:3306/Socialnetwork";
		String userName = "root";
		String passWord = "Barani@2002";
		String query = "INSERT INTO post(postname,posttype,postdesciption,postlikes,postviews,postdate,postpath)VALUES(?,?,?,?,?,?,?);";
		
		Connection con = DriverManager.getConnection(url,userName,passWord);
		PreparedStatement p= con.prepareStatement(query);
		
		p.setString(1,this.getPhotoName());
		p.setString(2, "Photo");
		p.setString(3, this.getPhotoDescription());
		p.setInt(4, this.getLikes());
		p.setInt(5, this.getViews());
		p.setDate(6, (java.sql.Date)this.getDate());
		p.setString(7, this.getPath());
		
		if(1==p.executeUpdate())
			con.close();
	}

	@Override
	public void editPost() throws Exception {
		String url = "jdbc:mysql://localhost:3306/Socialnetwork";
		String userName = "root";
		String passWord = "Barani@2002";
		String query = "UPDATE post SET postname=?,postdescription=?,postpath=? WHERE userid=? AND postid=?;";
		
		Connection con = DriverManager.getConnection(url,userName,passWord);
		PreparedStatement p= con.prepareStatement(query);
		
		p.setString(1,this.getPhotoName());
		p.setString(2, this.getPhotoDescription());
		p.setString(3, this.getPath());
		p.setInt(4, this.userId);
		p.setInt(5, this.getPhotoId());
		if(1==p.executeUpdate())
			con.close();
	}

	private int getPhotoId() {
		return this.getPhotoId();
	}
	@Override
	public void addLike() {
		this.likes++;
	}
	@Override
	public void setVisibility() {
		this.visibility=true;
		
	}
	@Override
	public String getPath() {
		return photoPath;
	}

	@Override
	public void setPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Override
	public void addViews() {
		this.viewes++;
	}

	@Override
	public int getViews() {
		return this.viewes;
	}

	@Override
	public int getLikes() {
		return this.likes;
	}

	public String getPhotoDescription() {
		return photoDescription;
	}

	public void setPhotoDescription(String photoDescription) {
		this.photoDescription = photoDescription;
	}

	public String getPhotoType() {
		return photoType;
	}


	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoSize() {
		return photoSize;
	}

	public Date getDate() {
		return this.photoDate;
	}

	@Override
	public void sendShare() {
		// TODO Auto-generated method stub
	}

	public void searchShare() {
		
	}
	public void deleteShare() {
		
	}
	public void addShare() {
		
	}
	public void editShare() {
		
	}
	@Override
	public void receiveShare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getReply() {
		return this.photoReply;
	}

	@Override
	public void setReply(String s) {
		this.photoReply = s;
	}
}