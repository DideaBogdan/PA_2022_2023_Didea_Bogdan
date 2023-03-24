import java.util.Objects;

public class Designer extends Person{
    private int numberOfDesigns;

    public Designer(String name, String birthDate, int numberOfDesigns) {
        super(name, birthDate);
        this.numberOfDesigns = numberOfDesigns;
    }

    public int getNumberOfDesigns() {
        return numberOfDesigns;
    }

    public void setNumberOfDesigns(int numberOfDesigns) {
        this.numberOfDesigns = numberOfDesigns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designer designer = (Designer) o;
        return numberOfDesigns == designer.numberOfDesigns;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfDesigns);
    }

    @Override
    public String toString() {
        return "Designer{" +
                ", name='" + name + '\'' +
                "numberOfDesigns=" + numberOfDesigns +
                ", birthDate='" + birthDate + '\'' +
                ", importance=" + importance +
                '}';
    }
}
