import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadRateKha {
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet result;

    public static void main(String[] args) {
    List<Player> khaPlayers=khaRate();
    for (Player pl:khaPlayers) System.out.println(pl);
    }

    public static List khaRate (){
        List<Player> playerList = new ArrayList<>();
        String SQL_query = "SELECT * FROM test_csv.ratekha";
        try {
            connection = DBConnection.getConnection();
            stmt = connection.createStatement();
            result = stmt.executeQuery(SQL_query);
            while (result.next()) {
                Player player = new Player();
                player.setName(result.getString("player"));
                player.setLocation(result.getString("town"));
                playerList.add(player);
                System.out.println(player.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try { connection.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { result.close(); } catch(SQLException se) { /*can't do anything */ }
        }
            return playerList;
    }
}

