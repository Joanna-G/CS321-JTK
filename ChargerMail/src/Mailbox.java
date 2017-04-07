import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
	public Message newMessage() {
		String toAddress;
		String messageText;
		
		input = new Scanner(System.in);
		toAddress = input.nextLine();
		messageText = input.nextLine();
		
		testString = toAddress + " " + messageText;
		
		Message newMessage = new Message(toAddress, messageText, null, null);
		
		return newMessage;
		
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
		sortMessages();
	}
	
	/**
	 * Move a message to the trash
	 * @param message
	 */
	public Message removeMessage(String subject) {
		
		int index = 0;
		Iterator<Message> list = messageQueue.iterator();
		Message temp = null;
		while (list.hasNext())
		{
			temp = list.next();
			if(temp.getMessageSubject().equals(subject))
			{
				break;
			}
			index++;
		}
		
		
		messageQueue.remove(index);
		
		sortMessages();
		return temp;
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
			messageQueue.clear();
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Sort messages by date
	 */
	public void sortMessages() {
		Collections.sort(messageQueue);
		Collections.reverseOrder();
	}
	
	public String getName() {
		return boxName;
	}
	
	public ArrayList<Message> getMessages()
	{
		return (ArrayList<Message>) messageQueue.clone();
	}
	
	public int getSize()
	{
		return messageQueue.size();
	}
	
	/**
	 * Function used for testing newMessage
	 * @return a string
	 */
	public String getTestString()
	{
		return testString;
	}
	
	public Message getMessage(String subject)
	{
		int index = 0;
		Iterator<Message> list = messageQueue.iterator();
		Message temp = null;
		while (list.hasNext())
		{
			temp = list.next();
			if(temp.getMessageSubject().equals(subject))
			{
				break;
			}
			index++;
		}
		return temp;
	}
	
	private ArrayList<Message> messageQueue = new ArrayList<Message>();
	private String boxName;
	private Scanner input;
	private String testString;
	
}
