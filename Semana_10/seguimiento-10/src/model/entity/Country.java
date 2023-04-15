package model.entity;

import model.entity.enums.Medal;
import model.exception.NegativeAmmountException;

public class Country implements Comparable<Country> {

    public static final String PATH = "data/";
    public static final String FILENAME = "countries.json";
    private String name;
    private int[] medals;

    public Country(String name) {
        this.medals = new int[Medal.values().length];
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMedals() {
        return medals;
    }

    public int getMedalCount(Medal type) {
        return medals[type.ordinal()];
    }

    public int getTotalMedals() {
        int count = 0;
        for (int i : medals) {
            count += i;
        }
        return count;
    }

    public void addMedals(Medal type, int quantity) throws NegativeAmmountException {
        if (quantity < 0) {
            throw new NegativeAmmountException("La cantidad debe ser positiva");
        }
        medals[type.ordinal()] = medals[type.ordinal()] + quantity;
    }

    public static Medal parseMedal(String type) {
        switch (type) {
            case "oro":
                return Medal.GOLD;
            case "plata":
                return Medal.SILVER;
            case "bronce":
                return Medal.BRONZE;
            default:
                return null;
        }
    }

    @Override
    public int compareTo(Country o) {
        int result;
        if ((result = o.getMedalCount(Medal.GOLD) - this.getMedalCount(Medal.GOLD)) != 0) {
            return result;
        }
        if ((result = o.getMedalCount(Medal.SILVER) - this.getMedalCount(Medal.SILVER)) != 0) {
            return result;
        }
        if ((result = o.getMedalCount(Medal.BRONZE) - this.getMedalCount(Medal.BRONZE)) != 0) {
            return result;
        }
        return this.getName().compareTo(o.getName());
    }

    public String conventionalMedalsString() {
        return "" + this.name + " - Oro: " + this.getMedalCount(Medal.GOLD) + " - Plata: "
                + this.getMedalCount(Medal.SILVER) + " - Bronce: " + this.getMedalCount(Medal.BRONZE);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getName().compareTo(((Country) obj).getName()) == 0;
    }

}
