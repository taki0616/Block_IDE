package block.ide;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.Locale;
import block.ide.lang.MsgTrans;
import block.ide.Read_XML;

public class Main_View extends JApplet{
	private static final long serialVersionUID = 1L;
	public void init(){
	//メイン画面描画クラス

	//多言語対応
//		Locale defaultLocale = Locale.getDefault();
		Locale.setDefault(Locale.US);
	//画面サイズ指定
		resize(800,600);
	//画面サイズ取得
		Dimension dim = getSize();
	//XMLからパーツデータ読み込み
		Read_XML rxml = new Read_XML();
		Menu_Icon[] lists = new Menu_Icon[100];
		try {
			lists = rxml.init_config_read();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	//パネルの幅を基準値の設定
		Integer pane_wide = (dim.width-30)/13;
		Integer pane_heig = (dim.height-50)/13;
	//タブペインの初期化
		JTabbedPane tabpane = new JTabbedPane();
	//Block Programタブの生成
		JPanel tab1 = new JPanel();
		tab1 = tab1_view(pane_wide,pane_heig,tab1,lists);

	//Code Programタブの生成
		JPanel tab2 = new JPanel();
		tab2.add(new JButton("Button2"));
		
	//Executeタブの生成
		JPanel tab3 = new JPanel();
		tab3.add(new JButton("Button3"));
		
	//Configタブの生成
		JPanel tab4 = new JPanel();
		tab4.add(new JLabel("Infomation"));

	//Helpタブの生成
		JPanel tab5 = new JPanel();
		tab4.add(new JLabel("Infomation"));

	//タブ名の設定
		tabpane.addTab(MsgTrans.TABNAME01.toString(),tab1);
		tabpane.addTab(MsgTrans.TABNAME02.toString(),tab2);
		tabpane.addTab(MsgTrans.TABNAME03.toString(), tab3);
		tabpane.addTab(MsgTrans.TABNAME04.toString(), tab4);
		tabpane.addTab(MsgTrans.TABNAME05.toString(), tab5);

		
	//タブの表示
		Container contentPane = getContentPane();
		contentPane.add(tabpane, BorderLayout.CENTER);
	}
	
	public JPanel tab1_view(Integer pane_wide,Integer pane_heig,JPanel tab1,Menu_Icon[] lists){
		//JScrollPane parts_win = new JScrollPane();
		Draw_Parts dpf = new Draw_Parts();
		JScrollPane parts_win = dpf.DrawPanel(lists);
		parts_win.setPreferredSize(new Dimension(pane_wide*5,pane_heig*13));
		parts_win.setBorder(new LineBorder(Color.red,2));
		JScrollPane main_win = new JScrollPane();
		main_win.setPreferredSize(new Dimension(pane_wide*8,pane_heig*13));
		main_win.setBorder(new LineBorder(Color.red,2));
		tab1.add(parts_win);
		tab1.add(main_win);
		return tab1;
	}
	
}
