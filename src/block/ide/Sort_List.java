package block.ide;
import java.util.Comparator;

public final class Sort_List implements Comparator<Menu_Icon>{
	@Override
	public int compare(Menu_Icon mast,Menu_Icon slav){
		return Integer.compare(mast.shape, slav.shape);
	}
}
