package pages;


import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import utility.Baseclass;

public class frame extends Baseclass {
		
	static By txt_frames = By.linkText("Frames");
	static By txt_frame_word = By.xpath("//div[@class='example']/h3[contains(text(),'Frames')]");
	static By click_iframelink =By.linkText("iFrame");
	static By get_iframeheader = By.xpath("//h3[contains(text(),'An iFrame containing the TinyMCE WYSIWYG Editor')]");
	static By remove_text = By.xpath("//p[contains(text(),'Your content goes here.')]");
	static By txt_file = By.xpath("//span[(contains(text(),'File'))]");
	
	static By txt_edit = By.xpath("//span[(contains(text(),'Edit'))]");
	static By txt_view = By.xpath("//span[(contains(text(),'View'))]");
	static By txt_format = By.xpath("//span[(contains(text(),'Format'))]");
	static By txt_box = By.xpath("//body//p");
	static By txt_element_link_bottom_page = By.linkText("Elemental Selenium");
	
	public static void frames() throws AWTException
	{
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(txt_frames).click();
		
		
		String str = driver.findElement(txt_frame_word).getText();
		driver.findElement(click_iframelink).click();
		assertTrue(str.equals("Frames"));
		String str1 = driver.findElement(get_iframeheader).getText();
		assertTrue(str1.equals("An iFrame containing the TinyMCE WYSIWYG Editor"));
		
		driver.switchTo().frame("mce_0_ifr");//Enter frame
		driver.findElement(remove_text).clear();
		
		
		
		driver.switchTo().defaultContent();//Exit frame
		
		String txt_file_parentmenu = driver.findElement(txt_file).getText();
		System.out.println("Parent Menu File option is visible: "+txt_file_parentmenu);
		
		String txt_edit_parentmenu = driver.findElement(txt_edit).getText();
		System.out.println("Parent Menu Edit option is visible: "+txt_edit_parentmenu);
		
		String txt_view_parentmenu = driver.findElement(txt_view).getText();
		System.out.println("Parent Menu View option is visible: "+txt_view_parentmenu);
		
		String txt_format_parentmenu = driver.findElement(txt_format).getText();
		System.out.println("Parent Menu Format option is visible: "+txt_format_parentmenu);
		
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(txt_box).sendKeys("Test");
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		WebElement ele_format = driver.findElement(txt_format);
		ele_format.click();
	
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		

		
		
		driver.findElement(txt_element_link_bottom_page).click();
		
		
	}
	
	
	public static void framesNew1() throws AWTException
	{
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(txt_frames).click();
		
		
		String str = driver.findElement(txt_frame_word).getText();
		driver.findElement(click_iframelink).click();
		assertTrue(str.equals("Frames!!!!"));
		String str1 = driver.findElement(get_iframeheader).getText();
		assertTrue(str1.equals("An iFrame containing the TinyMCE WYSIWYG Editor"));
		
		driver.switchTo().frame("mce_0_ifr");//Enter frame
		driver.findElement(remove_text).clear();
		
		
		
		driver.switchTo().defaultContent();//Exit frame
	}
	
	

}
