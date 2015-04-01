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

public class organizeMediaIntoAlbumsTest {
	@Test(groups = {"buddypress"})
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
		 System.out.println("Correctly Logged In");
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Functional/Organise Media Into Albums01.png');");		
	
/*
		wd.get(Constants.WP_SERVER); 		
		  Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);*/
	

		// Open rtMedia Settings 
		
		Constants.openrtMediaSettings(wd);
			
		// Click on rtMedia settings BuddyPress Tab
		wd.findElement(By.id("tab-rtmedia-bp")).click();
		System.out.println("BuddyPress Tab Opened");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Functional/Organise Media Into Albums02.png');");		
	
		// Check if the switch is on or off, if its off then switch on and  proceed
	List<WebElement> switchElement = wd.findElements(By
	.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-album-enable\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

			if (switchElement.size() != 0) {

			switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
			System.out.println("'Organise Media into Albums' is switched  on");
				} else
					System.out.println("'Organise Media into Albums' is already on");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Organise Media Into Albums03.png');");
	
	// Change the No of media items per activity setting back to a greater  number
	
	wd.findElement(By.id("rt-form-number-1")).click();
	wd.findElement(By.id("rt-form-number-1")).clear();
wd.findElement(By.id("rt-form-number-1")).sendKeys("15");  
			
	
		// save the BuddyPress settings Form

		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings Saved");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Functional/Organise Media Into Albums04.png');");		
		//Thread.sleep(2000);
	
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();

		// Click on Profile (Howdy, admin) section

		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		// click on Media
		wd.findElement(By.id("user-media")).click();

		// click on Albums. You will find Albums List
		wd.findElement(By.id("rtmedia-nav-item-albums")).click();
		Thread.sleep(1500);
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Functional/Organise Media Into Albums05.png');");		
		//click on Options
		
		wd.findElement(By.id("rtm-media-options-list")).click();
		
		System.out.println("Options Opened");
		//Thread.sleep(3000);
		
		//click on Add Album to check Allow users to create new albums
		
		wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
        wd.findElement(By.linkText("Add Album")).click();
        wd.findElement(By.id("rtmedia_album_name")).click();
        wd.findElement(By.id("rtmedia_album_name")).clear();
        wd.findElement(By.id("rtmedia_album_name")).sendKeys("Fresh album added by user");
        wd.findElement(By.id("rtmedia_create_new_album")).click();
	     //Thread.sleep(1000);
	     wd.navigate().refresh();
	     Thread.sleep(2000);
	     System.out.println("Album successfully added");
		
	     ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Functional/Organise Media Into Albums06.png');");
		
	     // check for Albums in BuddyPress Groups
		
		// Click on Profile (Howdy, admin) section

		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();
		
		
		
		
	/*	//FOR INSPIREBOOK STARTS 
		 wd.findElement(By.linkText("More")).click();
	    
       // FOR INSPIREBOOK ENDS
	        */
		
		// Click on Groups

		wd.findElement(By.id("user-groups")).click();

		
		// click on a group named "test"

		wd.findElement(By.linkText("test")).click();
	
		

		// click on Media inside test group

		wd.findElement(By.id("rtmedia-media-nav")).click();

		// click on Albums

		wd.findElement(By.id("rtmedia-nav-item-albums")).click();
		Thread.sleep(3000);

		wd.navigate().refresh();
		
		//click on Options
		
		wd.findElement(By.id("rtm-media-options-list")).click();
		
		//click on Add Album
		
		wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
        wd.findElement(By.linkText("Add Album")).click();
        wd.findElement(By.id("rtmedia_album_name")).click();
        wd.findElement(By.id("rtmedia_album_name")).clear();
        wd.findElement(By.id("rtmedia_album_name")).sendKeys("New album added by user in a group named test");
        wd.findElement(By.id("rtmedia_create_new_album")).click();
		
        Thread.sleep(2000);
        wd.navigate().refresh();
        ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/organizeMediaInAlbums/Functional/Organise Media Into Albums05.png');");		

	     if (!(wd.findElements(By.cssSelector("img[alt=\"New album added by user in a group named test\"]")).size() != 0)) {
	            System.out.println("verifyElementPresent failed"); 
	     }
	    
	     else {
	    	 System.out.println("verifyElementPresent Pass");
	     }
		// Logout
	     Constants.logout(wd);
		
	}

}
