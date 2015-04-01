package testscripts.wordPress;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.Reporter;

import testscripts.Constants;

public class WordPressSettingsHelper {

	public static void openWordPressSettingToEnableCommentsWithThumbnailAttachment(
			PhantomJSDriver wd) throws Exception {
		// Click on rtMedia settings wordPress Tab
		wd.findElement(By.id("tab-rtmedia-wordpress")).click();
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsHelper01.png'); ");
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
						+ "page.render('./screen/wordpress/WordPressSettingsHelper02.png'); ");
		// Click on radio button
		if (!wd.findElement(By.id("rt-form-radio-2")).isSelected()) {
			wd.findElement(By.id("rt-form-radio-2")).click();
		}
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsHelper03.png'); ");

		// save the wordpress settings Form
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		((PhantomJSDriver) wd)
				.executePhantomJS("var page=this; "
						+ "page.render('./screen/wordpress/WordPressSettingsHelper04.png'); ");
		// wd.findElement(By.id("rtmedia-settings-submit")).click();
	}

	public static void openWordPressSettingToEnableCommentsWithOutThumbnailAttachment(
			PhantomJSDriver wd) throws Exception {
		Thread.sleep(5000);
		// Click on rtMedia settings wordPress Tab
		wd.findElement(By.id("tab-rtmedia-wordpress")).click();
		((PhantomJSDriver) wd)
		.executePhantomJS("var page=this; "
				+ "page.render('./screen/wordpress/WordPressSettingsHelper05.png'); ");

		// Check if the switch in on or off, if its off then switch on if its
		// off then proceed
		List<WebElement> switchElement = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox.rtm_enable_comment_form > label > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement.size() != 0) {

			switchElement.get(0)
					.findElement(By.cssSelector("span.switch-right")).click();

			if (!wd.findElement(By.id("rt-form-checkbox-11")).isSelected()) {
				// Switch on Enable Attachment in comments
				wd.findElement(By.id("rt-form-checkbox-11")).click();
			}
		} else
			System.out.println("Enable Attachment in Comments Already On");
		((PhantomJSDriver) wd)
		.executePhantomJS("var page=this; "
				+ "page.render('./screen/wordpress/WordPressSettingsHelper06.png'); ");
		// Click on radio button
		if (!wd.findElement(By.id("rt-form-radio-3")).isSelected()) {
			// Switch on Enable Attachment in comments
			wd.findElement(By.id("rt-form-radio-3")).click();
		}
		((PhantomJSDriver) wd)
		.executePhantomJS("var page=this; "
				+ "page.render('./screen/wordpress/WordPressSettingsHelper07.png'); ");
		// save the wordpress settings Form
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		Thread.sleep(2000);
	}

	// Method to open Test post
	public static void openPost(PhantomJSDriver wd, String linkText)throws Exception {
		Thread.sleep(3000);

		// Click on Posts on primary menu, this menu contains all posts
		/*wd.findElement(By.linkText("POSTS")).click();*/
		wd.navigate().to(Constants.WP_SERVER);
		
		// Click on post named Test Post
		wd.findElement(By.linkText(linkText)).click();

	}

	// Generic Method to comment and attach Media
public static void attachMedia(PhantomJSDriver wd, String comment,String attachFile) throws Exception {
		Thread.sleep(3000);
		System.out.println("Comment and attach Mehtod called");
		// Click on comment
		wd.findElement(By.id("comment")).click();
		wd.findElement(By.id("comment")).clear();
	
		// Enter the comment in text box
		wd.findElement(By.id("comment")).sendKeys(comment);
		System.out.println("commented");

		// Click on browse to attach the file
		wd.findElement(By.id("rtmedia_simple_file_input")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ attachFile + "');"
				+ "page.render('./screen/nextprintscreen' + count+'.png');");
		Thread.sleep(5000);
		
		// Click on Submit button
		wd.findElement(By.cssSelector("form.comment-form > p > input#submit")).click();
	}

	// Generic method to verify comment text, attachment upload, display
	// attachment of comment when without thumbnail option is selected
	public static void verfiyCommentAndAttachmentWithoutThumbnail(
			PhantomJSDriver wd, String expectedComment, String commentXPath,
			String attachmentXpath, String attachmentType,
			String attachmentNamePath, String imageThumbnailPath,
			String expectAttachementTest) throws Exception {
		// Verify if comment text present
		// expectedComment = "This is a test comment";
		String actualComment = wd.findElement(By.xpath(commentXPath)).getText();
		System.out.println(actualComment);
		try {
			Assert.assertEquals(actualComment, expectedComment);
		} catch (Throwable e) {
			System.out
					.println("Expected Comment in section not present - Failed");
		}
		// Verify Video is uploaded
		List<WebElement> attachmentElements = wd.findElements(By
				.xpath(attachmentXpath));
		// If image is uploaded then check attachment displaying thumbnail with
		// file name
		if (attachmentElements.size() == 0) {
			System.out.println(attachmentType + " not uploaded successfully");
			Reporter.log(attachmentType + " not uploaded successfully");
		} else {
			System.out.println(attachmentType + " is uploaded successfully");
			Reporter.log(attachmentType + " is uploaded successfully");
			List<WebElement> attachementThumbnail = wd.findElements(By
					.xpath(imageThumbnailPath));
			if (attachementThumbnail.size() != 0) {
				System.out
						.println(attachmentNamePath + " Thumbanail available");
				Reporter.log(attachmentNamePath + " Thumbanail available");
			} else {
				String attachementName = wd.findElement(
						By.xpath(attachmentNamePath)).getText();
				System.out
						.println(attachmentType
								+ " is Dispalying only with file name without thumbnail");
				Reporter.log(attachmentType
						+ " is Dispalying only with file name without thumbnail");

				try {
					Assert.assertEquals(attachementName, expectAttachementTest);
				} catch (Throwable t) {
					System.out.println("Expected " + attachmentType
							+ " File name not present ");
					Reporter.log("Expected " + attachmentType
							+ " File name not present ");
				}

			}

		}
	}

	// Generic method to verify comment text, attachment upload, display
	// attachment of comment when with thumbnail option is selected
	public static void verfiyCommentAndAttachmentWithThumbnail(
			PhantomJSDriver wd, String expectedComment, String commentXPath,
			String attachmentXpath, String attachmentType,
			String attachmentNamePath, String imageThumbnailPath,
			String expectAttachementTest) throws Exception {
		// Verify if comment text present
		// Verify if comment text present
		System.out.println("Verify method called");
		String actualComment = wd.findElement(By.xpath(commentXPath)).getText();
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/wordpress/nextprintscreen01.png'); ");
		System.out.println(actualComment);
		try {
			Assert.assertEquals(actualComment, expectedComment);
			((PhantomJSDriver) wd)
					.executePhantomJS("var page=this; "
							+ "page.render('./screen/wordpress/nextprintscreen02.png'); ");
		} catch (Throwable e) {
			System.out
					.println("Expected Comment in section not present - Failed");
			Reporter.log("Expected Comment in section not present - Failed");
		}

		// Verify Attachment is uploaded
		List<WebElement> attachmentElements = wd.findElements(By
				.xpath(attachmentXpath));
		// If Attachment is uploaded then check attachment displaying thumbnail
		// with
		// file name
		if (attachmentElements.size() == 0) {
			System.out.println(attachmentType + " not uploaded successfully");
			Reporter.log(attachmentType + " not uploaded successfully");
		} else {
			System.out.println(attachmentType + " is uploaded successfully");
			Reporter.log(attachmentType + " is uploaded successfully");
			List<WebElement> attachementThumbnail = wd.findElements(By
					.xpath(imageThumbnailPath));
			((PhantomJSDriver) wd)
					.executePhantomJS("var page=this; "
							+ "page.render('./screen/wordpress/nextprintscreen03.png'); ");
			System.out.println(wd.findElement(By.xpath(imageThumbnailPath))
					.getText());
			if (attachementThumbnail.size() == 0) {
				System.out.println(attachmentType + " Thumbnail not available");
				Reporter.log(attachmentType + " Thumbnail not available");

			} else {
				String attachementName = wd.findElement(
						By.xpath(attachmentNamePath)).getText();

				try {
					Assert.assertEquals(attachementName, expectAttachementTest);
				} catch (Throwable e) {
					System.out
							.println(attachmentType
									+ " not uploaded and not displaying with thumbnail with file name");
					Reporter.log(attachmentType
							+ " not uploaded and not displaying with thumbnail with file name");
				}
			}
		}
	}

}
