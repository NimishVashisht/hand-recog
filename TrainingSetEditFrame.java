/*     */ package org.neuroph.easyneurons;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.table.TableColumn;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ import org.neuroph.core.learning.TrainingElement;
/*     */ import org.neuroph.core.learning.TrainingSet;
/*     */ 
/*     */ public class TrainingSetEditFrame extends javax.swing.JInternalFrame
/*     */ {
/*     */   private TrainingSet trainingSet;
/*     */   private TrainingSetTableModel tableModel;
/*     */   private EasyNeuronsApplicationView mainFrame;
/*     */   private String trainingSetType;
/*     */   private int inputs;
/*     */   private int outputs;
/*     */   private String trainingSetLabel;
/*     */   private JButton addRowButton;
/*     */   private javax.swing.JMenuItem addRowMenuItem;
/*     */   private JPanel buttonPanel;
/*     */   private JButton cancelButton;
/*     */   private javax.swing.JMenuItem delRowMenuItem;
/*     */   private JButton helpButton;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private JButton loadButton;
/*     */   private JPanel namePanel;
/*     */   private JButton okButton;
/*     */   private javax.swing.JPopupMenu tablePopupMenu;
/*     */   private javax.swing.JScrollPane tableScrollPane;
/*     */   private JTable trainingSetTable;
/*     */   private JTextField traningSetLabelTextField;
/*     */   
/*     */   public TrainingSetEditFrame(TrainingSet trainingSet, String type, int inputs, int outputs)
/*     */   {
/*  39 */     this.mainFrame = EasyNeuronsApplicationView.getInstance();
/*  40 */     this.trainingSetType = type;
/*  41 */     this.trainingSet = trainingSet;
/*  42 */     this.inputs = inputs;
/*  43 */     this.outputs = outputs;
/*  44 */     this.tableModel = new TrainingSetTableModel(inputs, outputs);
/*  45 */     this.tableModel.addTableModelListener(new InteractiveTableModelListener());
/*     */     
/*  47 */     initComponents();
/*     */     
/*  49 */     if (!this.tableModel.hasEmptyRow()) {
/*  50 */       this.tableModel.addEmptyRow();
/*     */     }
/*  52 */     this.trainingSetTable.setSurrendersFocusOnKeystroke(true);
/*     */     
/*  54 */     TableColumn hidden = this.trainingSetTable.getColumnModel().getColumn(this.tableModel.HIDDEN_INDEX);
/*  55 */     hidden.setMinWidth(2);
/*  56 */     hidden.setPreferredWidth(2);
/*  57 */     hidden.setMaxWidth(2);
/*  58 */     hidden.setCellRenderer(new InteractiveRenderer(this.tableModel.HIDDEN_INDEX));
/*     */     
/*  60 */     this.trainingSetLabel = trainingSet.getLabel();
/*  61 */     this.traningSetLabelTextField.setText(this.trainingSetLabel);
/*  62 */     this.trainingSetTable.getTableHeader().setReorderingAllowed(false);
/*     */   }
/*     */   
/*     */   public TrainingSetEditFrame(TrainingSet trainingSet)
/*     */   {
/*  67 */     this.mainFrame = EasyNeuronsApplicationView.getInstance();
/*  68 */     this.trainingSet = trainingSet;
/*  69 */     this.tableModel = new TrainingSetTableModel(trainingSet);
/*  70 */     this.tableModel.addTableModelListener(new InteractiveTableModelListener());
/*     */     
/*  72 */     initComponents();
/*     */     
/*  74 */     if (!this.tableModel.hasEmptyRow()) {
/*  75 */       this.tableModel.addEmptyRow();
/*     */     }
/*  77 */     this.trainingSetTable.setSurrendersFocusOnKeystroke(true);
/*     */     
/*  79 */     TableColumn hidden = this.trainingSetTable.getColumnModel().getColumn(this.tableModel.HIDDEN_INDEX);
/*  80 */     hidden.setMinWidth(2);
/*  81 */     hidden.setPreferredWidth(2);
/*  82 */     hidden.setMaxWidth(2);
/*  83 */     hidden.setCellRenderer(new InteractiveRenderer(this.tableModel.HIDDEN_INDEX));
/*     */     
/*  85 */     this.trainingSetLabel = trainingSet.getLabel();
/*  86 */     this.traningSetLabelTextField.setText(this.trainingSetLabel);
/*     */     
/*  88 */     if (trainingSet.trainingElements().size() > 0) {
/*  89 */       TrainingElement trainingElement = (TrainingElement)trainingSet.trainingElements().firstElement();
/*     */       
/*  91 */       if ((trainingElement instanceof org.neuroph.core.learning.SupervisedTrainingElement)) {
/*  92 */         this.trainingSetType = "Supervised";
/*  93 */         this.inputs = trainingElement.getInput().size();
/*  94 */         this.outputs = ((org.neuroph.core.learning.SupervisedTrainingElement)trainingElement).getDesiredOutput().size();
/*     */       }
/*     */       else {
/*  97 */         this.trainingSetType = "Unsupervised";
/*  98 */         this.outputs = 0;
/*  99 */         this.inputs = trainingElement.getInput().size();
/*     */       }
/*     */     }
/*     */   }
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
/*     */   private void initComponents()
/*     */   {
/* 116 */     this.tablePopupMenu = new javax.swing.JPopupMenu();
/* 117 */     this.addRowMenuItem = new javax.swing.JMenuItem();
/* 118 */     this.delRowMenuItem = new javax.swing.JMenuItem();
/* 119 */     this.namePanel = new JPanel();
/* 120 */     this.jLabel1 = new javax.swing.JLabel();
/* 121 */     this.traningSetLabelTextField = new JTextField();
/* 122 */     this.buttonPanel = new JPanel();
/* 123 */     this.okButton = new JButton();
/* 124 */     this.addRowButton = new JButton();
/* 125 */     this.loadButton = new JButton();
/* 126 */     this.cancelButton = new JButton();
/* 127 */     this.helpButton = new JButton();
/* 128 */     this.tableScrollPane = new javax.swing.JScrollPane();
/* 129 */     this.trainingSetTable = new JTable();
/*     */     
/* 131 */     this.tablePopupMenu.setName("tablePopupMenu");
/*     */     
/* 133 */     javax.swing.ActionMap actionMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(TrainingSetEditFrame.class, this);
/* 134 */     this.addRowMenuItem.setAction(actionMap.get("addtableRow"));
/* 135 */     this.addRowMenuItem.setName("addRowMenuItem");
/* 136 */     this.tablePopupMenu.add(this.addRowMenuItem);
/*     */     
/* 138 */     this.delRowMenuItem.setAction(actionMap.get("deleteTableRow"));
/* 139 */     this.delRowMenuItem.setName("delRowMenuItem");
/* 140 */     this.tablePopupMenu.add(this.delRowMenuItem);
/*     */     
/* 142 */     setClosable(true);
/* 143 */     setIconifiable(true);
/* 144 */     setMaximizable(true);
/* 145 */     ResourceMap resourceMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(TrainingSetEditFrame.class);
/* 146 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/* 147 */     setName("Form");
/*     */     
/* 149 */     this.namePanel.setBackground(resourceMap.getColor("namePanel.background"));
/* 150 */     this.namePanel.setName("namePanel");
/* 151 */     this.namePanel.setLayout(new java.awt.GridBagLayout());
/*     */     
/* 153 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 154 */     this.jLabel1.setName("jLabel1");
/* 155 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/* 156 */     gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 5);
/* 157 */     this.namePanel.add(this.jLabel1, gridBagConstraints);
/*     */     
/* 159 */     this.traningSetLabelTextField.setColumns(30);
/* 160 */     this.traningSetLabelTextField.setText(resourceMap.getString("traningSetLabelTextField.text", new Object[0]));
/* 161 */     this.traningSetLabelTextField.setName("traningSetLabelTextField");
/* 162 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 163 */     gridBagConstraints.fill = 2;
/* 164 */     gridBagConstraints.anchor = 17;
/* 165 */     gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 10);
/* 166 */     this.namePanel.add(this.traningSetLabelTextField, gridBagConstraints);
/*     */     
/* 168 */     getContentPane().add(this.namePanel, "North");
/*     */     
/* 170 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/* 172 */     this.okButton.setAction(actionMap.get("save"));
/* 173 */     this.okButton.setText(resourceMap.getString("okButton.text", new Object[0]));
/* 174 */     this.okButton.setName("okButton");
/* 175 */     this.buttonPanel.add(this.okButton);
/*     */     
/* 177 */     this.addRowButton.setAction(actionMap.get("addtableRow"));
/* 178 */     this.addRowButton.setText(resourceMap.getString("addRowButton.text", new Object[0]));
/* 179 */     this.addRowButton.setName("addRowButton");
/* 180 */     this.buttonPanel.add(this.addRowButton);
/*     */     
/* 182 */     this.loadButton.setAction(actionMap.get("showLoadTrainingSetDialog"));
/* 183 */     this.loadButton.setText(resourceMap.getString("loadButton.text", new Object[0]));
/* 184 */     this.loadButton.setName("loadButton");
/* 185 */     this.buttonPanel.add(this.loadButton);
/*     */     
/* 187 */     this.cancelButton.setAction(actionMap.get("cancel"));
/* 188 */     this.cancelButton.setText(resourceMap.getString("cancelButton.text", new Object[0]));
/* 189 */     this.cancelButton.setName("cancelButton");
/* 190 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/* 192 */     this.helpButton.setText(resourceMap.getString("helpButton.text", new Object[0]));
/* 193 */     this.helpButton.setEnabled(false);
/* 194 */     this.helpButton.setName("helpButton");
/* 195 */     this.buttonPanel.add(this.helpButton);
/*     */     
/* 197 */     getContentPane().add(this.buttonPanel, "South");
/*     */     
/* 199 */     this.tableScrollPane.setName("tableScrollPane");
/*     */     
/* 201 */     this.trainingSetTable.setModel(this.tableModel);
/* 202 */     this.trainingSetTable.setComponentPopupMenu(this.tablePopupMenu);
/* 203 */     this.trainingSetTable.setName("trainingSetTable");
/* 204 */     this.tableScrollPane.setViewportView(this.trainingSetTable);
/*     */     
/* 206 */     getContentPane().add(this.tableScrollPane, "Center");
/*     */     
/* 208 */     pack();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 213 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void addtableRow() {
/* 218 */     ((TrainingSetTableModel)this.trainingSetTable.getModel()).addEmptyRow();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void deleteTableRow()
/*     */   {
/* 224 */     ((TrainingSetTableModel)this.trainingSetTable.getModel()).removeRow(this.trainingSetTable.getSelectedRow());
/*     */   }
/*     */   
/*     */ 
/*     */   @org.jdesktop.application.Action
/*     */   public void save()
/*     */   {
/* 231 */     if (this.trainingSetTable.isEditing())
/*     */     {
/* 233 */       this.trainingSetTable.getCellEditor().stopCellEditing();
/*     */     }
/*     */     
/* 236 */     if (this.traningSetLabelTextField.getText().trim().isEmpty()) {
/* 237 */       javax.swing.JOptionPane.showMessageDialog(this, "Please enter the training set name!");
/* 238 */       return;
/*     */     }
/*     */     
/* 241 */     this.trainingSet.setLabel(this.traningSetLabelTextField.getText().trim());
/*     */     
/* 243 */     Vector<Vector> dataVector = this.tableModel.getDataVector();
/* 244 */     java.util.Iterator<Vector> iterator = dataVector.iterator();
/* 245 */     this.trainingSet.clear();
/*     */     
/* 247 */     if (this.trainingSetType.equals("Unsupervised"))
/* 248 */       while (iterator.hasNext()) {
/* 249 */         Vector rowVector = (Vector)iterator.next();
/* 250 */         Vector<Double> doubleRowVector = new Vector();
/*     */         try {
/* 252 */           for (int i = 0; i < this.inputs; i++) {
/* 253 */             double doubleVal = Double.parseDouble(rowVector.elementAt(i).toString());
/*     */             
/* 255 */             doubleRowVector.add(new Double(doubleVal));
/*     */           }
/*     */         } catch (Exception ex) {}
/* 258 */         continue;
/*     */         
/*     */ 
/* 261 */         TrainingElement trainingElement = new TrainingElement(doubleRowVector);
/*     */         
/* 263 */         this.trainingSet.addElement(trainingElement);
/*     */       }
/* 265 */     if (this.trainingSetType.equals("Supervised")) {
/* 266 */       while (iterator.hasNext()) {
/* 267 */         Vector rowVector = (Vector)iterator.next();
/* 268 */         Vector<Double> inputVector = new Vector();
/* 269 */         Vector<Double> outputVector = new Vector();
/*     */         try
/*     */         {
/* 272 */           for (int i = 0; i < this.inputs; i++) {
/* 273 */             double doubleVal = Double.parseDouble(rowVector.elementAt(i).toString());
/*     */             
/* 275 */             inputVector.add(new Double(doubleVal));
/*     */           }
/*     */           
/* 278 */           for (int i = 0; i < this.outputs; i++) {
/* 279 */             double doubleVal = Double.parseDouble(rowVector.elementAt(this.inputs + i).toString());
/*     */             
/* 281 */             outputVector.add(new Double(doubleVal));
/*     */           }
/*     */         } catch (Exception ex) {}
/* 284 */         continue;
/*     */         
/*     */ 
/* 287 */         org.neuroph.core.learning.SupervisedTrainingElement trainingElement = new org.neuroph.core.learning.SupervisedTrainingElement(inputVector, outputVector);
/*     */         
/* 289 */         this.trainingSet.addElement(trainingElement);
/*     */       }
/*     */     }
/*     */     
/* 293 */     this.mainFrame.updateTrainingSets(this.trainingSet);
/* 294 */     dispose();
/*     */   }
/*     */   
/*     */   public void highlightLastRow(int row)
/*     */   {
/* 299 */     int lastrow = this.tableModel.getRowCount();
/* 300 */     if (row == lastrow - 1) {
/* 301 */       this.trainingSetTable.setRowSelectionInterval(lastrow - 1, lastrow - 1);
/*     */     } else {
/* 303 */       this.trainingSetTable.setRowSelectionInterval(row + 1, row + 1);
/*     */     }
/*     */     
/* 306 */     this.trainingSetTable.setColumnSelectionInterval(0, 0);
/*     */   }
/*     */   
/*     */   class InteractiveRenderer extends javax.swing.table.DefaultTableCellRenderer {
/*     */     protected int interactiveColumn;
/*     */     
/*     */     public InteractiveRenderer(int interactiveColumn) {
/* 313 */       this.interactiveColumn = interactiveColumn;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
/*     */     {
/* 321 */       java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
/* 322 */       if ((column == this.interactiveColumn) && (hasFocus)) {
/* 323 */         if ((TrainingSetEditFrame.this.tableModel.getRowCount() - 1 == row) && (!TrainingSetEditFrame.this.tableModel.hasEmptyRow()))
/*     */         {
/*     */ 
/* 326 */           TrainingSetEditFrame.this.tableModel.addEmptyRow();
/*     */         }
/*     */         
/* 329 */         TrainingSetEditFrame.this.highlightLastRow(row);
/*     */       }
/*     */       
/* 332 */       return c;
/*     */     }
/*     */   }
/*     */   
/*     */   public class InteractiveTableModelListener implements javax.swing.event.TableModelListener {
/*     */     public InteractiveTableModelListener() {}
/*     */     
/* 339 */     public void tableChanged(javax.swing.event.TableModelEvent evt) { if (evt.getType() == 0) {
/* 340 */         int column = evt.getColumn();
/* 341 */         int row = evt.getFirstRow();
/*     */         
/* 343 */         TrainingSetEditFrame.this.trainingSetTable.setColumnSelectionInterval(column + 1, column + 1);
/* 344 */         TrainingSetEditFrame.this.trainingSetTable.setRowSelectionInterval(row, row);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void showLoadTrainingSetDialog() {
/* 351 */     org.neuroph.easyneurons.dialog.TrainingDataFileDialog dialog = new org.neuroph.easyneurons.dialog.TrainingDataFileDialog(this.inputs, this.outputs, this);
/* 352 */     EasyNeuronsApplication.getApplication().show(dialog);
/*     */   }
/*     */   
/*     */   public void setTrainingSet(TrainingSet trainingSet)
/*     */   {
/* 357 */     this.trainingSet = trainingSet;
/*     */     
/* 359 */     this.tableModel = new TrainingSetTableModel(this.trainingSet);
/* 360 */     this.trainingSetTable.setModel(this.tableModel);
/* 361 */     this.trainingSetTable.setSurrendersFocusOnKeystroke(true);
/*     */     
/* 363 */     TableColumn hidden = this.trainingSetTable.getColumnModel().getColumn(this.tableModel.HIDDEN_INDEX);
/* 364 */     hidden.setMinWidth(2);
/* 365 */     hidden.setPreferredWidth(2);
/* 366 */     hidden.setMaxWidth(2);
/* 367 */     hidden.setCellRenderer(new InteractiveRenderer(this.tableModel.HIDDEN_INDEX));
/*     */     
/* 369 */     this.tableModel.fireTableDataChanged();
/*     */   }
/*     */   
/*     */   private void setTableModel()
/*     */   {
/* 374 */     if (this.trainingSet.trainingElements().size() > 0) {
/* 375 */       TrainingElement trainingElement = (TrainingElement)this.trainingSet.trainingElements().firstElement();
/*     */       
/* 377 */       if ((trainingElement instanceof org.neuroph.core.learning.SupervisedTrainingElement)) {
/* 378 */         this.trainingSetType = "Supervised";
/* 379 */         this.inputs = trainingElement.getInput().size();
/* 380 */         this.outputs = ((org.neuroph.core.learning.SupervisedTrainingElement)trainingElement).getDesiredOutput().size();
/*     */       }
/*     */       else {
/* 383 */         this.trainingSetType = "Unsupervised";
/* 384 */         this.outputs = 0;
/* 385 */         this.inputs = trainingElement.getInput().size();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\TrainingSetEditFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */