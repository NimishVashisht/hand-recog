/*    */ package org.neuroph.easyneurons.dialog;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.EventQueue;
/*    */ import java.awt.Frame;
/*    */ import java.awt.GridBagLayout;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JFrame;
/*    */ import org.jdesktop.application.Action;
/*    */ import org.jdesktop.application.Application;
/*    */ import org.jdesktop.application.ApplicationContext;
/*    */ import org.jdesktop.application.ResourceMap;
/*    */ import org.neuroph.core.Neuron;
/*    */ import org.neuroph.easyneurons.EasyNeuronsApplication;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NeuronPropertiesDialog
/*    */   extends JDialog
/*    */ {
/*    */   public NeuronPropertiesDialog(Frame parent, boolean modal)
/*    */   {
/* 26 */     super(parent, modal);
/* 27 */     initComponents();
/*    */   }
/*    */   
/*    */   public NeuronPropertiesDialog(Frame parent, boolean modal, Neuron neuron) {
/* 31 */     super(parent, modal);
/* 32 */     initComponents();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 48 */     setDefaultCloseOperation(2);
/* 49 */     ResourceMap resourceMap = ((EasyNeuronsApplication)Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(NeuronPropertiesDialog.class);
/* 50 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/* 51 */     setName("Form");
/* 52 */     setResizable(false);
/* 53 */     getContentPane().setLayout(new GridBagLayout());
/*    */     
/* 55 */     pack();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 62 */     EventQueue.invokeLater(new Runnable() {
/*    */       public void run() {
/* 64 */         NeuronPropertiesDialog dialog = new NeuronPropertiesDialog(new JFrame(), true);
/* 65 */         dialog.addWindowListener(new WindowAdapter() {
/*    */           public void windowClosing(WindowEvent e) {
/* 67 */             System.exit(0);
/*    */           }
/* 69 */         });
/* 70 */         dialog.setVisible(true);
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   @Action
/*    */   public void close() {
/* 77 */     dispose();
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\NeuronPropertiesDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */