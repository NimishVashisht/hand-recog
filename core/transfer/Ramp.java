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
/*     */ 
/*     */ 
/*     */ public class Ramp
/*     */   extends TransferFunction
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  42 */   private double slope = 1.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  47 */   private double xHigh = 1.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  52 */   private double xLow = 0.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  57 */   private double yHigh = 1.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  62 */   private double yLow = 0.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Ramp() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Ramp(double slope, double xLow, double xHigh, double yLow, double yHigh)
/*     */   {
/*  75 */     this.slope = slope;
/*  76 */     this.xLow = xLow;
/*  77 */     this.xHigh = xHigh;
/*  78 */     this.yLow = yLow;
/*  79 */     this.yHigh = yHigh;
/*     */   }
/*     */   
/*     */ 
/*     */   public Ramp(Properties properties)
/*     */   {
/*     */     try
/*     */     {
/*  87 */       this.slope = ((Double)properties.getProperty("transferFunction.slope")).doubleValue();
/*  88 */       this.yHigh = ((Double)properties.getProperty("transferFunction.yHigh")).doubleValue();
/*  89 */       this.yLow = ((Double)properties.getProperty("transferFunction.yLow")).doubleValue();
/*  90 */       this.xHigh = ((Double)properties.getProperty("transferFunction.xHigh")).doubleValue();
/*  91 */       this.xLow = ((Double)properties.getProperty("transferFunction.xLow")).doubleValue();
/*     */     }
/*     */     catch (NullPointerException e) {}catch (NumberFormatException e)
/*     */     {
/*  95 */       System.err.println("Invalid transfer function properties! Using default values.");
/*     */     }
/*     */   }
/*     */   
/*     */   public double getOutput(double net)
/*     */   {
/* 101 */     if (net < this.xLow)
/* 102 */       return this.yLow;
/* 103 */     if (net > this.xHigh) {
/* 104 */       return this.yHigh;
/*     */     }
/* 106 */     return this.slope * net;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getXLow()
/*     */   {
/* 114 */     return this.xLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXLow(double x)
/*     */   {
/* 122 */     this.xLow = x;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getXHigh()
/*     */   {
/* 130 */     return this.xHigh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setXHigh(double x)
/*     */   {
/* 138 */     this.xHigh = x;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getYLow()
/*     */   {
/* 146 */     return this.yLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYLow(double y)
/*     */   {
/* 154 */     this.yLow = y;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getYHigh()
/*     */   {
/* 162 */     return this.yHigh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYHigh(double y)
/*     */   {
/* 170 */     this.yHigh = y;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\transfer\Ramp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */