//author Akash
package testscripts.display;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class NGEnableDownloadForMediaTest {
	
	@Test(groups = { "Display" })
	public static void checkDisableDownloadForMediaTest() throws Exception {
		
		
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
		 
		 Constants.openrtMediaSettings(wd);

		wd.findElement(By.id("tab-rtmedia-types")).click();
		System.out.println("types clicked");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NGdownload btn media Test1.png');");	
		 
		//Thread.sleep(2000);

		List<WebElement> views = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-20\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
		//System.out.println("Views size:" + views.size());
		if (views.size() == 1){

			views.get(0).findElement(By.cssSelector("span.switch-left")).click();
			//((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NG download btn media Test2.png');");	

				
		}
		List<WebElement> views1 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-23\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
		//System.out.println("Views size:" + views.size());
		if (views1.size() == 1){

			views1.get(0).findElement(By.cssSelector("span.switch-left")).click();
			//((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NG download btn media Test2.png');");	

				
		}
		List<WebElement> views2 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-26\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
		//System.out.println("Views size:" + views.size());
		if (views2.size() == 1){

			views2.get(0).findElement(By.cssSelector("span.switch-left")).click();
			//((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NG download btn media Test2.png');");	

				
		}
		
		List<WebElement> views3 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-29\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
		//System.out.println("Views size:" + views.size());
		if (views3.size() == 1){

			views3.get(0).findElement(By.cssSelector("span.switch-left")).click();
			//((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NG download btn media Test2.png');");	

				
		}

		List<WebElement> views4 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-33\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
		//System.out.println("Views size:" + views.size());
		if (views4.size() == 1){

			views4.get(0).findElement(By.cssSelector("span.switch-left")).click();
			//((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NG download btn media Test2.png');");	

				
		}



		
		
		
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
		System.out.println("rtMedia Settings Saved");
		
		
		//Do a mouse over on the primary menu on top LHS
				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		Thread.sleep(1000);

				// Click on Visit Site

				wd.findElement(By.linkText("Visit Site")).click();
				
				
				// Navigate to Media gallery
				
			//  Mouseover  on Profile (Howdy, admin) section , click on Media 

							new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
							Thread.sleep(1000);
							new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
							wd.findElement(By.linkText("Media")).click();
							
							System.out.println("Reached Media Gallery ");			
							Thread.sleep(1500);
							

							((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NG download btn media Test3.png');");
							//clicked on single media...
							
							//Thread.sleep(3000);
							wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-action > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();

							
							System.out.println("clicked on single media");
							
							if(wd.findElements(By.cssSelector("#download-media-form > button.rtmedia-download-media.rtmedia-action-buttons.rtmedia-download")).size() == 0)
							{
								System.out.println("download Button is not present");
								((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NG download btn media Test4.png');");

							}
							else
							{
								
							//wd.findElement(By.cssSelector("#download-media-form > button.rtmedia-download-media.rtmedia-action-buttons.rtmedia-download")).click();;	

							System.out.println("Still download is present");
							//System.out.println("Clicked to download button");
							}
							
                            Constants.logout(wd);
							
							//log in from another user
							
							Capabilities caps2 = new DesiredCapabilities();
							((DesiredCapabilities) caps2).setJavascriptEnabled(true);
							((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);

							PhantomJSDriver wd1 = new PhantomJSDriver(caps2);
							wd1.manage().window().setSize(new Dimension(1920, 1080));
							//wd1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


							// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
							// Login to wordpress by as a TestEditor
									wd.get(Constants.WP_SERVER);
									Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
									 System.out.println("Correctly Logged In from other user");
									 // Navigate to Media gallery
										
									//  Mouseover  on Profile (Howdy,) section , click on Media 

													new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
													Thread.sleep(1000);
													new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
													wd.findElement(By.linkText("Media")).click();
													
													System.out.println("Media Gallery ");			
													Thread.sleep(2000);
													

													((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NGdownload btn media Test5.png');");
													//clicked on single media...
													
													//Thread.sleep(3000);
													wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-3.rtm-pro-allow-action > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();

													
													System.out.println("clicked on single media");
													
													
													if(wd.findElements(By.cssSelector("#download-media-form > button.rtmedia-download-media.rtmedia-action-buttons.rtmedia-download")).size() == 0)
													{
														System.out.println("download Button is not present");
														((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Download/NG/NG download btn media Test6.png');");

													}
													else
													{
														
													//wd.findElement(By.cssSelector("#download-media-form > button.rtmedia-download-media.rtmedia-action-buttons.rtmedia-download")).click();;	

													System.out.println("Still download is present");
													//System.out.println("Clicked to download button");
													
													Constants.logout(wd);
							
							
							
							
	}	
	


	}
}
	
	
	


