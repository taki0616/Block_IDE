package block.ide;

import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
//import block.ide.Check_Config_File.*;

public class Read_XML {
	public Menu_Icon[] init_config_read() throws Exception{
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docb = fac.newDocumentBuilder();
		Check_Config_File ccf = new Check_Config_File();
		File[] file_path = ccf.getPath("../src/block/ide/config/");
		String paths = file_path[0].getPath();
		return xml_node_read(paths,docb);		
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
	public Menu_Icon[] xml_node_read(String paths,DocumentBuilder docb){
		Document docs;
		Menu_Icon[] menus = new Menu_Icon[100];
		for(int i=0;i<100;i++){
			menus[i] = new Menu_Icon();
		}
		try {
			int sttemp = 0;
			int flag = 0;
			docs = docb.parse(new File(paths));
			Element root = docs.getDocumentElement();
			NodeList rootch = root.getChildNodes();
			if(rootch.getLength() < 50){
				for(int i=0;i < rootch.getLength();i++){
					Node node = rootch.item(i);
					if(node.getNodeType() == Node.ELEMENT_NODE){
						Element elem = (Element)node;
						if(elem.getNodeName().equals("BLOCK")){
							NodeList perch = node.getChildNodes();
							for(int j=0;j<perch.getLength();j++){
								Node perno = perch.item(j);
								if(perno.getNodeType() == Node.ELEMENT_NODE){
									if(!perno.getTextContent().isEmpty()){
										if(perno.getNodeName().equals("ID")){
											if(flag != 0){
												sttemp++;
											}
											flag++;
											menus[sttemp].id = Integer.parseInt(perno.getTextContent());;
										}else if(perno.getNodeName().equals("NAME")){
											menus[sttemp].name = perno.getTextContent();
										}else if(perno.getNodeName().equals("COLOR")){
											menus[sttemp].color_no = perno.getTextContent();									
										}else if(perno.getNodeName().equals("SHAPE")){
											menus[sttemp].shape = Integer.parseInt(perno.getTextContent());
										}else if(perno.getNodeName().equals("VAL_NUM")){
											menus[sttemp].value_num = Integer.parseInt(perno.getTextContent());
										}else if(perno.getNodeName().equals("VAL_NAME")){
											menus[sttemp].value_name = perno.getTextContent();
										}else if(perno.getNodeName().equals("VAL_LABEL")){
											menus[sttemp].value_label = perno.getTextContent();										
										}else if(perno.getNodeName().equals("CODE")){
											menus[sttemp].code = perno.getTextContent();
										}else if(perno.getNodeName().equals("END_CODE")){
											menus[sttemp].end_code = perno.getTextContent();
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (SAXException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return menus;
	}
	public String getLabelTitle(int id){
		String label_name = new String();
		
		return label_name;
	}
}
