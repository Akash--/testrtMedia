package testscripts;

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

public class MediaTest {
@Test
	public static void media() throws Exception {

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

		// Open rtMedia Settings

		Constants.openrtMediaSettings(wd);

		wd.findElement(By.id("tab-rtmedia-bp")).click();

		System.out.println("BuddyPress Tab Opened");

		List<WebElement> switchElement = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-activity\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement.size() != 0) {

			switchElement.get(0)
					.findElement(By.cssSelector("span.switch-right")).click();
			System.out
					.println("'Allow Upload From Activity Stream' is switched  on");
		} else
			System.out
					.println("'Allow Upload From Activity Stream' is already on");

		// click on Types

		wd.findElement(By.id("tab-rtmedia-types")).click();

		System.out.println("Types  Tab Opened");

		// Photos
		// Check if the switch for Allow Photos Upload is on or off, if its off
		// then switch it to on and proceed

		List<WebElement> switchElement2 = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-18\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement2.size() != 0) {

			switchElement2.get(0)
					.findElement(By.cssSelector("span.switch-right")).click();
			System.out
					.println("'The setting for enabling Photos' is switched  on");
		} else
			System.out.println("The Switch for enabling Photos  is already ON");

		// Video

		List<WebElement> switchElement3 = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-20\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement3.size() != 0) {

			switchElement3.get(0)
					.findElement(By.cssSelector("span.switch-right")).click();
			System.out
					.println("'The setting for enabling Video' is switched  on");
		} else
			System.out.println("The Switch for enabling Video  is already ON");

/*
		// Music 
		

List<WebElement> switchElement4 = wd.findElements(By
.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-22\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement4.size() != 0) {

		switchElement4.get(0).findElement(By.cssSelector("span.switch-right")).click();
		System.out.println("'The setting for enabling Music' is switched  on");
			} 
		else
			System.out.println("The Switch for enabling Music  is already ON");	
		
		
	//Document	
		
List<WebElement> switchElement5 = wd.findElements(By
.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-24\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

	if (switchElement5.size() != 0) {

	switchElement5.get(0).findElement(By.cssSelector("span.switch-right")).click();
	System.out.println("'The setting for enabling Documents' is switched  on");
		} 
	else
		System.out.println("The Switch for enabling Documents  is already ON");	*/	
	// save the settings Form
			wd.findElement(By.id("rtmedia-settings-submit")).click();
			System.out.println("Settings saved");
			Thread.sleep(2000);
	
	// Do a mouse over on the primary menu on top LHS
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
	// Click on Visit Site

	wd.findElement(By.linkText("Visit Site")).click();
	
	// Click on ACTIVITY
	wd.navigate().to(Constants.WP_SERVER + "/activity");
	
	wd.findElement(By.id("whats-new")).click();
	
	
	
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTest/MediaTest1.png');");
	
	// Upload Media : Photos
	
	// Click Attach Files
	
	wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
	
	Thread.sleep(3000);
	System.out.println("Attach Files Clicked");


	((PhantomJSDriver) wd).executePhantomJS("var page=this; "
	        + "var count=0;" + "page.uploadFile('input[type=file]',['"
	        + Constants.VideoPhantom +"','"+ Constants.Video2+"','"+ Constants.Photo2 +"','"+ Constants.PhotoPhantom+"']);");			
	Thread.sleep(4000); // Increase sleep for Music and Video uploads
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTest/MediaTest2.png');");					
	// Enter some content

	wd.findElement(By.id("whats-new")).click();
	wd.findElement(By.id("whats-new")).clear();
	wd.findElement(By.id("whats-new")).sendKeys("Sample Media ");				
	System.out.println("Sample Media  text entered");	
	Thread.sleep(4000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTest/MediaTest3.png');");	
	// Click  Post Update
	
 

	wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
	System.out.println("Post Update button clicked. Uploading Starts");	
	Thread.sleep(2000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTest/MediaTest4.png');");
	Thread.sleep(2000);
	// Verify Media Upload  : test
	
	if (!wd.findElement(By.tagName("html")).getText().contains("test")) {
        System.out.println("verifyMediaName : test  failed");
    }
	else {
		System.out.println("verifyMediaNamePresent: test  Passed");
	}
	
	if (!wd.findElement(By.tagName("html")).getText().contains("test2")) {
        System.out.println("verifyMediaNamePresent : test2 failed");
    }
	else {
		System.out.println("verifyMediaNamePresent : test 2 Passed");
	}
	
	if (!wd.findElement(By.tagName("html")).getText().contains("smallvideo")) {
        System.out.println("verifyMediaNamePresent : smallvideo failed");
    }
	else {
		System.out.println("verifyMediaNamePresent : smallvideo Passed");
	}
	
	if (!wd.findElement(By.tagName("html")).getText().contains("testmpfour")) {
        System.out.println("verifyMediaNamePresent : testmpfour failed");
    }
	else {
		System.out.println("verifyMediaNamePresent : testmpfour Passed");
	}
	/*// Upload Videos
	
	// Click on ACTIVITY
			wd.navigate().to(Constants.WP_SERVER + "/activity");
			 wd.findElement(By.linkText("ACTIVITY")).click(); 
			wd.findElement(By.id("whats-new")).click();
			wd.findElement(By.id("whats-new")).clear();
			wd.findElement(By.id("whats-new")).sendKeys(
					"Check  Media Type : Videos");

			// Click Attach Files

			wd.findElement(By.cssSelector("button.rtmedia-add-media-button"))
					.click();

			Thread.sleep(3000);
			System.out.println("Attach Files Clicked");

			((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "var count=1;" + "page.uploadFile('input[type=file]',['"
					+ Constants.VideoPhantom + "','" + Constants.Video2 + "', ]);");
			((PhantomJSDriver) wd)
					.executePhantomJS("var page=this;"
							+ "page.render('./screen/MediaTypes/Functional/Video 04.png');");
			Thread.sleep(11000); // Increase sleep for Music and Video uploads

			// Enter some content

			wd.findElement(By.id("whats-new")).click();
			wd.findElement(By.id("whats-new")).clear();
			wd.findElement(By.id("whats-new")).sendKeys("Check Videos ");
			System.out.println("Check Videos  text entered");
			Thread.sleep(4000);

			// Click Post Update

			wd.findElement(By.cssSelector("input#aw-whats-new-submit")).click();
			System.out.println("Post Update button clicked");
			Thread.sleep(11000);
		// Upload Music	
			
			wd.navigate().to(Constants.WP_SERVER + "/activity");
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Media Types/Functional/Music 04.png');");		
								
					wd.findElement(By.id("whats-new")).click();
				
					Thread.sleep(2000);
					System.out.println(" Clicked Activity");
						
									
					// Click Attach Files
					
					wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
					
					Thread.sleep(3000);
					System.out.println("Attach Files Clicked");
							
					((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					        + "var count=2;" + "page.uploadFile('input[type=file]',['"
					        + Constants.MusicPhantom +"','"+Constants.Music2+"', ]);");
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Functional/Music 05.png');");			
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
					Thread.sleep(11000);
					
	// Upload Documents				
					
					// Click on ACTIVITY
					wd.navigate().to(Constants.WP_SERVER + "/activity");
			
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Functional/Document 1.png');");		
								
					wd.findElement(By.id("whats-new")).click();
				
					Thread.sleep(2000);
					System.out.println(" Clicked Activity");
			
					// Click Attach Files
					
					wd.findElement(By.cssSelector("button.rtmedia-add-media-button")).click();
					
					Thread.sleep(3000);
					System.out.println("Attach Files Clicked");
					// Multiple Documents
					((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					        + "var count=3;" + "page.uploadFile('input[type=file]',['"
					        + Constants.DocumentPhantom +"','"+Constants.Document+"']);");
					
					Thread.sleep(4000); // Increase sleep for Music and Video uploads
					
					// Enter some content

					wd.findElement(By.id("whats-new")).click();
					wd.findElement(By.id("whats-new")).clear();
					wd.findElement(By.id("whats-new")).sendKeys("Check Documents ");				
					System.out.println("Check Documents  text entered");	
					Thread.sleep(4000);
					
					// Click  Post Update
					
					wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
					System.out.println("Post Update button clicked");	
					Thread.sleep(11000);	*/
					
					/*// log out
					Constants.logout(wd);	*/
	}
}
