/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

/**
 *
 * Realizado por Yellsmy Wilson Eddison Roberto
 */
public class Vista extends javax.swing.JFrame {
    
  
    private Simulador simulador = new Simulador();

    /**
     * Creando nuevo formulario 
     */
    public Vista() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Este método se llama desde dentro del constructor para inicializar el formulario..
     * NO modificar este código. El contenido de este método es siempre
     * regenerado por el Editor de formularios
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        botoninsertarDato = new javax.swing.JButton();
        txtdato = new javax.swing.JTextField();
        cmdDarHojas = new javax.swing.JButton();
        cmdbuscarDato = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        impresion = new javax.swing.JTextArea();
        btnrecorridoInOrden = new javax.swing.JButton();
        btnrecorridoPreOrden = new javax.swing.JButton();
        btnrecorridoPostOrden = new javax.swing.JButton();
        btnNiveles = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Arbol Binario");
        setResizable(false);

        jDesktopPane1.setOpaque(false);

        jInternalFrame2.setEnabled(false);
        jInternalFrame2.setFocusCycleRoot(false);
        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        jDesktopPane1.add(jInternalFrame2);
        jInternalFrame2.setBounds(0, 0, 520, 360);

        botoninsertarDato.setText("insertarDato");
        botoninsertarDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoninsertarDatoActionPerformed(evt);
            }
        });

        cmdDarHojas.setText("Hojas");
        cmdDarHojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDarHojasActionPerformed(evt);
            }
        });

        cmdbuscarDato.setText("buscarDato");
        cmdbuscarDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbuscarDatoActionPerformed(evt);
            }
        });

        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Datos:");

        impresion.setColumns(20);
        impresion.setRows(5);
        jScrollPane2.setViewportView(impresion);

        btnrecorridoInOrden.setText("recorridoInOrden");
        btnrecorridoInOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecorridoInOrdenActionPerformed(evt);
            }
        });

        btnrecorridoPreOrden.setText("recorridoPreOrden");
        btnrecorridoPreOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecorridoPreOrdenActionPerformed(evt);
            }
        });

        btnrecorridoPostOrden.setText("recorridoPostOrden");
        btnrecorridoPostOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecorridoPostOrdenActionPerformed(evt);
            }
        });

        btnNiveles.setText("Niveles");
        btnNiveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNivelesActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnsalir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdato, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botoninsertarDato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdbuscarDato, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBorrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNiveles)
                                .addGap(18, 18, 18)
                                .addComponent(btnrecorridoInOrden)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnrecorridoPreOrden)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnrecorridoPostOrden)
                                .addGap(18, 18, 18)
                                .addComponent(cmdDarHojas)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botoninsertarDato)
                    .addComponent(cmdbuscarDato)
                    .addComponent(botonBorrar)
                    .addComponent(btnNiveles)
                    .addComponent(btnrecorridoInOrden)
                    .addComponent(btnrecorridoPreOrden)
                    .addComponent(btnrecorridoPostOrden)
                    .addComponent(cmdDarHojas))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botoninsertarDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoninsertarDatoActionPerformed

            int dato = Integer.parseInt(txtdato.getText());
            if (this.simulador.insertarDato(dato)) {
                complementos();
                txtdato.setText(null);
            }

    }//GEN-LAST:event_botoninsertarDatoActionPerformed

    private void cmdDarHojasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDarHojasActionPerformed
        String salida = this.simulador.darHojas();
        this.impresion.setText("");
        this.impresion.setText(salida);
    }//GEN-LAST:event_cmdDarHojasActionPerformed

    private void cmdbuscarDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbuscarDatoActionPerformed
        int dato_a_buscarDato = Integer.parseInt(txtdato.getText());
        String salida = this.simulador.esta(dato_a_buscarDato);
        this.impresion.setText("");
        this.impresion.setText(salida);
        txtdato.setText(null);

    }//GEN-LAST:event_cmdbuscarDatoActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
            int dato = Integer.parseInt(txtdato.getText());
            this.impresion.setText(this.simulador.borrar(dato));
            complementos();
            txtdato.setText(null);
    }//GEN-LAST:event_botonBorrarActionPerformed

    public void complementos(){
        this.repintarArbol();
    }
    
    private void btnrecorridoInOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecorridoInOrdenActionPerformed
        // TODO add your handling code here:
        String recorrido = null;
        recorrido = this.simulador.recorridoInOrden();
        this.impresion.setText("");
        this.impresion.setText(recorrido);
    }//GEN-LAST:event_btnrecorridoInOrdenActionPerformed

    private void btnrecorridoPreOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecorridoPreOrdenActionPerformed
        // TODO add your handling code here:
        String recorrido = null;
        recorrido = this.simulador.recorridoPreOrden();
        this.impresion.setText("");
        this.impresion.setText(recorrido);
    }//GEN-LAST:event_btnrecorridoPreOrdenActionPerformed

    private void btnrecorridoPostOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecorridoPostOrdenActionPerformed
        // TODO add your handling code here:
        String recorrido = null;
        recorrido = this.simulador.recorridoPostOrden();
        this.impresion.setText("");
        this.impresion.setText(recorrido);
    }//GEN-LAST:event_btnrecorridoPostOrdenActionPerformed

    private void btnNivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNivelesActionPerformed
        // TODO add your handling code here:
        String recorrido = null;
        recorrido = this.simulador.porNivel();
        this.impresion.setText("");
        this.impresion.setText(recorrido);
    }//GEN-LAST:event_btnNivelesActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void repintarArbol() {
        this.jDesktopPane1.removeAll();
        Rectangle tamaño = this.jInternalFrame2.getBounds();
        this.jInternalFrame2 = null;
        this.jInternalFrame2 = new JInternalFrame("Representación", true);
        this.jDesktopPane1.add(this.jInternalFrame2, JLayeredPane.DEFAULT_LAYER);
        this.jInternalFrame2.setVisible(true);
        this.jInternalFrame2.setBounds(tamaño);
        this.jInternalFrame2.setEnabled(false);
        this.jInternalFrame2.add(this.simulador.getDibujo(), BorderLayout.CENTER);
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botoninsertarDato;
    private javax.swing.JButton btnrecorridoInOrden;
    private javax.swing.JButton btnNiveles;
    private javax.swing.JButton btnrecorridoPostOrden;
    private javax.swing.JButton btnrecorridoPreOrden;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton cmdbuscarDato;
    private javax.swing.JButton cmdDarHojas;
    private javax.swing.JTextArea impresion;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtdato;
    // End of variables declaration//GEN-END:variables
}
