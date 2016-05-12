package block.ide;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Draw_Parts extends Panel implements MouseListener,MouseMotionListener{
	private static final long serialVersionUID = 1L;
	//部品描画クラス
	int x1,y1;
	public JScrollPane DrawPanel(Menu_Icon[] lists,int pane_wide,int pane_heig){
		JScrollPane pane = new JScrollPane();
//		pane.setLayout(new FlowLayout());
		pane.setPreferredSize(new Dimension(pane_wide*5,pane_heig*13));
		pane.setBorder(new LineBorder(Color.green,2));
		JViewport jview = pane.getViewport();

		//部品の数を抽出
		int i = 0;
		while(lists[i].id != 0){
			i++;
		}
		JTextField text = new JTextField();
		JLabel label1 = new JLabel("TEST");
		jview.add(label1);
		jview.add(text);
		JLabel[] label = new JLabel[i];
		for(int j = 0;j < i;j++){
			label[j] = new JLabel();
			label[j].setText(lists[j].name);
//			pane.add(label[j]);			
		}
		
//		addMouseMotionListener(this);
//		addMouseListener(this);
		return pane;
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
