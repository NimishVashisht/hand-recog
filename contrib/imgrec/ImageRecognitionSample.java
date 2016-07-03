/*    */ package org.neuroph.contrib.imgrec;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.util.HashMap;
/*    */ import org.neuroph.core.NeuralNetwork;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ImageRecognitionSample
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 39 */     NeuralNetwork nnet = NeuralNetwork.load("MyImageRecognition.nnet");
/*    */     
/* 41 */     ImageRecognitionPlugin imageRecognition = (ImageRecognitionPlugin)nnet.getPlugin("Image Recognition Plugin");
/*    */     
/*    */     try
/*    */     {
/* 45 */       HashMap<String, Double> output = imageRecognition.recognizeImage(new File("someImage.jpg"));
/* 46 */       System.out.println(output.toString());
/*    */     } catch (IOException ioe) {
/* 48 */       ioe.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\imgrec\ImageRecognitionSample.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */