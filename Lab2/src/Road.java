import java.util.Objects;

public abstract class Road {

    protected String name;
    protected double length;
    protected int speedLimit;

    public Road(){

    }

    public Road(String name, double length, int speedLimit) {
        this.name = name;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Double.compare(road.length, length) == 0 && speedLimit == road.speedLimit && Objects.equals(name, road.name);
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
