
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class myGui{

	private JFrame frame;
	private JPanel panel;
	private JPanel panel2;
	private JButton btn;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	
	JTree tree = new JTree();
	JTree messTree = new JTree();
	JTextArea area;
	JSplitPane splitPane;
	
	JMenuBar menuBar;
	JMenuBar optionBar = new JMenuBar();
	
	JMenu menu1;
	JMenu menu2;
	JMenu optionMenu;
	
	JMenuItem item1;
	JMenuItem item2;
	JMenuItem item3;
	JMenuItem item4;
	JMenuItem optionItem1;
	JMenuItem optionItem2;
	JMenuItem optionItem3;
	
	//JToolBar toolBar;
	
	public myGui(){  //Constructor initialization
		
		initGui();
		sys = new MailSystem();
		treeNode = new DefaultMutableTreeNode("ChargerMail");
		treeNodeMess = new DefaultMutableTreeNode("Messages");
		RefreshTree();
		refreshMessageTree();
	}
	
	public void initGui(){
		
		frame = new JFrame("JTK Email System");
		//frame.setLayout(new FlowLayout());
		//toolBar = new JToolBar();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		JPanel composePanel = new JPanel(new FlowLayout());
		JPanel sendPanel = new JPanel(new FlowLayout());
		JPanel toPanel = new JPanel(new FlowLayout());
		JPanel panel3 = new JPanel(new FlowLayout());
		JPanel optionPanel = new JPanel(new FlowLayout());
		
		final JTextField receipientEdit = new JTextField(20);
		final JTextField subjectEdit = new JTextField(12);
		final JTextArea textEdit = new JTextArea();
		panel2.setPreferredSize(new Dimension(300,350));
		panel2.setBackground(Color.RED);
		textEdit.setLineWrap(true);
		
		JLabel label = new JLabel("To :");
		label.setLayout(new FlowLayout());
		area = new JTextArea();
		//area.setBackground(Color.CYAN);
		area.setEditable(false);

	    tree.setMinimumSize(new Dimension(50, 50));
		tree.setPreferredSize(new Dimension(200, 500));
		area.setMaximumSize(new Dimension(300,500));
		area.setPreferredSize(new Dimension(300, 500));
		area.setWrapStyleWord(true);
		area.setLineWrap(true);
		
		panel.setBackground(Color.BLUE);
		menuBar = new JMenuBar();
		
		menu1 = new JMenu("Account");
		menu2 = new JMenu("User");
		optionMenu = new JMenu("Mailbox");
		
		//Add a "Add account" sub-menu to the Account menu
		item1 = new JMenuItem("Add Account");
		optionItem1 = new JMenuItem("Inbox");
		optionItem2 = new JMenuItem("Sent");
		optionItem3 = new JMenuItem("Trash");
		menu1.add(item1);
		
		
		optionItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				area.setText(null);
				treeNodeMess.removeAllChildren();
				mailboxType = 0;
				contextNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (contextNode != null)
				{
					if (contextNode.isRoot())
					{
						return;
					}
										
					ArrayList<Message> messages = sys.getMessages(contextNode.toString(), 0);
					Iterator<Message> list = messages.iterator();
					
					while (list.hasNext())
					{
						Message temp = list.next();
						DefaultMutableTreeNode mess = new DefaultMutableTreeNode(temp.getMessageSubject());
						
						treeNodeMess.add(mess);
					}
					
					refreshMessageTree();
					
					
			}
			}
		});

		
		optionItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				area.setText(null);
				treeNodeMess.removeAllChildren();
				mailboxType = 1;
				contextNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (contextNode != null)
				{
					if (contextNode.isRoot())
					{
						return;
					}
										
					ArrayList<Message> messages = sys.getMessages(contextNode.toString(), 1);
					Iterator<Message> list = messages.iterator();
					
					while (list.hasNext())
					{
						Message temp = list.next();
						DefaultMutableTreeNode mess = new DefaultMutableTreeNode(temp.getMessageSubject());
						
						treeNodeMess.add(mess);
					}
					
					refreshMessageTree();
					
					
			}
			}
		});
		
		optionItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				area.setText(null);
				treeNodeMess.removeAllChildren();
				mailboxType = 2;
				contextNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (contextNode != null)
				{
					if (contextNode.isRoot())
					{
						return;
					}
										
					ArrayList<Message> messages = sys.getMessages(contextNode.toString(), 2);
					Iterator<Message> list = messages.iterator();
					
					while (list.hasNext())
					{
						Message temp = list.next();
						DefaultMutableTreeNode mess = new DefaultMutableTreeNode(temp.getMessageSubject());
						
						treeNodeMess.add(mess);
					}
					
					refreshMessageTree();
					
					
			}
			}
		});

		
		

		
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				contextNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (contextNode != null)
				{
					System.out.println("The node's name is: " + contextNode.toString());
					if (!(contextNode.toString().equals("Local")) && !(contextNode.toString().equals("Remote")))
					{
						return;
					}
					
					String sName = JOptionPane.showInputDialog("Input server name");
					
					if (sys.accountExists(contextNode.getParent().toString() + "@" + sName))
					{
						JOptionPane.showMessageDialog(null,"This account already exists within the system");
						return;
					}
					Account newAccount = new Account(contextNode.getParent().toString()+"@"+sName,contextNode.getParent().toString());
					sys.addAccount(contextNode.getParent().toString(), newAccount);
					DefaultMutableTreeNode account = new DefaultMutableTreeNode(contextNode.getParent().toString()+"@"+sName);
					
					contextNode.add(account);
					RefreshTree();
			}
			}
		});
		
		
	    item2 = new JMenuItem("Remove Account");
	    
	    item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				contextNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (contextNode != null)
				{
					if (contextNode.isRoot())
					{
						return;
					}
					sys.deleteAccount(contextNode.getParent().getParent().toString(),contextNode.toString());
					
					DefaultMutableTreeNode temp = (DefaultMutableTreeNode) contextNode.getParent();
					temp.remove(contextNode);
					
					RefreshTree();
			}
			}
		});
	    
		menu1.add(item2);
		item3 = new JMenuItem("Add User");
		menu2.add(item3);
		
		
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String uname = JOptionPane.showInputDialog("Input username"); //this needs to eventually be a whole window that requests username, first name, and last name
				
				if (uname == null)
				{
					return;
				}
				if(sys.isNewUserUnique(uname))
				{
					String fname = JOptionPane.showInputDialog("Input first name");
					
					if (fname == null)
					{
						return;
					}
					String lname = JOptionPane.showInputDialog("Input last name");
					
					if (lname == null)
					{
						return;
					}
					User newUser = new User(uname);
					
					newUser.setGivenName(fname);
					newUser.setSurname(lname);
					sys.addNewUser(newUser);
					DefaultMutableTreeNode user = new DefaultMutableTreeNode(uname);
					DefaultMutableTreeNode local = new DefaultMutableTreeNode("Local");
					DefaultMutableTreeNode remote = new DefaultMutableTreeNode("Remote");

					treeNode.add(user);
					user.add(local);
					user.add(remote);
					
					RefreshTree();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR: This username already exists");
				}
				
				
			}
		});
		
		tree.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent tse) {
				contextNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (contextNode != null)
				{
					if (contextNode.isRoot())
					{
						return;
					}
					else if (contextNode.isLeaf())
					{
						return;
					}
					
					return;
					
				}			
			}
		});
		
		messTree.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent tse) {
				contextNodeMessage = (DefaultMutableTreeNode) messTree.getLastSelectedPathComponent();
				
				if (contextNodeMessage != null)
				{
					if (contextNodeMessage.isLeaf())
					{
						ArrayList<Message> messages = sys.getMessages(contextNode.toString(), mailboxType);
						Iterator<Message> list = messages.iterator();
						
						while (list.hasNext())
						{
							Message temp = list.next();
							if (contextNodeMessage.toString() == temp.getMessageSubject())
							{
								area.setText("SUBJECT: " + temp.getMessageSubject() + " \n");
								area.append("TO: " + temp.getTo() + " \n");
								area.append("FROM: " + temp.getFrom() + " \n");
								area.append("SENT AT: " + temp.getTimeStamp().toString() + " \n");
								area.append("MESSAGE: " + temp.getMessageText());
							}
						}
						
					}
			
					
				}			
			}
		});
		
		
		
		item4 = new JMenuItem("Remove User");
		menu2.add(item4);
		
		item4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				contextNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (contextNode != null)
				{
					if (contextNode.isRoot())
					{
						return;
					}
					else if (contextNode.isLeaf())
					{
						return;
					}
					
					sys.deleteUser(contextNode.toString());
					treeNode.remove(contextNode);
					System.out.println("There are " + sys.getNumUsers() + " users in the mail system");
				
				RefreshTree();
				
			}
		}
		});
		
		optionMenu.add(optionItem1);
		optionMenu.add(optionItem2);
		optionMenu.add(optionItem3);
		optionBar.add(optionMenu);
		
		optionPanel.add(optionBar);
		optionPanel.add(new JSeparator(JSeparator.HORIZONTAL));
		
		composePanel.add(new JSeparator(JSeparator.HORIZONTAL));
		btn = new JButton("Compose");
		composePanel.add(btn);
		composePanel.add(new JSeparator(JSeparator.HORIZONTAL));
		
		sendPanel.add(new JSeparator(JSeparator.HORIZONTAL));
		btn2 = new JButton("Send");
		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				if (!(sys.accountExists(receipientEdit.getText())))
				{
					JOptionPane.showMessageDialog(null, "This account does not exist");
					receipientEdit.setText(null);
					subjectEdit.setText(null);
					textEdit.setText(null);
					return;
				}
				contextNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (contextNode != null)
				{
					if (contextNode.getClass().getName() == "javax.swing.tree.DefaultMutableTreeNode" && contextNode.getParent().toString() == "Local")
					{
						Message temp = new Message(receipientEdit.getText(),contextNode.toString(),textEdit.getText(),subjectEdit.getText());
						sys.transferMessage(contextNode.toString(),receipientEdit.getText(),temp,1);
						sys.transferMessage(contextNode.toString(),receipientEdit.getText(),temp,0);
						receipientEdit.setText(null);
						subjectEdit.setText(null);
						textEdit.setText(null);
					}
				}
		}
		});
		
		
		
		sendPanel.add(btn2);
		sendPanel.add(new JSeparator(JSeparator.HORIZONTAL));
		
		toPanel.add(label);
		toPanel.add(receipientEdit);
		toPanel.add(new JLabel("Subject:"));
		toPanel.add(subjectEdit);
		toPanel.add(new JSeparator(JSeparator.HORIZONTAL));
		
		panel.add(composePanel);
		panel.add(new JSeparator());
		panel.add(toPanel);
		panel.add(new JSeparator());
		panel.add(textEdit);
		panel.add(new JSeparator(JSeparator.HORIZONTAL));
		panel.add(sendPanel);
		panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		panel2.add(optionPanel);
		panel2.add(new JSeparator());
		panel2.add(messTree);
		panel2.add(area);
		panel2.add(new JSeparator(JSeparator.HORIZONTAL));
		
		
		panel3.add(new JSeparator(JSeparator.HORIZONTAL));
		btn3 = new JButton("Reply");
		panel3.add(btn3);
		panel3.add(new JSeparator(JSeparator.HORIZONTAL));
		//	toolBar.add(btn3);
		btn4 = new JButton("Remove");
		
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				contextNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				contextNodeMessage = (DefaultMutableTreeNode) messTree.getLastSelectedPathComponent();
				
				sys.deleteMessage(contextNode.toString(),contextNodeMessage.toString(),mailboxType);
				treeNodeMess.remove(contextNodeMessage);	
				refreshMessageTree();
				area.setText(null);
		}
		});
		
		
		panel3.add(btn4);
		
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				if (mailboxType == 0)
				{
					String[] tokens = area.getText().split(" ");
					
					subjectEdit.setText( "RE: " + tokens[1]);
					receipientEdit.setText(tokens[5]);
				}
				
				
		}
		});
		panel3.add(new JSeparator(JSeparator.HORIZONTAL));
		panel2.add(panel3);
		panel2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		//	toolBar.add(btn4);
		//toolBar.add(btn);	
		//panel.add(Box.createHorizontalStrut(20));
		//toolBar.add(btn2);
	//	frame.add(toolBar);
	//	toolBar.setFloatable(false);
		
		//Add different menu to Menu bar
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		frame.add(menuBar);
		frame.setJMenuBar(menuBar);	
		
		JSplitPane leftPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), new JScrollPane(panel));
		JSplitPane rightPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(panel2),null);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPane, rightPane);
		
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);	
		frame.setSize(1500, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		FillTree();
		
		//JScrollPane treeScroll = new JScrollPane(tree);
		//JScrollPane areaScroll = new JScrollPane(panel);
		//JScrollPane panelScroll = new JScrollPane(panel);
		//rightPane.setLeftComponent(areaScroll);
		//rightPane.setRightComponent(panel2);
		//leftPane.add(treeScroll);
		//leftPane.setLeftComponent(treeScroll);
		//frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
	}
	
	public void FillTree(){
		
		/*DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode("Sample Email");
		DefaultMutableTreeNode user = new DefaultMutableTreeNode("User");
		DefaultMutableTreeNode local = new DefaultMutableTreeNode("Local");
		DefaultMutableTreeNode remote = new DefaultMutableTreeNode("Remote");
		user.add(local);
		user.add(remote);
		treeNode.add(user);
		DefaultTreeModel dtm = new DefaultTreeModel(treeNode);
		this.tree.setModel(dtm);*/

	}
	
	
	public void RefreshTree()
	{
		DefaultTreeModel dtm = new DefaultTreeModel(treeNode);
		this.tree.setModel(dtm);
	}
	
	public void refreshMessageTree()
	{
		DefaultTreeModel messTreeModel = new DefaultTreeModel(treeNodeMess);
		this.messTree.setModel(messTreeModel);
	}
	
	private DefaultMutableTreeNode treeNode;
	private DefaultMutableTreeNode treeNodeMess;
	private MailSystem sys;
	private DefaultMutableTreeNode contextNode;
	private DefaultMutableTreeNode contextNodeMessage;
	private int mailboxType;

}
