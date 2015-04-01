/*@ Author Sumeet*/
package testscripts.buddyPress;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;
// Run after Same Admin test case
public class numberOfMediaItemsInActivitySreamOtherRolesTest {
	// 3.7.1.4
	@Test(groups = {"buddypress"})
	public static void numberOfMediaItemsInActivityOtherRoles()	throws Exception {
	
		// Phantom js : headless
		// Code to take screenshots
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
 
		// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.TestContributor, Constants.TestContributorPassword);
		 System.out.println("Correctly Logged In");
		// REACH  ACTIVITY
	
		wd.navigate().to(Constants.WP_SERVER + "/activity");
		
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/NumberofMediaitemsInActivityStreamOtherRoles/Functional/NoOfMediaActivityOther 05 .png');");				
		
		
		wd.findElement(By.id("whats-new")).click();
		
		Thread.sleep(2000);
		System.out.println("Clicked Activity");
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/NumberofMediaitemsInActivityStreamOtherRoles/Functional/NoOfMediaActivityOther 06 .png');");					
		
		// Upload Media
		
		// Click Attach Files
		
		/*wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();*/
		wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
		
		Thread.sleep(3000);
		System.out.println("Attach Files Clicked");
				
/*((PhantomJSDriver) wd).executePhantomJS("var page=this; "
+ "var count=0;" + "page.uploadFile('input[type=file]','"
+ Constants.DocumentPhantom + "');"	+ "page.uploadFile('input[type=file]','"
+ Constants.PhotoPhantom + "');"				 
+"page.render('./screen/BuddyPress/Functional/Number of Media Activity Stream.png');");*/
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
		        + "var count=0;" + "page.uploadFile('input[type=file]',['"
		        + Constants.DocumentPhantom +"','"+Constants.Document+"']);");		
		Thread.sleep(10000); // Increase sleep for Music and Video uploads
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/NumberofMediaitemsInActivityStreamOtherRoles/Functional/NumberofMediaitemsInActivityStreamOtherRoles/Functional/NoOfMediaActivityOther 07.png');");		
		// Enter some content

		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("2 Media Uploaded. Media display should be 1");				
		System.out.println("Media visible in activity < = No of Media items value set. ");	
		Thread.sleep(5000);
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/NumberofMediaitemsInActivityStreamOtherRoles/Functional/NoOfMediaActivityOther 08.png');");		
		// Click  Post Update
		
		wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
		System.out.println("Post Update button clicked");	
		Thread.sleep(6000);
		System.out.println(" Media Uploaded");
		Thread.sleep(10000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/NumberofMediaitemsInActivityStreamOtherRoles/Functional/NoOfMediaActivityOther 09.png');");		
Thread.sleep(5000);
               


/*
		// CHECK FOR GROUPS

		// Click on Profile (Howdy,{username}) section

		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))
				.click();

		// Click on Groups

		wd.findElement(By.id("user-groups")).click();

		// click on a group named "test"

		wd.findElement(By.linkText("test")).click();
		  // Click on ACTIVITY inside test group
		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("Check number of media items in a single Activity for a  Group named test");

		// Upload multiple Media

		wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(Constants.Photo);
		Thread.sleep(10000);

		wd.findElement(By.id("aw-whats-new-submit")).click();
		Thread.sleep(10000);
		wd.navigate().refresh();

		Thread.sleep(4000);
*/
		// Log out

		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		wd.findElement(By.linkText("Log Out")).click();
		wd.quit();

	}

}
