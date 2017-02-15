package test ;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.media.sound.InvalidFormatException;

public class Scroll {
	static WebDriver driver;
	static int i=0;
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException, HeadlessException, AWTException {
        for ( i=1; i<=2; i++){
		System.setProperty("webdriver.chrome.driver", "E:\\doftware\\chromedriver.exe");
		// Initialize browser.
	    driver=new ChromeDriver();
	   // driver.manage().window().maximize();
		driver.get("http://www.folgerscoffee.com/coffee-recipes/coffee-drink-recipes/all");
		Thread.sleep(3000);
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		Long DocumentLength = (Long) javascript.executeScript("return document.documentElement.scrollHeight");
		Long BrowserLength= (Long) javascript.executeScript("return document.documentElement.clientHeight;");
		Long x= (long) 0;
		int b=1;
		do{
		//Take Screenshot
		catchscreenshot(b);
		javascript.executeScript("scroll(0, "+(x+BrowserLength)+");");
		Thread.sleep(1000);
		DocumentLength=DocumentLength-BrowserLength;
		x=x+BrowserLength;
		b=b+1;
        
		}while(DocumentLength>0);
		driver.quit();
		}
        processImage();
	}
	public static void catchscreenshot (int no) throws IOException, HeadlessException, AWTException{

		try{
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   if(i==1){
		FileUtils.copyFile(scrFile, new File("E:\\Chrome_snap\\"+no+".png"));
		}
	   else {
		   FileUtils.copyFile(scrFile, new File("E:\\Chrome_snap1\\"+no+".png"));
	   }
	   
	   
		   
		}
		   catch(Throwable e){
		    System.out.println(e.getMessage());
		   }

		}
	private static void processImage() {
		for(int j=1;j<=6;j++){
		String file1 = "E:\\Chrome_snap\\"+j+".png";
        String file2 = "E:\\Chrome_snap1\\"+j+".png";
		
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
        }}
    }

}
