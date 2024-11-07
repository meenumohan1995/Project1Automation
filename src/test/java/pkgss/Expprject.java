package pkgss;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Expprject {
	WebDriver driver;
	String baseurl="https://www.aliexpress.com/";
@BeforeTest
public void setup() {
	driver=new ChromeDriver();	
}
@BeforeMethod
public void urlloading() {
	driver.get(baseurl);
}
@Test
public void tests() throws Exception {
	//Navigation
	driver.manage().window().maximize();	
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//Locator(xpath)
	driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[3]/div[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[2]/div[2]/div[1]/div/div")).click();
	driver.findElement(By.xpath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[3]/span[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[2]/div[2]/div[2]/div[9]")).click();
    
    driver.navigate().refresh();
	Thread.sleep(1000);
	driver.navigate().refresh();
	
	
	driver.findElement(By.xpath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[1]/div/div/div/div[2]/div[2]/img")).click();
	
	//action class(mousehover)
	WebElement hover=driver.findElement(By.xpath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[2]/div[3]/div/b/span[1]"));	
	Actions act=new Actions(driver);
	act.moveToElement(hover).perform();
	driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[1]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"batman-dialog-wrap\"]/div/div/div/div[1]/div/div[3]/div[2]/div/span/span[1]/span[1]/input")).sendKeys("meenumohankgr@gmail.com");
	//action class(Keyboard)
    Actions act1=new Actions(driver);
	act1.sendKeys(Keys.ENTER).perform();
	driver.findElement(By.xpath("//*[@id=\"fm-login-password\"]")).sendKeys("1856MEEN**");
    driver.findElement(By.xpath("//*[@id=\"batman-dialog-wrap\"]/div/div/div/div[1]/div[9]/button")).click();
    driver.findElement(By.xpath("//*[@id=\"batman-dialog-wrap\"]/div/span/div/img")).click();
    driver.findElement(By.xpath("//*[@id=\"batman-dialog-wrap\"]/div/a[2]")).click();
   
    WebElement hover1=driver.findElement(By.xpath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[1]/div/div/div/div/img"));	
	Actions act2=new Actions(driver);
	act2.moveToElement(hover1).perform();
	
	
	//file upload
	driver.findElement(By.xpath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[3]/div[4]/span")).click();
	fileUpload("C:\\Users\\meenu\\Pictures\\Saved Pictures\\Capture.png");}
      
	private void fileUpload(String p) throws AWTException, IOException, Exception {
	StringSelection strSelection=new StringSelection(p);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
	
	Robot robo=new Robot();
	robo.delay(3000);
	robo.keyPress(KeyEvent.VK_CONTROL);
	robo.keyPress(KeyEvent.VK_V);
	robo.keyRelease(KeyEvent.VK_V); 
	robo.keyRelease(KeyEvent.VK_CONTROL);
	robo.keyPress(KeyEvent.VK_ENTER);
	robo.keyRelease(KeyEvent.VK_ENTER);
     
   
    
	
	driver.navigate().refresh();
    
   driver.findElement(By.xpath("//*[@id=\"search-words\"]")).sendKeys("watches");
   driver.findElement(By.xpath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[1]/div/input[2]")).click();
    
   //scrollby
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,1000)","");
    driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/div[2]/div[2]/span/span[2]/span[1]")).click();

	
        //window handling
		String parentWindow=driver.getWindowHandle();
	    driver.findElement(By.xpath("//*[@id=\"card-list\"]/div[9]/div/div/a/div[1]/div[1]/div[1]")).click();//iteam
		
		Set<String> allwindowhandles = driver.getWindowHandles();
		
		for(String handle:allwindowhandles)
		{
			System.out.println(handle);
			
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div/div/div[7]/button[2]/span")).click();//add to cart
				//driver.findElement(By.xpath("")).click();
			//	driver.close();
			}
			driver.switchTo().window(parentWindow);
	
	
	
	//screenshot
	WebElement dayelement=driver.findElement(By.xpath("//*[@id=\"card-list\"]/div[9]/div/div/a/div[1]/div[1]/div[1]"));
	File src1=dayelement.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src1, new File("./Screenshot1//Elementsscreenshot01.png"));
	
	
	
	
	//Link Validation
	URL ob=new URL(baseurl);
	HttpURLConnection con=(HttpURLConnection)ob.openConnection();
	con.connect();
	if(con.getResponseCode()==200)
	{
		System.out.println("valid url");
	}
	else
	{
		System.out.println("Invalid url");
	}
	
	driver.navigate().back();
	Thread.sleep(200);
	driver.navigate().back();
	
	 
}	
}
}
