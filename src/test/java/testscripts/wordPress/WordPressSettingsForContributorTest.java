package testscripts.wordPress;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testscripts.Constants;

public class WordPressSettingsForContributorTest {
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

		wd.get(Constants.WP_SERVER);
	//	wd.findElement(By.linkText("Log in")).click();
		// Login to wordpress by admin acccount
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);

		Constants.openrtMediaSettings(wd);
		WordPressSettingsHelper
				.openWordPressSettingToEnableCommentsWithThumbnailAttachment(wd);
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
		Constants.logout(wd);
//		wd.findElement(By.linkText("Log in")).click();
		// Login to Wordpress
		// Login to wordpress by Contributor acccount
		Constants.login(wd, Constants.TestContributor,
				Constants.TestContributorPassword);
		Thread.sleep(2000);
		WordPressSettingsHelper.openPost(wd, "Test Post For Contributor");
		System.out.println("Verifying when with thumbnail is selected");
		// Call method to comment and attach media
		WordPressSettingsHelper.attachMedia(wd,
				"This is a test comment by Contributor", Constants.UPLOADFILE1);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForContributor01.png'); ");
		// Call method to verify the comment text and image
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is a test comment by Contributor",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a",
						"Image",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/img",
						Constants.IMAGEATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForContributor02.png'); ");
		Thread.sleep(3000);
		// Call method to comment again and upload the video
		WordPressSettingsHelper.attachMedia(wd,
				"This is test comment 2 for video attachment by Contributor",
				Constants.UPLOADVIDEOFILE);
		// call method to verify comment text present and video is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is test comment 2 for video attachment by Contributor",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a",
						"Video",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/img",
						Constants.VIDEOATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForContributor03.png'); ");
		Thread.sleep(3000);
		// Call method to comment again and upload the Audio
		WordPressSettingsHelper.attachMedia(wd,
				"This is test comment 3 for audio attachment by Contributor",
				Constants.UPLOADAUDIOFILE);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForContributor04.png'); ");

		// call method to verify comment text present and Audio is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is test comment 3 for audio attachment by Contributor",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a",
						"Audio",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/img",
						Constants.AUDIOATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForContributor05.png'); ");
		Constants.logout(wd);
	//	wd.findElement(By.linkText("Log in")).click();
		// Login to wordpress by admin acccount
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);

		Constants.openrtMediaSettings(wd);
		WordPressSettingsHelper
				.openWordPressSettingToEnableCommentsWithOutThumbnailAttachment(wd);
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

		Constants.logout(wd);
//		wd.findElement(By.linkText("Log in")).click();
		// Login to wordpress by Contributor acccount
		Constants.login(wd, Constants.TestContributor,
				Constants.TestContributorPassword);
		Thread.sleep(2000);
		// Open Test Post again
		WordPressSettingsHelper.openPost(wd, "Test Post For Contributor");
		System.out
				.println("Verifying when whithout thumbnail radio buttion is selected");
		// Verify if comment text present
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is a test comment by Contributor",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a",
						"Image",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/img",
						Constants.IMAGEATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForContributor06.png'); ");
		// call method to verify comment text present and video is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is test comment 2 for video attachment by Contributor",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a",
						"Video",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/img",
						Constants.VIDEOATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForContributor07.png'); ");
		// call method to verify comment text present and Audio is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is test comment 3 for audio attachment by Contributor",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a",
						"Audio",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/img",
						Constants.AUDIOATTACHEMENTNAME);
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForContributor08.png'); ");
		Constants.logout(wd);

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
