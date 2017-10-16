import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

    public class ExpToXLS {

        public static void expToXLS(List<FinalPlayer> fpList){
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("по алфавиту");
            int rowNum = 0;
            Row row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue("Номер");
            row.createCell(1).setCellValue("ФИО");
            row.createCell(2).setCellValue("Рейтинг");
            row.createCell(3).setCellValue("Город");
            row.createCell(4).setCellValue("Турниров");
            row.createCell(5).setCellValue("Игр в-п");
            row.createCell(6).setCellValue("Дельта");
            row.createCell(7).setCellValue("Дата");


            for (FinalPlayer pl : fpList) {
                System.out.println(pl.toString());
                createSheetHeader(sheet, ++rowNum, pl);
            }
            try (FileOutputStream out = new FileOutputStream(new File("d:\\Apache POI Excel File.xls"))) {
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Excel файл успешно создан!");
        }

        private static void createSheetHeader(HSSFSheet sheet, int rowNum, FinalPlayer pl) {
            Row row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(pl.getNumber());
            row.createCell(1).setCellValue(pl.getName());
            row.createCell(2).setCellValue(pl.getRating());
            row.createCell(3).setCellValue(pl.getTown());
            row.createCell(4).setCellValue(pl.getCups());
            row.createCell(5).setCellValue(pl.getGames());
            row.createCell(6).setCellValue(pl.getDelta());
            row.createCell(7).setCellValue(pl.getDate());
        }

    }
