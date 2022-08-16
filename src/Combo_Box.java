import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Combo_Box extends JFrame{

    JComboBox jc = new JComboBox();
    JPanel panel = new JPanel();
    Connection con;
    Statement st;
    ResultSet rs;

    public Combo_Box () {
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","root","");
            st = con.createStatement();
            String sql = "SELECT DISTINCT * FROM users";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                jc.addItem(rs.getString(3));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        } finally {

            try {
                st.close();
                rs.close();
                con.close();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
        panel.add(jc);
        this.getContentPane().add(panel);
        this.setVisible(true);

    }

/*    public static void main(String[] args) {
        new Combo_Box();
    }*/

}
