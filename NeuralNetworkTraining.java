/*     */ package org.neuroph.easyneurons;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import org.neuroph.core.NeuralNetwork;
/*     */ import org.neuroph.core.learning.LearningRule;
/*     */ import org.neuroph.core.learning.TrainingSet;
/*     */ import org.neuroph.nnet.learning.BinaryDeltaRule;
/*     */ import org.neuroph.nnet.learning.KohonenLearning;
/*     */ import org.neuroph.nnet.learning.LMS;
/*     */ import org.neuroph.nnet.learning.SupervisedHebbianLearning;
/*     */ 
/*     */ public class NeuralNetworkTraining
/*     */ {
/*     */   NeuralNetwork neuralNet;
/*     */   TrainingSet trainingSet;
/*     */   
/*     */   public NeuralNetworkTraining(NeuralNetwork neuralNet, TrainingSet trainingSet)
/*     */   {
/*  19 */     this.neuralNet = neuralNet;
/*  20 */     this.trainingSet = trainingSet;
/*     */   }
/*     */   
/*     */   public NeuralNetworkTraining(NeuralNetwork neuralNet) {
/*  24 */     this.neuralNet = neuralNet;
/*     */   }
/*     */   
/*     */   public TrainingSet getTrainingSet() {
/*  28 */     return this.trainingSet;
/*     */   }
/*     */   
/*     */   public void setTrainingSet(TrainingSet trainingSet) {
/*  32 */     this.trainingSet = trainingSet;
/*     */   }
/*     */   
/*     */   public void setInput(String netIn) {
/*  36 */     Vector<Double> inVect = org.neuroph.util.VectorParser.parseDouble(netIn);
/*  37 */     this.neuralNet.setInput(inVect);
/*  38 */     this.neuralNet.calculate();
/*  39 */     this.neuralNet.notifyChange();
/*     */   }
/*     */   
/*     */   public void stopTraining() {
/*  43 */     this.neuralNet.stopLearning();
/*     */   }
/*     */   
/*     */   public void pause() {
/*  47 */     this.neuralNet.pauseLearning();
/*     */   }
/*     */   
/*     */   public void resume() {
/*  51 */     this.neuralNet.resumeLearning();
/*     */   }
/*     */   
/*     */   public boolean isStoppedTraining() {
/*  55 */     return this.neuralNet.getLearningRule().isStopped();
/*     */   }
/*     */   
/*     */   public void setLmsParams(Double learningRate, Double maxError, Integer maxIterations)
/*     */   {
/*  60 */     LMS lms = (LMS)this.neuralNet.getLearningRule();
/*  61 */     lms.setLearningRate(learningRate.doubleValue());
/*  62 */     lms.setMaxError(maxError.doubleValue());
/*  63 */     lms.setMaxIterations(maxIterations.intValue());
/*     */   }
/*     */   
/*     */   public void setHebbianParams(Double learningRate, Double maxError, Integer maxIterations)
/*     */   {
/*  68 */     SupervisedHebbianLearning hebbian = (SupervisedHebbianLearning)this.neuralNet.getLearningRule();
/*     */     
/*  70 */     hebbian.setLearningRate(learningRate.doubleValue());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setKohonenParams(Double learningRate, Integer Iphase, Integer IIphase)
/*     */   {
/*  77 */     KohonenLearning kl = (KohonenLearning)this.neuralNet.getLearningRule();
/*  78 */     kl.setLearningRate(learningRate.doubleValue());
/*  79 */     kl.setIterations(Iphase.intValue(), IIphase.intValue());
/*     */   }
/*     */   
/*     */   public void setStepDRParams(Double learningRate, Double maxError, Integer maxIterations) {
/*  83 */     BinaryDeltaRule sdr = (BinaryDeltaRule)this.neuralNet.getLearningRule();
/*  84 */     sdr.setLearningRate(learningRate.doubleValue());
/*  85 */     sdr.setMaxError(maxError.doubleValue());
/*  86 */     sdr.setMaxIterations(maxIterations.intValue());
/*     */   }
/*     */   
/*     */   public void calculate() {
/*  90 */     this.neuralNet.calculate();
/*  91 */     this.neuralNet.notifyChange();
/*     */   }
/*     */   
/*     */   public void train() {
/*  95 */     this.neuralNet.learnInNewThread(this.trainingSet);
/*     */   }
/*     */   
/*     */   public NeuralNetwork getNetwork() {
/*  99 */     return this.neuralNet;
/*     */   }
/*     */   
/*     */   public void randomize() {
/* 103 */     this.neuralNet.randomizeWeights();
/* 104 */     this.neuralNet.notifyChange();
/*     */   }
/*     */   
/*     */   public void reset() {
/* 108 */     this.neuralNet.reset();
/* 109 */     this.neuralNet.notifyChange();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\NeuralNetworkTraining.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */