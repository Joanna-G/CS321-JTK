/**
 * 
 * @author tevonwalker
 *
 */
public class Account {
	
	public Account()
	{
		//create three mailboxes
		inbox = new Mailbox("inbox");
		sent = new Mailbox("sent");
		trash = new Mailbox("trash");
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
	
	
	private Mailbox inbox,sent,trash;

}
