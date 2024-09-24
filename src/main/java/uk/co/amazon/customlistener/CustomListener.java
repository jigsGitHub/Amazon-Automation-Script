package uk.co.amazon.customlistener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import static uk.co.amazon.utilities.Utility.takeScreenShot;

public class CustomListener implements ITestListener {
    public ExtentSparkReporter reporter;
    public ExtentReports reports;
    public static ExtentTest test;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = reports.createTest(iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS, "TEST CASE PASSED IS " + iTestResult.getName());
        CustomListener.test.log(Status.PASS, iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(" ****** Entering fail testcase");
        test.log(Status.FAIL, "TEST FAILED IS " + iTestResult.getName());
        test.log(Status.FAIL, "TEST FAILED IS " + iTestResult.getThrowable());
        System.out.println("********* Before tacking screenshot");
        String screenShotName = takeScreenShot(iTestResult.getName());
        System.out.println("********* After tacking screenshot");
        test.addScreenCaptureFromPath(screenShotName);
        System.out.println("********* Adding screenshot");
        System.setProperty("org.uncommons.reportng.escape-output", "false");
        Reporter.log("Click to see screenshot");
        Reporter.log("<a target = \"_blank\" href=" + screenShotName + ">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target = \"_blank\" href=" + screenShotName + "><img src=" + screenShotName + " height=200 width=200></img></a>");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(Status.SKIP, "TEST SKIPPED IS " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extent.html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Xyz Bank");
        reporter.config().setTheme(Theme.DARK);
        reports = new ExtentReports();
        reports.attachReporter(reporter);

        reports.setSystemInfo("User Name", System.getProperty("user.name"));
        reports.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        reports.setSystemInfo("Machine", "Windows 10" + "64 Bit");
        reports.setSystemInfo("Selenium", "3.141.59");
        reports.setSystemInfo("Maven", "3.5.9");
        reports.setSystemInfo("Java Version", "1.8.0_151");
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        reports.flush();
    }

}
