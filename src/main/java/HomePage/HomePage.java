package HomePage;

import org.junit.Assert;
import utilities.SeleniumUtilities;

public class HomePage extends SeleniumUtilities {


    private String lbl_userName = "//a/img[@title='Flipkart']/following::div[4]/descendant::div[4]";
    private String option_userNamePath = "//a/img[@title='Flipkart']/following::div[4]/descendant::div[4]/following::div[1]/div[2]/div/ul/li[*]/a/div";


    public void selectUserOption(String optionName){
        try{
            isDisplayed(lbl_userName);
            moveToElement(getWebElement(lbl_userName));
            switch (optionName){
                case "MyProfile":

            }
        } catch (Exception e){
            Assert.fail("Exception in selecting option under UserName!!\n"+e.getMessage());
        }
    }
}