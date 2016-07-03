/*     */ package org.neuroph.core.learning;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public abstract class IterativeLearning
/*     */   extends LearningRule
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  44 */   protected double learningRate = 0.1D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  49 */   protected int currentIteration = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  56 */   protected int maxIterations = Integer.MAX_VALUE;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  61 */   protected boolean iterationsLimited = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  66 */   private transient boolean pausedLearning = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public IterativeLearning() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public IterativeLearning(NeuralNetwork network)
/*     */   {
/*  83 */     super(network);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getLearningRate()
/*     */   {
/*  92 */     return this.learningRate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLearningRate(double learningRate)
/*     */   {
/* 102 */     this.learningRate = learningRate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMaxIterations(int maxIterations)
/*     */   {
/* 112 */     this.maxIterations = maxIterations;
/* 113 */     this.iterationsLimited = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getCurrentIteration()
/*     */   {
/* 122 */     return new Integer(this.currentIteration);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isPausedLearning()
/*     */   {
/* 130 */     return this.pausedLearning;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void pause()
/*     */   {
/* 137 */     this.pausedLearning = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void resume()
/*     */   {
/* 144 */     this.pausedLearning = false;
/* 145 */     synchronized (this) {
/* 146 */       notify();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void reset()
/*     */   {
/* 154 */     this.currentIteration = 0;
/*     */   }
/*     */   
/*     */   public void learn(TrainingSet trainingSet)
/*     */   {
/* 159 */     reset();
/*     */     
/* 161 */     while (!isStopped()) {
/* 162 */       doLearningEpoch(trainingSet);
/* 163 */       this.currentIteration += 1;
/* 164 */       if ((this.iterationsLimited) && (this.currentIteration == this.maxIterations)) {
/* 165 */         stopLearning();
/* 166 */       } else if ((!this.iterationsLimited) && (this.currentIteration == Integer.MAX_VALUE))
/*     */       {
/* 168 */         this.currentIteration = 1;
/*     */       }
/*     */       
/* 171 */       notifyChange();
/*     */       
/*     */ 
/* 174 */       if (this.pausedLearning == true) {
/* 175 */         synchronized (this) {
/* 176 */           while (this.pausedLearning) {
/*     */             try {
/* 178 */               wait();
/*     */             }
/*     */             catch (Exception e) {}
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void learn(TrainingSet trainingSet, int maxIterations)
/*     */   {
/* 194 */     setMaxIterations(maxIterations);
/* 195 */     learn(trainingSet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void doOneLearningIteration(TrainingSet trainingSet)
/*     */   {
/* 204 */     doLearningEpoch(trainingSet);
/* 205 */     notifyChange();
/*     */   }
/*     */   
/*     */   public abstract void doLearningEpoch(TrainingSet paramTrainingSet);
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\learning\IterativeLearning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */