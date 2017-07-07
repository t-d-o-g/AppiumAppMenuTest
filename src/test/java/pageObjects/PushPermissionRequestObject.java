package pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static setUpClasses.App.driver;

/**
 * Created by rpalacios on 6/27/16.
 */
public class PushPermissionRequestObject{

    @AndroidFindBy(id = "news_alerts_enable_alerts_button")
    @iOSFindBy (accessibility = "ENABLE ALERTS")
    public static WebElement enableAlerts;

    public PushPermissionRequestObject() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickEnableAlerts() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            System.out.println("ENABLE ALERT");
            enableAlerts.click();
            driver.switchTo().alert().accept();
        }catch(Exception e){
            if(e.getMessage().contains("Can't locate an element by this strategy")){
                try {
                    wait.until(ExpectedConditions.visibilityOf(enableAlerts));
                    enableAlerts.click();
                    driver.switchTo().alert().accept();
                } catch (TimeoutException i) {
                    i.printStackTrace();
                } catch (NoSuchElementException n){
                    n.printStackTrace();
                }
            }
        }
    }
}
