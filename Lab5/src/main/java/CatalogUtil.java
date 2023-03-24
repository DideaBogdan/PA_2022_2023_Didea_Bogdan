import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.runtime.ObjectMethods;

public class CatalogUtil {
    public static void save(Catalog catalog, String path){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(
                    new File(path), catalog
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Catalog load(String path){
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = null;
        try {
            catalog = objectMapper.readValue(
                    new File(path),
                    Catalog.class
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}
