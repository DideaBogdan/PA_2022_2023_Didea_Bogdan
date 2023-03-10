import java.util.Objects;

public class Express extends Road{
    private int fee;

    public Express(String name, double length, int speedLimit, int fee) {
        super(name, length, speedLimit);
        this.fee = fee;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Express express = (Express) o;
        return fee == express.fee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fee);
    }

    @Override
    public String toString() {
        return "Express{" +
                "fee=" + fee +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
