import java.util.ArrayList;

public class Mailbox {
	
	private ArrayList<Message> messageQueue = new ArrayList();

	public Mailbox(String boxName) {
		
	}
	
	public void addMessage(Message message) {
		messageQueue.add(message);
	}
	
	public void removeMessage(Message message) {
		/* some function that copies a message to the trash queue
		Account.toTrash(message);
		*/
		messageQueue.remove(message);
	}
	
	public void checkMessage(Message message){
		
		if(messageQueue.contains(message)){
			
			System.out.println("Message contained in the Mailbox");
		}
		
		else{
			System.out.println("Message IS NOT contained in the Mailbox");
		}
	}
	
}
