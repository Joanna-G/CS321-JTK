
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.awt.*;

public class myGui{

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
	
	public myGui(){  //Constructor initialization
		
		initGui();
	}
	
	public void initGui(){
		
		frame = new JFrame("JTK Email System");
		//frame.setLayout(new FlowLayout());
		toolBar = new JToolBar();
	//	panel = new JPanel();
		//label = new JLabel("User");
		area = new JTextArea();
		area.setBackground(Color.CYAN);
		//area.setEditable(false);

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
		
		DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode("Sample Email");
		DefaultMutableTreeNode user = new DefaultMutableTreeNode("User");
		DefaultMutableTreeNode local = new DefaultMutableTreeNode("Local");
		DefaultMutableTreeNode site = new DefaultMutableTreeNode("Site");
		user.add(local);
		user.add(site);
		treeNode.add(user);
		DefaultTreeModel dtm = new DefaultTreeModel(treeNode);
		this.tree.setModel(dtm);

	}
	
	public static void main(String[] args) {
		
		new myGui();

	}

}
