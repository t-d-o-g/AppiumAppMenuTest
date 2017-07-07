package setUpClasses;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PushPermissionRequestObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by rpalacios on 12/15/15.
 */
public class App {
    public static AppiumDriver driver;
    public static String launchOn;
    public static String VD;
    public static String bundleid;
    public static String currentapp;
    public static String app;
    public static Scenario scenario;
    public static AppiumDriverLocalService appiumDriverLocalService;
    public static DesiredCapabilities capabilities;
    public static AppiumServiceBuilder builder;

    public void launch(Boolean noReset) throws InterruptedException {
        try {
            startAppiumServer();
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("newCommandTimeout",0);

            if(noReset){
                capabilities.setCapability("noReset", true);
            }

            if(App.launchOn == null) {
                new PropertyReader();

                System.out.println("------------ Environmental Configurations ------------");
                System.out.println("OS = " + App.launchOn);
                System.out.println("Simulator = " + App.VD);
                System.out.println("App = " + App.app);
                System.out.println("------------------------------------------------------");
            }

            capabilities.setCapability("platformName", App.launchOn);
            capabilities.setCapability("deviceName", App.VD.split(" \\(")[0]);
            capabilities.setCapability("platformVersion", App.VD.split("\\(")[1].replaceAll("\\)", "").replace(")",""));
            capabilities.setCapability("bundleId", App.bundleid);
            capabilities.setCapability("automationName", "XCUITest");

            File file = new File("iOSApps/"+App.app);
            capabilities.setCapability("app", file.getAbsolutePath());

            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            try {
                if (App.scenario==null || !App.scenario.getName().contains("notification")) {WebDriverWait wait = new WebDriverWait(App.driver, 4);
                    wait.until(ExpectedConditions.visibilityOf(new PushPermissionRequestObject().enableAlerts));
                    System.out.println("ENABLE ALERTS");
                    new PushPermissionRequestObject().clickEnableAlerts();
                }
            }catch(TimeoutException e){
                System.out.println("Push permission request screen wasn't displayed within 15 sec");
            }catch(NoSuchElementException ce){
                System.out.println("Push permission request screen wasn't displayed");
            }
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnreachableBrowserException e){
            e.printStackTrace();
        } catch (SessionNotCreatedException e) {
            e.printStackTrace();
        }
    }

    public static void startAppiumServer() {
        builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723);

        appiumDriverLocalService = builder.build();

        if (!appiumDriverLocalService.isRunning()) {
            System.out.println("Starting Appium Server...");
            Thread.currentThread().setName("AppiumServer");
            appiumDriverLocalService.start();
        }
    }
}
