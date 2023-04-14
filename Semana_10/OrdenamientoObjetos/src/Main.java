import java.util.ArrayList;
import java.util.Collections;

import model.DANEPerson;

public class Main {

    public static void main(String[] args) {
        ArrayList<DANEPerson> people = new ArrayList<>();

        people.add(new DANEPerson(111, "Andres", "Rodriguez", "Cali", 28));
        people.add(new DANEPerson(522, "Pedro", "Escobar", "Bogotá", 17));
        people.add(new DANEPerson(322, "Pablo", "Pinzón", "Bogotá", 17));
        people.add(new DANEPerson(833, "Alexandra", "Londoño", "Medellín", 18));
        people.add(new DANEPerson(944, "Verónica", "Andrade", "Cali", 40));
        people.add(new DANEPerson(334, "Verónica", "Andrade", "Cali", 40));
        people.add(new DANEPerson(833, "María", "Gomez", "Medellín", 18));
        people.add(new DANEPerson(422, "Jose", "Zapata", "Bogotá", 17));
        people.add(new DANEPerson(633, "Karen", "Pedroza", "Medellín", 18));
        people.add(new DANEPerson(044, "Yano", "Seque", "Cali", 40));
        people.add(new DANEPerson(222, "Manuel", "García", "Bogotá", 17));
        people.add(new DANEPerson(964, "Harry", "Styles", "Cali", 40));
        Collections.sort(people);

        people.forEach(person -> {
            System.out.println(person.toString());
        });
    }
}
