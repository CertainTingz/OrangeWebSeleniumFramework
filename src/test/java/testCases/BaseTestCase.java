package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTestCase {
    public WebDriver driver;
    public Logger logger;
    public Properties prop;


    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os,String br) throws IOException {


        //Loading a config.properties
        FileReader file = new FileReader("./src//test//resources//config.properties");
        prop = new Properties();
        prop.load(file);

        // Initialising Logging
        logger = LogManager.getLogger(this.getClass());

        // Selecting browser based on the one set in xml file.

        switch (br.toLowerCase()){
            case "chrome": driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver();break;
            case "safari": driver = new SafariDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            default: logger.info("Invalid browser name"); return;
        }
        logger.info("Browser selected is {}", br.toLowerCase());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("appURL"));


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }




}
