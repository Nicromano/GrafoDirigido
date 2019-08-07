package gui;

import Grafo.Grafo;
import Grafo.GrafoD;

public class Window extends javax.swing.JFrame {

    Grafo g = new GrafoD(8);
    String[] Vector = {"Manta", "Bahia", "Rocafuerte", "Portoviejo", "Junin", "Calceta", "Tosagua", "Chone"};

    public Window() {
        initComponents();
        Llenar();
        setVisible(true);
        setTitle("Grafo dirigido");
        g.insertarArista(0, 1, 50);
        g.insertarArista(0, 2, 4);
        g.insertarArista(0, 3, 10);
        g.insertarArista(1, 2, 6);
        g.insertarArista(1, 6, 7);
        g.insertarArista(1, 7, 14);
        g.insertarArista(2, 1, 3);
        g.insertarArista(2, 0, 8);
        g.insertarArista(2, 6, 12);
        g.insertarArista(3, 2, 11);
        g.insertarArista(3, 0, 11);
        g.insertarArista(3, 4, 5);
        g.insertarArista(5, 4, 9);
        g.insertarArista(5, 7, 6);
        g.insertarArista(6, 7, 4);
        g.insertarArista(6, 1, 11);
        g.insertarArista(6, 2, 10);
        g.insertarArista(6, 5, 16);

        matrizAdyacencia();
        matrizPeso();

    }

    public void MostrarA(String stg) {
        Adyacente.append("   " + stg);
    }

    public void matrizAdyacencia() {
        int[][] matriz = new int[g.numVertice()][g.numVertice()];
        matriz = g.matrizAdyacencia();

        MostrarA("  ");
        for (int i = 0; i < g.numVertice(); i++) {
            MostrarA("" + i );
        }
        MostrarA("\n");
        MostrarA("    ----------------------------------------");
        MostrarA("\n");
        for (int i = 0; i < g.numVertice(); i++) {
            MostrarA("" + i  + "|");
            for (int j = 0; j < g.numVertice(); j++) {
                MostrarA("" + matriz[i][j]);
            }
            MostrarA("\n");
        }
    }

    public void matrizPeso() {
        double[][] matrizP = new double[g.numVertice()][g.numVertice()];
        matrizP = g.matrizPesoAdyacencia();

        MostrarP("      ");
        for (int i = 0; i < g.numVertice(); i++) {
            MostrarP("" + i  + "       " );
        }
        MostrarP("\n");
        MostrarP("    -----------------------------------------------------------------------");
        MostrarP("\n");
        for (int i = 0; i < g.numVertice(); i++) {
            MostrarP("" + i  + "| ");
            for (int j = 0; j < g.numVertice(); j++) {
                if (i == j) {
                    matrizP[i][j] = 0;
                }
                if (matrizP[i][j] < 10) {
                    MostrarP(String.format("%.0f", matrizP[i][j]) + "      |");
                } else if (matrizP[i][j] < 100) {
                    MostrarP(String.format("%.0f", matrizP[i][j]) + "    |");
                } else {
                    MostrarP(String.format("%.0f", matrizP[i][j]) + "  |");
                }
            }
            MostrarP("\n");
        }
    }

    public void MostrarP(String stg) {
        Peso.append("" + stg);
    }

    public void Llenar() {
        for (int i = 0; i < Vector.length; i++) {
            Puntox.addItem(Vector[i]);
            Puntoy.addItem(Vector[i]);
            Ciudades.append(i + " " + Vector[i] + "\n"
            );
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Adyacente = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Peso = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Ciudades = new javax.swing.JTextArea();
        Puntox = new javax.swing.JComboBox();
        Puntoy = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        Caminos = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        Enviar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Ciudades");

        Adyacente.setEditable(false);
        Adyacente.setColumns(20);
        Adyacente.setRows(5);
        Adyacente.setBorder(null);
        jScrollPane2.setViewportView(Adyacente);

        Peso.setEditable(false);
        Peso.setColumns(20);
        Peso.setRows(5);
        Peso.setBorder(null);
        jScrollPane3.setViewportView(Peso);

        jLabel1.setText("Matriz Adyacente");

        jLabel2.setText("Matriz Peso");

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Ciudades.setEditable(false);
        Ciudades.setColumns(20);
        Ciudades.setRows(5);
        Ciudades.setBorder(null);
        jScrollPane4.setViewportView(Ciudades);

        Caminos.setEditable(false);
        Caminos.setColumns(20);
        Caminos.setRows(5);
        Caminos.setBorder(null);
        jScrollPane5.setViewportView(Caminos);

        jLabel3.setText("Caminos");

        Enviar.setText("Enviar");
        Enviar.setFocusable(false);
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        jLabel4.setText("Destino:");

        jLabel6.setText("Origen:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel5)
                .addGap(108, 108, 108)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(293, 293, 293))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane5)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Puntox, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Puntoy, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Enviar)))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Puntox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Puntoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Enviar)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        if (Puntox.getSelectedItem() == Puntoy.getSelectedItem()) {
            Caminos.append("No se puede calcular ese camino porque ya te encuentras ahí.\n");
        } else {
            Caminos.append("Caminos posibles de " + Vector[Puntox.getSelectedIndex()].toUpperCase() + " a " + Vector[Puntoy.getSelectedIndex()].toUpperCase() + ""
                    + " son: " + g.Caminos(Puntox.getSelectedIndex(), Puntoy.getSelectedIndex()) + "\n");
            //Caminos.append(g.Caminos(0, 5));
        }
    }//GEN-LAST:event_EnviarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Adyacente;
    private javax.swing.JTextArea Caminos;
    private javax.swing.JTextArea Ciudades;
    private javax.swing.JButton Enviar;
    private javax.swing.JTextArea Peso;
    private javax.swing.JComboBox Puntox;
    private javax.swing.JComboBox Puntoy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
