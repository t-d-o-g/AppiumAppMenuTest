package commands;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static setUpClasses.App.driver;
import static setUpClasses.App.launchOn;

/**
 * Created by rpalacios on 7/1/16.
 */
public class Window {

    public static void scrollToElement(WebElement element) {
        Dimension size = driver.manage().window().getSize();
        Point point = element.getLocation();
        int totalSwipes = 0;
        double elY = point.getY();

        while (elY > size.height) {
            point = element.getLocation();
            elY = point.getY();
            totalSwipes = (int) ((elY - size.height) / ((size.height) - (size.height * 0.6)));
            for (int i = 0; i <= totalSwipes; i++) {
                verticalSwipe(0.90, 0.30, 100);
            }
        }
    }

    public static void verticalSwipe(double start, double end, int dur) {
        Dimension size = driver.manage().window().getSize();
        TouchAction action = new TouchAction(driver);
        int startX = size.width / 2;
        int startY = (int) (size.height * start);
        int endX = 0;
        if (launchOn.equals("iOS")) {
            end = end * -1;
        } else {
            endX = size.width / 2;
        }
        int endY = (int) (size.height * end);

        action.press(startX, startY);
        action.waitAction(dur);
        action.moveTo(endX, endY).release().perform();
    }
}
