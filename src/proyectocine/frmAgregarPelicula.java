package proyectocine;

import TablasDB.Directores;
import TablasDB.Generos;
import TablasDB.Peliculas;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class frmAgregarPelicula extends javax.swing.JFrame {

    private JPanel contentPane;
    Peliculas pel = new Peliculas();
    File fichero = null;
    int cont = 0, codigoPelicula, codigoGenero, codigoDirector;
    DefaultComboBoxModel modeloAño = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloGenero = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloDirector = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloHoras = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloMinutos = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloSegundos = new DefaultComboBoxModel();
    String nomUsuario;

    public frmAgregarPelicula() {
        initComponents();

        llenarModelos();
        llenarCodigoPelicula();
        cmbGeneroItemStateChanged(null);
        cmbDirectorItemStateChanged(null);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public frmAgregarPelicula(String nomUsuario) {
        initComponents();
        this.nomUsuario = nomUsuario;
        this.getContentPane().setBackground(Color.DARK_GRAY);
        llenarModelos();
        llenarCodigoPelicula();
        cmbGeneroItemStateChanged(null);
        cmbDirectorItemStateChanged(null);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public static String codificarString(BufferedImage image) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "jpg", bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public void llenarModelos() {
        Generos gen = new Generos();
        ResultSet rs = gen.obtenerNombreGeneros();
        try {
            while (rs.next()) {
                String nombreGen = rs.getString("Nombre_Genero");
                modeloGenero.addElement(nombreGen);
            }
        } catch (Exception e) {
        }
        cmbGenero.setModel(modeloGenero);

        Directores dir = new Directores();
        rs = dir.obtenerNombreApellidoDirectores();
        try {
            while (rs.next()) {
                String nombreDir = rs.getString("Nombre_Director");
                String apellidoDir = rs.getString("Apellido_Director");
                String nombreCompleto = nombreDir + " " + apellidoDir;
                modeloDirector.addElement(nombreCompleto);
            }
        } catch (Exception e) {
        }
        cmbDirector.setModel(modeloDirector);

        Calendar añoBusqueda = Calendar.getInstance();
        int FechaActual = añoBusqueda.get(Calendar.YEAR);
        for (int año = FechaActual; año >= 1980; año--) {
            modeloAño.addElement(año);
        }
        cmbAño.setModel(modeloAño);

        for (int hrs = 0; hrs <= 4; hrs++) {
            modeloHoras.addElement("0" + hrs);
        }
        for (int min = 0; min <= 59; min++) {
            if (min <= 9) {
                modeloMinutos.addElement("0" + min);
            } else {
                modeloMinutos.addElement(min);
            }
        }
        for (int seg = 0; seg <= 59; seg++) {
            if (seg <= 9) {
                modeloSegundos.addElement("0" + seg);
            } else {
                modeloSegundos.addElement(seg);
            }
        }
        cmbHoras.setModel(modeloHoras);
        cmbMinutos.setModel(modeloMinutos);
        cmbSegundos.setModel(modeloSegundos);
    }

    public void llenarCodigoPelicula() {
        ResultSet rs = pel.obtenerMaxPelicula();
        try {
            while (rs.next()) {
                codigoPelicula = rs.getInt("maximo") + 1;
                lblCodigoPelicula.setText("" + codigoPelicula);
            }
        } catch (Exception e) {
        }
    }

    public void llenarCodigoGenero() {
        Generos gen = new Generos();
        ResultSet rs = gen.obtenerCodDeGenero("" + modeloGenero.getElementAt(cmbGenero.getSelectedIndex()));
        try {
            while (rs.next()) {
                codigoGenero = rs.getInt("Cod_Genero");
                lblCodGenero.setText("" + codigoGenero);
            }
        } catch (Exception e) {
        }
    }

    public void llenarCodigoDirector() {
        Directores dir = new Directores();
        String[] director = modeloDirector.getElementAt(cmbDirector.getSelectedIndex()).toString().split(" ");
        ResultSet rs = dir.obtenerCodDeDirector(director[0], director[1]);
        try {
            while (rs.next()) {
                codigoDirector = rs.getInt("Cod_Director");
                lblCodDirector.setText("" + codigoDirector);
            }
        } catch (Exception e) {
        }
    }

    public String obtenerDuracionSeleccionada() {
        return modeloHoras.getElementAt(cmbHoras.getSelectedIndex()) + ":" + modeloMinutos.getElementAt(cmbMinutos.getSelectedIndex()) + ":" + modeloSegundos.getElementAt(cmbSegundos.getSelectedIndex());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAbrirFotos = new javax.swing.JButton();
        lblFotoSeleccionada = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblCod = new javax.swing.JLabel();
        lblCodigoPelicula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombrePelicula = new javax.swing.JTextField();
        lblDuracion = new javax.swing.JLabel();
        lblAño = new javax.swing.JLabel();
        cmbAño = new javax.swing.JComboBox<>();
        lblGenero = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cmbDirector = new javax.swing.JComboBox<>();
        lblSinopsis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaSipnosis = new javax.swing.JTextArea();
        cmbHoras = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbMinutos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbSegundos = new javax.swing.JComboBox<>();
        btnAgregarPelicula = new javax.swing.JButton();
        lblCodGenero = new javax.swing.JLabel();
        lblCodDirector = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        lblRutaUbicacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAbrirFotos.setText("Buscar imagen");
        btnAbrirFotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirFotosActionPerformed(evt);
            }
        });

        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Datos sobre la pelicula");

        lblCod.setForeground(new java.awt.Color(255, 255, 255));
        lblCod.setText("Codigo:");

        lblCodigoPelicula.setForeground(new java.awt.Color(255, 255, 255));

        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Titulo:");

        txtNombrePelicula.setBorder(null);

        lblDuracion.setForeground(new java.awt.Color(255, 255, 255));
        lblDuracion.setText("Duracion:");

        lblAño.setForeground(new java.awt.Color(255, 255, 255));
        lblAño.setText("Año:");

        cmbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Genero:");

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGeneroItemStateChanged(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Director:");

        cmbDirector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDirector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDirectorItemStateChanged(evt);
            }
        });

        lblSinopsis.setForeground(new java.awt.Color(255, 255, 255));
        lblSinopsis.setText("Sinopsis:");

        txtAreaSipnosis.setColumns(20);
        txtAreaSipnosis.setRows(5);
        txtAreaSipnosis.setBorder(null);
        jScrollPane1.setViewportView(txtAreaSipnosis);

        cmbHoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(":");

        cmbMinutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(":");

        cmbSegundos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregarPelicula.setText("Agregar");
        btnAgregarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPeliculaActionPerformed(evt);
            }
        });

        lblCodGenero.setForeground(new java.awt.Color(255, 255, 255));

        lblCodDirector.setForeground(new java.awt.Color(255, 255, 255));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblRutaUbicacion.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblGenero)
                        .addGap(33, 33, 33)
                        .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCod)
                            .addComponent(lblNombre)
                            .addComponent(lblDuracion)
                            .addComponent(lblAño))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigoPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblSinopsis))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCodDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblRutaUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblFotoSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAbrirFotos)
                        .addGap(49, 49, 49))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnRegresar)
                        .addGap(71, 71, 71)
                        .addComponent(btnAgregarPelicula))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblTitulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCod)
                                .addGap(22, 22, 22)
                                .addComponent(lblNombre)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDuracion)
                                    .addComponent(cmbHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(cmbMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(cmbSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(lblAño))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblCodigoPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(cmbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblGenero))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCodGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCodDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lblFotoSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRutaUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbrirFotos)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarPelicula)
                    .addComponent(btnRegresar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirFotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirFotosActionPerformed
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "jpg");
        file.setFileFilter(filtro);

        int seleccion = file.showOpenDialog(contentPane);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fichero = file.getSelectedFile();
            lblRutaUbicacion.setText(fichero.getAbsolutePath());
            ImageIcon icon = new ImageIcon(fichero.toString());
            System.out.println(fichero.getName());
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFotoSeleccionada.getWidth(), lblFotoSeleccionada.getHeight(), Image.SCALE_DEFAULT));
            lblFotoSeleccionada.setText(null);
            lblFotoSeleccionada.setIcon(icono);

        }
    }//GEN-LAST:event_btnAbrirFotosActionPerformed

    private void btnAgregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPeliculaActionPerformed
        if (!lblRutaUbicacion.getText().equals("")) {
            try {
                BufferedImage img = ImageIO.read(new File(fichero.toString()));
                String imagenCodificada = codificarString(img);
                Object[] p = {codigoPelicula, txtNombrePelicula.getText(), txtAreaSipnosis.getText(), obtenerDuracionSeleccionada(), modeloAño.getElementAt(cmbAño.getSelectedIndex()), lblCodGenero.getText(), lblCodDirector.getText(), imagenCodificada};
                pel.AgregarPelicula(p);
                frmPrincipal prin = new frmPrincipal(nomUsuario);
                this.setVisible(false);
                prin.setVisible(true);
            } catch (IOException ex) {
            } catch (Exception ex) {
            }

        }

    }//GEN-LAST:event_btnAgregarPeliculaActionPerformed

    private void cmbGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGeneroItemStateChanged
        llenarCodigoGenero();
    }//GEN-LAST:event_cmbGeneroItemStateChanged

    private void cmbDirectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDirectorItemStateChanged
        llenarCodigoDirector();
    }//GEN-LAST:event_cmbDirectorItemStateChanged

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmPrincipal frm = new frmPrincipal(nomUsuario);
        frm.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(frmAgregarPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarPelicula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgregarPelicula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirFotos;
    private javax.swing.JButton btnAgregarPelicula;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbAño;
    private javax.swing.JComboBox<String> cmbDirector;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JComboBox<String> cmbHoras;
    private javax.swing.JComboBox<String> cmbMinutos;
    private javax.swing.JComboBox<String> cmbSegundos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAño;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblCodDirector;
    private javax.swing.JLabel lblCodGenero;
    private javax.swing.JLabel lblCodigoPelicula;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblFotoSeleccionada;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRutaUbicacion;
    private javax.swing.JLabel lblSinopsis;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtAreaSipnosis;
    private javax.swing.JTextField txtNombrePelicula;
    // End of variables declaration//GEN-END:variables
}
