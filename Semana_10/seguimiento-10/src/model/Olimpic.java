package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import model.entity.Country;
import model.entity.enums.Medal;
import model.exception.NegativeAmmountException;
import model.util.Storage;

public class Olimpic {
    private LinkedList<Country> countries;

    public Olimpic() {

    }

    public void loadData() throws FileNotFoundException, IOException {
        countries = new LinkedList<>();
        Country[] data = Storage.loadJsonFrom(Country.PATH + Country.FILENAME, Country[].class);
        for (Country country : data) {
            countries.add(country);
        }
    }

    public void saveData() {
        Storage.saveJsonTo(Country.FILENAME, Country.PATH, countries);
    }

    public void addMedal(String input) throws NegativeAmmountException {
        String name = input.split("::")[0];
        Medal type = Country.parseMedal(input.split("::")[1]);
        int quantity = Integer.parseInt(input.split("::")[2]);
        int index = countries.indexOf(new Country(name));
        if (index == -1) {
            countries.add(new Country(name));
            index = countries.size() - 1;
        }
        countries.get(index).addMedals(type, quantity);
        saveData();
    }

    public void conventionalSort() {
        Collections.sort(countries);
        System.out.println("Medallería convencional: ");
        for (Country country : countries) {
            System.out.println(country.conventionalMedalsString());
        }
    }

    public void totalMedalsSort() {
        Collections.sort(countries, (a, b) -> {
            return b.getTotalMedals() - a.getTotalMedals();
        });
        System.out.println("Total de medallas por país:");
        for (Country country : countries) {
            System.out.println(country.getName() + ": " + country.getTotalMedals());
        }
    }

    public void selectionSort() {
        for (int i = 0; i < countries.size() - 1; i++) {
            for (int j = i + 1; j < countries.size(); j++) {
                if (countries.get(j).getName().compareTo(countries.get(i).getName()) < 0) {
                    Country temp = countries.get(j);
                    countries.set(j, countries.get(i));
                    countries.set(i, temp);
                }
            }
        }
        for (Country country : countries) {
            System.out.println(country.conventionalMedalsString());
        }
    }
}
