/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.view.mxGraph;
import controlador.grafo.Adyacencia;
import controlador.grafo.Grafo;
import controlador.grafo.GrafoDirigidoEtiquetado;
import controlador.grafo.GrafoNoDirigidoEtiquetado;
import controlador.listas.ListaEnlazada;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author Dennys
 */
public class FmrGrafo extends javax.swing.JDialog {
    private Grafo grafo;
    /**
     * Creates new form FmrGrafo
     */
    public FmrGrafo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public FmrGrafo(java.awt.Frame parent, boolean modal, Grafo grafo) {
        super(parent, modal);
        this.grafo = grafo;
        initComponents();
        // siempre cargar en el contructor que lleva los datos 
        cargarDatos();
    }
    
    public FmrGrafo(java.awt.Frame parent, boolean modal, GrafoDirigidoEtiquetado grafo) {
        super(parent, modal);
        this.grafo = grafo;
        initComponents();
        // siempre cargar en el contructor que lleva los datos 
        cargarDatos(grafo);
    }
    
    public FmrGrafo(java.awt.Frame parent, boolean modal, GrafoNoDirigidoEtiquetado grafo) {
        super(parent, modal);
        this.grafo = grafo;
        initComponents();
        // siempre cargar en el contructor que lleva los datos 
        cargarDatos(grafo);
    }
    
    private void cargarDatos(){
        mxGraph graph=new mxGraph();
        mxGraphComponent graphComponent =new mxGraphComponent(graph);
        graphComponent.setSize(new Dimension(400,400));
        jPanel2.add(graphComponent,BorderLayout.CENTER);
        Object parent =graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try {
            for (int i = 0; i < grafo.numeroDeVertices(); i++) {
                Object start=graph.insertVertex(parent,String.valueOf(i),String.valueOf(i),100,100,80,30);
                ListaEnlazada<Adyacencia> lista=grafo.listaDeAdyacencias(i);
                for (int j = 0; j < lista.getTamanio(); j++) {
                    Adyacencia a = lista.obtener(j);
                    Object dest= graph.insertVertex(parent,String.valueOf(a.getDestino()),String.valueOf(a.getDestino()),100,100,80,30);
                    graph.insertEdge(parent,null,String.valueOf(a.getPeso()),start,dest);
                }
            }
        } catch (Exception e) {
        }finally{
            graph.getModel().endUpdate();
        }
        morphGraph(graph,graphComponent);
        new mxHierarchicalLayout(graph).execute(graph.getDefaultParent()); 
    }
    
    private void cargarDatos(GrafoDirigidoEtiquetado grafo){
        mxGraph graph=new mxGraph();
        mxGraphComponent graphComponent =new mxGraphComponent(graph);
        graphComponent.setSize(new Dimension(250,250));
        jPanel2.add(graphComponent,BorderLayout.CENTER);
        Object parent =graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try {
            for (int i = 0; i < grafo.numeroDeVertices(); i++) {
                Object start=graph.insertVertex(parent,String.valueOf(grafo.obtenerEtiqueta(i)),String.valueOf(grafo.obtenerEtiqueta(i)),100,100,80,30);
                ListaEnlazada<Adyacencia> lista=grafo.listaDeAdyacencias(i);
                for (int j = 0; j < lista.getTamanio(); j++) {
                    Adyacencia a = lista.obtener(j);
                    Object dest= graph.insertVertex(parent,String.valueOf(grafo.obtenerEtiqueta(Integer.valueOf(a.getDestino().toString()))),String.valueOf(grafo.obtenerEtiqueta(Integer.valueOf(a.getDestino().toString()))),100,100,80,30);
                    graph.insertEdge(parent,null,String.valueOf(a.getPeso()),start,dest);
                }
            }
        } catch (Exception e) {
        }finally{
            graph.getModel().endUpdate();
        }
        morphGraph(graph,graphComponent);
        new mxHierarchicalLayout(graph).execute(graph.getDefaultParent()); 
    }
    
    private void cargarDatos(GrafoNoDirigidoEtiquetado grafo){
        mxGraph graph=new mxGraph();
        mxGraphComponent graphComponent =new mxGraphComponent(graph);
        graphComponent.setSize(new Dimension(250,250));
        jPanel2.add(graphComponent,BorderLayout.CENTER);
        Object parent =graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try {
            for (int i = 0; i < grafo.numeroDeVertices(); i++) {
                Object start=graph.insertVertex(parent,String.valueOf(grafo.obtenerEtiqueta(i)),String.valueOf(grafo.obtenerEtiqueta(i)),100,100,80,30);
                ListaEnlazada<Adyacencia> lista=grafo.listaDeAdyacencias(i);
                for (int j = 0; j < lista.getTamanio(); j++) {
                    Adyacencia a = lista.obtener(j);
                    Object dest= graph.insertVertex(parent,String.valueOf(grafo.obtenerEtiqueta(Integer.valueOf(a.getDestino().toString()))),String.valueOf(grafo.obtenerEtiqueta(Integer.valueOf(a.getDestino().toString()))),100,100,80,30);
                    graph.insertEdge(parent,null,String.valueOf(a.getPeso()),start,dest);
                }
            }
        } catch (Exception e) {
        }finally{
            graph.getModel().endUpdate();
        }
        morphGraph(graph,graphComponent);
        new mxHierarchicalLayout(graph).execute(graph.getDefaultParent()); 
    }
    
    private static void morphGraph(mxGraph graph, mxGraphComponent graphComponent){
       // para que haga las animaciones 
       mxIGraphLayout layout = new mxFastOrganicLayout(graph);
       graph.getModel().beginUpdate();
        try {
            layout.execute(graph.getDefaultParent());
        } catch (Exception e) {
        } finally{
            mxMorphing morph = new mxMorphing(graphComponent, 20, 0.5, 20);
            morph.addListener(mxEvent.DONE, new mxEventSource.mxIEventListener(){
                @Override
                public void invoke(Object o, mxEventObject eo) {
                    graph.getModel().endUpdate();
                }
            });
            morph.startAnimation();
    
    }
       
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
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(-4, -1, 460, 310);

        setSize(new java.awt.Dimension(466, 335));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FmrGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FmrGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FmrGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FmrGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FmrGrafo dialog = new FmrGrafo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
