
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.*;

public class myGui{

	private JFrame frame;
	private JPanel panel;
	private JPanel panel2;
	private JButton btn;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	
	JTree tree = new JTree(); 
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
		
		JTextField editSubject = new JTextField(30);
		JTextArea textEdit = new JTextArea();
		panel2.setPreferredSize(new Dimension(300,350));
		panel2.setBackground(Color.RED);
		textEdit.setLineWrap(true);
		
		JLabel label = new JLabel("To :");
		label.setLayout(new FlowLayout());
		area = new JTextArea();
		//area.setBackground(Color.CYAN);
		//area.setEditable(false);

	    tree.setMinimumSize(new Dimension(50, 50));
		tree.setPreferredSize(new Dimension(200, 500));
		area.setPreferredSize(new Dimension(400, 350));
		area.setWrapStyleWord(true);
		area.setLineWrap(true);
		
		panel.setBackground(Color.BLUE);
		menuBar = new JMenuBar();
		
		menu1 = new JMenu("Account");
		menu2 = new JMenu("User");
		optionMenu = new JMenu("Options Menu");
		
		//Add a "Add account" sub-menu to the Account menu
		item1 = new JMenuItem("Add Account");
		optionItem1 = new JMenuItem("Inbox");
		optionItem2 = new JMenuItem("Sent");
		optionItem3 = new JMenuItem("Trash");
		menu1.add(item1);
		
	    item2 = new JMenuItem("Remove Account");
		menu1.add(item2);
		item3 = new JMenuItem("Add User");
		menu2.add(item3);
		item4 = new JMenuItem("Remove User");
		menu2.add(item4);
		
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
		sendPanel.add(btn2);
		sendPanel.add(new JSeparator(JSeparator.HORIZONTAL));
		
		toPanel.add(label);
		toPanel.add(editSubject);
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
		
		panel2.add(area);
		panel2.add(new JSeparator(JSeparator.HORIZONTAL));
		
		
		panel3.add(new JSeparator(JSeparator.HORIZONTAL));
		btn3 = new JButton("Reply");
		panel3.add(btn3);
		panel3.add(new JSeparator(JSeparator.HORIZONTAL));
		//	toolBar.add(btn3);
		btn4 = new JButton("Remove");
		panel3.add(btn4);
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
		JSplitPane rightPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(panel2), null);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPane, rightPane);
		
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);	
		frame.setSize(1000, 500);
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
		
		DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode("Sample Email");
		DefaultMutableTreeNode user = new DefaultMutableTreeNode("User");
		DefaultMutableTreeNode local = new DefaultMutableTreeNode("Local");
		DefaultMutableTreeNode remote = new DefaultMutableTreeNode("Remote");
		user.add(local);
		user.add(remote);
		treeNode.add(user);
		DefaultTreeModel dtm = new DefaultTreeModel(treeNode);
		this.tree.setModel(dtm);

	}
	
	public static void main(String[] args) {
		
		new myGui();

	}

}
