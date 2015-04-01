/*@ Author Sumeet*/
package testscripts.buddyPress;

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

public class organizeMediaIntoAlbumsNGTest {
	@Test(groups = { "buddypressnegative" })
	
	public static void organizeMediaInAlbums() throws Exception {
		// CHECK FOR PROFILES
		
		// Phantom js : headless
		// Code to take screenshots
				Capabilities caps = new DesiredCapabilities();
				((DesiredCapabilities) caps).setJavascriptEnabled(true);
				((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
				
				PhantomJSDriver wd = new PhantomJSDriver(caps);
				wd.manage().window().setSize(new Dimension(1920, 1080));
				//wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
				
				// Login to wordpress by admin account
				wd.get(Constants.WP_SERVER);
				Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
				 System.out.println("Correctly Logged In");((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Negative/Organise Media Into Albums Negative 01.png');");				
		// Open rtMedia Settings 
		
		Constants.openrtMediaSettings(wd);
			

		// Click on rtMedia settings BuddyPress Tab
		wd.findElement(By.id("tab-rtmedia-bp")).click();
		System.out.println("BuddyPress Tab Opened");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Negative/Organise Media Into Albums Negative 02.png');");		
		
		// Check if the switch is on or off, IF ON  then SWITCH  OFF
	List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-album-enable\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

				if (switchElement.size() != 0) {

					switchElement.get(0).findElement(By.cssSelector("span.switch-left")).click();
					
					System.out.println("Organise media into Albums is  disabled");
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Negative/Organise Media Into Albums Negative 03.png');");
				} else
					System.out.println("Organise media into Albums is already disabled");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Negative/Organise Media Into Albums Negative 04.png');");		
		// save the BuddyPress settings Form
		
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("BuddyPress Settings Saved");
		//Thread.sleep(2000);
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();

		// Click on Profile (Howdy, admin) section 


		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		// click on Media
		wd.findElement(By.id("user-media")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Negative/Organise Media Into Albums Negative 05.png');");
		// Albums should not be there . Negative Case 
		
		boolean flag=false;
		
		if(wd.findElements(By.id("rtmedia-nav-item-albums")).size() == 0){
			System.out.println("Organise media into Albums  is correctly disabled");
			Reporter.log("Organise media into Albums is correctly disabled");
			flag=true;
		} else {
			System.out.println("Organise media into Albums is still  enabled");
			Reporter.log("Organise media into Albums is still  enabled");
			flag=false;
		}
		Assert.assertEquals(flag, true,"Organise media into Albums is still  enabled");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Negative/Organise Media Into Albums Negative 06.png');");		
	/*	// click on Albums. You will find Albums List
		wd.findElement(By.id("rtmedia-nav-item-albums")).click();
		Thread.sleep(3000);

		// check for Albums in BuddyPress Groups
		// Click on Profile (Howdy, admin) section

		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();
		//FOR INSPIREBOOK STARTS 
		 wd.findElement(By.linkText("More")).click();
	    
       // FOR INSPIREBOOK ENDS
	        */
	/*	// Click on Groups

		wd.findElement(By.id("user-groups")).click();

		
		// click on a group named "test"

		wd.findElement(By.linkText("test")).click();

		// click on Media inside test group

		wd.findElement(By.id("rtmedia-media-nav")).click();

		// click on Albums

		wd.findElement(By.id("rtmedia-nav-item-albums")).click();
		Thread.sleep(3000);

		wd.navigate().refresh();*/

		// Logout
		Constants.logout(wd);
		//
	}

}
