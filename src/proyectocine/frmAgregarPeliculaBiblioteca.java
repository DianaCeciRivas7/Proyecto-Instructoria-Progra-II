package proyectocine;

import TablasDB.Bibliotecas;
import TablasDB.Peliculas;
import TablasDB.PeliculasPorBiblioteca;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;

public class frmAgregarPeliculaBiblioteca extends javax.swing.JFrame {
    
    private String nomUsuario, codPel;
    DefaultComboBoxModel modeloBibliotecas = new DefaultComboBoxModel();
    
    public frmAgregarPeliculaBiblioteca() {
        initComponents();
    }
    
    public frmAgregarPeliculaBiblioteca(String nom, String codPel) {
        initComponents();
        nomUsuario = nom;
        this.codPel = codPel;
        this.getContentPane().setBackground(Color.black);
        llenarModelo();
        
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    public void llenarModelo() {
        Bibliotecas bi = new Bibliotecas();
        ResultSet rs = bi.obtenerBibliotecas(nomUsuario);
        try {
            while (rs.next()) {
                String nombreGen = rs.getString("Nombre_Biblioteca");
                modeloBibliotecas.addElement(nombreGen);
            }
        } catch (Exception e) {
        }
        cmbBibliotecas.setModel(modeloBibliotecas);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbBibliotecas = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Biblioteca:");

        cmbBibliotecas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(cmbBibliotecas, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbBibliotecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ResultSet rs = new Bibliotecas().obtenerCodigo("" + modeloBibliotecas.getElementAt(cmbBibliotecas.getSelectedIndex()), nomUsuario);
        String codBiblioteca = null;
        try {
            while (rs.next()) {                
                codBiblioteca = rs.getString("Cod_Biblioteca");
            }
        } catch (Exception e) {
        }
        Object[] p = {codBiblioteca, codPel};
        PeliculasPorBiblioteca pb = new PeliculasPorBiblioteca();
        try {
            pb.AgregarPelicula(p);
            frmPrincipal frm = new frmPrincipal(nomUsuario);
            this.setVisible(false);
            frm.setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ResultSet rs = new Peliculas().ObtenerNombre(codPel);
        String nom = null;
        try {
            while (rs.next()) {                
                nom = rs.getString("Nombre_Pelicula");
            }
        } catch (Exception e) {
        }
        frmInformacionPelicula frm = new frmInformacionPelicula(nom, nomUsuario);
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgregarPeliculaBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbBibliotecas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
