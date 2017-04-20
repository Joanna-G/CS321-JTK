import java.util.ArrayList;

/**
 * 
 * @author Komlan Maglo
 *
 */
public class Account {
	
	/**
	 * Contructor
	 * @param name name of account
	 * @param userName name of the user that is associated with account
	 */
	public Account(String name,String userName)
	{
		//create three mailboxes
		inbox = new Mailbox("inbox");
		sent = new Mailbox("sent");
		trash = new Mailbox("trash");
		this.userName = userName;
		accountName = name;
	}
	
	/**
	 * Function to process incoming messages
	 * @param box inbox/sent box/ or trash
	 * @param mess the message to receive
	 */
	
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
	
	/**
	 * returns clone of message list to mailsystem
	 * @param type inbox/sent/ or trash?
	 * @return clone of message list to mailsystem
	 */
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
	
	/**
	 * delete a message from a mailbox
	 * @param mess the message to delete (message subject)
	 * @param type inbox/sent/ or trash?
	 */
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
