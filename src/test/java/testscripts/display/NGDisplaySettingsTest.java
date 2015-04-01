/**
 * @author Juhi
 * @tag This code is for negative test cases of display
 */
package testscripts.display;

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
import org.testng.annotations.Test;

import testscripts.Constants;

public class NGDisplaySettingsTest {
	@Test(groups = { "Display" })
	public static void checkNGDisplaySettings() throws Exception {
		
		 // Login to Wordpress
		// wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// for phantom js
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
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd)
				.moveToElement(
						wd.findElement(By
								.cssSelector("#wp-admin-bar-site-name > a.ab-item")))
				.build().perform();
		// Click on Dashboard
		wd.findElement(By.linkText("Dashboard")).click();
		System.out.println("Dashboard Clicked");
		// Click on rtMedia
		wd.findElement(By.linkText("rtMedia")).click();
		System.out.println("rtMedia Clicked");
		// // Check if the switch in on or off, if its on then switch it off if
		// its
		// // on then proceed
		// List<WebElement> switchElement = wd
		// .findElements(By
		// .cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-0\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
		Thread.sleep(3000);
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Display/displaysetting/NG/nextprintscreenrt.png'); ");
		
//		((PhantomJSDriver) wd).executePhantomJS(
//		 "page.includeJs('http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js', function() {"
// +"   page.evaluate(function() { console.log('before if: ' + page.content);"
// +"if($('#rt-form-checkbox-0').parent().hasClass('switch-off')){"
//						+ "$('#rt-form-checkbox-0').siblings('.switch-left').click();"
//						+ "console.log('Content inside if: ' + page.content);"
//						+ "};"
//  +"  });"
//  +"    }); ");

		((JavascriptExecutor) wd)
				.executeScript("console.log('content out of if');"
						+ "if(jQuery('#rt-form-checkbox-0').parent().hasClass('switch-off')){"
						+ "jQuery('#rt-form-checkbox-0').siblings('.switch-left').click();"
						+ "console.log('content');" + "};");

		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Display/displaysetting/NG/nextprintscreen0.png'); ");
		// if (switchElement.size() != 0) {
		//
		// switchElement.get(0)
		// .findElement(By.cssSelector("span.switch-left")).click();
		//
		// } else
		// System.out
		// .println("'Allow user to comment on uploaded media' is already off");

		// //Disable Likes for Media
		// List<WebElement> likesElement = wd
		// .findElements(By
		// .cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-1\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
		//
		// if (likesElement.size() != 0) {
		//
		// likesElement.get(0)
		// .findElement(By.cssSelector("span.switch-left")).click();
		//
		// } else
		// System.out
		// .println("'Enable likes for media ' is already off");
		//
		// //Disable Star Rating for Media
		// List<WebElement> ratingElement = wd
		// .findElements(By
		// .cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-2\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
		//
		// if (ratingElement.size() != 0) {
		//
		// ratingElement.get(0)
		// .findElement(By.cssSelector("span.switch-left")).click();
		//
		// } else
		// System.out
		// .println("'Enable 5 star rating for media ' is already off");
		// // Switch on the lightbox if it is off
		// // Check if the switch in on or off, if its on then switch it off if
		// its
		// // on then proceed
		List<WebElement> lightboxElement = wd
				.findElements(By
						.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-6\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		//
		System.out.println("lightbox size:" + lightboxElement.size());
		if (lightboxElement.size() != 0) {

			lightboxElement.get(0)
					.findElement(By.cssSelector("span.switch-right")).click();

		} else
			System.out
					.println("'Use lightbox to display media ' is already on");
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "

		+ "page.render('./screen/Display/displaysetting/NG/nextprintscreen1.png'); ");
		// Save settings
		// save the wordpress settings Form
		((JavascriptExecutor) wd)
				.executeScript("jQuery('#rtmedia-settings-submit').trigger('click');");
		// System.out.println("Switched to ON");
		Thread.sleep(2000);

		// Do a mouse over on the primary menu on top LHS
		new Actions(wd)
				.moveToElement(
						wd.findElement(By
								.cssSelector("#wp-admin-bar-site-name > a.ab-item")))
				.build().perform();
		// Click on Visit Site
		wd.findElement(By.linkText("Visit Site")).click();
		// Reach forums
		/*wd.findElement(By.linkText("FORUMS")).click();*/
		wd.navigate().to(Constants.WP_SERVER + "/forums");
		// Click on forum called testforum
		wd.findElement(By.linkText("TestForum")).click();
		// Click on a discussion called discussion1
		wd.findElement(By.linkText("discussion1")).click();
		// Click on Reply
		wd.findElement(By.id("bbp_reply_content")).click();
		wd.findElement(By.id("bbp_reply_content")).clear();

		// Add input to the reply field
		wd.findElement(By.id("bbp_reply_content")).sendKeys(
				"This is a test for negative display settings ");
		System.out.println("Comment Posted");

		// Click on Subscribe
		if (!wd.findElement(By.id("bbp_topic_subscription")).isSelected()) {
			wd.findElement(By.id("bbp_topic_subscription")).click();
		}

		// Upload Media
		wd.findElement(By.id("rtmedia_simple_file_input")).click();
		Thread.sleep(3000);
		/*((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.uploadFile('input[type=file]', 'E:/test.jpg');"
				+ "page.render('./screen/nextprintscreen2.png');");*/
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ Constants.PhotoPhantom + "');"					 
				+"page.render('/screen/Display/displaysetting/NG/nextprintscreen2.png');");

		
		// Runtime.getRuntime().exec(Constants.UPLOADFILE);
		Thread.sleep(3000);
		wd.findElement(By.id("bbp_reply_submit")).click();
		Thread.sleep(3000);
		System.out.println("Media uploaded");
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Display/displaysetting/NG/nextprintscreen3.png'); ");
		// // Verify if text is present
		// String expectedComment =
		// "This is a test for Media Comment display on bbPress";
		// String actualComment = wd
		// .findElement(
		// By.xpath("//div[1]/div/div[1]/div/div/article/div/div/ul/li[2]/div[4]/div[2]/p"))
		// .getText();
		//
		// try {
		// Assert.assertEquals(actualComment, expectedComment);
		// System.out.println("Comment found");
		// } catch (Throwable e) {
		// System.out
		// .println("Expected Comment in section not present - Failed");
		// }

		// Click on uploaded media to open it in Lightbox
		wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();
		Thread.sleep(5000);
		((JavascriptExecutor) wd)
				.executeScript("jQuery('#comment_content').attr('placeholder','nice pic...test for negative display');");

		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/Display/displaysetting/NG/nextprintscreen4.png'); ");
		// wd.findElement(By.id("comment_content")).click();
		// wd.findElement(By.id("comment_content")).clear();
		// wd.findElement(By.id("comment_content"))
		// .sendKeys("nice pic...test for negative display");
		// //Check for rating
		// boolean flag=false;
		// if(wd.findElements(By.cssSelector("div.rtmedia-pro-rating")).size()
		// == 0){
		// System.out.println("Rating is disabled");
		// Reporter.log("Rating is disabled");
		// flag=true;
		// } else {
		// System.out.println("Rating field is enabled");
		// Reporter.log("Rating field is enabled");
		// flag=false;
		// }
		// Assert.assertEquals(flag, true,"Rating field is enabled");
		//
		// flag =false;
		// if ((wd.findElements(By.id("comment_content")).size() == 0)) {
		// System.out.println("Comment field is disabled");
		// Reporter.log("Comment field is disabled");
		// flag=true;
		// } else {
		// System.out.println("Comment field is enabled");
		// Reporter.log("Comment field is enabled");
		// flag=false;
		// }
		// Assert.assertEquals(flag, true,"Comment field is enabled");
		//
		// //Check for Like
		// flag =false;
		// if
		// ((wd.findElements(By.cssSelector("button.rtmedia-like.rtmedia-action-buttons.button")).size()
		// == 0)) {
		// System.out.println("Like field is disabled");
		// Reporter.log("Like field is disabled");
		// flag=true;
		// } else {
		// System.out.println("Like field is enabled");
		// Reporter.log("Like field is enabled");
		// flag=false;
		// }
		// Assert.assertEquals(flag, true,"Like field is enabled");

		wd.close();

	}
}
