import java.util.ArrayList;
import java.util.List;

public class CityFilter{
    public static void main(String[] args){
        String[] cityIND={"Mumbai", "Delhi", "Mysore", "Varanasi","Vishakapatnam"};
        String[] cityAUS={"Sydney","Melbourne","Brisbane","Hobart"};
        String[] cityUSA={"New York","Los Angeles","San Francisco","Chicago"};
        String[] cityUK={"London","Swansea","Birmingham","Leicester","Manchester"};

        printCity("India",cityIND);
        printCity("Australia",cityAUS);
        printCity("The USA",cityUSA);
        printCity("The UK",cityUK);
    }
    private static void printCity(String country, String[] city){
        List<String> cities= new ArrayList<>();
        for(String o:city){
            if(o.toUpperCase().contains("S")){
                cities.add(o);
            }
        }
        if(!cities.isEmpty()){
            System.out.println("Cities in "+country+" with 'S':");
            for(String o:cities){
                System.out.println("- "+ o);
            }
        }
    }
}