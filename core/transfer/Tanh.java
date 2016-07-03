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
/*     */ 
/*     */ public class Tanh
/*     */   extends TransferFunction
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2L;
/*  45 */   private double slope = 1.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Tanh() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Tanh(double slope)
/*     */   {
/*  60 */     this.slope = slope;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Tanh(Properties properties)
/*     */   {
/*     */     try
/*     */     {
/*  70 */       this.slope = ((Double)properties.getProperty("transferFunction.slope")).doubleValue();
/*     */     }
/*     */     catch (NullPointerException e) {}catch (NumberFormatException e)
/*     */     {
/*  74 */       System.err.println("Invalid transfer function properties! Using default values.");
/*     */     }
/*     */   }
/*     */   
/*     */   public double getOutput(double net)
/*     */   {
/*  80 */     double E_x = Math.exp(-this.slope * net);
/*  81 */     return (1.0D - E_x) / (1.0D + E_x);
/*     */   }
/*     */   
/*     */   public double getDerivative(double net)
/*     */   {
/*  86 */     double out = getOutput(net);
/*  87 */     double derivative = this.slope * (1.0D - out * out);
/*  88 */     return derivative;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getSlope()
/*     */   {
/*  96 */     return this.slope;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSlope(double slope)
/*     */   {
/* 104 */     this.slope = slope;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\transfer\Tanh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */