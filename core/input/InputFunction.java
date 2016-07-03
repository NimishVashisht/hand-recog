/*     */ package org.neuroph.core.input;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Vector;
/*     */ import org.neuroph.core.Connection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InputFunction
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2L;
/*     */   private WeightsFunction weightsFunction;
/*     */   private SummingFunction summingFunction;
/*     */   
/*     */   public InputFunction()
/*     */   {
/*  70 */     this.weightsFunction = new WeightedInput();
/*  71 */     this.summingFunction = new Sum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public InputFunction(WeightsFunction weightsFunction, SummingFunction summingFunction)
/*     */   {
/*  85 */     this.weightsFunction = weightsFunction;
/*  86 */     this.summingFunction = summingFunction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getOutput(Vector<Connection> inputConnections)
/*     */   {
/*  97 */     Vector<Double> inputVector = this.weightsFunction.getOutput(inputConnections);
/*  98 */     double output = this.summingFunction.getOutput(inputVector);
/*     */     
/* 100 */     return output;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SummingFunction getSummingFunction()
/*     */   {
/* 109 */     return this.summingFunction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public WeightsFunction getWeightsFunction()
/*     */   {
/* 118 */     return this.weightsFunction;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\input\InputFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */