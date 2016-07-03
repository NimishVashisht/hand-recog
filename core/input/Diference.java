/*    */ package org.neuroph.core.input;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Vector;
/*    */ import org.neuroph.core.Connection;
/*    */ import org.neuroph.core.Neuron;
/*    */ import org.neuroph.core.Weight;
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
/*    */ public class Diference
/*    */   extends WeightsFunction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 21L;
/*    */   
/*    */   public Vector<Double> getOutput(Vector<Connection> inputConnections)
/*    */   {
/* 46 */     Vector<Double> inputVector = new Vector();
/*    */     
/* 48 */     for (Connection connection : inputConnections) {
/* 49 */       Neuron neuron = connection.getConnectedNeuron();
/*    */       
/* 51 */       Weight weight = connection.getWeight();
/* 52 */       double input = neuron.getOutput() - weight.getValue();
/*    */       
/* 54 */       inputVector.addElement(Double.valueOf(input));
/*    */     }
/*    */     
/* 57 */     return inputVector;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\input\Diference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */