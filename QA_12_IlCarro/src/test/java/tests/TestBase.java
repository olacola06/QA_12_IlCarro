package tests;

import org.testng.annotations.BeforeSuite;
import manager.ApplicationManager;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void init(){
        app.setUp();
    }

//    @AfterSuite
//    public void tearDown(){
//        app.stop();
//    }
}
