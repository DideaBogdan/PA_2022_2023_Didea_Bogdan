package commands;

import Model.Catalog;
import Model.Document;

public class AddCommand implements Command {
    private Document document;

    public void add(Catalog catalog, Document document){
        this.document = document;
        command(catalog);
    }
    @Override
    public void command(Catalog catalog) {
        catalog.getDocuments().add(document);
    }
}
