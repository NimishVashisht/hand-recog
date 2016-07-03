/*     */ package org.neuroph.contrib.imgrec;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Vector;
/*     */ import org.neuroph.core.NeuralNetwork;
/*     */ import org.neuroph.core.Neuron;
/*     */ import org.neuroph.core.learning.SupervisedTrainingElement;
/*     */ import org.neuroph.core.learning.TrainingSet;
/*     */ import org.neuroph.nnet.MultiLayerPerceptron;
/*     */ import org.neuroph.nnet.learning.MomentumBackpropagation;
/*     */ import org.neuroph.util.TransferFunctionType;
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
/*     */ public class ImageRecognitionHelper
/*     */ {
/*     */   public static NeuralNetwork createNewNeuralNetwork(String label, Dimension samplingResolution, ColorMode colorMode, List<String> imageLabels, Vector<Integer> layersNeuronsCount, TransferFunctionType transferFunctionType)
/*     */   {
/*     */     int numberOfInputNeurons;
/*     */     int numberOfInputNeurons;
/*  64 */     if (colorMode == ColorMode.FULL_COLOR) {
/*  65 */       numberOfInputNeurons = 3 * samplingResolution.width * samplingResolution.height;
/*     */     } else {
/*  67 */       numberOfInputNeurons = samplingResolution.width * samplingResolution.height;
/*     */     }
/*  69 */     int numberOfOuputNeurons = imageLabels.size();
/*     */     
/*  71 */     layersNeuronsCount.add(0, Integer.valueOf(numberOfInputNeurons));
/*  72 */     layersNeuronsCount.add(Integer.valueOf(numberOfOuputNeurons));
/*     */     
/*  74 */     System.out.println("Neuron layer size counts vector = " + layersNeuronsCount);
/*     */     
/*  76 */     NeuralNetwork neuralNetwork = new MultiLayerPerceptron(layersNeuronsCount, transferFunctionType);
/*  77 */     LabelsPlugin labelsPlugin = (LabelsPlugin)neuralNetwork.getPlugin("LabelsPlugin");
/*  78 */     labelsPlugin.setLabel(neuralNetwork, label);
/*  79 */     PluginBase imageRecognitionPlugin = new ImageRecognitionPlugin(samplingResolution, colorMode);
/*  80 */     neuralNetwork.addPlugin(imageRecognitionPlugin);
/*     */     
/*  82 */     assignLabelsToOutputNeurons(neuralNetwork, imageLabels);
/*  83 */     neuralNetwork.setLearningRule(new MomentumBackpropagation());
/*     */     
/*  85 */     return neuralNetwork;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void assignLabelsToOutputNeurons(NeuralNetwork neuralNetwork, List<String> imageLabels)
/*     */   {
/*  94 */     Vector<Neuron> outputNeurons = neuralNetwork.getOutputNeurons();
/*  95 */     LabelsPlugin labelsPlugin = (LabelsPlugin)neuralNetwork.getPlugin("LabelsPlugin");
/*     */     
/*  97 */     for (int i = 0; i < outputNeurons.size(); i++) {
/*  98 */       Neuron neuron = (Neuron)outputNeurons.get(i);
/*  99 */       String label = (String)imageLabels.get(i);
/* 100 */       labelsPlugin.setLabel(neuron, label);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TrainingSet createTrainingSet(List<String> imageLabels, Map<String, FractionRgbData> rgbDataMap)
/*     */   {
/* 112 */     TrainingSet trainingSet = new TrainingSet();
/*     */     
/* 114 */     for (Map.Entry<String, FractionRgbData> entry : rgbDataMap.entrySet()) {
/* 115 */       double[] input = ((FractionRgbData)entry.getValue()).getFlattenedRgbValues();
/* 116 */       double[] response = createResponse((String)entry.getKey(), imageLabels);
/* 117 */       trainingSet.addElement(new SupervisedTrainingElement(VectorParser.convertToVector(input), VectorParser.convertToVector(response)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 122 */     return trainingSet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TrainingSet createBlackAndWhiteTrainingSet(List<String> imageLabels, Map<String, FractionRgbData> rgbDataMap)
/*     */   {
/* 133 */     TrainingSet trainingSet = new TrainingSet();
/*     */     
/* 135 */     for (Map.Entry<String, FractionRgbData> entry : rgbDataMap.entrySet()) {
/* 136 */       double[] inputRGB = ((FractionRgbData)entry.getValue()).getFlattenedRgbValues();
/* 137 */       double[] inputBW = FractionRgbData.convertRgbInputToBinaryBlackAndWhite(inputRGB);
/* 138 */       double[] response = createResponse((String)entry.getKey(), imageLabels);
/* 139 */       trainingSet.addElement(new SupervisedTrainingElement(VectorParser.convertToVector(inputBW), VectorParser.convertToVector(response)));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 144 */     return trainingSet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static double[] createResponse(String inputLabel, List<String> imageLabels)
/*     */   {
/* 155 */     double[] response = new double[imageLabels.size()];
/* 156 */     int i = 0;
/* 157 */     for (String imageLabel : imageLabels) {
/* 158 */       if (inputLabel.startsWith(imageLabel)) {
/* 159 */         response[i] = 1.0D;
/*     */       } else {
/* 161 */         response[i] = 0.0D;
/*     */       }
/* 163 */       i++;
/*     */     }
/* 165 */     return response;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\imgrec\ImageRecognitionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */