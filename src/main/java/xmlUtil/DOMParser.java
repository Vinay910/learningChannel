package xmlUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {
	NodeList nodeList;
	List<User> usr; 
	DocumentBuilder builder ;
	Document document; 
	DocumentBuilderFactory factory;
	int counter=0;
	String filepath="../learningchannel/src/main/java/resources/UserDetails.xml";
	public void DOMParserIntial(String user,String eMail) throws Exception
	{
	  factory = DocumentBuilderFactory.newInstance();
      builder = factory.newDocumentBuilder();
      document = builder.parse(new File(filepath));
      usr = new ArrayList<User>();
      nodeList = document.getDocumentElement().getChildNodes();
      for (int i = 0; i < nodeList.getLength(); i++) 
      {
           Node node = nodeList.item(i);
           if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                int ID =Integer.parseInt( node.getAttributes().getNamedItem("ID").getNodeValue());
                String Name = elem.getElementsByTagName("Name")
                                    .item(0).getChildNodes().item(0).getNodeValue();
                String Email = elem.getElementsByTagName("Email").item(0)
                                    .getChildNodes().item(0).getNodeValue();
                usr.add(new User(ID,Name,Email));
           }
      }
      checkUser(user, eMail);
 }
	private void checkUser(String user,String eMail) throws Exception
	{
		User u=null;
		boolean noEntryFlag=true;
		for(int i=0;i<usr.size();i++)
		{
			u=usr.get(i);
			if(u.getName().equalsIgnoreCase(user)&&u.getEmail().equalsIgnoreCase(eMail))
			{
				System.out.println("User data is already present in the Database");
				noEntryFlag=false;
				break;
			}
			else if(u.getName().equalsIgnoreCase(user))
			{
				System.out.println(user+" email address is updated to "+eMail);
				updatingEmailXML(eMail,i);
				noEntryFlag=false;
			}
			counter++;
		}
		if(noEntryFlag)
		{
		enteringUserXML(user,eMail);
		System.out.println(user+" is added to the Database");
		}
	}
	private void updatingEmailXML(String email,int i) throws Exception
	{
		document.getElementsByTagName("Email").item(i).setTextContent(email);
		WritingXML();
	}
	private void enteringUserXML(String user,String eMail) throws Exception
	{
		 counter=counter+1;
		 document = builder.parse(new FileInputStream(new File(filepath)));
         Element element = document.getDocumentElement();
	     Node node = document.createElement("User");
	     ((Element)node).setAttribute("ID", counter+"");
	     element.appendChild(node);
	     Node name=document.createElement("Name");
	     name.setTextContent(user);
	     node.appendChild(name);
	     Node mail=document.createElement("Email");
	     mail.setTextContent(eMail);
	     node.appendChild(mail);
	     WritingXML();
	}
	private void WritingXML() throws Exception
	{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);
	}
}
