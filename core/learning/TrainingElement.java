/*     */ package org.neuroph.core.learning;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Vector;
/*     */ import org.neuroph.util.VectorParser;
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
/*     */ public class TrainingElement
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   protected Vector<Double> input;
/*     */   protected String label;
/*     */   
/*     */   public TrainingElement()
/*     */   {
/*  57 */     this.input = new Vector();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrainingElement(Vector<Double> input)
/*     */   {
/*  67 */     this.input = input;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrainingElement(String input)
/*     */   {
/*  76 */     this.input = VectorParser.parseDouble(input);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrainingElement(double... input)
/*     */   {
/*  86 */     this.input = new Vector();
/*  87 */     for (int i = 0; i < input.length; i++) {
/*  88 */       this.input.add(new Double(input[i]));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<Double> getInput()
/*     */   {
/*  97 */     return this.input;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInput(Vector<Double> input)
/*     */   {
/* 107 */     this.input = input;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLabel()
/*     */   {
/* 115 */     return this.label;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLabel(String label)
/*     */   {
/* 123 */     this.label = label;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\learning\TrainingElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */