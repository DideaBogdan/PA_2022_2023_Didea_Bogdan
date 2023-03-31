package commands;

import Exceptions.InvalidCatalogException;
import Exceptions.InvalidLocationException;

import Exceptions.InvalidReportException;
import Model.Catalog;
import java.io.IOException;

public interface Command{
    void command(Catalog catalog) throws InvalidCatalogException, InvalidLocationException, InvalidReportException, IOException;

}