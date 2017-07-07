package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.MastHeadObject;
import pageObjects.MenuObject;

import static commands.Window.scrollToElement;
import static pageObjects.MenuObject.verticalElement;

/**
 * Created by rpalacios on 11/13/15.
 */
public class AppMenu {

    MastHeadObject mastHead = new MastHeadObject();
    MenuObject verticals = new MenuObject();

    @Given("^Hamburger menu is open$")
    public void hamburger_menu_is_open() throws Throwable {
        System.out.println("HAMBURGER MENU IS OPEN");
        mastHead.clickHamburgerMenu();
    }

    // Works but is very slow
    @When("^I click (.*) option$")
    public void i_click_vertical(String arg) throws Throwable {
        System.out.println("I CLICK VERTICAL " + arg);
        scrollToElement(verticalElement(arg));
        verticalElement(arg).click();
    }

    /*
    // Doesn't automatically scroll to element like XCUITest
    @When("^I click (.*) option$")
    public void i_click_vertical(String arg) throws Throwable {
        System.out.println("I CLICK VERTICAL " + arg);
        verticalElement(arg).click();
    }

    // JavascriptExecutor method does not scroll to offscreen element
    @When("^I click (.*) option$")
    public void i_click_vertical(String arg) throws Throwable {
        System.out.println("I CLICK VERTICAL " + arg);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", ((RemoteWebElement) verticalElement(arg)).getId());
        js.executeScript("mobile: scroll", scrollObject);
        verticalElement(arg).click();
    }
    */

    @Then("^Verify (.*) is rendered$")
    public void verify_vertical_is_rendered(String vertical) throws Throwable {
        System.out.println("VERIFY VERTICAL IS RENDERED: " + vertical);
        vertical=vertical.toLowerCase();
        if(vertical.equals("home"))
            vertical="business insider";
        mastHead.isCurrentTitle(vertical);
    }
}