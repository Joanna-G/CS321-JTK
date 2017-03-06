import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * 
 * @author Joanna Pease
 *
 */
public class GUI {
	
	public GUI() {
		JFrame frame = new JFrame();
		
		JPanel menuPanel = new JPanel();
    	JMenuBar mainMenu = new JMenuBar();
    	JMenu userMenu = new JMenu("User");
    	
		JMenuItem addUser = new JMenuItem("Add User");
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Add a user!");
			}
		});
		
		JMenuItem removeUser = new JMenuItem("Remove User");
		removeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Remove a user!");
			}
		});
		
		userMenu.add(addUser);
		userMenu.add(removeUser);
		
		JMenu accountMenu = new JMenu("Account");
		JMenuItem addAccount = new JMenuItem("Add Account");
		addAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Add an account!");
			}
		});
		
		JMenuItem removeAccount = new JMenuItem("Remove Account");
		removeAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Remove an account!");
			}
		});
		
		accountMenu.add(addAccount);
		accountMenu.add(removeAccount);
		
		mainMenu.add(userMenu);
		mainMenu.add(accountMenu);
		menuPanel.add(mainMenu);

		JButton composeButton = new JButton("Compose");
		composeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Compose a new message!");
			}
		});
		
		JButton replyButton = new JButton("Reply");
		replyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Reply to a message!");
			}
		});
		
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Send the message!");
			}
		}); 
		
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Remove the message!");
			}
		}); 
		
		JButton emptyTrashButton = new JButton("Empty Trash");
		emptyTrashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Empty the Trash!");
			}
		}); 
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(composeButton);
		buttonPanel.add(replyButton);
		buttonPanel.add(sendButton);
		buttonPanel.add(removeButton);
		buttonPanel.add(emptyTrashButton);
		
		JPanel split = new JPanel();

		JTextField treeText = new JTextField();
	
		treeText.setText("This is some text stuff.");
		treeText.setEditable(false);
		treeText.setHorizontalAlignment(JTextField.CENTER);
		
		JTextField messages = new JTextField();
		messages.setText("This is some other text stuff.");
		messages.setHorizontalAlignment(JTextField.CENTER);
				
		split.setLayout(new GridLayout());
		split.add(treeText);
		split.add(messages);
		
		JPanel accessPanel = new JPanel();
		accessPanel.setLayout(new GridLayout());
		accessPanel.add(menuPanel);
		accessPanel.add(buttonPanel);
		
		frame.add(accessPanel, BorderLayout.NORTH);
		frame.add(split, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 500);
	//	frame.pack();
		frame.setVisible(true);
	}

}
