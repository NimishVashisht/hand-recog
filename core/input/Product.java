/*    */ package org.neuroph.core.input;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Vector;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Product
/*    */   extends SummingFunction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 2L;
/*    */   
/*    */   public double getOutput(Vector<Double> inputVector)
/*    */   {
/* 41 */     double product = 1.0D;
/* 42 */     for (Double in : inputVector) {
/* 43 */       product *= in.doubleValue();
/*    */     }
/* 45 */     return product;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\input\Product.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */