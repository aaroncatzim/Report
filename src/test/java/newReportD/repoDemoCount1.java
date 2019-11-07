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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class repoDemoCount1 {
	public static String url = "http://acatzim9388:Qweasdzxc123@reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2f_Testing%2fTest+CMPS+Student+Logins+LMS2.0";
	public static String url1 = "http://acatzim9388:Qweasdzxc123@reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2f_Testing%2fTest+Student+Logins+LMS2.0"; 
	static WebDriver webdriver;





	@BeforeTest
	public static void lauchTest() {
		System.setProperty("webdriver.chrome.driver", "./src/test/java/newReportD/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		webdriver.get(url);
	}
	@BeforeMethod
	public void filterSetup() throws InterruptedException {
		Select dropDown = new Select(webdriver.findElement(By.name("ctl32$ctl04$ctl03$ddValue")));
		dropDown.selectByValue("1");
		webdriver.findElement(By.name("ctl32$ctl04$ctl00")).click();
		//Thread.sleep(5000);
		webdriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}



	@Test(priority = 0)
	public void reportLoading() throws IOException {
		Screenshot screenshot = new AShot().takeScreenshot(webdriver);

		try {

			WebElement reportP = webdriver.findElement(By.xpath("/html/body/form/span[1]/table/tbody/tr[2]/td/table/tbody/tr/td/span/table/tbody/tr/td/span[2]/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody"));
		}catch(Exception ex) {
			if(ex instanceof NoSuchElementException) {
				System.err.println("-------------------------------------- Report FAIL -> Report was not found -------------------------------------- "  );
			}else {
				System.err.println("Test failed " + ex.getMessage());
			}
		}ImageIO.write(screenshot.getImage(), "jpg", new File("./test-output/Screenshot/reportLoading.jpg"));
		webdriver.close();
	}

	@Test (priority = 1)
	public void informationPresent() {


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
	}

	@AfterTest
	public void close () {
		webdriver.close();
	}

}
