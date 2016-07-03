/*    */ package org.neuroph.contrib.jHRT;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cleaner
/*    */ {
/*    */   public static void scanLetter(BufferedImage image)
/*    */   {
/* 15 */     for (int j = 0; j < image.getHeight(); j++) {
/* 16 */       for (int i = 0; i < image.getWidth(); i++) {
/* 17 */         if ((image.getRGB(i, j) != -1) && (image.getRGB(i, j) != -16777216)) {
/* 18 */           System.out.println(image.getRGB(i, j));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BufferedImage blackAndWhiteCleaning(BufferedImage image)
/*    */   {
/* 31 */     for (int j = 0; j < image.getHeight(); j++) {
/* 32 */       for (int i = 0; i < image.getWidth(); i++) {
/* 33 */         if (image.getRGB(i, j) != -16777216) {
/* 34 */           image.setRGB(i, j, -1);
/*    */         }
/*    */       }
/*    */     }
/* 38 */     return image;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BufferedImage blackAndGrayCleaning(BufferedImage image)
/*    */   {
/* 49 */     for (int j = 0; j < image.getHeight(); j++) {
/* 50 */       for (int i = 0; i < image.getWidth(); i++) {
/* 51 */         if (image.getRGB(i, j) > -4473925) {
/* 52 */           image.setRGB(i, j, -1);
/*    */         } else {
/* 54 */           image.setRGB(i, j, -16777216);
/*    */         }
/*    */       }
/*    */     }
/* 58 */     return image;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BufferedImage blackAndLightGrayCleaning(BufferedImage image)
/*    */   {
/* 69 */     for (int j = 0; j < image.getHeight(); j++) {
/* 70 */       for (int i = 0; i < image.getWidth(); i++) {
/* 71 */         if (image.getRGB(i, j) > -5) {
/* 72 */           image.setRGB(i, j, -1);
/*    */         } else {
/* 74 */           image.setRGB(i, j, -16777216);
/*    */         }
/*    */       }
/*    */     }
/* 78 */     return image;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BufferedImage ColorCleaning(BufferedImage image, int RGBcolor)
/*    */   {
/* 90 */     for (int j = 0; j < image.getHeight(); j++) {
/* 91 */       for (int i = 0; i < image.getWidth(); i++) {
/* 92 */         if (image.getRGB(i, j) == RGBcolor) {
/* 93 */           image.setRGB(i, j, -16777216);
/*    */         } else {
/* 95 */           image.setRGB(i, j, -1);
/*    */         }
/*    */       }
/*    */     }
/* 99 */     return image;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\jHRT\Cleaner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */