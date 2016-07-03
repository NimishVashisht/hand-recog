/*    */ package org.neuroph.easyneurons;
/*    */ 
/*    */ import java.awt.Window;
/*    */ import org.jdesktop.application.Application;
/*    */ import org.jdesktop.application.SingleFrameApplication;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EasyNeuronsApplication
/*    */   extends SingleFrameApplication
/*    */ {
/*    */   protected void startup()
/*    */   {
/* 20 */     EasyNeuronsApplicationView easyNeuronsApplicationView = new EasyNeuronsApplicationView(this);
/*    */     
/* 22 */     show(easyNeuronsApplicationView);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void configureWindow(Window root) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static EasyNeuronsApplication getApplication()
/*    */   {
/* 40 */     return (EasyNeuronsApplication)Application.getInstance(EasyNeuronsApplication.class);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 47 */     launch(EasyNeuronsApplication.class, args);
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\EasyNeuronsApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */