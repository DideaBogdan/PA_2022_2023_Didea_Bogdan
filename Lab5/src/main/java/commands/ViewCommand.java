package commands;

import Exceptions.InvalidLocationException;
import Model.Catalog;

import java.awt.*;
import java.io.File;
import java.net.URI;

public class ViewCommand implements Command{
    int index;
    public void view(Catalog catalog, int index) throws InvalidLocationException {
        this.index = index;
        command(catalog);
    }
    @Override
    public void command(Catalog catalog) throws InvalidLocationException {
        try {
            var location = catalog.getDocuments().get(index).getLocation();
            if(location.contains("https") || location.contains("http")){
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(URI.create(location));
            } else {
                Desktop desktop = Desktop.getDesktop();
                File file = new File(location);
                desktop.open(file);
            }
        } catch (Exception e){
            throw new InvalidLocationException(e);
        }

    }
}
