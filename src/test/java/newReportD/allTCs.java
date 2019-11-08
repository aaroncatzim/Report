package newReportD;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class allTCs {

	public static String username = "aaroncatzim@gmail.com";//"jcatzim@tiempodevelopment.com";
	public static String password = "@";
	public static String url2 = "http://acatzim9388:Qweasdzxc123@reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2fRegistrar%2fWithdrawal+Form&ViewMode=Detail";
	public static String url = "http://acatzim9388:Qweasdzxc123@reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2f_Testing%2fTest+CMPS+Student+Logins+LMS2.0";
	public static String url1 = "http://acatzim9388:Qweasdzxc123@reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2f_Testing%2fTest+Student+Logins+LMS2.0"; 
	static WebDriver webdriver;

	By WithdrawalFormLink = By.linkText("Withdrawal Form");
	By Parameters = By.linkText("Parameters");
	By schoolID = By.name("ui_txt_pvsText_SchoolID");
	By btnApply = By.name("ui_btnSave");
	By returntoreport = By.linkText("Withdrawal Form");
	By addStudentID = By.id("ctl32_ctl04_ctl03_txtValue");
	By btnViewReport = By.id("ctl32_ctl04_ctl00");

	@BeforeTest
	public static void lauchTest() {}

	@AfterTest
	public void close () {
		webdriver.quit();
	}

	//--------------------------------------------------------------------------- test cases ----------------------------------------------------------------------------------------

	@Test(priority = 0)

	public void config1studentID () {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url2);
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		webdriver.findElement(WithdrawalFormLink).click();
		webdriver.findElement(Parameters).click();
		webdriver.findElement(schoolID).clear();
		webdriver.findElement(schoolID).sendKeys("17");
		webdriver.findElement(btnApply).click();
		webdriver.findElement(returntoreport).click();
		webdriver.findElement(addStudentID).sendKeys("697623");
		webdriver.findElement(btnViewReport).click();

		//webdriver.close();

	}
	@Test(priority = 1)

	public void secondconsult () {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url2);
		webdriver.findElement(addStudentID).sendKeys("697362");
		webdriver.findElement(btnViewReport).click();



	}
	@Test(priority = 2)

	public void secondconsult1 () {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url2);
		webdriver.findElement(addStudentID).sendKeys("697353");
		webdriver.findElement(btnViewReport).click();
	}

	//--------------------------------------------------------------------------- test cases ----------------------------------------------------------------------------------------
	@Test(priority = 3)

	public void tc01_reportLoading() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url);

		Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
		dropDown.selectByValue("1");
		webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();

		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		try {

			WebElement reportP = webdriver.findElement(By.xpath("/html/body/form/span[1]/table/tbody/tr[2]/td/table/tbody/tr/td/span/table/tbody/tr/td/span[2]/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody"));


		}catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Report Loading: Report FAIL -> Report was not found -------------------------------------- "  );
			}else {
				System.err.println("Test failed " + ex.getMessage());
			}
		}		

		Screenshot screenshot = new AShot().takeScreenshot(webdriver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/01reportIsPresent.jpg"));
		System.out.println("-------------------------------------- Report Data is present --------------------------------------");
		webdriver.close();

	}

	@Test (priority = 4)
	public void tc02_informationPresent_withoutData() throws InterruptedException, IOException  {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url);

		Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
		dropDown.selectByValue("1");
		webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();

		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);


		try {			

			List<WebElement> elementsP = webdriver.findElements(By.xpath("/html/body/form/span[1]/table/tbody/tr[2]/td/table/tbody/tr/td/span/table/tbody/tr/td/span[2]/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]"));

			if(elementsP.size()>0) {
				System.out.println("-------------------------------------- Report Data is present --------------------------------------");
			}else {
				System.out.println("-------------------------------------- Report is loading -> Data is not present -------------------------------------- ");
				Screenshot screenshot = new AShot().takeScreenshot(webdriver);
				ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/02reportIsPresentWithoutData.jpg"));
				webdriver.close();
				Assert.fail("-------------------------------------- Report is loading -> Data is not present -------------------------------------- ");

			}

		}
		catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Test Element was not found --------------------------------------"  );
			}else {
				System.err.println("-------------------------------------- Test failed " + ex.getMessage());
			}
		}
	}

	@Test(priority = 5)

	public void tc03_informationPresent_withData() throws InterruptedException, IOException  {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url);

		Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
		dropDown.selectByValue("15");
		webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		try {			

			List<WebElement> elementsP = webdriver.findElements(By.xpath("/html/body/form/span[1]/table/tbody/tr[2]/td/table/tbody/tr/td/span/table/tbody/tr/td/span[2]/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]"));

			if(elementsP.size()>0) {
				System.out.println("-------------------------------------- Report Load -> Data is present --------------------------------------");
			}else {
				System.out.println("-------------------------------------- Report Data is not present -------------------------------------- ");
			}

		}
		catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Report Loading: Test Element was not found --------------------------------------"  );
			}else {
				System.err.println("-------------------------------------- Test failed " + ex.getMessage());
			}
		}
		Thread.sleep(5000);
		Screenshot screenshot = new AShot().takeScreenshot(webdriver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/03reportIsPresentWithData.jpg"));
		webdriver.close();
	}

	@Test (priority = 6)
	public void tc04_LoadingFail() throws InterruptedException, IOException  {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url1);

		Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
		dropDown.selectByValue("15");
		webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();
		Thread.sleep(3000);
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		try {

			WebElement reportP = webdriver.findElement(By.xpath("/html/body/form/span[1]/table/tbody/tr[2]/td/table/tbody/tr/td/span/table/tbody/tr/td/span[2]/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody"));


		}catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Report FAIL -> Report was not found -------------------------------------- "  );
				Thread.sleep(5000);
				Screenshot screenshot = new AShot().takeScreenshot(webdriver);
				ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/04LoadingFail.jpg"));
				webdriver.close();
				Assert.fail("-------------------------------------- Report FAIL -> Report was not found --------------------------------------" );
			}else {
				System.err.println("Test failed " + ex.getMessage());
			}
		}
		webdriver.close();
	}

	@Test (priority = 7)
	public void tc05_LoadingFail_NoData() throws InterruptedException, IOException  {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url1);

		Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
		dropDown.selectByValue("15");
		webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();
	
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		try {			

			List<WebElement> elementsP = webdriver.findElements(By.xpath("/html/body/form/span[1]/table/tbody/tr[2]/td/table/tbody/tr/td/span/table/tbody/tr/td/span[2]/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]"));

			if(elementsP.size()>0) {
				System.out.println("-------------------------------------- Report Data is present --------------------------------------");
			}else {
				System.out.println("-------------------------------------- Report Data is not present -------------------------------------- ");
				Thread.sleep(5000);
				Screenshot screenshot = new AShot().takeScreenshot(webdriver);
				ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/05LoadingFailNoData.jpg"));
				webdriver.close();
				Assert.fail("-------------------------------------- Report Data is not present --------------------------------------" );
			}

		}
		catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Test Element was not found --------------------------------------"  );
			
			}else {
				System.err.println("-------------------------------------- Test failed " + ex.getMessage());
			}
		}

		webdriver.close();
	} 
	//--------------------------------------------------------------------------- Test cases ----------------------------------------------------------------------------------------
	
	@Test (priority = 8)
	public void LoadingFail_NoDatamail() throws InterruptedException, IOException, EmailException  {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url);

		Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
		dropDown.selectByValue("1");
		webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();

		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		try {			

			List<WebElement> elementsP = webdriver.findElements(By.xpath("/html/body/form/span[1]/table/tbody/tr[2]/td/table/tbody/tr/td/span/table/tbody/tr/td/span[2]/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]"));

			if(elementsP.size()>0) {
				System.out.println("-------------------------------------- Report Data is present --------------------------------------");
			}else {
				System.out.println("-------------------------------------- Report Data is not present -------------------------------------- ");
				Thread.sleep(5000);
				Screenshot screenshot = new AShot().takeScreenshot(webdriver);
				ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/LoadingFailNoDataEmail.jpg"));

				// Create the attachment
				EmailAttachment attachment = new EmailAttachment();
				attachment.setPath("./test-output/Screenshot/LoadingFailNoDataEmail.jpg");
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				attachment.setDescription("Report ####  Data is not present");
				attachment.setName("Strongmind");

				// Create the email message
				MultiPartEmail email = new MultiPartEmail();
				email.setHostName("smtp.googlemail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator(username, password));
				email.setSSLOnConnect(true);
				email.setFrom("aaroncatzim@gmail.com", "QA");
				email.addTo("aaron.catzim@strongmind.com", "Aaron Catzim");
				email.setSubject("Automation Report #### Fail");
				email.setMsg("Report ####  FAIL - Report Data is not present - please review  " + url1 );

				// add the attachment
				email.attach(attachment);

				// send the email
				email.send();

				System.out.println("-------------------------------------- Sending mail -------------------------------------- ");
				webdriver.close();
				Assert.fail("-------------------------------------- Test Element was not found --------------------------------------" );
			}
		}
		catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Test Element was not found --------------------------------------"  );

			}else {
				System.err.println("-------------------------------------- Test failed " + ex.getMessage());
			}
		}
		webdriver.quit();
	}
	
	@Test (priority = 9)
	public void LoadingFailmail() throws InterruptedException, IOException, EmailException  {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url1);

		Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
		dropDown.selectByValue("15");
		webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();
		Thread.sleep(3000);
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		try {

			WebElement reportP = webdriver.findElement(By.xpath("/html/body/form/span[1]/table/tbody/tr[2]/td/table/tbody/tr/td/span/table/tbody/tr/td/span[2]/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody"));


		}catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Report FAIL -> Report was not found -------------------------------------- "  );

				Thread.sleep(5000);
				Screenshot screenshot = new AShot().takeScreenshot(webdriver);
				ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/ReportWasNotFound.jpg"));

				// Create the attachment
				EmailAttachment attachment = new EmailAttachment();
				attachment.setPath("./test-output/Screenshot/ReportWasNotFound.jpg");
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				attachment.setDescription("Report ####  Data is not present");
				attachment.setName("Strongmind");

				// Create the email message
				MultiPartEmail email = new MultiPartEmail();
				email.setHostName("smtp.googlemail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator(username, password));
				email.setSSLOnConnect(true);
				email.setFrom("aaroncatzim@gmail.com", "QA");
				email.addTo("aaron.catzim@strongmind.com", "Aaron Catzim");
				email.setSubject("Automation Report #### Fail");
				email.setMsg("Report ####  FAIL - Report was not found - please review " + url1 );

				// add the attachment
				email.attach(attachment);

				// send the email
				email.send();
				System.out.println("-------------------------------------- Sending mail -------------------------------------- ");
				Assert.fail("-------------------------------------- Report FAIL -> Report was not found --------------------------------------" );


			}else {
				System.err.println("Test failed " + ex.getMessage());
			}
		}
		webdriver.close();
	}
	
	//--------------------------------------------------------------------------- END ----------------------------------------------------------------------------------------








}
