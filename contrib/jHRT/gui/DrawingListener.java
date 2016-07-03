/*    */ package org.neuroph.contrib.jHRT.gui;
/*    */ 
/*    */ import java.awt.Point;
/*    */ import java.awt.event.MouseEvent;
/*    */ import javax.swing.event.MouseInputAdapter;
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
/*    */ class DrawingListener
/*    */   extends MouseInputAdapter
/*    */ {
/*    */   private DrawingPanel dp;
/*    */   private Point start;
/*    */   
/*    */   public DrawingListener(DrawingPanel dp)
/*    */   {
/* 38 */     this.dp = dp;
/*    */   }
/*    */   
/*    */   public void mousePressed(MouseEvent e)
/*    */   {
/* 43 */     this.start = e.getPoint();
/*    */   }
/*    */   
/*    */   public void mouseDragged(MouseEvent e)
/*    */   {
/* 48 */     Point p = e.getPoint();
/* 49 */     this.dp.draw(this.start, p);
/* 50 */     this.start = p;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\jHRT\gui\DrawingListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */