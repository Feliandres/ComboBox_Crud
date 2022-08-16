import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class docs extends JFrame{
    private JComboBox nombreCB;
    private JPanel mainPanel;
    private JComboBox ciudadCB;
    private JComboBox emailCB;
    private JComboBox celularCB;
    Statement st;
    ResultSet rs;
    Connection con;

    public docs () {
        this.setContentPane(mainPanel);
        this.setTitle("ComboBox");
        this.setSize(460,560);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null); // centrar la pantalla
        Combobox();




    }

    public void Combobox (){
        try{
            con = DriverManager.getConnection("jdbc:mysql://mysql-jpzaldumbide.alwaysdata.net/jpzaldumbide_bdd?serverTimezone=UTC","278457","rYqhic-buvwoh-1tecqe");
            st = con.createStatement();
            String sql = "SELECT * FROM pazmiño";
            rs= st.executeQuery(sql);

            while (rs.next()) {
                nombreCB.addItem(rs.getString(3));
                ciudadCB.addItem(rs.getString(4));
                emailCB.addItem(rs.getString(2));
                celularCB.addItem(rs.getString(5));
            }

        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error");
        } finally {
            try {
                st.close();
                rs.close();
                con.close();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }



    public static void main(String[] args) {
        docs docs = new docs();
    }
}
