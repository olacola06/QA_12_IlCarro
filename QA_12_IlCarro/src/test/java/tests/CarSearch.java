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



}
