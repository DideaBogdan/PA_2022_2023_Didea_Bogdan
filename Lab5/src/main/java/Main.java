import Exceptions.InvalidCatalogException;
import Model.Catalog;
import Model.Document;
import commands.*;


public class Main {
    public String path = "D:\\FACULTATE\\Anul_3_Sem_2\\Programare avansata\\PA_2022_2023_Didea_Bogdan\\Lab5\\catalog.json";
    public static void main(String[] args){
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (Exception e) {
            e.printStackTrace();
        }
        app.testLoadView();
    }

    private void testCreateSave() throws InvalidCatalogException {
        Catalog catalog = new Catalog("Documents");
        Document book = new Document("1", "book1", "here");
        Document article = new Document("2", "article1", "there");
        Document article1 = new Document("3", "article1", "idk");
        Document article2 = new Document("4", "JAR File!", "https://www.jetbrains.com/idea/guide/tutorials/hello-world/packaging-the-application/");
        Document pdf1 = new Document("5", "pdf", "D:\\FACULTATE\\Anul_3_Sem_2\\Programare avansata\\PA_2022_2023_Didea_Bogdan\\Lab5\\curs1-adnotat.pdf");

        //Test ADD COMMAND
        AddCommand addCommand =  new AddCommand();
        addCommand.add(catalog, book);
        addCommand.add(catalog, article);
        addCommand.add(catalog, article1);
        addCommand.add(catalog, article2);
        addCommand.add(catalog, pdf1);

      //  System.out.println(catalog);
        //TEST SAVE COMMAND
        SaveCommand saveCommand = new SaveCommand();
        saveCommand.save(catalog, this.path);
    }

    private void testLoadView()  {
        // TEST LOAD COMMAND
        LoadCommand loadCommand = new LoadCommand();
        Catalog catalog = new Catalog();
        try {
            loadCommand.load(catalog, path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TEST TO STRING COMMAND
        ToStringCommand toStringCommand = new ToStringCommand();
        toStringCommand.command(catalog);

        //TEST LIST COMMAND
        ListCommand listCommand = new ListCommand();
        try {
            listCommand.command(catalog);
        }catch (Exception e){
            e.printStackTrace();
        }
        // TEST VIEW COMMAND
        ViewCommand viewCommand = new ViewCommand();
        try {
            viewCommand.view(catalog, 3);
            viewCommand.view(catalog, 4);
        }catch (Exception e){
            e.printStackTrace();
        }

        ReportCommand reportCommand = new ReportCommand();
        try {
            reportCommand.command(catalog);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
