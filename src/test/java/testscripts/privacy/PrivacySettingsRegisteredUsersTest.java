package testscripts.privacy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import testscripts.Constants;

public class PrivacySettingsRegisteredUsersTest {
	@Test(groups={"Privacy"})
	public static void checkPrivacySettingsForRegisteredUsers()
			throws Exception {
		// FirefoxDriver wd;
		// wd = new FirefoxDriver();
		// wd.manage().window().maximize();
		// Phantomjs
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		Constants.openrtMediaSettings(wd);
		//System.out.println("rtMedia Clicked");
		 // Click on rtMedia settings Privacy Tab
		 wd.findElement(By.id("tab-rtmedia-privacy")).click();
		// Click on rtMedia settings Privacy Tab
//		((JavascriptExecutor) wd)
//				.executeScript("jQuery('.rtm-settings-tab-container dd').each(function(){"
//						+ "jQuery(this).removeClass('active');"
//						+ "});"
//						+ "jQuery('.rtm-settings-tab-container dd:nth-child(8) a').trigger('click');");
		 ((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "page.render('./screen/Privacy/Register/Functional/PrivacySettingsTestForRegisteredUsers01.png'); ");
		// Check if the switch in on or off, if its off then switch it on if its
		// on then proceed
		List<WebElement> switchElement = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-privacy-enable\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement.size() != 0) {

			switchElement.get(0)
					.findElement(By.cssSelector("span.switch-right")).click();

		} else
			System.out.println("'Enable privacy ' is already on");
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Privacy/Register/Functional/PrivacySettingsTestForRegisteredUsers02.png'); ");
		// Select privacy as logged in users
		Thread.sleep(2000);
		if (!wd.findElement(By.id("rt-form-radio-7")).isSelected()) {
			wd.findElement(By.id("rt-form-radio-7")).click();
		}
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Privacy/Register/Functional/PrivacySettingsTestForRegisteredUsers03.png'); ");
		// To save the form
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Privacy/Register/Functional/PrivacySettingsTestForRegisteredUsers04.png'); ");
		Thread.sleep(2000);
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd)
				.moveToElement(
						wd.findElement(By
								.cssSelector("#wp-admin-bar-site-name > a.ab-item")))
				.build().perform();
		Thread.sleep(3000);
		// Click on Visit Site
		wd.findElement(By.linkText("Visit Site")).click();
		Thread.sleep(3000);
		// click on Activity Menu
		
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a"))).build().perform();
		//new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-activity > a"))).build().perform();
		Thread.sleep(2000);
		wd.findElement(By.cssSelector("#wp-admin-bar-my-account-activity > a")).click();
		System.out.println("Clicked on Activity");
		Thread.sleep(3000);
		//wd.findElement(By.linkText("ACTIVITY")).click();
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Privacy/Register/Functional/PrivacySettingsTestForRegisteredUsers05.png'); ");

		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("Privacy Settings Test For Registered Users");
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/Privacy/Register/Functional/PrivacySettingsTestForRegisteredUsers06.png'); ");

		wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		// Upload Media
//		Runtime.getRuntime().exec(Constants.UPLOADFILEFORPRIVACY);
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ Constants.UPLOADFILE1 + "');"
				+ "page.render('./screen/Privacy/Register/Functional/PrivacySettingsTestForPrivate07.png');");
		Thread.sleep(4000);
((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Privacy/Register/Functional/PrivacySettingsTestForRegisteredUsers07.png'); ");

		Thread.sleep(3000);

		wd.findElement(By.id("aw-whats-new-submit")).click();
		Thread.sleep(10000);
		 wd.navigate().refresh();
		Thread.sleep(2000);
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Privacy/Register/Functional/PrivacySettingsTestForRegisteredUsers07.png'); ");
		// WebElement postConetentElement = wd.findElement(By
		// .cssSelector("div.rtmedia-activity-text"));
		// Verify if recently uploaded media uploaded is visible to public
		String expectedImageName = "PrivacyTestPublic";
		String actualImageName = "";
		// System.out.println(postConetentElement.getText() + " : text");
		WebElement parent = wd.findElement(By.id("activity-stream"));
		// List<WebElement>
		// childActivities=parent.findElements(By.tagName("li"));
		WebElement recentChildActivity = parent.findElements(
				By.cssSelector("li[id^='activity']")).get(0);
		String expectedText = "Privacy Settings Test For Registered Users";
		/*new WebDriverWait(wd, 60)
				.until(ExpectedConditions.presenceOfElementLocated(By
						.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "div.rtmedia-activity-text")));
		*/String actualText = recentChildActivity
				.findElement(
						By.cssSelector("div.activity-content > div.activity-inner > div > div")).getText();
		try {
			Assert.assertEquals(actualText, expectedText);
			System.out.println(actualText + " : present for logged in users");
		} catch (Throwable e) {
			System.out.println("Content is not present for logged in users too");
			wd.close();
		}
/*List<WebElement> ele=	wd.findElements(
				By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
						+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"));
        ((WebElement) ele).getAttribute("id");     // for getting id of each element
        System.out.println(ele);
        
*/		
		/*WebElement ImageFile = wd.findElement(
				By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
						+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"));
		*/
		boolean acutalFlag = false, expectedFlag = true;
		if (recentChildActivity
				.findElements(
						By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
				.size() != 0)
			acutalFlag = true;

		try {
			Assert.assertEquals(acutalFlag, expectedFlag);
			System.out
					.println(recentChildActivity
							.findElements(
									By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
											+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
							.size()
							+ " image present for logged in users");
		} catch (Throwable e) {
			System.out.println(" Image is not present for logged in users too");
			wd.close();
		}

		// Logout
		Constants.logout(wd);

		// Check visible to the world
		WebElement parentPublic = wd.findElement(By.id("activity-stream"));

		WebElement recentChildActivityPublic = parentPublic.findElements(
				By.cssSelector("li[id^='activity']")).get(0);

		
		boolean acutalFlagPublic = false, expectedFlagPublic = false;
		if (recentChildActivityPublic
				.findElements(
						By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
				.size() != 0)
			acutalFlagPublic = true;

		try {
			Assert.assertEquals(acutalFlagPublic, expectedFlagPublic);
			System.out
					.println(recentChildActivityPublic
							.findElements(
									By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
											+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
							.size()
							+ " image is present for public");
		} catch (Throwable e) {
			System.out.println(" Image is not present for public");

		}
		// Check for other Registered users
		//wd.findElement(By.linkText("Log in")).click();
		Constants.login(wd, Constants.TestSubscriber, Constants.TestSubscriberPassword);
		Thread.sleep(1000);

		// click on Activity Menu
		/*wd.findElement(By.linkText("ACTIVITY")).click();*/
		wd.navigate().to(Constants.WP_SERVER + "/activity");
		WebElement parentRegistered = wd.findElement(By.id("activity-stream"));

		WebElement recentChildActivityRegistered = parentRegistered
				.findElements(By.cssSelector("li[id^='activity']")).get(0);
		String expectedTextRegistered = "Privacy Settings Test For Registered Users";
		new WebDriverWait(wd, 60)
				.until(ExpectedConditions.presenceOfElementLocated(By
						.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "div.rtmedia-activity-text")));
		String actualTextRegistered = recentChildActivityRegistered
				.findElement(
						By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "div.rtmedia-activity-text")).getText();
		try {
			Assert.assertEquals(actualTextRegistered, expectedTextRegistered);
			System.out.println(actualTextRegistered
					+ " : present for registered users");
		} catch (Throwable e) {
			System.out.println("Content is not present for registered users ");
			wd.close();
		}

		boolean acutalFlagRegistered = false, expectedFlagRegistered = true;
		if (recentChildActivityRegistered
				.findElements(
						By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
				.size() != 0)
			acutalFlagRegistered = true;

		try {
			Assert.assertEquals(acutalFlagRegistered, expectedFlagRegistered);
			System.out.println(recentChildActivityRegistered
							.findElements(
									By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
											+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
							.size()
							+ " image is present for Registered User");
		} catch (Throwable e) {
			System.out.println(" Image is not present for Registered user");

		}
		wd.close();
	}

}
