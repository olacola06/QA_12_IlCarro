package tests;

import org.testng.annotations.Test;

public class CarSearch extends TestBase{

    @Test
    public void searchPeriodCurrentMonth(){
        app.search().clickSearchBtn();
        app.search().fillSearchFormCurrentMonth("Tel Aviv","05/28/2022","05/30/2022");
        app.search().submitYalla();
        app.search().pause(2000);

    }



}
