package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CarSearch extends TestBase{

    @Test
    public void searchPeriodCurrentMonth(){
        app.search().fillSearchFormCurrentMonth("Tel Aviv","05/28/2022","05/30/2022");
        logger.info("rent details:-->"+"Tel Aviv, from 28 May 2022 till 30 May 2022");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
    }

    @Test
    public void searchPeriodInFuture(){
        app.search().fillSearchFormAnyDate("Moscow","10/25/2022","11/28/2022");
        logger.info("rent details:-->"+"Moscow, from 25 Oct 2022 till 28 Nov 2022");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());

    }

    @Test(enabled = false)
    public void searchPeriodInFuture2(){
        //app.search().fillSearchFormAnyDate2("Moscow","01/25/2023","02/28/2023");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());

    }

    @AfterMethod
    public void returnToMainPage(){
        app.search().click(By.xpath(""));
    }
}
