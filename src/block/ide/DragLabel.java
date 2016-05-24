package block.ide;

import javax.swing.JLabel;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.IOException;
import java.awt.Color;

@SuppressWarnings("serial")
public class DragLabel extends JLabel implements Transferable,DragGestureListener,DropTargetListener{
	private static final DataFlavor myFlavor = new DataFlavor(DragLabel.class,"DragLabel");
	public DragLabel(String text,Color color){
		super(text);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setBackground(color);
		setOpaque(true);
		
		new DragSource().createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY,this);
		new DropTarget(this,DnDConstants.ACTION_COPY,this);
	}
	@Override
	public void dragGestureRecognized(DragGestureEvent dge){
		System.out.println("ドラッグ開始");
		System.out.println(getText());
		dge.startDrag(DragSource.DefaultMoveDrop, this);
	}
	@Override
	public DataFlavor[] getTransferDataFlavors(){
		return new DataFlavor[] {myFlavor};
	}
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor){
		return true;
	}
	@Override
	public void drop(DropTargetDropEvent dtde){
		System.out.println("ドロップ開始");
		dtde.acceptDrop(DnDConstants.ACTION_COPY);
		Transferable tr = dtde.getTransferable();
		
		try{
			if(dtde.isDataFlavorSupported(myFlavor)){
				DragLabel lbl = (DragLabel)tr.getTransferData(myFlavor);
				System.out.println(getText());
				System.out.println(lbl.getText());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void dragEnter(DropTargetDragEvent dtde){
		
	}
	@Override
	public void dragOver(DropTargetDragEvent dtde){
		
	}
	@Override
	public void dropActionChanged(DropTargetDragEvent dtde){
		
	}
	@Override
	public void dragExit(DropTargetEvent dte){
		
	}
	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
