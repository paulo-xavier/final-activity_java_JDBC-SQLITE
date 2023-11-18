import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.Statement; 
import java.sql.ResultSet;
import java.sql.SQLException;

public interface VerifyUserInterface {

    default int verifyUser(User user) {
        Connection conn = null; 

        String sql = "SELECT rowId from user where nickname = '" + user.getNickname() + "'"; 

        try {
            String url = "jdbc:sqlite:messages.db"; 
            conn = DriverManager.getConnection(url);
            
            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql);
            
            int rowId = -1; 

            while (rs.next()) {
                rowId = rs.getInt("rowId"); 
            }
            return rowId; 
        
        } catch (SQLException e) {
            return -1; 
        
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