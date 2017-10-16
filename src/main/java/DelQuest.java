import java.io.*;

/**
 * Created by owner on 06.09.2017.
 */
public class DelQuest {
    //public static void main(String[] args) {

    public static void main() {

        BufferedReader buff = null;
        BufferedWriter buffOut = null;
            try {
                buff = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\\\down\\\\rating.csv"), "windows-1251"));
                buffOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\\\down\\\\rating1.csv"), "cp1251"));
                while (true) {
                    String line = buff.readLine();
                    if (line == null) break;
                    String line1=line.replaceAll("\\?","" );
                    buffOut.write(line1+"\n");
                }
            }catch (IOException e){
                e.printStackTrace();
            } finally {
                try{
                    buff.close();
                    buffOut.flush();
                    buffOut.close();
                }catch(IOException e1){
                    e1.printStackTrace();
                }
            }
        ImportCsv.changeFile("D:\\\\down\\\\rating.csv","D:\\\\down\\\\rating1.csv");
    }
}

