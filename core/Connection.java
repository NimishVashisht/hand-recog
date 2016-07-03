/*     */ package org.neuroph.core;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class Connection
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected Neuron connectedNeuron;
/*     */   protected Weight weight;
/*     */   
/*     */   public Connection(Neuron connectTo)
/*     */   {
/*  57 */     this.connectedNeuron = connectTo;
/*  58 */     this.weight = new Weight();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Connection(Neuron connectTo, Weight weight)
/*     */   {
/*  70 */     this.connectedNeuron = connectTo;
/*  71 */     this.weight = weight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Connection(Neuron connectTo, double weightVal)
/*     */   {
/*  83 */     this.connectedNeuron = connectTo;
/*  84 */     this.weight = new Weight(weightVal);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Connection(Neuron from, Neuron connectTo)
/*     */   {
/*  96 */     this.connectedNeuron = connectTo;
/*  97 */     this.weight = new Weight();
/*  98 */     from.addInputConnection(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Weight getWeight()
/*     */   {
/* 107 */     return this.weight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Neuron getConnectedNeuron()
/*     */   {
/* 116 */     return this.connectedNeuron;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getInput()
/*     */   {
/* 126 */     return this.connectedNeuron.getOutput();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getWeightedInput()
/*     */   {
/* 135 */     return getInput() * this.weight.getValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */