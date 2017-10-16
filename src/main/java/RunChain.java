import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Created by owner on 19.09.2017.
 */
public class RunChain {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        // качаем, читаем файл CSV - нв выходе List<CsvPlayer>
        String filePath="D:\\\\down\\\\rating.csv";
        ImportCsv.downFile(filePath);
        DelQuest delQuest=new DelQuest();
        delQuest.main();
        List<CsvPlayer> csvPlayersList=AlterReadCSV.alterReadCSV(filePath);
        //парсим XML и сравнение
        MultiRename.multiRename(); //запускает CompareKhaAndXml, а тот : ImportXml, ReadRateKha

    }
}
