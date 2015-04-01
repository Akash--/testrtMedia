package testscripts.CustomCSS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class CustomCssTest {
@Test

public static void customcss() throws Exception {
	
	Capabilities caps = new DesiredCapabilities();
	((DesiredCapabilities) caps).setJavascriptEnabled(true);
	((DesiredCapabilities) caps).setCapability("takesScreenshot",true);
	
	PhantomJSDriver wd = new PhantomJSDriver(caps);
	wd.manage().window().setSize(new Dimension (1920, 1080));
	//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	// Login to wordpress by admin account
	wd.get(Constants.WP_SERVER);
	Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
	 System.out.println("Correctly Logged In");
	// Open rtMedia Settings 
	Constants.openrtMediaSettings(wd);
	//Thread.sleep(5000);
	
	
	// Click on rtMedia settings CustomCSS tab
	
	wd.findElement(By.id("tab-rtmedia-custom-css-settings")).click();
	
	wd.findElement(By.id("rtmedia-custom-css")).click();
    wd.findElement(By.id("rtmedia-custom-css")).clear();
    // INSERT CUSTOM CSS IN LINE BELOW
    wd.findElement(By.id("rtmedia-custom-css")).sendKeys("#buddypress #whats-new-options { height: auto !important; overflow: hidden; }");
    wd.findElement(By.id("rtmedia-settings-submit")).click();

	// Do a mouse over on the primary menu on top LHS
    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

    //Click on Visit Site

    wd.findElement(By.linkText("Visit Site")).click();

    //Log out
	Constants.logout(wd);
}
}
