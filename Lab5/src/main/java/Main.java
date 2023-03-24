import javax.print.Doc;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("Documents");
        Document book = new Document("1", "book1", "here");
        Document article = new Document("2", "article1", "there");
        catalog.add(book);
        catalog.add(article);
      //  System.out.println(catalog);

        CatalogUtil.save(catalog, "D:\\FACULTATE\\Anul_3_Sem_2\\Programare avansata\\PA_2022_2023_Didea_Bogdan\\Lab5\\catalog.json");
    }

    private void testLoadView() {
        Catalog catalog = CatalogUtil.load("D:\\FACULTATE\\Anul_3_Sem_2\\Programare avansata\\PA_2022_2023_Didea_Bogdan\\Lab5\\catalog.json");
        System.out.println(catalog);
    }
}
