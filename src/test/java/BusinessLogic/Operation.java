package BusinessLogic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Operation {
	public static WebDriver driver;

	private static ExtentReports report;

	static {
		report = new ExtentReports(System.getProperty("user.dir") + "//HTML_Report//" + "ExtentReportResults"
				+ System.currentTimeMillis() + ".html");
	}
	
	public Operation() {
		System.out.println("Parent");
		String p1 = System.getProperty("user.dir");
		System.out.println("directory = " + p1);
		System.setProperty("webdriver.chrome.driver", p1 + "//Driver//chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins*=");

		driver = new ChromeDriver(co);

		driver.manage().window().maximize();
	}

	public static void openurl() throws InterruptedException {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}

	public static void click(WebElement xpath) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(xpath));
		xpath.click();

	}

	public static void sendText(WebElement xpath, String value) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(xpath));
	    xpath.sendKeys(value);
	}

	public static void scrolldown(int pxl) {
		JavascriptExecutor JSE = (JavascriptExecutor) driver;
		JSE.executeScript("window.scrollBy(0," + pxl + ")", "");
	}

	public static void verifyText(WebElement xpath, String exptitle) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(xpath));
		String actualtitle = xpath.getText();
		System.out.println(actualtitle);
	}

	public static String capture(WebDriver driver) throws IOException {

		// File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.File);
		String path = System.getProperty("user.dir");
		File src = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File Dest = new File(path + ".\\Screenshot\\IMG" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(src, Dest);
		return errflpath;
	}

	public static void ExtentReportTest(String TestCase, String status, String Testdetails) throws IOException {
		ExtentTest test = report.startTest(TestCase);

		if (status.equalsIgnoreCase("PASSED")) {
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + Testdetails);
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + Testdetails);
		}

		report.flush(); 
	}

}