/*Author Akash*/

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

public class PhotoHeightWidthLargeTest {
	@Test(groups = { "Imagesizes" })
	public static void checkPhotoHeightWidthLargeTest() throws Exception
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
		 wd.findElement(By.id("rt-form-text-5")).clear();
		 int i=300;
		 String a1=String.valueOf(i);
		 wd.findElement(By.id("rt-form-text-5")).sendKeys(a1);
		 wd.findElement(By.id("rt-form-text-6")).clear();
		 int j=300;
		 String a2=String.valueOf(j);
		 wd.findElement(By.id("rt-form-text-6")).sendKeys(a2);
		 
		 Thread.sleep(1500);
		 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Photo/Large/Functional/photoheightwidth Test1.png');");
		 
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
                System.out.println("reached Media");
               
                wd.findElement(By.linkText("Photos")).click();
                System.out.println("Photos");
			//wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();

			wd.findElement(By.id("rtm_show_upload_ui")).click();
			Thread.sleep(2000);
			wd.findElement(By.id("rtMedia-upload-button")).click();
			
		
			((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "var count=0;" + "page.uploadFile('input[type=file]','"
					+ Constants.PhotoPhantom + "');"					 
					+"page.render('./screen/Image Sizes/Photo/Large/Functional/photoheightwidth upload Test.png');");
			Thread.sleep(2000); 
			//Thread.sleep(2000);
			wd.findElement(By.id("rtmedia_upload_terms_conditions")).click();
			
			wd.findElement(By.cssSelector("#drag-drop-area > input")).click();
			Thread.sleep(4000);
			 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Photo/Large/Functional/photoheightwidth Test11.png');");
            wd.navigate().refresh();
            Thread.sleep(2000);
			wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
			+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();
			       
			Thread.sleep(2000);
		    int h=	wd.findElement(By.cssSelector("#rtmedia-single-media-container > div.rtmedia-media > img")).getSize().getHeight();
		    //Thread.sleep(2000);
			String a=String.valueOf(h);
			System.out.println("Height is"+a);
		
			
			
			int w=	wd.findElement(By.cssSelector("#rtmedia-single-media-container > div.rtmedia-media > img")).getSize().getWidth();
			String b=String.valueOf(w);
	
			System.out.println("Width is"+b);
			 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Photo/Large/Functional/photoheightwidth Test2.png');");

			if(h==i && w==j)
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
			//wd1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		    // Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
			// Login to wordpress by as a TestEditor
			wd.get(Constants.WP_SERVER);
			Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
			System.out.println("Correctly Logged In from other user");
			 new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a"))).build().perform();
				//Thread.sleep(1000);

		     new Actions(wd).moveToElement(wd.findElement(By.linkText("Media"))).build().perform();
				//wd.findElement(By.linkText("Media")).click();
				Thread.sleep(1000);
				
				
				System.out.println("reached Media");
				
				wd.findElement(By.linkText("Photos")).click();
				
			     System.out.println("Photos");
			     
			     Thread.sleep(2000);
				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Photo/Large/Functional/photoheightwidth Test3.png');");

				wd.findElement(By.id("rtm_show_upload_ui")).click();
				Thread.sleep(2000);
				wd.findElement(By.id("rtMedia-upload-button")).click();
				
			
				((PhantomJSDriver) wd).executePhantomJS("var page=this; "
						+ "var count=0;" + "page.uploadFile('input[type=file]','"
						+ Constants.PhotoPhantom + "');"					 
						+"page.render('./screen/Image Sizes/Photo/Large/Functional/photoheightwidth upload11 Test.png');");
				Thread.sleep(4000); 
				//Thread.sleep(2000);
				wd.findElement(By.id("rtmedia_upload_terms_conditions")).click();
				wd.findElement(By.className("start-media-upload")).click();
				Thread.sleep(4000);
				
				wd.navigate().refresh();
				Thread.sleep(2000);
				
			  wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-3.rtm-pro-allow-act"
			+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();
				Thread.sleep(2000);
			    int h1=	wd.findElement(By.cssSelector("#rtmedia-single-media-container > div.rtmedia-media > img")).getSize().getHeight();
			   // Thread.sleep(2000);
				String a11=String.valueOf(h1);
				System.out.println("Height is"+a11);
			
				int w1=	wd.findElement(By.cssSelector("#rtmedia-single-media-container > div.rtmedia-media > img")).getSize().getWidth();
				String b1=String.valueOf(w1);
		
				System.out.println("Width is"+b1);
				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Photo/Large/Functional/photoheightwidth Test3.png');");

				if(h1==i && w1==j)
				{
					System.out.println("set value for Photo's Height and width are equal");
				}
				else
				{
					System.out.println("set value for Photo's Height and Width are not equal");
				}
			
			    Constants.logout(wd);
			 

		
	}
	
	
	

}
