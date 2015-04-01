/*@ Author Sumeet*/
package testscripts.buddyPress;

//3.7.1.3
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
import org.testng.Reporter;
import org.testng.annotations.Test;

import testscripts.Constants;

//For this test to pass , you need to have ACTIVITY as a menu item and  Create a group named test   
public class allowUploadFromActivityStreamNGTest {
	@Test(groups = { "buddypressnegative" }) 
	public static void uploadactivity() throws Exception {
		// CHECK FOR PROFILES

		// Phantom js : headless
		// Code to take screenshots
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	
		// Login to WordPress 
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		Thread.sleep(1000);
				
		System.out.println("Correctly Logged In");		
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload From activity stream/Negative/Allow Upload Activity Negative 01.png');");		

		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
				
		Thread.sleep(5000);
		// Click on rtMedia settings BuddyPress Tab

		wd.findElement(By.id("tab-rtmedia-bp")).click();

		System.out.println("BuddyPress Tab Opened");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload From activity stream/Negative/Allow Upload Activity Negative 02.png');");		
		// Check if the switch is on or off, IF ON  then SWITCH  OFF
		List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-activity\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

		if (switchElement.size() != 0) {

			switchElement.get(0).findElement(By.cssSelector("span.switch-left")).click();
			
			System.out.println("Allow upload from activity stream disabled");

		} else
			System.out.println("Allow upload from activity stream is already off");
		
		// Check if the switch is on or off, if its off then switch on and  proceed
		
		Thread.sleep(4000);
		// save the BuddyPress settings
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("rtMedia Settings Saved");
		Thread.sleep(2000);
		
		// Do a mouse over on the primary menu on top LHS
		
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();
		// Click on ACTIVITY
		/*wd.get(Constants.WP_SERVER_ACTIVITY);*/
		wd.navigate().to(Constants.WP_SERVER + "/activity");
		/*wd.findElement(By.linkText("ACTIVITY")).click();*/
		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream : Photos ");
		
		//Check for Activity Attach Files Negative Case . Should not work
				boolean flag=false;
				if(wd.findElements(By.cssSelector("div.rtmedia-add-media-button")).size() == 0){
					System.out.println("Allow Upload From Activity is correctly disabled");
					Reporter.log("Allow Upload From Activity is correctly disabled");
					flag=true;
				} else {
					System.out.println("Allow Upload From Activity is still  enabled");
					Reporter.log("Allow Upload From Activity is still  enabled");
					flag=false;
				}
				Assert.assertEquals(flag, true,"Allow Upload From Activity is still  enabled");
				
				
			
			
/*			// Upload Media : Photo

		wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\sumeet\\Documents\\photo_x64.exe");
		Runtime.getRuntime().exec(Constants.Photo);

		Thread.sleep(5000);

		wd.findElement(By.id("aw-whats-new-submit")).click();
		
		Thread.sleep(5000);
	
		// Upload Media : Video
		wd.findElement(By.linkText("ACTIVITY")).click();
		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream: Videos");
				wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
				Thread.sleep(3000);
				Runtime.getRuntime().exec(Constants.Video);

				Thread.sleep(5000);

				wd.findElement(By.id("aw-whats-new-submit")).click();
		
				Thread.sleep(5000);

				// Upload Media : Music
				wd.findElement(By.linkText("ACTIVITY")).click();
				wd.findElement(By.id("whats-new")).click();
				wd.findElement(By.id("whats-new")).clear();
				wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream: Music");
						wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
						Thread.sleep(3000);
						Runtime.getRuntime().exec(Constants.Music);

						Thread.sleep(5000);

						wd.findElement(By.id("aw-whats-new-submit")).click();
				
						Thread.sleep(5000);
					//Upload Media : Documents
						wd.findElement(By.linkText("ACTIVITY")).click();
						wd.findElement(By.id("whats-new")).click();
						wd.findElement(By.id("whats-new")).clear();
						wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream: Documents");
								wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
								Thread.sleep(3000);
								Runtime.getRuntime().exec(Constants.Documents);

								Thread.sleep(5000);

								wd.findElement(By.id("aw-whats-new-submit")).click();
						
								Thread.sleep(5000);

*/	/*					
		// CHECK FOR GROUPS

		 //  Mouseover on Profile (Howdy, admin) section
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		Thread.sleep(1000);
				   
		// Click on Groups
			
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-groups > a.ab-item"))).build().perform();
		wd.findElement(By.cssSelector("#wp-admin-bar-my-account-groups > a.ab-item")).click();
		Thread.sleep(1000);*/
		
		/*// Create a group named test, if not already done
					
		// click on a group named "test"

		wd.findElement(By.linkText("test")).click();
		  // Click on ACTIVITY inside test group
		
		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("check number of media items in a single Activity for a  Group named test");

		//Check for Activity Attach Files Negative Case . Should not work
		boolean flag2=false;
		if(wd.findElements(By.cssSelector("div.rtmedia-add-media-button")).size() == 0){
			System.out.println("Allow Upload From Activity: Groups is disabled");
			Reporter.log("Allow Upload From Activity : Groups is correctly disabled");
			flag2=true;
		} else {
			System.out.println("Allow Upload From Activity: Groups is still  enabled");
			Reporter.log("Allow Upload From Activity : Groups is still  enabled");
			flag2=false;
		}
		Assert.assertEquals(flag2, true,"Allow Upload From Activity is still  enabled");
		*/
		// Upload multiple Media

	/*	wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(Constants.Photo);
		Runtime.getRuntime().exec("C:\\Users\\sumeet\\Documents\\video_x64.exe");
		Thread.sleep(10000);

		wd.findElement(By.id("aw-whats-new-submit")).click();
		Thread.sleep(10000);*/
				

		// log out
		Constants.logout(wd);
	}

	
}
