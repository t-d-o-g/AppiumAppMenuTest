package pageObjects;

import commands.Assertions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static setUpClasses.App.driver;

/**
 * Created by rpalacios on 12/11/15.
 */
public class MastHeadObject{

    @AndroidFindBy(id = "drawer_vertical_list")
    @iOSFindBy (accessibility = "VerticalPickerTableView")
    public static WebElement menuTable;

    @AndroidFindBy(xpath = "//*[@content-desc='Open Drawer']")
    @iOSFindBy(accessibility = "verticalMenuButton")
    public static WebElement hamburgerMenu;

    @AndroidFindBy(id = "toolbar_brand_text")
    @iOSFindBy(accessibility = "verticalLabel")
    public static WebElement verticalLabel;

    public MastHeadObject() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickHamburgerMenu() throws InterruptedException {
        try {
            menuTable.isDisplayed();
        }catch(NoSuchElementException e){
            hamburgerMenu.click();
            Thread.sleep(2000);
        }
    }

    public void isCurrentTitle(String expectedTitle){
        String title = null;

        try{
            MastHeadObject.verticalLabel.isDisplayed();
            title= MastHeadObject.verticalLabel.getText().toLowerCase();
            if(title.equals("home"))
                title = "business insider";
        }catch (Exception e){
            title = "business insider";
        }
        Assertions.assertChar(title,expectedTitle.toLowerCase());
    }
}

