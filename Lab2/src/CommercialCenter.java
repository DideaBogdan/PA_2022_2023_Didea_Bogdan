import java.util.Objects;

public class CommercialCenter extends Location{
    private int storesNumber;

    public CommercialCenter(String name, double x, double y, int storesNumber) {
        super(name, x, y);
        this.storesNumber = storesNumber;
    }

    public int getStoresNumber() {
        return storesNumber;
    }

    public void setStoresNumber(int storesNumber) {
        this.storesNumber = storesNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommercialCenter that = (CommercialCenter) o;
        return storesNumber == that.storesNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storesNumber);
    }

    @Override
    public String toString() {
        return "CommercialCenter{" +
                "storesNumber=" + storesNumber +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
