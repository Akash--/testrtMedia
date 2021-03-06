//@Akash
package testscripts.imagesizes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class VideoSinglePlayerTest {
	@Test(groups = { "Imagesizes" })
	public static void checkVideoHeightWidth() throws Exception
	{

			Capabilities caps = new DesiredCapabilities();
			((DesiredCapabilities) caps).setJavascriptEnabled(true);
			((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

			PhantomJSDriver wd;
			wd = new PhantomJSDriver(caps);
			wd.manage().window().setSize(new Dimension(1920, 1080));

			//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			wd.get(Constants.WP_SERVER);
			Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
			 System.out.println("Correctly Logged In");
			 
			 Constants.openrtMediaSettings(wd);
			 
			 wd.findElement(By.id("tab-rtmedia-sizes")).click();
			 wd.findElement(By.id("rt-form-text-9")).clear();
			 // the i variable is used for width
			 int i=300;
			 String a1=String.valueOf(i);
			 wd.findElement(By.id("rt-form-text-9")).sendKeys(a1);
			 wd.findElement(By.id("rt-form-text-10")).clear();
			 // the j variable is used for height
			 int j=250;
			 String a2=String.valueOf(j);
			 wd.findElement(By.id("rt-form-text-10")).sendKeys(a2);
			 Thread.sleep(1500);
			 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Video/Functional/VideoSinglePlayer Test1.png');");
			 
			 wd.findElement(By.id("rtmedia-settings-submit")).click();
			 System.out.println("setting saved");
			 
			//Do a mouse over on the primary menu on top LHS
				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		Thread.sleep(1000);

				// Click on Visit Site

				wd.findElement(By.linkText("Visit Site")).click();
				

			 
			 
			 new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a"))).build().perform();
				Thread.sleep(1000);
				new Actions(wd).moveToElement(wd.findElement(By.linkText("Media"))).build().perform();
			Thread.sleep(1000);
		
				wd.findElement(By.linkText("Videos")).click();
				Thread.sleep(2000);
				
				
				System.out.println("reached Videos");
				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Video/Functional/VideoSinglePlayer Test11.png');");

				wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
					+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();
				Thread.sleep(2000);
			    int h=	wd.findElement(By.id("rtm-mejs-video-container")).getSize().getHeight();
			    Thread.sleep(2000);
				String a=String.valueOf(h);
				System.out.println("Height is"+a);
			
				
				
				int w=	wd.findElement(By.id("rtm-mejs-video-container")).getSize().getWidth();
				String b=String.valueOf(w);
		
				System.out.println("Width is"+b);
				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Video/Functional/VideoSinglePlayer Test2.png');");

				if(h==j && w==i)
				{
					System.out.println("set value for Photo's Height and width are equal");
				}
				else
				{
					System.out.println("set value for Photo's Height and Width are not equal");
				}
				
				Constants.logout(wd);
				//Login from another user
				
				Capabilities caps2 = new DesiredCapabilities();
				((DesiredCapabilities) caps2).setJavascriptEnabled(true);
				((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);

				PhantomJSDriver wd1 = new PhantomJSDriver(caps2);
				wd1.manage().window().setSize(new Dimension(1920, 1080));
				wd1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


			    // Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
				// Login to wordpress by as a TestEditor
				wd.get(Constants.WP_SERVER);
				Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
				System.out.println("Correctly Logged In from other user");
				 new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a"))).build().perform();
					Thread.sleep(1000);
					new Actions(wd).moveToElement(wd.findElement(By.linkText("Media"))).build().perform();
				Thread.sleep(1000);
			
					wd.findElement(By.linkText("Videos")).click();
					Thread.sleep(2000);
					
					
					System.out.println("reached Videos");
					wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-3.rtm-pro-allow-act"
					+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();
					
				    int h1=	wd.findElement(By.id("rtm-mejs-video-container")).getSize().getHeight();
				    Thread.sleep(2000);
					String a11=String.valueOf(h1);
					System.out.println("Height is"+a11);
				
					
					
					int w1=	wd.findElement(By.id("rtm-mejs-video-container")).getSize().getWidth();
					String b1=String.valueOf(w1);
			
					System.out.println("Width is"+b1);
					 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Video/Functional/VideoSinglePlayer Test3.png');");

					if(h1==j && w1==i)
					{
						System.out.println("set value for Video's Height and width are equal");
					}
					else
					{
						System.out.println("set value for Video's Height and Width are not equal");
					}
				
				    Constants.logout(wd);
				 
				
		}

		
		
		
	}


