/*    */ package org.neuroph.easyneurons.dialog;
/*    */ 
/*    */ public class ComboItem
/*    */ {
/*    */   private String string;
/*    */   private Object value;
/*    */   
/*    */   public ComboItem(String string, Object value) {
/*  9 */     this.string = string;
/* 10 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 15 */     return this.string;
/*    */   }
/*    */   
/*    */   public Object getValue() {
/* 19 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\ComboItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */