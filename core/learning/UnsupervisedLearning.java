/*    */ package org.neuroph.core.learning;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Iterator;
/*    */ import java.util.Vector;
/*    */ import org.neuroph.core.NeuralNetwork;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class UnsupervisedLearning
/*    */   extends IterativeLearning
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public UnsupervisedLearning() {}
/*    */   
/*    */   public UnsupervisedLearning(NeuralNetwork neuralNetwork)
/*    */   {
/* 56 */     super(neuralNetwork);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void doLearningEpoch(TrainingSet trainingSet)
/*    */   {
/* 68 */     Iterator<TrainingElement> iterator = trainingSet.iterator();
/* 69 */     while ((iterator.hasNext()) && (!isStopped())) {
/* 70 */       TrainingElement trainingElement = (TrainingElement)iterator.next();
/* 71 */       learnPattern(trainingElement);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void learnPattern(TrainingElement trainingElement)
/*    */   {
/* 82 */     Vector<Double> input = trainingElement.getInput();
/* 83 */     this.neuralNetwork.setInput(input);
/* 84 */     this.neuralNetwork.calculate();
/* 85 */     adjustWeights();
/*    */   }
/*    */   
/*    */   protected abstract void adjustWeights();
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\learning\UnsupervisedLearning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */