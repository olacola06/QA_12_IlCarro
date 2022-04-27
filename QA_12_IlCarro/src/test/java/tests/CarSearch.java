package tests;

import org.testng.annotations.Test;

public class CarSearch extends TestBase{

    @Test
    public void letTheCarWork(){

        app.search().fillForm("Moscow");
        app.search().submitYalla();

    }


}
