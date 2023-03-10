import java.lang.reflect.AnnotatedArrayType;

import static java.lang.System.exit;

public class Main {



    public static void main(String[] args) {

        Location []sites = new Location[3];

        sites[0] = new City("Vaslui", 3.45, 2.56, 56789);
        sites[1] = new Airport("AeroSpatial", 5.67, 9.01, 5);
        sites[2] = new CommercialCenter("CuDeToate", 3.34, 7.89, 23);

        System.out.println(sites[0]);
        System.out.println(sites[1]);
        System.out.println(sites[2]);

        Road []links = new Road[3];

        links[0] = new Highway("H12", 300, 130, 3);
        links[1] = new Express("E22", 500, 150, 30);
        links[2] = new Country("C112", 120, 80, 31);

        System.out.println(links[0]);
        System.out.println(links[1]);
        System.out.println(links[2]);

        Problem pb = new Problem();
        pb.addLocation(sites[0]);
        pb.addLocation(sites[1]);
        pb.addLocation(sites[2]);

        pb.addRoad(links[0]);
        pb.addRoad(links[1]);
        pb.addRoad(links[2]);

        System.out.println(pb);
        if(pb.checkValid() == true){
            System.out.println("Problema este valida!");
        }
        else{
            System.out.println("Problema nu este valida!");
        }
    }
}
