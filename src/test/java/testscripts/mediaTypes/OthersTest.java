package testscripts.mediaTypes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class OthersTest {
	@Test(groups={"MediaTypes"})
// Try zip files and other file extensions.
// Allowing other file types for upload could be dangerous
public static void otherextensions() throws Exception {

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
		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
		
		// Allow upload from Activity Stream must be ON
	/*			// Click on rtMedia settings BuddyPress Tab

						wd.findElement(By.id("tab-rtmedia-bp")).click();

						System.out.println("BuddyPress Tab Opened");
						// Check if the switch is on or off, if its off then switch on and  proceed
						boolean checkBox1 = wd.findElement(By.id("rtmedia-bp-enable-activity")).isSelected();
						if (checkBox1 == false)
							wd.findElement(By.id("rtmedia-bp-enable-activity")).click();
						else
							System.out.println("The Switch  is already ON");*/
		
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
								
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Other/Functional/Others 01.png');");					
						
						// save the BuddyPress settings
				
				// click on Types 
				
				wd.findElement(By.id("tab-rtmedia-types")).click();

				System.out.println("Types  Tab Opened");
 
				// Other Extensions
				
				// Check if the switch for Other extensions Upload is on or off, if its off then switch it to on and proceed
				
				List<WebElement> switchElement2 = wd.findElements(By
				.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-27\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

						if (switchElement2.size() != 0) {

						switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
						System.out.println("'The setting for enabling Other File Types' is switched  on");
							} 
						else
							System.out.println("The Switch for enabling Other File types  is already ON");
															
				
				// enter an extension. Eg : zip   

				wd.findElement(By.id("rtm_other_extensions")).click();
				wd.findElement(By.id("rtm_other_extensions")).clear();
				Thread.sleep(3000);
				wd.findElement(By.id("rtm_other_extensions")).sendKeys("zip"); // can enter zip, exe, ...
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Other/Functional/Others 02.png');");				
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
/*				wd.findElement(By.linkText("ACTIVITY")).click();*/
				wd.findElement(By.id("whats-new")).click();
				wd.findElement(By.id("whats-new")).clear();
				wd.findElement(By.id("whats-new")).sendKeys("Check  Media Type : Others");
				
// Upload Media : Others
					
				// Click Attach Files
				
				wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
				
				Thread.sleep(3000);
				System.out.println("Attach Files Clicked");
						
				((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				        + "var count=0;" + "page.uploadFile('input[type=file]',['"
				        + Constants.OthersPhantom +"','"+Constants.PhotoPhantom+"', ]);");
				
				Thread.sleep(11000); // Increase sleep for Music and Video uploads
				((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Other/Functional/Others 03.png');");				
				// Enter some content

				wd.findElement(By.id("whats-new")).click();
				wd.findElement(By.id("whats-new")).clear();
				wd.findElement(By.id("whats-new")).sendKeys("Check Other File Types");				
				System.out.println("Check Other File Types  text entered");	
				Thread.sleep(4000);
				
				// Click  Post Update
				
				wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
				System.out.println("Post Update button clicked");	
							
				Thread.sleep(10000);
				((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Other/Functional/Others 04.png');");
				/*
				// Upload Media

				wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
				Thread.sleep(10000);
				Runtime.getRuntime().exec(Constants.Others);

				Thread.sleep(10000);

				wd.findElement(By.id("aw-whats-new-submit")).click();
				*/
				//Thread.sleep(10000);
				

				// log out
				Constants.logout(wd);
		
				
}
	
}
