import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person implements Node, Comparable<Person>{
    protected String name;
    protected String birthDate;
    protected int importance;
    private Map<Node, String> relationships = new HashMap<>();

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public void addRelationship(Node node, String value){
        relationships.put(node, value);
    }

    @Override
    public void setImportance() {
        this.importance = this.relationships.size();
    }
    @Override
    public int getImportance() {
        return importance;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(birthDate, person.birthDate) && Objects.equals(relationships, person.relationships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, relationships);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", importance=" + importance +
                '}';
    }
}
