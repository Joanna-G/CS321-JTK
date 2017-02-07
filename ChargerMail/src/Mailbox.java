import java.util.ArrayList;

public class Mailbox {
	
	

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
	
	private ArrayList<Message> messageQueue = new ArrayList();
	
}
