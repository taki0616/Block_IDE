package block.ide;

import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DragLabel extends JLabel{
	public int id;
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
	public int getID(){
		return id;
	}
	public void setID(int ids){
		System.out.println("IDS : "+ids);
		id = ids;
	}
	private ArrayList listenerList = new ArrayList();
	public void addListener(DSLabelListener l){
		listenerList.add(l);
	}
	private DragGestureListener dgl = new DragGestureListener(){
		public void dragGestureRecognized(DragGestureEvent e){
			System.out.println("ドラッグ開始");
			System.out.println(getID());
			
			String text = String.valueOf(getID());
			Cursor dragCursor = DragSource.DefaultCopyDrop;
			StringSelection transferable = new StringSelection(text);
			e.startDrag(dragCursor, transferable,dsl);
		}
	};
	private DragSourceListener dsl = new DragSourceListener(){
		@Override
		public void dragEnter(DragSourceDragEvent dsde) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void dragOver(DragSourceDragEvent dsde) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void dropActionChanged(DragSourceDragEvent dsde) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void dragExit(DragSourceEvent dse) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void dragDropEnd(DragSourceDropEvent dsde) {
			if(dsde.getDropSuccess()){
				System.out.print("Drop!!");
				for(int i = 0 ; i < listenerList.size() ; i++){
					DSLabelListener l = (DSLabelListener)listenerList.get(i);
					l.requestRemove(DragLabel.this);
				}
			}
			
		}
	};
}
