import java.io.*;

/**
 * Created by owner on 06.09.2017.
 */
public class DelQuest2 {
    public static void main(String[] args) {
        dell("D:\\\\down\\\\xml\\\\1.xml");
    }
    public static void dell(String fileName) {

        BufferedReader buff = null;
        BufferedWriter buffOut = null;
        String charSet="UTF-8";
        String charSet2="UTF-8";
        if (fileName.substring(fileName.length()-3).equals("xml")) {
            charSet="windows-1251";
            charSet2="cp1251";
        }
        try {
                buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charSet));
                buffOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName+"1"), charSet2));
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
        ImportCsv.changeFile(fileName,fileName+"1");
    }
}

