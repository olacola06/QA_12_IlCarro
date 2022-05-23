package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd){
        super(wd);
    }

     public void fillSearchFormCurrentMonth(String address, String dataFrom, String dataTo) {
        typeLocation(By.id("city"),address);
        click(By.id("dates"));

        String []dataF = dataFrom.split("/");
        String []dataT = dataTo.split("/");

        String locator = "//div[text()=' "+ dataF[1] +" ']";
        String locator2 = "//div[text()=' "+ dataT[1] +" ']";

        click(By.xpath(locator));
        click(By.xpath(locator2));
    }

    public boolean carSearchSuccess() {
        return wd.findElements(By.cssSelector("div.search-results")).size()>0;
    }
}
