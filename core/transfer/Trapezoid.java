/*     */ package org.neuroph.core.transfer;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import org.neuroph.util.Properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Trapezoid
/*     */   extends TransferFunction
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   double leftLow;
/*     */   double leftHigh;
/*     */   double rightLow;
/*     */   double rightHigh;
/*     */   
/*     */   public Trapezoid()
/*     */   {
/*  47 */     this.leftLow = 0.0D;
/*  48 */     this.leftHigh = 1.0D;
/*  49 */     this.rightLow = 3.0D;
/*  50 */     this.rightHigh = 2.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Trapezoid(double leftLow, double leftHigh, double rightLow, double rightHigh)
/*     */   {
/*  58 */     this.leftLow = leftLow;
/*  59 */     this.leftHigh = leftHigh;
/*  60 */     this.rightLow = rightLow;
/*  61 */     this.rightHigh = rightHigh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Trapezoid(Properties properties)
/*     */   {
/*     */     try
/*     */     {
/*  70 */       this.leftLow = ((Double)properties.getProperty("transferFunction.leftLow")).doubleValue();
/*  71 */       this.leftHigh = ((Double)properties.getProperty("transferFunction.leftHigh")).doubleValue();
/*  72 */       this.rightLow = ((Double)properties.getProperty("transferFunction.rightLow")).doubleValue();
/*  73 */       this.rightHigh = ((Double)properties.getProperty("transferFunction.rightHigh")).doubleValue();
/*     */     }
/*     */     catch (NullPointerException e) {}catch (NumberFormatException e)
/*     */     {
/*  77 */       System.err.println("Invalid transfer function properties! Using default values.");
/*     */     }
/*     */   }
/*     */   
/*     */   public double getOutput(double net)
/*     */   {
/*  83 */     if ((net >= this.leftHigh) && (net <= this.rightHigh))
/*  84 */       return 1.0D;
/*  85 */     if ((net > this.leftLow) && (net < this.leftHigh))
/*  86 */       return (net - this.leftLow) / (this.leftHigh - this.leftLow);
/*  87 */     if ((net > this.rightHigh) && (net < this.rightLow)) {
/*  88 */       return (this.rightLow - net) / (this.rightLow - this.rightHigh);
/*     */     }
/*     */     
/*  91 */     return 0.0D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLeftLow(double leftLow)
/*     */   {
/*  99 */     this.leftLow = leftLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLeftHigh(double leftHigh)
/*     */   {
/* 107 */     this.leftHigh = leftHigh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRightLow(double rightLow)
/*     */   {
/* 115 */     this.rightLow = rightLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRightHigh(double rightHigh)
/*     */   {
/* 123 */     this.rightHigh = rightHigh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getLeftLow()
/*     */   {
/* 131 */     return this.leftLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getLeftHigh()
/*     */   {
/* 139 */     return this.leftHigh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getRightLow()
/*     */   {
/* 147 */     return this.rightLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getRightHigh()
/*     */   {
/* 155 */     return this.rightHigh;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\transfer\Trapezoid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */