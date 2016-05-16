package block.ide;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.*;

public class Draw_Parts extends Panel implements MouseListener,MouseMotionListener{
	private static final long serialVersionUID = 1L;
	//部品描画クラス
	int x1,y1;
	public JScrollPane DrawPanel(Menu_Icon[] lists,int pane_wide,int pane_heig){
		JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setPreferredSize(new Dimension(pane_wide*5,pane_heig*13));
		pane.setBorder(new LineBorder(Color.green,2));
		JViewport jview = pane.getViewport();
		JPanel panels = new JPanel();
		panels.setLayout(null);
		panels.setBackground(Color.white);

		//部品の数を抽出
		int i = 0;
		while(lists[i].id != 0){
			i++;
		}
		lists = sortList(lists);
		JLabel[] label = new JLabel[i];
		//グループするならlists[j].shapeで判断する
		//(int)(shape/100)
		//1:Control 2:Input 3:Output 4:Operators 5:Utility 6:Tools 7:Raspberry Pi 99:Other
		for(int j = 0;j < i;j++){
			label[j] = new JLabel();
			label[j].setText(lists[j].name);
			label[j].setBounds(5,j*50+j*5+5,100,50);
			label[j].setHorizontalAlignment(JLabel.CENTER);
			label[j].setVerticalAlignment(JLabel.CENTER);			
			label[j].setBorder(new LineBorder(Color.black,2));
			panels.add(label[j]);
		}
		jview.add(panels);
		
		addMouseMotionListener(this);
		addMouseListener(this);
		return pane;
	}
	public Menu_Icon[] sortList(Menu_Icon[] list_org){
		ArrayList<Menu_Icon> templist = new ArrayList<Menu_Icon>();
		int i = 0;
		while(list_org[i].id != 0){
			templist.add(list_org[i]);
			i++;
		}	
		Collections.sort(templist,new Sort_List());
		Menu_Icon[] list_sort = (Menu_Icon[])templist.toArray(new Menu_Icon[0]);
		return list_sort;
	}
	public void mousePressed(MouseEvent e){
		
	}
	public void mouseDragged(MouseEvent e){
		
	}
	public void mouseMoved(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		
	}
	public void mouseEntered(MouseEvent e){
		
	}
	public void mouseExited(MouseEvent e){
		
	}
	public void mouseClicked(MouseEvent e){
		
	}
}
