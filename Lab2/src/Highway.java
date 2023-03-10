import java.util.Objects;

public class Highway extends Road{
    private int lanesNumber;

    public Highway(String name, double length, int speedLimit, int lanesNumber) {
        super(name, length, speedLimit);
        this.lanesNumber = lanesNumber;
    }

    public int getLanesNumber() {
        return lanesNumber;
    }

    public void setLanesNumber(int lanesNumber) {
        this.lanesNumber = lanesNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Highway highway = (Highway) o;
        return lanesNumber == highway.lanesNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lanesNumber);
    }

    @Override
    public String toString() {
        return "Highway{" +
                "lanesNumber=" + lanesNumber +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
