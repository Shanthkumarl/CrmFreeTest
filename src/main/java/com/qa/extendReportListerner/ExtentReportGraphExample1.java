package com.qa.extendReportListerner;


	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.ChartLocation;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentReportGraphExample1 {

	    public static void main(String[] args) {
	        // Create ExtentReports and attach HTML reporter
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Extent Report Graph Example");
	        htmlReporter.config().setReportName("Extent Report Graph Example");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	        // Create a test
	        ExtentTest test = extent.createTest("Graph Test", "This test demonstrates graph representation");
	        
	        // Add data points to the chart
	      // test.info("Data1",10);
	     //   test.info("Data2", 20);
	       // test.info("Data3", 30);
	       // test.info("Data4", 40);
	        
	        // Generate the report
	        extent.flush();
	        
	        // Log the status of the test
	        test.log(Status.PASS, "Graph generated successfully");
	    }
	}


