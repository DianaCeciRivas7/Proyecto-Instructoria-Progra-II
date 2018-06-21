package proyectocine;

import TablasDB.Bibliotecas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class frmBibliotecas extends javax.swing.JFrame implements ActionListener {

    private String nomUsuario;
    Bibliotecas b = new Bibliotecas();

    public frmBibliotecas() {
        initComponents();
        pnlBibliotecas.setLayout(new GridLayout(100, 1, 5, 5));
        pnlBibliotecas.setBackground(Color.black);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public frmBibliotecas(String nom) {
        initComponents();
        nomUsuario = nom;
        this.getContentPane().setBackground(Color.black);
        pnlBibliotecas.setLayout(new GridLayout(100, 1, 5, 5));
        pnlBibliotecas.setBackground(Color.black);
        agregarBotones();

        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void agregarBotones() {
        pnlBibliotecas.removeAll();
        ResultSet rs = b.obtenerBibliotecas(nomUsuario);
        try {
            while (rs.next()) {
                String nom = rs.getString("Nombre_Biblioteca");
                JButton btnBiblioteca = new JButton();
                btnBiblioteca.setSize(250, 76);
                btnBiblioteca.setContentAreaFilled(false);
                Font fuente = new Font("Dialog", Font.BOLD, 24);
                btnBiblioteca.setFont(fuente);
                btnBiblioteca.setForeground(Color.LIGHT_GRAY);
                btnBiblioteca.setText(nom);
                btnBiblioteca.setHorizontalTextPosition(SwingConstants.CENTER);
                btnBiblioteca.addActionListener(this);
                btnBiblioteca.setActionCommand(nom);
                pnlBibliotecas.add(btnBiblioteca);
            }
        } catch (Exception e) {
        }
        pnlBibliotecas.revalidate();
        pnlBibliotecas.repaint();
    }

    public void verPeliculasBiblioteca(String nom) {
        ResultSet rs = b.obtenerCodigo(nom, nomUsuario);
        String cod = null;
        try {
            while (rs.next()) {
                cod = rs.getString("Cod_Biblioteca");
            }
        } catch (Exception e) {
        }
        frmPeliculasBiblioteca frm = new frmPeliculasBiblioteca(cod, nomUsuario);
        this.setVisible(false);
        frm.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlBibliotecas = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mis bibliotecas");

        pnlBibliotecas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnlBibliotecasLayout = new javax.swing.GroupLayout(pnlBibliotecas);
        pnlBibliotecas.setLayout(pnlBibliotecasLayout);
        pnlBibliotecasLayout.setHorizontalGroup(
            pnlBibliotecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        pnlBibliotecasLayout.setVerticalGroup(
            pnlBibliotecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlBibliotecas);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Agregar biblioteca");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(btnRegresar))
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        frmNuevaBiblioteca nb = new frmNuevaBiblioteca(this);
        nb.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        btnAgregarActionPerformed(null);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmPrincipal frm = new frmPrincipal(nomUsuario);
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(frmBibliotecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBibliotecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBibliotecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBibliotecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBibliotecas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBibliotecas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        ResultSet rs = b.obtenerNombresBibliotecas();
        String nombreComando = e.getActionCommand();
        System.out.println(nombreComando);
        try {
            while (rs.next()) {
                String nom = rs.getString("Nombre_Biblioteca");
                if (nombreComando.equals(nom)) {
                    verPeliculasBiblioteca(nom);
                }
            }
        } catch (Exception ex) {
        }
    }
}
