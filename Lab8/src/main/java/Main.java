import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {



        ArtistDAO artist1 = new ArtistDAO();
        artist1.create("artist1", 1);

        ArtistDAO artist2 = new ArtistDAO();
        artist1.create("artist2", 2);

        ArtistDAO artist3 = new ArtistDAO();
        artist1.create("artist3", 3);

        ArtistDAO artist4 = new ArtistDAO();
        artist1.create("artist4", 4);

        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists")) {

        }

    }
}
