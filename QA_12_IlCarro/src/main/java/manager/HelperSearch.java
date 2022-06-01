package manager;

import net.bytebuddy.asm.Advice;
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

        clear(By.id("dates"));
        click(By.id("dates"));
        //clear(By.id("dates"));


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

        clear(By.id("dates"));
        click(By.id("dates"));
        //clear(By.id("dates"));

        String todayDate = "06/18/2022";
        String[] todayD = todayDate.split("/"); // [05] [28] [2022]
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

        clear(By.id("dates"));
        click(By.id("dates"));
        //clear(By.id("dates"));

        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();

        int diff = from.getYear() - now.getYear() == 0 ? from.getMonthValue() - now.getMonthValue() :
                12 - now.getMonthValue() + from.getMonthValue();
        clickNextMonth(diff);
        String dateLocator = String.format("//div[text()=' %s ']", from.getDayOfMonth());
        click(By.xpath(dateLocator));

        diff = to.getYear() - from.getYear() == 0 ? to.getMonthValue() - from.getMonthValue() :
                12 - from.getMonthValue() + to.getMonthValue();
        clickNextMonth(diff);
        dateLocator = String.format("//div[text()=' %s ']", to.getDayOfMonth());
        click(By.xpath(dateLocator));

    }

    private void clickNextMonth(int diff) {
        for (; diff > 0; diff--) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }

    public boolean carSearchSuccess() {
        return wd.findElements(By.cssSelector("div.search-results")).size() > 0;
    }

    public void fillSearchFormAnyDateLocalDataIf(String city, String dateFrom, String dateTo) {
        typeLocation(By.id("city"), city);

        clear(By.id("dates"));
        click(By.id("dates"));
        //clear(By.id("dates"));

        LocalDate rentFrom = LocalDate.parse(dateFrom,DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate rentTo = LocalDate.parse(dateTo,DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate now = LocalDate.now();

        int diff;
        if ((rentFrom.getYear() - now.getYear())!=0){
            diff = 12 - now.getMonthValue() + rentFrom.getMonthValue();
        }
        else
            diff = rentFrom.getMonthValue() - now.getMonthValue();
        clickNextMonth(diff);
        String locator = String.format("//div[text()=' %s ']",rentFrom.getDayOfMonth());
        click(By.xpath(locator));

        if ((rentTo.getYear() - rentFrom.getYear())!=0){
            diff = 12 - rentFrom.getMonthValue() + rentTo.getMonthValue();
        }
        else
            diff = rentTo.getMonthValue() - rentFrom.getMonthValue();
        clickNextMonth(diff);
        locator = String.format("//div[text()=' %s ']",rentTo.getDayOfMonth());
        click(By.xpath(locator));
    }

}

