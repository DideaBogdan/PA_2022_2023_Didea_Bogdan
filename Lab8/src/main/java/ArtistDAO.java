import java.sql.*;

public class ArtistDAO {
    public void create(String name, int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (id, name) values (?, ?)")) {
            pstmt.setString(2, name);
            pstmt.setString(1, String.valueOf(id));
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        //TODO
        return null;
    }
}
