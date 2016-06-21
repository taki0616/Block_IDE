package block.ide;

public class DrawManage {
	public static DropParts[] drawparts = new DropParts[500];
	public static int partsum = 0; 
	public static int select_parts = 0;
	public static LineParts[] lines = new LineParts[500];
	public static int linesum = 0;
	
	public int getX(int id){
		int ret = 0;
		int ids = searchID(id);
		ret = drawparts[ids].axis_x;
		return ret;
	}
	public int getY(int id){
		int ret = 0;
		int ids = searchID(id);
		ret = drawparts[ids].axis_y;
		return ret;
	}
	public void setX(int id,int x){
		int ids = searchID(id);
		drawparts[ids].axis_x = x;
	}
	public void setY(int id,int y){
		int ids = searchID(id);
		drawparts[ids].axis_y = y;		
	}
	public int searchID(int id){
		for(int i = 0 ; i < partsum ; i++){
			if(drawparts[i].id == id){
				return i;				
			}
		}
		return -1;
	}
}
