package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd){
        super(wd);
    }

     public void fillSearchFormCurrentMonth(String city, String dataFrom, String dataTo) {
        typeLocation(By.id("city"),city);
        click(By.id("dates"));

        String []dataF = dataFrom.split("/");
        String []dataT = dataTo.split("/");

        String locator = "//div[text()=' "+ dataF[1] +" ']";
        String locator2 = "//div[text()=' "+ dataT[1] +" ']";

        click(By.xpath(locator));
        click(By.xpath(locator2));
    }
    public void fillSearchFormAnyDate(String city, String dateFrom, String dateTo) {
        // rent period from "10/25/2022" to "11/28/2022"//
        typeLocation(By.id("city"),city);
        click(By.id("dates"));

        String todayDate = "05/24/2022";
        String []todayD = todayDate.split("/"); // [05] [24] [2022]
        int todayMonth = Integer.parseInt(todayD[0]); //[05] --> digit 5

        String []dateF = dateFrom.split("/");
        String []dateT = dateTo.split("/");
        int dateMonthFrom = Integer.parseInt(dateF[0]); // [10] --> digit 10
        int dateMonthTo = Integer.parseInt(dateT[0]); // [11] --> digit 11

        List<WebElement> months = wd.findElements(By.xpath("//button[@aria-label='Next month']"));

//        if((todayMonth-dateMonthFrom)<0) {
//            int i = dateMonthFrom - todayMonth;
//            for (WebElement el : months) {
//                while (i > 0) {
//                    click(By.xpath("//button[@aria-label='Next month']"));
//                    i -= 1;
//                }
//            }
//        }
        int diff = dateMonthFrom-todayMonth;
        if(diff!=0){
            for(;diff>0;diff--){
                click(By.xpath("//button[@aria-label='Next month']"));
            }
        }

        String locatorFrom = String.format("//div[text()=' %s ']", dateF[1]);
        click(By.xpath(locatorFrom));

        int diff2 = dateMonthTo-dateMonthFrom;
        if(diff2!=0){
            for(int i=0; i<diff2; i++){
                click(By.xpath("//button[@aria-label='Next month']"));
            }
        }

        String locatorTo = String.format("//div[text()=' %s ']",dateT[1]);
        click(By.xpath(locatorTo));

    }

    public void fillSearchFormAnyDate2(String city, String dateFrom, String dateTo) {
        // rent period from 01/25/2023" to "02/28/2023"//
        typeLocation(By.id("city"),city);
        click(By.id("dates"));

        String todayDate = "05/24/2022";
        String []todayD = todayDate.split("/"); // [05] [24] [2022]
        int todayYear = Integer.parseInt(todayD[2]); // [2022] --> digit 2022
        int todayMonth = Integer.parseInt(todayD[0]); //[05] --> digit 5

        String []dateF = dateFrom.split("/");
        String []dateT = dateTo.split("/");
        int dateMonthFrom = Integer.parseInt(dateF[0]); // [01] --> digit 1
        int dateYearFrom = Integer.parseInt(dateF[2]);
        int dateMonthTo = Integer.parseInt(dateT[0]); // [2] --> digit 2
        int dateYearTo = Integer.parseInt(dateT[2]);

        List<WebElement> months = wd.findElements(By.xpath("//button[@aria-label='Next month']"));

        if((dateYearFrom-dateYearTo)<0){
            click(By.xpath("//button[@aria-label='Choose date']"));
            String locatorY = String.format("//div[text()=' %s ']",dateF[2]);
            click(By.xpath(locatorY));
//            switch(dateF[1]){
//                case 01 = "JAN";
//
//            }


        }

        if((todayMonth-dateMonthFrom)<0) {
            int i = dateMonthFrom - todayMonth;
            for (WebElement el : months) {
                //int i = dateMonthFrom - todayMonth;
                while (i > 0) {
                    click(By.xpath("//button[@aria-label='Next month']"));
                    i -= 1;
                }
            }
        }
            String locatorFrom = String.format("//div[text()=' %s ']", dateF[1]);
            click(By.xpath(locatorFrom));

            if((dateMonthFrom-dateMonthTo)<0){
                int i = dateMonthTo-dateMonthFrom;
                for (WebElement el:months) {
                    while (i>0){
                        click(By.xpath("//button[@aria-label='Next month']"));
                        i=-1;
                    }
                }
            }
            String locatorTo = String.format("//div[text()=' %s ']",dateT[1]);
            click(By.xpath(locatorTo));

    }

    public boolean carSearchSuccess() {
        return wd.findElements(By.cssSelector("div.search-results")).size()>0;
    }

}
