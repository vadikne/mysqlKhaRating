import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by owner on 19.09.2017.
 */
public class AlterReadRateKha {
    public static void main(String[] args) {
        String csvFile = "D:\\\\down\\\\csv\\\\kharkov.csv";
        List<Player> khaPlayers=alterKhaRate(csvFile);
    }
    public static List alterKhaRate (String csvFile){
        List<Player> playerList = new ArrayList<>(1500);
        BufferedReader br = null;
        String line = "";
        String separ = ";";
        boolean firstLine = true;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "windows-1251"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                Player pl = new Player();
                String[] stringOfData = line.split(separ);
                pl.setName(stringOfData[1]);
                pl.setLocation(stringOfData[2]);
                playerList.add(pl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
         return playerList;
    }
}
