package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog implements Serializable {
    private String name;
    private List<Document> documents = new ArrayList<>();

    public void add(Document doc){
        documents.add(doc);
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void setCatalog(Catalog catalog){ //pentru load la catalog, vezi LoadCommand!!!
        this.setName(catalog.getName());
        this.setDocuments(catalog.getDocuments());
    }

    public Catalog() {
    }

    public Document findById(String id){
        return documents.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(name, catalog.name) && Objects.equals(documents, catalog.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, documents);
    }

    @Override
    public String toString() {
        return "Model.Catalog{" +
                "name='" + name + '\'' +
                ", documents=" + documents +
                '}';
    }


}
