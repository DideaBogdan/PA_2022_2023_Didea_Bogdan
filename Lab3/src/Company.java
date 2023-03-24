import java.util.HashMap;
import java.util.Map;

public class Company implements Node, Comparable<Company>{
    private String name;
    private int importance;
    private Map<Node, String> relationships = new HashMap<>();

    public Company(String name) {
        this.name = name;
    }

    public void addRelationship(Node node, String value){
        relationships.put(node, value);
    }


    @Override
    public String getName() {
        return name;
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
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", importance=" + importance +
                '}';
    }
}
