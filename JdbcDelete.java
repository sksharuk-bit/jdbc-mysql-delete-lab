import java.sql.*;

public class JdbcDelete {
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, 2);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No rows were deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
