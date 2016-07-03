/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class BackpropagationTrainingDialog extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   org.neuroph.easyneurons.NeuralNetworkTraining controller;
/*     */   private javax.swing.JPanel buttonPanel;
/*     */   private JTextField changeRateDLRField;
/*     */   private JTextField changeRateMomentumField;
/*     */   private javax.swing.JButton closeButton;
/*     */   private javax.swing.JCheckBox dynamicLearningRateCheckBox;
/*     */   private javax.swing.JCheckBox dynamicMomentumCheckBox;
/*     */   private javax.swing.JCheckBox graphCheckBox;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel10;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel5;
/*     */   private javax.swing.JLabel jLabel6;
/*     */   private javax.swing.JLabel jLabel7;
/*     */   private javax.swing.JLabel jLabel8;
/*     */   
/*     */   public BackpropagationTrainingDialog(java.awt.Frame parent, boolean modal)
/*     */   {
/*  29 */     super(parent, modal);
/*  30 */     initComponents();
/*     */   }
/*     */   
/*     */   public BackpropagationTrainingDialog(java.awt.Frame parent, org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame, boolean modal, org.neuroph.easyneurons.NeuralNetworkTraining controller)
/*     */   {
/*  35 */     super(parent, modal);
/*  36 */     this.controller = controller;
/*  37 */     this.mainFrame = mainFrame;
/*  38 */     initComponents();
/*     */   }
/*     */   
/*     */ 
/*     */   private javax.swing.JLabel jLabel9;
/*     */   
/*     */   private javax.swing.JPanel jPanel1;
/*     */   
/*     */   private javax.swing.JPanel jPanel2;
/*     */   
/*     */   private javax.swing.JPanel jPanel3;
/*     */   
/*     */   private javax.swing.JPanel jPanel4;
/*     */   private JTextField learningRateField;
/*     */   private javax.swing.JCheckBox limitIterationsCheckkBox;
/*     */   private JTextField maxDLRField;
/*     */   private javax.swing.JLabel maxErrLabel;
/*     */   
/*     */   private void initComponents()
/*     */   {
/*  58 */     this.buttonPanel = new javax.swing.JPanel();
/*  59 */     this.trainButton = new javax.swing.JButton();
/*  60 */     this.closeButton = new javax.swing.JButton();
/*  61 */     this.jPanel1 = new javax.swing.JPanel();
/*  62 */     this.maxErrLabel = new javax.swing.JLabel();
/*  63 */     this.maxErrorField = new JTextField();
/*  64 */     this.maxIterationsField = new JTextField();
/*  65 */     this.limitIterationsCheckkBox = new javax.swing.JCheckBox();
/*  66 */     this.minErrorChangeField = new JTextField();
/*  67 */     this.minErrorChangeIterationsField = new JTextField();
/*  68 */     this.jLabel2 = new javax.swing.JLabel();
/*  69 */     this.jLabel10 = new javax.swing.JLabel();
/*  70 */     this.minErrorChangeCheckBox = new javax.swing.JCheckBox();
/*  71 */     this.jPanel2 = new javax.swing.JPanel();
/*  72 */     this.jLabel1 = new javax.swing.JLabel();
/*  73 */     this.learningRateField = new JTextField();
/*  74 */     this.dynamicLearningRateCheckBox = new javax.swing.JCheckBox();
/*  75 */     this.jLabel3 = new javax.swing.JLabel();
/*  76 */     this.jLabel5 = new javax.swing.JLabel();
/*  77 */     this.jLabel6 = new javax.swing.JLabel();
/*  78 */     this.minDLRField = new JTextField();
/*  79 */     this.maxDLRField = new JTextField();
/*  80 */     this.changeRateDLRField = new JTextField();
/*  81 */     this.jPanel3 = new javax.swing.JPanel();
/*  82 */     this.jLabel4 = new javax.swing.JLabel();
/*  83 */     this.dynamicMomentumCheckBox = new javax.swing.JCheckBox();
/*  84 */     this.momentumtField = new JTextField();
/*  85 */     this.minMomentumField = new JTextField();
/*  86 */     this.maxMomentumField = new JTextField();
/*  87 */     this.changeRateMomentumField = new JTextField();
/*  88 */     this.jLabel9 = new javax.swing.JLabel();
/*  89 */     this.jLabel8 = new javax.swing.JLabel();
/*  90 */     this.jLabel7 = new javax.swing.JLabel();
/*  91 */     this.jPanel4 = new javax.swing.JPanel();
/*  92 */     this.graphCheckBox = new javax.swing.JCheckBox();
/*     */     
/*  94 */     setDefaultCloseOperation(2);
/*  95 */     org.jdesktop.application.ResourceMap resourceMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getResourceMap(BackpropagationTrainingDialog.class);
/*  96 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  97 */     setModal(true);
/*  98 */     setName("Form");
/*  99 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/* 101 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/* 103 */     javax.swing.ActionMap actionMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getActionMap(BackpropagationTrainingDialog.class, this);
/* 104 */     this.trainButton.setAction(actionMap.get("train"));
/* 105 */     this.trainButton.setText(resourceMap.getString("trainButton.text", new Object[0]));
/* 106 */     this.trainButton.setName("trainButton");
/* 107 */     this.buttonPanel.add(this.trainButton);
/*     */     
/* 109 */     this.closeButton.setAction(actionMap.get("close"));
/* 110 */     this.closeButton.setText(resourceMap.getString("closeButton.text", new Object[0]));
/* 111 */     this.closeButton.setName("closeButton");
/* 112 */     this.buttonPanel.add(this.closeButton);
/*     */     
/* 114 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/* 115 */     gridBagConstraints.gridx = 0;
/* 116 */     gridBagConstraints.gridy = 2;
/* 117 */     gridBagConstraints.gridwidth = 3;
/* 118 */     gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
/* 119 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 121 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/* 122 */     this.jPanel1.setName("jPanel1");
/* 123 */     this.jPanel1.setLayout(new java.awt.GridBagLayout());
/*     */     
/* 125 */     this.maxErrLabel.setText(resourceMap.getString("maxErrLabel.text", new Object[0]));
/* 126 */     this.maxErrLabel.setName("maxErrLabel");
/* 127 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 128 */     gridBagConstraints.gridx = 0;
/* 129 */     gridBagConstraints.gridy = 0;
/* 130 */     gridBagConstraints.anchor = 17;
/* 131 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 132 */     this.jPanel1.add(this.maxErrLabel, gridBagConstraints);
/*     */     
/* 134 */     this.maxErrorField.setColumns(8);
/* 135 */     this.maxErrorField.setText(resourceMap.getString("maxErrorField.text", new Object[0]));
/* 136 */     this.maxErrorField.setName("maxErrorField");
/* 137 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 138 */     gridBagConstraints.gridx = 1;
/* 139 */     gridBagConstraints.gridy = 0;
/* 140 */     gridBagConstraints.fill = 2;
/* 141 */     gridBagConstraints.anchor = 17;
/* 142 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 143 */     this.jPanel1.add(this.maxErrorField, gridBagConstraints);
/*     */     
/* 145 */     this.maxIterationsField.setColumns(8);
/* 146 */     this.maxIterationsField.setEnabled(false);
/* 147 */     this.maxIterationsField.setName("maxIterationsField");
/* 148 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 149 */     gridBagConstraints.gridx = 1;
/* 150 */     gridBagConstraints.gridy = 1;
/* 151 */     gridBagConstraints.fill = 2;
/* 152 */     gridBagConstraints.anchor = 17;
/* 153 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 154 */     this.jPanel1.add(this.maxIterationsField, gridBagConstraints);
/*     */     
/* 156 */     this.limitIterationsCheckkBox.setText(resourceMap.getString("limitIterationsCheckkBox.text", new Object[0]));
/* 157 */     this.limitIterationsCheckkBox.setName("limitIterationsCheckkBox");
/* 158 */     this.limitIterationsCheckkBox.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/* 160 */         BackpropagationTrainingDialog.this.limitIterationsCheckkBoxItemStateChanged(evt);
/*     */       }
/* 162 */     });
/* 163 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 164 */     gridBagConstraints.gridx = 0;
/* 165 */     gridBagConstraints.gridy = 1;
/* 166 */     gridBagConstraints.anchor = 17;
/* 167 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 168 */     this.jPanel1.add(this.limitIterationsCheckkBox, gridBagConstraints);
/*     */     
/* 170 */     this.minErrorChangeField.setColumns(8);
/* 171 */     this.minErrorChangeField.setText(resourceMap.getString("minErrorChangeField.text", new Object[0]));
/* 172 */     this.minErrorChangeField.setEnabled(false);
/* 173 */     this.minErrorChangeField.setName("minErrorChangeField");
/* 174 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 175 */     gridBagConstraints.gridx = 1;
/* 176 */     gridBagConstraints.gridy = 3;
/* 177 */     gridBagConstraints.anchor = 17;
/* 178 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 179 */     this.jPanel1.add(this.minErrorChangeField, gridBagConstraints);
/*     */     
/* 181 */     this.minErrorChangeIterationsField.setColumns(8);
/* 182 */     this.minErrorChangeIterationsField.setText(resourceMap.getString("minErrorChangeIterationsField.text", new Object[0]));
/* 183 */     this.minErrorChangeIterationsField.setEnabled(false);
/* 184 */     this.minErrorChangeIterationsField.setName("minErrorChangeIterationsField");
/* 185 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 186 */     gridBagConstraints.gridx = 1;
/* 187 */     gridBagConstraints.gridy = 4;
/* 188 */     gridBagConstraints.anchor = 17;
/* 189 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 190 */     this.jPanel1.add(this.minErrorChangeIterationsField, gridBagConstraints);
/*     */     
/* 192 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 193 */     this.jLabel2.setName("jLabel2");
/* 194 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 195 */     gridBagConstraints.gridx = 0;
/* 196 */     gridBagConstraints.gridy = 3;
/* 197 */     gridBagConstraints.anchor = 17;
/* 198 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 199 */     this.jPanel1.add(this.jLabel2, gridBagConstraints);
/*     */     
/* 201 */     this.jLabel10.setText(resourceMap.getString("jLabel10.text", new Object[0]));
/* 202 */     this.jLabel10.setName("jLabel10");
/* 203 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 204 */     gridBagConstraints.gridx = 0;
/* 205 */     gridBagConstraints.gridy = 4;
/* 206 */     gridBagConstraints.anchor = 17;
/* 207 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 208 */     this.jPanel1.add(this.jLabel10, gridBagConstraints);
/*     */     
/* 210 */     this.minErrorChangeCheckBox.setText(resourceMap.getString("minErrorChangeCheckBox.text", new Object[0]));
/* 211 */     this.minErrorChangeCheckBox.setName("minErrorChangeCheckBox");
/* 212 */     this.minErrorChangeCheckBox.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/* 214 */         BackpropagationTrainingDialog.this.minErrorChangeCheckBoxItemStateChanged(evt);
/*     */       }
/* 216 */     });
/* 217 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 218 */     gridBagConstraints.gridx = 0;
/* 219 */     gridBagConstraints.gridy = 2;
/* 220 */     gridBagConstraints.anchor = 17;
/* 221 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 222 */     this.jPanel1.add(this.minErrorChangeCheckBox, gridBagConstraints);
/*     */     
/* 224 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 225 */     gridBagConstraints.anchor = 11;
/* 226 */     getContentPane().add(this.jPanel1, gridBagConstraints);
/*     */     
/* 228 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title", new Object[0])));
/* 229 */     this.jPanel2.setName("jPanel2");
/* 230 */     this.jPanel2.setLayout(new java.awt.GridBagLayout());
/*     */     
/* 232 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 233 */     this.jLabel1.setName("jLabel1");
/* 234 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 235 */     gridBagConstraints.anchor = 17;
/* 236 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 237 */     this.jPanel2.add(this.jLabel1, gridBagConstraints);
/*     */     
/* 239 */     this.learningRateField.setColumns(8);
/* 240 */     this.learningRateField.setText(resourceMap.getString("learningRateField.text", new Object[0]));
/* 241 */     this.learningRateField.setName("learningRateField");
/* 242 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 243 */     gridBagConstraints.gridx = 1;
/* 244 */     gridBagConstraints.gridy = 0;
/* 245 */     gridBagConstraints.anchor = 17;
/* 246 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 247 */     this.jPanel2.add(this.learningRateField, gridBagConstraints);
/*     */     
/* 249 */     this.dynamicLearningRateCheckBox.setText(resourceMap.getString("dynamicLearningRateCheckBox.text", new Object[0]));
/* 250 */     this.dynamicLearningRateCheckBox.setName("dynamicLearningRateCheckBox");
/* 251 */     this.dynamicLearningRateCheckBox.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/* 253 */         BackpropagationTrainingDialog.this.dynamicLearningRateCheckBoxItemStateChanged(evt);
/*     */       }
/* 255 */     });
/* 256 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 257 */     gridBagConstraints.gridx = 0;
/* 258 */     gridBagConstraints.gridy = 1;
/* 259 */     gridBagConstraints.anchor = 17;
/* 260 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 261 */     this.jPanel2.add(this.dynamicLearningRateCheckBox, gridBagConstraints);
/*     */     
/* 263 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 264 */     this.jLabel3.setName("jLabel3");
/* 265 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 266 */     gridBagConstraints.gridx = 0;
/* 267 */     gridBagConstraints.gridy = 2;
/* 268 */     gridBagConstraints.anchor = 17;
/* 269 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 270 */     this.jPanel2.add(this.jLabel3, gridBagConstraints);
/*     */     
/* 272 */     this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
/* 273 */     this.jLabel5.setName("jLabel5");
/* 274 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 275 */     gridBagConstraints.gridx = 0;
/* 276 */     gridBagConstraints.gridy = 3;
/* 277 */     gridBagConstraints.anchor = 17;
/* 278 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 279 */     this.jPanel2.add(this.jLabel5, gridBagConstraints);
/*     */     
/* 281 */     this.jLabel6.setText(resourceMap.getString("jLabel6.text", new Object[0]));
/* 282 */     this.jLabel6.setName("jLabel6");
/* 283 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 284 */     gridBagConstraints.gridx = 0;
/* 285 */     gridBagConstraints.gridy = 4;
/* 286 */     gridBagConstraints.anchor = 17;
/* 287 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 288 */     this.jPanel2.add(this.jLabel6, gridBagConstraints);
/*     */     
/* 290 */     this.minDLRField.setColumns(8);
/* 291 */     this.minDLRField.setText(resourceMap.getString("minDLRField.text", new Object[0]));
/* 292 */     this.minDLRField.setEnabled(false);
/* 293 */     this.minDLRField.setName("minDLRField");
/* 294 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 295 */     gridBagConstraints.gridx = 1;
/* 296 */     gridBagConstraints.gridy = 2;
/* 297 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 298 */     this.jPanel2.add(this.minDLRField, gridBagConstraints);
/*     */     
/* 300 */     this.maxDLRField.setColumns(8);
/* 301 */     this.maxDLRField.setText(resourceMap.getString("maxDLRField.text", new Object[0]));
/* 302 */     this.maxDLRField.setEnabled(false);
/* 303 */     this.maxDLRField.setName("maxDLRField");
/* 304 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 305 */     gridBagConstraints.gridx = 1;
/* 306 */     gridBagConstraints.gridy = 3;
/* 307 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 308 */     this.jPanel2.add(this.maxDLRField, gridBagConstraints);
/*     */     
/* 310 */     this.changeRateDLRField.setColumns(8);
/* 311 */     this.changeRateDLRField.setText(resourceMap.getString("changeRateDLRField.text", new Object[0]));
/* 312 */     this.changeRateDLRField.setEnabled(false);
/* 313 */     this.changeRateDLRField.setName("changeRateDLRField");
/* 314 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 315 */     gridBagConstraints.gridx = 1;
/* 316 */     gridBagConstraints.gridy = 4;
/* 317 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 318 */     this.jPanel2.add(this.changeRateDLRField, gridBagConstraints);
/*     */     
/* 320 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 321 */     gridBagConstraints.gridx = 1;
/* 322 */     gridBagConstraints.gridy = 0;
/* 323 */     gridBagConstraints.fill = 1;
/* 324 */     gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
/* 325 */     getContentPane().add(this.jPanel2, gridBagConstraints);
/*     */     
/* 327 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title", new Object[0])));
/* 328 */     this.jPanel3.setName("jPanel3");
/* 329 */     this.jPanel3.setLayout(new java.awt.GridBagLayout());
/*     */     
/* 331 */     this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
/* 332 */     this.jLabel4.setName("jLabel4");
/* 333 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 334 */     gridBagConstraints.anchor = 17;
/* 335 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 336 */     this.jPanel3.add(this.jLabel4, gridBagConstraints);
/*     */     
/* 338 */     this.dynamicMomentumCheckBox.setText(resourceMap.getString("dynamicMomentumCheckBox.text", new Object[0]));
/* 339 */     this.dynamicMomentumCheckBox.setName("dynamicMomentumCheckBox");
/* 340 */     this.dynamicMomentumCheckBox.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/* 342 */         BackpropagationTrainingDialog.this.dynamicMomentumCheckBoxItemStateChanged(evt);
/*     */       }
/* 344 */     });
/* 345 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 346 */     gridBagConstraints.gridx = 0;
/* 347 */     gridBagConstraints.gridy = 1;
/* 348 */     gridBagConstraints.anchor = 17;
/* 349 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 350 */     this.jPanel3.add(this.dynamicMomentumCheckBox, gridBagConstraints);
/*     */     
/* 352 */     this.momentumtField.setColumns(8);
/* 353 */     this.momentumtField.setText(resourceMap.getString("momentumtField.text", new Object[0]));
/* 354 */     this.momentumtField.setName("momentumtField");
/* 355 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 356 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 357 */     this.jPanel3.add(this.momentumtField, gridBagConstraints);
/*     */     
/* 359 */     this.minMomentumField.setColumns(8);
/* 360 */     this.minMomentumField.setText(resourceMap.getString("minMomentumField.text", new Object[0]));
/* 361 */     this.minMomentumField.setEnabled(false);
/* 362 */     this.minMomentumField.setName("minMomentumField");
/* 363 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 364 */     gridBagConstraints.gridx = 1;
/* 365 */     gridBagConstraints.gridy = 2;
/* 366 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 367 */     this.jPanel3.add(this.minMomentumField, gridBagConstraints);
/*     */     
/* 369 */     this.maxMomentumField.setColumns(8);
/* 370 */     this.maxMomentumField.setText(resourceMap.getString("maxMomentumField.text", new Object[0]));
/* 371 */     this.maxMomentumField.setEnabled(false);
/* 372 */     this.maxMomentumField.setName("maxMomentumField");
/* 373 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 374 */     gridBagConstraints.gridx = 1;
/* 375 */     gridBagConstraints.gridy = 3;
/* 376 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 377 */     this.jPanel3.add(this.maxMomentumField, gridBagConstraints);
/*     */     
/* 379 */     this.changeRateMomentumField.setColumns(8);
/* 380 */     this.changeRateMomentumField.setText(resourceMap.getString("changeRateMomentumField.text", new Object[0]));
/* 381 */     this.changeRateMomentumField.setEnabled(false);
/* 382 */     this.changeRateMomentumField.setName("changeRateMomentumField");
/* 383 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 384 */     gridBagConstraints.gridx = 1;
/* 385 */     gridBagConstraints.gridy = 4;
/* 386 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 387 */     this.jPanel3.add(this.changeRateMomentumField, gridBagConstraints);
/*     */     
/* 389 */     this.jLabel9.setText(resourceMap.getString("jLabel9.text", new Object[0]));
/* 390 */     this.jLabel9.setName("jLabel9");
/* 391 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 392 */     gridBagConstraints.gridx = 0;
/* 393 */     gridBagConstraints.gridy = 4;
/* 394 */     gridBagConstraints.anchor = 17;
/* 395 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 396 */     this.jPanel3.add(this.jLabel9, gridBagConstraints);
/*     */     
/* 398 */     this.jLabel8.setText(resourceMap.getString("jLabel8.text", new Object[0]));
/* 399 */     this.jLabel8.setName("jLabel8");
/* 400 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 401 */     gridBagConstraints.gridx = 0;
/* 402 */     gridBagConstraints.gridy = 3;
/* 403 */     gridBagConstraints.anchor = 17;
/* 404 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 405 */     this.jPanel3.add(this.jLabel8, gridBagConstraints);
/*     */     
/* 407 */     this.jLabel7.setText(resourceMap.getString("jLabel7.text", new Object[0]));
/* 408 */     this.jLabel7.setName("jLabel7");
/* 409 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 410 */     gridBagConstraints.gridx = 0;
/* 411 */     gridBagConstraints.gridy = 2;
/* 412 */     gridBagConstraints.anchor = 17;
/* 413 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 414 */     this.jPanel3.add(this.jLabel7, gridBagConstraints);
/*     */     
/* 416 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 417 */     gridBagConstraints.gridx = 2;
/* 418 */     gridBagConstraints.gridy = 0;
/* 419 */     gridBagConstraints.fill = 1;
/* 420 */     gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
/* 421 */     getContentPane().add(this.jPanel3, gridBagConstraints);
/*     */     
/* 423 */     this.jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel4.border.title", new Object[0])));
/* 424 */     this.jPanel4.setName("jPanel4");
/* 425 */     this.jPanel4.setLayout(new java.awt.GridBagLayout());
/*     */     
/* 427 */     this.graphCheckBox.setSelected(true);
/* 428 */     this.graphCheckBox.setText(resourceMap.getString("graphCheckBox.text", new Object[0]));
/* 429 */     this.graphCheckBox.setName("graphCheckBox");
/* 430 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 431 */     gridBagConstraints.anchor = 17;
/* 432 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 433 */     this.jPanel4.add(this.graphCheckBox, gridBagConstraints);
/*     */     
/* 435 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 436 */     gridBagConstraints.gridx = 0;
/* 437 */     gridBagConstraints.gridy = 1;
/* 438 */     gridBagConstraints.fill = 1;
/* 439 */     gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
/* 440 */     getContentPane().add(this.jPanel4, gridBagConstraints);
/*     */     
/* 442 */     pack();
/*     */   }
/*     */   
/*     */   private void dynamicLearningRateCheckBoxItemStateChanged(java.awt.event.ItemEvent evt)
/*     */   {
/* 447 */     if (this.dynamicLearningRateCheckBox.isSelected()) {
/* 448 */       this.minDLRField.setEnabled(true);
/* 449 */       this.maxDLRField.setEnabled(true);
/* 450 */       this.changeRateDLRField.setEnabled(true);
/*     */     } else {
/* 452 */       this.minDLRField.setEnabled(false);
/* 453 */       this.maxDLRField.setEnabled(false);
/* 454 */       this.changeRateDLRField.setEnabled(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dynamicMomentumCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {
/* 459 */     if (this.dynamicMomentumCheckBox.isSelected()) {
/* 460 */       this.minMomentumField.setEnabled(true);
/* 461 */       this.maxMomentumField.setEnabled(true);
/* 462 */       this.changeRateMomentumField.setEnabled(true);
/*     */     } else {
/* 464 */       this.minMomentumField.setEnabled(false);
/* 465 */       this.maxMomentumField.setEnabled(false);
/* 466 */       this.changeRateMomentumField.setEnabled(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void minErrorChangeCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {
/* 471 */     if (this.minErrorChangeCheckBox.isSelected()) {
/* 472 */       this.minErrorChangeField.setEnabled(true);
/* 473 */       this.minErrorChangeIterationsField.setEnabled(true);
/*     */     } else {
/* 475 */       this.minErrorChangeField.setEnabled(false);
/* 476 */       this.minErrorChangeIterationsField.setEnabled(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void limitIterationsCheckkBoxItemStateChanged(java.awt.event.ItemEvent evt)
/*     */   {
/* 482 */     if (this.limitIterationsCheckkBox.isSelected()) {
/* 483 */       this.maxIterationsField.setEnabled(true);
/*     */     } else
/* 485 */       this.maxIterationsField.setEnabled(false); }
/*     */   
/*     */   private JTextField maxErrorField;
/*     */   private JTextField maxIterationsField;
/*     */   private JTextField maxMomentumField;
/*     */   private JTextField minDLRField;
/*     */   private javax.swing.JCheckBox minErrorChangeCheckBox;
/*     */   
/* 493 */   public static void main(String[] args) { java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 495 */         BackpropagationTrainingDialog dialog = new BackpropagationTrainingDialog(new javax.swing.JFrame(), true);
/*     */         
/* 497 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 499 */             System.exit(0);
/*     */           }
/* 501 */         });
/* 502 */         dialog.setVisible(true);
/*     */       } }); }
/*     */   
/*     */   private JTextField minErrorChangeField;
/*     */   private JTextField minErrorChangeIterationsField;
/*     */   
/*     */   @org.jdesktop.application.Action
/* 509 */   public void close() { dispose(); }
/*     */   
/*     */   private JTextField minMomentumField;
/*     */   
/*     */   @org.jdesktop.application.Action
/* 514 */   public void train() { String maxErrorStr = this.maxErrorField.getText().toString();
/* 515 */     String maxIterationsStr = this.maxIterationsField.getText().toString();
/*     */     
/* 517 */     String learningRateStr = this.learningRateField.getText().toString();
/*     */     
/* 519 */     String momentumStr = this.momentumtField.getText().toString();
/*     */     
/* 521 */     Double learningRate = new Double(learningRateStr);
/* 522 */     Double maxError = new Double(maxErrorStr);
/* 523 */     Integer maxIterations = new Integer(0);
/* 524 */     Double momentum = new Double(momentumStr);
/*     */     
/* 526 */     if (this.limitIterationsCheckkBox.isSelected()) {
/* 527 */       maxIterations = new Integer(maxIterationsStr);
/*     */     }
/* 529 */     this.controller.setLmsParams(learningRate, maxError, maxIterations);
/*     */     
/* 531 */     org.neuroph.nnet.learning.BackPropagation learningRule = (org.neuroph.nnet.learning.BackPropagation)this.controller.getNetwork().getLearningRule();
/*     */     
/* 533 */     if (this.minErrorChangeCheckBox.isSelected()) {
/* 534 */       learningRule.setMinErrorChange(new Double(this.minErrorChangeField.getText().trim()).doubleValue());
/* 535 */       learningRule.setMinErrorChangeIterationsLimit(new Integer(this.minErrorChangeIterationsField.getText().trim()).intValue());
/*     */     }
/*     */     
/* 538 */     if ((learningRule instanceof org.neuroph.nnet.learning.MomentumBackpropagation)) {
/* 539 */       ((org.neuroph.nnet.learning.MomentumBackpropagation)learningRule).setMomentum(momentum.doubleValue());
/*     */     }
/*     */     
/* 542 */     if ((learningRule instanceof org.neuroph.nnet.learning.DynamicBackPropagation)) {
/* 543 */       org.neuroph.nnet.learning.DynamicBackPropagation dbp = (org.neuroph.nnet.learning.DynamicBackPropagation)learningRule;
/*     */       
/* 545 */       dbp.setMomentum(momentum.doubleValue());
/*     */       
/* 547 */       if (this.dynamicLearningRateCheckBox.isSelected()) {
/* 548 */         Double minDLR = new Double(this.minDLRField.getText().trim());
/* 549 */         Double maxDLR = new Double(this.maxDLRField.getText().trim());
/* 550 */         Double changeRateDLR = new Double(this.changeRateDLRField.getText().trim());
/*     */         
/* 552 */         dbp.setUseDynamicLearningRate(true);
/* 553 */         dbp.setMinLearningRate(minDLR.doubleValue());
/* 554 */         dbp.setMaxLearningRate(maxDLR.doubleValue());
/* 555 */         dbp.setLearningRateChange(changeRateDLR.doubleValue());
/*     */       } else {
/* 557 */         dbp.setUseDynamicLearningRate(false);
/*     */       }
/*     */       
/* 560 */       if (this.dynamicMomentumCheckBox.isSelected()) {
/* 561 */         Double minMomentum = new Double(this.minMomentumField.getText().trim());
/* 562 */         Double maxMomentum = new Double(this.maxMomentumField.getText().trim());
/* 563 */         Double changeRateMomentum = new Double(this.changeRateMomentumField.getText().trim());
/*     */         
/* 565 */         dbp.setUseDynamicMomentum(true);
/* 566 */         dbp.setMinMomentum(minMomentum.doubleValue());
/* 567 */         dbp.setMaxMomentum(maxMomentum.doubleValue());
/* 568 */         dbp.setMomentumChange(changeRateMomentum.doubleValue());
/*     */       } else {
/* 570 */         dbp.setUseDynamicMomentum(false);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 575 */     if (this.graphCheckBox.isSelected()) {
/* 576 */       org.neuroph.easyneurons.errorgraph.GraphFrame graphFrame = this.mainFrame.openErrorGraphFrame();
/* 577 */       graphFrame.observe(learningRule);
/*     */     }
/*     */     
/* 580 */     SupervisedTrainingMonitorFrame monitorFrame = this.mainFrame.openMonitorFrame(this.controller);
/* 581 */     learningRule.addObserver(monitorFrame);
/*     */     
/* 583 */     this.controller.train();
/*     */     
/* 585 */     dispose();
/*     */   }
/*     */   
/*     */   private JTextField momentumtField;
/*     */   private javax.swing.JButton trainButton;
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\BackpropagationTrainingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */