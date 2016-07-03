/*     */ package org.neuroph.core.learning;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Observable;
/*     */ import org.neuroph.core.NeuralNetwork;
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
/*     */ public abstract class LearningRule
/*     */   extends Observable
/*     */   implements Runnable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected NeuralNetwork neuralNetwork;
/*     */   private transient TrainingSet trainingSet;
/*  56 */   private transient boolean stopLearning = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LearningRule() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LearningRule(NeuralNetwork network)
/*     */   {
/*  70 */     this.neuralNetwork = network;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTrainingSet(TrainingSet trainingSet)
/*     */   {
/*  80 */     this.trainingSet = trainingSet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrainingSet getTrainingSet()
/*     */   {
/*  89 */     return this.trainingSet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public NeuralNetwork getNeuralNetwork()
/*     */   {
/*  97 */     return this.neuralNetwork;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNeuralNetwork(NeuralNetwork neuralNetwork)
/*     */   {
/* 106 */     this.neuralNetwork = neuralNetwork;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void run()
/*     */   {
/* 115 */     this.stopLearning = false;
/* 116 */     learn(this.trainingSet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void stopLearning()
/*     */   {
/* 123 */     this.stopLearning = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isStopped()
/*     */   {
/* 131 */     return this.stopLearning;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void notifyChange()
/*     */   {
/* 138 */     setChanged();
/* 139 */     notifyObservers();
/* 140 */     clearChanged();
/*     */   }
/*     */   
/*     */   public abstract void learn(TrainingSet paramTrainingSet);
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\learning\LearningRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */