package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarSearch extends TestBase{

    @Test
    public void searchPeriodCurrentMonth(){
        app.search().fillSearchFormCurrentMonth("Tel Aviv","05/28/2022","05/30/2022");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());
    }

    @Test
    public void searchPeriodInFuture(){
        app.search().fillSearchFormAnyDate("Moscow","10/25/2022","11/28/2022");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());

    }

    @Test
    public void searchPeriodInFuture2(){
        app.search().fillSearchFormAnyDate("Moscow","01/25/2023","02/28/2023");
        app.search().submitYalla();

        Assert.assertTrue(app.search().carSearchSuccess());

    }
}
