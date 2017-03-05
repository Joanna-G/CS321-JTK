/**
 * 
 * @author tevonwalker
 *
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import java.util.Iterator;
import java.awt.event.*;

import javax.swing.JFrame;

public class Gui2 {

	public Gui2()
	{
		final MailSystem sys = new MailSystem();
		userListing = new ArrayList();
		JFrame frame = new JFrame();
		JMenuBar bar = new JMenuBar();
		userMenu = new JMenu();
		userItem = new JMenuItem();
		userItem.setText("Create a new User");
		userMenu.setText("Users");
		userMenu.add(userItem);
		
		userItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String uname = JOptionPane.showInputDialog("Enter the User Name");
				 if(sys.createNewUser(uname))
				 {
					 JMenuItem newUser = new JMenuItem();
					 newUser.setText(uname);
					 
					 newUser.addActionListener(new ActionListener() {
						 public void actionPerformed(ActionEvent event) {
							 JMenuItem tempMenuItem = (JMenuItem) event.getSource();
							 UserContextSwitch(tempMenuItem.getText());
							 
						 }
					 });
					 
					 userMenu.add(newUser);
				 }
			}
		});
		
		bar.add(userMenu);
		JPanel panel = new JPanel();
		
		 tField = new JTextField(20);
		
		frame.setLayout(new GridLayout(2,1));
		//tField.setEditable(false);
		frame.add(bar);
		frame.add(tField);
		//frame.add(bar);
		frame.add(panel);
		frame.setSize(500, 500);
		//frame.pack();
		frame.setVisible(true);
	}
	
	void updateUsers()
	{
		userMenu.removeAll();
		userMenu.add(userItem);
	}
	
	void UserContextSwitch(String name)
	{
		System.out.print("Hello " + name);
		tField.setText("Hello, " + name + "Enter A message in the box below to send");
		//temporary code to exemplify message passing
	}
	
	private ArrayList<JMenuItem> userListing;
	private JMenu userMenu;
	private JMenuItem userItem;
	private JTextField tField;
}
