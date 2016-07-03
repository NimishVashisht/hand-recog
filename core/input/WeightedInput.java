/*    */ package org.neuroph.core.input;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Vector;
/*    */ import org.neuroph.core.Connection;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WeightedInput
/*    */   extends WeightsFunction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Vector<Double> getOutput(Vector<Connection> inputs)
/*    */   {
/* 50 */     Vector<Double> outputVector = new Vector();
/* 51 */     for (Connection connection : inputs) {
/* 52 */       double in = connection.getWeightedInput();
/*    */       
/* 54 */       outputVector.addElement(Double.valueOf(in));
/*    */     }
/*    */     
/* 57 */     return outputVector;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\input\WeightedInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */