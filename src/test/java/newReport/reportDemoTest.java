package newReport;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;





public class reportDemoTest {
	
	WebDriver webdriver;
	reportsDemo reportD;
	
	String visit = "reports.flipswitch.com/Reports/Pages/Report.aspx?ItemPath=%2fSSO%2fRegistrar%2fWithdrawal+Form&ViewMode=Detail";
	
	
	

	@Before
	public void setUp() throws Exception {
					
		reportD = new reportsDemo(webdriver);
		webdriver = reportD.conexion();
		reportD.Visit("http://acatzim9388:Qweasdzxc123@"+visit);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		
		reportD.configReport(visit);
		
	}

}
