package proyectocine;

import TablasDB.Peliculas;
import TablasDB.PeliculasPorBiblioteca;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import sun.misc.BASE64Decoder;

public class frmPeliculasBiblioteca extends javax.swing.JFrame implements ActionListener {

    ImageIcon imagen;
    private String nomUsuario;
    PeliculasPorBiblioteca pel = new PeliculasPorBiblioteca();

    public frmPeliculasBiblioteca() {
        initComponents();
    }

    public frmPeliculasBiblioteca(String codBiblioteca, String nomUsuario) {
        initComponents();
        this.nomUsuario = nomUsuario;
        this.getContentPane().setBackground(Color.BLACK);
        pnlPeliculas.setLayout(new GridLayout(2, 100, 5, 5));
        pnlPeliculas.setBackground(Color.black);

        agregarBotones(codBiblioteca);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void agregarBotones(String codBiblioteca) {
        pnlPeliculas.removeAll();
        ResultSet rs = pel.obtenerBibliotecas(codBiblioteca);
        String nom = null, port = null;
        try {
            while (rs.next()) {
                nom = rs.getString("nombre");
                port = rs.getString("portada");
                JButton btnPelicula = new JButton();
                btnPelicula.setSize(450, 276);
                cargar(port, nom, btnPelicula);
                pnlPeliculas.add(btnPelicula);
            }
        } catch (Exception e) {
        }
        pnlPeliculas.revalidate();
        pnlPeliculas.repaint();
    }

    public static BufferedImage decodificarImagen(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public void cargar(String image, String nom, JButton btnPelicula) {
        BufferedImage img = null;
        String imagen = image;
        try {
            img = decodificarImagen(imagen);
            this.imagen = new ImageIcon(img);
            Icon icono = new ImageIcon(this.imagen.getImage().getScaledInstance(btnPelicula.getWidth(), btnPelicula.getHeight(), Image.SCALE_DEFAULT));
            btnPelicula.setIcon(icono);
            btnPelicula.setContentAreaFilled(false);
            Font fuente = new Font("Dialog", Font.BOLD, 24);
            btnPelicula.setFont(fuente);
            btnPelicula.setForeground(Color.LIGHT_GRAY);
            btnPelicula.setText(nom);
            btnPelicula.setHorizontalTextPosition(SwingConstants.CENTER);
            btnPelicula.addActionListener(this);
            btnPelicula.setActionCommand(nom);
        } catch (Exception ex) {
        }

    }

    private void verInformacion(String nom) {
        frmInformacionPelicula frm = new frmInformacionPelicula(nom, nomUsuario);
        frm.quitarAgregar();
        frm.setVisible(true);
        this.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPeliculas = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Peliculas");

        javax.swing.GroupLayout pnlPeliculasLayout = new javax.swing.GroupLayout(pnlPeliculas);
        pnlPeliculas.setLayout(pnlPeliculasLayout);
        pnlPeliculasLayout.setHorizontalGroup(
            pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );
        pnlPeliculasLayout.setVerticalGroup(
            pnlPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlPeliculas);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmBibliotecas frm = new frmBibliotecas(nomUsuario);
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
            java.util.logging.Logger.getLogger(frmPeliculasBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPeliculasBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPeliculasBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPeliculasBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPeliculasBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlPeliculas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        ResultSet rs = new Peliculas().obtenerNombres();
        String nombreComando = e.getActionCommand();
        try {
            while (rs.next()) {
                String nom = rs.getString("Nombre");
                if (nombreComando.equals(nom)) {
                    verInformacion(nom);
                }
            }

        } catch (Exception ex) {
        }
    }
}
