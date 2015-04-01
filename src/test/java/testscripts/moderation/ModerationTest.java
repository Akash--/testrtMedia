package testscripts.moderation;

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

public class ModerationTest {
@Test

public static void Moderation() throws Exception {
	Capabilities caps = new DesiredCapabilities();
	((DesiredCapabilities) caps).setJavascriptEnabled(true);
	((DesiredCapabilities) caps).setCapability("takesScreenshot",true);
	
	PhantomJSDriver wd = new PhantomJSDriver(caps);
	wd.manage().window().setSize(new Dimension (1920, 1080));
	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	// Login to wordpress by admin account
	wd.get(Constants.WP_SERVER);
	Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
	 System.out.println("Correctly Logged In");
	 
((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Moderation/Functional/Moderation1.png'); ");			
		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
		Thread.sleep(5000);
		
		// Click on rtMedia settings Moderation tab
		
		wd.findElement(By.id("tab-rtmedia-moderation")).click();

		// Enable Moderation
		List<WebElement> switchElement = wd.findElements(By
				.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-34\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

	if(switchElement.size()==1) {
		switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
		System.out.println("Moderation is enabled");
		
	} else {
		System.out.println("Moderation is already enabled");
	}
	((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Moderation/Functional/Moderation2.png'); ");	
	// Set Remove Content after how many reports
	
	 wd.findElement(By.id("rt-form-number-10")).click();
     wd.findElement(By.id("rt-form-number-10")).clear();
     wd.findElement(By.id("rt-form-number-10")).sendKeys("1");
     
     wd.findElement(By.name("rtmedia-options[moderation_adminEmails]")).click();
     wd.findElement(By.name("rtmedia-options[moderation_adminEmails]")).clear();
     wd.findElement(By.name("rtmedia-options[moderation_adminEmails]")).sendKeys("sumeet.sarna@rtcamp.com");
     
		wd.findElement(By.id("rtmedia-settings-submit")).click();

     ((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Moderation/Functional/Moderation3.png'); ");	
     // Upload a Media and Report that Media
     
    	// Check with Lightbox OFF
      		// Open rtMedia Settings 
     		Constants.openrtMediaSettings(wd);
     				
     		// Click on rtMedia Display

    	wd.findElement(By.id("tab-rtmedia-display")).click();

    		System.out.println("Display Tab Clicked ");
    
     		// If Use Light Box to display media is ON then switch it OFF
     				
     	List<WebElement> switchElement1 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-6\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

     		if (switchElement1.size() != 0) {

     			switchElement1.get(0).findElement(By.cssSelector("span.switch-left")).click();
     			
     			System.out.println("Lightbox is switched off");

     		} else
     			System.out.println("Lightbox is already off");
     Thread.sleep(2000);
   ((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Moderation/Functional/Moderation4.png'); ");   
     		// Save settings
     		wd.findElement(By.id("rtmedia-settings-submit")).click();
     		System.out.println("Settings saved . Lightbox switched Off");
     		Thread.sleep(2000);
     		// Enable Upload from Activity if disabled
     		
    		// Click on rtMedia settings BuddyPress Tab

    		wd.findElement(By.id("tab-rtmedia-bp")).click();

    		System.out.println("BuddyPress Tab Opened");
   ((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Moderation/Functional/Moderation5.png'); ");
    		
    		// Check if the switch is on or off, if its off then switch on and  proceed
    		
    		List<WebElement> switchElement2 = wd.findElements(By
    .cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-activity\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

    	if (switchElement2.size() != 0) {

    	switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
    	System.out.println("'Allow Upload From Activity Stream' is switched  on");
    		} 
    	else
    		System.out.println("'Allow Upload From Activity Stream' is already on");
		
 		// Save settings
 		wd.findElement(By.id("rtmedia-settings-submit")).click();
 		System.out.println("Settings saved . Lightbox switched Off");
 		Thread.sleep(2000);

     		// Upload a Media and report that media
     		
     		// Do a mouse over on the primary menu on top LHS
     	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
     		// Click on Visit Site
     		wd.findElement(By.linkText("Visit Site")).click(); 
     		// Click on ACTIVITY
    		
    		wd.navigate().to(Constants.WP_SERVER + "/activity");
   
    		wd.findElement(By.id("whats-new")).click();
    		
    		Thread.sleep(2000);
    		System.out.println(" Clicked Activity");
    			
    		
    		// Upload Media : Image named test
    		
    		// Click Attach Files
    		
    		
    		wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
    		
    		Thread.sleep(3000);
    		System.out.println("Attach Files Clicked");
    				
    		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
    				+ "var count=0;" + "page.uploadFile('input[type=file]','"
    				+ Constants.PhotoPhantom + "');"					 
    				+"page.render('./screen/Moderation/Functional/Moderation 01.png');");
    		Thread.sleep(4000); // Increase sleep for Music and Video uploads
    		
    		// Enter some content

    		wd.findElement(By.id("whats-new")).click();
    		wd.findElement(By.id("whats-new")).clear();
    		wd.findElement(By.id("whats-new")).sendKeys("Moderation check");				
    		System.out.println("Media uploaded");
    		
    		   Thread.sleep(4000);
      ((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Moderation/Functional/Moderation6.png'); ");    		
    		// Click  Post Update
    		
    		
    		wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
    		System.out.println("Post Update button clicked");
     		// Open the Media and Click Report
    		
    		 /*new Actions(wd).doubleClick(wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img"))).build().perform();
    		 new Actions(wd).doubleClick(wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img"))).click();*/
    		
    		wd.findElement(By.linkText("test")).click();
    		Thread.sleep(3000);
    		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Moderation/Functional/Moderation02.png');");     		

    		 //Report
   //findElement(By.cssSelector("button.rtmedia-moderate")).click();	 
   ((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Moderation/Functional/Moderation7.png'); ");   		 
    		// Check Managed Media Page in backend
     		
   wd.navigate().to(Constants.WP_SERVER + "/wp-admin/admin.php?page=rtmedia-moderate");
   ((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Moderation/Functional/Moderation8.png'); ");   		
    	Thread.sleep(4000);
    // Screenshot of Reported Media
    	
   ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Moderation/Functional/Moderation9.png');"); 	
    	Thread.sleep(4000);
     
    	
    	// Disable Moderation after test case done	
    	
    	// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
		Thread.sleep(5000);
		
		// Click on rtMedia settings Moderation tab
		
		wd.findElement(By.id("tab-rtmedia-moderation")).click();


     List<WebElement> switchElement3 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-34\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

 	if (switchElement3.size() != 0) {

 		switchElement3.get(0).findElement(By.cssSelector("span.switch-left")).click();
 		
 		System.out.println("Moderation Disabled");

 	} else
 		System.out.println("Moderation already disabled");
		//Log out
			Constants.logout(wd);
}
}
