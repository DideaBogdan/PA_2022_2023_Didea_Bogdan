import java.util.Objects;

public class City extends Location{
    private int populationNumber;

    public City(int populationNumber) {
        this.populationNumber = populationNumber;
    }

    public City(String name, double x, double y, int populationNumber) {
        super(name, x, y);
        this.populationNumber = populationNumber;
    }

    public int getPopulationNumber() {
        return populationNumber;
    }

    public void setPopulationNumber(int populationNumber) {
        this.populationNumber = populationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return populationNumber == city.populationNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(populationNumber);
    }

    @Override
    public String toString() {
        return "City{" +
                "populationNumber=" + populationNumber +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
