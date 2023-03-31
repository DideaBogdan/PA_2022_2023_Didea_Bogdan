package commands;

import Model.Catalog;
import Model.Document;

import java.io.IOException;

public class ListCommand implements Command{
    @Override
    public void command(Catalog catalog) throws IOException {
        try{
            for (Document document : catalog.getDocuments()){
                System.out.println(document);
            }

        }catch (Exception ex){
            throw new IOException(ex);
        }

    }
}
