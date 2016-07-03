/*    */ package org.neuroph.contrib;
/*    */ 
/*    */ import org.neuroph.core.Neuron;
/*    */ import org.neuroph.core.input.InputFunction;
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
/*    */ public class IACNeuron
/*    */   extends Neuron
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private boolean externalInputSet;
/*    */   
/*    */   public IACNeuron()
/*    */   {
/* 45 */     setTransferFunction(new IACFunction());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setInput(double input)
/*    */   {
/* 56 */     this.netInput = input;
/* 57 */     this.externalInputSet = true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void calculate()
/*    */   {
/* 65 */     if (!this.externalInputSet) {
/* 66 */       this.netInput = this.inputFunction.getOutput(this.inputConnections);
/*    */     }
/*    */     
/*    */ 
/* 70 */     this.output = ((IACFunction)this.transferFunction).getOutput(this.netInput, this.output);
/*    */     
/* 72 */     if (this.externalInputSet) {
/* 73 */       this.externalInputSet = false;
/* 74 */       this.netInput = 0.0D;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\IACNeuron.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */