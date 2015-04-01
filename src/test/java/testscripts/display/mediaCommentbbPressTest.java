/**
 * @author Gaurav
 * @tag This code checks blah blah
 */
package testscripts.display;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import testscripts.Constants;

public class mediaCommentbbPressTest {
	@Test(groups = { "Display" })
	public static void commentOnUploadedMedia() throws Exception {
		/*FirefoxDriver wd;
		wd = new FirefoxDriver();
		wd.manage().window().maximize();*/
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
		 
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 01.png');");	
		// Open rtMedia Settings 
	Constants.openrtMediaSettings(wd);
			
	// Click on rtMedia Display

			wd.findElement(By.id("tab-rtmedia-display")).click();

			System.out.println("Display Tab Clicked ");
	/*	// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		// Click on Dashboard
		wd.findElement(By.linkText("Dashboard")).click();
		System.out.println("Dashboard Clicked");
		// Click on rtMedia
		wd.findElement(By.linkText("rtMedia")).click();
		System.out.println("rtMedia Clicked");*/
		
		// If Allow user to comment on uploaded media is ON then switch it OFF
		
		/*boolean checkBox1 = wd.findElement(By.id("rt-form-checkbox-0"))
				.isSelected();

		if (checkBox1 == true)
			wd.findElement(By.id("rt-form-checkbox-0")).click();
*/		
		// Check if the switch is on or off, if its off then switch on and  proceed
	List<WebElement> switchElement = wd.findElements(By
	.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-0\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

			if (switchElement.size() != 0) {

			switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
			System.out.println("'Allow user to comment on uploaded media' is switched  on");
				} else
					System.out.println("'Allow user to comment on uploaded media' is already on");
			
			
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 02.png');");
		
		// If Lightbox is OFF then turn it ON
		
	List<WebElement> switchElement2 = wd.findElements(By
			.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-6\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

					if (switchElement2.size() != 0) {

					switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
					System.out.println("'Lightbox' is switched  on");
						} else
							System.out.println("'Lightbox' is already on");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 03.png');");	
		
		// Save settings
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
		System.out.println("Settings Saved");
		Thread.sleep(2000);

		// Do a mouse over on the primary menu on top LHS
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		// Click on Visit Site
		wd.findElement(By.linkText("Visit Site")).click();
		// Click on Forums on primary menu
		wd.navigate().to(Constants.WP_SERVER + "/forums");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 04.png');");		
		/*wd.findElement(By.linkText("FORUMS")).click();*/
		// Click on forum called TestForum
		wd.findElement(By.linkText("TestForum")).click();
		// Click on a discussion called discussion1
		wd.findElement(By.linkText("discussion1")).click();
		// Click on Reply
		wd.findElement(By.id("bbp_reply_content")).click();
		wd.findElement(By.id("bbp_reply_content")).clear();
		// Add input to the reply field
		wd.findElement(By.id("bbp_reply_content")).sendKeys(
		"This is a test for Media Comment display on bbPress");
		System.out.println("Comment Posted");
		// Click on Subscribe
		if (!wd.findElement(By.id("bbp_topic_subscription")).isSelected()) {
			wd.findElement(By.id("bbp_topic_subscription")).click();
		}
		// Upload Media
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ Constants.PhotoPhantom + "');"				 
				+"page.render('./screen/nextprintscreen' + count+'.png');");		
		Thread.sleep(2000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 05.png');");		
		
	/*	wd.findElement(By.id("rtmedia_simple_file_input")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(Constants.UPLOADFILE1);
		Thread.sleep(3000);*/

		wd.findElement(By.id("bbp_reply_submit")).click();
		Thread.sleep(10000);
		System.out.println("Media uploaded");
		
		
		// Verify if text is present
		String expectedComment = "This is a test for Media Comment display on bbPress";
		// xpath below Failing 
		/*String actualComment = wd
				.findElement(
						By.xpath("//div[1]/div/div[1]/div/div/article/div/div/ul/li[2]/div[4]/div[2]/p"))
				.getText();*/
/*String actualComment = wd.findElement(By.xpath(".//*[@id='topic-1081-replies']/li[2]/div[4]/div[2]/p")).getText();*/
		//class = forums bbp-replies
		//ul[@class='sitemap']
// Works
/*String actualComment = wd.findElement(By.xpath("//ul[@class='forums bbp-replies']")).getText();*/
		
// Better		

	String actualComment = wd.findElement(By.xpath("//li[@class='bbp-body']/div[6]/div[2]/p")).getText();
	
		System.out.println("xpath working now");
		try {
			Assert.assertEquals(actualComment, expectedComment);
			System.out.println("Comment found");
		} catch (Throwable e) {
			System.out.println("Expected Comment in section not present - Failed");
		}
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 06.png');");
		// Click on uploaded media to open it in Lightbox
		Thread.sleep(4000);
		wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 07.png');");			
		Thread.sleep(1000);
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 08.png');");
		
		if ((wd.findElements(By.id("comment_content")).size() != 0)) {
			System.out.println("Comment field is Enabled");
		} else {
			System.out.println("Comment field is Disabled");
		}

		// Close the Light box
		wd.findElement(By.cssSelector("span.mfp-close")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 09.png');");		
		Thread.sleep(2000);
/*
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		// Click on Dashboard
		wd.findElement(By.linkText("Dashboard")).click();
		System.out.println("Dashboard Clicked");
		// Click on rtMedia
		wd.findElement(By.linkText("rtMedia")).click();
		System.out.println("rtMedia Clicked");
		
		// If Allow user to comment on uploaded media is ON then switch it OFF
		
		wd.findElement(By.id("rt-form-checkbox-0")).click();
		
		

		// Save settings
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Switched to ON");
		Thread.sleep(2000);
*/
	/*	// Do a mouse over on the primary menu on top LHS
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		// Click on Visit Site
		wd.findElement(By.linkText("Visit Site")).click();
		// Navigate to Forums
		wd.findElement(By.linkText("FORUMS")).click();
		
		*/
		
		/*wd.navigate().to(Constants.WP_SERVER +"/forums");
		// Click on forum called TestForum
		wd.findElement(By.linkText("TestForum")).click();
		// Click on a discussion called discussion1
		wd.findElement(By.linkText("discussion1")).click();

		// Click on uploaded media to open it in Lightbox
		wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();
		Thread.sleep(5000);

		// Comment on Media
		wd.findElement(By.id("comment_content")).click();
		wd.findElement(By.id("comment_content")).clear();
		wd.findElement(By.id("comment_content")).sendKeys(
		"Test for Upload Media Comment bbPress");
		wd.findElement(By.id("rt_media_comment_submit")).click();
		// Close the Light box
		wd.findElement(By.cssSelector("span.mfp-close")).click();
		Thread.sleep(2000);
		wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();
		Thread.sleep(5000);

		String actual = wd.findElement(
	By.xpath("//div[@class='rtmedia-comment-content']//p[.='Test for Upload Media Comment bbPress']")).getText();
		String expected = "Test for Upload Media Comment bbPress";
		try {
			Assert.assertEquals(actual, expected);
			Reporter.log("Comment has been posted on media successfully");
		} catch (Throwable e) {
			System.out.println("Expected Text Not Present for COMMENT- failed");
			Reporter.log("Expected Text Not Present for COMMENT- Failed check");
		}

		wd.findElement(By.cssSelector("span.mfp-close")).click();
		Thread.sleep(5000);*/
		
		
		// Check with Lightbox OFF
System.out.println("Checking with lightbox off");
		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
				
		// Click on rtMedia Display

				wd.findElement(By.id("tab-rtmedia-display")).click();

				System.out.println("Display Tab Clicked ");
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 10.png');");
		// If Use Light Box to display media is ON then switch it OFF
				
	List<WebElement> switchElement3 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-6\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

		if (switchElement3.size() != 0) {

			switchElement3.get(0).findElement(By.cssSelector("span.switch-left")).click();
			
			System.out.println("Lightbox is switched off");

		} else
			System.out.println("Lighbox is already off");
Thread.sleep(2000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 11.png');");
		// Save settings
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings saved . Lightbox switched Off");
		Thread.sleep(2000);

		// Do a mouse over on the primary menu on top LHS
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		// Click on Visit Site
		wd.findElement(By.linkText("Visit Site")).click();
		// Navigate to forums
		wd.navigate().to(Constants.WP_SERVER+ "/forums");
		/*wd.findElement(By.linkText("FORUMS")).click();*/
		// Click on forum called TestForum
		wd.findElement(By.linkText("TestForum")).click();
		// Click on a discussion called discussion1
		wd.findElement(By.linkText("discussion1")).click();

		// Store the current window handle
		String winHandleBefore = wd.getWindowHandle();

		wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 12.png');");		
		Thread.sleep(5000);

		// Switch to new window opened
		for (String winHandle : wd.getWindowHandles()) {
			wd.switchTo().window(winHandle);
		}
		// Add a new comment
		wd.findElement(By.id("comment_content")).click();
		wd.findElement(By.id("comment_content")).clear();
		wd.findElement(By.id("comment_content")).sendKeys(
				"Test for Upload Media Comment without Light Box bbPress");
		wd.findElement(By.id("rt_media_comment_submit")).click();
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 13.png');");		
		// Check if new Comment was successfully added
		// x path failing
	/*String actual1 = wd.findElement(By.xpath("//ul[@id='rtmedia_comment_ul']/li[2]/div[2]/div/div[1]/p"))
				.getText();*/
		// New xpath
	String actual1 = wd.findElement(By.cssSelector("#rtmedia_comment_ul > li > div:nth-child(2) > div > div.rtmedia-comment-content > p"))
			.getText();
	
		
	//*[@id='topic-824-replies']/li[2]/div[4]/div[2]/p/text()
		String expected1 = "Test for Upload Media Comment without Light Box bbPress";
		try {
			Assert.assertEquals(actual1, expected1);
		} catch (Throwable e) {
			System.out.println("Expected Text Not Present for COMMENT- failed");
		}
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Comment/Functional/Allow user to comment 14.png');");
	/*	// Check if old Comment is present
String actual2 = wd.findElement(By.xpath("//ul[@id='rtmedia_comment_ul']/li[1]/div[2]/div/div[1]/p"))
				.getText();
		String expected2 = "Test for Upload Media Comment bbPress";
		try {
			Assert.assertEquals(actual2, expected2);
		} catch (Throwable e) {
			System.out.println("Expected Text Not Present for COMMENT- failed");
		}
*/
		// Close the window
		wd.close();

		// Switch back to original browser (first window)

		wd.switchTo().window(winHandleBefore);

		// Log out
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		wd.findElement(By.linkText("Log Out")).click();
		wd.quit();
	}
}
