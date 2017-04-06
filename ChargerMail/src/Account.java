import java.util.ArrayList;

/**
 * 
 * @author Tevon Walker
 *
 */
public class Account {
	
	public Account(String name,String userName)
	{
		//create three mailboxes
		inbox = new Mailbox("inbox");
		sent = new Mailbox("sent");
		trash = new Mailbox("trash");
		this.userName = userName;
		accountName = name;
	}
	
	public void receiveMessage(int box, Message mess)
	{
		if (box == 0){
			inbox.addMessage(mess);
		}
		
		else if (box == 1){
			sent.addMessage(mess);
		}
		
		else{
			trash.addMessage(mess);
		}
	}
	
	public String getAccountName()
	{
		return accountName;
	}
	
	public ArrayList<Message> getMailboxMessages(int type)
	{
		if (type == 0)
		{
			return inbox.getMessages();
		}
		
		else if (type == 1)
		{
			return sent.getMessages();
		}
		
		else if (type == 2)
		{
			return trash.getMessages();
		}
		
		else
			return null;
	}
	
	public int getMailboxSize(int type)
	{
		if (type == 0)
		{
			return inbox.getSize();
		}
		
		else if (type == 1)
		{
			return sent.getSize();
		}
		
		else
		{
			return trash.getSize();
		}
	}
	
	public String getUsername()
	{
		return userName;
	}
	
	public void removeMessage(String mess, int type)
	{
		if (type == 0)
		{
			trash.addMessage(inbox.removeMessage(mess));
			
		}
		
		else if (type == 1)
		{
			trash.addMessage(sent.removeMessage(mess));
		}
		
		else
		{
			trash.removeMessage(mess);
		}
	}
	
	
	
	private Mailbox inbox,sent,trash;
	private String accountName,userName;

}
