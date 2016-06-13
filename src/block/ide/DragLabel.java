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
	public int uid;
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
		id = ids;
	}
	public void setUID(int uds){
		uid = uds;
	}
	public int getUID(){
		return uid;
	}
	private ArrayList<DSLabelListener> listenerList = new ArrayList<DSLabelListener>();
	public void addListener(DSLabelListener l){
		listenerList.add(l);
	}
	private DragGestureListener dgl = new DragGestureListener(){
		public void dragGestureRecognized(DragGestureEvent e){
			//DragLabelベースからovs主体に変更が必要
			String text;
			if(getUID() == 0){
				text = "F"+String.valueOf(getID());				
			}else{
				text = "S"+String.valueOf(getID());
			}
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
				for(int i = 0 ; i < listenerList.size() ; i++){
					DSLabelListener l = (DSLabelListener)listenerList.get(i);
					l.requestRemove(DragLabel.this);
				}
			}
			
		}
	};
}
