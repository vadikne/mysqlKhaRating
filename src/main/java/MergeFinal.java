import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MergeFinal {
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet result;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //CompareKhaAndXml compareKhaAndXml = new CompareKhaAndXml();
       // compareKhaAndXml.main();
        List fpList=finalMerge();
        ExpToXLS.expToXLS(fpList);
    }

    public static List finalMerge() {
        List<FinalPlayer> finalPlayerList = new ArrayList<>(1300);
        int i =1;
  //      String SQL_query = "SELECT  ratekha.player, csvttw.*\n" +
  //              "FROM  csvttw right OUTER JOIN ratekha\n" +
  //              "ON  ratekha.player=csvttw.player\n" +
  //              "where locate('украина', csvttw.town)\n" +
  //              "group by csvttw.player, csvttw.town\n" +
  //              "order by ratekha.player";
        String SQL_query = " SELECT  ratekha.player, csvttw.* \n" +
                "FROM  csvttw right OUTER JOIN ratekha \n" +
                "ON  ratekha.player=csvttw.player\n" +
                "where csvttw.town like '%украина%'\n" +
                "or  csvttw.town like '%крым%'\n" +
                "or  csvttw.town like '%венгрия%'\n" +
                "group by csvttw.player, csvttw.town\n" +
                "order by ratekha.player";

        try {
            connection = DBConnection.getConnection();
            stmt = connection.createStatement();
            result = stmt.executeQuery(SQL_query);
            while (result.next()) {
                FinalPlayer player = new FinalPlayer();
                player.setNumber(i++);
                player.setName(result.getString("player"));
                player.setTown(result.getString("town"));
                player.setCups(result.getInt("cups"));
                player.setGames(result.getString("games"));
                player.setRating(result.getInt("rating"));
                player.setDelta(result.getString("delta"));
                player.setDate(result.getString("date"));
                finalPlayerList.add(player);
              //  System.out.println(player.toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {  }
            try {
                stmt.close();
            } catch (SQLException se) {  }
            try {
                result.close();
            } catch (SQLException se) {  }
        }
        return finalPlayerList;
    }
}