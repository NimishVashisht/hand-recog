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
/*    */ public class Max
/*    */   extends SummingFunction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public double getOutput(Vector<Double> inputVector)
/*    */   {
/* 40 */     double max = 0.0D;
/* 41 */     for (Double input : inputVector) {
/* 42 */       if (input.doubleValue() > max)
/* 43 */         max = input.doubleValue();
/*    */     }
/* 45 */     return max;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\input\Max.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */