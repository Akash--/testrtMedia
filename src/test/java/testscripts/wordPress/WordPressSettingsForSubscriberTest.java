package testscripts.wordPress;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testscripts.Constants;

public class WordPressSettingsForSubscriberTest {
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
		Constants.logout(wd);
		// Login to Wordpress
		// Login to wordpress by Subscriber acccount
		Constants.login(wd, Constants.TestSubscriber,
				Constants.TestSubscriberPassword);
		Thread.sleep(2000);
		WordPressSettingsHelper.openPost(wd, "Test Post For Subscriber");
		System.out.println("Verifying when with thumbnail is selected");
		// Call method to comment and attach media
		WordPressSettingsHelper.attachMedia(wd,
				"This is a test comment by Subscriber", Constants.UPLOADFILE1);
		// Call method to verify the comment text and image
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is a test comment by Subscriber",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a",
						"Image",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/img",
						Constants.IMAGEATTACHEMENTNAME);
		Thread.sleep(3000);
		// Call method to comment again and upload the video
		WordPressSettingsHelper.attachMedia(wd,
				"This is test comment 2 for video attachment by Subscriber",
				Constants.UPLOADVIDEOFILE);
		// call method to verify comment text present and video is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is test comment 2 for video attachment by Subscriber",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a",
						"Video",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/img",
						Constants.VIDEOATTACHEMENTNAME);
		Thread.sleep(3000);
		// Call method to comment again and upload the Audio
		WordPressSettingsHelper.attachMedia(wd,
				"This is test comment 3 for audio attachment by Subscriber",
				Constants.UPLOADAUDIOFILE);

		// call method to verify comment text present and Audio is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is test comment 3 for audio attachment by Subscriber",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a",
						"Audio",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/img",
						Constants.AUDIOATTACHEMENTNAME);
		Constants.logout(wd);
		//wd.findElement(By.linkText("Log in")).click();
		// Login to wordpress by admin acccount
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);

		Constants.openrtMediaSettings(wd);
		WordPressSettingsHelper
				.openWordPressSettingToEnableCommentsWithOutThumbnailAttachment(wd);
		Thread.sleep(2000);
		Constants.logout(wd);
		
		Thread.sleep(2000);
		// Login to wordpress by Subscriber acccount
		Constants.login(wd, Constants.TestSubscriber,
				Constants.TestSubscriberPassword);
		Thread.sleep(2000);
		// Open Test Post again
		WordPressSettingsHelper.openPost(wd, "Test Post For Subscriber");
		System.out
				.println("Verifying when whithout thumbnail radio buttion is selected");
		// Verify if comment text present
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is a test comment by Subscriber",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a",
						"Image",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/img",
						Constants.IMAGEATTACHEMENTNAME);
		// call method to verify comment text present and video is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is test comment 2 for video attachment by Subscriber",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a",
						"Video",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/img",
						Constants.VIDEOATTACHEMENTNAME);
		// call method to verify comment text present and Audio is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is test comment 3 for audio attachment by Subscriber",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a",
						"Audio",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/img",
						Constants.AUDIOATTACHEMENTNAME);
		Constants.logout(wd);

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
