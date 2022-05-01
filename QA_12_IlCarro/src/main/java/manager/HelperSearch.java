package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillForm(String city){
        type(By.cssSelector("input#city"),city);//How to choose from drop down list?
        click(By.cssSelector("input#dates"));
        click(By.xpath("//*[@aria-label='Choose month and year']"));
        click(By.xpath("//*[text()=' 2022 ']"));
        click(By.xpath("//*[text()=' JUL ']"));
        click(By.xpath("//*[@aria-label='July 13, 2022']"));
        click(By.xpath("//*[@aria-label='July 16, 2022']"));
    }


}
