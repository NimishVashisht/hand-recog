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
/*     */ 
/*     */ 
/*     */ public class Step
/*     */   extends TransferFunction
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  44 */   private double yHigh = 1.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  49 */   private double yLow = 0.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Step() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public Step(Properties properties)
/*     */   {
/*     */     try
/*     */     {
/*  62 */       this.yHigh = ((Double)properties.getProperty("transferFunction.yHigh")).doubleValue();
/*  63 */       this.yLow = ((Double)properties.getProperty("transferFunction.yLow")).doubleValue();
/*     */     }
/*     */     catch (NullPointerException e) {}catch (NumberFormatException e)
/*     */     {
/*  67 */       System.err.println("Invalid transfer function properties! Using default values.");
/*     */     }
/*     */   }
/*     */   
/*     */   public double getOutput(double net)
/*     */   {
/*  73 */     if (net > 0.0D) {
/*  74 */       return this.yHigh;
/*     */     }
/*  76 */     return this.yLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getYHigh()
/*     */   {
/*  84 */     return this.yHigh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYHigh(double yHigh)
/*     */   {
/*  92 */     this.yHigh = yHigh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getYLow()
/*     */   {
/* 100 */     return this.yLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setYLow(double yLow)
/*     */   {
/* 108 */     this.yLow = yLow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Properties getProperties()
/*     */   {
/* 116 */     Properties properties = new Properties();
/* 117 */     properties.setProperty("transferFunction.yHigh", new Double(this.yHigh).toString());
/* 118 */     properties.setProperty("transferFunction.yLow", new Double(this.yLow).toString());
/* 119 */     return properties;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\transfer\Step.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */