package utilities;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class SeleniumUtilities {
    public WebDriver webDriver;
    public RemoteWebDriver remoteWebDriver;
    public WebDriverWait wait;
    public DesiredCapabilities dc;
    public URL url;
    private Actions actions;

    private String lbl_userName = "//a/img[@title='Flipkart']/following::div[4]/descendant::div[4]";
    private String userNameOptions = "//a/img[@title='Flipkart']/following::div[4]/descendant::div[4]/following::div[1]/div[2]/div/ul/li[*]/a/div";

    protected void launch() throws IOException {
        setUpWebDriver(PropertiesFileReader.getPropertyValue("config","browserName"));
        if(getEnvironment().equalsIgnoreCase("local")){
            webDriver.manage().window().maximize();
            webDriver.get(PropertiesFileReader.getPropertyValue("config","baseUrl"));
        } else{
            remoteWebDriver.manage().window().maximize();
            remoteWebDriver.get(PropertiesFileReader.getPropertyValue("config","baseUrl"));
        }
        wait = new WebDriverWait(webDriver, 30);
    }

    protected void launchByUrl(String urlName) throws IOException {
        setUpWebDriver(PropertiesFileReader.getPropertyValue("config","browserName"));
        if(getEnvironment().equalsIgnoreCase("local")){
            webDriver.manage().window().maximize();
            webDriver.get(PropertiesFileReader.getPropertyValue("config",urlName));
        } else{
            remoteWebDriver.manage().window().maximize();
            remoteWebDriver.get(PropertiesFileReader.getPropertyValue("config",urlName));
        }
        wait = new WebDriverWait(webDriver, 30);
    }

    protected String getEnvironment() throws IOException {
        return PropertiesFileReader.getPropertyValue("config","environment");
    }

    public void setUpWebDriver(String browserName) throws IOException {
        String environment = getEnvironment();
        if(environment.equalsIgnoreCase("local")){
            switch (browserName){
                case "chrome":
                    System.out.println("Opening Chrome browser.");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(Arrays.asList("--no-sandbox","--ignore-certificate-errors","--homepage=about:blank","--no-first-run","--disable-infobars","--disable-notifications"));
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver(options);
                    break;
                case "firefox":
                    System.out.println("Opening Firefox browser.");
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                case "edge":
                    System.out.println("Opening Edge browser.");
                    WebDriverManager.edgedriver().setup();
                    webDriver = new EdgeDriver();
                    break;
                case "opera":
                    System.out.println("Opening Opera browser.");
                    WebDriverManager.operadriver().setup();
                    webDriver = new OperaDriver();
                    break;
                case "internet explorer":
                    System.out.println("Opening Internet Explorer.");
                    WebDriverManager.iedriver().setup();
                    webDriver = new InternetExplorerDriver();
                    break;
                default:
//                Assert.fail("Invalid browser, please enter valid browser name!!");
                    System.out.println("Invalid browser, please enter valid browser name!!");
            }
        } else if(environment.equalsIgnoreCase("remote")){
            switch (browserName){
                case "chrome":
                    System.out.println("Opening Remote Chrome browser.");
                    url = new URL("http://localhost:5900/wd/hub");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(Arrays.asList("--no-sandbox","--ignore-certificate-errors","--homepage=about:blank","--no-first-run","--disable-infobars","--disable-notifications","--disable-popup-blocking"));
                    options.addArguments("--test-type");
                    options.addArguments("--incognito");
                    dc = new DesiredCapabilities();
                    dc.setCapability(ChromeOptions.CAPABILITY,options);
                    options.merge(dc);
                    remoteWebDriver = new RemoteWebDriver(url, options);
                    break;
                case "firefox":
                    System.out.println("Opening Remote Firefox browser.");
                    url = new URL("http://localhost:5901/wd/hub");
                    FirefoxOptions options1 = new FirefoxOptions();
                    options1.addArguments("--disable-popup-blocking");
                    dc = new DesiredCapabilities();
                    dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS,options1);
                    options1.merge(dc);
                    remoteWebDriver = new RemoteWebDriver(url,options1);
                    break;
                default:
                Assert.fail("Invalid browser, please enter valid browser name!!");
            }

        }

    }

    public WebDriver getWebDriver(){
        return  webDriver;
    }

    public WebElement getWebElement(String elePath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elePath)));
        return webDriver.findElement(By.xpath(elePath));
    }

    public void sendKeys(String elePath, String eleText){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elePath)));
        getWebElement(elePath).sendKeys(eleText);
    }

    public void click(String elePath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elePath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elePath)));
        getWebElement(elePath).click();

    }

    public void verifyTextIsVisible(String elePath) throws InterruptedException {
        Thread.sleep(3000);
        getWebElement(elePath);
    }

    public void quit(){
        webDriver.quit();
    }

    public void captureScreenshot(){
        try{
            File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
//            try {
//                FileUtils.copyFile(screenshotFile , new File(System.getProperty("user.dir")+File.separator+"Screenshots"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            Files.move(screenshotFile,new File(System.getProperty("user.dir")+File.separator+"Screenshots"));
        } catch (Exception e){
            Assert.fail("Exception while capturing screen!!\n"+e.getMessage());
        }
    }

    public void moveToElement(WebElement element){
        actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
    }

    public void isDisplayed(String elePath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elePath)));
    }

    public void isClickable(String elePath){
        wait.until(ExpectedConditions.elementToBeClickable(getWebElement(elePath)));
    }

    public void clickLogoutLink(){
        String eleText = "";
        moveToElement(getWebElement(lbl_userName));
        List<WebElement> eleList = webDriver.findElements(By.xpath(userNameOptions));
        for(WebElement ele: eleList){
            eleText = ele.getText();
            if(eleText.toLowerCase().contains("logout")){
                ele.click();
                break;
            }
        }
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public void selectUserNameOption(String optionValue){
//
//    }
}
