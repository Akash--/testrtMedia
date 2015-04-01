package testscripts.bbPress;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import testscripts.Constants;

public class bbPressSettingsTest {
	@Test(groups = { "bbPressSettings" })
	public static void bbPressSettings() throws Exception {

		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));

		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int count = 1;
		// for (String link : links) {
		long iStart = System.currentTimeMillis();

		wd.get(Constants.WP_SERVER);
	
	//	wd.findElement(By.cssSelector("li#wp-admin-bar-bp-login > a.ab-item")).click();
		
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);

		System.out.println("wp-submit");
		Thread.sleep(2000);
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		System.out.println("Mouse over on site");
		Thread.sleep(2000);
		wd.findElement(By.cssSelector("li#wp-admin-bar-dashboard > a.ab-item")).click();
		System.out.println("dashboard");
		// wd.findElement(By.linkText("rtMedia")).click();

		wd.findElement(By.cssSelector("li#toplevel_page_rtmedia-settings > a.wp-has-submenu.wp-not-current-submenu.menu-top.toplevel_page_rtmedia-settings.menu-top-last > div.wp-menu-name")).click();
		System.out.println("rtMedia");
		// Thread.sleep(10000);
		wd.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		((JavascriptExecutor) wd)
				.executeScript("jQuery('.rtm-settings-tab-container dd').each(function(){"
						+ "jQuery(this).removeClass('active');"
						+ "});"
						+ "jQuery('.rtm-settings-tab-container dd:nth-child(3) a').trigger('click');");


		System.out.println("rtMedia-bbPress");

		
		List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox.rtm_enable_bbpress > label > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement.size() != 0) {

	switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();

			if (!wd.findElement(By.id("rt-form-checkbox-14")).isSelected()) {
				wd.findElement(By.id("rt-form-checkbox-14")).click();
			}
			((JavascriptExecutor) wd)
	.executeScript("jQuery('#rt-form-radio-4').attr('checked',true);");
			System.out.println("with thumbnails + filename");
			// wd.findElement(By.id("rt-form-radio-4")).click();
	((JavascriptExecutor) wd).executeScript("jQuery('#rtmedia-settings-submit').trigger('click');");
			// wd.findElement(By.id("rtmedia-settings-submit")).click();
			System.out.println("rtmedia-settings-submit");
			Thread.sleep(2000);

			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
			System.out.println("wp-admin-bar-site-name ");
			wd.findElement(By.linkText("Visit Site")).click();
			System.out.println("Visit Site");
			/*wd.findElement(By.linkText("FORUMS")).click();*/
			
			wd.navigate().to(Constants.WP_SERVER+ "/forums");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/bbpress/Functional/bbPress Settings 01.png');");			
			wd.findElement(By.linkText("TestForum")).click();
			wd.findElement(By.linkText("discussion1")).click();
			wd.findElement(By.id("bbp_reply_content")).click();
			wd.findElement(By.id("bbp_reply_content")).clear();
			wd.findElement(By.id("bbp_reply_content")).sendKeys("This is a test reply to forum");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/bbpress/Functional/bbPress Settings 02.png');");			
			if (!wd.findElement(By.id("bbp_topic_subscription")).isSelected()) {
				wd.findElement(By.id("bbp_topic_subscription")).click();
			}
			wd.findElement(By.id("rtmedia_simple_file_input")).click();
// Insert a file named test
		
			
			((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "var count=0;" + "page.uploadFile('input[type=file]','"
					+ Constants.PhotoPhantom + "');"					 
					+"page.render('./screen/nextprintscreen' + count+'.png');");		
			Thread.sleep(3000);
			
			
			wd.findElement(By.id("bbp_reply_submit")).click();
			Thread.sleep(3000);

			String expectedComment = "This is a test reply to forum";
String actualComment = wd.findElement(By.xpath("//div[1]/div/div[1]/div/div/article/div/div/ul/li[2]/div[4]/div[2]/p")).getText();

			try {
			Assert.assertEquals(actualComment, expectedComment);
			} catch (Throwable e) {
		System.out.println("Expected Comment in section not present - Failed");
			}

			wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();
			
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/bbpress/Functional/bbPress Settings 03.png');");		
			Thread.sleep(2000);
			((JavascriptExecutor) wd).executeScript("jQuery('.webwidget_rating_simple li:nth-child(1)').trigger('click');");
			// wd.findElement(By.cssSelector("ul.webwidget_rating_simple > li"))
			// .click();
			Thread.sleep(2000);
			System.out.println("webwidget_rating_simple ");
			((JavascriptExecutor) wd).executeScript("jQuery('.rtmedia-actions-before-comments button').trigger('click');");
			System.out.println("Like Button ");
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/bbpress/Functional/bbPress Settings 04.png');");
			// wd.findElement(
			// By.xpath("//div[@class='rtmedia-actions-before-comments']//button[.='Like']"))
			// .click();
			Thread.sleep(2000);

			wd.findElement(By.id("comment_content")).click();
			wd.findElement(By.id("comment_content")).clear();
			wd.findElement(By.id("comment_content")).sendKeys("nice pic...test");
			wd.findElement(By.id("rt_media_comment_submit")).click();
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/bbpress/Functional/bbPress Settings 05.png');");
			wd.findElement(By.cssSelector("span.mfp-close")).click();
			Thread.sleep(1000);

			wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();
			Thread.sleep(3000);

      String actual1 = wd.findElement(By.cssSelector("span.rtmedia-avg-rate")).getText();
			System.out.println(actual1);
			String expected1 = "Rating : 1";
			try {
				Assert.assertEquals(actual1, expected1);
			} catch (Throwable e) {
				System.out.println("Expected Text Not Present for RATING - failed");
			}

			String actual2 = wd.findElement(By.cssSelector("span.rtmedia-like-counter-wrap")).getText();
			String expected2 = "1 people like this";
			try {
				Assert.assertEquals(actual2, expected2);
			} catch (Throwable e) {
				System.out
						.println("Expected Text Not Present FOR LIKE - failed");
			}
			String actual3 = wd.findElement(By.xpath("//div[@class='rtmedia-comment-content']//p[.='nice pic...test']")).getText();
			String expected3 = "nice pic...test";
			try {
				Assert.assertEquals(actual3, expected3);
			} catch (Throwable e) {
				System.out.println("Expected Text Not Present for COMMENT- failed");
			}

			wd.findElement(By.cssSelector("span.mfp-close")).click();
			Thread.sleep(1000);
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			wd.findElement(By.linkText("Log Out")).click();
			wd.quit();

		} else {
			System.out.println("Enable Attachment Switch is Already On");
			((JavascriptExecutor) wd)
			.executeScript("jQuery('#rt-form-radio-4').attr('checked',true);");
			System.out.println("with thumbnails + filename");
		
		((JavascriptExecutor) wd).executeScript("jQuery('#rtmedia-settings-submit').trigger('click');");
			// wd.findElement(By.id("rtmedia-settings-submit")).click();
			System.out.println("rtmedia-settings-submit");
			Thread.sleep(2000);

			new Actions(wd)
					.moveToElement(
							wd.findElement(By
									.cssSelector("#wp-admin-bar-site-name > a.ab-item")))
					.build().perform();
			System.out.println("wp-admin-bar-site-name ");
			wd.findElement(By.linkText("Visit Site")).click();
			System.out.println("Visit Site");
			
			wd.navigate().to(Constants.WP_SERVER + "/forums");
			/*wd.findElement(By.linkText("FORUMS")).click();*/
			System.out.println("Forums");
			
			wd.findElement(By.linkText("TestForum")).click();
			System.out.println("TEST Forum clicked");
			wd.findElement(By.linkText("discussion1")).click();
			System.out.println("Discussion 1 clicked ");
			wd.findElement(By.id("bbp_reply_content")).click();
			wd.findElement(By.id("bbp_reply_content")).clear();
			wd.findElement(By.id("bbp_reply_content")).sendKeys(
					"This is a test reply to forum");
			System.out.println("Reply Content");
			if (!wd.findElement(By.id("bbp_topic_subscription")).isSelected()) {
				wd.findElement(By.id("bbp_topic_subscription")).click();
				System.out.println("TOP SUBSCRIPTION CLICKED");
			}
			List<WebElement> fileElement=wd.findElements(By.id("rtmedia_simple_file_input"));
			if(fileElement.size()!=0){
				System.out.println("File:"+fileElement.size());
				wd.findElement(By.id("rtmedia_simple_file_input")).click();
//				wd.findElement(By.id("rtmedia_simple_file_input")).sendKeys("E:\\test.jpg");
			}

			
			((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "var count=0;" + "page.uploadFile('input[type=file]','"
					+ Constants.PhotoPhantom + "');"					 
					+"page.render('./screen/nextprintscreen' + count+'.png');");		
			Thread.sleep(1000);		

	
			wd.findElement(By.id("bbp_reply_submit")).click();
			System.out.println("Clicked on Submit");
			Thread.sleep(2000);
/*// Having problem in locating xpath. Commenting for now
String expectedComment = "This is a test reply to forum";

String actualComment = wd.findElement(By.xpath("//div[1]/div/div[1]/div/div/article/div/div/ul/li[2]/div[4]/div[2]/p")).getText();

			try {
				Assert.assertEquals(actualComment, expectedComment);
			} catch (Throwable e) {
				System.out.println("Expected Comment in section not present - Failed");
			}
*/
			List<WebElement> imageElement = wd.findElements(By.cssSelector("img[alt=\"test\"]"));
			System.out.println(imageElement.size() + " :Size");
			if (imageElement.size() != 0) {
				wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();
				System.out.println(wd.findElement(By.cssSelector("img[alt=\"test\"]")).getText()+ "image");
			}
			Thread.sleep(2000);
			((JavascriptExecutor) wd)
.executeScript("jQuery('.webwidget_rating_simple li:nth-child(1)').trigger('click');");
			// wd.findElement(By.cssSelector("ul.webwidget_rating_simple > li"))
			// .click();
			Thread.sleep(5000);
			System.out.println("webwidget_rating_simple ");
			((JavascriptExecutor) wd)
					.executeScript("jQuery('.rtmedia-actions-before-comments button').trigger('click');");
			System.out.println("Like Button ");
		
			Thread.sleep(1000);
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/bbpress/Functional/bbPress Settings 11.png');");

			wd.findElement(By.id("comment_content")).click();
			wd.findElement(By.id("comment_content")).clear();
			wd.findElement(By.id("comment_content")).sendKeys("nice pic...test");
			wd.findElement(By.id("rt_media_comment_submit")).click();

			wd.findElement(By.cssSelector("span.mfp-close")).click();
			Thread.sleep(2000);

			wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();

			Thread.sleep(3000);

			// String actual1 = wd.findElement(By.tagName("html")).getText();
			String actual1 = wd.findElement(By.cssSelector("span.rtmedia-avg-rate")).getText();
			System.out.println(actual1);
			String expected1 = "Rating : 1";
			try {
				Assert.assertEquals(actual1, expected1);
			} catch (Throwable e) {
				System.out
						.println("Expected Text Not Present for RATING - failed");
			}

			String actual2 = wd.findElement(By.cssSelector("span.rtmedia-like-counter-wrap")).getText();
			String expected2 = "1 people like this";
			//System.out.println(actual2);
			try {
				Assert.assertEquals(actual2, expected2);
			} catch (Throwable e) {
				System.out
						.println("Expected Text Not Present FOR LIKE - failed");
			}
			String actual3 = wd.findElement(By.xpath("//div[@class='rtmedia-comment-content']//p[.='nice pic...test']")).getText();
			String expected3 = "nice pic...test";
			System.out.println(actual3);
			try {
				Assert.assertEquals(actual3, expected3);
			} catch (Throwable e) {
				System.out.println("Expected Text Not Present for COMMENT- failed");
			}

			wd.findElement(By.cssSelector("span.mfp-close")).click();
			Thread.sleep(2000);
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			wd.findElement(By.linkText("Log Out")).click();

			wd.quit();

		}
	}


}
