package block.ide;

import java.io.*;

public class Check_Config_File {
	public File[] getPath(String base_path){
		//configファイルの一覧を取得し値を返す
		File dirs = new File(base_path);
		File[] files = dirs.listFiles();
		return files;
	}
}
