package testscripts.display;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class EnablePaginationForMediaTest {
	
	@Test(groups = { "Display" })
	public static void checkEnablePaginationandLoadMoreForMedia() throws Exception
	{
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));

		//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		 
		 Constants.openrtMediaSettings(wd);

		wd.findElement(By.id("tab-rtmedia-display")).click();
		System.out.println("display clicked");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Pagination/Functional/pagination btn media Test1.png');");	
		 
		//Thread.sleep(2000);

		wd.findElement(By.id("rt-form-number-0")).clear();
		wd.findElement(By.id("rt-form-number-0")).sendKeys("6");
		int i=6;
		
		System.out.println("set the value as 6");
		
		wd.findElement(By.id("rt-form-radio-1")).click();
		
		System.out.println("Clicked on Pagination Radio Button");
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
		System.out.println("rtMedia Settings Saved");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Pagination/Functional/pagination btn media Test2.png');");	
		
		
		//Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		Thread.sleep(1000);

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();
		// Navigate to Media gallery
				
		//  Mouseover  on Profile (Howdy, admin) section , click on Media 

		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		Thread.sleep(1000);
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
		wd.findElement(By.linkText("Media")).click();
						
		System.out.println("Reached Media Gallery ");			
		Thread.sleep(5000);
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Pagination/Functional/pagination btn media Test3.png');");	

		int media =(wd.findElements(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
				+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).size());
		String s1 =String.valueOf(media);
		System.out.println("Current Media on the page is :"+s1);
	
		if (i==media)
		{
			wd.findElement(By.id("rtmedia_go_to_num")).clear();
			wd.findElement(By.id("rtmedia_go_to_num")).sendKeys("2");
			System.out.println("put the page no as 2");
			wd.findElement(By.cssSelector("#bulk-edit-form > div.rtmedia_next_prev.row > div.pagination.text-right > div > a")).click();
			System.out.println("Go button clicked");
			
			Thread.sleep(3000);

			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Pagination/Functional/pagination btn media Test4.png');");		
		}
			
		else
		{
			System.out.println("Condition not match");
		}
		
	Constants.logout(wd);
	
	
	
	//log in from another user
	
	Capabilities caps2 = new DesiredCapabilities();
	((DesiredCapabilities) caps2).setJavascriptEnabled(true);
	((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);

	PhantomJSDriver wd1 = new PhantomJSDriver(caps2);
	wd1.manage().window().setSize(new Dimension(1920, 1080));
	//wd1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    // Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
	// Login to wordpress by as a TestEditor
	wd.get(Constants.WP_SERVER);
	Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
	System.out.println("Correctly Logged In from other user");
	 // Navigate to Media gallery
						
	//  Mouseover  on Profile (Howdy,) section , click on Media 

	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
	Thread.sleep(1000);
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
	wd.findElement(By.linkText("Media")).click();
										
	System.out.println("Media Gallery ");			
	Thread.sleep(5000);
	int media1 =(wd.findElements(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-3.rtm-pro-allow-act"
			+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).size());
	String s =String.valueOf(media1);
	System.out.println("Current Media on the page is :"+s);

	if (i==media)
	{
		wd.findElement(By.id("rtmedia_go_to_num")).clear();
		wd.findElement(By.id("rtmedia_go_to_num")).sendKeys("2");
		System.out.println("put the page no as 2");
		wd.findElement(By.cssSelector("#bulk-edit-form > div.rtmedia_next_prev.row > div.pagination.text-right > div > a")).click();
		System.out.println("Go button clicked");
		
		Thread.sleep(3000);

		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Pagination/Functional/another user pagination btn media Test5.png');");		
	}
		
	else
	{
		System.out.println("Condition not match");
	}

	
	
	
	

	}
	
	

}
