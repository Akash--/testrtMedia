/*@ Author Sumeet*/
package testscripts.buddyPress;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testscripts.Constants;

//check for Admin
public class enablePodcastingNGTest {
	@Test(groups = { "buddypressnegative" })
//PRO only feature . rtMedia Pro must be activated
	public static void enablePodcasting() throws Exception {
	
	/*FirefoxDriver wd;
	wd = new FirefoxDriver();*/
	/*wd.manage().window().maximize();*/

	/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/

	// Phantom js : headless
	// Code to take screenshots
	Capabilities caps = new DesiredCapabilities();
	((DesiredCapabilities) caps).setJavascriptEnabled(true);
	((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
	
	PhantomJSDriver wd = new PhantomJSDriver(caps);
	wd.manage().window().setSize(new Dimension(1920, 1080));
	wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	// Login to WordPress by admin account
	wd.get(Constants.WP_SERVER);
	Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
	 System.out.println("Correctly Logged In");

	
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 01.png');");			
	// Open rtMedia Settings 
	Constants.openrtMediaSettings(wd);
			
	Thread.sleep(1000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 02.png');");
	// Click on rtMedia settings BuddyPress Tab
	wd.findElement(By.id("tab-rtmedia-bp")).click();
	System.out.println("BuddyPress Tab Opened");
	
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 03.png');");
	// Check if the switch is on or off, IF ON  then SWITCH  OFF
	List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-podcasting\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
     //System.out.println("Size"+switchElement.size());
	if (switchElement.size() != 0) {

		switchElement.get(0).findElement(By.cssSelector("span.switch-left")).click();
		
		System.out.println("Enable Podcasting is switched off");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 04.png');");
	} 
	else
	{
		System.out.println("Enable Podcasting is already off");
	
//((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 05.png');");		
	}
 //limit no of media items in feed 
	
	wd.findElement(By.id("rt-form-number-3")).click();
	wd.findElement(By.id("rt-form-number-3")).clear();
	wd.findElement(By.id("rt-form-number-3")).sendKeys("20");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 06.png');");    
	
	// save the BuddyPress settings Form
	wd.findElement(By.id("rtmedia-settings-submit")).click();
	System.out.println("Settings saved");
	Thread.sleep(2000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 07.png');");	
	// Do a mouse over on the primary menu on top LHS
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
	
	// Click on Visit Site

	wd.findElement(By.linkText("Visit Site")).click();
	// Click on Profile (Howdy, admin) section

	wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

	//click on Media
	wd.findElement(By.id("user-media")).click();
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 08.png');");
	//click on Options
	
	 wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
	 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 09.png');");  
	Thread.sleep(1000);
	
	
	//click on RSS under Media Gallery ( All)
	
	// Negative Case RSS SHOULD NOT BE AVAILABLE AS SETTING IS DISABLED
	boolean flag=false;
	if(wd.findElements(By.id("rtmedia-nav-item-rss")).size() == 0){
		System.out.println("Podcasting/ RSS Setting  is correctly disabled");
		Reporter.log("Podcasting/ RSS Setting is correctly disabled");
		flag=true;
	} else {
		System.out.println("Podcasting/ RSS Setting is still  enabled");
		Reporter.log("Podcasting/ RSS Setting is still  enabled");
		flag=false;
	}
			Assert.assertEquals(flag, true,"Podcasting/ RSS Setting is still  enabled");
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnablePodcasting/Negative/Enable Podcasting NG 10.png');");

/*	wd.findElement(By.id("rtmedia-nav-item-rss")).click();  // check in Live BookMarks 
*/	//Thread.sleep(5000);
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
	
	// log out
	       Constants.logout(wd);
}}
