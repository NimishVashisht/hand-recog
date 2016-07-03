/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class MultiLayerPerceptronWizard extends javax.swing.JDialog { private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private javax.swing.JPanel buttonPanel;
/*     */   private javax.swing.JButton cancelButton;
/*     */   private javax.swing.JCheckBox connectIOCheckBox;
/*     */   private javax.swing.JButton createButton;
/*     */   private javax.swing.JTextField hiddenNeuronsField;
/*     */   private javax.swing.JTextField inputNeuronsField;
/*     */   private javax.swing.JPanel inputPanel;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTable jTable1;
/*     */   private javax.swing.JComboBox learningRuleCombo;
/*     */   private JLabel neuronsNumLabel;
/*     */   private javax.swing.JTextField outputNeuronsField;
/*     */   private javax.swing.JComboBox transferComboBox;
/*     */   private javax.swing.JCheckBox useBiasCheckBox;
/*     */   
/*  27 */   public MultiLayerPerceptronWizard(java.awt.Frame parent, boolean modal) { super(parent, modal);
/*  28 */     initComponents();
/*  29 */     fillTransferFunctionCombo();
/*  30 */     fillLearningRuleCombo();
/*  31 */     this.mainFrame = org.neuroph.easyneurons.EasyNeuronsApplicationView.getInstance();
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
/*     */   private void initComponents()
/*     */   {
/*  45 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  46 */     this.jTable1 = new javax.swing.JTable();
/*  47 */     this.inputPanel = new javax.swing.JPanel();
/*  48 */     this.neuronsNumLabel = new JLabel();
/*  49 */     this.hiddenNeuronsField = new javax.swing.JTextField();
/*  50 */     this.jLabel1 = new JLabel();
/*  51 */     this.transferComboBox = new javax.swing.JComboBox();
/*  52 */     this.useBiasCheckBox = new javax.swing.JCheckBox();
/*  53 */     this.connectIOCheckBox = new javax.swing.JCheckBox();
/*  54 */     this.learningRuleCombo = new javax.swing.JComboBox();
/*  55 */     this.jLabel2 = new JLabel();
/*  56 */     this.jLabel3 = new JLabel();
/*  57 */     this.jLabel4 = new JLabel();
/*  58 */     this.inputNeuronsField = new javax.swing.JTextField();
/*  59 */     this.outputNeuronsField = new javax.swing.JTextField();
/*  60 */     this.jLabel5 = new JLabel();
/*  61 */     this.buttonPanel = new javax.swing.JPanel();
/*  62 */     this.createButton = new javax.swing.JButton();
/*  63 */     this.cancelButton = new javax.swing.JButton();
/*     */     
/*  65 */     this.jScrollPane1.setName("jScrollPane1");
/*     */     
/*  67 */     this.jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/*  78 */     this.jTable1.setName("jTable1");
/*  79 */     this.jScrollPane1.setViewportView(this.jTable1);
/*     */     
/*  81 */     setDefaultCloseOperation(2);
/*  82 */     org.jdesktop.application.ResourceMap resourceMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getResourceMap(MultiLayerPerceptronWizard.class);
/*  83 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  84 */     setName("Form");
/*  85 */     setResizable(false);
/*  86 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  88 */     this.inputPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  89 */     this.inputPanel.setName("inputPanel");
/*  90 */     this.inputPanel.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  92 */     this.neuronsNumLabel.setText(resourceMap.getString("neuronsNumLabel.text", new Object[0]));
/*  93 */     this.neuronsNumLabel.setName("neuronsNumLabel");
/*  94 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/*  95 */     gridBagConstraints.gridx = 0;
/*  96 */     gridBagConstraints.gridy = 1;
/*  97 */     gridBagConstraints.fill = 1;
/*  98 */     gridBagConstraints.anchor = 17;
/*  99 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
/* 100 */     this.inputPanel.add(this.neuronsNumLabel, gridBagConstraints);
/*     */     
/* 102 */     this.hiddenNeuronsField.setColumns(20);
/* 103 */     this.hiddenNeuronsField.setText(resourceMap.getString("hiddenNeuronsField.text", new Object[0]));
/* 104 */     this.hiddenNeuronsField.setName("hiddenNeuronsField");
/* 105 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 106 */     gridBagConstraints.gridx = 1;
/* 107 */     gridBagConstraints.gridy = 1;
/* 108 */     gridBagConstraints.fill = 1;
/* 109 */     gridBagConstraints.anchor = 17;
/* 110 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
/* 111 */     this.inputPanel.add(this.hiddenNeuronsField, gridBagConstraints);
/*     */     
/* 113 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 114 */     this.jLabel1.setName("jLabel1");
/* 115 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 116 */     gridBagConstraints.gridx = 0;
/* 117 */     gridBagConstraints.gridy = 6;
/* 118 */     gridBagConstraints.anchor = 17;
/* 119 */     gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
/* 120 */     this.inputPanel.add(this.jLabel1, gridBagConstraints);
/*     */     
/* 122 */     this.transferComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sigmoid", "Tanh" }));
/* 123 */     this.transferComboBox.setName("transferComboBox");
/* 124 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 125 */     gridBagConstraints.gridx = 1;
/* 126 */     gridBagConstraints.gridy = 6;
/* 127 */     gridBagConstraints.anchor = 17;
/* 128 */     gridBagConstraints.insets = new java.awt.Insets(15, 5, 5, 5);
/* 129 */     this.inputPanel.add(this.transferComboBox, gridBagConstraints);
/*     */     
/* 131 */     this.useBiasCheckBox.setSelected(true);
/* 132 */     this.useBiasCheckBox.setText(resourceMap.getString("useBiasCheckBox.text", new Object[0]));
/* 133 */     this.useBiasCheckBox.setName("useBiasCheckBox");
/* 134 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 135 */     gridBagConstraints.gridx = 1;
/* 136 */     gridBagConstraints.gridy = 4;
/* 137 */     gridBagConstraints.anchor = 17;
/* 138 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 139 */     this.inputPanel.add(this.useBiasCheckBox, gridBagConstraints);
/*     */     
/* 141 */     this.connectIOCheckBox.setText(resourceMap.getString("connectIOCheckBox.text", new Object[0]));
/* 142 */     this.connectIOCheckBox.setName("connectIOCheckBox");
/* 143 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 144 */     gridBagConstraints.gridx = 1;
/* 145 */     gridBagConstraints.gridy = 5;
/* 146 */     gridBagConstraints.anchor = 17;
/* 147 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 148 */     this.inputPanel.add(this.connectIOCheckBox, gridBagConstraints);
/*     */     
/* 150 */     this.learningRuleCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Backpropagation ", "Backpropagation with Momentum", "Dynamic Backpropagation" }));
/* 151 */     this.learningRuleCombo.setName("learningRuleCombo");
/* 152 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 153 */     gridBagConstraints.gridx = 1;
/* 154 */     gridBagConstraints.gridy = 7;
/* 155 */     gridBagConstraints.anchor = 17;
/* 156 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 157 */     this.inputPanel.add(this.learningRuleCombo, gridBagConstraints);
/*     */     
/* 159 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 160 */     this.jLabel2.setName("jLabel2");
/* 161 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 162 */     gridBagConstraints.gridx = 0;
/* 163 */     gridBagConstraints.gridy = 7;
/* 164 */     gridBagConstraints.anchor = 17;
/* 165 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 166 */     this.inputPanel.add(this.jLabel2, gridBagConstraints);
/*     */     
/* 168 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 169 */     this.jLabel3.setName("jLabel3");
/* 170 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 171 */     gridBagConstraints.anchor = 17;
/* 172 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 173 */     this.inputPanel.add(this.jLabel3, gridBagConstraints);
/*     */     
/* 175 */     this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
/* 176 */     this.jLabel4.setName("jLabel4");
/* 177 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 178 */     gridBagConstraints.gridx = 0;
/* 179 */     gridBagConstraints.gridy = 3;
/* 180 */     gridBagConstraints.anchor = 17;
/* 181 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
/* 182 */     this.inputPanel.add(this.jLabel4, gridBagConstraints);
/*     */     
/* 184 */     this.inputNeuronsField.setColumns(3);
/* 185 */     this.inputNeuronsField.setText(resourceMap.getString("inputNeuronsField.text", new Object[0]));
/* 186 */     this.inputNeuronsField.setName("inputNeuronsField");
/* 187 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 188 */     gridBagConstraints.anchor = 17;
/* 189 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 190 */     this.inputPanel.add(this.inputNeuronsField, gridBagConstraints);
/*     */     
/* 192 */     this.outputNeuronsField.setColumns(3);
/* 193 */     this.outputNeuronsField.setText(resourceMap.getString("outputNeuronsField.text", new Object[0]));
/* 194 */     this.outputNeuronsField.setName("outputNeuronsField");
/* 195 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 196 */     gridBagConstraints.gridx = 1;
/* 197 */     gridBagConstraints.gridy = 3;
/* 198 */     gridBagConstraints.anchor = 17;
/* 199 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
/* 200 */     this.inputPanel.add(this.outputNeuronsField, gridBagConstraints);
/*     */     
/* 202 */     this.jLabel5.setFont(resourceMap.getFont("jLabel5.font"));
/* 203 */     this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
/* 204 */     this.jLabel5.setName("jLabel5");
/* 205 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 206 */     gridBagConstraints.gridx = 1;
/* 207 */     gridBagConstraints.gridy = 2;
/* 208 */     this.inputPanel.add(this.jLabel5, gridBagConstraints);
/*     */     
/* 210 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 211 */     gridBagConstraints.fill = 1;
/* 212 */     gridBagConstraints.weightx = 400.0D;
/* 213 */     gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
/* 214 */     getContentPane().add(this.inputPanel, gridBagConstraints);
/*     */     
/* 216 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/* 218 */     javax.swing.ActionMap actionMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getActionMap(MultiLayerPerceptronWizard.class, this);
/* 219 */     this.createButton.setAction(actionMap.get("create"));
/* 220 */     this.createButton.setText(resourceMap.getString("createButton.text", new Object[0]));
/* 221 */     this.createButton.setName("createButton");
/* 222 */     this.buttonPanel.add(this.createButton);
/*     */     
/* 224 */     this.cancelButton.setAction(actionMap.get("cancel"));
/* 225 */     this.cancelButton.setText(resourceMap.getString("cancelButton.text", new Object[0]));
/* 226 */     this.cancelButton.setName("cancelButton");
/* 227 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/* 229 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 230 */     gridBagConstraints.gridx = 0;
/* 231 */     gridBagConstraints.gridy = 1;
/* 232 */     gridBagConstraints.fill = 1;
/* 233 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
/* 234 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 236 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 244 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 246 */         MultiLayerPerceptronWizard dialog = new MultiLayerPerceptronWizard(new javax.swing.JFrame(), true);
/*     */         
/* 248 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 250 */             System.exit(0);
/*     */           }
/* 252 */         });
/* 253 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void fillTransferFunctionCombo() {
/* 259 */     this.transferComboBox.removeAllItems();
/* 260 */     this.transferComboBox.addItem(new ComboItem("Sigmoid", org.neuroph.util.TransferFunctionType.SIGMOID.toString()));
/* 261 */     this.transferComboBox.addItem(new ComboItem("Tanh", org.neuroph.util.TransferFunctionType.TANH.toString()));
/*     */   }
/*     */   
/*     */   private void fillLearningRuleCombo() {
/* 265 */     this.learningRuleCombo.removeAllItems();
/* 266 */     this.learningRuleCombo.addItem(new ComboItem("Backpropagation", org.neuroph.nnet.learning.BackPropagation.class));
/* 267 */     this.learningRuleCombo.addItem(new ComboItem("Backpropagation with Momentum", org.neuroph.nnet.learning.MomentumBackpropagation.class));
/* 268 */     this.learningRuleCombo.addItem(new ComboItem("Dynamic Backpropagation", org.neuroph.nnet.learning.DynamicBackPropagation.class));
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 273 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/* 278 */     String inputNeuronsNum = this.inputNeuronsField.getText().trim();
/* 279 */     String hiddenNeuronsNum = this.hiddenNeuronsField.getText().trim();
/* 280 */     String outputNeuronsNum = this.outputNeuronsField.getText().trim();
/*     */     
/* 282 */     String neuronsStr = inputNeuronsNum + " " + hiddenNeuronsNum + " " + outputNeuronsNum;
/*     */     
/* 284 */     org.neuroph.util.TransferFunctionType transferFuncType = org.neuroph.util.TransferFunctionType.valueOf(((ComboItem)this.transferComboBox.getSelectedItem()).getValue().toString());
/* 285 */     Class learningRule = (Class)((ComboItem)this.learningRuleCombo.getSelectedItem()).getValue();
/* 286 */     boolean useBias = this.useBiasCheckBox.isSelected();
/* 287 */     boolean connectIO = this.connectIOCheckBox.isSelected();
/*     */     
/* 289 */     this.mainFrame.newMLPerceptronNetwork(neuronsStr, transferFuncType, learningRule, useBias, connectIO);
/* 290 */     setVisible(false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\MultiLayerPerceptronWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */