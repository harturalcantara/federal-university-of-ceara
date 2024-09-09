/*package application;


import java.io.File;
import java.util.List;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlFile{

	private Element rootNode;
	public String path;

	public XmlFile(String filePath){
		
		this.path = path;
		SAXBuilder builder = new SAXBuilder();
	  	File xmlFile = new File(filePath);

	  	try{

			Document document = (Document) builder.build(xmlFile);
			this.rootNode = document.getRootElement();

		}catch (IOException io) {
			
			System.out.println(io.getMessage());
		}
		catch (JDOMException jdomex) {
			
			System.out.println(jdomex.getMessage());
		}
	}

	public String getElement(String element){
		
		try {
			
			return this.rootNode.getChildText(element);
		
		}catch(Exception e){
			
			System.out.println("Error while getting xml Element...");
			return null;
		}
	}

	public boolean IsNotNull(){

		return this.rootNode != null;
	}
}*/