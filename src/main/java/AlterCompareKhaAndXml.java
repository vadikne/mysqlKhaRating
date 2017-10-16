import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlterCompareKhaAndXml {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        main();
    }

    public static void main() throws IOException, SAXException, ParserConfigurationException {
        List<Player> playerList=ImportXml.impXml("D:\\\\down\\\\xml\\\\1.xml");
        List<Player> khaPlayers=AlterReadRateKha.alterKhaRate("D:\\\\down\\\\csv\\\\kharkov.csv");
        List<Player> newPlayers = new ArrayList<>();

       for (Player playerXml : playerList){
         boolean b=false;
           for (Player khPlayer:khaPlayers){

             if (playerXml.getName().toString().equals(khPlayer.getName().toString())){
                 b=true;
                 continue;
             }
         }
         if (!b) newPlayers.add(playerXml);
       }
       OutputStream os = new FileOutputStream("D:\\\\down\\\\csv\\\\kharkov.csv",true);
       for (Player pl : newPlayers) {
           String string = ";"+pl.getName() + ";" + pl.getRegion()+", "+pl.getLocation()+"\n";
           os.write( string.getBytes("Cp1251") );
       }
       os.close();
    }
}
