import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User implements VerifyUserInterface {
    private String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void registerUser(User user) {
        int userExists = verifyUser(user);

        Connection conn = null;

        String sql = "INSERT INTO user (nickname) VALUES (?)";

        if (userExists == -1) {
            try {
                String url = "jdbc:sqlite:messages.db";
                conn = DriverManager.getConnection(url);

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getNickname());

                pstmt.executeUpdate();

                System.out.println("Person registered!!");

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
        } else {
            System.out.println("This user already exists!!");
        }
    }

    public void readMessage(User recipient) {
        Connection conn = null;

        String sql = "SELECT nickname AS sender, message FROM message INNER JOIN user ON (idSender = user.rowid) WHERE idRecipient = (SELECT rowid FROM user WHERE nickname = '"
                + recipient.getNickname() + "')";

        try {
            String url = "jdbc:sqlite:messages.db";
            conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String sender = rs.getString("sender");

                String message = rs.getString("message");

                System.out.println("From: " + sender + " - Message: " + message);
            }

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

    public void checkUsers() {
        Connection conn = null;

        String sql = "SELECT * FROM user";

        try {
            String url = "jdbc:sqlite:messages.db";
            conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                System.out.println("User: " + rs.getString("nickname"));
            }
        
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
