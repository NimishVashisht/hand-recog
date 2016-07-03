/*     */ package org.neuroph.easyneurons;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ import org.neuroph.core.learning.SupervisedTrainingElement;
/*     */ import org.neuroph.core.learning.TrainingElement;
/*     */ import org.neuroph.core.learning.TrainingSet;
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
/*     */ public class TrainingSetTableModel
/*     */   extends AbstractTableModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public int HIDDEN_INDEX;
/*     */   protected Vector<String> columnIdentifiers;
/*     */   protected Vector<Vector> dataVector;
/*     */   
/*     */   public TrainingSetTableModel()
/*     */   {
/*  29 */     this.columnIdentifiers = new Vector();
/*  30 */     this.dataVector = new Vector();
/*     */   }
/*     */   
/*     */   public TrainingSetTableModel(TrainingSet trainingSet)
/*     */   {
/*  35 */     this.columnIdentifiers = new Vector();
/*  36 */     this.dataVector = new Vector();
/*     */     
/*  38 */     TrainingElement trainingElement = trainingSet.elementAt(0);
/*     */     
/*  40 */     this.HIDDEN_INDEX = trainingElement.getInput().size();
/*     */     
/*  42 */     Vector<Double> inputVector = trainingElement.getInput();
/*  43 */     for (int i = 0; i < inputVector.size(); i++) {
/*  44 */       this.columnIdentifiers.add("Input " + (i + 1));
/*     */     }
/*     */     
/*  47 */     if ((trainingElement instanceof SupervisedTrainingElement)) {
/*  48 */       Vector<Double> outputVector = ((SupervisedTrainingElement)trainingElement).getDesiredOutput();
/*     */       
/*  50 */       for (int i = 0; i < outputVector.size(); i++) {
/*  51 */         this.columnIdentifiers.add("Output " + (i + 1));
/*     */       }
/*     */       
/*  54 */       this.HIDDEN_INDEX += outputVector.size();
/*     */     }
/*     */     
/*     */ 
/*  58 */     this.columnIdentifiers.add("");
/*     */     
/*     */ 
/*  61 */     Iterator<TrainingElement> iterator = trainingSet.iterator();
/*  62 */     while (iterator.hasNext()) {
/*  63 */       trainingElement = (TrainingElement)iterator.next();
/*  64 */       inputVector = trainingElement.getInput();
/*     */       
/*  66 */       Vector rowVector = new Vector();
/*  67 */       rowVector.addAll(inputVector);
/*     */       
/*  69 */       if ((trainingElement instanceof SupervisedTrainingElement)) {
/*  70 */         Vector<Double> outputVector = new Vector();
/*  71 */         outputVector = ((SupervisedTrainingElement)trainingElement).getDesiredOutput();
/*     */         
/*  73 */         rowVector.addAll(outputVector);
/*     */       }
/*     */       
/*  76 */       rowVector.add(new String());
/*     */       
/*  78 */       this.dataVector.add(rowVector);
/*     */     }
/*     */   }
/*     */   
/*     */   public TrainingSetTableModel(int inputs, int outputs) {
/*  83 */     this.columnIdentifiers = new Vector();
/*  84 */     this.dataVector = new Vector();
/*     */     
/*  86 */     this.HIDDEN_INDEX = (inputs + outputs);
/*     */     
/*  88 */     for (int i = 0; i < inputs; i++) {
/*  89 */       this.columnIdentifiers.add("Input " + (i + 1));
/*     */     }
/*     */     
/*  92 */     for (int j = 0; j < outputs; j++) {
/*  93 */       this.columnIdentifiers.add("Output " + (j + 1));
/*     */     }
/*  95 */     this.columnIdentifiers.add("");
/*     */   }
/*     */   
/*     */ 
/*     */   public String getColumnName(int column)
/*     */   {
/* 101 */     return ((String)this.columnIdentifiers.elementAt(column)).toString();
/*     */   }
/*     */   
/*     */   public boolean isCellEditable(int row, int column)
/*     */   {
/* 106 */     if (column == this.HIDDEN_INDEX) return false;
/* 107 */     return true;
/*     */   }
/*     */   
/*     */   public Class getColumnClass(int column)
/*     */   {
/* 112 */     return Object.class;
/*     */   }
/*     */   
/*     */   public Object getValueAt(int row, int column)
/*     */   {
/* 117 */     return ((Vector)this.dataVector.get(row)).get(column);
/*     */   }
/*     */   
/*     */   public void setValueAt(Object value, int row, int column)
/*     */   {
/* 122 */     Vector rowVector = (Vector)this.dataVector.get(row);
/* 123 */     rowVector.set(column, value);
/* 124 */     fireTableCellUpdated(row, column);
/*     */   }
/*     */   
/*     */   public int getRowCount()
/*     */   {
/* 129 */     return this.dataVector.size();
/*     */   }
/*     */   
/*     */   public int getColumnCount()
/*     */   {
/* 134 */     return this.columnIdentifiers.size();
/*     */   }
/*     */   
/*     */   public void addEmptyRow()
/*     */   {
/* 139 */     int columns = this.columnIdentifiers.size();
/* 140 */     Vector<String> newRow = new Vector();
/* 141 */     for (int c = 0; c < columns; c++) {
/* 142 */       newRow.add(new String());
/*     */     }
/*     */     
/* 145 */     this.dataVector.add(newRow);
/* 146 */     fireTableRowsInserted(this.dataVector.size() - 1, this.dataVector.size() - 1);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean hasEmptyRow()
/*     */   {
/* 152 */     if (this.dataVector.size() == 0) return false;
/* 153 */     Vector rowVector = (Vector)this.dataVector.get(this.dataVector.size() - 1);
/*     */     
/* 155 */     Iterator i = rowVector.iterator();
/* 156 */     while (i.hasNext()) {
/* 157 */       if (!i.next().toString().trim().equals("")) { return false;
/*     */       }
/*     */     }
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   public Vector getDataVector() {
/* 164 */     return this.dataVector;
/*     */   }
/*     */   
/*     */   public void removeLastEmptyRow() {
/* 168 */     this.dataVector.removeElementAt(this.dataVector.size() - 1);
/* 169 */     fireTableRowsInserted(this.dataVector.size() - 1, this.dataVector.size() - 1);
/*     */   }
/*     */   
/*     */ 
/*     */   public void removeRow(int row)
/*     */   {
/* 175 */     if ((row < 0) || (row > getRowCount())) {
/* 176 */       return;
/*     */     }
/*     */     
/* 179 */     this.dataVector.remove(row);
/* 180 */     fireTableRowsDeleted(row, row);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\TrainingSetTableModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */