package block.ide;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Draw_Parts extends Panel implements MouseListener,MouseMotionListener{
	private static final long serialVersionUID = 1L;
	//部品描画クラス
	int x1,y1;
	public void DrawPanel(JScrollPane scpane){
		setForeground(Color.red);
		setBackground(Color.white);
		//部品を保管するLabelを作成。とりあえず、部品の数は１００個
		//今後、XMLの要素数になるように変更する。
		JLabel[] label = new JLabel[100];
		
		addMouseMotionListener(this);
		addMouseListener(this);
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