/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class NeuronPropertiesFrame extends javax.swing.JInternalFrame {
/*     */   private JTextField biasField;
/*     */   private javax.swing.JButton closeButton;
/*     */   private JTextField inputField;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel5;
/*     */   private javax.swing.JLabel jLabel6;
/*     */   private javax.swing.JLabel jLabel7;
/*     */   private javax.swing.JLabel jLabel8;
/*     */   private javax.swing.JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private JTextField labelField;
/*     */   private JTextField neuronTypeField;
/*     */   private JTextField outputField;
/*     */   private JTextField sumFuncField;
/*     */   private JTextField transFuncField;
/*     */   private JTextField weightFuncField;
/*     */   private javax.swing.JTextArea weightsField;
/*     */   
/*  29 */   public NeuronPropertiesFrame() { initComponents(); }
/*     */   
/*     */   public NeuronPropertiesFrame(org.neuroph.core.Neuron neuron)
/*     */   {
/*  33 */     initComponents();
/*  34 */     this.inputField.setText(Double.toString(neuron.getNetInput()));
/*  35 */     this.outputField.setText(Double.toString(neuron.getOutput()));
/*     */     
/*  37 */     this.neuronTypeField.setText(neuron.getClass().getName());
/*     */     
/*  39 */     if ((neuron instanceof org.neuroph.nnet.comp.InputOutputNeuron)) {
/*  40 */       this.biasField.setText(Double.toString(((org.neuroph.nnet.comp.InputOutputNeuron)neuron).getBias()));
/*  41 */     } else if ((neuron instanceof org.neuroph.nnet.comp.ThresholdNeuron)) {
/*  42 */       this.biasField.setText(Double.toString(((org.neuroph.nnet.comp.ThresholdNeuron)neuron).getThresh()));
/*     */     }
/*  44 */     this.weightFuncField.setText(neuron.getInputFunction().getWeightsFunction().getClass().getName());
/*  45 */     this.sumFuncField.setText(neuron.getInputFunction().getSummingFunction().getClass().getName());
/*  46 */     this.transFuncField.setText(neuron.getTransferFunction().getClass().getName());
/*     */     
/*  48 */     String weightsText = new String();
/*  49 */     for (org.neuroph.core.Weight weight : neuron.getWeightsVector()) {
/*  50 */       weightsText = weightsText + Double.toString(weight.getValue()) + "\n";
/*     */     }
/*     */     
/*  53 */     this.weightsField.setText(weightsText);
/*     */     
/*  55 */     String neuronLabel = ((org.neuroph.util.plugins.LabelsPlugin)neuron.getParentLayer().getParentNetwork().getPlugin("LabelsPlugin")).getLabel(neuron);
/*  56 */     this.labelField.setText(neuronLabel);
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
/*     */   private void initComponents()
/*     */   {
/*  69 */     this.jPanel1 = new javax.swing.JPanel();
/*  70 */     this.jLabel1 = new javax.swing.JLabel();
/*  71 */     this.jLabel2 = new javax.swing.JLabel();
/*  72 */     this.jLabel3 = new javax.swing.JLabel();
/*  73 */     this.jLabel4 = new javax.swing.JLabel();
/*  74 */     this.jLabel5 = new javax.swing.JLabel();
/*  75 */     this.inputField = new JTextField();
/*  76 */     this.outputField = new JTextField();
/*  77 */     this.biasField = new JTextField();
/*  78 */     this.weightFuncField = new JTextField();
/*  79 */     this.sumFuncField = new JTextField();
/*  80 */     this.jLabel6 = new javax.swing.JLabel();
/*  81 */     this.transFuncField = new JTextField();
/*  82 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  83 */     this.weightsField = new javax.swing.JTextArea();
/*  84 */     this.jLabel7 = new javax.swing.JLabel();
/*  85 */     this.jLabel8 = new javax.swing.JLabel();
/*  86 */     this.labelField = new JTextField();
/*  87 */     this.neuronTypeField = new JTextField();
/*  88 */     this.jLabel9 = new javax.swing.JLabel();
/*  89 */     this.jPanel2 = new javax.swing.JPanel();
/*  90 */     this.closeButton = new javax.swing.JButton();
/*     */     
/*  92 */     setClosable(true);
/*  93 */     setIconifiable(true);
/*  94 */     org.jdesktop.application.ResourceMap resourceMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getResourceMap(NeuronPropertiesFrame.class);
/*  95 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  96 */     setName("Form");
/*     */     
/*  98 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  99 */     this.jPanel1.setName("jPanel1");
/* 100 */     this.jPanel1.setLayout(new java.awt.GridBagLayout());
/*     */     
/* 102 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 103 */     this.jLabel1.setName("jLabel1");
/* 104 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/* 105 */     gridBagConstraints.anchor = 17;
/* 106 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 107 */     this.jPanel1.add(this.jLabel1, gridBagConstraints);
/*     */     
/* 109 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 110 */     this.jLabel2.setName("jLabel2");
/* 111 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 112 */     gridBagConstraints.gridx = 0;
/* 113 */     gridBagConstraints.gridy = 1;
/* 114 */     gridBagConstraints.anchor = 17;
/* 115 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 116 */     this.jPanel1.add(this.jLabel2, gridBagConstraints);
/*     */     
/* 118 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 119 */     this.jLabel3.setName("jLabel3");
/* 120 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 121 */     gridBagConstraints.gridx = 0;
/* 122 */     gridBagConstraints.gridy = 7;
/* 123 */     gridBagConstraints.anchor = 17;
/* 124 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 125 */     this.jPanel1.add(this.jLabel3, gridBagConstraints);
/*     */     
/* 127 */     this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
/* 128 */     this.jLabel4.setName("jLabel4");
/* 129 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 130 */     gridBagConstraints.gridx = 0;
/* 131 */     gridBagConstraints.gridy = 4;
/* 132 */     gridBagConstraints.anchor = 17;
/* 133 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 134 */     this.jPanel1.add(this.jLabel4, gridBagConstraints);
/*     */     
/* 136 */     this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
/* 137 */     this.jLabel5.setName("jLabel5");
/* 138 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 139 */     gridBagConstraints.gridx = 0;
/* 140 */     gridBagConstraints.gridy = 5;
/* 141 */     gridBagConstraints.anchor = 17;
/* 142 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 143 */     this.jPanel1.add(this.jLabel5, gridBagConstraints);
/*     */     
/* 145 */     this.inputField.setBackground(resourceMap.getColor("inputField.background"));
/* 146 */     this.inputField.setColumns(25);
/* 147 */     this.inputField.setEditable(false);
/* 148 */     this.inputField.setName("inputField");
/* 149 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 150 */     gridBagConstraints.fill = 2;
/* 151 */     gridBagConstraints.anchor = 17;
/* 152 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 153 */     this.jPanel1.add(this.inputField, gridBagConstraints);
/*     */     
/* 155 */     this.outputField.setBackground(resourceMap.getColor("outputField.background"));
/* 156 */     this.outputField.setColumns(25);
/* 157 */     this.outputField.setEditable(false);
/* 158 */     this.outputField.setName("outputField");
/* 159 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 160 */     gridBagConstraints.gridx = 1;
/* 161 */     gridBagConstraints.gridy = 1;
/* 162 */     gridBagConstraints.fill = 2;
/* 163 */     gridBagConstraints.anchor = 17;
/* 164 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 165 */     this.jPanel1.add(this.outputField, gridBagConstraints);
/*     */     
/* 167 */     this.biasField.setBackground(resourceMap.getColor("biasField.background"));
/* 168 */     this.biasField.setColumns(25);
/* 169 */     this.biasField.setEditable(false);
/* 170 */     this.biasField.setName("biasField");
/* 171 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 172 */     gridBagConstraints.gridx = 1;
/* 173 */     gridBagConstraints.gridy = 7;
/* 174 */     gridBagConstraints.fill = 2;
/* 175 */     gridBagConstraints.anchor = 17;
/* 176 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 177 */     this.jPanel1.add(this.biasField, gridBagConstraints);
/*     */     
/* 179 */     this.weightFuncField.setBackground(resourceMap.getColor("weightFuncField.background"));
/* 180 */     this.weightFuncField.setColumns(25);
/* 181 */     this.weightFuncField.setEditable(false);
/* 182 */     this.weightFuncField.setName("weightFuncField");
/* 183 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 184 */     gridBagConstraints.gridx = 1;
/* 185 */     gridBagConstraints.gridy = 4;
/* 186 */     gridBagConstraints.fill = 2;
/* 187 */     gridBagConstraints.anchor = 17;
/* 188 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 189 */     this.jPanel1.add(this.weightFuncField, gridBagConstraints);
/*     */     
/* 191 */     this.sumFuncField.setBackground(resourceMap.getColor("sumFuncField.background"));
/* 192 */     this.sumFuncField.setColumns(25);
/* 193 */     this.sumFuncField.setEditable(false);
/* 194 */     this.sumFuncField.setName("sumFuncField");
/* 195 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 196 */     gridBagConstraints.gridx = 1;
/* 197 */     gridBagConstraints.gridy = 5;
/* 198 */     gridBagConstraints.fill = 2;
/* 199 */     gridBagConstraints.anchor = 17;
/* 200 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 201 */     this.jPanel1.add(this.sumFuncField, gridBagConstraints);
/*     */     
/* 203 */     this.jLabel6.setText(resourceMap.getString("jLabel6.text", new Object[0]));
/* 204 */     this.jLabel6.setName("jLabel6");
/* 205 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 206 */     gridBagConstraints.gridx = 0;
/* 207 */     gridBagConstraints.gridy = 6;
/* 208 */     gridBagConstraints.anchor = 17;
/* 209 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 210 */     this.jPanel1.add(this.jLabel6, gridBagConstraints);
/*     */     
/* 212 */     this.transFuncField.setBackground(resourceMap.getColor("transFuncField.background"));
/* 213 */     this.transFuncField.setColumns(25);
/* 214 */     this.transFuncField.setEditable(false);
/* 215 */     this.transFuncField.setName("transFuncField");
/* 216 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 217 */     gridBagConstraints.gridx = 1;
/* 218 */     gridBagConstraints.gridy = 6;
/* 219 */     gridBagConstraints.fill = 2;
/* 220 */     gridBagConstraints.anchor = 17;
/* 221 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 222 */     this.jPanel1.add(this.transFuncField, gridBagConstraints);
/*     */     
/* 224 */     this.jScrollPane1.setName("jScrollPane1");
/*     */     
/* 226 */     this.weightsField.setBackground(resourceMap.getColor("weightsField.background"));
/* 227 */     this.weightsField.setColumns(25);
/* 228 */     this.weightsField.setEditable(false);
/* 229 */     this.weightsField.setRows(7);
/* 230 */     this.weightsField.setName("weightsField");
/* 231 */     this.jScrollPane1.setViewportView(this.weightsField);
/*     */     
/* 233 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 234 */     gridBagConstraints.gridx = 1;
/* 235 */     gridBagConstraints.gridy = 8;
/* 236 */     gridBagConstraints.fill = 1;
/* 237 */     gridBagConstraints.anchor = 17;
/* 238 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 239 */     this.jPanel1.add(this.jScrollPane1, gridBagConstraints);
/*     */     
/* 241 */     this.jLabel7.setText(resourceMap.getString("jLabel7.text", new Object[0]));
/* 242 */     this.jLabel7.setName("jLabel7");
/* 243 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 244 */     gridBagConstraints.gridx = 0;
/* 245 */     gridBagConstraints.gridy = 8;
/* 246 */     gridBagConstraints.anchor = 17;
/* 247 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 248 */     this.jPanel1.add(this.jLabel7, gridBagConstraints);
/*     */     
/* 250 */     this.jLabel8.setText(resourceMap.getString("jLabel8.text", new Object[0]));
/* 251 */     this.jLabel8.setName("jLabel8");
/* 252 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 253 */     gridBagConstraints.gridx = 0;
/* 254 */     gridBagConstraints.gridy = 2;
/* 255 */     gridBagConstraints.anchor = 17;
/* 256 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 257 */     this.jPanel1.add(this.jLabel8, gridBagConstraints);
/*     */     
/* 259 */     this.labelField.setBackground(resourceMap.getColor("labelField.background"));
/* 260 */     this.labelField.setColumns(25);
/* 261 */     this.labelField.setEditable(false);
/* 262 */     this.labelField.setName("labelField");
/* 263 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 264 */     gridBagConstraints.gridx = 1;
/* 265 */     gridBagConstraints.gridy = 2;
/* 266 */     gridBagConstraints.fill = 2;
/* 267 */     gridBagConstraints.anchor = 17;
/* 268 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 269 */     this.jPanel1.add(this.labelField, gridBagConstraints);
/*     */     
/* 271 */     this.neuronTypeField.setName("neuronTypeField");
/* 272 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 273 */     gridBagConstraints.gridx = 1;
/* 274 */     gridBagConstraints.gridy = 3;
/* 275 */     gridBagConstraints.fill = 2;
/* 276 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 277 */     this.jPanel1.add(this.neuronTypeField, gridBagConstraints);
/*     */     
/* 279 */     this.jLabel9.setText(resourceMap.getString("jLabel9.text", new Object[0]));
/* 280 */     this.jLabel9.setName("jLabel9");
/* 281 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 282 */     gridBagConstraints.gridx = 0;
/* 283 */     gridBagConstraints.gridy = 3;
/* 284 */     gridBagConstraints.anchor = 17;
/* 285 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/* 286 */     this.jPanel1.add(this.jLabel9, gridBagConstraints);
/*     */     
/* 288 */     this.jPanel2.setName("jPanel2");
/*     */     
/* 290 */     javax.swing.ActionMap actionMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getActionMap(NeuronPropertiesFrame.class, this);
/* 291 */     this.closeButton.setAction(actionMap.get("close"));
/* 292 */     this.closeButton.setName("closeButton");
/* 293 */     this.jPanel2.add(this.closeButton);
/*     */     
/* 295 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 296 */     getContentPane().setLayout(layout);
/* 297 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 323, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 5, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel2, -2, 304, -2))).addGap(0, 4, 32767))));
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
/* 310 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 423, 32767).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 2, 32767).addComponent(this.jPanel1, -2, 386, -2).addComponent(this.jPanel2, -2, -1, -2).addGap(0, 2, 32767))));
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
/* 321 */     pack();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void close() {
/* 326 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\NeuronPropertiesFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */