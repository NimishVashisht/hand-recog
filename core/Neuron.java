/*     */ package org.neuroph.core;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import java.util.Vector;
/*     */ import org.neuroph.core.input.InputFunction;
/*     */ import org.neuroph.core.transfer.Step;
/*     */ import org.neuroph.core.transfer.TransferFunction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Neuron
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3L;
/*     */   protected Layer parentLayer;
/*  62 */   protected Vector<Connection> inputConnections = new Vector();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  68 */   protected Vector<Connection> outConnections = new Vector();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  74 */   protected transient double netInput = 0.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  79 */   protected transient double output = 0.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  84 */   protected transient double error = 0.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected InputFunction inputFunction;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected TransferFunction transferFunction;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Neuron()
/*     */   {
/* 102 */     this.inputFunction = new InputFunction();
/* 103 */     this.transferFunction = new Step();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Neuron(InputFunction inputFunction, TransferFunction transferFunction)
/*     */   {
/* 115 */     this.inputFunction = inputFunction;
/* 116 */     this.transferFunction = transferFunction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void calculate()
/*     */   {
/* 123 */     if (hasInputConnections()) {
/* 124 */       this.netInput = this.inputFunction.getOutput(this.inputConnections);
/*     */     }
/* 126 */     this.output = this.transferFunction.getOutput(this.netInput);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void reset()
/*     */   {
/* 133 */     setInput(0.0D);
/* 134 */     setOutput(0.0D);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInput(double input)
/*     */   {
/* 144 */     this.netInput = input;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getNetInput()
/*     */   {
/* 153 */     return this.netInput;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getOutput()
/*     */   {
/* 162 */     return this.output;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasInputConnections()
/*     */   {
/* 172 */     return !this.inputConnections.isEmpty();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Iterator<Connection> getInputsIterator()
/*     */   {
/* 181 */     return this.inputConnections.iterator();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addInputConnection(Connection connection)
/*     */   {
/* 191 */     this.inputConnections.add(connection);
/* 192 */     Neuron connected = connection.getConnectedNeuron();
/* 193 */     Connection backConnection = new Connection(this, connection.getWeight());
/* 194 */     connected.addOutputConnection(backConnection);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addInputConnection(Neuron fromNeuron)
/*     */   {
/* 204 */     Connection connection = new Connection(fromNeuron);
/* 205 */     addInputConnection(connection);
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
/*     */   public void addInputConnection(Neuron fromNeuron, double weightVal)
/*     */   {
/* 218 */     Connection connection = new Connection(fromNeuron, weightVal);
/* 219 */     addInputConnection(connection);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void addOutputConnection(Connection connection)
/*     */   {
/* 228 */     this.outConnections.add(connection);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Connection> getInputConnections()
/*     */   {
/* 237 */     return this.inputConnections;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Connection> getOutConnections()
/*     */   {
/* 246 */     return this.outConnections;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeInputConnectionFrom(Neuron fromNeuron)
/*     */   {
/* 256 */     for (Connection connection : this.inputConnections) {
/* 257 */       if (connection.getConnectedNeuron() == fromNeuron) {
/* 258 */         this.inputConnections.remove(connection);
/* 259 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Connection getConnectionFrom(Neuron fromNeuron)
/*     */   {
/* 269 */     for (Connection connection : this.inputConnections) {
/* 270 */       if (connection.getConnectedNeuron() == fromNeuron)
/* 271 */         return connection;
/*     */     }
/* 273 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInputFunction(InputFunction inputFunction)
/*     */   {
/* 283 */     this.inputFunction = inputFunction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTransferFunction(TransferFunction transferFunction)
/*     */   {
/* 293 */     this.transferFunction = transferFunction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public InputFunction getInputFunction()
/*     */   {
/* 302 */     return this.inputFunction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TransferFunction getTransferFunction()
/*     */   {
/* 311 */     return this.transferFunction;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setParentLayer(Layer parent)
/*     */   {
/* 322 */     this.parentLayer = parent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Layer getParentLayer()
/*     */   {
/* 331 */     return this.parentLayer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Weight> getWeightsVector()
/*     */   {
/* 340 */     Vector<Weight> weights = new Vector();
/* 341 */     for (Connection connection : this.inputConnections) {
/* 342 */       Weight weight = connection.getWeight();
/* 343 */       weights.addElement(weight);
/*     */     }
/* 345 */     return weights;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getError()
/*     */   {
/* 354 */     return this.error;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setError(double error)
/*     */   {
/* 364 */     this.error = error;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOutput(double output)
/*     */   {
/* 374 */     this.output = output;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void randomizeInputWeights()
/*     */   {
/* 381 */     for (Connection connection : this.inputConnections) {
/* 382 */       connection.getWeight().randomize();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initializeWeights(double value)
/*     */   {
/* 391 */     for (Connection connection : this.inputConnections) {
/* 392 */       connection.getWeight().setValue(value);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initializeWeights(Random generator)
/*     */   {
/* 401 */     for (Connection connection : this.inputConnections) {
/* 402 */       connection.getWeight().setValue(generator.nextDouble());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\Neuron.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */