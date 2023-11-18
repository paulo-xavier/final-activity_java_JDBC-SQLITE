import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDb {

    public static void main(String args[]) {
        ConnectionDb database1 = new ConnectionDb();
        database1.createDatabase();
    }

    public void createDatabase() {

        Connection conn = null;
        try {

            String url = "jdbc:sqlite:messages.db";

            conn = DriverManager.getConnection(url);

            createTables();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createTables() {
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + "nickname text NOT NULL\n"
                + ");";

        String sql2 = "CREATE TABLE IF NOT EXISTS message (\n"
                + "idSender number NOT NULL, \n"
                + "idRecipient number NOT NULL,\n"
                + "message text NOT NULL, \n"
                + "FOREIGN KEY (idSender) REFERENCES user (rowid),\n"
                + "FOREIGN KEY (idRecipient) REFERENCES user (rowid)\n"
                + ");";

        Connection conn = null;

        try {

            String url = "jdbc:sqlite:messages.db";
            conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.execute(sql2);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } 
    }
}
