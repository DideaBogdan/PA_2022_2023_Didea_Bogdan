package commands;

import Exceptions.InvalidReportException;
import Model.Catalog;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;


public class ReportCommand implements Command {
    @Override
    public void command(Catalog catalog) throws InvalidReportException{
        try {
            Velocity.init();

            VelocityContext context = new VelocityContext();
            context.put("catalog", catalog.getDocuments());

            Template template = Velocity.getTemplate("/HTMLdocument.vm");
            StringWriter writer = new StringWriter();
            template.merge(context, writer);
            writer.close();
            FileWriter file = new FileWriter("HTMLdocument.html");
            file.write(String.valueOf(writer));
            file.close();
            Desktop.getDesktop().open(new File("HTMLDocument.html"));


        } catch (Exception e) {
            throw new InvalidReportException(e);
        }
    }
}