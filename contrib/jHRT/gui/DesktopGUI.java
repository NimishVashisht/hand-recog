/*    */ package org.neuroph.contrib.jHRT.gui;
/*    */ 
/*    */ import java.awt.Panel;
/*    */ import java.awt.event.WindowAdapter;
/*    */ import java.awt.event.WindowEvent;
/*    */ import java.beans.PropertyVetoException;
/*    */ import javax.swing.JDesktopPane;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLayeredPane;
/*    */ 
/*    */ public class DesktopGUI
/*    */   extends JFrame
/*    */ {
/*    */   JLayeredPane desktop;
/*    */   
/*    */   public DesktopGUI()
/*    */   {
/* 18 */     super("Neuroph");
/* 19 */     setBounds(200, 50, 800, 700);
/* 20 */     setDefaultLookAndFeelDecorated(true);
/*    */     
/* 22 */     Panel p = new Panel();
/*    */     
/* 24 */     add(p, "South");
/* 25 */     addWindowListener(new WindowAdapter()
/*    */     {
/*    */       public void windowClosing(WindowEvent e)
/*    */       {
/* 29 */         System.exit(0);
/*    */       }
/*    */       
/*    */ 
/* 33 */     });
/* 34 */     this.desktop = new JDesktopPane();
/* 35 */     this.desktop.setOpaque(true);
/* 36 */     add(this.desktop, "Center");
/*    */     
/* 38 */     HandwritingRecognitionToolFrame internalFrame = new HandwritingRecognitionToolFrame("Internal Frame", true, true, true, true);
/*    */     
/* 40 */     this.desktop.add(internalFrame);
/* 41 */     internalFrame.setVisible(true);
/*    */     try
/*    */     {
/* 44 */       internalFrame.setMaximum(true);
/*    */     }
/*    */     catch (PropertyVetoException ex) {}
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 50 */     DesktopGUI main = new DesktopGUI();
/* 51 */     main.setVisible(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\jHRT\gui\DesktopGUI.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */