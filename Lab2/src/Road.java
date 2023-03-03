import java.util.Objects;

public class Road {
    public enum RoadType{
        HIGHWAY,
        EXPRESS,
        COUNTRY;
    }
    private String name;
    private RoadType type;
    private double length;
    private int speedLimit;

    public Road(){

    }

    public Road(String name, RoadType type, double length, int speedLimit) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Double.compare(road.length, length) == 0 && speedLimit == road.speedLimit && Objects.equals(name, road.name) && type == road.type;
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
