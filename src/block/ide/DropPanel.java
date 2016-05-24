package block.ide;
import javax.swing.JPanel;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

@SuppressWarnings("serial")
public class DropPanel extends JPanel implements Transferable,DropTargetListener{
	private static final DataFlavor myFlavor = new DataFlavor(DropPanel.class,"DropPanel");
	public DropPanel(){
		new DropTarget(this,DnDConstants.ACTION_COPY,this);
	}
	@Override
	public DataFlavor[] getTransferDataFlavors(){
		return new DataFlavor[] {myFlavor};
	}
	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException,IOException{
		String fla = flavor.getHumanPresentableName();
		System.out.println("FLAVOR:"+fla);
		return this;
	}
	@Override
	public void drop(DropTargetDropEvent dtde){
		System.out.println("Drop Start");
		dtde.acceptDrop(DnDConstants.ACTION_COPY);
		Transferable tr = dtde.getTransferable();
		
		try{
			if(dtde.isDataFlavorSupported(myFlavor)){
				DragLabel lbl = (DragLabel)tr.getTransferData(myFlavor);
				System.out.println(lbl.getText());
			}else{
				System.out.println("Not Supported!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void dropActionChanged(DropTargetDragEvent dtde){

	}
	@Override
	public void dragExit(DropTargetEvent dte){
		
	}
	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return true;
	}
}
