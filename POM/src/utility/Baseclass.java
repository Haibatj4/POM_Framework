package utility;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Baseclass
{
     public static WebDriver driver;
     public static String screenshotFolderName;
     
     @BeforeTest
     public static void OpenBrowserApp()
     {
    	 System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Browsers\\137\\chromedriver-win64\\chromedriver.exe");
    	 Log.info("***Started Execution****");
	 driver = new ChromeDriver();
	 driver.navigate().to("https://the-internet.herokuapp.com/");
	 }
     
   
     @AfterTest
     public static void CloseBrowserApp()
     {
    	 driver.quit();
    	 Log.info("Application Close Sucessfully!!!");
     }

     public void screenShots(String fileName) throws IOException
     {
    	 if(screenshotFolderName == null)
    	 {
    		 LocalDateTime myDateObj = LocalDateTime.now();
        	 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

        	 screenshotFolderName = myDateObj.format(myFormatObj);
    	 }
    	 
    	 
    	    
    	TakesScreenshot ts=(TakesScreenshot)driver;
 		File src=ts.getScreenshotAs(OutputType.FILE);
 		File dest=new File("./screenshots/" +screenshotFolderName+ "/"+fileName);
 		try {
 		FileUtils.copyFile(src, dest);//commons.io
 		}
 		catch(IOException e)
 		{
 			e.printStackTrace();
 		}
 		System.out.println("Screenshots saved sucessfully!!!!");
     }
     
	
}
