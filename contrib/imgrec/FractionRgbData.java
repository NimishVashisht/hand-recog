/*     */ package org.neuroph.contrib.imgrec;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Arrays;
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
/*     */ public class FractionRgbData
/*     */ {
/*     */   private int width;
/*     */   private int height;
/*     */   protected double[][] redValues;
/*     */   protected double[][] greenValues;
/*     */   protected double[][] blueValues;
/*     */   protected double[] flattenedRgbValues;
/*     */   
/*     */   public FractionRgbData(BufferedImage img)
/*     */   {
/*  83 */     this.width = img.getWidth();
/*  84 */     this.height = img.getHeight();
/*     */     
/*  86 */     this.redValues = new double[this.height][this.width];
/*  87 */     this.greenValues = new double[this.height][this.width];
/*  88 */     this.blueValues = new double[this.height][this.width];
/*  89 */     this.flattenedRgbValues = new double[this.width * this.height * 3];
/*     */     
/*  91 */     populateRGBArrays(img);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void populateRGBArrays(BufferedImage img)
/*     */   {
/* 100 */     for (int y = 0; y < this.height; y++) {
/* 101 */       for (int x = 0; x < this.width; x++) {
/* 102 */         Color color = new Color(img.getRGB(x, y));
/*     */         
/* 104 */         double red = color.getRed() / 256.0D;
/* 105 */         this.redValues[y][x] = red;
/* 106 */         this.flattenedRgbValues[(y * this.width + x)] = red;
/*     */         
/* 108 */         double green = color.getGreen() / 256.0D;
/* 109 */         this.greenValues[y][x] = green;
/* 110 */         this.flattenedRgbValues[(this.width * this.height + y * this.width + x)] = green;
/*     */         
/* 112 */         double blue = color.getBlue() / 256.0D;
/* 113 */         this.blueValues[y][x] = blue;
/* 114 */         this.flattenedRgbValues[(2 * this.width * this.height + y * this.width + x)] = blue;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static double[] convertRgbInputToBinaryBlackAndWhite(double[] inputRGB)
/*     */   {
/* 125 */     double[] inputBinary = new double[inputRGB.length / 3];
/*     */     
/* 127 */     for (int i = 0; i < inputRGB.length / 3; i += 3) {
/* 128 */       if (inputRGB[i] > 0.0D) inputBinary[i] = 0.0D; else {
/* 129 */         inputBinary[i] = 1.0D;
/*     */       }
/*     */     }
/* 132 */     return inputBinary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getWidth()
/*     */   {
/* 141 */     return this.width;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getHeight()
/*     */   {
/* 150 */     return this.height;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double[][] getRedValues()
/*     */   {
/* 159 */     return this.redValues;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double[][] getGreenValues()
/*     */   {
/* 168 */     return this.greenValues;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double[][] getBlueValues()
/*     */   {
/* 177 */     return this.blueValues;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double[] getFlattenedRgbValues()
/*     */   {
/* 187 */     return this.flattenedRgbValues;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 193 */     if ((obj == null) || (!(obj instanceof FractionRgbData))) {
/* 194 */       return false;
/*     */     }
/* 196 */     FractionRgbData other = (FractionRgbData)obj;
/* 197 */     return Arrays.equals(this.flattenedRgbValues, other.getFlattenedRgbValues());
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 203 */     return Arrays.hashCode(this.flattenedRgbValues);
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 209 */     return Arrays.toString(this.flattenedRgbValues);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\imgrec\FractionRgbData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */