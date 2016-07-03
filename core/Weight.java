/*     */ package org.neuroph.core;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class Weight
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private double value;
/*     */   private transient double previousValue;
/*     */   
/*     */   public Weight()
/*     */   {
/*  50 */     this.value = (Math.random() - 0.5D);
/*  51 */     this.previousValue = this.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Weight(double value)
/*     */   {
/*  61 */     this.value = value;
/*  62 */     this.previousValue = this.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void inc(double amount)
/*     */   {
/*  72 */     this.value += amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void dec(double amount)
/*     */   {
/*  82 */     this.value -= amount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setValue(double value)
/*     */   {
/*  92 */     this.value = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getValue()
/*     */   {
/* 101 */     return this.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setPreviousValue(double previousValue)
/*     */   {
/* 112 */     this.previousValue = previousValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getPreviousValue()
/*     */   {
/* 121 */     return this.previousValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 131 */     return new Double(this.value).toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void randomize()
/*     */   {
/* 138 */     this.value = (Math.random() - 0.5D);
/* 139 */     this.previousValue = this.value;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\Weight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */