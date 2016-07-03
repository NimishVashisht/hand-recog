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
/*    */ public class Sum
/*    */   extends SummingFunction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 2L;
/*    */   
/*    */   public double getOutput(Vector<Double> inputVector)
/*    */   {
/* 40 */     double sum = 0.0D;
/* 41 */     for (Double input : inputVector) {
/* 42 */       sum += input.doubleValue();
/*    */     }
/* 44 */     return sum;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\input\Sum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */