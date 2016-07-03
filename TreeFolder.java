/*    */ package org.neuroph.easyneurons;
/*    */ 
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TreeFolder
/*    */   extends DefaultMutableTreeNode
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public TreeFolder(String label)
/*    */   {
/* 18 */     super(label);
/*    */   }
/*    */   
/*    */   public boolean isLeaf() {
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\TreeFolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */