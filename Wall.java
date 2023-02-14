/*import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.applet.*;
*/
import java.applet.*;
import java.awt.*;
import java.awt.Event.*;

public class Wall extends Frame{
	
	Image picture;
	Panel photo;
	public void photo() {
		this.picture = getImage(getDocumentBase(),"Bird.jpg");
		this.add(photo);
		repaint();
		this.setVisible(true);
		this.setSize(400,400);
	}	
	public void paint(Graphics g)
	{
		g.drawImage(picture,300, 300, photo);
	}
	public static void main(String arg[]) {
		Wall w = new Wall();
		w.photo();
		}
	/*private JPanel photo;
	private JLabel picLabel;
	private JPanel entity;
	private Button b1,b2,b3;
	private Label like;
	private JFrame picture;
	
public void photo() throws IOException {
	
	this.b1 = new Button("LIKE");
	this.b2 = new Button("COMMENT");
	this.b3 = new Button("SHARE");
	like = new Label();
	like.setText("Views:");
	
	picture= new JFrame();    
	photo=new JPanel();  
	
	entity.setLayout(new GridLayout(1,3));
	photo.setLayout(new FlowLayout());  
	
	BufferedImage myPicture = ImageIO.read(new File("Bird.jpg"));
	picLabel = new JLabel(new ImageIcon(myPicture));
	
	picture.add(picLabel);
	picture.add(like);
	picture.add(entity);
	
	picture.setVisible(true);
	picture.setSize(200,200);
}/*/
}
