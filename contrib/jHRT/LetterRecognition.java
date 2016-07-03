/*     */ package org.neuroph.contrib.jHRT;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import javax.swing.DefaultListModel;
/*     */ import org.neuroph.contrib.imgrec.ImageRecognitionPlugin;
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
/*     */ public class LetterRecognition
/*     */ {
/*     */   private static final String RESOURCE_PATH = "/org/neuroph/contrib/jHRT/resources/neuralNetwork.nnet";
/*     */   private NeuralNetwork nnet;
/*     */   
/*     */   public LetterRecognition()
/*     */   {
/*  55 */     InputStream nnetStream = getClass().getResourceAsStream("/org/neuroph/contrib/jHRT/resources/neuralNetwork.nnet");
/*  56 */     this.nnet = NeuralNetwork.load(nnetStream);
/*     */   }
/*     */   
/*     */   public LetterRecognition(String file)
/*     */   {
/*  61 */     this.nnet = NeuralNetwork.load(file);
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
/*     */   public void recognize(DefaultListModel model)
/*     */   {
/*  74 */     ImageRecognitionPlugin imageRecognition = (ImageRecognitionPlugin)this.nnet.getPlugin("Image Recognition Plugin");
/*     */     
/*     */ 
/*     */     try
/*     */     {
/*  79 */       HashMap<String, Double> output = imageRecognition.recognizeImage(new File("letter.png"));
/*  80 */       String[] regonition = reogranize(sortHashMapByValuesD(output).toString());
/*     */       
/*  82 */       for (int i = 0; i < regonition.length; i++) {
/*  83 */         model.addElement(regonition[i]);
/*     */       }
/*     */     } catch (IOException e) {
/*  86 */       throw new RuntimeException(e.getMessage());
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
/*     */   private String[] reogranize(String output)
/*     */   {
/*  99 */     return output.substring(1, output.length() - 1).split(", ");
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
/*     */   private LinkedHashMap sortHashMapByValuesD(HashMap passedMap)
/*     */   {
/* 112 */     List mapKeys = new ArrayList(passedMap.keySet());
/* 113 */     List mapValues = new ArrayList(passedMap.values());
/* 114 */     Collections.sort(mapValues);
/* 115 */     Collections.sort(mapKeys);
/* 116 */     Collections.reverse(mapValues);
/*     */     
/* 118 */     LinkedHashMap sortedMap = new LinkedHashMap();
/*     */     
/*     */ 
/* 121 */     Iterator valueIt = mapValues.iterator();
/* 122 */     while (valueIt.hasNext()) {
/* 123 */       Object val = valueIt.next();
/* 124 */       Iterator keyIt = mapKeys.iterator();
/*     */       
/* 126 */       while (keyIt.hasNext()) {
/* 127 */         Object key = keyIt.next();
/* 128 */         String comp1 = passedMap.get(key).toString();
/* 129 */         String comp2 = val.toString();
/*     */         
/* 131 */         if (comp1.equals(comp2)) {
/* 132 */           passedMap.remove(key);
/* 133 */           mapKeys.remove(key);
/* 134 */           sortedMap.put((String)key, (Double)val);
/* 135 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 141 */     return sortedMap;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\jHRT\LetterRecognition.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */