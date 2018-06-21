package TablasDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    private String url = "jdbc:mysql://127.0.0.1:3306/ProyectoCine";
    private String login = "root";
    private String password = "nozomi";
    private Connection cnx = null;
    private Statement sttm = null;
    private ResultSet rst = null;

    public void UID(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement();
            sttm.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException c) {
            JOptionPane.showMessageDialog(null, "ERROR: " + c.getMessage());
        }
    }

    public ResultSet getValores(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, login, password);
            sttm = cnx.createStatement();
            rst = sttm.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException c) {
            JOptionPane.showMessageDialog(null, "ERROR: " + c.getMessage());
        } finally {
            return rst;
        }
    }

    public void desconectar() {
        try {

            cnx.close();
            System.out.println("Se cerró la conexión");
        } catch (SQLException ex) {

        }
    }

    public Connection conectar() {
        Connection link = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha fallado. " + e);
        }
        return link;
    }

}
