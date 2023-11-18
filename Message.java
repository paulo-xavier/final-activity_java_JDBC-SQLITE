import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Message implements VerifyUserInterface {
    private String message;
    private User sender;
    private User recipient;

    public Message(String message, User sender, User recipient) {

        this.message = message;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getMessage() {
        return this.message;
    }

    public User getSender() {
        return this.sender;
    }

    public User getRecipient() {
        return this.recipient;
    }

    public void sendMessage(Message message) {
        Connection conn = null;

        int senderId = verifyUser(message.getSender());
        int recipientId = verifyUser(message.getRecipient());

        String sql = "INSERT INTO message (idSender, idRecipient, message) VALUES (?, ?, ?);";

        if (recipientId != -1 && senderId != -1) {
            try {
                String url = "jdbc:sqlite:messages.db";
                conn = DriverManager.getConnection(url);

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, senderId);
                pstmt.setInt(2, recipientId);
                pstmt.setString(3, message.getMessage());

                pstmt.executeUpdate();

                System.out.println("Message sent!!");

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
            System.out.println("Not found!!");

        }

    }

}