import java.util.Objects;

public class Programmer extends Person{
    private int deployedProjects;

    public Programmer(String name, String birthDate, int deployedProjects) {
        super(name, birthDate);
        this.deployedProjects = deployedProjects;
    }

    public int getDeployedProjects() {
        return deployedProjects;
    }

    public void setDeployedProjects(int deployedProjects) {
        this.deployedProjects = deployedProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programmer that = (Programmer) o;
        return deployedProjects == that.deployedProjects;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deployedProjects);
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", deployedProjects=" + deployedProjects +
                ", birthDate='" + birthDate + '\'' +
                ", importance=" + importance +
                '}';
    }
}
