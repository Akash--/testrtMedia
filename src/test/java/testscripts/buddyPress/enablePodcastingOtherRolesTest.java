/*@ Author Sumeet*/
package testscripts.buddyPress;

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

//check for non admin roles
public class enablePodcastingOtherRolesTest {
	@Test(groups = {"buddypress"})
//PRO only feature . rtMedia Pro must be activated
	public static void enablePodcastingOther() throws Exception {
	
	// Admin login first.  Admin login done to switch on the setting if disabled		
	
			Capabilities caps = new DesiredCapabilities();
			((DesiredCapabilities) caps).setJavascriptEnabled(true);
			((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
			
			PhantomJSDriver wdAdmin = new PhantomJSDriver(caps);
			wdAdmin.manage().window().setSize(new Dimension(1920, 1080));
			wdAdmin.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// Login to wordpress by admin account
			wdAdmin.get(Constants.WP_SERVER);
			Constants.login(wdAdmin, Constants.USERNAME1, Constants.UPASSWORD1);
			 
	System.out.println("Correctly Logged In With Admin Account to switch on the setting if off");	
				
/*	FirefoxDriver wd;
	wd = new FirefoxDriver();*/
	/*wd.manage().window().maximize();*/

	/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/

	// Open rtMedia Settings 
	Constants.openrtMediaSettings(wdAdmin);
((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcastingOtherRoles/Functional/Enable Podcasting 01.png');");			
//	Thread.sleep(5000);

	// Click on rtMedia settings BuddyPress Tab
	wdAdmin.findElement(By.id("tab-rtmedia-bp")).click();
	System.out.println("BuddyPress Tab Opened");
	
/*	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 02.png');");*/

	//Check if the switch is on or off, if its off then switch on and  proceed
	
	List<WebElement> switchElement = wdAdmin.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-podcasting\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement.size() != 0) {

				switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
						System.out.println("'Enable Podcasting ' is switched  on");
						wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
						System.out.println("Setting Saved");
							} else
								System.out.println("'Enable Podcasting' is already on");
		((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcastingOtherRoles/Functional/Enable Podcasting 03.png');");	
	
	
		// log out of Admin Account
		Constants.logout(wdAdmin);
	
		// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
				// Phantom js : headless
				// Code to take screenshots
				Capabilities caps2 = new DesiredCapabilities();
				((DesiredCapabilities) caps2).setJavascriptEnabled(true);
				((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);
				
				PhantomJSDriver wd = new PhantomJSDriver(caps);
				wd.manage().window().setSize(new Dimension(1920, 1080));
				//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     	//wd.get(Constants.WP_SERVER);  
	
	    	// Login to wordpress by admin account
			wd.get(Constants.WP_SERVER);
			Constants.login(wd, Constants.TestContributor, Constants.TestContributorPassword);
			 System.out.println("Correctly Logged In");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcastingOtherRoles/Functional/Enable Podcasting Other 03.png');");	
	
	// Click on Profile (Howdy, {username} ) section on RHS

	wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

	//click on Media
	wd.findElement(By.id("user-media")).click();
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcastingOtherRoles/Functional/Enable Podcasting Other 04.png');");
	//click on Options
	
	 wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
     
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcastingOtherRoles/Functional/Enable Podcasting Other 05.png');");
	Thread.sleep(1000);
	
	//click on RSS under Media Gallery ( All)
	
	wd.findElement(By.id("rtmedia-nav-item-rss")).click();  // check in Live BookMarks
	
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcastingOtherRoles/Functional/Enable Podcasting Other 06.png');");	
	Thread.sleep(2000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcastingOtherRoles/Functional/Enable Podcasting Other 07.png');");
	/*  // check for Albums   
	 *  wd.findElement(By.id("rtmedia-nav-item-albums")).click();
        wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
        // check for Photos
        wd.findElement(By.id("rtmedia-nav-item-photo")).click();
        wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
        //  check for Videos
        wd.findElement(By.id("rtmedia-nav-item-video")).click();
        wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
        
        // check for Music  // check in Live BookMarks  or feedly.com account ( add via feedly's search area) 
        wd.findElement(By.id("rtmedia-nav-item-music")).click();
        wd.findElement(By.id("rtm-media-options")).click();
        wd.findElement(By.cssSelector("span.mfp-close")).click();
        
        
        // check  RSS for Documents
        wd.findElement(By.id("rtmedia-nav-item-document")).click();
        wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
        wd.findElement(By.id("rtmedia-nav-item-rss")).click(); */
	
	 //Logout 
	// get back to the parent window
	Constants.logout(wd);
}}
