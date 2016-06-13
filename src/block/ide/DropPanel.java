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
import java.awt.Color;
import java.awt.Point;

@SuppressWarnings("serial")
public class DropPanel extends JPanel{
	public static DropParts[] ovs = new DropParts[500];
	public static int partsum = 0;
	private static int action = DnDConstants.ACTION_MOVE;
	public DropPanel(){
		super();
		setLayout(null);
		setBackground(Color.white);
		new DropTarget(this,action,dropTargetListener);

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
		if(selec == 0){
			//初回ブロック作成時にovsの空き状況をチェックして空いている箇所があれば埋める
			if(partsum != 0){
				int partsums = 0;
				for(int jj = 0 ; jj < partsum ; jj++){
					if(ovs[jj].visual == false){
						partsums = jj;
					}
				}
				if(partsums != 0){
					partsum = partsums;
				}else{
					partsum++;
				}
			}
			partss = sett.getMenu(ids);
			item.setText(partss.name);
			item.setID(partsum);
			item.setUID(ids);
			item.setLocation(droppedLocation);
			ovs[partsum] = new DropParts();
			ovs[partsum].id = partsum;
			ovs[partsum].partsid = partss.id;
			ovs[partsum].axis_x = droppedLocation.x;
			ovs[partsum].axis_y = droppedLocation.y;
			ovs[partsum].visual = true;
		}else{
			//登録済みブロックをDnDした時の処理
			partss  = sett.getMenubyUID(ids);
			item.setText(partss.name);
			item.setID(ids);
			item.setUID(partss.id);
			item.setLocation(droppedLocation);
			ovs[ids].id = ids;
			ovs[ids].partsid = partss.id;
			ovs[ids].axis_x = droppedLocation.x;
			ovs[ids].axis_y = droppedLocation.y;
			ovs[ids].visual = true;	
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
		for(int nn = 0 ; nn < partsum ; nn++){
			System.out.println("parts Num:"+nn+" parts ID:"+ovs[nn].partsid+" X="+ovs[nn].axis_x+" Y="+ovs[nn].axis_y);			
		}
		repaint();
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
