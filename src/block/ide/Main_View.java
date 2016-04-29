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
		Integer pane_wide = (dim.width-30)/13;
		Integer pane_heig = (dim.height-50)/13;
		JTabbedPane tabpane = new JTabbedPane();
		JPanel tab1 = new JPanel();
		tab1 = tab1_view(pane_wide,pane_heig,tab1);


		
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
	
	public JPanel tab1_view(Integer pane_wide,Integer pane_heig,JPanel tab1){
		JPanel parts_win = new JPanel();
		parts_win.setPreferredSize(new Dimension(pane_wide*5,pane_heig*13));
		parts_win.setBorder(new LineBorder(Color.red,2));
		JPanel main_win = new JPanel();
		main_win.setPreferredSize(new Dimension(pane_wide*8,pane_heig*13));
		main_win.setBorder(new LineBorder(Color.red,2));
		tab1.add(parts_win);
		tab1.add(main_win);
		return tab1;
	}
	
}
