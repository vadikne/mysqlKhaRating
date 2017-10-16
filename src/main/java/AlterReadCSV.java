import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AlterReadCSV {
    public static void main(String[] args) throws IOException {
        String csvFile="D:\\\\down\\\\rating.csv";
       // AlterReadCSV obj = new AlterReadCSV();
       // obj.run();
        List<CsvPlayer> csvPlayersList=alterReadCSV(csvFile);
        for (CsvPlayer player:csvPlayersList) System.out.println(player.toString());
    }

    public static  List alterReadCSV(String csvFile) {
        List<CsvPlayer> csvPlayersList = new ArrayList<>(4000);
      //  String csvFile = "D:\\\\down\\\\rating.csv";
        BufferedReader br = null;
        String line = "";
        String separ = ";";

        boolean firstLine = true;
        int i=0;
        try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "windows-1251"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                while ((line = br.readLine()) != null) {
                    CsvPlayer csvPlayer = new CsvPlayer();
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
                    String[] stringOfData = line.split(separ);
                    if (stringOfData[2].contains("Украина")||stringOfData[2].contains("Крым")||stringOfData[2].contains("Венгрия")) {
                        csvPlayer.setNumber(i++);
                        csvPlayer.setName(stringOfData[1]);
                        csvPlayer.setTown(stringOfData[2]);
                        csvPlayer.setCups(Integer.parseInt(stringOfData[3]));
                        csvPlayer.setGames(stringOfData[4]);
                        csvPlayer.setRating(Integer.parseInt(stringOfData[5]));
                        csvPlayer.setDelta(stringOfData[6]);
                        csvPlayer.setDate(stringOfData[7]);

                        csvPlayersList.add(csvPlayer);
                        //System.out.println(csvPlayer.toString());
                    }
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
            return csvPlayersList;
        }
    }

