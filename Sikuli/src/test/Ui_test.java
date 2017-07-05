package test;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;

import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class Ui_test {
	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException {
		System.setProperty("webdriver.chrome.driver", "E:\\doftware\\chromedriver.exe");
		// Initialize browser.
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//System.setProperty("webdriver.gecko.driver", "E:\\doftware\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		//driver =new FirefoxDriver();
		driver.get("http://www.smuckers.com/");
		
		WebElement ele = driver.findElement(By.xpath(".//*[@id='header-container']/header"));   
		//Get entire page screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		//Get the location of element on the page
		Point point = ele.getLocation();
		//Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		System.out.println(eleWidth);
		System.out.println(eleHeight);
		//Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,
		    eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);
		//Copy the element screenshot to disk
		File screenshotLocation = new File("E:\\GoogleLogo_screenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		
	
		
		Thread.sleep(1000);
		System. setProperty("webdriver.chrome.driver", "E:\\doftware\\chromedriver.exe");
		// Initialize browser.
		WebDriver driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("http://www.smuckers.com/");
		WebElement ele1 = driver1.findElement(By.xpath(".//*[@id='header-container']/header"));   
		//Get entire page screenshot
		File screenshot1 = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg1 = ImageIO.read(screenshot1);
		//Get the location of element on the page
		Point point1 = ele1.getLocation();
		//Get width and height of the element
		int eleWidth1 = ele1.getSize().getWidth();
		int eleHeight1 = ele1.getSize().getHeight();
		System.out.println(eleWidth1);
		System.out.println(eleHeight1);
		//Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot1= fullImg1.getSubimage(point1.getX(), point1.getY(), eleWidth1,
		    eleHeight1);
		ImageIO.write(eleScreenshot1, "png", screenshot1);
		//Copy the element screenshot to disk
		File screenshotLocation1 = new File("E:\\Chrome_snap\\GoogleLogo_screenshot.png");
		FileUtils.copyFile(screenshot1, screenshotLocation1);
		driver1.quit();

		processImage();

		
		
	}

	private static void processImage() {
		String file1 = "E:\\GoogleLogo_screenshot.png";
        String file2 = "E:\\Chrome_snap\\GoogleLogo_screenshot.png";
        
        Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
        Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
 
        try 
        {    
            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);
 
            int[] data1 = null;
 
            if (grab1.grabPixels()) 
            {
                int width = grab1.getWidth();
                int height = grab1.getHeight();
                System.out.println(width);
                System.out.println(height);
                data1 = new int[width * height];
                data1 = (int[]) grab1.getPixels();
            }
 
            int[] data2 = null;
 
            if (grab2.grabPixels()) {
                int width1 = grab2.getWidth();
                int height1 = grab2.getHeight();
                System.out.println(width1);
                System.out.println(height1);
                data2 = new int[width1 * height1];
                data2 = (int[]) grab2.getPixels();
            }
 
            System.out.println("Pixels equal: " + java.util.Arrays.equals(data1, data2));
 
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
		
	}

	
	