import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class SignIn extends Frame implements ActionListener{
	private Label userName;
	private Label userMobile;
	private Label userMail;
	private Label userDob;
	private Label userAddress;
	private Label newPassword;
	
	private TextField name;
	private TextField mobile;
	private TextField mail;
	private TextField dob;
	private TextArea address;
	private TextField pass;
	
	private Button b1,b2,b3;
	
	private Panel pSignIn;
	
public void init() {
	this.userName = new Label("User_Name:");
	this.userMobile = new Label("User_MObile:");
	this.userMail = new Label("User_Mail");
	this.userDob = new Label("User_DOB");
	this.userAddress = new Label("User_Address:");
	this.newPassword = new Label("New Password:");
	
	this.name = new TextField(25);
	this.mobile = new TextField(25);
	this.mail =new TextField(25);
	this.dob = new TextField(25);
	this.address = new TextArea(4,20);
	this.pass = new TextField(20);

	pass.setEchoChar('*');
	
	this.b1 = new Button("Submit");
	this.b2 = new Button("Reset");
	this.b3 = new Button("Back");
	this.pSignIn = new Panel();
	
	//bounds
	this.userName.setBounds(70,90,90,60);
	this.name.setBounds(70,130,90,60);
	this.userMobile.setBounds(200,100,90,20);
	this.mobile.setBounds(200,140,90,20);
	

	//listeners
	this.b1.addActionListener(this);
	this.b2.addActionListener(this);
	this.b3.addActionListener(this);
	//adding 
	pSignIn.add(userName);pSignIn.add(name);
	pSignIn.add(userMobile);pSignIn.add(mobile);
	pSignIn.add(userMail);pSignIn.add(mail);
	pSignIn.add(userDob);pSignIn.add(dob);
	pSignIn.add(userAddress);pSignIn.add(address);
	pSignIn.add(newPassword);pSignIn.add(pass);
	pSignIn.add(b1);pSignIn.add(b2);pSignIn.add(b3);
	
	this.add(pSignIn);
	this.setName("SIGN IN");
	this.setVisible(true);
	this.setSize(330,400);
}


@Override
public void actionPerformed(ActionEvent e) {
	Button b = (Button)e.getSource();
	
	if(b==b1) {
		 
			User user= new User(name.getText(),mobile.getText(),mail.getText(),dob.getText(),address.getText(),pass.getText());
			System.out.println(user.getUserName());
			this.dispose();
	}
	
	else if(b==b2){
		this.name.setText("");
		this.mobile.setText("");
		this.mail.setText("");
		this.dob.setText("");
		this.address.setText("");
		this.pass.setText("");
	}
	
	else
	this.dispose();
	
}
}
/*<applet code = "SignIn" height=300 width=300></applet>*/