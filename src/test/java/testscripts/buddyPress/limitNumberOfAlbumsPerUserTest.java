/*@ Author Sumeet*/
/*@ Improved by Akash*/
package testscripts.buddyPress;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class limitNumberOfAlbumsPerUserTest {

	@Test(groups = {"buddypress"})
	// PRO only feature . rtMedia Pro must be activated
	public static void limitNumberOfAlbumsPerUsr() throws Exception {

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
		 
		 //clicked on user name
			wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

			// click on Media
			wd.findElement(By.id("user-media")).click();

			// click on Albums. You will find Albums List
			wd.findElement(By.id("rtmedia-nav-item-albums")).click();
		
			String a = wd.findElement(By.cssSelector("#rtmedia-nav-item-albums > span")).getText();
			
			System.out.println("current album :" +a);

		int a1=Integer.parseInt(a);
		int b=a1+2;
		String b1=String.valueOf(b);
		 
		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
				
		//Thread.sleep(5000);
		// Click on rtMedia settings BuddyPress Tab
		wd.findElement(By.id("tab-rtmedia-bp")).click();
		System.out.println("BuddyPress Tab Opened");
		
		/*// enter a number > 0 in settings

		wd.findElement(By.id("rt-form-number-2")).click();
		wd.findElement(By.id("rt-form-number-2")).clear();
		 
		//0 is unlimited albums . Change to set limits 
		wd.findElement(By.id("rt-form-number-2")).sendKeys("60");
		
*/
		// enter a number > 0 in settings

				wd.findElement(By.id("rt-form-number-2")).click();
				wd.findElement(By.id("rt-form-number-2")).clear();
				 
				//0 is unlimited albums . Change to set limits 
				System.out.println("we are setting limit on album is 2 so thats become is current+2");
				wd.findElement(By.id("rt-form-number-2")).sendKeys(b1);
		
		
		
		//Thread.sleep(7000);
		// save the BuddyPress settings Form
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings saved");
		//Thread.sleep(2000);
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();

		// Click on Profile (Howdy, admin) section to check Media is present in
		// BuddyPress profile or not

		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		// click on Media
		wd.findElement(By.id("user-media")).click();

		// click on Albums. You will find Albums List
		wd.findElement(By.id("rtmedia-nav-item-albums")).click();
		//Thread.sleep(3000);

		// click on Options . Must show options to Proceed

		wd.findElement(By.id("rtm-media-options-list")).click();

		Thread.sleep(1000);

		wd.findElement(
				By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons"))
				.click();
		// click on Add Album
		wd.findElement(By.linkText("Add Album")).click();
		wd.findElement(By.id("rtmedia_album_name")).click();
		wd.findElement(By.id("rtmedia_album_name")).clear();
		wd.findElement(By.id("rtmedia_album_name")).sendKeys(
				"new album 1 added by user");
		wd.findElement(By.id("rtmedia_create_new_album")).click();
		Thread.sleep(1000);
		System.out.println("create new album 1");
		wd.navigate().refresh();

		// album 2
		wd.findElement(By.id("rtm-media-options-list")).click();
		wd.findElement(
				By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons"))
				.click();
		wd.findElement(By.linkText("Add Album")).click();
		wd.findElement(By.id("rtmedia_album_name")).click();
		wd.findElement(By.id("rtmedia_album_name")).clear();
		wd.findElement(By.id("rtmedia_album_name")).click();
		wd.findElement(By.id("rtmedia_album_name")).sendKeys(
				"new album 2 added by user");
		wd.findElement(By.id("rtmedia_create_new_album")).click();
		System.out.println("created new album 2");
		wd.navigate().refresh();
		// album3
		wd.findElement(By.id("rtm-media-options-list")).click();


		wd.findElement(
				By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons"))
				.click();
		if(wd.findElement(
				By.linkText("Add Album")).isDisplayed())
		{
		wd.findElement(By.linkText("Add Album")).click();
		wd.findElement(By.id("rtmedia_album_name")).click();
		wd.findElement(By.id("rtmedia_album_name")).clear();
		wd.findElement(By.id("rtmedia_album_name")).click();

		wd.findElement(By.id("rtmedia_album_name")).sendKeys(
				"new album 3 added by user");
		wd.findElement(By.id("rtmedia_create_new_album")).click();
		wd.navigate().refresh();
		System.out.println("created 3 Album : Test Fail");
		}
		else
		{
			System.out.println("created album is 2 now");
			System.out.println("Test Pass :Not allow to user create album greater than: "+b1);
		}
		//Thread.sleep(10000);

		// Logout
		Constants.logout(wd);
	}
}
