package block.ide;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.*;

public class Draw_Parts extends Panel implements MouseListener,MouseMotionListener{
	private static final long serialVersionUID = 1L;
	//部品描画クラス
	public static Menu_Icon[] lists_all;
	int x1,y1;
	public JScrollPane DrawPanel(Menu_Icon[] lists,int pane_wide,int pane_heig){
		JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setPreferredSize(new Dimension(pane_wide*5,pane_heig*13));
		pane.setBorder(new LineBorder(Color.green,2));
		JViewport jview = pane.getViewport();
		DragPanel panels = new DragPanel();

		//部品の数を抽出
		int i = 0;
		while(lists[i].id != 0){
			i++;
		}
		lists = sortList(lists);
		lists_all = lists;
		DragLabel[] label = new DragLabel[i];
		//グループするならlists[j].shapeで判断する
		//1:Control 2:Input 3:Output 4:Operators 5:Utility 6:Tools 7:Raspberry Pi 99:Other
		int grp_tmp = 0;
		int rile = 0;
		//開始座標
		int x = 0;
		int y = 0;
		int wide = 400;
		int heig = 20;
		for(int j = 0;j < i;j++){
			int shape_grp = lists[j].shape/1000;
			label[j] = new DragLabel();
			if(shape_grp == grp_tmp){
				if(rile == 0){
					x = 5;
					label[j].setText(lists[j].name);
					label[j].setBounds(x,y,100,50);
					label[j].setHorizontalAlignment(JLabel.CENTER);
					label[j].setVerticalAlignment(JLabel.CENTER);			
					label[j].setBorder(new LineBorder(Color.black,2));
					label[j].setID(lists[j].id);
					panels.add(label[j]);
					rile = 1;
				}else{
					x = x + 120;
					label[j].setText(lists[j].name);
					label[j].setBounds(x,y,100,50);
					label[j].setHorizontalAlignment(JLabel.CENTER);
					label[j].setVerticalAlignment(JLabel.CENTER);			
					label[j].setBorder(new LineBorder(Color.black,2));
					label[j].setID(lists[j].id);
					panels.add(label[j]);
					y = y + 55;
					rile = 0;
				}
				
			}else{
				grp_tmp = shape_grp;
				if(rile == 1){
					y = y + 55;
				}
				rile = 0;
				JLabel tlabel = new JLabel();
				if(grp_tmp == 1){
					tlabel.setText("Control");
					tlabel.setBackground(Color.cyan);
					tlabel.setOpaque(true);
					tlabel.setBounds(0, y, wide, heig);
				}else if(grp_tmp == 2){
					tlabel.setText("Input");
					tlabel.setBackground(Color.cyan);					
					tlabel.setOpaque(true);
					tlabel.setBounds(0, y, wide, heig);
				}else if(grp_tmp == 3){
					tlabel.setText("Output");
					tlabel.setBackground(Color.cyan);
					tlabel.setOpaque(true);
					tlabel.setBounds(0, y, wide, heig);
				}else if(grp_tmp == 4){
					tlabel.setText("Operation");
					tlabel.setBackground(Color.cyan);
					tlabel.setOpaque(true);
					tlabel.setBounds(0, y, wide, heig);
				}else if(grp_tmp == 5){
					tlabel.setText("Utility");
					tlabel.setBackground(Color.cyan);
					tlabel.setOpaque(true);
					tlabel.setBounds(0, y, wide, heig);
				}else if(grp_tmp == 6){
					tlabel.setText("Tools");
					tlabel.setBackground(Color.cyan);
					tlabel.setOpaque(true);
					tlabel.setBounds(0, y, wide, heig);
				}else if(grp_tmp == 7){
					tlabel.setText("Raspberry Pi");
					tlabel.setBackground(Color.cyan);
					tlabel.setOpaque(true);
					tlabel.setBounds(0, y, wide, heig);
				}else if(grp_tmp == 99){
					tlabel.setText("Other");
					tlabel.setBackground(Color.cyan);
					tlabel.setOpaque(true);
					tlabel.setBounds(0, y, wide, heig);
				}
				panels.add(tlabel);
				y = y + heig + 5;
				x=5;
				label[j].setText(lists[j].name);
				label[j].setBounds(x,y,100,50);
				label[j].setHorizontalAlignment(JLabel.CENTER);
				label[j].setVerticalAlignment(JLabel.CENTER);			
				label[j].setBorder(new LineBorder(Color.black,2));
				label[j].setID(lists[j].id);
				panels.add(label[j]);
				rile = 1;
			}
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
