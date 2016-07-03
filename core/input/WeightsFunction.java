/*    */ package org.neuroph.core.input;
/*    */ 
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
/*    */ public abstract class WeightsFunction
/*    */ {
/*    */   public abstract Vector<Double> getOutput(Vector<Connection> paramVector);
/*    */   
/*    */   public String toString()
/*    */   {
/* 47 */     return getClass().getName();
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\input\WeightsFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */