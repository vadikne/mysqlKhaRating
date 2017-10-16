import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompareKhaAndXml {
    private static Connection connection;
    private static PreparedStatement ps;


    public static void main() throws IOException, SAXException, ParserConfigurationException {
        List<Player> playerList=ImportXml.impXml("D:\\\\down\\\\xml\\\\1.xml");
        List<Player> khaPlayers=ReadRateKha.khaRate();
        List<Player> notNewPlayers = new ArrayList<>();
        for (Player playerXml : playerList){
            for (Player khaPlayer : khaPlayers){
                String play=playerXml.getName();
                if (play.equals(khaPlayer.getName()))notNewPlayers.add(playerXml);
            }
        }
        for (int i=0;i<notNewPlayers.size();i++){
            Iterator<Player> iter = playerList.iterator();
            while (iter.hasNext()) {
                Player s = iter.next();

                if (s.getName().equals(notNewPlayers.get(i).getName())) {
                    iter.remove();
                }
            }
        }
        for (Player pl : playerList) System.out.println("rez - "+pl.getName()+" "+pl.getLocation());

        try {
            connection = DBConnection.getConnection();
            String sqlPrepared = "insert into test_csv.ratekha (player, town) values (?, ?)";
             ps = connection.prepareStatement(sqlPrepared);
                for (Player pl : playerList) {
                    ps.setString(1, pl.getName());
                    ps.setString(2, pl.getLocation());
                    ps.addBatch();
                }
                int [] insertedRows = ps.executeBatch();
            System.out.println("Добавлено " + insertedRows.length + " новых участников");
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
              e.printStackTrace();

        } finally {
             try {
                 connection.close();
             } catch (SQLException se) { /*can't do anything */ }
              try {
                  ps.close();
              } catch (SQLException se) { /*can't do anything */ }

          }
      }

    }
