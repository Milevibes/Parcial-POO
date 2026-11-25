    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
     */
    package frontend;

    import clases.Pokemon;
    import clases.Trainer;
    import operation.OperationsPokemon;
    import operation.OperationsTrainers;

    import java.awt.*;
    import java.io.IOException;
    import java.io.InputStream;
    import java.util.List;
    import javax.swing.Box;
    import javax.swing.BoxLayout;
    import javax.swing.DefaultListModel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.SwingConstants;

    /**
     *
     * @author villa
     */
    public class CrearEntrenadorModerno extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CrearEntrenadorModerno.class.getName());
        InputStream is = getClass().getResourceAsStream("/assets/PokemonFuente.ttf");
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, is);
        Font sizedFont = customFont.deriveFont(Font.BOLD, 10f);
        Font smallFont = customFont.deriveFont(Font.BOLD, 9f);
        Font listFont = customFont.deriveFont(Font.BOLD, 8f);

        private final DefaultListModel<Pokemon> modeloPokemones = new DefaultListModel<>();

        /**
         * Creates new form NewJFrame1
         */
        public CrearEntrenadorModerno() throws FontFormatException, IOException {
            // 1. retirar los botones
            setUndecorated(true);

            initComponents();

            // 2. Hacer completamente transparente el fondo del JFrame
            setBackground(new Color(0, 0, 0, 0));
            ((JPanel) getContentPane()).setOpaque(false);

            cargarPokemones();

            // 3. Centrar la ventana en pantalla
            setLocationRelativeTo(null);
        }

        private void initComponents() {

            jButton1 = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();
            jScrollPane5 = new javax.swing.JScrollPane();
            jPanel5 = new javax.swing.JPanel();
            jPanelBotones = new javax.swing.JPanel();
            jLabel10 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jTextField5 = new javax.swing.JTextField();
            jLabel12 = new javax.swing.JLabel();
            jScrollPane6 = new javax.swing.JScrollPane();
            jList3 = new javax.swing.JList<>();
            jLabel13 = new javax.swing.JLabel();
            jTextField6 = new javax.swing.JTextField();
            jButton2 = new javax.swing.JButton();
            jButtonVolver = new javax.swing.JButton();
            jLabel1 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);
            getContentPane().setLayout(null);

            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CirculoN.png")));
            jButton1.setBorderPainted(false);
            jButton1.setContentAreaFilled(false);
            jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CirculoSelección.png")));
            jButton1.addActionListener(this::jButton1ActionPerformed);
            jButton1.setBounds(460, 70, 20, 20);
            getContentPane().add(jButton1);

            jPanel5.setBackground(new java.awt.Color(255, 255, 255));
            jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10));
            jPanel5.setLayout(new BoxLayout(jPanel5, BoxLayout.Y_AXIS));

            jLabel10.setFont(sizedFont);
            jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel10.setText("ENTRENADOR");
            jLabel10.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            jLabel10.setMaximumSize(new Dimension(Integer.MAX_VALUE, 15));

            jLabel11.setFont(sizedFont);
            jLabel11.setText("nombre");

            jTextField5.setFont(sizedFont);

            jLabel13.setFont(sizedFont);
            jLabel13.setText("medallas");

            jTextField6.setFont(sizedFont);
            jTextField6.addActionListener(this::jTextField6ActionPerformed);

            JPanel filaDatos = new JPanel(new GridLayout(2, 2, 8, 2));
            filaDatos.setBackground(new java.awt.Color(255, 255, 255));
            filaDatos.setPreferredSize(new Dimension(210, 50));
            filaDatos.setMinimumSize(new Dimension(180, 50));
            filaDatos.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            filaDatos.add(jLabel11);
            filaDatos.add(jLabel13);
            filaDatos.add(jTextField5);
            filaDatos.add(jTextField6);

            jLabel12.setFont(sizedFont);
            jLabel12.setHorizontalAlignment(SwingConstants.LEFT);
            jLabel12.setAlignmentX(Component.CENTER_ALIGNMENT);
            jLabel12.setText("pokemones");
            jLabel12.setMaximumSize(new Dimension(Integer.MAX_VALUE, 13));

            jList3.setFont(listFont);
            jList3.setModel(modeloPokemones);
            jList3.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            jList3.setVisibleRowCount(3);
            jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane6.setPreferredSize(new Dimension(210, 38));
            jScrollPane6.setMinimumSize(new Dimension(180, 38));
            jScrollPane6.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
            jScrollPane6.setViewportView(jList3);

            jButton2.setFont(smallFont);
            jButton2.setText("Guardar");
            jButton2.setMargin(new java.awt.Insets(2, 2, 2, 2));
            jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(120, 120, 120)));
            jButton2.addActionListener(this::jButton2ActionPerformed);

            jButtonVolver.setFont(smallFont);
            jButtonVolver.setText("Volver");
            jButtonVolver.setMargin(new java.awt.Insets(2, 2, 2, 2));
            jButtonVolver.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(120, 120, 120)));
            jButtonVolver.addActionListener(this::jButtonVolverActionPerformed);

            jPanelBotones.setBackground(new java.awt.Color(255, 255, 255));
            jPanelBotones.setLayout(new GridLayout(1, 2, 3, 0));
            jPanelBotones.add(jButton2);
            jPanelBotones.add(jButtonVolver);
            jPanelBotones.setPreferredSize(new Dimension(210, 20));
            jPanelBotones.setMinimumSize(new Dimension(180, 20));
            jPanelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));

            jPanel5.add(jLabel10);
            jPanel5.add(Box.createVerticalStrut(2));
            jPanel5.add(filaDatos);
            jPanel5.add(Box.createVerticalStrut(3));
            jPanel5.add(jLabel12);
            jPanel5.add(Box.createVerticalStrut(1));
            jPanel5.add(jScrollPane6);
            jPanel5.add(Box.createVerticalStrut(4));
            jPanel5.add(jPanelBotones);
            jPanel5.add(Box.createVerticalGlue());

            jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane5.setViewportView(jPanel5);

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 6, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jPanel1.setBounds(180, 90, 240, 150);
            getContentPane().add(jPanel1);

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gameboy.png")));
            jLabel1.setBounds(7, -10, 570, 350);
            getContentPane().add(jLabel1);

            getContentPane().setPreferredSize(new java.awt.Dimension(577, 340));
            pack();
        }

        private void cargarPokemones() {
            modeloPokemones.clear();
            for (Pokemon pokemon : OperationsPokemon.readPokemons()) {
                modeloPokemones.addElement(pokemon);
            }
        }

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            System.exit(0);
        }

        private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
            String nombre = jTextField5.getText().trim();
            String medallasTexto = jTextField6.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Escribe el nombre del entrenador.",
                        "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (nombre.contains(",") || nombre.contains(":") || nombre.contains("|")) {
                JOptionPane.showMessageDialog(this, "El nombre no puede contener comas, dos puntos ni barras.",
                        "Dato invalido", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int medallas = 0;
            if (!medallasTexto.isEmpty()) {
                if (!medallasTexto.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Las medallas deben ser un valor numerico.",
                            "Dato invalido", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                medallas = Integer.parseInt(medallasTexto);
            }

            List<Pokemon> seleccionados = jList3.getSelectedValuesList();
            if (seleccionados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Selecciona al menos un Pokemon para el entrenador.",
                        "Equipo vacio", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Trainer trainer = new Trainer(nombre, seleccionados.toArray(new Pokemon[0]), medallas);

            if (OperationsTrainers.saveTrainer(trainer)) {
                JOptionPane.showMessageDialog(this, "Entrenador guardado correctamente.",
                        "Entrenador", JOptionPane.INFORMATION_MESSAGE);
                abrirListaEntrenadores();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo guardar el entrenador.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {
            abrirListaEntrenadores();
        }

        private void abrirListaEntrenadores() {
            try {
                MostrarEntrenadoresModerno mostrar = new MostrarEntrenadoresModerno();
                mostrar.setVisible(true);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir la ventana: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        /**
         * @param args the command line arguments
         */
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
            } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
                logger.log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(() -> {
                try {
                    new CrearEntrenadorModerno().setVisible(true);
                } catch (FontFormatException ex) {
                    System.getLogger(CrearEntrenadorModerno.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                } catch (IOException ex) {
                    System.getLogger(CrearEntrenadorModerno.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButtonVolver;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private JPanel jPanel1;
        private JPanel jPanel5;
        private JPanel jPanelBotones;
        private javax.swing.JList<Pokemon> jList3;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JScrollPane jScrollPane6;
        private javax.swing.JTextField jTextField5;
        private javax.swing.JTextField jTextField6;
        // End of variables declaration//GEN-END:variables
    }
