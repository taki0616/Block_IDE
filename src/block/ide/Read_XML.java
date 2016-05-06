package block.ide;

import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import block.ide.Check_Config_File.*;

public class Read_XML {
	public void init_config_read() throws Exception{
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docb = fac.newDocumentBuilder();
		Check_Config_File ccf = new Check_Config_File();
		File[] file_path = ccf.getPath("../src/block/ide/config/");
		String paths = file_path[0].getPath();
		xml_node_read(paths,docb);
		//ここから先は別のメソッドにする
		
	}

	public void config_read(String pathname) throws Exception{
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docb = fac.newDocumentBuilder();
		Check_Config_File ccf = new Check_Config_File();
		File[] file_path = ccf.getPath(pathname);
		String paths = file_path[0].getPath();
		Document docs = docb.parse(new File(paths));
		Element root = docs.getDocumentElement();
		System.out.println(root.getNodeName());
	}
	public void xml_node_read(String paths,DocumentBuilder docb){
		Document docs;
		try {
			docs = docb.parse(new File(paths));
			Element root = docs.getDocumentElement();
			System.out.println(root.getNodeName());
			NodeList rootch = root.getChildNodes();
			System.out.println(rootch.getLength());
			for(int i=0;i < rootch.getLength();i++){
				Node node = rootch.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element elem = (Element)node;
					if(elem.getNodeName().equals("BLOCK")){
						NodeList perch = node.getChildNodes();
						for(int j=0;j<perch.getLength();j++){
							Node perno = perch.item(j);
							if(perno.getNodeType() == Node.ELEMENT_NODE){
								System.out.println(perno.getNodeName());
							}
							
						}
					}
				}
			}

		} catch (SAXException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
