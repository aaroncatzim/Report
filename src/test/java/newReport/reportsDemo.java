package newReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class reportsDemo extends methods {
	
	WebDriver  webdriver;
	
	//paths
	
	By accessPropperties = By.linkText("Withdrawal Form");
	By accessParameters = By.linkText("Parameters");
	By schoolID = By.name("ui_txt_pvsText_SchoolID");
	By btnApply = By.name("ui_btnSave");
	By returntoreport = By.linkText("Withdrawal Form");
	By addStudentID = By.id("ctl32_ctl04_ctl03_txtValue");
	By btnViewReport = By.id("ctl32_ctl04_ctl00");
	
	public reportsDemo (WebDriver webdriver) {
		super(webdriver);
	}
	
	

	public void configReport(String Visit) throws Exception {
	
		
		//tss(webdriver);
		takeSnapShot(webdriver, "ss");
		
	}
	
	

}
