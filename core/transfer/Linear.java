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
/*    */ public class Linear
/*    */   extends TransferFunction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 42 */   private double slope = 1.0D;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Linear() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Linear(double slope)
/*    */   {
/* 55 */     this.slope = slope;
/*    */   }
/*    */   
/*    */ 
/*    */   public Linear(Properties properties)
/*    */   {
/*    */     try
/*    */     {
/* 63 */       this.slope = ((Double)properties.getProperty("transferFunction.slope")).doubleValue();
/*    */     }
/*    */     catch (NullPointerException e) {}catch (NumberFormatException e)
/*    */     {
/* 67 */       System.err.println("Invalid transfer function properties! Using default values.");
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public double getSlope()
/*    */   {
/* 76 */     return this.slope;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setSlope(double slope)
/*    */   {
/* 84 */     this.slope = slope;
/*    */   }
/*    */   
/*    */   public double getOutput(double net) {
/* 88 */     return this.slope * net;
/*    */   }
/*    */   
/*    */   public double getDerivative(double net)
/*    */   {
/* 93 */     return this.slope;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\transfer\Linear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */