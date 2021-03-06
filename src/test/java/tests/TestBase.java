package tests;


import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import manager.ApplicationManager;

import java.lang.reflect.Method;

public class TestBase {
    //protected static ApplicationManager app = new ApplicationManager();
    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void loggerStart(Method m){
        logger.info("Starts test---> "+m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void loggerStop(Method m){
        logger.info("Ends test---> "+m.getName());
    }

    @BeforeSuite(alwaysRun = true)
    public void init(){
        app.setUp();
    }

//    @AfterSuite (alwaysRun = true)
//    public void tearDown(){
//        app.stop();
//    }
}
