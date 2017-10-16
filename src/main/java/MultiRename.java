import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class MultiRename {
    public static void main(String []args) throws ParserConfigurationException, SAXException, IOException {
       multiRename();
        }
        public static void multiRename() throws ParserConfigurationException, SAXException, IOException {
    File[] filesList;
    String pathName="D:\\\\down\\\\xml\\\\";
    File newFile= new File(pathName+"1.xml");
        if (newFile.exists()){
        ImportCsv.delFile(newFile.toString());
    }
    File filesPath = new java.io.File(pathName);
    filesList = filesPath.listFiles();
    for(int i=0; i<filesList.length; i++) {
        System.out.println(filesList[i].getName());
        filesList[i].renameTo(newFile);
        //CompareKhaAndXml.main();
        AlterCompareKhaAndXml.main();
        ImportCsv.delFile(newFile.toString());
        }
    }
    }


