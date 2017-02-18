import java.util.ArrayList;

/**
 * Creates a mailbox
 * @author Joanna Pease
 *
 */

public class Mailbox {

	public Mailbox(String boxName) {
		this.boxName = boxName;
	}
	
	/**
	 * Add a message to the queue
	 * @param message
	 */
	public void addMessage(Message message) {
		messageQueue.add(message);
	}
	
	/**
	 * Move a message to the trash
	 * @param message
	 */
	public void removeMessage(Message message) {
		/* some function that copies a message to the trash queue
		Account.toTrash(message);
		*/
		messageQueue.remove(message);
	}
	
	/**
	* Empty the trash.
	* @return true if emptied, false if not.
	*/
	public boolean emptyTrash() {
		if (boxName.equals("Trash")) {
			messageQueue.clear();
			return true;
		}
		else
			return false;
	}
	
	public String getName() {
		return boxName;
	}
	
	private ArrayList<Message> messageQueue = new ArrayList();
	private String boxName;

	
}
