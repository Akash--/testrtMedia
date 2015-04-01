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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import testscripts.Constants;

public class WordPressSettingsForAnonymousUserTest {
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

		// Open rtmedia Settings and check if
		// "Enable for non-logged in users also" switch is off and if not then
		// make it OFF
		// Click on rtMedia settings wordPress Tab
		wd.findElement(By.id("tab-rtmedia-wordpress")).click();

		// Check if the switch in on or off, if its off then switch on if its
		// off then proceed
		List<WebElement> switchElement = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox.rtm_enable_comment_form > label > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement.size() != 0) {

			switchElement.get(0)
					.findElement(By.cssSelector("span.switch-right")).click();

			if (!wd.findElement(By.id("rt-form-checkbox-11")).isSelected()) {
				// Swtich on Enable Attachment in comments
				wd.findElement(By.id("rt-form-checkbox-11")).click();
			}
		} else
			System.out.println("Enable Attachment in Comments Already On");
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForAnonymousUser01.png'); ");
		// Click on radio button
		if (!wd.findElement(By.id("rt-form-radio-2")).isSelected()) {
			// Swtich on Enable Attachment in comments
			wd.findElement(By.id("rt-form-radio-2")).click();
		}
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForAnonymousUser02.png'); ");
		List<WebElement> anonymousElement = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox.rtm_enable_anonymous_comment > label > div.rt-switch.has-switch.deactivate > div.switch-animate.switch-off"));
		List<WebElement> anonymousElement2 = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox.rtm_enable_anonymous_comment > label > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (anonymousElement.size() != 0 || anonymousElement2.size() != 0) {
			anonymousElement.get(0)
					.findElement(By.cssSelector("span.switch-right")).click();
			if (!wd.findElement(By.id("rt-form-checkbox-12")).isSelected()) {
				// Swtich on Enable Attachment in comments
				wd.findElement(By.id("rt-form-checkbox-12")).click();
			}
		} else {
			System.out
					.println("Enable for non-logged in users also already On");
		}
		// save the wordpress settings Form
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForAnonymousUser03.png'); ");
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
		// ///////////////////////////////////////////////////////////////////////////////////////////////////////////

		Thread.sleep(2000);
		WordPressSettingsHelper.openPost(wd, "Test Post For Anonymous");
		System.out.println("Verifying when with thumbnail is selected");

		// Comment and attach media
		// enter name
		wd.findElement(By.id("author")).click();
		wd.findElement(By.id("author")).clear();
		wd.findElement(By.id("author")).sendKeys("Anonymous");
		System.out.println("Entered Author name");

		// Enter email id
		wd.findElement(By.id("email")).click();
		wd.findElement(By.id("email")).clear();
		wd.findElement(By.id("email")).sendKeys("test@test.com");
		System.out.println("Entered email");

		// Enter Comment
		wd.findElement(By.id("comment")).click();
		wd.findElement(By.id("comment")).clear();
		wd.findElement(By.id("comment")).sendKeys(
				"This is a test comment by Anonymous");
		System.out.println("Entered Comment");

		// Click on browse to attach the file
		wd.findElement(By.id("rtmedia_simple_file_input")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ Constants.UPLOADFILE1 + "');"
				+ "page.render('./screen/nextprintscreen' + count+'.png');");
		Thread.sleep(5000);

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForAnonymousUser04.png'); ");
		// Click on Submit button
		wd.findElement(By.cssSelector("form.comment-form > p > input#submit"))
				.click();

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForAnonymousUser05.png'); ");

		// // Call method to comment and attach media
		// WordPressSettingsHelper.attachMedia(wd,
		// "This is a test comment by Anonymous", Constants.UPLOADFILE1);
		// Call method to verify the comment text and image
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is a test comment by Anonymous",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a",
						"Image",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li/article/div[1]/div/ul/li/div/a/img",
						Constants.IMAGEATTACHEMENTNAME);
		Thread.sleep(3000);
		// Comment and attach media
		// enter name
		wd.findElement(By.id("author")).click();
		wd.findElement(By.id("author")).clear();
		wd.findElement(By.id("author")).sendKeys("Anonymous");
		System.out.println("Entered Author name");

		// Enter email id
		wd.findElement(By.id("email")).click();
		wd.findElement(By.id("email")).clear();
		wd.findElement(By.id("email")).sendKeys("test@test.com");
		System.out.println("Entered email");

		// Enter Comment
		wd.findElement(By.id("comment")).click();
		wd.findElement(By.id("comment")).clear();
		wd.findElement(By.id("comment")).sendKeys(
				"This is test comment 2 for video attachment by Anonymous");
		System.out.println("Entered Comment");
		// Click on browse to attach the file
		wd.findElement(By.id("rtmedia_simple_file_input")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ Constants.UPLOADVIDEOFILE + "');"
				+ "page.render('./screen/nextprintscreen' + count+'.png');");
		Thread.sleep(5000);

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForAnonymousUser06.png'); ");
		// Click on Submit button
		wd.findElement(By.cssSelector("form.comment-form > p > input#submit"))
				.click();

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForAnonymousUser07.png'); ");
		// // Call method to comment again and upload the video
		// WordPressSettingsHelper.attachMedia(wd,
		// "This is test comment 2 for video attachment by Anonymous",
		// Constants.UPLOADVIDEOFILE);
		// call method to verify comment text present and video is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is test comment 2 for video attachment by Anonymous",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a",
						"Video",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[2]/article/div[1]/div/ul/li/div/a/img",
						Constants.VIDEOATTACHEMENTNAME);
		Thread.sleep(3000);
		// Comment and attach media
		// enter name
		wd.findElement(By.id("author")).click();
		wd.findElement(By.id("author")).clear();
		wd.findElement(By.id("author")).sendKeys("Anonymous");
		System.out.println("Entered Author name");

		// Enter email id
		wd.findElement(By.id("email")).click();
		wd.findElement(By.id("email")).clear();
		wd.findElement(By.id("email")).sendKeys("test@test.com");
		System.out.println("Entered email");

		// Enter Comment
		wd.findElement(By.id("comment")).click();
		wd.findElement(By.id("comment")).clear();
		wd.findElement(By.id("comment")).sendKeys(
				"This is test comment 3 for audio attachment by Anonymous");
		System.out.println("Entered Comment");
		// Click on browse to attach the file
		wd.findElement(By.id("rtmedia_simple_file_input")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ Constants.UPLOADAUDIOFILE + "');"
				+ "page.render('./screen/nextprintscreen' + count+'.png');");
		Thread.sleep(5000);

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForAnonymousUser08.png'); ");
		// Click on Submit button
		wd.findElement(By.cssSelector("form.comment-form > p > input#submit"))
				.click();

		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsTestForAnonymousUser09.png'); ");

		// // Call method to comment again and upload the Audio
		// WordPressSettingsHelper.attachMedia(wd,
		// "This is test comment 3 for audio attachment by Anonymous",
		// Constants.UPLOADAUDIOFILE);

		// call method to verify comment text present and Audio is uploaded
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithThumbnail(
						wd,
						"This is test comment 3 for audio attachment by Anonymous",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a",
						"Audio",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/img",
						Constants.AUDIOATTACHEMENTNAME);
		Thread.sleep(2000);
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
		wd.findElement(By.linkText("Log in")).click();

		Thread.sleep(2000);
		// Open Test Post again
		WordPressSettingsHelper.openPost(wd, "Test Post For Anonymous");
		System.out
				.println("Verifying when whithout thumbnail radio buttion is selected");
		// Verify if comment text present
		WordPressSettingsHelper
				.verfiyCommentAndAttachmentWithoutThumbnail(
						wd,
						"This is a test comment by Anonymous",
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
						"This is test comment 2 for video attachment by Anonymous",
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
						"This is test comment 3 for audio attachment by Anonymous",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a",
						"Audio",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/p",
						"//div[1]/div/div[1]/div/div/ol/li[3]/article/div[1]/div/ul/li/div/a/img",
						Constants.AUDIOATTACHEMENTNAME);
		/*
		 * Constants.logout(wd);// Failing at my end . Unable to find Css
		 * Selector error
		 */
		// log out
		new Actions(wd)
				.moveToElement(
						wd.findElement(By
								.cssSelector("#wp-admin-bar-my-account > a.ab-item")))
				.build().perform();
		wd.findElement(By.linkText("Log Out")).click();

		
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
		*/
		wd.quit();
	}
}
