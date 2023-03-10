import java.util.Objects;

public class Airport extends Location{
    private int terminalsNumber;

    public Airport(String name, double x, double y, int terminalsNumber) {
        super(name, x, y);
        this.terminalsNumber = terminalsNumber;
    }

    public int getTerminalsNumber() {
        return terminalsNumber;
    }

    public void setTerminalsNumber(int terminalsNumber) {
        this.terminalsNumber = terminalsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airport airport = (Airport) o;
        return terminalsNumber == airport.terminalsNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(terminalsNumber);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "terminalsNumber=" + terminalsNumber +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
