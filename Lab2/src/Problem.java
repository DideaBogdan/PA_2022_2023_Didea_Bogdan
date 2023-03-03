import java.util.Arrays;

public class Problem {
    private Location[] locations;
    private Road[] roads;
    private int locationsNumber;
    private int roadsNumber;

    public Problem(){

    }

    public Problem(Location[] locations, Road[] roads, int locationsNumber, int roadsNumber) {
        this.locations = locations;
        this.roads = roads;
        this.locationsNumber = locationsNumber;
        this.roadsNumber = roadsNumber;
    }

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    public Road[] getRoads() {
        return roads;
    }

    public void setRoads(Road[] roads) {
        this.roads = roads;
    }

    public int getLocationsNumber() {
        return locationsNumber;
    }

    public void setLocationsNumber(int locationsNumber) {
        this.locationsNumber = locationsNumber;
    }

    public int getRoadsNumber() {
        return roadsNumber;
    }

    public void setRoadsNumber(int roadsNumber) {
        this.roadsNumber = roadsNumber;
    }
}
