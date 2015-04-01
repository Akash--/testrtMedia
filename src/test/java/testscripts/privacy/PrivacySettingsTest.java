/**
 * @author Juhi
 * @tag This is for privacy settings
 */
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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testscripts.Constants;

public class PrivacySettingsTest {
	static PhantomJSDriver wd;

	@BeforeMethod
	public void setUp() throws Exception {
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(groups = { "Privacy" })
	public static void checkPrivacySettings() throws Exception {

		// Login to Wordpress
		// wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Phantomjs
		
		wd.get(Constants.WP_SERVER);
		wd.findElement(By.linkText("Log in")).click();
		wd.findElement(By.id("user_login")).click();
		wd.findElement(By.id("user_login")).clear();
		wd.findElement(By.id("user_login")).sendKeys(Constants.USERNAME1);
		wd.findElement(By.id("user_pass")).click();
		wd.findElement(By.id("user_pass")).clear();
		wd.findElement(By.id("user_pass")).sendKeys(Constants.UPASSWORD1);
		wd.findElement(By.id("wp-submit")).click();
		Thread.sleep(1000);
		Constants.openrtMediaSettings(wd);

		// Click on rtMedia settings Privacy Tab
		wd.findElement(By.id("tab-rtmedia-privacy")).click();

		// // Click on rtMedia settings Privacy Tab
		// ((JavascriptExecutor) wd)
		// .executeScript("jQuery('.rtm-settings-tab-container dd').each(function(){"
		// + "jQuery(this).removeClass('active');"
		// + "});"
		// +
		// "jQuery('.rtm-settings-tab-container dd:nth-child(8) a').trigger('click');");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/Privacy/PrivacySettingsTest01.png'); ");
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
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/Privacy/PrivacySettingsTest02.png'); ");
		// // Default privacy is public, still its not selected then select it
		if (!wd.findElement(By.id("rt-form-radio-8")).isSelected()) {
			wd.findElement(By.id("rt-form-radio-8")).click();
		}
		// // Default privacy is public, still its not selected then select it
		// ((JavascriptExecutor) wd)
		// .executeScript("jQuery('#rt-form-radio-8').attr('checked',true);");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/Privacy/PrivacySettingsTest03.png'); ");

		// To save the form
		wd.findElement(By.id("rtmedia-settings-submit")).click();

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/Privacy/PrivacySettingsTest04.png'); ");
		// // To save the form
		// ((JavascriptExecutor) wd)
		// .executeScript("jQuery('#rtmedia-settings-submit').trigger('click');");
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
		wd.navigate().to(Constants.WP_SERVER + "/activity");
		/* wd.findElement(By.linkText("ACTIVITY")).click(); */

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/Privacy/PrivacySettingsTest05.png'); ");

		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys(
				"Privacy Settings Test For Public");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/Privacy/PrivacySettingsTest06.png'); ");
		// // Upload Media
		// Runtime.getRuntime().exec(Constants.UPLOADFILEFORPRIVACY);

		wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ Constants.UPLOADFILE1 + "');"
				+ "page.render('./screen/nextprintscreen' + count+'.png');");
		Thread.sleep(4000);

		wd.findElement(By.id("aw-whats-new-submit")).click();
		wd.navigate().refresh();
		Thread.sleep(2000);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/Privacy/PrivacySettingsTest07.png'); ");
		WebElement postContentElement = wd.findElement(By
				.cssSelector("div.rtmedia-activity-text"));
		// Verify if recently uploaded media uploaded is visible to public
		/* String expectedImageName = "PrivacyTestPublic"; */
		String expectedImageName = "test";
		String actualImageName = "";
		// System.out.println(postConetentElement.getText() + " : text");
		WebElement parent = wd.findElement(By.id("activity-stream"));
		// List<WebElement>
		// childActivities=parent.findElements(By.tagName("li"));
		WebElement recentChildActivity = parent.findElements(By.tagName("li"))
				.get(0);
		String expectedText = "Privacy Settings Test For Public";
		String actualText = recentChildActivity
				.findElement(
						By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "div.rtmedia-activity-text")).getText();
		try {
			Assert.assertEquals(actualText, expectedText);
			System.out.println(actualText + " : present");
		} catch (Throwable e) {
			System.out.println("Content is not present in private too");
			wd.close();
		}

		boolean actualFlag = false, expectedFlag = true;
		if (recentChildActivity
				.findElements(
						By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
				.size() != 0)
			actualFlag = true;

		try {
			Assert.assertEquals(actualFlag, expectedFlag);
			System.out
					.println(recentChildActivity
							.findElements(
									By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
											+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
							.size()
							+ "image size present");
		} catch (Throwable e) {
			System.out.println("Image is not present in private too");
			wd.close();
		}
		// if ("Privacy Settings Test For Public ".equals(postConetentElement
		// .getText())) {
		// actualImageName=postConetentElement
		// .findElement(
		// By.cssSelector("div.rtmedia-item-title"))
		// .getText();
		// System.out.println(actualImageName+": actual image name");
		//
		// }
		//
		//
		// try {
		// Assert.assertEquals(actualImageName, expectedImageName);
		//
		// } catch (Throwable e) {
		// System.out
		// .println("Image is not avilable in logged in too");
		// }

		// Logout
		Constants.logout(wd);
		WebElement postContentElementPublic = wd.findElement(By
				.cssSelector("div.rtmedia-activity-text"));
		// Verify if recently uploaded media uploaded is visible to public
		WebElement parentPublic = wd.findElement(By.id("activity-stream"));
		// List<WebElement>
		// childActivities=parent.findElements(By.tagName("li"));
		WebElement recentChildActivityPublic = parentPublic.findElements(
				By.cssSelector("li[id^='activity']")).get(0);
		String expectedTextPublic = "Privacy Settings Test For Public";
		String actualTextPublic = recentChildActivityPublic
				.findElement(
						By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "div.rtmedia-activity-text")).getText();
		try {
			Assert.assertEquals(actualTextPublic, expectedTextPublic);
			System.out.println(actualTextPublic + " : present for public");
		} catch (Throwable e) {
			System.out.println("Content is not present for public");
		}

		boolean actualFlagPublic = false, expectedFlagPublic = true;
		if (recentChildActivityPublic
				.findElements(
						By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
								+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
				.size() != 0)
			actualFlagPublic = true;

		try {
			Assert.assertEquals(actualFlagPublic, expectedFlagPublic);
			System.out
					.println(recentChildActivityPublic
							.findElements(
									By.cssSelector("div.activity-content > div.activity-inner > div.rtmedia-activity-container > "
											+ "ul.rtmedia-list.large-block-grid-3.rtmedia-activity-media-length-1"))
							.size()
							+ "image size present");
		} catch (Throwable e) {
			System.out.println("Image is not present for public");
		}
	}
	@AfterMethod
    public void tearDown()
    {
        wd.quit();
    }
}
