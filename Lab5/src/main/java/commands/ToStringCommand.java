package commands;

import Model.Catalog;

public class ToStringCommand implements Command{
    @Override
    public void command(Catalog catalog) {
        System.out.println(catalog.toString());
    }
}
