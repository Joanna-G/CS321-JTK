/**
 * Creates an email message
 * @author Joanna Pease
 *
 */

public class Message {
	
	public void setTo(String toAddress) {
		this.toAddress = toAddress;
	}
	
	public void setFrom(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	private String toAddress;
	private String fromAddress;
	private String message;
	
}
