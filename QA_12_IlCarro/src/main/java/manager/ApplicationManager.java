package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
    String browser;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    HelperRegistration regist;
    HelperLogin login;
    HelperSearch search;
    HelperCar helperCar;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void setUp(){
        if(browser.equals(BrowserType.CHROME)){
            logger.info("All tests starts in 'Chrome' browser");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("load-extension=C://Tools/4.46.1_0");
//            wd = new EventFiringWebDriver(new ChromeDriver(options));
            wd = new EventFiringWebDriver(new ChromeDriver());

        }else if(browser.equals(BrowserType.EDGE)){
            wd = new EventFiringWebDriver(new EdgeDriver());
            logger.info("All tests starts in 'Edge' browser");

        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests starts in 'Edge' browser");
        }

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro-1578153671498.web.app");
        regist = new HelperRegistration(wd);
        login = new HelperLogin(wd);
        search = new HelperSearch(wd);
        helperCar = new HelperCar(wd);
    }

    public HelperRegistration regist(){
        return regist;
    }

    public HelperLogin login() {
        return login;
    }
    public HelperCar helperCar(){
        return helperCar;
    }

    public HelperSearch search(){
        return search;
    }
    public void stop(){
        wd.quit();
    }

}
