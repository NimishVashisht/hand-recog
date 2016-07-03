 package org.neuroph.easyneurons;

 import javax.swing.tree.DefaultMutableTreeNode;

 public class TreeFolder
   extends DefaultMutableTreeNode
 {

  public TreeFolder(String label)
  {
    super(label);
  }
 
  public boolean isLeaf() {
   return false;
   }
 }

