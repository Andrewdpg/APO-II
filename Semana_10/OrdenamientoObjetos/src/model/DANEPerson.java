package model;

public class DANEPerson implements Comparable<DANEPerson> {

    private int natID;
    private String name;
    private String lastname;
    private String city;
    private int age;

    public DANEPerson(int natID, String name, String lastname, String city, int age) {
        this.natID = natID;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
    }

    public int getNatID() {
        return natID;
    }

    public void setNatID(int natID) {
        this.natID = natID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.city + " - " + this.lastname + " " + this.name + " - " + this.natID;
    }

    @Override
    public int compareTo(DANEPerson o) {
        int crit;
        if ((crit = this.city.compareTo(o.city)) != 0) {
            return crit;
        }
        if ((crit = this.lastname.compareTo(o.lastname)) != 0) {
            return crit;
        }
        if ((crit = this.name.compareTo(o.name)) != 0) {
            return crit;
        }
        return this.natID - o.natID;
    }
}
