/*    */ package org.neuroph.core.transfer;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Properties;
/*    */ import org.neuroph.util.TransferFunctionType;
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
/*    */ public class Sgn
/*    */   extends TransferFunction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public double getOutput(double net)
/*    */   {
/* 47 */     if (net > 0.0D) {
/* 48 */       return 1.0D;
/*    */     }
/* 50 */     return -1.0D;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Properties getProperties()
/*    */   {
/* 58 */     Properties properties = new Properties();
/* 59 */     properties.setProperty("transferFunction", TransferFunctionType.SGN.toString());
/* 60 */     return properties;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\transfer\Sgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */