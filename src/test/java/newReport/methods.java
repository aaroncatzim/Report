package newReport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class methods {
	WebDriver webdriver;
	
	//constructor -> to test
		public  methods (WebDriver webdriver) {
			this.webdriver = webdriver;
		}
	
	public WebDriver conexion () {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acatzim9388\\eclipse-workspace\\newReport\\src\\test\\resources\\drivers\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();
		
		return webdriver; 
	}
	// visit get the URL
	public void Visit (String url) {
		webdriver.get(url);
	}
	//Click
	public void Click (By locator) {
		webdriver.findElement(locator).click();
	}
	//Type
	public void Type (By locator, String Text) {
		webdriver.findElement(locator).clear();
		webdriver.findElement(locator).sendKeys(Text);
	}
	//Double click
	public void DoubleClick (By locator) {
		Actions action = new Actions(webdriver);
		WebElement link = webdriver.findElement(locator);
		action.doubleClick(link);
	}
	//Drop down
	public void DropDown (By locator, String Text) {
		Select select = new Select(webdriver.findElement(locator));
		select.selectByVisibleText(Text);
	}
	
	//Screenshot
	/*
	public static void tss(WebDriver webdriver) throws Exception{
		String fileWithPath = "C:\\Users\\acatzim9388\\eclipse-workspace\\newReport\\src\\test\\resources\\screenshots\\test.png";
        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
	}*/

	public static String takeSnapShot(WebDriver driver, String snapshotError) throws Exception{
		//Object SSDate = new SimpleDateFormat("yyyyMMdd_HH").format(Calendar.getInstance().getTime()).toString();
		String SSDateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()).toString();
		String file = System.getProperty("user.dir")  + snapshotError + SSDateTime + ".png";
		
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		try{ //Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			//Move image file to new destination
			File DestFile=new File(file);
			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			throw new Exception("Class BaseClass | Method takeSnapShot | Exception desc: ", e);
		}
		return file;
	}
}
