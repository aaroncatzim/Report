package newReportD;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class repoDemo1 {
	
	public static String url = "http://acatzim9388:Qweasdzxc123@reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2fRegistrar%2fWithdrawal+Form&ViewMode=Detail";
	public static String url1 = "http://acatzim9388:Qweasdzxc123@reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2f_Testing%2fTest+CMPS+Student+Logins+LMS2.0";
	public static String username = "######@gmail.com";//"jcatzim@tiempodevelopment.com";
	public static String password = "#####";
	
	static WebDriver webdriver;

	//--------------------------------------------------------------------------- locator ----------------------------------------------------------------------------------------
	
	
	By WithdrawalFormLink = By.linkText("Withdrawal Form");
	By Parameters = By.linkText("Parameters");
	By schoolID = By.name("ui_txt_pvsText_SchoolID");
	By btnApply = By.name("ui_btnSave");
	By returntoreport = By.linkText("Withdrawal Form");
	By addStudentID = By.id("ctl32_ctl04_ctl03_txtValue");
	By btnViewReport = By.id("ctl32_ctl04_ctl00");
	
	//---------------------------------------------------------------------------  ----------------------------------------------------------------------------------------
	@BeforeTest
	public static void lauchTest() {
		
	}

	@AfterTest
	public void close () {
		
		//webdriver.quit();
	}

	//--------------------------------------------------------------------------- test cases ----------------------------------------------------------------------------------------


	// * reportLoading 'happy path'
	// * xpath is pointing to /Body were the data body take place since this once this /Body is  reached the test case pass

	@Test(priority = 0)

	public void config1studentID () {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url);
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		webdriver.findElement(WithdrawalFormLink).click();
		webdriver.findElement(Parameters).click();
		webdriver.findElement(schoolID).clear();
		webdriver.findElement(schoolID).sendKeys("17");
		webdriver.findElement(btnApply).click();
		webdriver.findElement(returntoreport).click();
		webdriver.findElement(addStudentID).sendKeys("697623");
		webdriver.findElement(btnViewReport).click();
		
		webdriver.close();
		
	}
	@Test(priority = 1)

	public void secondconsult () {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url);
		webdriver.findElement(addStudentID).sendKeys("697362");
		webdriver.findElement(btnViewReport).click();
		
		webdriver.close();
		
	}
	@Test(priority = 2)

	public void secondconsult1 () {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url);
		webdriver.findElement(addStudentID).sendKeys("697353");
		webdriver.findElement(btnViewReport).click();
		
		webdriver.close();
		
	}
	
//	@Test(priority = 3)

	public void screenshot () throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
			webdriver = new ChromeDriver();
			webdriver.manage().window().maximize();
			webdriver.manage().deleteAllCookies();
			webdriver.get(url1);

			Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
			dropDown.selectByValue("15");
			webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();
			webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			Thread.sleep(8000);
			Screenshot screenshot = new AShot().takeScreenshot(webdriver);
			
			ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/screenthotTEST.jpg"));
			webdriver.close();
		
	}
	
}
