
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ImportXml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{

        List <Player> playerList=impXml("D:\\\\down\\\\xml\\\\1.xml");
        for (Player pl:playerList) System.out.println(pl);
    }

public static List impXml(String filePath) throws ParserConfigurationException, IOException, SAXException{
    File file = new File(filePath);
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(file);
    //Element playersElement = (Element) document.getElementsByTagName("NewPlayers").item(0);
    NodeList playerNodeList = document.getElementsByTagName("Player");
    List<Player> playerList = new ArrayList<>();
    for (int i=0; i<playerNodeList.getLength();i++){
        if (playerNodeList.item(i).getNodeType()== Node.ELEMENT_NODE){
            Element playerElement = (Element) playerNodeList.item(i);

            Player player = new Player();
            NodeList childNodes = playerElement.getChildNodes();
            for (int j=0;j<childNodes.getLength();j++){
                if (childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){
                    Element childElement = (Element) childNodes.item(j);
                    switch (childElement.getNodeName()){
                        case "name" : {
                            String line=childElement.getTextContent().replaceAll("\\?","" );
                            player.setName(line);
                        }   break;
                        case "region" : {
                            player.setRegion(childElement.getTextContent());
                        }   break;
                        case "location" : {
                            player.setLocation(childElement.getTextContent());
                        }
                    }
                }
            }
            playerList.add(player);
        }
    }
    //playerList.forEach(System.out::println);
    for (int i=playerList.size()-1; i>0; i--){
        if (playerList.get(i).getName()==null)playerList.remove(i);
    }

    //for (Player pl:playerList) System.out.println(pl);
    return playerList;
}
}
