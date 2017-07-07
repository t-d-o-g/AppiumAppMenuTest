package commands;

import org.testng.Assert;

/**
 * Created by rpalacios on 3/28/17.
 */
public class Assertions {
    public static void assertChar(String actual, String expected) {
        try{
            Assert.assertEquals(actual,expected);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
