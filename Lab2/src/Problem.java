import java.util.Arrays;

public class Problem {
    private Location[] locations;
    private Road[] roads;
    private int locationsNumber;
    private int roadsNumber;

    public Problem() {
        locations = new Location[100];
        roads = new Road[100];
        locationsNumber = 0;
        roadsNumber = 0;
    }

    public void addLocation(Location location){
        for( int i = 0; i < locationsNumber; i++)
            if(location.equals(locations[i]) == true){
                System.out.println("Location already exists!");
                return;
            }
        locations[locationsNumber] = location;
        locationsNumber++;

    }

    public void addRoad(Road road){
        for( int i = 0; i < roadsNumber; i++)
            if(road.equals(roads[i]) == true){
                System.out.println("Road already exists!");
                return;
            }
        roads[roadsNumber] = road;
        roadsNumber++;

    }

    public int getLocationsNumber() {
        return locationsNumber;
    }
    public int getRoadsNumber() {
        return roadsNumber;
    }

    public boolean checkValid() {
        if (this.locationsNumber < 2 && this.roadsNumber < 1) {
            System.out.println("The problem is not valid, insert more roads and locations!");
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Problem{" +
                "\n locations=" + Arrays.toString(locations) +
                "\n roads=" + Arrays.toString(roads) +
                "\n locationsNumber=" + locationsNumber +
                "\n roadsNumber=" + roadsNumber +
                "\n}";
    }



}
