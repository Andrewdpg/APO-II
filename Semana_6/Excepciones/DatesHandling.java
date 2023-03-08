package Semana_6.Excepciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesHandling {

    public static void main(String[] args) {
        try{
            action("2002-08-12");
        }catch(ParseException e){
            e.printStackTrace();
        }
    }

    public static void action(String dateSTR) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateSTR);
        System.out.println(date);
    }
}
