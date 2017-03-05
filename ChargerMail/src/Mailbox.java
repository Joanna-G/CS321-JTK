import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Creates a mailbox
 * @author Joanna Pease
 *
 */

public class Mailbox {

	/**
	 * Creates a mailbox
	 * @param Account The current Account address
	 * @param boxName Inbox, Sent, or Trash
	 */
	public Mailbox(String boxName) {
		this.boxName = boxName;
	}
	
	/**
	 * Create a new message to send.
	 */
	public void newMessage() {
		String toAddress;
		String messageText;
		
		input = new Scanner(System.in);
		toAddress = input.nextLine();
		input.next();
		messageText = input.nextLine();
		input.next();
		
		//Message newMessage = new Message(toAddress, messageText);
		
		// Some way to actually send the message.
		// Like:
		// currentAccount.send(newMessage); ??
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
		// some MailSystem function that copies a message to Trash box.
		// Like:
		if (!boxName.equals("Trash"))
			//MailSystem.move(message, "Trash");
		
		messageQueue.remove(message);	
	}
	
	/**
	 * Move all messages in Inbox/Sent to Trash or empties Trash
	 * @return true if emptied, false if not.
	 */
	public boolean eraseAll() {

		if (boxName.equals("Trash")) {
			messageQueue.clear();
			return true;
		}
		else if ((boxName.equals("Sent")) || (boxName.equals("Inbox"))) {
			//MailSystem.moveAll(messageQueue);
			messageQueue.clear();
			return true;
		}
		else
			return false;
	}
	
	public String getName() {
		return boxName;
	}
	
	/**
	 * Sort messages by date
	 */
	public void sortMessages() {
		Collections.sort(messageQueue);
	}
	
	private ArrayList<Message> messageQueue = new ArrayList<Message>();
	private String boxName;
	private Scanner input;
	
}
