/*    */ package org.neuroph.contrib.jHRT.gui;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.swing.JTree;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ import javax.swing.tree.DefaultTreeModel;
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
/*    */ public class TreeManager
/*    */ {
/*    */   private static DefaultTreeModel model;
/*    */   private static final String PATH = "Letters/Training Set";
/*    */   
/*    */   public static void setLettersTreeModel(JTree tree)
/*    */   {
/* 42 */     DefaultMutableTreeNode root = new DefaultMutableTreeNode("Letters/Training Set");
/* 43 */     File rootFolder = new File("Letters/Training Set");
/* 44 */     File[] files = rootFolder.listFiles();
/* 45 */     if (files == null) {
/* 46 */       tree.setModel(model);
/*    */     } else {
/* 48 */       for (int i = 0; i < files.length; i++) {
/* 49 */         if (files[i].isFile()) {
/* 50 */           root.add(new DefaultMutableTreeNode(files[i].getName()));
/*    */         }
/*    */       }
/*    */     }
/* 54 */     model = new DefaultTreeModel(root);
/* 55 */     tree.setModel(model);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static DefaultTreeModel getLettersModel()
/*    */   {
/* 64 */     return model;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static String getPath()
/*    */   {
/* 74 */     return "Letters/Training Set";
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\jHRT\gui\TreeManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */