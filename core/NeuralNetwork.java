/*     */ package org.neuroph.core;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Observable;
/*     */ import java.util.Random;
/*     */ import java.util.Vector;
/*     */ import org.neuroph.core.learning.IterativeLearning;
/*     */ import org.neuroph.core.learning.LearningRule;
/*     */ import org.neuroph.core.learning.TrainingSet;
/*     */ import org.neuroph.util.NeuralNetworkType;
/*     */ import org.neuroph.util.VectorParser;
/*     */ import org.neuroph.util.plugins.LabelsPlugin;
/*     */ import org.neuroph.util.plugins.PluginBase;
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
/*     */ public class NeuralNetwork
/*     */   extends Observable
/*     */   implements Runnable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3L;
/*     */   private NeuralNetworkType type;
/*     */   private Vector<Layer> layers;
/*     */   private Vector<Neuron> inputNeurons;
/*     */   private Vector<Neuron> outputNeurons;
/*     */   private LearningRule learningRule;
/*     */   private transient Thread learningThread;
/*     */   private Map<String, PluginBase> plugins;
/*     */   
/*     */   public NeuralNetwork()
/*     */   {
/* 109 */     this.layers = new Vector();
/* 110 */     this.plugins = new HashMap();
/* 111 */     addPlugin(new LabelsPlugin());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addLayer(Layer layer)
/*     */   {
/* 121 */     layer.setParentNetwork(this);
/* 122 */     this.layers.add(layer);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addLayer(int idx, Layer layer)
/*     */   {
/* 134 */     layer.setParentNetwork(this);
/* 135 */     this.layers.add(idx, layer);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeLayer(Layer layer)
/*     */   {
/* 145 */     this.layers.removeElement(layer);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeLayerAt(int idx)
/*     */   {
/* 156 */     this.layers.removeElementAt(idx);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Iterator<Layer> getLayersIterator()
/*     */   {
/* 165 */     return this.layers.iterator();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Layer> getLayers()
/*     */   {
/* 174 */     return this.layers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Layer getLayerAt(int idx)
/*     */   {
/* 185 */     return (Layer)this.layers.elementAt(idx);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int indexOf(Layer layer)
/*     */   {
/* 196 */     return this.layers.indexOf(layer);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getLayersCount()
/*     */   {
/* 205 */     return this.layers.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInput(Vector<Double> inputVector)
/*     */   {
/* 215 */     if (inputVector.size() != this.inputNeurons.size()) {
/* 216 */       throw new RuntimeException("Input vector size does not match network input dimension!");
/*     */     }
/*     */     
/* 219 */     Iterator<Double> inputIterator = inputVector.iterator();
/*     */     
/* 221 */     for (Neuron neuron : this.inputNeurons) {
/* 222 */       Double input = (Double)inputIterator.next();
/* 223 */       neuron.setInput(input.doubleValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInput(double... inputArray)
/*     */   {
/* 234 */     if (inputArray.length != this.inputNeurons.size())
/* 235 */       throw new RuntimeException("Input vector size does not match network input dimension!");
/* 236 */     setInput(VectorParser.convertToVector(inputArray));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Double> getOutput()
/*     */   {
/* 246 */     Vector<Double> outputVector = new Vector();
/*     */     
/* 248 */     for (Neuron neuron : this.outputNeurons) {
/* 249 */       double output = neuron.getOutput();
/* 250 */       outputVector.add(new Double(output));
/*     */     }
/*     */     
/* 253 */     return outputVector;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double[] getOutputAsArray()
/*     */   {
/* 262 */     return VectorParser.convertToArray(getOutput());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void calculate()
/*     */   {
/* 269 */     for (Layer layer : this.layers) {
/* 270 */       layer.calculate();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void reset()
/*     */   {
/* 278 */     for (Layer layer : this.layers) {
/* 279 */       layer.reset();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void run()
/*     */   {
/* 289 */     calculate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   public void learn(TrainingSet trainingSetToLearn)
/*     */   {
/* 300 */     learnInNewThread(trainingSetToLearn);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void learnInNewThread(TrainingSet trainingSetToLearn)
/*     */   {
/* 310 */     this.learningRule.setTrainingSet(trainingSetToLearn);
/* 311 */     this.learningThread = new Thread(this.learningRule);
/* 312 */     this.learningThread.start();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void learnInNewThread(TrainingSet trainingSetToLearn, LearningRule learningRule)
/*     */   {
/* 324 */     setLearningRule(learningRule);
/* 325 */     learningRule.setTrainingSet(trainingSetToLearn);
/* 326 */     this.learningThread = new Thread(learningRule);
/* 327 */     this.learningThread.start();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void learnInSameThread(TrainingSet trainingSetToLearn)
/*     */   {
/* 337 */     this.learningRule.setTrainingSet(trainingSetToLearn);
/* 338 */     this.learningRule.run();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void learnInSameThread(TrainingSet trainingSetToLearn, LearningRule learningRule)
/*     */   {
/* 350 */     setLearningRule(learningRule);
/* 351 */     learningRule.setTrainingSet(trainingSetToLearn);
/* 352 */     learningRule.run();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void stopLearning()
/*     */   {
/* 359 */     this.learningRule.stopLearning();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void pauseLearning()
/*     */   {
/* 367 */     if ((this.learningRule instanceof IterativeLearning)) {
/* 368 */       ((IterativeLearning)this.learningRule).pause();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void resumeLearning()
/*     */   {
/* 375 */     if ((this.learningRule instanceof IterativeLearning)) {
/* 376 */       ((IterativeLearning)this.learningRule).resume();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void randomizeWeights()
/*     */   {
/* 383 */     for (Layer layer : this.layers) {
/* 384 */       layer.randomizeWeights();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initializeWeights(double value)
/*     */   {
/* 394 */     for (Layer layer : this.layers) {
/* 395 */       layer.initializeWeights(value);
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
/* 406 */     for (Layer layer : this.layers) {
/* 407 */       layer.initializeWeights(generator);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public NeuralNetworkType getNetworkType()
/*     */   {
/* 417 */     return this.type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setNetworkType(NeuralNetworkType type)
/*     */   {
/* 426 */     this.type = type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Neuron> getInputNeurons()
/*     */   {
/* 435 */     return this.inputNeurons;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInputNeurons(Vector<Neuron> inputNeurons)
/*     */   {
/* 445 */     this.inputNeurons = inputNeurons;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Neuron> getOutputNeurons()
/*     */   {
/* 454 */     return this.outputNeurons;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setOutputNeurons(Vector<Neuron> outputNeurons)
/*     */   {
/* 464 */     this.outputNeurons = outputNeurons;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public LearningRule getLearningRule()
/*     */   {
/* 473 */     return this.learningRule;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLearningRule(LearningRule learningRule)
/*     */   {
/* 482 */     learningRule.setNeuralNetwork(this);
/* 483 */     this.learningRule = learningRule;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Thread getLearningThread()
/*     */   {
/* 491 */     return this.learningThread;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void notifyChange()
/*     */   {
/* 498 */     setChanged();
/* 499 */     notifyObservers();
/* 500 */     clearChanged();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void createConnection(Neuron fromNeuron, Neuron toNeuron, double weightVal)
/*     */   {
/* 511 */     Connection connection = new Connection(fromNeuron, weightVal);
/* 512 */     toNeuron.addInputConnection(connection);
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 518 */     if (this.plugins.containsKey("LabelsPlugin")) {
/* 519 */       LabelsPlugin labelsPlugin = (LabelsPlugin)getPlugin("LabelsPlugin");
/* 520 */       String label = labelsPlugin.getLabel(this);
/* 521 */       if (label != null) { return label;
/*     */       }
/*     */     }
/* 524 */     return super.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void save(String filePath)
/*     */   {
/* 534 */     ObjectOutputStream out = null;
/*     */     try {
/* 536 */       File file = new File(filePath);
/* 537 */       out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
/* 538 */       out.writeObject(this);
/* 539 */       out.flush(); return;
/*     */     } catch (IOException ioe) {
/* 541 */       ioe.printStackTrace();
/*     */     } finally {
/* 543 */       if (out != null) {
/*     */         try {
/* 545 */           out.close();
/*     */         }
/*     */         catch (IOException e) {}
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static NeuralNetwork load(String filePath)
/*     */   {
/* 560 */     ObjectInputStream oistream = null;
/*     */     try
/*     */     {
/* 563 */       File file = new File(filePath);
/* 564 */       if (!file.exists()) {
/* 565 */         throw new FileNotFoundException("Cannot find file: " + filePath);
/*     */       }
/*     */       
/* 568 */       oistream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)));
/* 569 */       NeuralNetwork nnet = (NeuralNetwork)oistream.readObject();
/*     */       
/* 571 */       return nnet;
/*     */     }
/*     */     catch (IOException ioe) {
/* 574 */       ioe.printStackTrace();
/*     */     } catch (ClassNotFoundException cnfe) {
/* 576 */       cnfe.printStackTrace();
/*     */     } finally {
/* 578 */       if (oistream != null) {
/*     */         try {
/* 580 */           oistream.close();
/*     */         }
/*     */         catch (IOException ioe) {}
/*     */       }
/*     */     }
/*     */     
/* 586 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static NeuralNetwork load(InputStream inputStream)
/*     */   {
/* 597 */     ObjectInputStream oistream = null;
/*     */     try
/*     */     {
/* 600 */       oistream = new ObjectInputStream(new BufferedInputStream(inputStream));
/* 601 */       NeuralNetwork nnet = (NeuralNetwork)oistream.readObject();
/*     */       
/* 603 */       return nnet;
/*     */     }
/*     */     catch (IOException ioe) {
/* 606 */       ioe.printStackTrace();
/*     */     } catch (ClassNotFoundException cnfe) {
/* 608 */       cnfe.printStackTrace();
/*     */     } finally {
/* 610 */       if (oistream != null) {
/*     */         try {
/* 612 */           oistream.close();
/*     */         }
/*     */         catch (IOException ioe) {}
/*     */       }
/*     */     }
/*     */     
/* 618 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addPlugin(PluginBase plugin)
/*     */   {
/* 626 */     plugin.setParentNetwork(this);
/* 627 */     this.plugins.put(plugin.getName(), plugin);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public PluginBase getPlugin(String pluginName)
/*     */   {
/* 636 */     return (PluginBase)this.plugins.get(pluginName);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removePlugin(String pluginName)
/*     */   {
/* 644 */     this.plugins.remove(pluginName);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\NeuralNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */