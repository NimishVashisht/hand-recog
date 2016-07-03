/*     */ package org.neuroph.contrib.imgrec;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Robot;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.geom.Rectangle2D.Double;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImageSampler
/*     */ {
/*     */   public static BufferedImage scanLocationUsingScreenshot(Robot robot, Rectangle2D.Double rectangleAsDecimalPercent, Dimension samplingResolution)
/*     */   {
/*  64 */     return scanLocationUsingScreenshot(robot, rectangleAsDecimalPercent, samplingResolution, 1);
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
/*     */ 
/*     */ 
/*     */   public static BufferedImage scanLocationUsingScreenshot(Robot robot, Rectangle2D.Double rectangleAsDecimalPercent, Dimension samplingResolution, int imageType)
/*     */   {
/*  79 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*     */     
/*  81 */     int inspectX = (int)Math.round(screenSize.width * rectangleAsDecimalPercent.x);
/*  82 */     int inspectY = (int)Math.round(screenSize.height * rectangleAsDecimalPercent.y);
/*  83 */     int inspectWidth = (int)Math.round(screenSize.width * rectangleAsDecimalPercent.width);
/*  84 */     int inspectHeight = (int)Math.round(screenSize.height * rectangleAsDecimalPercent.height);
/*     */     
/*  86 */     Rectangle screenRect = new Rectangle(inspectX, inspectY, inspectWidth, inspectHeight);
/*  87 */     BufferedImage screenCapture = robot.createScreenCapture(screenRect);
/*     */     
/*     */ 
/*  90 */     return downSampleImage(samplingResolution, screenCapture, imageType);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static BufferedImage downSampleImage(Dimension samplingResolution, BufferedImage bigImg)
/*     */   {
/* 101 */     return downSampleImage(samplingResolution, bigImg, 1);
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
/*     */ 
/*     */ 
/*     */   public static BufferedImage downSampleImage(Dimension samplingResolution, BufferedImage bigImg, int returnImageType)
/*     */   {
/* 116 */     int numberOfSamplesAcross = samplingResolution.width;
/* 117 */     int numberOfSamplesDown = samplingResolution.height;
/*     */     
/* 119 */     if ((bigImg.getWidth() <= numberOfSamplesAcross) || (bigImg.getHeight() <= numberOfSamplesDown)) {
/* 120 */       return bigImg;
/*     */     }
/*     */     
/* 123 */     BufferedImage img = new BufferedImage(numberOfSamplesAcross, numberOfSamplesDown, returnImageType);
/*     */     
/*     */ 
/*     */ 
/* 127 */     double samplingIncrementX = bigImg.getWidth() / (samplingResolution.getWidth() - 1.0D);
/* 128 */     double samplingIncrementY = bigImg.getHeight() / (samplingResolution.getHeight() - 1.0D);
/*     */     
/* 130 */     double sampleX = 0.0D;
/* 131 */     double sampleY = 0.0D;
/* 132 */     for (int y = 0; y < numberOfSamplesDown; y++) {
/* 133 */       for (int x = 0; x < numberOfSamplesAcross; x++) {
/* 134 */         int inspectX = (int)Math.round(sampleX);
/* 135 */         int inspectY = (int)Math.round(sampleY);
/*     */         
/* 137 */         if (inspectX >= bigImg.getWidth()) {
/* 138 */           inspectX = bigImg.getWidth() - 1;
/*     */         }
/* 140 */         if (inspectY >= bigImg.getHeight()) {
/* 141 */           inspectY = bigImg.getHeight() - 1;
/*     */         }
/* 143 */         int color = bigImg.getRGB(inspectX, inspectY);
/* 144 */         img.setRGB(x, y, color);
/* 145 */         sampleX += samplingIncrementX;
/*     */       }
/* 147 */       sampleX = 0.0D;
/* 148 */       sampleY += samplingIncrementY;
/*     */     }
/*     */     
/* 151 */     return img;
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
/*     */   public static BufferedImage scanLocationUsingSampling(Robot robot, Rectangle2D.Double rectangleAsDecimalPercent, Dimension samplingResolution)
/*     */   {
/* 164 */     return scanLocationUsingSampling(robot, rectangleAsDecimalPercent, samplingResolution, 1);
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
/*     */ 
/*     */ 
/*     */   public static BufferedImage scanLocationUsingSampling(Robot robot, Rectangle2D.Double rectangleAsDecimalPercent, Dimension samplingResolution, int imageType)
/*     */   {
/* 179 */     double slotULXAsDecimalPercent = rectangleAsDecimalPercent.x;
/* 180 */     double slotULYAsDecimalPercent = rectangleAsDecimalPercent.y;
/* 181 */     double sampleIncrementAcrossAsDecimalPercent = rectangleAsDecimalPercent.width / (samplingResolution.getWidth() - 1.0D);
/* 182 */     double sampleIncrementDownAsDecimalPercent = rectangleAsDecimalPercent.height / (samplingResolution.getHeight() - 1.0D);
/*     */     
/* 184 */     int numberOfSamplesAcross = samplingResolution.width;
/* 185 */     int numberOfSamplesDown = samplingResolution.height;
/* 186 */     BufferedImage img = new BufferedImage(numberOfSamplesAcross, numberOfSamplesDown, imageType);
/*     */     
/*     */ 
/*     */ 
/* 190 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*     */     
/* 192 */     waitForVerticalScreenRefresh();
/*     */     
/* 194 */     double inspectXAsDecimalPercent = slotULXAsDecimalPercent;
/* 195 */     double inspectYAsDecimalPercent = slotULYAsDecimalPercent;
/* 196 */     for (int y = 0; y < numberOfSamplesDown; y++) {
/* 197 */       for (int x = 0; x < numberOfSamplesAcross; x++) {
/* 198 */         int inspectX = (int)Math.round(screenSize.width * inspectXAsDecimalPercent);
/* 199 */         int inspectY = (int)Math.round(screenSize.height * inspectYAsDecimalPercent);
/* 200 */         Color color = robot.getPixelColor(inspectX, inspectY);
/* 201 */         img.setRGB(x, y, color.getRGB());
/* 202 */         inspectXAsDecimalPercent += sampleIncrementAcrossAsDecimalPercent;
/*     */       }
/* 204 */       inspectXAsDecimalPercent = slotULXAsDecimalPercent;
/* 205 */       inspectYAsDecimalPercent += sampleIncrementDownAsDecimalPercent;
/*     */     }
/* 207 */     return img;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void waitForVerticalScreenRefresh()
/*     */   {
/* 215 */     Toolkit.getDefaultToolkit().sync();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\imgrec\ImageSampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */