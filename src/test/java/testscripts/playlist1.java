package testscripts;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class playlist1 {
	
    public static void main(String[] args) throws Exception {
        FirefoxDriver wd;
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://sumeetqatester.rtcamp.net/members/admin/media/");
        wd.findElement(By.cssSelector("#wp-admin-bar-bp-login > a.ab-item")).click();
        wd.findElement(By.id("user_login")).click();
        wd.findElement(By.id("user_login")).clear();
        wd.findElement(By.id("user_login")).sendKeys("admin");
        wd.findElement(By.id("loginform")).click();
        wd.findElement(By.id("wp-submit")).click();
        wd.findElement(By.id("rtmedia-nav-item-music")).click();
        wd.findElement(By.cssSelector("h4[title=\"mpthreetest1\"]")).click();
        wd.findElement(By.cssSelector("button[type=\"button\"]")).click();
        wd.findElement(By.cssSelector("button[type=\"button\"]")).click();
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}