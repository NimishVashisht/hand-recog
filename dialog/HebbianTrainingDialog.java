/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class HebbianTrainingDialog extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.NeuralNetworkTraining controller;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JPanel buttonPanel;
/*     */   private javax.swing.JButton closeButton;
/*     */   private javax.swing.JButton helpButton;
/*     */   private JPanel inputPanel;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private JTextField learningRateField;
/*     */   private javax.swing.JCheckBox limitIterationsCheckkBox;
/*     */   private JTextField maxErrorField;
/*     */   private JTextField maxIterationsField;
/*     */   private javax.swing.JButton trainButton;
/*     */   
/*     */   public HebbianTrainingDialog(java.awt.Frame parent, boolean modal)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*     */   }
/*     */   
/*     */   public HebbianTrainingDialog(java.awt.Frame parent, boolean modal, org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame, org.neuroph.easyneurons.NeuralNetworkTraining controller)
/*     */   {
/*  32 */     super(parent, modal);
/*  33 */     this.controller = controller;
/*  34 */     this.mainFrame = mainFrame;
/*  35 */     initComponents();
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
/*  49 */     this.inputPanel = new JPanel();
/*  50 */     this.jLabel1 = new javax.swing.JLabel();
/*  51 */     this.jLabel2 = new javax.swing.JLabel();
/*  52 */     this.jLabel3 = new javax.swing.JLabel();
/*  53 */     this.limitIterationsCheckkBox = new javax.swing.JCheckBox();
/*  54 */     this.learningRateField = new JTextField();
/*  55 */     this.maxErrorField = new JTextField();
/*  56 */     this.maxIterationsField = new JTextField();
/*  57 */     this.buttonPanel = new JPanel();
/*  58 */     this.trainButton = new javax.swing.JButton();
/*  59 */     this.closeButton = new javax.swing.JButton();
/*  60 */     this.helpButton = new javax.swing.JButton();
/*     */     
/*  62 */     setDefaultCloseOperation(2);
/*  63 */     org.jdesktop.application.ResourceMap resourceMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getResourceMap(HebbianTrainingDialog.class);
/*     */     
/*     */ 
/*     */ 
/*  67 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  68 */     setModal(true);
/*  69 */     setName("Form");
/*  70 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  72 */     this.inputPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  73 */     this.inputPanel.setName("inputPanel");
/*  74 */     this.inputPanel.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  76 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/*  77 */     this.jLabel1.setName("jLabel1");
/*  78 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/*  79 */     gridBagConstraints.anchor = 17;
/*  80 */     gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 0);
/*  81 */     this.inputPanel.add(this.jLabel1, gridBagConstraints);
/*     */     
/*  83 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/*  84 */     this.jLabel2.setName("jLabel2");
/*  85 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  86 */     gridBagConstraints.gridx = 0;
/*  87 */     gridBagConstraints.gridy = 1;
/*  88 */     gridBagConstraints.anchor = 17;
/*  89 */     gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
/*  90 */     this.inputPanel.add(this.jLabel2, gridBagConstraints);
/*     */     
/*  92 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/*  93 */     this.jLabel3.setName("jLabel3");
/*  94 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  95 */     gridBagConstraints.gridx = 0;
/*  96 */     gridBagConstraints.gridy = 2;
/*  97 */     gridBagConstraints.anchor = 17;
/*  98 */     gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
/*  99 */     this.inputPanel.add(this.jLabel3, gridBagConstraints);
/*     */     
/* 101 */     this.limitIterationsCheckkBox.setText(resourceMap.getString("limitIterationsCheckkBox.text", new Object[0]));
/*     */     
/* 103 */     this.limitIterationsCheckkBox.setName("limitIterationsCheckkBox");
/* 104 */     this.limitIterationsCheckkBox.addItemListener(new java.awt.event.ItemListener()
/*     */     {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/* 107 */         HebbianTrainingDialog.this.limitIterationsCheckkBoxItemStateChanged(evt);
/*     */       }
/* 109 */     });
/* 110 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 111 */     gridBagConstraints.gridx = 0;
/* 112 */     gridBagConstraints.gridy = 3;
/* 113 */     gridBagConstraints.fill = 2;
/* 114 */     gridBagConstraints.anchor = 17;
/* 115 */     gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
/* 116 */     this.inputPanel.add(this.limitIterationsCheckkBox, gridBagConstraints);
/*     */     
/* 118 */     this.learningRateField.setColumns(8);
/* 119 */     this.learningRateField.setText(resourceMap.getString("learningRateField.text", new Object[0]));
/*     */     
/* 121 */     this.learningRateField.setName("learningRateField");
/* 122 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 123 */     gridBagConstraints.gridx = 1;
/* 124 */     gridBagConstraints.gridy = 0;
/* 125 */     gridBagConstraints.fill = 2;
/* 126 */     gridBagConstraints.anchor = 17;
/* 127 */     gridBagConstraints.weightx = 80.0D;
/* 128 */     gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 10);
/* 129 */     this.inputPanel.add(this.learningRateField, gridBagConstraints);
/*     */     
/* 131 */     this.maxErrorField.setColumns(8);
/* 132 */     this.maxErrorField.setText(resourceMap.getString("maxErrorField.text", new Object[0]));
/* 133 */     this.maxErrorField.setName("maxErrorField");
/* 134 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 135 */     gridBagConstraints.gridx = 1;
/* 136 */     gridBagConstraints.gridy = 1;
/* 137 */     gridBagConstraints.fill = 2;
/* 138 */     gridBagConstraints.anchor = 17;
/* 139 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
/* 140 */     this.inputPanel.add(this.maxErrorField, gridBagConstraints);
/*     */     
/* 142 */     this.maxIterationsField.setColumns(8);
/* 143 */     this.maxIterationsField.setEnabled(false);
/* 144 */     this.maxIterationsField.setName("maxIterationsField");
/* 145 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 146 */     gridBagConstraints.gridx = 1;
/* 147 */     gridBagConstraints.gridy = 2;
/* 148 */     gridBagConstraints.fill = 2;
/* 149 */     gridBagConstraints.anchor = 17;
/* 150 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
/* 151 */     this.inputPanel.add(this.maxIterationsField, gridBagConstraints);
/*     */     
/* 153 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 154 */     gridBagConstraints.fill = 2;
/* 155 */     gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
/* 156 */     getContentPane().add(this.inputPanel, gridBagConstraints);
/*     */     
/* 158 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/* 160 */     javax.swing.ActionMap actionMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getActionMap(HebbianTrainingDialog.class, this);
/*     */     
/*     */ 
/*     */ 
/* 164 */     this.trainButton.setAction(actionMap.get("train"));
/* 165 */     this.trainButton.setText(resourceMap.getString("trainButton.text", new Object[0]));
/* 166 */     this.trainButton.setName("trainButton");
/* 167 */     this.buttonPanel.add(this.trainButton);
/*     */     
/* 169 */     this.closeButton.setAction(actionMap.get("close"));
/* 170 */     this.closeButton.setText(resourceMap.getString("closeButton.text", new Object[0]));
/* 171 */     this.closeButton.setName("closeButton");
/* 172 */     this.buttonPanel.add(this.closeButton);
/*     */     
/* 174 */     this.helpButton.setText(resourceMap.getString("helpButton.text", new Object[0]));
/* 175 */     this.helpButton.setEnabled(false);
/* 176 */     this.helpButton.setName("helpButton");
/* 177 */     this.buttonPanel.add(this.helpButton);
/*     */     
/* 179 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 180 */     gridBagConstraints.gridx = 0;
/* 181 */     gridBagConstraints.gridy = 1;
/* 182 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
/* 183 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 185 */     pack();
/*     */   }
/*     */   
/*     */   private void limitIterationsCheckkBoxItemStateChanged(java.awt.event.ItemEvent evt)
/*     */   {
/* 190 */     if (this.maxIterationsField.isEnabled()) {
/* 191 */       this.maxIterationsField.setEnabled(false);
/*     */     } else {
/* 193 */       this.maxIterationsField.setEnabled(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 201 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 203 */         HebbianTrainingDialog dialog = new HebbianTrainingDialog(new javax.swing.JFrame(), true);
/*     */         
/* 205 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 207 */             System.exit(0);
/*     */           }
/* 209 */         });
/* 210 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void close() {
/* 217 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void train() {
/* 222 */     String learningRateStr = this.learningRateField.getText().toString();
/* 223 */     String maxErrorStr = this.maxErrorField.getText().toString();
/* 224 */     String maxIterationsStr = this.maxIterationsField.getText().toString();
/*     */     
/* 226 */     Double learningRate = new Double(learningRateStr);
/* 227 */     Double maxError = new Double(maxErrorStr);
/* 228 */     Integer maxIterations = new Integer(0);
/*     */     
/* 230 */     if (this.limitIterationsCheckkBox.isSelected()) {
/* 231 */       maxIterations = new Integer(maxIterationsStr);
/*     */     }
/* 233 */     this.controller.setLmsParams(learningRate, maxError, maxIterations);
/*     */     
/* 235 */     org.neuroph.nnet.learning.LMS learningRule = (org.neuroph.nnet.learning.LMS)this.controller.getNetwork().getLearningRule();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 241 */     SupervisedTrainingMonitorFrame monitorFrame = this.mainFrame.openMonitorFrame(this.controller);
/* 242 */     learningRule.addObserver(monitorFrame);
/*     */     
/* 244 */     this.controller.train();
/*     */     
/* 246 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\HebbianTrainingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */