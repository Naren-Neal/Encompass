package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class J_Smucker {
	static WebDriver driver;
	public static void main(String[] args) throws FindFailed, IOException {
		System.setProperty("webdriver.gecko.driver", "E:\\doftware\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("http://www.smuckers.com/");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("E:\\screenshot.png"));
		
       // org.sikuli.script.Pattern open= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Smuker.PNG");
       
        //Pattern baseImagePattern = new Pattern("C:\\Users\\narendra\\Desktop\\test\\Smuker.PNG");
        Pattern capturedImagePattern = new Pattern("E:\\screenshot.png");

        Screen screen=new Screen();
        Match pass = screen.exists(capturedImagePattern);

        System.out.println("Pass = ");
        System.out.println(pass);

        if (screen.exists(capturedImagePattern) != null) {
             System.out.println("true");
        }
        else{
                 System.out.println("false");
        }
      
		
	}

}
