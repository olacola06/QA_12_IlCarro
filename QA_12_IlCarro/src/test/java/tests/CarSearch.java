package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CarSearch extends TestBase{

    @Test
    public void searchPeriodCurrentMonth(){
        app.search().fillSearchFormCurrentMonth("Tel Aviv","05/29/2022","05/30/2022");
        logger.info("rent details:-->"+"Tel Aviv, from 29 May 2022 till 30 May 2022");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
        logger.info("Test finished Success");
    }

    @Test
    public void searchPeriodInFuture(){
        app.search().fillSearchFormAnyDate("Moscow","10/25/2022","11/28/2022");
        logger.info("rent details:-->"+"Moscow, from 25 Oct 2022 till 28 Nov 2022");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
        logger.info("Test finished Success");

    }
    @Test
    public void searchPeriodInFutureLocalData(){
        app.search().fillSearchFormAnyDateLocalData("Tokio","01/25/2023","05/28/2023");
        logger.info("rent details:-->"+"Moscow, from 25 Jan 2023 till 28 May 2023");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
        logger.info("Test finished Success");

    }

    @Test(enabled = true)
    public void fillSearchFormFutureYears(){
        app.search().fillSearchFormAnyDateLocalDataIf("Paris","11/25/2022","03/05/2023");
        logger.info("rent details:-->"+"Paris, from 25 Nov 2022 till 05 March 2023");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
        logger.info("Test finished Success");

    }

    @AfterMethod
    public void returnToMainPage(){
        app.search().returnMainPage();
    }
}
