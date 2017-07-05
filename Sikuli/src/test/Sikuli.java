package test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;



public class Sikuli {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, FindFailed {
		
		//Launch firefox browser 
		System.setProperty("webdriver.gecko.driver", "E:\\doftware\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1");
        //Enter Email and Password and click on SignIn Button
		driver.findElement(By.id("Email")).sendKeys("niftynaren3");
		driver.findElement(By.id("next")).click();
		Thread.sleep(500);
		driver.findElement(By.id("Passwd")).sendKeys("neal@2306");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(5000);
		//Click on Compose
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		Thread.sleep(500);
		//Click on Upload Link
		driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
		//Use Sikuli for to match pattern of Image 
		org.sikuli.script.Pattern open= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\filename.PNG");
		org.sikuli.script.Pattern open1= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\open.PNG");
		
		org.sikuli.script.Screen scr= new org.sikuli.script.Screen();
		scr.setAutoWaitTimeout(30);
		scr.type(open, "C:\\Users\\narendra\\Desktop\\test\\searchButton");
		scr.click(open1);
		
	}

}
