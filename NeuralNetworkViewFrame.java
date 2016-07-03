/*     */ package org.neuroph.easyneurons;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.util.Iterator;
/*     */ import java.util.Observable;
/*     */ import java.util.Observer;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ActionMap;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JInternalFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JViewport;
/*     */ import org.jdesktop.application.Action;
/*     */ import org.jdesktop.application.Application;
/*     */ import org.jdesktop.application.ApplicationContext;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import org.neuroph.core.NeuralNetwork;
/*     */ import org.neuroph.core.learning.TrainingSet;
/*     */ import org.neuroph.easyneurons.dialog.BackpropagationTrainingDialog;
/*     */ import org.neuroph.easyneurons.dialog.HebbianTrainingDialog;
/*     */ import org.neuroph.easyneurons.dialog.SetNetworkInputDialog;
/*     */ import org.neuroph.easyneurons.dialog.SupervisedTrainingDialog;
/*     */ import org.neuroph.easyneurons.view.JNeuralNetwork;
/*     */ 
/*     */ public class NeuralNetworkViewFrame extends JInternalFrame implements Observer
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private NeuralNetwork neuralNetwork;
/*     */   private Vector<TrainingSet> trainingSets;
/*  37 */   private JNeuralNetwork blockView = new JNeuralNetwork();
/*     */   private NeuralGraphRenderer neuralGraphRenderer;
/*     */   private JPanel graphView;
/*     */   private NeuralNetworkTraining trainingController;
/*  41 */   private boolean graphViewActive = false;
/*     */   private String filePath;
/*     */   private EasyNeuronsApplicationView mainFrame;
/*     */   public static final int BLOCK_VIEW = 1;
/*     */   public static final int GRAPH_VIEW = 2;
/*     */   private JPanel buttonPanel;
/*     */   private JButton calculateButton;
/*     */   
/*     */   public NeuralNetworkViewFrame(NeuralNetwork neuralNetwork, Vector<TrainingSet> trainingSets) {
/*  50 */     this.neuralNetwork = neuralNetwork;
/*  51 */     this.trainingSets = trainingSets;
/*  52 */     this.mainFrame = EasyNeuronsApplicationView.getInstance();
/*  53 */     this.trainingController = new NeuralNetworkTraining(this.neuralNetwork);
/*  54 */     neuralNetwork.addObserver(this);
/*     */     
/*  56 */     initComponents();
/*     */     
/*  58 */     this.blockView.setNetwork(neuralNetwork);
/*  59 */     this.scrollPanel.getViewport().add(this.blockView);
/*     */     
/*     */ 
/*  62 */     setTitle(neuralNetwork.toString());
/*     */     
/*  64 */     Iterator<TrainingSet> iterator = trainingSets.iterator();
/*  65 */     while (iterator.hasNext()) {
/*  66 */       TrainingSet ts = (TrainingSet)iterator.next();
/*  67 */       this.trainingSetsComboBox.addItem(ts);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private JLabel jLabel1;
/*     */   
/*     */   private JButton randomizeButton;
/*     */   private JButton resetButton;
/*     */   private JScrollPane scrollPanel;
/*     */   private JButton setInputButton;
/*     */   private JButton trainButton;
/*     */   private JComboBox trainingSetsComboBox;
/*     */   private void initComponents()
/*     */   {
/*  82 */     this.scrollPanel = new JScrollPane();
/*  83 */     this.buttonPanel = new JPanel();
/*  84 */     this.jLabel1 = new JLabel();
/*  85 */     this.trainingSetsComboBox = new JComboBox();
/*  86 */     this.trainButton = new JButton();
/*  87 */     this.setInputButton = new JButton();
/*  88 */     this.calculateButton = new JButton();
/*  89 */     this.randomizeButton = new JButton();
/*  90 */     this.resetButton = new JButton();
/*     */     
/*  92 */     setClosable(true);
/*  93 */     setIconifiable(true);
/*  94 */     setMaximizable(true);
/*  95 */     ResourceMap resourceMap = ((EasyNeuronsApplication)Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(NeuralNetworkViewFrame.class);
/*  96 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  97 */     setAutoscrolls(true);
/*  98 */     setDoubleBuffered(true);
/*  99 */     setMaximumSize(null);
/* 100 */     setName("Form");
/* 101 */     setNormalBounds(null);
/*     */     
/* 103 */     this.scrollPanel.setName("scrollPanel");
/* 104 */     this.scrollPanel.setPreferredSize(new Dimension(700, 600));
/* 105 */     getContentPane().add(this.scrollPanel, "Center");
/*     */     
/* 107 */     this.buttonPanel.setName("buttonPanel");
/* 108 */     this.buttonPanel.setLayout(new AbsoluteLayout());
/*     */     
/* 110 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 111 */     this.jLabel1.setName("jLabel1");
/* 112 */     this.buttonPanel.add(this.jLabel1, new AbsoluteConstraints(10, 4, 70, -1));
/*     */     
/* 114 */     this.trainingSetsComboBox.setName("trainingSetsComboBox");
/* 115 */     this.trainingSetsComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 117 */         NeuralNetworkViewFrame.this.trainingSetsComboBoxFocusGained(evt);
/*     */       }
/* 119 */     });
/* 120 */     this.buttonPanel.add(this.trainingSetsComboBox, new AbsoluteConstraints(70, 0, 140, 23));
/*     */     
/* 122 */     ActionMap actionMap = ((EasyNeuronsApplication)Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(NeuralNetworkViewFrame.class, this);
/* 123 */     this.trainButton.setAction(actionMap.get("train"));
/* 124 */     this.trainButton.setFont(resourceMap.getFont("trainButton.font"));
/* 125 */     this.trainButton.setText(resourceMap.getString("trainButton.text", new Object[0]));
/* 126 */     this.trainButton.setName("trainButton");
/* 127 */     this.buttonPanel.add(this.trainButton, new AbsoluteConstraints(210, 0, -1, -1));
/*     */     
/* 129 */     this.setInputButton.setAction(actionMap.get("setInput"));
/* 130 */     this.setInputButton.setFont(resourceMap.getFont("setInputButton.font"));
/* 131 */     this.setInputButton.setName("setInputButton");
/* 132 */     this.buttonPanel.add(this.setInputButton, new AbsoluteConstraints(280, 0, 100, -1));
/*     */     
/* 134 */     this.calculateButton.setAction(actionMap.get("calculate"));
/* 135 */     this.calculateButton.setFont(resourceMap.getFont("calculateButton.font"));
/* 136 */     this.calculateButton.setText(resourceMap.getString("calculateButton.text", new Object[0]));
/* 137 */     this.calculateButton.setName("calculateButton");
/* 138 */     this.buttonPanel.add(this.calculateButton, new AbsoluteConstraints(380, 0, -1, -1));
/*     */     
/* 140 */     this.randomizeButton.setAction(actionMap.get("randomize"));
/* 141 */     this.randomizeButton.setFont(resourceMap.getFont("randomizeButton.font"));
/* 142 */     this.randomizeButton.setText(resourceMap.getString("randomizeButton.text", new Object[0]));
/* 143 */     this.randomizeButton.setName("randomizeButton");
/* 144 */     this.buttonPanel.add(this.randomizeButton, new AbsoluteConstraints(530, 0, -1, -1));
/*     */     
/* 146 */     this.resetButton.setAction(actionMap.get("reset"));
/* 147 */     this.resetButton.setFont(resourceMap.getFont("resetButton.font"));
/* 148 */     this.resetButton.setName("resetButton");
/* 149 */     this.buttonPanel.add(this.resetButton, new AbsoluteConstraints(470, 0, -1, -1));
/*     */     
/* 151 */     getContentPane().add(this.buttonPanel, "North");
/*     */     
/* 153 */     pack();
/*     */   }
/*     */   
/*     */   private void trainingSetsComboBoxFocusGained(FocusEvent evt) {
/* 157 */     this.trainingSetsComboBox.removeAllItems();
/* 158 */     Iterator<TrainingSet> iterator = this.trainingSets.iterator();
/* 159 */     while (iterator.hasNext()) {
/* 160 */       TrainingSet ts = (TrainingSet)iterator.next();
/* 161 */       this.trainingSetsComboBox.addItem(ts);
/*     */     }
/*     */   }
/*     */   
/*     */   @Action
/*     */   public void train() {
/* 167 */     TrainingSet trainingSet = (TrainingSet)this.trainingSetsComboBox.getSelectedItem();
/*     */     
/* 169 */     this.trainingController.setTrainingSet(trainingSet);
/*     */     
/* 171 */     org.neuroph.util.NeuralNetworkType nnetType = this.neuralNetwork.getNetworkType();
/*     */     
/*     */ 
/* 174 */     switch (nnetType) {
/*     */     case ADALINE: 
/* 176 */       showLmsTrainingDialog();
/* 177 */       break;
/*     */     case PERCEPTRON: 
/* 179 */       showLmsTrainingDialog();
/* 180 */       break;
/*     */     case MULTI_LAYER_PERCEPTRON: 
/* 182 */       showMLPTrainingDialog();
/* 183 */       break;
/*     */     case RBF_NETWORK: 
/* 185 */       showLmsTrainingDialog();
/* 186 */       break;
/*     */     case HOPFIELD: 
/* 188 */       this.trainingController.train();
/* 189 */       break;
/*     */     case KOHONEN: 
/*     */       break;
/*     */     case NEURO_FUZZY_REASONER: 
/* 193 */       showLmsTrainingDialog();
/* 194 */       break;
/*     */     case SUPERVISED_HEBBIAN_NET: 
/* 196 */       showHebbianTrainingDialog();
/* 197 */       break;
/*     */     
/*     */     default: 
/* 200 */       this.trainingController.train();
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   private void showLmsTrainingDialog()
/*     */   {
/* 207 */     SupervisedTrainingDialog trainingDialog = new SupervisedTrainingDialog(null, this.mainFrame, true, this.trainingController);
/*     */     
/* 209 */     trainingDialog.setLocationRelativeTo(this);
/* 210 */     trainingDialog.setVisible(true);
/*     */   }
/*     */   
/*     */   private void showMLPTrainingDialog() {
/* 214 */     if ((this.trainingController.getNetwork().getLearningRule() instanceof org.neuroph.nnet.learning.DynamicBackPropagation)) {
/* 215 */       BackpropagationTrainingDialog trainingDialog = new BackpropagationTrainingDialog(null, this.mainFrame, true, this.trainingController);
/*     */       
/* 217 */       trainingDialog.setLocationRelativeTo(this);
/* 218 */       trainingDialog.setVisible(true);
/*     */     } else {
/* 220 */       showLmsTrainingDialog();
/*     */     }
/*     */   }
/*     */   
/*     */   private void showHebbianTrainingDialog() {
/* 225 */     HebbianTrainingDialog trainingDialog = new HebbianTrainingDialog(null, true, this.mainFrame, this.trainingController);
/*     */     
/* 227 */     trainingDialog.setLocationRelativeTo(this);
/* 228 */     trainingDialog.setVisible(true);
/*     */   }
/*     */   
/*     */   @Action
/*     */   public void calculateNetwork() {
/* 233 */     this.neuralNetwork.calculate();
/*     */   }
/*     */   
/*     */   @Action
/*     */   public void setInput() {
/* 238 */     SetNetworkInputDialog dialog = new SetNetworkInputDialog(null, true, this.trainingController);
/*     */     
/* 240 */     dialog.setLocationRelativeTo(this);
/* 241 */     dialog.setVisible(true);
/*     */   }
/*     */   
/*     */   @Action
/*     */   public void calculate() {
/* 246 */     this.trainingController.calculate();
/*     */   }
/*     */   
/*     */   public NeuralNetworkTraining getController() {
/* 250 */     return this.trainingController;
/*     */   }
/*     */   
/*     */   @Action
/*     */   public void randomize() {
/* 255 */     this.trainingController.randomize();
/*     */   }
/*     */   
/*     */   @Action
/*     */   public void reset() {
/* 260 */     this.trainingController.reset();
/*     */   }
/*     */   
/*     */   public void switchToView(int view) {
/* 264 */     if (view == 2)
/*     */     {
/* 266 */       this.scrollPanel.getViewport().remove(this.blockView);
/* 267 */       this.blockView = null;
/*     */       try {
/* 269 */         this.neuralGraphRenderer = new NeuralGraphRenderer(this.neuralNetwork);
/* 270 */         this.graphView = this.neuralGraphRenderer.getGraphPanel();
/*     */       }
/*     */       catch (Exception ex) {}
/*     */       
/* 274 */       getContentPane().remove(this.scrollPanel);
/* 275 */       getContentPane().add(this.graphView);
/* 276 */       this.graphViewActive = true;
/*     */     }
/* 278 */     else if (view == 1) {
/* 279 */       this.neuralGraphRenderer = null;
/* 280 */       getContentPane().remove(this.graphView);
/*     */       
/* 282 */       this.blockView = new JNeuralNetwork();
/* 283 */       this.blockView.setNetwork(this.neuralNetwork);
/* 284 */       this.scrollPanel.getViewport().add(this.blockView);
/*     */       
/* 286 */       getContentPane().add(this.scrollPanel);
/* 287 */       this.graphViewActive = false;
/*     */     }
/*     */     
/* 290 */     refresh();
/* 291 */     repaint();
/*     */   }
/*     */   
/*     */   public void update(Observable o, Object arg)
/*     */   {
/* 296 */     if (this.graphViewActive) {
/* 297 */       this.graphView = this.neuralGraphRenderer.getGraphPanel();
/* 298 */       this.graphView.revalidate();
/* 299 */       this.graphView.repaint();
/*     */     } else {
/* 301 */       this.blockView.update();
/*     */     }
/*     */   }
/*     */   
/*     */   public void refresh()
/*     */   {
/* 307 */     if (this.graphViewActive) {
/* 308 */       getContentPane().remove(this.graphView);
/* 309 */       this.graphView = null;
/* 310 */       this.graphView = this.neuralGraphRenderer.getGraphPanel();
/* 311 */       getContentPane().add(this.graphView);
/* 312 */       this.graphView.revalidate();
/* 313 */       this.graphView.repaint();
/*     */     } else {
/* 315 */       this.blockView.update();
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateTitle()
/*     */   {
/* 321 */     setTitle(this.neuralNetwork.toString());
/*     */   }
/*     */   
/*     */   public String getFilePath() {
/* 325 */     return this.filePath;
/*     */   }
/*     */   
/*     */   public void setFilePath(String filePath) {
/* 329 */     this.filePath = filePath;
/*     */   }
/*     */   
/*     */   public NeuralNetwork getNeuralNetwork() {
/* 333 */     return this.neuralNetwork;
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\NeuralNetworkViewFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */