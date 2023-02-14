import java.util.*;
class TextMessage implements Share
{
	private int messageId;
	private String message;
	private Date messageDate;
	private boolean isOpened = false;
	private String replyMessage;

public void message(String... mes) {
	Scanner s = new Scanner(System.in);
	for(int i=0;i<mes.length;i++)
	{
		message += mes[i]+" ";
	}
}
public void isOpened() {
	isOpened = true;
}
	
@Override
public void add() {
	// TODO Auto-generated method stub
	
}
@Override
public void edit() {
	// TODO Auto-generated method stub
	
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
public void send() {
	// TODO Auto-generated method stub
	
}
@Override
public void receive() {
	// TODO Auto-generated method stub
	
}
@Override
public void setReplay(String s) {
	this.replyMessage = s;
	
}
@Override
public String getReplay() {
	return this.replyMessage;
}

}