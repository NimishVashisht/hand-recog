/*    */ package org.neuroph.contrib;
/*    */ 
/*    */ import org.neuroph.core.transfer.TransferFunction;
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
/*    */ public class IACFunction
/*    */   extends TransferFunction
/*    */ {
/* 41 */   double decay = 0.1D; double rest = -0.1D; double min = -0.2D; double max = 1.0D;
/*    */   
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public double getOutput(double netInput, double output)
/*    */   {
/* 47 */     double delta = 0.0D;
/*    */     
/* 49 */     if (netInput > 0.0D) {
/* 50 */       delta = (this.max - output) * netInput - this.decay * (output - this.rest);
/*    */     } else {
/* 52 */       delta = (output - this.min) * netInput - this.decay * (output - this.rest);
/*    */     }
/* 54 */     output += delta;
/*    */     
/* 56 */     return output;
/*    */   }
/*    */   
/*    */   public double getOutput(double netInput)
/*    */   {
/* 61 */     throw new RuntimeException("Method getOutput(double netInput) not implemented for this type of TransferFunctions. Use getOutput(double netInput, double output)");
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\IACFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */