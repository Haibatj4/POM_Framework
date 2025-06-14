package testcasessuite;


import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.frame;
import utility.Baseclass;
import org.apache.log4j.xml.DOMConfigurator;
import utility.Log;


public class Testcase1 {

	@Test
	public static void testcase1() throws AWTException
	{
	DOMConfigurator.configure("log4j.xml");
		Baseclass.OpenBrowserApp();
		frame.frames();
		//Baseclass.OpenAnotherBrowserApp();
		Baseclass.CloseBrowserApp();
		
		
	}
	
	@Test
	public static void testcase2() throws AWTException
	{
	
		Baseclass.OpenBrowserApp();
		frame.framesNew1();
		
		Baseclass.CloseBrowserApp();
			
	}
}
