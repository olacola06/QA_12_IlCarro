package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CarSearch extends TestBase{

    @Test
    public void searchPeriodCurrentMonth(){
        logger.info("rent details:-->"+"Tel Aviv, from 29 June 2022 till 30 June 2022");
        app.search().fillSearchFormCurrentMonth("Tel Aviv","06/29/2022","06/30/2022");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
        logger.info("Test finished Success");
    }

    @Test(groups = {"four"})
    public void searchPeriodInFuture(){
        logger.info("rent details:-->"+"Moscow, from 25 Oct 2022 till 28 Nov 2022");
        app.search().fillSearchFormAnyDate("Moscow","10/25/2022","11/28/2022");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
        logger.info("Test finished Success");

    }
    @Test
    public void searchPeriodInFutureLocalData(){
        logger.info("rent details:-->"+"Tokio, from 25 Jan 2023 till 28 May 2023");
        app.search().fillSearchFormAnyDateLocalData("Tokyo, Japan","01/25/2023","05/28/2023");

        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
        logger.info("Test finished Success");

    }

    @Test(enabled = true, groups = {"four"})
    public void fillSearchFormFutureYears(){
        logger.info("rent details:-->"+"Paris, from 25 Nov 2022 till 05 March 2023");
        app.search().fillSearchFormAnyDateLocalDataIf("Paris","11/25/2022","03/05/2023");

        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
        logger.info("Test finished Success");

    }

    @AfterMethod(alwaysRun = true)
    public void returnToMainPage2(){
        app.search().returnMainPage2();

    }
}
