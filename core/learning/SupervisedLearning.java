/*     */ package org.neuroph.core.learning;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SupervisedLearning
/*     */   extends IterativeLearning
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2L;
/*     */   protected double totalNetworkError;
/*     */   protected transient double previousEpochError;
/*  61 */   protected double maxError = 0.01D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  68 */   private transient double minErrorChange = Double.POSITIVE_INFINITY;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */   private transient int minErrorChangeIterationsLimit = Integer.MAX_VALUE;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private transient int minErrorChangeIterationsCount;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SupervisedLearning() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SupervisedLearning(NeuralNetwork network)
/*     */   {
/*  97 */     super(network);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void learn(TrainingSet trainingSet, double maxError)
/*     */   {
/* 107 */     this.maxError = maxError;
/* 108 */     learn(trainingSet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void learn(TrainingSet trainingSet, double maxError, int maxIterations)
/*     */   {
/* 118 */     this.maxError = maxError;
/* 119 */     setMaxIterations(maxIterations);
/* 120 */     learn(trainingSet);
/*     */   }
/*     */   
/*     */   protected void reset()
/*     */   {
/* 125 */     super.reset();
/* 126 */     this.minErrorChangeIterationsCount = 0;
/* 127 */     this.totalNetworkError = 0.0D;
/* 128 */     this.previousEpochError = 0.0D;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void doLearningEpoch(TrainingSet trainingSet)
/*     */   {
/* 146 */     this.previousEpochError = this.totalNetworkError;
/* 147 */     this.totalNetworkError = 0.0D;
/*     */     
/* 149 */     Iterator<TrainingElement> iterator = trainingSet.iterator();
/* 150 */     while ((iterator.hasNext()) && (!isStopped())) {
/* 151 */       TrainingElement trainingElement = (TrainingElement)iterator.next();
/* 152 */       if ((trainingElement instanceof SupervisedTrainingElement)) {
/* 153 */         SupervisedTrainingElement supervisedTrainingElement = (SupervisedTrainingElement)trainingElement;
/* 154 */         learnPattern(supervisedTrainingElement);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 159 */     if (hasReachedStopCondition()) {
/* 160 */       stopLearning();
/*     */     }
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
/*     */   protected boolean hasReachedStopCondition()
/*     */   {
/* 174 */     return (this.totalNetworkError < this.maxError) || (errorChangeStalled());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean errorChangeStalled()
/*     */   {
/* 182 */     double absErrorChange = Math.abs(this.previousEpochError - this.totalNetworkError);
/*     */     
/* 184 */     if (absErrorChange <= this.minErrorChange) {
/* 185 */       this.minErrorChangeIterationsCount += 1;
/*     */       
/* 187 */       if (this.minErrorChangeIterationsCount >= this.minErrorChangeIterationsLimit) {
/* 188 */         return true;
/*     */       }
/*     */     } else {
/* 191 */       this.minErrorChangeIterationsCount = 0;
/*     */     }
/*     */     
/* 194 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void learnPattern(SupervisedTrainingElement trainingElement)
/*     */   {
/* 205 */     Vector<Double> input = trainingElement.getInput();
/* 206 */     this.neuralNetwork.setInput(input);
/* 207 */     this.neuralNetwork.calculate();
/* 208 */     Vector<Double> output = this.neuralNetwork.getOutput();
/* 209 */     Vector<Double> desiredOutput = trainingElement.getDesiredOutput();
/* 210 */     Vector<Double> patternError = getPatternError(output, desiredOutput);
/* 211 */     updateTotalNetworkError(patternError);
/* 212 */     updateNetworkWeights(patternError);
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
/*     */   protected Vector<Double> getPatternError(Vector<Double> output, Vector<Double> desiredOutput)
/*     */   {
/* 226 */     Vector<Double> patternError = new Vector();
/*     */     
/* 228 */     for (int i = 0; i < output.size(); i++) {
/* 229 */       Double outputError = Double.valueOf(((Double)desiredOutput.elementAt(i)).doubleValue() - ((Double)output.elementAt(i)).doubleValue());
/* 230 */       patternError.add(outputError);
/*     */     }
/*     */     
/* 233 */     return patternError;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMaxError(double maxError)
/*     */   {
/* 245 */     this.maxError = maxError;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getMaxError()
/*     */   {
/* 255 */     return this.maxError;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized Double getTotalNetworkError()
/*     */   {
/* 266 */     return new Double(this.totalNetworkError);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getPreviousEpochError()
/*     */   {
/* 275 */     return this.previousEpochError;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getMinErrorChange()
/*     */   {
/* 284 */     return this.minErrorChange;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMinErrorChange(double minErrorChange)
/*     */   {
/* 293 */     this.minErrorChange = minErrorChange;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMinErrorChangeIterationsLimit()
/*     */   {
/* 302 */     return this.minErrorChangeIterationsLimit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMinErrorChangeIterationsLimit(int minErrorChangeIterationsLimit)
/*     */   {
/* 310 */     this.minErrorChangeIterationsLimit = minErrorChangeIterationsLimit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMinErrorChangeIterationsCount()
/*     */   {
/* 319 */     return this.minErrorChangeIterationsCount;
/*     */   }
/*     */   
/*     */   protected abstract void updateTotalNetworkError(Vector<Double> paramVector);
/*     */   
/*     */   protected abstract void updateNetworkWeights(Vector<Double> paramVector);
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\learning\SupervisedLearning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */