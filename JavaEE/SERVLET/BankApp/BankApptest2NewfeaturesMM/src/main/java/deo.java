import java.sql.*;

public class deo {
    public deo() {
    }

    public void save(double amount, int year, int percent, double balance, String phone) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankapp", "root", "root123");
            PreparedStatement st = con.prepareStatement("INSERT into tr (amount, year, percent, balance, phone) values (?,?,?,?,?)");

            st.setDouble(1, amount);
            st.setInt(2, year);
            st.setInt(3, percent);
            st.setDouble(4, balance);
            st.setString(5, phone);
            st.executeUpdate();
        } catch (NumberFormatException var6) {
            var6.printStackTrace();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } catch (ClassNotFoundException var8) {
            var8.printStackTrace();
        }
    }
    public static int check_phone(String phone) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankapp", "root", "root123");
            PreparedStatement st = con.prepareStatement("SELECT phone from tr where phone = ? ");
            st.setString(1, phone);
            ResultSet res =st.executeQuery();
            if(res.next()) {
                return 1 ;
            }
        } catch (NumberFormatException var6) {
            var6.printStackTrace();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } catch (ClassNotFoundException var8) {
            var8.printStackTrace();
        }
        return 0;
    }
}