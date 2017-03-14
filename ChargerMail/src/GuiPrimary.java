/**
 * @author Komlan Maglo
 */

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPrimary{

	private JFrame frame;
	//private JPanel panel;
	//private JPanel panel2;
	private JButton btn;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	
	JTree tree = new JTree(); 
	JTextArea area;
	JSplitPane splitPane;
	
	JMenuBar menuBar;
	
	JMenu menu1;
	JMenu menu2;
	
	JMenuItem item1;
	JMenuItem item2;
	JMenuItem item3;
	JMenuItem item4;
	
	
	JToolBar toolBar;
	
	
	public GuiPrimary(){  //Constructor initialization
		
		initGui();
		sys = new MailSystem();
		treeNode = new DefaultMutableTreeNode("ChargerMail");
		RefreshTree();
	}
	
	public void initGui(){
		
		frame = new JFrame("JTK Email System");
		//frame.setLayout(new FlowLayout());
		toolBar = new JToolBar();
	//	panel = new JPanel();
		//label = new JLabel("User");
		area = new JTextArea();
		area.setBackground(Color.CYAN);
		area.setEditable(false);

	    tree.setMinimumSize(new Dimension(50, 50));
		tree.setPreferredSize(new Dimension(150, 100));
	//	area.setMinimumSize(new Dimension(100, 100));
		area.setPreferredSize(new Dimension(300, 100));
	    
	
		
	//	panel.setBackground(Color.YELLOW);
		menuBar = new JMenuBar();
		//menuBar.setLayout(new GridLayout());
		
		menu1 = new JMenu("Account");
		menu2 = new JMenu("User");
		
		//Add a "Add account" sub-menu to the Account menu
		item1 = new JMenuItem("Add Account");
		menu1.add(item1);
		
	    item2 = new JMenuItem("Remove Account");
		menu1.add(item2);
		
		item3 = new JMenuItem("Add User");
		menu2.add(item3);
		
		
			item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String uname = JOptionPane.showInputDialog("Input username"); //this needs to eventually be a whole window that requests username, first name, and last name
				String fname = JOptionPane.showInputDialog("Input first name");
				String lname = JOptionPane.showInputDialog("Input last name");
				if(sys.isNewUserUnique(uname))
				{
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
					
					
					System.out.println(sys.retrieveFirstName(contextNode.toString())   + sys.retrieveLastName(contextNode.toString()));
					area.setText(sys.retrieveFirstName(contextNode.toString())   + " " + sys.retrieveLastName(contextNode.toString()));
					
					
					return;
					
				}			
			}
		});
		
		item4 = new JMenuItem("Remove User");
		menu2.add(item4);
		
		btn = new JButton("Compose");
		toolBar.add(btn);
		btn2 = new JButton("Send");
		toolBar.add(btn2);
		btn3 = new JButton("Reply");
		toolBar.add(btn3);
		btn4 = new JButton("Remove");
		toolBar.add(btn4);
	
		frame.add(toolBar);
		toolBar.setFloatable(false);
		
		//Add different menu to Menu bar
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		frame.add(menuBar);
		frame.setJMenuBar(menuBar);	
		//frame.add(panel);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), new JScrollPane(area));

		frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		FillTree();

	}
	
	public void FillTree(){
		
		//DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode("ChargerMail");
		/*DefaultMutableTreeNode user = new DefaultMutableTreeNode("User");
		DefaultMutableTreeNode account = new DefaultMutableTreeNode("Acounts");
		DefaultMutableTreeNode local = new DefaultMutableTreeNode("Local");
		DefaultMutableTreeNode remote = new DefaultMutableTreeNode("Remote");
		local.add(account);
		//remote.add(account);
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
	
	private DefaultMutableTreeNode treeNode;
	private MailSystem sys;
	private DefaultMutableTreeNode contextNode;
	

}
