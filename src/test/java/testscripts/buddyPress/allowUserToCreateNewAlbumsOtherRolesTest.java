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



//checking for non admin roles
import testscripts.Constants;

public class allowUserToCreateNewAlbumsOtherRolesTest {
	@Test(groups = {"buddypress"})
	// PRO only feature . rtMedia Pro must be activated
	//  checking for other roles 
	public static void allowUserCreateNewAlbumsOther() throws Exception {

		// // Admin login first.  Admin login done to switch on the setting if disabled	
		// Phantom js : headless
		// Code to take screenshots
		
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wdAdmin = new PhantomJSDriver(caps);
		wdAdmin.manage().window().setSize(new Dimension(1920, 1080));
		wdAdmin.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		// Login to wordpress by admin account
				wdAdmin.get(Constants.WP_SERVER);
				Constants.login(wdAdmin, Constants.USERNAME1, Constants.UPASSWORD1);
				 System.out.println("Correctly Logged In");


		((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles01.png');");	
			
		/*// Login to WordPress 
		wd.get(Constants.WP_SERVER); 	
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);*/
				
		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wdAdmin);
		((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles02.png');");		
		
		//Thread.sleep(5000);
		// Click on rtMedia settings BuddyPress Tab
		wdAdmin.findElement(By.id("tab-rtmedia-bp")).click();
		System.out.println("BuddyPress Tab Opened");
		((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles03.png');");		
		// Enable Organize Media into Albums, it will enable Allow users to create albums
		
		List<WebElement> switchElement1 = wdAdmin.findElements(By
				.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-album-enable\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		
			if (switchElement1.size() != 0) {

			switchElement1.get(0).findElement(By.cssSelector("span.switch-right")).click();
			System.out.println("'Organise Media into Albums' is switched  on");
				} else
					System.out.println("'Organise Media into Albums' is already on");
			((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles04.png');");			
		// Re- enable  Allow users to create albums 
	List<WebElement> switchElement2 = wdAdmin.findElements(By
	.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-17\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRolesAdmin5.png');");
	if (switchElement2.size() != 0) {

	switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
	System.out.println("'Allow User To Create New Albums' is switched  on");
		} else
			System.out.println("'Allow User To Create New Albums' is already on");
	
	((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles05.png');");		
			
	// Save the BuddyPress settings Form
		
	wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
					System.out.println("rtMedia Settings Saved");
					Thread.sleep(2000);
	((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles06.png');");					
					
	// Admin log out
					new Actions(wdAdmin).moveToElement(wdAdmin.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					wdAdmin.findElement(By.linkText("Log Out")).click();
					wdAdmin.quit();
	// Login as a TestSubscriber				
					// Phantom js : headless
										
					Capabilities caps2 = new DesiredCapabilities();
					((DesiredCapabilities) caps2).setJavascriptEnabled(true);
					((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);
					
					PhantomJSDriver wd = new PhantomJSDriver(caps);
					wd.manage().window().setSize(new Dimension(1920, 1080));
					wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
					
	// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
					
		wd.get(Constants.WP_SERVER);
	    wd.findElement(By.linkText("Log in")).click();
					wd.findElement(By.id("user_login")).click();
					wd.findElement(By.id("user_login")).clear();
					wd.findElement(By.id("user_login")).sendKeys(Constants.TestSubscriber);
					wd.findElement(By.id("user_pass")).click();
					wd.findElement(By.id("user_pass")).clear();
					wd.findElement(By.id("user_pass")).sendKeys(Constants.TestSubscriberPassword);
					wd.findElement(By.id("wp-submit")).click();
					Thread.sleep(1000);

					
			System.out.println("Correctly Logged In");	

			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles07.png');");		
				
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

		// Click on Profile (Howdy, admin) section to check Media is present in BuddyPress profile or not

		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles08.png');");
		// click on Media
		wd.findElement(By.id("user-media")).click();
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles09.png');");
		// click on Albums. You will find Albums List
		wd.findElement(By.id("rtmedia-nav-item-albums")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles10.png');");	
		//Thread.sleep(3000);
		
		// click on Options

		wd.findElement(By.id("rtm-media-options-list")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles11.png');");
		// click on Add Album

		wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
		wd.findElement(By.linkText("Add Album")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles12.png');");		
		wd.findElement(By.id("rtmedia_album_name")).click();
		wd.findElement(By.id("rtmedia_album_name")).clear();
		wd.findElement(By.id("rtmedia_album_name")).sendKeys("New album added by user");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles13.png');");	
		Thread.sleep(3000);
		wd.findElement(By.id("rtmedia_create_new_album")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles14.png');");	
		
		Thread.sleep(2000);
		wd.navigate().refresh();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow other user to create new album/Functional/AllowUserToCreateAlbumsOtherRoles15.png');");	
		
		// Verify Album name : New album added by user
		
		 if (!(wd.findElements(By.cssSelector("img[alt=\"New album added by user\"]")).size() != 0)) {
	            System.out.println("verifyAlbumPresent failed"); 
	     }
	    
	     else {
	    	 System.out.println("verifyAlbumPresent Pass");
	     }
		
		/*
		// check for Albums in BuddyPress Groups
		// Click on Profile (Howdy, admin) section

		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		// Click on Groups

		wd.findElement(By.id("user-groups")).click();

		// Make a group named test. If already there, click on a group named
		// "test"

		wd.findElement(By.linkText("test")).click();

		// click on Media inside test group

		wd.findElement(By.id("rtmedia-media-nav")).click();

		// click on Albums

		wd.findElement(By.id("rtmedia-nav-item-albums")).click();
		Thread.sleep(6000);

		wd.navigate().refresh();

		// click on Options

		wd.findElement(By.id("rtm-media-options-list")).click();

		// click on Add Album

		wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
		wd.findElement(By.linkText("Add Album")).click();
		wd.findElement(By.id("rtmedia_album_name")).click();
		wd.findElement(By.id("rtmedia_album_name")).clear();
		wd.findElement(By.id("rtmedia_album_name")).sendKeys("New album added by  user in a group named test");
		wd.findElement(By.id("rtmedia_create_new_album")).click();
		Thread.sleep(6000);
*/	
		// Logout
		Constants.logout(wd);

	}

}
