package proyectocine;

import TablasDB.Peliculas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import sun.misc.BASE64Decoder;

public class frmPrincipal extends javax.swing.JFrame implements ActionListener {

    Peliculas pel = new Peliculas();
    ImageIcon imagen;
    int xx, xy;
    String nomUsuario;

    public frmPrincipal() {
        initComponents();
        pnlBotones.setLayout(new GridLayout(2, 100, 5, 5));
        pnlBotones.setBackground(Color.black);
        pnlOpcionesUsuario.setBackground(Color.DARK_GRAY);
        jPanel1.setBackground(Color.DARK_GRAY);
        jPanel2.setBackground(Color.DARK_GRAY);
        agregarBotones();

        this.setLocationRelativeTo(null);
    }

    public frmPrincipal(String nombre) {
        initComponents();
        pnlBotones.setLayout(new GridLayout(2, 100, 5, 5));
        pnlBotones.setBackground(Color.black);
        pnlOpcionesUsuario.setBackground(Color.DARK_GRAY);
        jPanel1.setBackground(Color.DARK_GRAY);
        jPanel2.setBackground(Color.DARK_GRAY);
        agregarBotones();
        nomUsuario = nombre;
        lblUsuario.setText(nomUsuario);
        validarAdmin();
        checkBoxAdministrarEliminar.setSelected(false);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void validarAdmin() {
        if (!nomUsuario.equals("admin")) {
            administrarAgregarPelicula.setEnabled(false);
            administrarAgregarDirector.setEnabled(false);
            administrarAgregarGenero.setEnabled(false);
            checkBoxAdministrarEliminar.setEnabled(false);
        }
    }

    public void agregarBotones() {
        pnlBotones.removeAll();
        ResultSet rs = pel.ObtenerNombreImagen();
        String nom = null, port = null;
        try {
            while (rs.next()) {
                nom = rs.getString("Nombre_Pelicula");
                port = rs.getString("portada");
                JButton btnPelicula = new JButton();
                btnPelicula.setSize(450, 276);
                cargar(port, nom, btnPelicula);
                pnlBotones.add(btnPelicula);
            }
        } catch (Exception e) {
        }
        pnlBotones.revalidate();
        pnlBotones.repaint();
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
        frm.setVisible(true);
        this.setVisible(false);
    }

    private void eliminar(String nom) {
        ResultSet rs = pel.ObtenerCodigo(nom);
        try {
            while (rs.next()) {
                int cod = rs.getInt("Cod_Pelicula");
                pel.EliminarPelicula(cod);
            }
        } catch (Exception e) {
        }

        agregarBotones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlBotones = new javax.swing.JPanel();
        pnlOpcionesUsuario = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnMisBibliotecas = new javax.swing.JButton();
        lblMisBibliotecas = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JMenuBar();
        menuOpcionAdministrar = new javax.swing.JMenu();
        administrarAgregarPelicula = new javax.swing.JMenuItem();
        administrarAgregarDirector = new javax.swing.JMenuItem();
        administrarAgregarGenero = new javax.swing.JMenuItem();
        checkBoxAdministrarEliminar = new javax.swing.JCheckBoxMenuItem();
        menuOpcionVer = new javax.swing.JMenu();
        VerPorGenero = new javax.swing.JMenuItem();
        VerPorDirector = new javax.swing.JMenuItem();
        VerPorAño = new javax.swing.JMenuItem();
        VerPorNombre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        pnlBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(pnlBotones);

        pnlOpcionesUsuario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlOpcionesUsuarioMouseDragged(evt);
            }
        });
        pnlOpcionesUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlOpcionesUsuarioMousePressed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        lblSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir.setText("Logout");

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir_off.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir)
                .addGap(43, 43, 43)
                .addComponent(lblSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalir))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        btnMisBibliotecas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/biblioteca_off.png"))); // NOI18N
        btnMisBibliotecas.setBorder(null);
        btnMisBibliotecas.setBorderPainted(false);
        btnMisBibliotecas.setContentAreaFilled(false);
        btnMisBibliotecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMisBibliotecasMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMisBibliotecasMouseEntered(evt);
            }
        });
        btnMisBibliotecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisBibliotecasActionPerformed(evt);
            }
        });

        lblMisBibliotecas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMisBibliotecas.setForeground(new java.awt.Color(255, 255, 255));
        lblMisBibliotecas.setText("Mis bibliotecas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnMisBibliotecas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMisBibliotecas)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMisBibliotecas, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMisBibliotecas)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout pnlOpcionesUsuarioLayout = new javax.swing.GroupLayout(pnlOpcionesUsuario);
        pnlOpcionesUsuario.setLayout(pnlOpcionesUsuarioLayout);
        pnlOpcionesUsuarioLayout.setHorizontalGroup(
            pnlOpcionesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                    .addGroup(pnlOpcionesUsuarioLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlOpcionesUsuarioLayout.setVerticalGroup(
            pnlOpcionesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesUsuarioLayout.createSequentialGroup()
                .addGroup(pnlOpcionesUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOpcionesUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOpcionesUsuarioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        menuPrincipal.setBackground(new java.awt.Color(153, 153, 153));
        menuPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuPrincipalMouseDragged(evt);
            }
        });
        menuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuPrincipalMousePressed(evt);
            }
        });

        menuOpcionAdministrar.setText("Administrar");

        administrarAgregarPelicula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_MASK));
        administrarAgregarPelicula.setText("Agregar película");
        administrarAgregarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarAgregarPeliculaActionPerformed(evt);
            }
        });
        menuOpcionAdministrar.add(administrarAgregarPelicula);

        administrarAgregarDirector.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_MASK));
        administrarAgregarDirector.setText("Agregar director");
        administrarAgregarDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarAgregarDirectorActionPerformed(evt);
            }
        });
        menuOpcionAdministrar.add(administrarAgregarDirector);

        administrarAgregarGenero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.ALT_MASK));
        administrarAgregarGenero.setText("Agregar género");
        administrarAgregarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarAgregarGeneroActionPerformed(evt);
            }
        });
        menuOpcionAdministrar.add(administrarAgregarGenero);

        checkBoxAdministrarEliminar.setSelected(true);
        checkBoxAdministrarEliminar.setText("Eliminar");
        checkBoxAdministrarEliminar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkBoxAdministrarEliminarItemStateChanged(evt);
            }
        });
        menuOpcionAdministrar.add(checkBoxAdministrarEliminar);

        menuPrincipal.add(menuOpcionAdministrar);

        menuOpcionVer.setText("Ver");

        VerPorGenero.setText("Por género");
        VerPorGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPorGeneroActionPerformed(evt);
            }
        });
        menuOpcionVer.add(VerPorGenero);

        VerPorDirector.setText("Por director");
        VerPorDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPorDirectorActionPerformed(evt);
            }
        });
        menuOpcionVer.add(VerPorDirector);

        VerPorAño.setText("Por año");
        VerPorAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPorAñoActionPerformed(evt);
            }
        });
        menuOpcionVer.add(VerPorAño);

        VerPorNombre.setText("Por nombre");
        VerPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPorNombreActionPerformed(evt);
            }
        });
        menuOpcionVer.add(VerPorNombre);

        menuPrincipal.add(menuOpcionVer);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlOpcionesUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
            .addComponent(pnlOpcionesUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void administrarAgregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarAgregarPeliculaActionPerformed
        frmAgregarPelicula ventana = new frmAgregarPelicula(nomUsuario);
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_administrarAgregarPeliculaActionPerformed

    private void pnlOpcionesUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOpcionesUsuarioMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlOpcionesUsuarioMousePressed

    private void pnlOpcionesUsuarioMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOpcionesUsuarioMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlOpcionesUsuarioMouseDragged

    private void menuPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPrincipalMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_menuPrincipalMousePressed

    private void menuPrincipalMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPrincipalMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_menuPrincipalMouseDragged

    private void administrarAgregarDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarAgregarDirectorActionPerformed
        frmNuevoDirector ventana = new frmNuevoDirector(nomUsuario);
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_administrarAgregarDirectorActionPerformed

    private void administrarAgregarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarAgregarGeneroActionPerformed
        frmNuevoGenero ventana = new frmNuevoGenero(nomUsuario);
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_administrarAgregarGeneroActionPerformed

    private void VerPorGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPorGeneroActionPerformed
        pnlBotones.removeAll();
        ResultSet rs = pel.ObtenerNombreImagenOrdenado("Cod_Genero");
        try {
            while (rs.next()) {
                String nom = rs.getString("Nombre_Pelicula");
                String port = rs.getString("portada");
                JButton btnPelicula = new JButton();
                btnPelicula.setSize(450, 276);
                cargar(port, nom, btnPelicula);
                pnlBotones.add(btnPelicula);
                pnlBotones.revalidate();
                pnlBotones.repaint();
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_VerPorGeneroActionPerformed

    private void VerPorDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPorDirectorActionPerformed
        pnlBotones.removeAll();
        ResultSet rs = pel.ObtenerNombreImagenOrdenado("Cod_Director");
        try {
            while (rs.next()) {
                String nom = rs.getString("Nombre_Pelicula");
                String port = rs.getString("portada");
                JButton btnPelicula = new JButton();
                btnPelicula.setSize(450, 276);
                cargar(port, nom, btnPelicula);
                pnlBotones.add(btnPelicula);
                pnlBotones.revalidate();
                pnlBotones.repaint();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_VerPorDirectorActionPerformed

    private void VerPorAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPorAñoActionPerformed
        pnlBotones.removeAll();
        ResultSet rs = pel.ObtenerNombreImagenOrdenado("Año");
        try {
            while (rs.next()) {
                String nom = rs.getString("Nombre_Pelicula");
                String port = rs.getString("portada");
                JButton btnPelicula = new JButton();
                btnPelicula.setSize(450, 276);
                cargar(port, nom, btnPelicula);
                pnlBotones.add(btnPelicula);
                pnlBotones.revalidate();
                pnlBotones.repaint();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_VerPorAñoActionPerformed

    private void VerPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPorNombreActionPerformed
        pnlBotones.removeAll();
        ResultSet rs = pel.ObtenerNombreImagenOrdenado("Nombre_Pelicula");
        try {
            while (rs.next()) {
                String nom = rs.getString("Nombre_Pelicula");
                String port = rs.getString("portada");
                JButton btnPelicula = new JButton();
                btnPelicula.setSize(450, 276);
                cargar(port, nom, btnPelicula);
                pnlBotones.add(btnPelicula);
                pnlBotones.revalidate();
                pnlBotones.repaint();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_VerPorNombreActionPerformed

    private void checkBoxAdministrarEliminarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxAdministrarEliminarItemStateChanged
        if (checkBoxAdministrarEliminar.isSelected()) {
            pnlBotones.setCursor(new Cursor(CROSSHAIR_CURSOR));
        } else {
            pnlBotones.setCursor(new Cursor(DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_checkBoxAdministrarEliminarItemStateChanged

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        ImageIcon imagen;
        String dir = "/Imagenes/salir_on.png";
        URL url = this.getClass().getResource(dir);
        imagen = new ImageIcon(url);
        btnSalir.setIcon(imagen);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        ImageIcon imagen;
        String dir = "/Imagenes/salir_off.png";
        URL url = this.getClass().getResource(dir);
        imagen = new ImageIcon(url);
        btnSalir.setIcon(imagen);
    }//GEN-LAST:event_btnSalirMouseExited

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        btnSalirMouseEntered(null);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        btnSalirMouseExited(null);
    }//GEN-LAST:event_jPanel1MouseExited

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        frmLogin log = new frmLogin();
        this.setVisible(false);
        log.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        btnSalirActionPerformed(null);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnMisBibliotecasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMisBibliotecasMouseEntered
        ImageIcon imagen;
        String dir = "/Imagenes/biblioteca_on.png";
        URL url = this.getClass().getResource(dir);
        imagen = new ImageIcon(url);
        btnMisBibliotecas.setIcon(imagen);
    }//GEN-LAST:event_btnMisBibliotecasMouseEntered

    private void btnMisBibliotecasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMisBibliotecasMouseExited
        ImageIcon imagen;
        String dir = "/Imagenes/biblioteca_off.png";
        URL url = this.getClass().getResource(dir);
        imagen = new ImageIcon(url);
        btnMisBibliotecas.setIcon(imagen);
    }//GEN-LAST:event_btnMisBibliotecasMouseExited

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        btnMisBibliotecasMouseEntered(null);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        btnMisBibliotecasMouseExited(null);
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        btnMisBibliotecasActionPerformed(null);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void btnMisBibliotecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisBibliotecasActionPerformed
        frmBibliotecas bib = new frmBibliotecas(nomUsuario);
        this.setVisible(false);
        bib.setVisible(true);
    }//GEN-LAST:event_btnMisBibliotecasActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JMenuItem VerPorAño;
    private javax.swing.JMenuItem VerPorDirector;
    private javax.swing.JMenuItem VerPorGenero;
    private javax.swing.JMenuItem VerPorNombre;
    private javax.swing.JMenuItem administrarAgregarDirector;
    private javax.swing.JMenuItem administrarAgregarGenero;
    private javax.swing.JMenuItem administrarAgregarPelicula;
    private javax.swing.JButton btnMisBibliotecas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBoxMenuItem checkBoxAdministrarEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMisBibliotecas;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menuOpcionAdministrar;
    private javax.swing.JMenu menuOpcionVer;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlOpcionesUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        ResultSet rs = pel.obtenerNombres();
        String nombreComando = e.getActionCommand();
        try {
            while (rs.next()) {
                if (pnlBotones.getCursor().getName().equals("Cursor Por defecto")) {
                    String nom = rs.getString("Nombre");
                    if (nombreComando.equals(nom)) {
                        verInformacion(nom);
                    }
                } else if (pnlBotones.getCursor().getName().equals("Cursor de Punto de Mira")) {
                    String nom = rs.getString("Nombre");
                    if (nombreComando.equals(nom)) {
                        int sel = JOptionPane.showConfirmDialog(pnlBotones, "¿Seguro/a quiere eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
                        if (sel == 0) {
                            eliminar(nom);
                        }
                    }
                }
            }
        } catch (Exception ex) {
        }
    }
}
