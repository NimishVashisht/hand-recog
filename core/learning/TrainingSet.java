/*     */ package org.neuroph.core.learning;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
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
/*     */ public class TrainingSet
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2L;
/*     */   private Vector<TrainingElement> elements;
/*  53 */   private int inputVectorSize = 0;
/*  54 */   private int outputVectorSize = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private String label;
/*     */   
/*     */ 
/*     */ 
/*     */   private transient String filePath;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrainingSet()
/*     */   {
/*  70 */     this.elements = new Vector();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrainingSet(String label)
/*     */   {
/*  79 */     this.label = label;
/*  80 */     this.elements = new Vector();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrainingSet(int inputVectorSize)
/*     */   {
/*  89 */     this.elements = new Vector();
/*  90 */     this.inputVectorSize = inputVectorSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrainingSet(int inputVectorSize, int outputVectorSize)
/*     */   {
/* 100 */     this.elements = new Vector();
/* 101 */     this.inputVectorSize = inputVectorSize;
/* 102 */     this.outputVectorSize = outputVectorSize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addElement(TrainingElement el)
/*     */   {
/* 111 */     if ((this.inputVectorSize != 0) && (el.getInput().size() != this.inputVectorSize)) {
/* 112 */       throw new RuntimeException("Input vector size does not match training set setting!");
/*     */     }
/*     */     
/* 115 */     if ((el instanceof SupervisedTrainingElement)) {
/* 116 */       SupervisedTrainingElement sel = (SupervisedTrainingElement)el;
/* 117 */       if ((this.outputVectorSize != 0) && (sel.getDesiredOutput().size() != this.outputVectorSize)) {
/* 118 */         throw new RuntimeException("Output vector size does not match training set setting!");
/*     */       }
/*     */     }
/*     */     
/* 122 */     this.elements.addElement(el);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeElementAt(int idx)
/*     */   {
/* 130 */     this.elements.removeElementAt(idx);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Enumeration<TrainingElement> elements()
/*     */   {
/* 138 */     return this.elements.elements();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Iterator<TrainingElement> iterator()
/*     */   {
/* 146 */     return this.elements.iterator();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Vector<TrainingElement> trainingElements()
/*     */   {
/* 154 */     return this.elements;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public TrainingElement elementAt(int idx)
/*     */   {
/* 163 */     return (TrainingElement)this.elements.elementAt(idx);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/* 170 */     this.elements.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 178 */     return this.elements.isEmpty();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int size()
/*     */   {
/* 186 */     return this.elements.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLabel()
/*     */   {
/* 194 */     return this.label;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLabel(String label)
/*     */   {
/* 202 */     this.label = label;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFilePath(String filePath)
/*     */   {
/* 210 */     this.filePath = filePath;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getFilePath()
/*     */   {
/* 218 */     return this.filePath;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 227 */     return this.label;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void save(String filePath)
/*     */   {
/* 235 */     this.filePath = filePath;
/* 236 */     save();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void save()
/*     */   {
/* 243 */     ObjectOutputStream out = null;
/*     */     try
/*     */     {
/* 246 */       File file = new File(this.filePath);
/* 247 */       out = new ObjectOutputStream(new FileOutputStream(file));
/* 248 */       out.writeObject(this);
/* 249 */       out.flush(); return;
/*     */     }
/*     */     catch (Exception e) {
/* 252 */       System.err.println(e.getMessage());
/* 253 */       e.printStackTrace();
/*     */     } finally {
/* 255 */       if (out != null) {
/*     */         try {
/* 257 */           out.close();
/*     */         }
/*     */         catch (IOException ioe) {}
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static TrainingSet load(String filePath)
/*     */   {
/* 270 */     ObjectInputStream oistream = null;
/*     */     try
/*     */     {
/* 273 */       File file = new File(filePath);
/* 274 */       if (!file.exists()) {
/* 275 */         throw new FileNotFoundException("Cannot find file: " + filePath);
/*     */       }
/*     */       
/* 278 */       oistream = new ObjectInputStream(new FileInputStream(filePath));
/* 279 */       TrainingSet tSet = (TrainingSet)oistream.readObject();
/*     */       
/* 281 */       return tSet;
/*     */     }
/*     */     catch (IOException ioe) {
/* 284 */       ioe.printStackTrace();
/*     */     } catch (ClassNotFoundException cnfe) {
/* 286 */       cnfe.printStackTrace();
/*     */     } finally {
/* 288 */       if (oistream != null) {
/*     */         try {
/* 290 */           oistream.close();
/*     */         }
/*     */         catch (IOException ioe) {}
/*     */       }
/*     */     }
/*     */     
/* 296 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\core\learning\TrainingSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */