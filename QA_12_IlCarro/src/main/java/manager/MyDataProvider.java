package manager;

import lombok.Data;
import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;

    @DataProvider
    public Iterator<Object[]> registrationValidData() {

        List<Object[]> list = new ArrayList();

        list.add(new Object[]{"Tom", "Brown", "user" + i + "@gmail.com", "Asd" + i + "d#%"});
        list.add(new Object[]{"Tommy", "Bro", "user" + i + 1 + "@gmail.com", "Asd" + i + 1 + "d#%"});
        list.add(new Object[]{"Toms", "Bros", "user" + i + 2 + "@gmail.com", "Asd" + i + 2 + "d#%"});
        list.add(new Object[]{"Tomer", "Broch", "user" + i + 3 + "@gmail.com", "Asd" + i + 4 + "d#%"});
        list.add(new Object[]{"Toma", "Bred", "user" + i + 4 + "@gmail.com", "Asd" + i + 4 + "d#%"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registValidDataFS() {

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withName("Ola").withLastName("Mar").withEmail("ads" + i + "@gmail.com").withPassword("Df123hg$")});
        list.add(new Object[]{new User().withName("Ola").withLastName("Mar").withEmail("ads" + i + 1 + "@gmail.com").withPassword("Df1231hg$")});
        list.add(new Object[]{new User().withName("Ola").withLastName("Mar").withEmail("ads" + i + 2 + "@gmail.com").withPassword("Df1232hg$")});
        list.add(new Object[]{new User().withName("Ola").withLastName("Mar").withEmail("ads" + i + 3 + "@gmail.com").withPassword("Df1233hg$")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWrongEmailCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/registrationLoginInvalidData.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] obj = line.split(",");
            list.add(new Object[]{obj[0], obj[1], obj[2], obj[3]});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> letTheCarWorkDataLombok() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Car.builder().location("London").make("UK").model("Porsh").about("Super car").clasS("Sx").distance("150").doors("3")
                .engine("2.8").features("Red fast car").fuel("Petrol").gear("SMT").price("80").registrationNum("10-100-333" + i).seats("2").fuelConsumption("12")
                .wD("FWD").year("2018").build()});
        list.add(new Object[]{Car.builder().location("Berlin").make("UK").model("Porsh").about("Super car").clasS("Sx").distance("150").doors("3")
                .engine("2.8").features("Red fast car").fuel("Petrol").gear("SMT").price("80").registrationNum("10-100-333" + i + 1).seats("2").fuelConsumption("12")
                .wD("FWD").year("2018").build()});
        list.add(new Object[]{Car.builder().location("Paris").make("UK").model("Porsh").about("Super car").clasS("Sx").distance("150").doors("3")
                .engine("2.8").features("Red fast car").fuel("Petrol").gear("SMT").price("80").registrationNum("10-100-333" + i + 2).seats("2").fuelConsumption("12")
                .wD("FWD").year("2018").build()});
        list.add(new Object[]{Car.builder().location("Madrid").make("UK").model("Porsh").about("Super car").clasS("Sx").distance("150").doors("3")
                .engine("2.8").features("Red fast car").fuel("Petrol").gear("SMT").price("80").registrationNum("10-100-333" + i + 3).seats("2").fuelConsumption("12")
                .wD("FWD").year("2018").build()});

        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> letTheCarWorkWrongData() throws IOException {

        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/letTheCarWorkWrongData.csv"));

        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{Car.builder().location(split[0]).make(split[1]).model(split[2]).year(split[3]).engine(split[4])
                    .fuel(split[5]).gear(split[6]).wD(split[7]).doors(split[8]).seats(split[9]).clasS(split[10])
                    .fuelConsumption(split[11]).registrationNum(split[12]).price(split[13]).distance(split[14]).features(split[15])
                    .about(split[16]).build()});
            line = reader.readLine();

        }
        return list.iterator();
    }
    @DataProvider
    //public Iterator<Object[]> letTheCarWorkValidData() throws IOException {
    public Iterator<Object[]> letTheCarWorkValidWithoutSingapore() throws IOException {
        List<Object[]> list = new ArrayList<>();

        //BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/letTheCarWorkValidData.csv"));
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/letTheCarWorkValidWithoutSingapore.csv"));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(";");
            list.add(new Object[]{Car.builder().location(split[0]).make(split[1]).model(split[2]).year(split[3]).engine(split[4])
                    .fuel(split[5]).gear(split[6]).wD(split[7]).doors(split[8]).seats(split[9]).clasS(split[10])
                    .fuelConsumption(split[11]).registrationNum(split[12]).price(split[13]).distance(split[14]).features(split[15])
                    .about(split[16]).build()});
            line = reader.readLine();

        }
        return list.iterator();

    }
}
