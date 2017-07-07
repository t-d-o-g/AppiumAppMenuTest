The AppiumAppMenuTest repo has the following dependencies in the pom.xml file: 
- latest Appium Java client 5.0.0-BETA9
- Cucumber and TestNG test framework

Using Maven 3.3.9
Using Java jdk1.8.0_102.jdk

To Run Test:
- Follow instructions to build Appium from source:
-- cd appium
-- npm install
-- gulp transpile # requires gulp, see below
-- npm install -g authorize-ios # for ios only
-- authorize-ios                # for ios only

- Add app to iOSApps dir

- Run the test using the RunCukesTest class in src/test/java/stepDefinitions.

AppMenu Test: 
src/test/java/stepDefinitions/AppMenu.java
I included 2 additional commented out methods.  The first one omits the scroll which is an example of how the XCUITest example works.  The second uses the JavascriptExecutor method as suggested.  Neither methods go to the offscreen elements.

AppMenu Cucumber Feature File:
src/test/java/resources/features/AppMenu.feature
I commented out the menu items that do not require scrolling.  They can be uncommented in the Cucumber feature file.
