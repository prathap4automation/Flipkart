package utilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hook {
    public SeleniumUtilities utils;

//    public Hook(){
//        utils = new SeleniumUtilities();
//    }

    @Before
    public void initiate() throws IOException {
        System.out.println("\nIn cucumber Before tag.");
    }

    @After
    public void close() {
        System.out.println("\nIn Cucumber After tag.");
//        utils = new SeleniumUtilities();
//        utils.quit();
    }

}
