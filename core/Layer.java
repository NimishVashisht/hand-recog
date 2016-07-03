/*     */ package org.neuroph.core;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import java.util.Vector;
/*     */ import org.neuroph.util.NeuronFactory;
/*     */ import org.neuroph.util.NeuronProperties;
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
/*     */ public class Layer
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2L;
/*     */   private NeuralNetwork parentNetwork;
/*     */   protected Vector<Neuron> neurons;
/*     */   
/*     */   public Layer()
/*     */   {
/*  62 */     this.neurons = new Vector();
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
/*     */   public Layer(int neuronsCount, NeuronProperties neuronProperties)
/*     */   {
/*  75 */     this();
/*     */     
/*  77 */     for (int i = 0; i < neuronsCount; i++) {
/*  78 */       Neuron neuron = NeuronFactory.createNeuron(neuronProperties);
/*  79 */       addNeuron(neuron);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParentNetwork(NeuralNetwork parent)
/*     */   {
/*  90 */     this.parentNetwork = parent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public NeuralNetwork getParentNetwork()
/*     */   {
/*  99 */     return this.parentNetwork;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Iterator<Neuron> getNeuronsIterator()
/*     */   {
/* 108 */     return this.neurons.iterator();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Neuron> getNeurons()
/*     */   {
/* 117 */     return this.neurons;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addNeuron(Neuron neuron)
/*     */   {
/* 127 */     neuron.setParentLayer(this);
/* 128 */     this.neurons.add(neuron);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addNeuron(int idx, Neuron neuron)
/*     */   {
/* 140 */     neuron.setParentLayer(this);
/* 141 */     this.neurons.add(idx, neuron);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNeuron(int idx, Neuron neuron)
/*     */   {
/* 153 */     neuron.setParentLayer(this);
/* 154 */     this.neurons.set(idx, neuron);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeNeuron(Neuron neuron)
/*     */   {
/* 164 */     this.neurons.remove(neuron);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeNeuronAt(int idx)
/*     */   {
/* 174 */     this.neurons.removeElementAt(idx);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Neuron getNeuronAt(int idx)
/*     */   {
/* 185 */     return (Neuron)this.neurons.elementAt(idx);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int indexOf(Neuron neuron)
/*     */   {
/* 196 */     return this.neurons.indexOf(neuron);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getNeuronsCount()
/*     */   {
/* 205 */     return this.neurons.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void calculate()
/*     */   {
/* 212 */     for (Neuron neuron : this.neurons) {
/* 213 */       neuron.calculate();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void reset()
/*     */   {
/* 221 */     for (Neuron neuron : this.neurons) {
/* 222 */       neuron.reset();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void randomizeWeights()
/*     */   {
/* 230 */     for (Neuron neuron : this.neurons) {
/* 231 */       neuron.randomizeInputWeights();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initializeWeights(double value)
/*     */   {
/* 241 */     for (Neuron neuron : this.neurons) {
/* 242 */       neuron.initializeWeights(value);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initializeWeights(Random generator)
/*     */   {
/* 253 */     for (Neuron neuron : this.neurons) {
/* 254 */       neuron.initializeWeights(generator);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\Layer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */