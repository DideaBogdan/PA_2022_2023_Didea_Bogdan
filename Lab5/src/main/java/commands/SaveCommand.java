package commands;

import Exceptions.InvalidCatalogException;
import Model.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class SaveCommand implements Command {
    Catalog catalog;
    String path;
    public void save(Catalog catalog, String path) throws InvalidCatalogException {
        this.catalog=catalog;
        this.path = path;
        try {
            command(catalog);
        }catch (Exception e){
            throw new InvalidCatalogException(e);
        }
    }
    @Override
    public void command(Catalog catalog) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), catalog);
        } catch (Exception e) {
            throw new InvalidCatalogException(e);
        }
    }
}
