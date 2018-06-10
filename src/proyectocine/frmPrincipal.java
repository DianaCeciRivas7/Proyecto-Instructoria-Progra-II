package proyectocine;

import TablasDB.Peliculas;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class frmPrincipal extends javax.swing.JFrame {

    Peliculas pel = new Peliculas();
    DefaultTableModel modeloTablaPelicula = new DefaultTableModel() {
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };

    public frmPrincipal() {
        initComponents();

        modeloTablaPelicula.addColumn("Codigo");
        modeloTablaPelicula.addColumn("Pelicula");
        modeloTablaPelicula.addColumn("Nombre director");
        modeloTablaPelicula.addColumn("Apellido director");
        modeloTablaPelicula.addColumn("Genero");
        modeloTablaPelicula.addColumn("Año");

        for (int column = 0; column < tblPeliculas.getColumnModel().getColumnCount(); column++) {
            tblPeliculas.getColumnModel().getColumn(column).setResizable(false);
        }
        tblPeliculas.getTableHeader().setReorderingAllowed(false);
        tblPeliculas.setModel(modeloTablaPelicula);
        llenarTabla();

        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void limpiarTabla() {
        for (int posicion = 0; posicion < tblPeliculas.getRowCount(); posicion++) {
            modeloTablaPelicula.removeRow(posicion);
            posicion -= 1;
        }
    }

    public void llenarTabla() {
        limpiarTabla();
        ResultSet rs = pel.obtenerDatosTabla();
        try {
            while (rs.next()) {
                String cod = rs.getString("Cod_Pelicula");
                String nom = rs.getString("Nombre_Pelicula");
                String gen = rs.getString("Nombre_Genero");
                String nomDir = rs.getString("Nombre_Director");
                String apeDir = rs.getString("Apellido_Director");
                int año = rs.getInt("Año");
                modeloTablaPelicula.addRow(new Object[]{cod, nom, nomDir, apeDir, gen, año});
            }
        } catch (Exception e) {
        }
        tblPeliculas.setModel(modeloTablaPelicula);
        tblPeliculas.setDefaultRenderer(Object.class, new ColorFilas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        pnlPeliculas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        btnInfPelicula = new javax.swing.JButton();
        btnAgregarBiblioteca = new javax.swing.JButton();
        lblNombreUsuario = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JMenuBar();
        menuOpcionAdministrar = new javax.swing.JMenu();
        administrarAgregarPelicula = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setEnabled(false);

        tblPeliculas.setModel(modeloTablaPelicula);
        jScrollPane1.setViewportView(tblPeliculas);

        btnInfPelicula.setText("Informacion");
        btnInfPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfPeliculaActionPerformed(evt);
            }
        });

        btnAgregarBiblioteca.setText("Agregar");

        javax.swing.GroupLayout pnlPeliculasLayout = new javax.swing.GroupLayout(pnlPeliculas);
        pnlPeliculas.setLayout(pnlPeliculasLayout);
        pnlPeliculasLayout.setHorizontalGroup(
            pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPeliculasLayout.createSequentialGroup()
                .addGroup(pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(pnlPeliculasLayout.createSequentialGroup()
                        .addComponent(btnInfPelicula)
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregarBiblioteca)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPeliculasLayout.setVerticalGroup(
            pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPeliculasLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfPelicula)
                    .addComponent(btnAgregarBiblioteca))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblNombreUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        menuPrincipal.setBackground(new java.awt.Color(153, 153, 153));

        menuOpcionAdministrar.setText("Administrar");

        administrarAgregarPelicula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK));
        administrarAgregarPelicula.setText("Agregar película");
        administrarAgregarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarAgregarPeliculaActionPerformed(evt);
            }
        });
        menuOpcionAdministrar.add(administrarAgregarPelicula);

        menuPrincipal.add(menuOpcionAdministrar);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void administrarAgregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarAgregarPeliculaActionPerformed
        frmAgregarPelicula ventana = new frmAgregarPelicula();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_administrarAgregarPeliculaActionPerformed

    private void btnInfPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfPeliculaActionPerformed
        int seleccion = Integer.parseInt(modeloTablaPelicula.getValueAt(tblPeliculas.getSelectedRow(), 0).toString());
        frmInformacionPelicula frame = new frmInformacionPelicula(seleccion);
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInfPeliculaActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem administrarAgregarPelicula;
    private javax.swing.JButton btnAgregarBiblioteca;
    private javax.swing.JButton btnInfPelicula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JMenu menuOpcionAdministrar;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JPanel pnlPeliculas;
    private javax.swing.JTable tblPeliculas;
    // End of variables declaration//GEN-END:variables
}
