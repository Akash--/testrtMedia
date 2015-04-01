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

//3.7.1.4
public class numberOfMediaItemsInActivitySreamTest {
	@Test(groups = { "buddypress" })
	public static void numberOfMediaItemsInActivity() throws Exception {

		// Phantom js : headless
		// Code to take screenshots
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		 
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this;"
						+ "page.render('./screen/BuddyPress/NumberofMediaItemsInActivityStream/Functional/NoOfMediaActivity 01 .png');");

		// Open rtMedia Settings
		Constants.openrtMediaSettings(wd);

		//Thread.sleep(5000);
		// Click on rtMedia settings BuddyPress Tab
		wd.findElement(By.id("tab-rtmedia-bp")).click();
		System.out.println("BuddyPress Tab Opened");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this;"
						+ "page.render('./screen/BuddyPress/NumberofMediaItemsInActivityStream/Functional/NoOfMediaActivity 02 .png');");
		// 0 is unlimited. Enter a number > 0 and check number of media files
		// displayed per activity

		wd.findElement(By.id("rt-form-number-1")).click();
		wd.findElement(By.id("rt-form-number-1")).clear();
		wd.findElement(By.id("rt-form-number-1")).sendKeys("1"); // Media >this
																	// number
																	// will be
																	// uploaded
																	// but won't
																	// show in
																	// Activity
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this;"
						+ "page.render('./screen/BuddyPress/NumberofMediaItemsInActivityStream/Functional/NoOfMediaActivity 03 .png');");

		// save the BuddyPress settings Form
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("saved");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this;"
						+ "page.render('./screen/BuddyPress/NumberofMediaItemsInActivityStream/Functional/NoOfMediaActivity 04 .png');");
		//Thread.sleep(7000);

		// Do a mouse over on the primary menu on top LHS
		new Actions(wd)
				.moveToElement(
						wd.findElement(By
								.cssSelector("#wp-admin-bar-site-name > a.ab-item")))
				.build().perform();

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();

		// Click on ACTIVITY

		/* wd.get(Constants.WP_SERVER_ACTIVITY); */
		wd.navigate().to(Constants.WP_SERVER + "/activity");

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this;"
						+ "page.render('./screen/BuddyPress/NumberofMediaItemsInActivityStream/Functional/NoOfMediaActivity 05 .png');");
		/* wd.findElement(By.linkText("ACTIVITY")).click(); */

		wd.findElement(By.id("whats-new")).click();
		/* wd.findElement(By.id("whats-new")).clear(); */
		/*
		 * wd.findElement(By.id("whats-new")).sendKeys(
		 * "Check Upload From Activity Stream : Photos ");
		 */
		//Thread.sleep(2000);
		System.out.println(" Clicked Activity");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this;"
						+ "page.render('./screen/BuddyPress/NumberofMediaItemsInActivityStream/Functional/NoOfMediaActivity 06 .png');");
		//https://rtcamp.com/refund-policy/
		// Upload Media

		// Click Attach Files

		/*
		 * wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		 */
		wd.findElement(By.cssSelector("button.rtmedia-add-media-button"))
				.click();

		//Thread.sleep(3000);
		System.out.println("Attach Files Clicked");

		/*
		 * ((PhantomJSDriver) wd).executePhantomJS("var page=this; " +
		 * "var count=0;" + "page.uploadFile('input[type=file]','" +
		 * Constants.DocumentPhantom + "');" +
		 * "page.uploadFile('input[type=file]','" + Constants.PhotoPhantom +
		 * "');" +
		 * "page.render('./screen/BuddyPress/Functional/Number of Media Activity Stream.png');"
		 * );
		 */

		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]',['"
				+ Constants.DocumentPhantom + "','" + Constants.Document
				+ "']);");
		Thread.sleep(8000); // Increase sleep for Music and Video uploads
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this;"
						+ "page.render('./screen/BuddyPress/NumberofMediaItemsInActivityStream/Functional/NoOfMediaActivity 07.png');");
		// Enter some content

		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("2 Media Uploaded. Media displayed should be 1");
		System.out.println("Media visible in activity < = No of Media items value set in setting. ");
		Thread.sleep(2000);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this;"
						+ "page.render('./screen/BuddyPress/NumberofMediaItemsInActivityStream/Functional/NoOfMediaActivity 08.png');");
		// Click Post Update

		wd.findElement(By.cssSelector("input#aw-whats-new-submit")).click();
		System.out.println("Post Update button clicked");
		Thread.sleep(20000);
		System.out.println(" Media Uploaded");
		wd.findElement(By.cssSelector("input#aw-whats-new-submit")).click();

		//Thread.sleep(10000);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this;"
						+ "page.render('./screen/BuddyPress/NumberofMediaItemsInActivityStream/Functional/NoOfMediaActivity 09.png');");
		//wd.findElements(By.cssSelector("div.activity-content > div.activity-inner > div > ul > li > div.rtmedia-item-thumbnail > a > img")).size();
		int i = wd.findElements(By.cssSelector("div.activity-content > div.activity-inner > div > ul > li > div.rtmedia-item-thumbnail > a > img")).size();
		System.out.println("size :"+i);
		
		//Thread.sleep(5000);
		/*
		 * // CHECK FOR GROUPS
		 * 
		 * // Click on Profile (Howdy, admin) section
		 * 
		 * wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))
		 * .click();
		 * 
		 * // Click on Groups
		 * 
		 * wd.findElement(By.id("user-groups")).click();
		 * 
		 * // click on a group named "test"
		 * 
		 * wd.findElement(By.linkText("test")).click(); // Click on ACTIVITY
		 * inside test group
		 * 
		 * wd.findElement(By.id("whats-new")).click();
		 * wd.findElement(By.id("whats-new")).clear();
		 * wd.findElement(By.id("whats-new")).sendKeys(
		 * "check number of media items in a single Activity for a  Group named test"
		 * );
		 * 
		 * // Upload multiple Media
		 * 
		 * wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		 * Thread.sleep(3000);
		 * 
		 * Runtime.getRuntime().exec(Constants.Photo);
		 * 
		 * Thread.sleep(10000);
		 * 
		 * wd.findElement(By.id("aw-whats-new-submit")).click();
		 * Thread.sleep(10000); wd.navigate().refresh();
		 * 
		 * Thread.sleep(4000);
		 */
		// Log out
		
		Constants.logout(wd);
	}
}
