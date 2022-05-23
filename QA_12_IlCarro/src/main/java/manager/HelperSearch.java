package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd){
        super(wd);
    }

    public void clickSearchBtn() {
        click(By.xpath("//*[text()=' Search ']"));
    }

    public void fillSearchFormCurrentMonth(String address, String dataFrom, String dataTo) {
        typeLocation(By.cssSelector("input#'city'"),address);
        click(By.cssSelector("input#'dates'"));
    }
}
