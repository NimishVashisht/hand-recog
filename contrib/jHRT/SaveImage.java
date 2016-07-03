/*    */ package org.neuroph.contrib.jHRT;
/*    */ 
/*    */ import java.io.File;
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
/*    */ public class SaveImage
/*    */ {
/*    */   public static int numberOfFiles(String letter)
/*    */   {
/* 46 */     File f = new File("Letters/Training Set/");
/* 47 */     File[] files = f.listFiles();
/* 48 */     int numberOfFiles = 0;
/* 49 */     for (int i = 0; i < files.length; i++) {
/* 50 */       if (files[i].getName().startsWith(letter)) {
/* 51 */         numberOfFiles++;
/*    */       }
/*    */     }
/* 54 */     return numberOfFiles;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void createTrainingSetFolder()
/*    */   {
/* 62 */     File f = new File("Letters");
/* 63 */     f.mkdir();
/* 64 */     File f1 = new File("Letters/Training Set");
/* 65 */     f1.mkdir();
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\jHRT\SaveImage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */