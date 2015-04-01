package testscripts.wordPress;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import testscripts.Constants;

public class WordPressSettingsTest {
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
	public static void wordPressSettings() throws Exception {

		// FirefoxDriver wd;
		// wd = new FirefoxDriver();
		// wd.manage().window().maximize();
		// System.setProperty(Constants.CHROMEDRIVER,Constants.CHROMEDRIVERPATH);
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--test-type");
		// ChromeDriver wd;
		// wd = new ChromeDriver(options);
		// wd.manage().window().maximize();

		// PhantomJSDriver wd;
		// wd = new PhantomJSDriver();
		// wd.manage().window().setSize(new Dimension(1920,1080));

		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login to Wordpress
		wd.get(Constants.WP_SERVER);
		//wd.findElement(By.linkText("Log in")).click();
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		Thread.sleep(2000);
		// Call method to open rtMedia Setting
		Constants.openrtMediaSettings(wd);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTest01.png'); ");
		Thread.sleep(5000);
		WordPressSettingsHelper
				.openWordPressSettingToEnableCommentsWithThumbnailAttachment(wd);
		Thread.sleep(2000);
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd)
				.moveToElement(
						wd.findElement(By
								.cssSelector("#wp-admin-bar-site-name > a.ab-item")))
				.build().perform();
		WebDriverWait wait = new WebDriverWait(wd, 20); // wait for a

		Thread.sleep(2000);
		// Click on the Visit Site menu
		wd.findElement(By.linkText("Visit Site")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title")));
		WordPressSettingsHelper.openPost(wd, "Test Post");
		System.out.println("Verifying when with thumbnail is selected");
		// Call method to comment and attach media
		WordPressSettingsHelper.attachMedia(wd, "This is a test comment",
				Constants.UPLOADFILE1);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest01.png'); ");
		// Call method to verify the comment text and image
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is a test comment",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a",
						"Image",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/img",
						Constants.IMAGEATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest02.png'); ");

		// Call method to comment again and upload the video
		WordPressSettingsHelper.attachMedia(wd,
				"This is test comment 2 for video attachment",
				Constants.UPLOADVIDEOFILE);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest03.png'); ");
		// call method to verify comment text present and video is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is test comment 2 for video attachment",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a",
						"Video",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/img",
						Constants.VIDEOATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest04.png'); ");
		// Call method to comment again and upload the video
		WordPressSettingsHelper.attachMedia(wd,
				"This is test comment 3 for audio attachment",
				Constants.UPLOADAUDIOFILE);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest05.png'); ");
		// call method to verify comment text present and Audio is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is test comment 3 for audio attachment",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a",
						"Audio",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/img",
						Constants.AUDIOATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest06.png'); ");
		// Call to open rtMedia Settings again
		Constants.openrtMediaSettings(wd);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest07.png'); ");
		Thread.sleep(5000);
		WordPressSettingsHelper
				.openWordPressSettingToEnableCommentsWithOutThumbnailAttachment(wd);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest08.png'); ");
		Thread.sleep(2000);
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd)
				.moveToElement(
						wd.findElement(By
								.cssSelector("#wp-admin-bar-site-name > a.ab-item")))
				.build().perform();
		Thread.sleep(2000);
		// Click on the Visit Site menu
		wd.findElement(By.linkText("Visit Site")).click();
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest09.png'); ");
		// Open Test Post again
		WordPressSettingsHelper.openPost(wd, "Test Post");
		System.out
				.println("Verifying when whithout thumbnail radio buttion is selected");
		// Verify if comment text present
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is a test comment",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a",
						"Image",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/img",
						Constants.IMAGEATTACHEMENTNAME);

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest10.png'); ");
		// call method to verify comment text present and video is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is test comment 2 for video attachment",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a",
						"Video",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/img",
						Constants.VIDEOATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest11.png'); ");
		// call method to verify comment text present and Audio is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is test comment 3 for audio attachment",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a",
						"Audio",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/img",
						Constants.AUDIOATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/wordpresssettingstest12.png'); ");

	}

	@AfterMethod
	public void afterTest(Method test, ITestResult result) throws MalformedURLException { 
		/*if (result.isSuccess()) {
			Constants.setResult(test.getAnnotation(Test.class).testName(),
					ExecutionStatus.PASSED);
			
		} else {
			Constants.setResult(test.getAnnotation(Test.class).testName(),
					ExecutionStatus.FAILED);
		}
	*/	wd.quit();
	}

}
