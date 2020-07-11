import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


/// My First Automation E2E script --Spicejet--
public class SpicejetE2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://spicejet.com");
		//Thread.sleep(3000);
		Thread.sleep(6000);
		//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		
		//------------------------------------Radio Button--------------------------------------------------
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		Thread.sleep(2000);

		// id from value =ctl00_mainContent_ddl_originStation1_CTXT
		
		//driver.findElement(By.cssSelector("input[id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		//-----------------------------------------Dynamic DropDown---------------------------------------------
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//driver.findElement(By.xpath("//a[@text='Bengaluru (BLR)']")).click();
		//driver.findElement(By.xpath("(//a[@text='Bagdogra (IXB)'])[2]')")).click();
		driver.findElement(By.xpath("//*[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@text='Dibrugarh (DIB)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Chennai (MAA)']")).click();
		Thread.sleep(2000);
		
		//-----------------------------------checking for current date on calender-------------------------------
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Thread.sleep(3000);
		
		//--------------------------------Checking for enabled or disabled calender------------------------------
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){	
			System.out.println("Its disabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		//----------------------------------static Dropdown-------------------------------------------------------
		
		System.out.println("Intial Value :" +" "+ driver.findElement(By.cssSelector("#divpaxinfo")).getText());
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		Select s0 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s0.selectByValue("4");
		Select s1 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		//ctl00_mainContent_ddl_Child", ctl00_mainContent_ddl_Infant
		s1.selectByIndex(2);
		Select s2 = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		s2.selectByVisibleText("2");
		
		System.out.println("Final Value :" +" "+ driver.findElement(By.cssSelector("#divpaxinfo")).getText());
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		
		//---------------------------------static dropdown for currency selection----------------------------------
		
		Select currency = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		currency.selectByIndex(2);
		
		//-------------------------------checkbox------------------------------------------------------------------
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
