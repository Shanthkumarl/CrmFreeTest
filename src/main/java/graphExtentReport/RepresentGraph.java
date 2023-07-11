package graphExtentReport;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/*public class RepresentGraph {

	public static void main(String[] args) {
		//Set up Extent Report:
		//Create an ExtentHtmlReporter object and configure it as per your requirements. This will define the appearance and behavior of the report.
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\LENOVO\\eclipse-workspace\\CrmTesting\\extent-report.html");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("Graph Generation Report");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
        
		//Read values from XLSX file:
		//Use Apache POI to read values from the XLSX file and store them in a suitable data structure.
		//Here's an example to read values from the first sheet of the workbook:
		
		//Workbook workbook = new XSSFWorkbook("C:\\Users\\LENOVO\\Desktop\\Testing.xlsx");
		//Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		//List<Double> values1 = new ArrayList<>();

		//for (Row row : sheet) {
		   // for (Cell cell : row) {
		     //   String cellValue = dataFormatter.formatCellValue(cell);
		        try {
		            double numericValue = Double.parseDouble(cellValue);
		          //  values1.add(numericValue);
		        } catch (NumberFormatException e) {
		            // Ignore non-numeric cells
		        }
		    }
		}
		//workbook.close();
//Generate a graph using the values:
//Utilize your preferred graphing library (e.g., JFreeChart, Chart.js) to create a graph based on the values obtained from the XLSX file.

		
		//Add the graph to the Extent Report:
		//Create a new ExtentTest object, add the graph as a media entity, and log it to the report.
		
		ExtentTest test = extent.createTest("Graph Generation Test");
		// Generate graph using the values

		// Assuming you have the graph as a BufferedImage object
		///MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromBufferedImage(graphImage).build();
	//	test.pass("Generated Graph:", mediaModel);

		
		
		//Generate and save the report:
		extent.flush();

	}

}*/
