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
/*     */ public class Sigmoid
/*     */   extends TransferFunction
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2L;
/*  44 */   private double slope = 1.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Sigmoid() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Sigmoid(double slope)
/*     */   {
/*  59 */     this.slope = slope;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Sigmoid(Properties properties)
/*     */   {
/*     */     try
/*     */     {
/*  69 */       this.slope = ((Double)properties.getProperty("transferFunction.slope")).doubleValue();
/*     */     }
/*     */     catch (NullPointerException e) {}catch (NumberFormatException e)
/*     */     {
/*  73 */       System.err.println("Invalid transfer function properties! Using default values.");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getSlope()
/*     */   {
/*  82 */     return this.slope;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSlope(Double slope)
/*     */   {
/*  90 */     this.slope = slope.doubleValue();
/*     */   }
/*     */   
/*     */   public double getOutput(double net)
/*     */   {
/*  95 */     double den = 1.0D + Math.exp(-this.slope * net);
/*  96 */     return 1.0D / den;
/*     */   }
/*     */   
/*     */   public double getDerivative(double net)
/*     */   {
/* 101 */     double out = getOutput(net);
/* 102 */     double derivative = this.slope * out * (1.0D - out);
/* 103 */     return derivative;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\transfer\Sigmoid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */