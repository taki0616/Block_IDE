package block.ide;

import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.util.ArrayList;
import java.awt.PopupMenu;
import java.awt.MenuItem;

@SuppressWarnings("serial")
public class DragLabel extends JLabel implements MouseListener{
	public int id;
	public int uid;
	public boolean isConnectMODE = false;
	
	PopupMenu pop = new PopupMenu();
	public DragLabel(){
		super();
		int dragAction = DnDConstants.ACTION_MOVE;
		System.out.println("this:"+this.id);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setSize(100,50);
		setBorder(new LineBorder(Color.black,2));
		setBackground(Color.white);
		setOpaque(true);
		setID(id);
		addPopupMenuItem("Connect",this.id,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				isConnectMODE = true;
				setPartsNo();
			}
		});
		addPopupMenuItem("Delete",this.id,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Select");				
			}
		});
		addPopupMenuItem("Value Input",this.id,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Value Select");				
			}
		});
		add(pop);
		addMouseListener(this);		
		new DragSource().createDefaultDragGestureRecognizer(this, dragAction,dgl);
	}
	public void setPartsNo(){
			DrawManage.select_parts=Integer.parseInt(getName());		
	}
	private void connect_line(){
		if(Integer.parseInt(getName()) != DrawManage.select_parts){
			//接続情報を格納
			
			//Lineを描画する
			
			
		}
		isConnectMODE = false;
	}
	private MenuItem addPopupMenuItem(String name,int id,ActionListener a){
		MenuItem item = new MenuItem(name);
		item.addActionListener(a);
		item.setName(String.valueOf(id));
		pop.add(item);
		return item;
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
	@Override
	public void mouseClicked(MouseEvent e) {
		//クリックしたラベルのコンポーネント名を取得
		if(isConnectMODE == true){
			connect_line();
			
		}else{
			pop.show(this,e.getX(),e.getY());
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
