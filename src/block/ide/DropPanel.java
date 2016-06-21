package block.ide;
import javax.swing.JPanel;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

@SuppressWarnings("serial")
public class DropPanel extends JPanel{
	private static int action = DnDConstants.ACTION_MOVE;

	public DropPanel(){
		super();
		setLayout(null);
		setBackground(Color.white);
		new DropTarget(this,action,dropTargetListener);

	}
	public boolean setConnectData(int ida,int idb){
		//ida:接続元オブジェクト
		//idb:接続先オブジェクト
		if(ida != idb){
			DropParts plist = new DropParts();
			for(int jj = 0 ; jj < DrawManage.partsum ; jj++){
				plist = DrawManage.drawparts[jj];
				if(plist.id == ida || plist.id == idb){
					if(plist.coaid == 9999){
						if(plist.id == ida){
							DrawManage.lines[DrawManage.linesum].id = DrawManage.linesum;
							DrawManage.lines[DrawManage.linesum].x11 = plist.axis_x;
							DrawManage.lines[DrawManage.linesum].y11 = plist.axis_y;
							DrawManage.linesum++;

							plist.coaid = idb;
						}else{
							plist.coaid = ida;
						}
					}else if(plist.cobid == 9999){
						if(plist.id == ida){
							plist.cobid = idb;
						}else{
							plist.cobid = ida;
						}						
					}else if(plist.cocid == 9999){
						if(plist.id == ida){
							plist.cocid = idb;
						}else{
							plist.cocid = ida;
						}
					}else if(plist.codid == 9999){
						if(plist.id == ida){
							plist.codid = idb;
						}else{
							plist.codid = ida;
						}
					}else{
						return false;
					}
					DrawManage.drawparts[jj] = plist; 
				}
			}
			return true;
		}
		return false;
	}
	public void addDroppedText(String text,Point droppedLocation){
		DragLabel item = new DragLabel();
		int ids;
		int selec;
		String check_po = text.substring(0,1);
		String strcom = text.substring(2-1);
		ids = Integer.parseInt(strcom);	
		if(check_po.equals("F")){
			selec = 0;
		}else{
			selec = 1;
		}
		PartsData sett = new PartsData();
		Menu_Icon partss = new Menu_Icon();
		System.out.println("Text:"+text+" IDS:"+ids+" SELEC:"+selec);

		if(selec == 0){
			//初回ブロック作成時にDrawManage.drawpartsをチェックして空いている箇所があれば埋める
			int partsums = 0;
			if(DrawManage.partsum != 0){
				for(int jj = 0 ; jj < DrawManage.partsum ; jj++){
					if(DrawManage.drawparts[jj].visual == false){
						partsums = jj;
					}
				}
				if(partsums != 0){
					DrawManage.partsum = partsums;
				}
			}
			partss = sett.getMenu(ids);
			item.setText(partss.name);
			item.setID(DrawManage.partsum);
			item.setUID(ids);
			item.setLocation(droppedLocation);
			item.setName(String.valueOf(DrawManage.partsum));
			DrawManage.drawparts[DrawManage.partsum] = new DropParts();
			DrawManage.drawparts[DrawManage.partsum].id = DrawManage.partsum;
			DrawManage.drawparts[DrawManage.partsum].partsid = partss.id;
			DrawManage.drawparts[DrawManage.partsum].axis_x = droppedLocation.x;
			DrawManage.drawparts[DrawManage.partsum].axis_y = droppedLocation.y;
			DrawManage.drawparts[DrawManage.partsum].visual = true;
			DrawManage.drawparts[DrawManage.partsum].coaid = 9999;
			DrawManage.drawparts[DrawManage.partsum].cobid = 9999;
			DrawManage.drawparts[DrawManage.partsum].cocid = 9999;
			DrawManage.drawparts[DrawManage.partsum].codid = 9999;
			if(partsums == 0){
				DrawManage.partsum++;
			}
		}else{
			//登録済みブロックをDnDした時の処理
			partss  = sett.getMenubyUID(ids);
			item.setText(partss.name);
			item.setID(ids);
			item.setUID(partss.id);
			item.setLocation(droppedLocation);
			item.setName(String.valueOf(ids));
			DrawManage.drawparts[ids].id = ids;
			DrawManage.drawparts[ids].partsid = partss.id;
			DrawManage.drawparts[ids].axis_x = droppedLocation.x;
			DrawManage.drawparts[ids].axis_y = droppedLocation.y;
		}
		DSLabelListener l = new DSLabelListener(){
			public void requestRemove(DragLabel dsl){			
				remove(dsl);
				revalidate();
				repaint();
			}
		};
		item.addListener(l);
		add(item);
		repaint();
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setPaint(Color.PINK);
		g2.draw(new Line2D.Double(30.0d, 120.0d, 250.0d, 70.0d));
	}
	private DropTargetListener dropTargetListener = new DropTargetListener(){
		public void drop (DropTargetDropEvent e){
			e.acceptDrop(action);
			Transferable tr = e.getTransferable();
			boolean gotData = false;
			try{
				String data = null;
				if(e.isDataFlavorSupported(DataFlavor.stringFlavor)){
					data = (String)tr.getTransferData(DataFlavor.stringFlavor);
				}
				if(data!=null){
					gotData = true;
					Point droppedLocation = e.getLocation();
					addDroppedText(data,droppedLocation);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				e.dropComplete(gotData);
			}
		}
		public void dragOver(DropTargetDragEvent dtde){
			
		}
		public void dragExit(DropTargetEvent dte){
			
		}
		public void dragEnter(DropTargetDragEvent dtde){
			
		}
		public void dropActionChanged(DropTargetDragEvent dtde){
			
		}
	};
}
