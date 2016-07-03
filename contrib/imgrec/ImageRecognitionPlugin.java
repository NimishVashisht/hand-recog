/*     */ package org.neuroph.contrib.imgrec;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.Vector;
/*     */ import javax.imageio.ImageIO;
/*     */ import org.neuroph.core.NeuralNetwork;
/*     */ import org.neuroph.core.Neuron;
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
/*     */ public class ImageRecognitionPlugin
/*     */   extends PluginBase
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String IMG_REC_PLUGIN_NAME = "Image Recognition Plugin";
/*     */   private Dimension samplingResolution;
/*     */   private ColorMode colorMode;
/*     */   
/*     */   public ImageRecognitionPlugin(Dimension samplingResolution)
/*     */   {
/*  66 */     super("Image Recognition Plugin");
/*  67 */     this.samplingResolution = samplingResolution;
/*  68 */     this.colorMode = ColorMode.FULL_COLOR;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ImageRecognitionPlugin(Dimension samplingResolution, ColorMode colorMode)
/*     */   {
/*  79 */     super("Image Recognition Plugin");
/*  80 */     this.samplingResolution = samplingResolution;
/*  81 */     this.colorMode = colorMode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Dimension getSamplingResolution()
/*     */   {
/*  90 */     return this.samplingResolution;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ColorMode getColorMode()
/*     */   {
/*  98 */     return this.colorMode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInput(BufferedImage img)
/*     */   {
/* 109 */     FractionRgbData imgRgb = new FractionRgbData(ImageSampler.downSampleImage(this.samplingResolution, img));
/*     */     
/*     */     double[] input;
/*     */     
/* 113 */     if (this.colorMode == ColorMode.FULL_COLOR) {
/* 114 */       input = imgRgb.getFlattenedRgbValues(); } else { double[] input;
/* 115 */       if (this.colorMode == ColorMode.BLACK_AND_WHITE) {
/* 116 */         input = FractionRgbData.convertRgbInputToBinaryBlackAndWhite(imgRgb.getFlattenedRgbValues());
/*     */       }
/*     */       else
/* 119 */         throw new RuntimeException("Unknown color mode!"); }
/*     */     double[] input;
/* 121 */     getParentNetwork().setInput(input);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInput(File imgFile)
/*     */     throws IOException
/*     */   {
/* 131 */     BufferedImage img = ImageIO.read(imgFile);
/* 132 */     setInput(img);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInput(URL imgURL)
/*     */     throws IOException
/*     */   {
/* 142 */     BufferedImage img = ImageIO.read(imgURL);
/* 143 */     setInput(img);
/*     */   }
/*     */   
/*     */   public void processInput() {
/* 147 */     getParentNetwork().calculate();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HashMap<String, Double> getOutput()
/*     */   {
/* 157 */     LabelsPlugin labelsPlugin = (LabelsPlugin)getParentNetwork().getPlugin("LabelsPlugin");
/*     */     
/* 159 */     HashMap<String, Double> networkOutput = new HashMap();
/*     */     
/* 161 */     for (Neuron neuron : getParentNetwork().getOutputNeurons()) {
/* 162 */       String neuronLabel = labelsPlugin.getLabel(neuron);
/* 163 */       networkOutput.put(neuronLabel, Double.valueOf(neuron.getOutput()));
/*     */     }
/*     */     
/* 166 */     return networkOutput;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HashMap<String, Double> recognizeImage(BufferedImage img)
/*     */   {
/* 178 */     setInput(img);
/* 179 */     processInput();
/* 180 */     return getOutput();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HashMap<String, Double> recognizeImage(File imgFile)
/*     */     throws IOException
/*     */   {
/* 191 */     setInput(imgFile);
/* 192 */     processInput();
/* 193 */     return getOutput();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HashMap<String, Double> recognizeImage(URL imgURL)
/*     */     throws IOException
/*     */   {
/* 204 */     setInput(imgURL);
/* 205 */     processInput();
/* 206 */     return getOutput();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HashMap<String, Neuron> getMaxOutput()
/*     */   {
/* 216 */     HashMap<String, Neuron> maxOutput = new HashMap();
/* 217 */     Neuron maxNeuron = (Neuron)getParentNetwork().getOutputNeurons().elementAt(0);
/*     */     
/*     */ 
/* 220 */     for (Neuron neuron : getParentNetwork().getOutputNeurons()) {
/* 221 */       if (neuron.getOutput() > maxNeuron.getOutput()) {
/* 222 */         maxNeuron = neuron;
/*     */       }
/*     */     }
/* 225 */     LabelsPlugin labels = (LabelsPlugin)getParentNetwork().getPlugin("LabelsPlugin");
/*     */     
/*     */ 
/* 228 */     maxOutput.put(labels.getLabel(maxNeuron), maxNeuron);
/*     */     
/* 230 */     for (Neuron neuron : getParentNetwork().getOutputNeurons()) {
/* 231 */       if (neuron.getOutput() == maxNeuron.getOutput()) {
/* 232 */         maxOutput.put(labels.getLabel(neuron), neuron);
/*     */       }
/*     */     }
/*     */     
/* 236 */     return maxOutput;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\imgrec\ImageRecognitionPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */