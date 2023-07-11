package com.qa.extendReportListerner;


	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.ChartLocation;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentReportGraphExample {
	    public static void main(String[] args) {
	    	
	    	
	        // Create ExtentReports and attach the HTML reporter
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);

	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);

	        // Create a test and add logs with status
	        ExtentTest test = extent.createTest("Graph Example");
	        test.log(Status.INFO, "Creating graph...");

	        // Add data for the line chart
	        test.info("<pre>\n" +
	                "    {\n" +
	                "        labels: [\"Jan\", \"Feb\", \"Mar\", \"Apr\", \"May\"],\n" +
	                "        datasets: [\n" +
	                "            {\n" +
	                "                label: \"Data 1\",\n" +
	                "                data: [10, 20, 30, 40, 50],\n" +
	                "                fill: false,\n" +
	                "                borderColor: \"rgb(75, 192, 192)\",\n" +
	                "                tension: 0.1\n" +
	                "            }\n" +
	                "        ]\n" +
	                "    }\n" +
	                "</pre>");

	        // Add the line chart
	        test.log(Status.PASS, "<canvas id=\"lineChart\"></canvas>");
	        test.log(Status.INFO, "Graph created successfully!");

	        // Flush the extent report
	        extent.flush();
	    }
	}


