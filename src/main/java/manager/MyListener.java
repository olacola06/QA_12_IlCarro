package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;


public class MyListener extends AbstractWebDriverEventListener {

    public MyListener() {
        super();
    }
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start search element by locator-->" + by);
    }


    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("Element with locator-->" + by + " was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("Something went wrong: " + driver.getCurrentUrl());
        logger.info(throwable.getMessage());
        logger.info(String.valueOf(throwable.fillInStackTrace()));

        int i = (int) (System.currentTimeMillis()) / 1000 % 3600;
        //String link = "C:/Users/Olga/GitHub/QA_12_IlCarro/src/test/screenshots/screenshot" + i + ".png";
        String link = "C:/Users/Olga/QA_12_IlCarro/src/test/screenshots/screenshot"+i+".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try { Files.copy(screenshot, new File(link));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

//    @Override
//    public void beforeGetText(WebElement element, WebDriver driver) {
//        super.beforeGetText(element, driver);
//        logger.info("A message expected to be received");
//    }
//
//    @Override
//    public void afterGetText(WebElement element, WebDriver driver, String text) {
//        super.afterGetText(element, driver, text);
//        logger.info("Message was received-->"+text);
//    }

}