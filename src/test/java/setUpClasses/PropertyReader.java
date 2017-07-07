package setUpClasses;

public class PropertyReader {

    public PropertyReader() {
        loadProperties();
    }

    private void loadProperties() {
        App.launchOn = "iOS";
        App.bundleid = "com.businessinsider.iphone";
        App.app = "iPhoneBI.app";
        App.currentapp = App.app;
        App.VD = "iPhone 7 (10.3)";
    }
}
