package pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static setUpClasses.App.driver;

/**
 * Created by khadijaislam on 3/17/16.
 */
public class MenuObject {

    @AndroidFindBy(id = "drawer_list_item_function_text")
    @iOSFindBy(accessibility = "vpc_Saved Articles")
    public static WebElement savedArticles;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HOME']")
    @iOSFindBy(accessibility = "vpc_HOME")
    public static WebElement home;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Latest']")
    @iOSFindBy(accessibility = "vpc_Latest")
    public static WebElement latest;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TECH INSIDER']")
    @iOSFindBy(accessibility = "vpc_TECH INSIDER")
    public static WebElement techInsider;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enterprise']")
    @iOSFindBy(accessibility = "vpc_Enterprise")
    public static WebElement enterprise;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Science']")
    @iOSFindBy(accessibility = "vpc_Science")
    public static WebElement science;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Advertising']")
    @iOSFindBy(accessibility = "vpc_Advertising")
    public static WebElement advertising;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Media']")
    @iOSFindBy(accessibility = "vpc_Media")
    public static WebElement media;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Entertainment']")
    @iOSFindBy(accessibility = "vpc_Entertainment")
    public static WebElement entertainment;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Transportation']")
    @iOSFindBy(accessibility = "vpc_Transportation")
    public static WebElement transportation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FINANCE']")
    @iOSFindBy(accessibility = "vpc_FINANCE")
    public static WebElement finance;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Markets']")
    @iOSFindBy(accessibility = "vpc_Markets")
    public static WebElement markets;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Retail']")
    @iOSFindBy(accessibility = "vpc_Retail")
    public static WebElement retail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wealth Advisor']")
    @iOSFindBy(accessibility = "vpc_Wealth Advisor")
    public static WebElement wealthAdvisor;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your Money']")
    @iOSFindBy(accessibility = "vpc_Your Money")
    public static WebElement yourMoney;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='POLITICS']")
    @iOSFindBy(accessibility = "vpc_POLITICS")
    public static WebElement politics;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Military & Defense']")
    @iOSFindBy(accessibility = "vpc_Military & Defense")
    public static WebElement militaryDefense;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='News']")
    @iOSFindBy(accessibility = "vpc_News")
    public static WebElement news;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='STRATEGY']")
    @iOSFindBy(accessibility = "vpc_STRATEGY")
    public static WebElement strategy;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Careers']")
    @iOSFindBy(accessibility = "vpc_Careers")
    public static WebElement careers;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    @iOSFindBy(accessibility = "vpc_Education")
    public static WebElement education;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Small Business']")
    @iOSFindBy(accessibility = "vpc_Small Business")
    public static WebElement smallBusiness;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Lists']")
    @iOSFindBy(accessibility = "vpc_Lists")
    public static WebElement lists;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LIFE']")
    @iOSFindBy(accessibility = "vpc_LIFE")
    public static WebElement life;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Travel']")
    @iOSFindBy(accessibility = "vpc_Travel")
    public static WebElement travel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SPORTS']")
    @iOSFindBy(accessibility = "vpc_SPORTS")
    public static WebElement sports;

    @iOSFindBy(accessibility = "vpc_Legal Fine Print")
    public static WebElement legalFinePrint;

    @iOSFindBy(accessibility = "vpc_Send Feedback")
    public static WebElement sendFeedback;

    public MenuObject() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public static WebElement verticalElement(String vertical) throws InterruptedException {
        WebElement el = null;
        switch (vertical.toLowerCase()){
            case "saved articles":{ el = savedArticles; break; }
            case "home":{ el = home; break; }
            case "latest":{ el = latest; break; }
            case "tech insider":{ el = techInsider; break; }
            case "enterprise":{ el = enterprise; break; }
            case "science":{ el = science; break; }
            case "advertising":{ el = advertising; break; }
            case "media":{ el = media; break; }
            case "entertainment":{ el = entertainment; break; }
            case "transportation":{ el = transportation; break; }
            case "finance":{ el = finance; break; }
            case "markets":{ el = markets; break; }
            case "retail":{ el = retail; break; }
            case "wealth advisor":{ el = wealthAdvisor; break; }
            case "your money":{ el = yourMoney; break; }
            case "politics":{ el = politics; break; }
            case "military & defense":{ el = militaryDefense; break; }
            case "news":{ el = news; break; }
            case "strategy":{ el = strategy; break; }
            case "careers":{ el = careers; break; }
            case "education":{ el = education; break; }
            case "small business":{ el = smallBusiness; break; }
            case "lists":{ el = lists; break; }
            case "life":{ el = life; break; }
            case "travel":{ el = travel; break; }
            case "sports":{ el = sports; break; }
            case "legal fine print":{ el = legalFinePrint; break; }
            case "send feedback":{ el = sendFeedback; break; }
        }
        return el;
    }
}
