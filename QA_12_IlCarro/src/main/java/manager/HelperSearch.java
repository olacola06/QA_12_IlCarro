package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HelperSearch extends HelperBase {
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormCurrentMonth(String city, String dataFrom, String dataTo) {
        typeLocation(By.id("city"), city);
        click(By.id("dates"));

        String[] dataF = dataFrom.split("/");
        String[] dataT = dataTo.split("/");

        String locator = "//div[text()=' " + dataF[1] + " ']";
        String locator2 = "//div[text()=' " + dataT[1] + " ']";

        click(By.xpath(locator));
        click(By.xpath(locator2));
    }

    public void fillSearchFormAnyDate(String city, String dateFrom, String dateTo) {
        // rent period from "10/25/2022" to "11/28/2022"//
        typeLocation(By.id("city"), city);
        click(By.id("dates"));

        String todayDate = "05/24/2022";
        String[] todayD = todayDate.split("/"); // [05] [24] [2022]
        int todayMonth = Integer.parseInt(todayD[0]); //[05] --> digit 5

        String[] dateF = dateFrom.split("/");
        String[] dateT = dateTo.split("/");
        int dateMonthFrom = Integer.parseInt(dateF[0]); // [10] --> digit 10
        int dateMonthTo = Integer.parseInt(dateT[0]); // [11] --> digit 11

        int diff = dateMonthFrom - todayMonth;
        if (diff != 0) {
            for (; diff > 0; diff--) {
                click(By.xpath("//button[@aria-label='Next month']"));
            }
        }

        String locatorFrom = String.format("//div[text()=' %s ']", dateF[1]);
        click(By.xpath(locatorFrom));

        int diff2 = dateMonthTo - dateMonthFrom;
        if (diff2 != 0) {
            for (int i = 0; i < diff2; i++) {
                click(By.xpath("//button[@aria-label='Next month']"));
            }
        }

        String locatorTo = String.format("//div[text()=' %s ']", dateT[1]);
        click(By.xpath(locatorTo));

    }

    public void fillSearchFormAnyDateLocalData(String city, String dateFrom, String dateTo) {
        typeLocation(By.id("city"), city);

        click(By.id("dates"));

        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();

        int diff = from.getYear() - now.getYear() == 0 ? from.getMonthValue() - now.getMonthValue() :
                12 - now.getMonthValue() + from.getMonthValue();
        clickNextMonth(diff);
        String dateLocator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(dateLocator));

        diff = to.getYear() - from.getYear() ==0 ? to.getMonthValue() - from.getMonthValue() :
               12 - from.getMonthValue() + to.getMonthValue();
        clickNextMonth(diff);
        pause(2000);
        dateLocator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(dateLocator));

    }

    private void clickNextMonth(int diff){
        for(; diff>0; diff--){
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }

    public boolean carSearchSuccess() {
        return wd.findElements(By.cssSelector("div.search-results")).size() > 0;
    }
}
//    public void fillSearchFormFutureYears(String city, String dateFrom, String dateTo) {
//        // rent period from 01/25/2023" to "03/28/2023"//
//        typeLocation(By.id("city"),city);
//        click(By.id("dates"));
//
//        String todayDate = "05/24/2022";
//        String []todayD = todayDate.split("/"); // [05] [24] [2022]
//        int todayYear = Integer.parseInt(todayD[2]); // [2022] --> digit 2022
//        int todayMonth = Integer.parseInt(todayD[0]); //[05] --> digit 5
//
//        String []dateF = dateFrom.split("/");
//        String []dateT = dateTo.split("/");
//        int dateMonthFrom = Integer.parseInt(dateF[0]); // [01] --> digit 1
//        int dateYearFrom = Integer.parseInt(dateF[2]);
//        int dateMonthTo = Integer.parseInt(dateT[0]); // [2] --> digit 2
//        int dateYearTo = Integer.parseInt(dateT[2]);
//
//       int diff = dateYearFrom-todayYear;
//       if(diff!=0){
//           click(By.xpath("//button[@aria-label='Choose month and year']"));
//           String locatorY = String.format("//div[text()=' %s ']",dateF[2]);
//           click(By.xpath(locatorY));
//
//           if (dateMonthFrom==01){
//               click(By.xpath("//div[text()=' JAN ']"));
//           }
//           if (dateMonthFrom==02) {
//               click(By.xpath("//div[text()=' FEB ']"));
//           }
//           if (dateMonthFrom==03) {
//               click(By.xpath("//div[text()=' MAR ']"));
//           }
//           if (dateMonthFrom==05){
//               click(By.xpath("//div[text()=' APR ']"));
//           }
//           if (dateMonthFrom==06){
//               click(By.xpath("//div[text()=' JUN ']"));
//           }
//           String dateLocatorFrom = String.format("//div[text()=' %s ']",dateF[1]);
//           click(By.xpath(dateLocatorFrom));
//
//       }
//       diff = dateMonthFrom - todayMonth;
//       for (;diff>0;diff--){
//           click(By.xpath("//button[@aria-label='Next month']"));
//       }
//        String dateLocatorFrom = String.format("//div[text()=' %s ']",dateF[1]);
//        click(By.xpath(dateLocatorFrom));
//
//       int diff2 = dateMonthTo - dateMonthFrom;//can't calculate 03 (march) - 11 (november) = -8
//            if(diff2!=0){
//                for(int i=0;i<diff2;i++){
//                    click(By.xpath("//button[@aria-label='Next month']"));
//                }
//        }
//            String dateLocatorTo = String.format("//div[text()=' %s ']", dateT[1]);
//            click(By.xpath(dateLocatorTo));
//    }

