import java.util.ArrayList;
import java.util.Collections;

/**
 * Creates an email message
 * @author Joanna Pease
 *
 */

public class Message {
	
	public Message() {
		
	}
	
	/**
	 * Parameterized constructor.
	 * @param toAddress String for address the message is to.
	 * @param fromAddress String for address the message is from.
	 * @param message String ArrayList for message text.
	 */
	public Message(String toAddress, String fromAddress, 
			ArrayList<String> message) {
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		messageText = new ArrayList<String>();
		Collections.copy(messageText,message);
	}
	
	public String getTo() {
		return toAddress;
	}
	
	public void setTo(String toAddress) {
		this.toAddress = toAddress;
	}
	
	public String getFrom() {
		return fromAddress;
	}
	
	public void setFrom(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	
	public ArrayList<String> getMessageText() {
		return messageText;
	}
	
	public void setMessageText(ArrayList<String> message) {
		Collections.copy(messageText, message);
	}
	
	private String toAddress;
	private String fromAddress;
	private ArrayList<String> messageText;
	
}
