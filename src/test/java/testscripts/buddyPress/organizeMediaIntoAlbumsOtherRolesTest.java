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
import org.testng.annotations.Test;

import testscripts.Constants;

public class organizeMediaIntoAlbumsOtherRolesTest {
	@Test(groups = {"buddypress"})
	public static void  organizeMediaIntoAlbumsOther() throws Exception{
		
	// Phantom js : headless
		// Code to take screenshots
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wdAdmin = new PhantomJSDriver(caps);
		wdAdmin.manage().window().setSize(new Dimension(1920, 1080));
		//wdAdmin.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		// Login to wordpress by admin account
		wdAdmin.get(Constants.WP_SERVER);
		Constants.login(wdAdmin, Constants.USERNAME1, Constants.UPASSWORD1);
		 
		System.out.println("Correctly Logged In With Admin Account to switch on the setting if off");		
/*((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Organise Media Into Albums01.png');");*/		


		// Open rtMedia Settings 
		
		Constants.openrtMediaSettings(wdAdmin);
			
		// Click on rtMedia settings BuddyPress Tab
		wdAdmin.findElement(By.id("tab-rtmedia-bp")).click();
		System.out.println("BuddyPress Tab Opened");
		/*((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Organise Media Into Albums02.png');");*/		
	
		//If  Organise Media into Albums is disabled, enable it
		// Check if the switch is on or off, if its off then switch on and  proceed
	List<WebElement> switchElement = wdAdmin.findElements(By
	.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-album-enable\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

			if (switchElement.size() != 0) {

			switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
			System.out.println("'Organise Media into Albums' is switched  on");
				} else
					System.out.println("'Organise Media into Albums' is already on");
	/*((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Organise Media Into Albums03.png');");*/	  			
		// save the BuddyPress settings Form

	wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings Saved");
		
		
		// Logout from Admin Account
		new Actions(wdAdmin).moveToElement(wdAdmin.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		wdAdmin.findElement(By.linkText("Log Out")).click();
		System.out.println("Logout from Admin Account");
		wdAdmin.quit();	
		
		// Phantom js : headless
		// Code to take screenshots
		Capabilities caps2 = new DesiredCapabilities();
		((DesiredCapabilities) caps2).setJavascriptEnabled(true);
		((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps2);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
		// Login with TestEditor
		
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
		 System.out.println("Correctly Logged In");
			
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaIntoAlbumsOtherRoles/Functional/Organise Media Into Albums Other01.png');");
		
					// Click on Profile (Howdy, admin) section 

					wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();
					
					//Reach Albums
					wd.findElement(By.id("user-media")).click();

					//click on Albums. You will find Albums List  
					wd.findElement(By.id("rtmedia-nav-item-albums")).click();
					Thread.sleep(2000);
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaIntoAlbumsOtherRoles/Functional/Organise Media Into Albums Other02.png');");					
					// check for Albums in BuddyPress Groups
					
					// Click on Profile (Howdy, admin) section

					wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

					// Click on Groups

					wd.findElement(By.id("user-groups")).click();

					// click on a group named "test"

					wd.findElement(By.linkText("test")).click();

					// Reach Albums

					wd.findElement(By.id("rtmedia-media-nav")).click();
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaIntoAlbumsOtherRoles/Functional/Organise Media Into Albums Other03.png');");					
					//click on Albums  
					
					wd.findElement(By.id("rtmedia-nav-item-albums")).click();
					System.out.println("clicked on the albums");
					Thread.sleep(2000);
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaIntoAlbumsOtherRoles/Functional/Organise Media Into Albums Other04.png');");					
					
					// Logout
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					wd.findElement(By.linkText("Log Out")).click();
					wd.quit();
	}
}
