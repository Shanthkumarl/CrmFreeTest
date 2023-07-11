package readingGraphValue;


	import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\LENOVO\\eclipse-workspace\\CrmTesting\\src\\main\\java\\readingGraphValue\\Testing.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("Sheet1"); // Replace "Sheet1" with the actual sheet name

            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.println(cell.toString()); // Perform the desired action with the cell value
                }
            }

            ((FileInputStream) workbook).close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


