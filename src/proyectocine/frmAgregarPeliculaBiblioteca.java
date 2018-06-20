package proyectocine;

import TablasDB.Bibliotecas;
import TablasDB.Generos;
import TablasDB.Peliculas;
import TablasDB.PeliculasPorBiblioteca;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class frmAgregarPeliculaBiblioteca extends javax.swing.JFrame {

    String nomUsuario = "wxlter";
    DefaultComboBoxModel modeloPeliculas = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloBiblioteca = new DefaultComboBoxModel();
    PeliculasPorBiblioteca pxb = new PeliculasPorBiblioteca();
    Peliculas pel = new Peliculas();
    Bibliotecas bib = new Bibliotecas();

    public frmAgregarPeliculaBiblioteca() throws Exception {
        initComponents();
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        llenarCombos();
    }

    public frmAgregarPeliculaBiblioteca(String nombreUsuario) throws Exception {
        initComponents();
        this.nomUsuario = nomUsuario;
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        llenarCombos();

    }

    public void llenarCombos() throws Exception {
        Peliculas pel = new Peliculas();
        Bibliotecas bib = new Bibliotecas();

        ResultSet rs = pel.obtenerNombres();
        try {
            while (rs.next()) {
                String nombrePeliculas = rs.getString("Nombre");
                modeloPeliculas.addElement(nombrePeliculas);
            }
        } catch (SQLException e) {
        }

        rs = bib.BuscarBiblioteca(nomUsuario);
        try {
            while (rs.next()) {
                String nombreBibliotecas = rs.getString("Nombre_Biblioteca");
                modeloBiblioteca.addElement(nombreBibliotecas);
            }
        } catch (SQLException e) {
        }
        cmbBiblioteca.setModel(modeloBiblioteca);
        cmbPelicula.setModel(modeloPeliculas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBiblioteca = new javax.swing.JLabel();
        cmbBiblioteca = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbPelicula = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBiblioteca.setForeground(new java.awt.Color(255, 255, 255));
        lblBiblioteca.setText("Biblioteca:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pelicula:");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Agregar Pelicula a la Biblioteca:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnRegresar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(lblBiblioteca))
                            .addGap(76, 76, 76)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbPelicula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBiblioteca)
                    .addComponent(cmbBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnAgregar))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmPrincipal frm = new frmPrincipal(nomUsuario);
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    @SuppressWarnings("empty-statement")
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        ResultSet rs = pel.ObtenerCodPelicula(cmbPelicula.getSelectedItem().toString());

        int peli = 0, biblio = 0;
        try {
            if (rs.next()) {
                peli = rs.getInt("Cod_Pelicula");
                System.out.println(peli);
            }
            rs = bib.obtenerCodBiblioteca(cmbBiblioteca.getSelectedItem().toString());
            if (rs.next()) {
                biblio = rs.getInt("Cod_Biblioteca");
                System.out.println(biblio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAgregarPeliculaBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmAgregarPeliculaBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object[] p = {peli, biblio};
        try {
            pxb.AgregarPeliculasXBiblioteca(p);
        } catch (Exception e) {
        }
        btnRegresarActionPerformed(null);

    }//GEN-LAST:event_btnAgregarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPeliculaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPeliculaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPeliculaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPeliculaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmAgregarPeliculaBiblioteca().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(frmAgregarPeliculaBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbBiblioteca;
    private javax.swing.JComboBox<String> cmbPelicula;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBiblioteca;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
