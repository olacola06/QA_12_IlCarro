package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    HelperRegistration regist;
    HelperLogin login;
    HelperSearch search;
    HelperCar helperCar;

    public void setUp(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=C://Tools/4.46.1_0");
        //wd = new ChromeDriver();
        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");
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
