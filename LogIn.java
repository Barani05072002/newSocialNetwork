import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class LogIn extends Frame implements ActionListener{
	Label userName;
	Label userMobile;
	Label passWord;
	
	TextField name;
	TextField mobile;
	TextField pass;
	
	Button b1,b2,b3,b4;
	
	Panel logIn;
	SignIn signin;
	
	User user;
public void init() {
	this.userName = new Label("User_Name:");
	this.userMobile = new Label("User_Mobile:");
	this.passWord = new Label("Password");
	
	this.name = new TextField(25);
	this.mobile = new TextField(25);
	this.pass = new TextField(25);
	pass.setEchoChar('*');
	
	this.b1 = new Button("Log In");
	this.b2 = new Button("Reset");
	this.b3 = new Button("New User");
	this.b4 = new Button("Close");
	//listener
	this.b1.addActionListener(this);
	this.b2.addActionListener(this);
	this.b3.addActionListener(this);
	this.b4.addActionListener(this);
	
	this.logIn = new Panel();
	this.signin = new SignIn();
	
	this.user = new User();
	//adding
	logIn.add(userName);logIn.add(name);
	logIn.add(userMobile);logIn.add(mobile);
	logIn.add(passWord);logIn.add(pass);
	logIn.add(b1);logIn.add(b2);logIn.add(b3);logIn.add(b4);

	this.add(logIn);
	this.setName("LOGIN");
	this.setVisible(true);
	this.setSize(330,400);
}
@Override
public void actionPerformed(ActionEvent e) {
	Button b = (Button)e.getSource();
	if(b==b1)
	{
		boolean str;
		try {
			str = user.logIn(this.mobile.getText(),this.pass.getText());
			System.out.println(str);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		this.dispose();
	}
	else if(b==b2)
	{
		this.name.setText("");
		this.mobile.setText("");
		this.pass.setText("");
	}
	else if(b==b3)
	{
		signin.init();
	}
	else
	{
		this.dispose();
	}
}
	public static void main(String arg[])
	{
		LogIn login = new LogIn();
		login.init();
	}
}
