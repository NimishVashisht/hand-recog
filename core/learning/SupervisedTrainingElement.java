/*     */ package org.neuroph.core.learning;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Vector;
/*     */ import org.neuroph.util.VectorParser;
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
/*     */ public class SupervisedTrainingElement
/*     */   extends TrainingElement
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Vector<Double> desiredOutput;
/*     */   
/*     */   public SupervisedTrainingElement(Vector<Double> input, Vector<Double> desiredOutput)
/*     */   {
/*  58 */     super(input);
/*  59 */     this.desiredOutput = desiredOutput;
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
/*     */   public SupervisedTrainingElement(String input, String desiredOutput)
/*     */   {
/*  72 */     super(input);
/*  73 */     this.desiredOutput = VectorParser.parseDouble(desiredOutput);
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
/*     */   public SupervisedTrainingElement(double[] input, double[] desiredOutput)
/*     */   {
/*  86 */     super(input);
/*     */     
/*  88 */     this.desiredOutput = new Vector();
/*  89 */     for (int i = 0; i < desiredOutput.length; i++) {
/*  90 */       this.desiredOutput.add(new Double(desiredOutput[i]));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Double> getDesiredOutput()
/*     */   {
/*  99 */     return this.desiredOutput;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDesiredOutput(Vector<Double> desiredOutput)
/*     */   {
/* 109 */     this.desiredOutput = desiredOutput;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\learning\SupervisedTrainingElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */