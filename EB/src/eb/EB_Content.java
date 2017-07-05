package eb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class EB_Content {

	public static void main(String[] args) throws InterruptedException {
    
		//Initiate Driver
		WebDriver driver= new FirefoxDriver();
		//Navigate To Url 
		driver.get("http://qa1eagle.ossclients.com/admin/login/");
		//Login
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Osscube@12345");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[contains(text(),'Objects')]")).click();
        Thread.sleep(10000);

        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[contains(text(),'123snapbrownies-4179')]")).click();
        Thread.sleep(10000);
	    String RecipeName=  driver.findElement(By.xpath("//input[@name='Recipe_Name']")).getAttribute("value");
	    System.out.println("RecipeName"+RecipeName);
	    driver.findElement(By.xpath("//span[contains(text(),'Recipe Images')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Recipe Relational Info')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Ingredients')]")).click();
	    String Ingredients=driver.findElement(By.xpath(".//*[@id='ext-gen1206']/div[1]/table/tbody/tr/td[2]/div")).getAttribute("innerHTML");
	    System.out.println("Ingredients Used"+Ingredients);
	}
	

}
