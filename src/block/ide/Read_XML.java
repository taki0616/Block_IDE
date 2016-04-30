package block.ide;

import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.*;

public class Read_XML {
	public void config_read() throws Exception{
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docb = fac.newDocumentBuilder();
		Document docs = docb.parse(new File("../src/block/ide/config/c_block.xml"));
		Element root = docs.getDocumentElement();
		System.out.println(root.getNodeName());
	}

}
