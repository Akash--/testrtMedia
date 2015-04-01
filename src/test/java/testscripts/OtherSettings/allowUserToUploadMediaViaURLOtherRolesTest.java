/*@ Author Sumeet*/
package testscripts.OtherSettings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class allowUserToUploadMediaViaURLOtherRolesTest {
	@Test(groups={"OtherSettings"})
	
//  Pro only feature 
// run it after allowUserToUploadMediaViaURL.java
public static void UploadMediaViaURLNonAdminRoles() throws Exception {

	// Phantom js : headless
		// Code to take screenshots
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	

		// Login to wordpress 
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.TestContributor, Constants.TestContributorPassword);
		 System.out.println("Correctly Logged In");
	Thread.sleep(2000);
	
	// Reach the Media Gallery 
	
    //  Mouseover  on Profile (Howdy, admin) section , click on Media 

			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			//Thread.sleep(4000);
			new Actions(wd).moveToElement(wd.findElement(By.linkText("Media"))).build().perform();
			
			wd.findElement(By.linkText("Media")).click();
			Thread.sleep(1000);
			System.out.println("Media Tab clicked");
			// Upload Media in Gallery by URL
			((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Other/Upload Media via url/Functional/Moderation2.png'); ");	
            wd.findElement(By.id("rtm_show_upload_ui")).click();
            Thread.sleep(1000);
			wd.findElement(By.cssSelector("#drag-drop-area > div.rtm-uploader-main-wrapper > div.rtm-uploader-tabs > ul > li.rtm-url-import-tab")).click();

			//wd.findElement(By.id("rtm_show_upload_ui")).click();
			Thread.sleep(2000);
			
			wd.findElement(By.id("rtmedia_url_upload_input")).click();
			Thread.sleep(2000);
			wd.findElement(By.id("rtmedia_url_upload_input")).clear();
			Thread.sleep(2000);
   // Add URL 
wd.findElement(By.id("rtmedia_url_upload_input")).sendKeys("http://www.hdwallpapersinn.com/wp-content/uploads/2014/07/taj_mahal_india_wallpaper.jpg");
Thread.sleep(4000);

		// some links for testing 	
//files other than mp4 for videos , mp3 for audio , jpg, jpeg, png, gif for images , txt, doc, docx, xls, xlsx, ppt, pptx, pdf, xps, pages for Documents won't work @ localhost
		/*	http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4
				http://clips.vorwaerts-gmbh.de/big_buck_bunny.ogv
					http://clips.vorwaerts-gmbh.de/big_buck_bunny.webm
					
					http://kevinwiliarty.com/openvideo/external-vfe-tester.mp4
http://kevinwiliarty.com/openvideo/external-vfe-tester.webm  

http://kevinwiliarty.com/openvideo/external-vfe-tester.ogv

Get more from http://download.wavetlan.com/SVV/Media/HTTP/http-mp4.htm
http://www.hdwallpapersinn.com/wp-content/uploads/2014/07/taj_mahal_india_wallpaper.jpg
or http://download.wavetlan.com/SVV/Media/HTTP/
				*/
				
				
			
			// click on Terms and Conditions . Uncomment IF statement when T& C is Enabled 
			/*if (!wd.findElement(By.id("rtmedia_upload_terms_conditions"))
					.isSelected()) {
				wd.findElement(By.id("rtmedia_upload_terms_conditions")).click();
			}
			*/
			// click Start Upload button after entering correct URL
			
			wd.findElement(By.cssSelector("input.start-media-upload")).click();
			Thread.sleep(4000);
			wd.navigate().refresh();
			Thread.sleep(5000);
			
			
			// log out
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			Thread.sleep(2000);
			wd.findElement(By.linkText("Log Out")).click();
			  wd.quit();
	
	
}
	
}
