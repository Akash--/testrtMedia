package testscripts.imagesizes;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class FeaturedDefaultImageTest {
	@Test(groups = { "Imagesizes" })
	public static void checkFeaturedDefault() throws Exception
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
		 
		    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
			Thread.sleep(2000);
			// Click on Dashboard
			wd.findElement(By.linkText("Dashboard")).click();
			Thread.sleep(1000);
			wd.findElement(By.cssSelector("#menu-appearance > a > div.wp-menu-name")).click();
			   new Actions(wd).doubleClick(wd.findElement(By.cssSelector("#menu-appearance > ul.wp-submenu.wp-submenu-wrap > li.wp-first-item > a.wp-first-item"))).build().perform();
			   wd.findElement(By.cssSelector("#menu-appearance > ul.wp-submenu.wp-submenu-wrap > li.wp-first-item > a.wp-first-item")).click();
			   wd.findElement(By.id("inspirebook-action")).click();
				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Featured/Functional/Featured Test1.png');");
				 if(wd.findElement(By.cssSelector("#wpbody-content > div.wrap > div.theme-overlay > div > div.theme-wrap > div.theme-actions > div.inactive-theme > a.button.button-secondary.activate")).isDisplayed())
					 	{
					 		new Actions(wd).doubleClick(wd.findElement(By.cssSelector("#wpbody-content > div.wrap > div.theme-overlay > div > div.theme-wrap > div.theme-actions > div.inactive-theme > a.button.button-secondary.activate"))).build().perform();
					 		System.out.println("inspire theme is activited");
					 	}		   
		        
				 else{
					 System.out.println("Inspire is already activated");
				 	}
				 
				 
				 //go to the
				 new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
					Thread.sleep(1000);
				 
		      //  new Actions(wd).doubleClick(wd.findElement(By.linkText("Visit Site"))).build().perform();
		      

	    			// Click on Visit Site

	    			wd.findElement(By.linkText("Visit Site")).click();
	    		
	      //  wd.findElement(By.xpath("//div[@class='themes']/div[3]/div[3]/a[1]")).click();
	       
		 
		 Constants.openrtMediaSettings(wd);
		 
		 wd.findElement(By.id("tab-rtmedia-sizes")).click();
		 wd.findElement(By.id("rt-form-text-13")).clear();
		 // the i variable is used for width
		 int i=200;
		 String a1=String.valueOf(i);
		 wd.findElement(By.id("rt-form-text-13")).sendKeys(a1);
		 wd.findElement(By.id("rt-form-text-14")).click();
		 wd.findElement(By.id("rt-form-text-14")).clear();
		 // the j variable is used for height
		 int j=200;
		 
		 String a2=String.valueOf(j);
		 wd.findElement(By.id("rt-form-text-14")).sendKeys(a2);
		/* int s=wd.findElements(By.id("rt-form-checkbox-32")).size();
		 System.out.println(s);
		*/ if (!wd.findElement(By.id("rt-form-checkbox-37")).isSelected())
		 {
		 wd.findElement(By.id("rt-form-checkbox-37")).click();
		 }
		 Thread.sleep(1500);
		 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Featured/Functional/Featured Test2.png');");
		 
		 wd.findElement(By.id("rtmedia-settings-submit")).click();
		 System.out.println("setting saved");
		 
		//Do a mouse over on the primary menu on top LHS
		/*	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
	Thread.sleep(1000);

			// Click on Visit Site

			wd.findElement(By.linkText("Visit Site")).click();
			
			
			Thread.sleep(2000);
			
	*/		
		 	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		 	Thread.sleep(2000);
		 	
		 	wd.findElement(By.cssSelector("#wp-admin-bar-my-account-activity > a.ab-item")).click();
			  Thread.sleep(2000);
			  
			
			  
			  
		/*	  Dimension elementDimensions = wd.findElement(By.cssSelector("#item-header > div > figure > div > a > img")).getSize();

			  System.out.println(elementDimensions.getHeight());

			  elementDimensions.getWidth();

			  */
			
		       int height= wd.findElement(By.cssSelector("#item-header > div > figure > div > a > img")).getSize().getHeight();
		      
		       System.out.println("height is:"+height);
		       int width=wd.findElement(By.cssSelector("#item-header > div > figure > div > a > img")).getSize().getWidth();

		       System.out.println("width is:"+width);
			if (i==width && j==height)
			{
				System.out.println("Test Pass: set values from backend are equal");
			}
			else{
				System.out.println("Test Fail: set values from backend are not equal");
			}
			
			
			
			   new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
				Thread.sleep(2000);
				// Click on Dashboard
				wd.findElement(By.linkText("Dashboard")).click();
				Thread.sleep(1000);
				wd.findElement(By.cssSelector("#menu-appearance > a > div.wp-menu-name")).click();
				   new Actions(wd).doubleClick(wd.findElement(By.cssSelector("#menu-appearance > ul.wp-submenu.wp-submenu-wrap > li.wp-first-item > a.wp-first-item"))).build().perform();
				   wd.findElement(By.cssSelector("#menu-appearance > ul.wp-submenu.wp-submenu-wrap > li.wp-first-item > a.wp-first-item")).click();
				   wd.findElement(By.id("twentyfourteen-action")).click();
					 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Image Sizes/Featured/Functional/Featured Test3.png');");
					 if(wd.findElement(By.cssSelector("#wpbody-content > div.wrap > div.theme-overlay > div > div.theme-wrap > div.theme-actions > div.inactive-theme > a.button.button-secondary.activate")).isDisplayed())
						 	{
						 		new Actions(wd).doubleClick(wd.findElement(By.cssSelector("#wpbody-content > div.wrap > div.theme-overlay > div > div.theme-wrap > div.theme-actions > div.inactive-theme > a.button.button-secondary.activate"))).build().perform();
						 		System.out.println("Twenty Fourteen theme is activited");
						 	}		   
			        
					 else{
						 System.out.println("Twenty Fourteen is alredy activated");
					 	}
					 

				/*	 new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
						Thread.sleep(2000);

								// Click on Visit Site

								wd.findElement(By.linkText("Visit Site")).click();
								
*/					 new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
				//	 wd.findElement(By.cssSelector("#wp-admin-bar-my-account-activity > a.ab-item")).click();
					 wd.findElement(By.linkText("Log Out")).click();
			
			
		      
		 

	}
	
	
	

}
