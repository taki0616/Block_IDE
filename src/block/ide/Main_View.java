package block.ide;

import javax.swing.*;
import java.awt.*;

public class Main_View extends JApplet{
	private static final long serialVersionUID = 1L;
	public void init(){
		JTabbedPane tabpane = new JTabbedPane();
		JPanel tab1 = new JPanel();
		tab1.add(new JButton("Button1"));
		JPanel tab2 = new JPanel();
		tab2.add(new JButton("Button2"));
		JPanel tab3 = new JPanel();
		tab3.add(new JButton("Button3"));
		JPanel tab4 = new JPanel();
		tab4.add(new JLabel("Infomation"));
		tabpane.addTab("Block",tab1);
		tabpane.addTab("Text",tab2);
		tabpane.addTab("Config", tab3);
		tabpane.addTab("Help", tab4);
		
		Container contentPane = getContentPane();
		contentPane.add(tabpane, BorderLayout.CENTER);
	}
	
}
