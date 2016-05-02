package block.ide.lang;

import java.util.Locale;
import java.util.ResourceBundle;
	
public enum MsgTrans {
	TABNAME01,
	TABNAME02,
	TABNAME03,
	TABNAME04,
	TABNAME05;
	
	@Override public String toString(){
		try{
			return ResourceBundle.getBundle("block.ide.lang.MSG",Locale.getDefault()).getString(name());
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}
