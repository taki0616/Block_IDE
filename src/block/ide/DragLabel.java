package block.ide;

import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.Color;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class DragLabel extends JLabel{
	public DragLabel(){
		super();
		int dragAction = DnDConstants.ACTION_MOVE;
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setSize(100,50);
		setBorder(new LineBorder(Color.black,2));
		setBackground(Color.white);
		setOpaque(true);
		
		new DragSource().createDefaultDragGestureRecognizer(this, dragAction,dgl);
	}
	private DragGestureListener dgl = new DragGestureListener(){
		public void dragGestureRecognized(DragGestureEvent e){
			System.out.println("ドラッグ開始");
			System.out.println(getText());
			String text = getText();
			Cursor dragCursor = DragSource.DefaultCopyDrop;
			StringSelection transferable = new StringSelection(text);
			e.startDrag(dragCursor, transferable);
		}
	};
}
