package testscripts.wordPress;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
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
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import testscripts.Constants;

public class SiteWideGalleryTest {
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

	@Test(groups={"WordPressSettings"})
	public static void checkSiteWideGallerySettings() throws Exception {

	
		// Login to Wordpress
		wd.get(Constants.WP_SERVER);
		//wd.findElement(By.linkText("Log in")).click();
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		Thread.sleep(2000);
		// Call method to open rtMedia Setting
		Constants.openrtMediaSettings(wd);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/SiteWideGalley/SiteWideGallery01.png'); ");
		Thread.sleep(5000);
		// Click on rtMedia settings wordPress Tab
		wd.findElement(By.id("tab-rtmedia-wordpress")).click();
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/SiteWideGalley/SiteWideGallery02.png'); ");
		// Check if the switch in on or off, if its off then switch on if its
		// off then proceed
		List<WebElement> switchElement = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox > label[for=\"rt-form-checkbox-13\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		System.out.println(switchElement.size() + " : Switch Size");
		if (switchElement.size() != 0) {

			switchElement.get(0)
					.findElement(By.cssSelector("span.switch-right")).click();
			System.out.println("Switched on Enable Sitewide gallery section");

		} else
			System.out.println("Enable Sitewide gallery section is already on");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/SiteWideGalley/SiteWideGallery03.png'); ");

		// Enter Slug for sitewide gallery section
		wd.findElement(By.id("rt-form-text-0")).click();
		wd.findElement(By.id("rt-form-text-0")).clear();
		wd.findElement(By.id("rt-form-text-0")).sendKeys("TestAlbum");
		System.out.println("Entered slug");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/SiteWideGalley/SiteWideGallery04.png'); ");

		// save the wordpress settings Form
		wd.findElement(By.id("rtmedia-settings-submit")).click();

		Thread.sleep(2000);
		System.out.println("saved the settings");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/SiteWideGalley/SiteWideGallery05.png'); ");

		// Click on rtMedia
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.linkText("Albums")))
				.build().perform();
		Thread.sleep(2000);
		wd.findElement(By.linkText("Create")).click();
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/SiteWideGalley/SiteWideGallery06.png'); ");
		// Enter album title
		wd.findElement(By.id("title")).click();
		wd.findElement(By.id("title")).clear();
		wd.findElement(By.id("title")).sendKeys("Test Album");

		// Click on publish button
		wd.findElement(By.id("publish")).click();
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/SiteWideGalley/SiteWideGallery07.png'); ");

		String message = wd.findElement(By.cssSelector("div#message > p"))
				.getText();
		System.out.println(message + ": message");
		if ("Post published. View post".equals(message))
			System.out.println("Album published");
		else
			System.out.println("Album not published");

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/SiteWideGalley/SiteWideGallery08.png'); ");

		wd.navigate().to(Constants.WP_SERVER + "/TestAlbum");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/SiteWideGalley/SiteWideGallery09.png'); ");
		String expectedTitle = "Archives";
		String actualTitle = wd.findElement(By.className("page-title"))
				.getText();
		System.out.println(actualTitle);
		try {
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("Album exists");
			Reporter.log("Album exists");
		} catch (Throwable t) {
			System.out.println("Album does not exists");
			Reporter.log("Album does not exists");
		}
	}
	@AfterMethod
	public void afterTest(Method test, ITestResult result) throws MalformedURLException { 
		/*if (result.isSuccess()) {
			Constants.setResult(test.getAnnotation(Test.class).testName(),
					ExecutionStatus.PASSED);
			
		} else {
			Constants.setResult(test.getAnnotation(Test.class).testName(),
					ExecutionStatus.FAILED);
		}*/
		wd.quit();
	}
}
