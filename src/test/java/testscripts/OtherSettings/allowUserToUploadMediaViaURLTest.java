/*@ Author Sumeet*/
package testscripts.OtherSettings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import testscripts.Constants;

public class allowUserToUploadMediaViaURLTest {
	@Test(groups={"OtherSettings"})

//  Pro only feature 
public static void UploadMediaViaURL() throws Exception {
	
	// Phantom js : headless
		// Code to take screenshots
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		 
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/URL UPLOAD 1.png');");
	/*// Login to WordPress with user role : Administrator
	wd.get(Constants.WP_SERVER); 
	Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);*/
			
	// Open rtMedia Settings 
	
	Constants.openrtMediaSettings(wd);
	
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/User upload via url/Functional/URL UPLOAD 2.png');");			
	
	// Click on rtMedia settings OtherSettings Tab

	wd.findElement(By.id("tab-rtmedia-general")).click();
			
	System.out.println("Other Settings  Tab Opened");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/User upload via url/Functional/URL UPLOAD 3.png');");			
	// Check if the switch is on or off, if its off then switch on and  proceed
	
	
List<WebElement> switchElement = wd.findElements(By
.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-40\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

	if (switchElement.size() != 0) {

switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
System.out.println("'Allow Upload via URL' is switched  on");
						} 
					else
						System.out.println("'Allow Upload via URL' is already on");
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/User upload via url/Functional/URL UPLOAD 4.png');");					
	
			// Enable terms and conditions 
			
					try{			
			List<WebElement> switchElement2 = wd.findElements(By
					.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-39\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

						if (switchElement2.size() != 0) {

						switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
						System.out.println("'Terms and Conditions' is switched  on");
							} 
						else
							System.out.println("'Terms and Conditions' is already on");
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/User upload via url/Functional/URL UPLOAD 5.png');");				


					wd.findElement(By.id("rt-form-text-15")).click();
			        wd.findElement(By.id("rt-form-text-15")).clear();
			        wd.findElement(By.id("rt-form-text-15")).sendKeys("https://rtcamp.com/refund-policy/");
			        Thread.sleep(2000);
			        System.out.println("Terms and Conditions link text entered");  
}  catch(Throwable t)   {System.out.println("Terms and Conditions is Pro only");}	
					
	Thread.sleep(2000);
	// save the  settings
	wd.findElement(By.id("rtmedia-settings-submit")).click();
			Thread.sleep(2000);
			System.out.println("Settings Saved");
			Thread.sleep(2000);
		
			
			// Do a mouse over on the primary menu on top LHS
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

// Click on Visit Site

	wd.findElement(By.linkText("Visit Site")).click();
	
	// Reach the Media Gallery 
	
	//  Mouseover  on Profile (Howdy, admin) section , click on Media 

	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
	Thread.sleep(1000);
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
	wd.findElement(By.linkText("Media")).click();
	
System.out.println("Media Tab Clicked");			
	Thread.sleep(5000);
	
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/User upload via url/Functional/URL UPLOAD 6.png');");			
	
	// Upload Media in Gallery by URL
Thread.sleep(2000);
			wd.findElement(By.id("rtm_show_upload_ui")).click();
			Thread.sleep(2000);	
			wd.findElement(By.cssSelector("#drag-drop-area > div.rtm-uploader-main-wrapper > div.rtm-uploader-tabs > ul > li.rtm-url-import-tab")).click();
			wd.findElement(By.id("rtmedia_url_upload_input")).click();
   wd.findElement(By.id("rtmedia_url_upload_input")).clear();
   Thread.sleep(2000);
   // Add URL 
wd.findElement(By.id("rtmedia_url_upload_input")).sendKeys("http://www.hdwallpapersinn.com/wp-content/uploads/2014/07/taj_mahal_india_wallpaper.jpg");
Thread.sleep(2000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/User upload via url/Functional/URL UPLOAD 7.png');");
		// some links for testing 	
		/*	Videos:
		 http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4
				http://clips.vorwaerts-gmbh.de/big_buck_bunny.ogv
					http://clips.vorwaerts-gmbh.de/big_buck_bunny.webm
					
					http://kevinwiliarty.com/openvideo/external-vfe-tester.mp4
http://kevinwiliarty.com/openvideo/external-vfe-tester.webm
http://kevinwiliarty.com/openvideo/external-vfe-tester.ogv
Images :
http://www.hdwallpapersinn.com/wp-content/uploads/2014/07/taj_mahal_india_wallpaper.jpg
Get more from http://download.wavetlan.com/SVV/Media/HTTP/http-mp4.htm

or from http://download.wavetlan.com/SVV/Media/HTTP/
				*/
				
				
			
			// click on Terms and Conditions . Uncomment if statement when T& C is Enabled 
			if (!wd.findElement(By.id("rtmedia_upload_terms_conditions"))
					.isSelected()) {
				wd.findElement(By.id("rtmedia_upload_terms_conditions")).click();
			}
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/User upload via url/Functional/URL UPLOAD 8.png');");			
			// click Start Upload button after entering correct URL
			
			wd.findElement(By.cssSelector("input.start-media-upload")).click();
			Thread.sleep(2000);
			wd.navigate().refresh();
			Thread.sleep(2000);
			System.out.println("media uploaded through url");
			Thread.sleep(2000);
			
			
			/*new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			Thread.sleep(1000);
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
			wd.findElement(By.linkText("Media")).click();
			
		System.out.println("Media Tab Clicked");			

			
			
			String Medianame=wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
			+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).getText();
			System.out.println(Medianame);
			Assert.assertEquals("taj_mahal_india_wallpaper" ,Medianame);
			
			
		*/	
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/User upload via url/Functional/URL UPLOAD 9.png');");	
			
			// log out
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			Thread.sleep(1000);
			wd.findElement(By.linkText("Log Out")).click();
			  wd.quit();
	
	
}
	
	
}
