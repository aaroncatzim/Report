package newReportD;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

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

/**
 * @author acatzim9388
 *
 */

public class RD {
	public static String url = "http://acatzim9388:Qweasdzxc123@reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2f_Testing%2fTest+CMPS+Student+Logins+LMS2.0";
	public static String url1 = "http://acatzim9388:Qweasdzxc123@reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2f_Testing%2fTest+Student+Logins+LMS2.0"; 
	static WebDriver webdriver;





	@BeforeTest
	public static void lauchTest() {}

	@AfterTest
	public void close () {
		webdriver.quit();
	}

	//--------------------------------------------------------------------------- test cases ----------------------------------------------------------------------------------------


	/**
	 * reportLoading 'happy path' with no data present
	 * xpath is pointing to /Body were the data body take place since this once this /Body is  reached the test case pass
	 */
	@Test(priority = 0)

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
		//	Thread.sleep(5000);

		Screenshot screenshot = new AShot().takeScreenshot(webdriver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/01reportIsPresent.jpg"));
		//System.out.println("-------------------------------------- Report Data is present --------------------------------------");
		webdriver.close();
		
		

	}
	/**
	 * informationPresent this report configuration is displaying 'Report Data is not present'
	 * xpath is pointing to /tr were the data body take place since this once this /tr is not reached the err is displayed in the console
	 */

	@Test (priority = 1)
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

			}

		}
		catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Test Element was not found --------------------------------------"  );
			}else {
				System.err.println("-------------------------------------- Test failed " + ex.getMessage());
			}
		}

		Screenshot screenshot = new AShot().takeScreenshot(webdriver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/02reportIsPresentWithoutData.jpg"));
		webdriver.close();

	}
	/**
	 * informationPresent this report configuration is displaying 'Report Data is present'
	 * xpath is pointing to /tr were the data body take place since this once this /tr is not reached the err is displayed in the console
	 */
	@Test(priority = 2)

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


	/**
	 * reportLoading 'happy path'
	 * xpath is pointing to /Body were the data body take place since  /Body is not reached console will display 'Report FAIL -> Report was not found'
	 */


	@Test (priority = 3)
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
			}else {
				System.err.println("Test failed " + ex.getMessage());
			}
		}
		Thread.sleep(5000);
		Screenshot screenshot = new AShot().takeScreenshot(webdriver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/04LoadingFail.jpg"));
		webdriver.close();

	}

	/**
	 * informationPresent this report configuration is displaying 'Report Data is not present'
	 * xpath is pointing to /tr were the data body take place since this once this /tr is not reached the err is displayed in the console
	 */

	@Test (priority = 4)
	public void tc05_LoadingFail_NoData() throws InterruptedException, IOException  {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url1);

		Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
		dropDown.selectByValue("15");
		webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();
		//Thread.sleep(5000);
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		try {			

			List<WebElement> elementsP = webdriver.findElements(By.xpath("/html/body/form/span[1]/table/tbody/tr[2]/td/table/tbody/tr/td/span/table/tbody/tr/td/span[2]/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[3]"));

			if(elementsP.size()>0) {
				System.out.println("-------------------------------------- Report Data is present --------------------------------------");
			}else {
				System.out.println("-------------------------------------- Report Data is not present -------------------------------------- ");
			}

		}
		catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Test Element was not found --------------------------------------"  );
			}else {
				System.err.println("-------------------------------------- Test failed " + ex.getMessage());
			}
		}
		Thread.sleep(5000);
		Screenshot screenshot = new AShot().takeScreenshot(webdriver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/05LoadingFailNoData.jpg"));
		
		
		webdriver.close();
	} 

}
