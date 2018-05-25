package top.treegrowth.poi;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * @author wusi
 * 20180520
 */
public class POITest {

    public String path = this.getClass().getResource("/").getPath();

    public static void main(String[] args) throws Exception {

        POITest test = new POITest();
        System.out.println(test.path);

            OPCPackage pkg = OPCPackage.open(new File(test.path+"批量禁用上传模板.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(pkg);
            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(3);
            if (cell == null)
                cell = row.createCell(1);
            cell.setCellType(CellType.STRING);
            cell.setCellValue("a test");

            // Write the output to a file
            try (OutputStream fileOut = new FileOutputStream(test.path+"workbook.xlsx")) {
                wb.write(fileOut);
            }
            pkg.close();

    }
}
