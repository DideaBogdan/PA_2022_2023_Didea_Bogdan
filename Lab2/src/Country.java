import java.util.Objects;

public class Country extends Road{
    private int potholesCount;

    public Country(String name, double length, int speedLimit, int potholesCount) {
        super(name, length, speedLimit);
        this.potholesCount = potholesCount;
    }

    public int getPotholesCount() {
        return potholesCount;
    }

    public void setPotholesCount(int potholesCount) {
        this.potholesCount = potholesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Country country = (Country) o;
        return potholesCount == country.potholesCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(potholesCount);
    }

    @Override
    public String toString() {
        return "Country{" +
                "potholesCount=" + potholesCount +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
