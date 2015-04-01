package testscripts.mediaTypes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class MusicTest {
@Test(groups={"MediaTypes"})

public  static void  music () throws Exception{
	
	
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
	 
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Music/Functional/Music 01.png');");					
	// Open rtMedia Settings 
			Constants.openrtMediaSettings(wd);

			// Allow upload from Activity Stream must be ON
			// Click on rtMedia settings BuddyPress Tab

					wd.findElement(By.id("tab-rtmedia-bp")).click();

					System.out.println("BuddyPress Tab Opened");
					
	List<WebElement> switchElement = wd.findElements(By
	.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-activity\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

				if (switchElement.size() != 0) {

				switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
				System.out.println("'Allow Upload From Activity Stream' is switched  on");
					} 
				else
					System.out.println("'Allow Upload From Activity Stream' is already on");
							
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Music/Functional/Music 02.png');");					
					
		// save the BuddyPress settings
			
			// click on Types 
			
			wd.findElement(By.id("tab-rtmedia-types")).click();

			System.out.println("Types  Tab Opened");
			
			// Music
		
			// Check if the switch for Allow Music Upload  is on or off , if its off then switch it to on and proceed

List<WebElement> switchElement2 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-22\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement2.size() != 0) {

		switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
		System.out.println("'The setting for enabling Music' is switched  on");
			} 
		else
			System.out.println("The Switch for enabling Music  is already ON");
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Music/Functional/Music 03.png');");					
			
			// save the settings Form
			wd.findElement(By.id("rtmedia-settings-submit")).click();
			System.out.println("Settings saved");
			Thread.sleep(2000);		
			
			// Do a mouse over on the primary menu on top LHS
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

			// Click on Visit Site

			wd.findElement(By.linkText("Visit Site")).click();
			
			// Click on ACTIVITY
			
			/*wd.get(Constants.WP_SERVER_ACTIVITY);*/
			wd.navigate().to(Constants.WP_SERVER + "/activity");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Media Types/Music/Functional/Music 04.png');");		
						
			wd.findElement(By.id("whats-new")).click();
		
			Thread.sleep(2000);
			System.out.println(" Clicked Activity");
				
			
			// Upload Media : Music
			
			// Click Attach Files
			
			wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
			
			Thread.sleep(3000);
			System.out.println("Attach Files Clicked");
					
			((PhantomJSDriver) wd).executePhantomJS("var page=this; "
			        + "var count=0;" + "page.uploadFile('input[type=file]',['"
			        + Constants.MusicPhantom +"','"+Constants.Music2+"', ]);");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Music/Functional/Music 05.png');");			
			Thread.sleep(10000); // Increase sleep for Music and Video uploads
			
			// Enter some content

			wd.findElement(By.id("whats-new")).click();
			wd.findElement(By.id("whats-new")).clear();
			wd.findElement(By.id("whats-new")).sendKeys("Check Music ");				
			System.out.println("Check Music  text entered");	
			Thread.sleep(4000);
			
			// Click  Post Update
			
			wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
			System.out.println("Post Update button clicked");	
			Thread.sleep(6000);
			
		/*	// Click on ACTIVITY
			wd.findElement(By.linkText("ACTIVITY")).click();
			wd.findElement(By.id("whats-new")).click();
			wd.findElement(By.id("whats-new")).clear();
			wd.findElement(By.id("whats-new")).sendKeys("Check  Media Type : Music ");
			
			// Upload Media

			wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
			Thread.sleep(8000);
			Runtime.getRuntime().exec(Constants.Music);

			Thread.sleep(14000);

			wd.findElement(By.id("aw-whats-new-submit")).click();*/
		
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Music/Functional/Music 06.png');");
	// Verify Music Files Added
	  if (!wd.findElement(By.tagName("html")).getText().contains("mpthreetest")) {
          System.out.println("verifyTextPresent failed");
      }
	  else {
		  System.out.println("Mp3test is Present");
	  }
      
      if (!wd.findElement(By.tagName("html")).getText().contains("SukoonMila")) {
          System.out.println("verifyTextPresent failed"); }
     
	
		
			// log out
			Constants.logout(wd);





			
			

	
}

}
