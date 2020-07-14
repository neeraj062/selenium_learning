package actionAndframes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesConcept {
	
	public static void framesconcept(WebDriver driver) {
		driver.get("https://jqueryui.com/droppable/");
		//driver.switchTo().frame(driver.findElement(By.cssSelector("#content iframe")));
		//driver.findElement(By.cssSelector("#draggable")).click();  // got the error if we directly run the program
		
		
		// Implementation of drag and drop
		System.out.println("Number of frames present :"+ driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		WebElement target = driver.findElement(By.cssSelector("#droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://jqueryui.com/droppable/
		System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		framesconcept(driver);
	}
}
