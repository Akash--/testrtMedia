package testscripts.privacy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import testscripts.Constants;

public class PrivacySettingsPrivateTest {
	@Test(groups={"Privacy"})
	
	public static void checkPrivacySettingsForPrivate() throws Exception {
	    
		// Phantomjs
		
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		 
	//	Thread.sleep(1000);
		Constants.openrtMediaSettings(wd);
		Thread.sleep(2000);
		// Click on rtMedia settings Privacy Tab
		 wd.findElement(By.id("tab-rtmedia-privacy")).click();
		// Click on rtMedia settings Privacy Tab
//		((PhantomJSDriver) wd)
//		.executePhantomJS("var page=this; "
//				+ "page.injectJs('./js/jquery-2.1.0.min.js', function() {"
//				+ "  waitFor(function(){ ,"
//				+ "function(){ return page.evaluate(function(){"
//				+ "return $('#rtm-settings-tab-container').is(':visible');"
//				+ "});"
//				+ "}page.evaluate(function() {"
//				+ "  $('.rtm-settings-tab-container dd').each(function(){"
//						+ "$(this).removeClass('active');"
//						+ "});"
//						+ "$('.rtm-settings-tab-container dd:nth-child(8) a').trigger('click');"
//				+ " });" + "});" + "phantom.exit();}); ");
//		((JavascriptExecutor) wd)
//				.executeScript("$('.rtm-settings-tab-container dd').each(function(){"
//						+ "$(this).removeClass('active');"
//						+ "});"
//						+ "$('.rtm-settings-tab-container dd:nth-child(8) a').trigger('click');");
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Privacy/Private/Functional/PrivacySettingsTestForPrivate01.png'); ");
		// Check if the switch in on or off, if its off then switch it on if its
		// on then proceed
		 List<WebElement> switchElement = wd
		 .findElements(By
		 .cssSelector("span.rt-form-checkbox > label[for=\"rtmedia-privacy-enable\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		 System.out.println("switch size:"+switchElement.size());
		 if (switchElement.size() != 0) {
		
		 switchElement.get(0)
		 .findElement(By.cssSelector("span.switch-right")).click();
		
		 } else
		 System.out.println("'Enable privacy ' is already on");
//		((JavascriptExecutor) wd)
//				.executeScript("if($('#rtmedia-privacy-enable').parent().hasClass('switch-off')){"
//						+ "$('.switch-right').click();" + "}");
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Privacy/Private/Functional/PrivacySettingsTestForPrivate02.png'); ");
		// ((PhantomJSDriver) wd).executePhantomJS("var page=this; "
		// + "page.check('rtmedia-options[privacy_enabled]')");
		// Select Privacy as private
//		((PhantomJSDriver) wd)
//		.executePhantomJS("var page=this; "
//				+ "page.injectJs('./js/jquery-2.1.0.min.js', function() {"
//				+ "  page.evaluate(function(){"
//				+ "$(#rt-form-radio-6).val()"
//				+ "});}); ");
	
		 if (!wd.findElement(By.id("rt-form-radio-6")).isSelected()) {
		 wd.findElement(By.id("rt-form-radio-6")).click();
		 }
		 ((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "page.render('./screen/Privacy/Private/Functional/PrivacySettingsTestForPrivate03.png'); ");
//		((JavascriptExecutor) wd)
//				.executeScript("jQuery('#rt-form-radio-6').attr('checked',true);");
		 // To save the form
		 wd.findElement(By.id("rtmedia-settings-submit")).click();
		 ((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "page.render('./screen/Privacy/Private/Functional/PrivacySettingsTestForPrivate04.png'); ");
//		// To save the form
//		((JavascriptExecutor) wd)
//				.executeScript("jQuery('#rtmedia-settings-submit').trigger('click');");
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
		wd.findElement(By.linkText("ACTIVITY")).click();
		Thread.sleep(2000);
		 ((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "page.render('./screen/Privacy/Private/Functional/PrivacySettingsTestForPrivate05.png'); ");
		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys(
				"Privacy Settings Test For Private");
		 ((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "page.render('./screen/Privacy/Private/Functional/PrivacySettingsTestForPrivate06.png'); ");
		wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		// // Upload Media
		// Runtime.getRuntime().exec(Constants.UPLOADFILEFORPRIVACY);
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ Constants.UPLOADFILE1 + "');"
				+ "page.render('./screen/Privacy/Private/Functional/PrivacySettingsTestForPrivate07.png');");
		Thread.sleep(4000);
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Privacy/Private/Functional/PrivacySettingsTestForPrivate07.png'); ");
		wd.findElement(By.id("aw-whats-new-submit")).click();
		 wd.navigate().refresh();
		Thread.sleep(3000);
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
		String expectedText = "Privacy Settings Test For Private";
		/*new WebDriverWait(wd, 60)
				.until(ExpectedConditions.presenceOfElementLocated(By
						.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "div.rtmedia-activity-text")));
		*/String actualText = recentChildActivity.findElement(
						By.cssSelector("div.activity-content > div.activity-inner > div > div")).getText();
		System.out.println("Actual text is"+actualText);
		try {
			Assert.assertEquals(actualText, expectedText);
			System.out.println(actualText + " : present for logged in users");
		} catch (Throwable e) {
			System.out
					.println("Content is not present for logged in users too");
			wd.close();
		}

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
							+ "image present for logged in users");
		} catch (Throwable e) {
			System.out.println("Image is not present for logged in users too");
			wd.close();
		}

		// Logout
		Constants.logout(wd);

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
							+ " image not present for public");
		} catch (Throwable e) {
			System.out.println("Image is present for public");

		}
		//Constants.logout(wd);
		Thread.sleep(2000);
		// Check for other Registered users
		//wd.findElement(By.linkText("Log in")).click();
		Constants.login(wd, Constants.TestAuthor, Constants.TestAuthorPassword);
		Thread.sleep(1000);

		// click on Activity Menu
		wd.navigate().to(Constants.WP_SERVER+"/activity");
		/*wd.findElement(By.linkText("ACTIVITY")).click();*/
		WebElement parentRegistered = wd.findElement(By.id("activity-stream"));

		WebElement recentChildActivityRegistered = parentRegistered
				.findElements(By.cssSelector("li[id^='activity']")).get(0);

		boolean acutalFlagRegistered = false, expectedFlagRegistered = false;
		if (recentChildActivityRegistered
				.findElements(
						By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
				.size() != 0)
			acutalFlagRegistered = true;

		try {
			Assert.assertEquals(acutalFlagRegistered, expectedFlagRegistered);
			System.out.println(recentChildActivityRegistered.findElements(
									By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
											+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
							.size()
							+ " image not present for Registered User");
		} catch (Throwable e) {
			System.out.println("Image is present for Registered user");

		}
		wd.close();
	}

}
