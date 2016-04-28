package block.ide;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.Locale;
import block.ide.lang.MsgTrans;

public class Main_View extends JApplet{
	private static final long serialVersionUID = 1L;
	public void init(){
//		Locale defaultLocale = Locale.getDefault();
		Locale.setDefault(Locale.US);
		resize(800,600);
		Dimension dim = getSize();
		Integer pane_wide = (dim.width-20)/13;
		Integer pane_heig = (dim.height-20)/13;
			JTabbedPane tabpane = new JTabbedPane();
		JPanel tab1 = new JPanel();
		JPanel parts_win = new JPanel();
		parts_win.setPreferredSize(new Dimension(pane_wide*5,pane_heig*10));
		parts_win.setBorder(new LineBorder(Color.red,2));
		JPanel main_win = new JPanel();
		main_win.setPreferredSize(new Dimension(pane_wide*8,pane_heig*10));
		main_win.setBorder(new LineBorder(Color.red,2));
		tab1.add(parts_win);
		tab1.add(main_win);
		
		JPanel tab2 = new JPanel();
		tab2.add(new JButton("Button2"));
		JPanel tab3 = new JPanel();
		tab3.add(new JButton("Button3"));
		JPanel tab4 = new JPanel();
		tab4.add(new JLabel("Infomation"));
		tabpane.addTab(MsgTrans.TABNAME01.toString(),tab1);
		tabpane.addTab(MsgTrans.TABNAME02.toString(),tab2);
		tabpane.addTab(MsgTrans.TABNAME03.toString(), tab3);
		tabpane.addTab(MsgTrans.TABNAME04.toString(), tab4);
		
		Container contentPane = getContentPane();
		contentPane.add(tabpane, BorderLayout.CENTER);
	}
	
}
