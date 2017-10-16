/**
 * Created by owner on 05.09.2017.
 */
public class FinalPlayer {
    int number;
    String name;
    String town;
    int cups;
    String games;
    int rating;
    String delta;
    String date;

    public FinalPlayer(int number, String name, String town, int cups, String games, int rating, String delta, String date) {
        this.number = number;
        this.name = name;
        this.town = town;
        this.cups = cups;
        this.games = games;
        this.rating = rating;
        this.delta = delta;
        this.date = date;
    }

    public FinalPlayer() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDelta() {
        return delta;
    }

    public void setDelta(String delta) {
        this.delta = delta;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FinalPlayer{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", cups=" + cups +
                ", games='" + games + '\'' +
                ", rating=" + rating +
                ", delta='" + delta + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
