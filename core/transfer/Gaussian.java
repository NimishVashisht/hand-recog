/*    */ package org.neuroph.core.transfer;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.io.Serializable;
/*    */ import org.neuroph.util.Properties;
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
/*    */ public class Gaussian
/*    */   extends TransferFunction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 45 */   private double sigma = 0.5D;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Gaussian() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Gaussian(Properties properties)
/*    */   {
/*    */     try
/*    */     {
/* 60 */       this.sigma = ((Double)properties.getProperty("transferFunction.sigma")).doubleValue();
/*    */     }
/*    */     catch (NullPointerException e) {}catch (NumberFormatException e)
/*    */     {
/* 64 */       System.err.println("Invalid transfer function properties! Using default values.");
/*    */     }
/*    */   }
/*    */   
/*    */   public double getOutput(double net) {
/* 69 */     return Math.exp(-0.5D * Math.pow(net / this.sigma, 2.0D));
/*    */   }
/*    */   
/*    */ 
/*    */   public double getDerivative(double net)
/*    */   {
/* 75 */     double out = getOutput(net);
/* 76 */     double derivative = out * (-net / (this.sigma * this.sigma));
/* 77 */     return derivative;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public double getSigma()
/*    */   {
/* 85 */     return this.sigma;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setSigma(double sigma)
/*    */   {
/* 93 */     this.sigma = sigma;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\transfer\Gaussian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */