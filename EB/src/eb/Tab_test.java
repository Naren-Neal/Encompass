package eb;




import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tab_test {

	public static void main(String[] args) throws InterruptedException {
		
		//WebDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\doftware\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
	
	       driver.get("http://google.com");
	      //  String windowHandle = driver.getWindowHandle();
           driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

	       ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
           System.out.println(tabs);
	      //Switch to new window
	       driver.switchTo().window(tabs.get(1));
	       driver.get("http://google.com");

	    //  driver.close();//do some action in new window(2nd tab)
	       Thread.sleep(500);
	      //Switch to main/parent window
	    // driver.switchTo().window(tabs.get(0));
	       driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
	       driver.getTitle();//do some action in main window(1st tab)
	      // driver.switchTo().window(tabs.get(1));
	       Thread.sleep(500);

           driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");


		            
		        
		    



    

	}

}
