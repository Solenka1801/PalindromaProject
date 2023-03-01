/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpalindroma.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import projectpalindroma.model.CaracteresEspeciales;
import projectpalindroma.model.Persistencia;
import projectpalindroma.model.Texto;

public class Interfaz extends javax.swing.JFrame {

    private String resultadoCarga;
    private String resultadoGenerado;
    private String cadenaResultado;
    private String rutaCarga;

    public Interfaz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rutaArchivo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Palindroma Programa");
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setMinimumSize(new java.awt.Dimension(13, 20));
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setText("Cargar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generar Archivo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Dirección del nuevo Archivo generado:");

        rutaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(245, 245, 245))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(rutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BufferedReader entrada = null;
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            resultadoCarga = chooser.getSelectedFile().getAbsolutePath();

            entrada = new BufferedReader(new FileReader(resultadoCarga));
            try {
                jTextArea1.setText(Persistencia.leer(entrada, "", ""));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo");
            }
            resultadoGenerado = chooser.getSelectedFile().getParentFile().getAbsolutePath();

            char[] split = {'|', '/', '*','#','"','^','$',',','-','¿','?','.','+','_','=','%','&','¡','!','‘','~',
                '\\', '<','>','(',')','[',']','{','}',':',';','.',','};
            String cadena = jTextArea1.getText();

            cadena = CaracteresEspeciales.tratamientoCondiciones(cadena.toLowerCase(), 0, split, 0);
          
            String[] arrOriginal = cadena.split(" ");
            
            
            String[] arrActualizado = cadena.split(" ");
            String[] resultado = Texto.inicializarRecorrido(arrOriginal, 0, cadena, arrActualizado);

            
            cadenaResultado = recorrer(0, resultado, "");
            jTextArea2.setText(cadenaResultado);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun archivo");
        } finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

//        for (int i = 0; i < resultado.length; i++) {
//            cadenaResultado += resultado[i] + " ";
    }

    public String recorrer(int i, String[] resultado, String cadenaResultado) {
        if (i > resultado.length - 1) {
            return cadenaResultado;

        } /*else if(i==10) {
             cadenaResultado += resultado[i] + "\n";
             
            return recorrer(i + 1, resultado, cadenaResultado);
        }*/ else {
            cadenaResultado += resultado[i] + " ";
            return recorrer(i + 1, resultado, cadenaResultado);

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (resultadoCarga != null) {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.showSaveDialog(null);
                resultadoGenerado = chooser.getSelectedFile().getAbsolutePath();
                Persistencia.escribirArchivo(resultadoGenerado + "\\resultado.txt", cadenaResultado, false);
                JOptionPane.showMessageDialog(null,"Archivo generado exitosamente.");// "Archivo generado en : " + resultadoGenerado + "\\resultado.txt");
                rutaArchivo.setText(resultadoGenerado + "\\resultado.txt");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
           
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No has seleccionado ninguna carpeta");
                rutaArchivo.setText("No has seleccionado ninguna carpeta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la ruta antes de generar el archivo");
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed


    private void rutaArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaArchivoActionPerformed


    }//GEN-LAST:event_rutaArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField rutaArchivo;
    // End of variables declaration//GEN-END:variables
}
