/*     */ package org.neuroph.easyneurons;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.DefaultTreeModel;
/*     */ import javax.swing.tree.TreeModel;
/*     */ import org.neuroph.core.NeuralNetwork;
/*     */ import org.neuroph.core.learning.TrainingSet;
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
/*     */ public class EasyNeuronsProject
/*     */ {
/*     */   private Vector<NeuralNetwork> neuralNetworks;
/*     */   private Vector<TrainingSet> trainingSets;
/*     */   private Vector testSets;
/*     */   
/*     */   public EasyNeuronsProject()
/*     */   {
/*  29 */     this.neuralNetworks = new Vector();
/*  30 */     this.trainingSets = new Vector();
/*  31 */     this.testSets = new Vector();
/*     */   }
/*     */   
/*     */   public Vector<NeuralNetwork> getNeuralNetworks() {
/*  35 */     return this.neuralNetworks;
/*     */   }
/*     */   
/*     */   public void setNeuralNetworks(Vector<NeuralNetwork> neuralNetworks) {
/*  39 */     this.neuralNetworks = neuralNetworks;
/*     */   }
/*     */   
/*     */   public Vector getTestSets() {
/*  43 */     return this.testSets;
/*     */   }
/*     */   
/*     */   public void setTestSets(Vector testSets) {
/*  47 */     this.testSets = testSets;
/*     */   }
/*     */   
/*     */   public Vector<TrainingSet> getTrainingSets() {
/*  51 */     return this.trainingSets;
/*     */   }
/*     */   
/*     */   public void setTrainingSets(Vector<TrainingSet> trainingSets) {
/*  55 */     this.trainingSets = trainingSets;
/*     */   }
/*     */   
/*     */   public void addNeuralNetwork(NeuralNetwork nnet) {
/*  59 */     this.neuralNetworks.add(nnet);
/*     */   }
/*     */   
/*     */   public void addTrainingSet(TrainingSet trainingSet) {
/*  63 */     this.trainingSets.add(trainingSet);
/*     */   }
/*     */   
/*     */ 
/*     */   public void addTestSet() {}
/*     */   
/*     */   public void removeNeuralNetwork(NeuralNetwork nnet)
/*     */   {
/*  71 */     this.neuralNetworks.remove(nnet);
/*     */   }
/*     */   
/*     */   public void removeTrainingSet(TrainingSet trainingSet) {
/*  75 */     this.trainingSets.remove(trainingSet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void removeTestSet() {}
/*     */   
/*     */ 
/*     */   public TreeModel getTreeModel()
/*     */   {
/*  85 */     DefaultMutableTreeNode root = new DefaultMutableTreeNode("easyNeurons Project");
/*     */     
/*     */ 
/*  88 */     DefaultMutableTreeNode child1 = new TreeFolder("Neural networks");
/*  89 */     root.add(child1);
/*     */     
/*  91 */     Iterator<NeuralNetwork> iterator = this.neuralNetworks.iterator();
/*  92 */     while (iterator.hasNext()) {
/*  93 */       DefaultMutableTreeNode child = new DefaultMutableTreeNode(iterator.next());
/*     */       
/*  95 */       child1.add(child);
/*     */     }
/*     */     
/*  98 */     DefaultMutableTreeNode child2 = new TreeFolder("Training Sets");
/*  99 */     root.add(child2);
/*     */     
/* 101 */     Iterator<TrainingSet> tsIterator = this.trainingSets.iterator();
/* 102 */     while (tsIterator.hasNext()) {
/* 103 */       DefaultMutableTreeNode child = new DefaultMutableTreeNode(tsIterator.next());
/*     */       
/* 105 */       child2.add(child);
/*     */     }
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
/* 120 */     TreeModel treeModel = new DefaultTreeModel(root);
/*     */     
/* 122 */     return treeModel;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\EasyNeuronsProject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */