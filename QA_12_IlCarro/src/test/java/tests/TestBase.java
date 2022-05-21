package tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeSuite;
import manager.ApplicationManager;

public class TestBase {
    //protected static ApplicationManager app = new ApplicationManager();
    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void init(){
        app.setUp();
    }

//    @AfterSuite
//    public void tearDown(){
//        app.stop();
//    }
}
