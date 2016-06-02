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
		int ids = Integer.parseInt(text);
		PartsData sett = new PartsData();
		Menu_Icon partss = new Menu_Icon();
		partss = sett.getMenu(ids);
		item.setText(partss.name);
		item.setID(ids);
		item.setLocation(droppedLocation);
		ovs[partsum] = new DropParts();
		ovs[partsum].id = partsum;
		ovs[partsum].partsid = partss.id;
		partsum++;
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
