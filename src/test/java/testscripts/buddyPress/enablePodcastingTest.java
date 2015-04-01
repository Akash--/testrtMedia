/*@ Author Sumeet*/
package testscripts.buddyPress;

//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyEvent;
import java.awt.Robot;
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

//import com.thoughtworks.selenium.webdriven.commands.KeyEvent;




import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import testscripts.Constants;

//check for Admin
public class enablePodcastingTest {
	@Test(groups = {"buddypress"})
//PRO only feature . rtMedia Pro must be activated
public static void enablePodcastingAdmin() throws Exception {
	
	// Phantom js : headless
	// Code to take screenshots
	Capabilities caps = new DesiredCapabilities();
	((DesiredCapabilities) caps).setJavascriptEnabled(true);
	((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
	
	PhantomJSDriver wd = new PhantomJSDriver(caps);
	wd.manage().window().setSize(new Dimension(1920, 1080));
	//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	// Login to wordpress by admin account
	wd.get(Constants.WP_SERVER);
	Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
	 System.out.println("Correctly Logged In");
			
	// Open rtMedia Settings 
	Constants.openrtMediaSettings(wd);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 01.png');");			
	//Thread.sleep(5000);

	// Click on rtMedia settings BuddyPress Tab
	wd.findElement(By.id("tab-rtmedia-bp")).click();
	System.out.println("BuddyPress Tab Opened");
	
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 02.png');");

	//Check if the switch is on or off, if its off then switch on and  proceed
	
	List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-podcasting\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement.size() != 0) {

				switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
						System.out.println("'Enable Podcasting ' is switched  on");
							} else
								System.out.println("'Enable Podcasting' is already on");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 03.png');");
	/*boolean checkBox1 = wd.findElement(By.id("rtmedia-bp-enable-podcasting")).isSelected();
	if (checkBox1 == false)
		wd.findElement(By.id("rtmedia-bp-enable-podcasting")).click();
	else
		System.out.println("The Switch is already ON");*/  

	//limit no of media items in feed 
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 04.png');");
	wd.findElement(By.id("rt-form-number-3")).click();
	wd.findElement(By.id("rt-form-number-3")).clear();
	wd.findElement(By.id("rt-form-number-3")).sendKeys("30");
    
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 05.png');");	
	// save the BuddyPress settings Form
	wd.findElement(By.id("rtmedia-settings-submit")).click();
	
	System.out.println("Settings saved");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 06.png');");	
	Thread.sleep(2000);
	// Do a mouse over on the primary menu on top LHS
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
	
	// Click on Visit Site

	wd.findElement(By.linkText("Visit Site")).click();
	// Click on Profile (Howdy, admin) section

	wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

	//click on Media
	wd.findElement(By.id("user-media")).click();

	//click on Options
	
	 wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
	 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 05.png');");     
	
	Thread.sleep(1000);
	
	//click on RSS under Media Gallery ( All)
	
	wd.findElement(By.id("rtmedia-nav-item-rss")).click(); 
	System.out.println("Clicked on rss");
	// check in Live BookMarks
	Thread.sleep(2000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 06.png');");
	Thread.sleep(2000);
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
	
	
            

	/*Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_W);
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_W);
*/
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Enable Podcasting 07.png');");
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			System.out.println("log out");
			wd.findElement(By.linkText("Log Out")).click();
			wd.quit();
}}
