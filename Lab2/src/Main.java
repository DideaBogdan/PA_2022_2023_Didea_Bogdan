public class Main {
    public static void main(String[] args) {
        Location c1 = new Location();
        c1.setName("Iasi");
        c1.setType(Location.LocationType.MALL);
        c1.setX(2.356);
        c1.setY(3.456);
        System.out.println(c1);

        Location c2 = new Location("Vaslui", Location.LocationType.CITY, 5.678, 2.123);
        System.out.println(c2);

        Road r1 = new Road("D24", Road.RoadType.EXPRESS, 85.2,100);
        Road r2 = new Road();
        r2.setName("D12");
        r2.setType(Road.RoadType.HIGHWAY);
        r2.setLength(156.265);
        r2.setSpeedLimit(130);

        System.out.println(r1);
        System.out.println(r2);

        Problem pb = new Problem();



    }
}
