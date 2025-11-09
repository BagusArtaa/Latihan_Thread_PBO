import java.sql.*;

public class SpaceTicket {

    public void showAllTickets() {
        String sql = "SELECT * FROM tickets";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== DAFTAR TIKET PERJALANAN LUAR ANGKASA ===");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + ". Tujuan: " + rs.getString("destination") +
                    " | Harga: " + rs.getDouble("price") +
                    " | Tersedia: " + rs.getInt("available")
                );
            }
            System.out.println("\n==========================================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Ticket getTicketById(int id) {
        String sql = "SELECT * FROM tickets WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Ticket(
                    rs.getInt("id"),
                    rs.getString("destination"),
                    rs.getDouble("price"),
                    rs.getInt("available")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized boolean bookTicket(int id) {
        String check = "SELECT available FROM tickets WHERE id = ?";
        String update = "UPDATE tickets SET available = available - 1 WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psCheck = conn.prepareStatement(check);
             PreparedStatement psUpdate = conn.prepareStatement(update)) {

            psCheck.setInt(1, id);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next() && rs.getInt("available") > 0) {
                psUpdate.setInt(1, id);
                psUpdate.executeUpdate();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
