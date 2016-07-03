/*      */ package org.neuroph.easyneurons;
/*      */ 
/*      */ import java.awt.Dimension;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.beans.PropertyChangeEvent;
/*      */ import java.beans.PropertyVetoException;
/*      */ import java.io.File;
/*      */ import java.util.Observable;
/*      */ import java.util.Vector;
/*      */ import javax.help.HelpSet;
/*      */ import javax.swing.ActionMap;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JDesktopPane;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JInternalFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JMenu;
/*      */ import javax.swing.JMenuBar;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JPopupMenu;
/*      */ import javax.swing.JProgressBar;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JSplitPane;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JToolBar;
/*      */ import javax.swing.JTree;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ import javax.swing.Timer;
/*      */ import javax.swing.event.InternalFrameEvent;
/*      */ import javax.swing.event.TreeModelEvent;
/*      */ import javax.swing.filechooser.FileFilter;
/*      */ import javax.swing.tree.DefaultMutableTreeNode;
/*      */ import javax.swing.tree.DefaultTreeCellRenderer;
/*      */ import javax.swing.tree.TreePath;
/*      */ import org.jdesktop.application.Action;
/*      */ import org.jdesktop.application.Application;
/*      */ import org.jdesktop.application.ApplicationContext;
/*      */ import org.jdesktop.application.FrameView;
/*      */ import org.jdesktop.application.ResourceMap;
/*      */ import org.jdesktop.application.TaskMonitor;
/*      */ import org.neuroph.contrib.RecommenderNetwork;
/*      */ import org.neuroph.core.Layer;
/*      */ import org.neuroph.core.NeuralNetwork;
/*      */ import org.neuroph.core.Neuron;
/*      */ import org.neuroph.core.learning.LearningRule;
/*      */ import org.neuroph.core.learning.SupervisedTrainingElement;
/*      */ import org.neuroph.core.learning.TrainingElement;
/*      */ import org.neuroph.core.learning.TrainingSet;
/*      */ import org.neuroph.core.transfer.Trapezoid;
/*      */ import org.neuroph.easyneurons.dialog.AdalineWizard;
/*      */ import org.neuroph.easyneurons.dialog.BamWizard;
/*      */ import org.neuroph.easyneurons.dialog.CompetitiveNetworkWizard;
/*      */ import org.neuroph.easyneurons.dialog.MaxnetWizard;
/*      */ import org.neuroph.easyneurons.dialog.MultiLayerPerceptronWizard;
/*      */ import org.neuroph.easyneurons.dialog.NeuronPropertiesFrame;
/*      */ import org.neuroph.easyneurons.dialog.PerceptronWizard;
/*      */ import org.neuroph.easyneurons.dialog.RbfWizard;
/*      */ import org.neuroph.easyneurons.dialog.RenameNodeDialog;
/*      */ import org.neuroph.easyneurons.dialog.SupervisedHebbianWizard;
/*      */ import org.neuroph.easyneurons.dialog.SupervisedTrainingMonitorFrame;
/*      */ import org.neuroph.easyneurons.dialog.TrainingSetWizard;
/*      */ import org.neuroph.easyneurons.dialog.UnsupervisedHebbianWizard;
/*      */ import org.neuroph.easyneurons.errorgraph.GraphFrame;
/*      */ import org.neuroph.easyneurons.file.FileFilterAdapter.NeuralNetworkBinaryFileFilter;
/*      */ import org.neuroph.easyneurons.file.FileFilterAdapter.NeuralNetworkXmlFileFilter;
/*      */ import org.neuroph.easyneurons.file.FileFilterAdapter.TrainingSetBinaryFileFilter;
/*      */ import org.neuroph.easyneurons.file.FileFilterAdapter.TrainingSetXmlFileFilter;
/*      */ import org.neuroph.easyneurons.file.FileIO;
/*      */ import org.neuroph.easyneurons.file.FileObserver;
/*      */ import org.neuroph.easyneurons.file.FileUtils;
/*      */ import org.neuroph.easyneurons.file.WindowObserver;
/*      */ import org.neuroph.easyneurons.imgrec.ImageRecognitionFrame;
/*      */ import org.neuroph.easyneurons.samples.BasicNeuronSample;
/*      */ import org.neuroph.easyneurons.samples.KohonenSample;
/*      */ import org.neuroph.easyneurons.samples.NFRSample;
/*      */ import org.neuroph.easyneurons.samples.backpropagation.BackpropagationSample;
/*      */ import org.neuroph.easyneurons.samples.backpropagation.MarkovNeuralNet;
/*      */ import org.neuroph.easyneurons.samples.perceptron.PerceptronSampleFrame;
/*      */ import org.neuroph.easyneurons.samples.perceptron.PerceptronSampleTrainingSet;
/*      */ import org.neuroph.easyneurons.samples.perceptron.TrainingSetObserver;
/*      */ import org.neuroph.nnet.Kohonen;
/*      */ import org.neuroph.nnet.MultiLayerPerceptron;
/*      */ import org.neuroph.nnet.Perceptron;
/*      */ import org.neuroph.util.NeuralNetworkFactory;
/*      */ import org.neuroph.util.TransferFunctionType;
/*      */ import org.neuroph.util.plugins.LabelsPlugin;
/*      */ 
/*      */ public class EasyNeuronsApplicationView extends FrameView implements java.io.Serializable
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*  102 */   int counter = 0;
/*      */   
/*      */   public static EasyNeuronsApplicationView myInstance;
/*      */   private EasyNeuronsProject easyNeuronsProject;
/*  106 */   private NeuralNetworkViewFrame netActiveWindow = null;
/*  107 */   private TrainingSet traActiveWindow = null;
/*  108 */   private FileObserver fileObserver = new FileObserver();
/*  109 */   private JFileChooser fileChooser = new JFileChooser();
/*  110 */   private JFrame mainFrame = EasyNeuronsApplication.getApplication().getMainFrame();
/*      */   private JMenuItem adalineMenuItem;
/*      */   private JMenuItem bamMenuItem;
/*      */   
/*  114 */   public EasyNeuronsApplicationView(org.jdesktop.application.SingleFrameApplication app) { super(app);
/*      */     
/*  116 */     initComponents();
/*      */     
/*      */ 
/*      */ 
/*  120 */     ResourceMap resourceMap = getResourceMap();
/*  121 */     int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout").intValue();
/*  122 */     this.messageTimer = new Timer(messageTimeout, new ActionListener() {
/*      */       public void actionPerformed(ActionEvent e) {
/*  124 */         EasyNeuronsApplicationView.this.statusMessageLabel.setText("");
/*      */       }
/*  126 */     });
/*  127 */     this.messageTimer.setRepeats(false);
/*  128 */     int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate").intValue();
/*      */     
/*  130 */     for (int i = 0; i < this.busyIcons.length; i++) {
/*  131 */       this.busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
/*      */     }
/*      */     
/*  134 */     this.busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
/*      */       public void actionPerformed(ActionEvent e) {
/*  136 */         EasyNeuronsApplicationView.this.busyIconIndex = ((EasyNeuronsApplicationView.this.busyIconIndex + 1) % EasyNeuronsApplicationView.this.busyIcons.length);
/*  137 */         EasyNeuronsApplicationView.this.statusAnimationLabel.setIcon(EasyNeuronsApplicationView.this.busyIcons[EasyNeuronsApplicationView.this.busyIconIndex]);
/*      */       }
/*  139 */     });
/*  140 */     this.idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
/*  141 */     this.statusAnimationLabel.setIcon(this.idleIcon);
/*  142 */     this.progressBar.setVisible(false);
/*      */     
/*      */ 
/*  145 */     TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
/*  146 */     taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener()
/*      */     {
/*      */       public void propertyChange(PropertyChangeEvent evt)
/*      */       {
/*  150 */         String propertyName = evt.getPropertyName();
/*  151 */         if ("started".equals(propertyName)) {
/*  152 */           if (!EasyNeuronsApplicationView.this.busyIconTimer.isRunning()) {
/*  153 */             EasyNeuronsApplicationView.this.statusAnimationLabel.setIcon(EasyNeuronsApplicationView.this.busyIcons[0]);
/*  154 */             EasyNeuronsApplicationView.this.busyIconIndex = 0;
/*  155 */             EasyNeuronsApplicationView.this.busyIconTimer.start();
/*      */           }
/*  157 */           EasyNeuronsApplicationView.this.progressBar.setVisible(true);
/*  158 */           EasyNeuronsApplicationView.this.progressBar.setIndeterminate(true);
/*  159 */         } else if ("done".equals(propertyName)) {
/*  160 */           EasyNeuronsApplicationView.this.busyIconTimer.stop();
/*  161 */           EasyNeuronsApplicationView.this.statusAnimationLabel.setIcon(EasyNeuronsApplicationView.this.idleIcon);
/*  162 */           EasyNeuronsApplicationView.this.progressBar.setVisible(false);
/*  163 */           EasyNeuronsApplicationView.this.progressBar.setValue(0);
/*  164 */         } else if ("message".equals(propertyName)) {
/*  165 */           String text = (String)evt.getNewValue();
/*  166 */           EasyNeuronsApplicationView.this.statusMessageLabel.setText(text == null ? "" : text);
/*      */           
/*  168 */           EasyNeuronsApplicationView.this.messageTimer.restart();
/*  169 */         } else if ("progress".equals(propertyName)) {
/*  170 */           int value = ((Integer)evt.getNewValue()).intValue();
/*  171 */           EasyNeuronsApplicationView.this.progressBar.setVisible(true);
/*  172 */           EasyNeuronsApplicationView.this.progressBar.setIndeterminate(false);
/*  173 */           EasyNeuronsApplicationView.this.progressBar.setValue(value);
/*      */         }
/*      */         
/*      */       }
/*      */       
/*  178 */     });
/*  179 */     JFrame mainFrame2 = getFrame();
/*  180 */     mainFrame2.setDefaultCloseOperation(3);
/*      */     
/*  182 */     this.easyNeuronsProject = new EasyNeuronsProject();
/*      */     
/*  184 */     java.awt.event.MouseListener ml = new java.awt.event.MouseAdapter()
/*      */     {
/*      */       public void mouseClicked(MouseEvent e) {
/*  187 */         int selRow = EasyNeuronsApplicationView.this.projectTree.getRowForLocation(e.getX(), e.getY());
/*  188 */         TreePath selPath = EasyNeuronsApplicationView.this.projectTree.getPathForLocation(e.getX(), e.getY());
/*      */         
/*  190 */         if ((selRow != -1) && 
/*  191 */           (e.getClickCount() == 2)) {
/*  192 */           EasyNeuronsApplicationView.this.treeNodeDoubleClick(selRow, selPath);
/*      */         }
/*      */         
/*      */       }
/*      */       
/*      */ 
/*  198 */     };
/*  199 */     this.projectTree.addMouseListener(ml);
/*      */     
/*  201 */     DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
/*      */     
/*      */ 
/*  204 */     renderer.setLeafIcon(null);
/*  205 */     this.projectTree.setCellRenderer(renderer);
/*      */     
/*  207 */     updateProjectTree();
/*      */     
/*  209 */     this.desktopPanel.setDragMode(1);
/*  210 */     myInstance = this;
/*      */   }
/*      */   
/*      */   private JMenuItem competitiveMenuItem;
/*      */   private JDesktopPane desktopPanel;
/*      */   private JMenu editMenu;
/*      */   private JMenuItem hopfieldMenuItem;
/*      */   private JMenuItem imageRecognitionMenuItem;
/*      */   private JMenuItem instarMenuItem;
/*  219 */   private void initComponents() { this.mainPanel = new JPanel();
/*  220 */     this.jToolBar1 = new JToolBar();
/*  221 */     this.openButton = new JButton();
/*  222 */     this.saveButton = new JButton();
/*  223 */     this.newTrainingSetButton = new JButton();
/*  224 */     this.jSplitPane1 = new JSplitPane();
/*  225 */     this.projectTreeScrollPane = new JScrollPane();
/*  226 */     this.projectTree = new JTree();
/*  227 */     this.jSplitPane2 = new JSplitPane();
/*  228 */     this.desktopPanel = new JDesktopPane();
/*  229 */     this.jScrollPane1 = new JScrollPane();
/*  230 */     this.messageBox = new JTextArea();
/*  231 */     this.menuBar = new JMenuBar();
/*  232 */     JMenu fileMenu = new JMenu();
/*  233 */     this.openMenuItem = new JMenuItem();
/*  234 */     this.saveMenuItem = new JMenuItem();
/*  235 */     this.saveAsMenuItem = new JMenuItem();
/*  236 */     JMenuItem exitMenuItem = new JMenuItem();
/*  237 */     this.editMenu = new JMenu();
/*  238 */     this.jMenuItem1 = new JMenuItem();
/*  239 */     this.jMenuItem2 = new JMenuItem();
/*  240 */     this.jMenuItem3 = new JMenuItem();
/*  241 */     this.jMenuItem4 = new JMenuItem();
/*  242 */     this.jMenuItem6 = new JMenuItem();
/*  243 */     this.viewMenu = new JMenu();
/*  244 */     this.viewBlockMenuItem = new JMenuItem();
/*  245 */     this.viewGraphMenuItem = new JMenuItem();
/*  246 */     this.viewRefreshMenuItem = new JMenuItem();
/*  247 */     this.networksMenu = new JMenu();
/*  248 */     this.adalineMenuItem = new JMenuItem();
/*  249 */     this.perceptronMenuItem = new JMenuItem();
/*  250 */     this.mlpMenuItem = new JMenuItem();
/*  251 */     this.hopfieldMenuItem = new JMenuItem();
/*  252 */     this.bamMenuItem = new JMenuItem();
/*  253 */     this.kohonenMenuItem = new JMenuItem();
/*  254 */     this.supervisedHebbianMenuItem = new JMenuItem();
/*  255 */     this.unsupervisedHebbianMenuItem = new JMenuItem();
/*  256 */     this.maxnetMenuItem = new JMenuItem();
/*  257 */     this.competitiveMenuItem = new JMenuItem();
/*  258 */     this.rbfMenuItem = new JMenuItem();
/*  259 */     this.instarMenuItem = new JMenuItem();
/*  260 */     this.outstarMenuItem = new JMenuItem();
/*  261 */     this.jSeparator1 = new JSeparator();
/*  262 */     this.trainingMenu = new JMenu();
/*  263 */     this.trainingSetWizardMenuItem = new JMenuItem();
/*  264 */     this.trainMenuItem = new JMenuItem();
/*  265 */     this.toolsMenu = new JMenu();
/*  266 */     this.imageRecognitionMenuItem = new JMenuItem();
/*  267 */     this.samplesMenu = new JMenu();
/*  268 */     this.sampleBasicNeuron = new JMenuItem();
/*  269 */     this.sampleKohonenMenuItem = new JMenuItem();
/*  270 */     this.sampleNFRMenuItem = new JMenuItem();
/*  271 */     this.sampleRecommenderMenuItem = new JMenuItem();
/*  272 */     this.samplePerceptronMenuItem = new JMenuItem();
/*  273 */     this.sampleBackpropMenuItem = new JMenuItem();
/*  274 */     JMenu helpMenu = new JMenu();
/*  275 */     this.jMenuItem7 = new JMenuItem();
/*  276 */     JMenuItem aboutMenuItem = new JMenuItem();
/*  277 */     this.statusPanel = new JPanel();
/*  278 */     JSeparator statusPanelSeparator = new JSeparator();
/*  279 */     this.statusMessageLabel = new JLabel();
/*  280 */     this.statusAnimationLabel = new JLabel();
/*  281 */     this.progressBar = new JProgressBar();
/*  282 */     this.treePopupMenu = new JPopupMenu();
/*  283 */     this.renameMenuItem = new JMenuItem();
/*  284 */     this.removeMenuItem = new JMenuItem();
/*      */     
/*  286 */     this.mainPanel.setName("mainPanel");
/*  287 */     this.mainPanel.setPreferredSize(new Dimension(900, 600));
/*  288 */     this.mainPanel.setLayout(new java.awt.BorderLayout(2, 2));
/*      */     
/*  290 */     this.jToolBar1.setRollover(true);
/*  291 */     this.jToolBar1.setName("jToolBar1");
/*  292 */     this.jToolBar1.setPreferredSize(new Dimension(154, 33));
/*      */     
/*  294 */     ActionMap actionMap = ((EasyNeuronsApplication)Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(EasyNeuronsApplicationView.class, this);
/*  295 */     this.openButton.setAction(actionMap.get("showOpenDialog"));
/*  296 */     ResourceMap resourceMap = ((EasyNeuronsApplication)Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(EasyNeuronsApplicationView.class);
/*  297 */     this.openButton.setIcon(resourceMap.getIcon("openButton.icon"));
/*  298 */     this.openButton.setText(resourceMap.getString("openButton.text", new Object[0]));
/*  299 */     this.openButton.setToolTipText(resourceMap.getString("openButton.toolTipText", new Object[0]));
/*  300 */     this.openButton.setFocusable(false);
/*  301 */     this.openButton.setHorizontalTextPosition(0);
/*  302 */     this.openButton.setName("openButton");
/*  303 */     this.openButton.setVerticalTextPosition(3);
/*  304 */     this.jToolBar1.add(this.openButton);
/*      */     
/*  306 */     this.saveButton.setAction(actionMap.get("showSaveDialog"));
/*  307 */     this.saveButton.setIcon(resourceMap.getIcon("saveButton.icon"));
/*  308 */     this.saveButton.setText(resourceMap.getString("saveButton.text", new Object[0]));
/*  309 */     this.saveButton.setToolTipText(resourceMap.getString("saveButton.toolTipText", new Object[0]));
/*  310 */     this.saveButton.setFocusable(false);
/*  311 */     this.saveButton.setHorizontalTextPosition(0);
/*  312 */     this.saveButton.setName("saveButton");
/*  313 */     this.saveButton.setVerticalTextPosition(3);
/*  314 */     this.jToolBar1.add(this.saveButton);
/*      */     
/*  316 */     this.newTrainingSetButton.setAction(actionMap.get("showTrainingSetWizard"));
/*  317 */     this.newTrainingSetButton.setIcon(resourceMap.getIcon("newTrainingSetButton.icon"));
/*  318 */     this.newTrainingSetButton.setText(resourceMap.getString("newTrainingSetButton.text", new Object[0]));
/*  319 */     this.newTrainingSetButton.setToolTipText(resourceMap.getString("newTrainingSetButton.toolTipText", new Object[0]));
/*  320 */     this.newTrainingSetButton.setFocusable(false);
/*  321 */     this.newTrainingSetButton.setHorizontalTextPosition(0);
/*  322 */     this.newTrainingSetButton.setName("newTrainingSetButton");
/*  323 */     this.newTrainingSetButton.setVerticalTextPosition(3);
/*  324 */     this.jToolBar1.add(this.newTrainingSetButton);
/*      */     
/*  326 */     this.mainPanel.add(this.jToolBar1, "First");
/*      */     
/*  328 */     this.jSplitPane1.setMaximumSize(null);
/*  329 */     this.jSplitPane1.setName("jSplitPane1");
/*      */     
/*  331 */     this.projectTreeScrollPane.setAlignmentX(1.0F);
/*  332 */     this.projectTreeScrollPane.setAlignmentY(1.0F);
/*  333 */     this.projectTreeScrollPane.setName("projectTreeScrollPane");
/*      */     
/*  335 */     this.projectTree.setAutoscrolls(true);
/*  336 */     this.projectTree.setComponentPopupMenu(this.treePopupMenu);
/*  337 */     this.projectTree.setDragEnabled(true);
/*  338 */     this.projectTree.setMaximumSize(new Dimension(100, 64));
/*  339 */     this.projectTree.setName("projectTree");
/*  340 */     this.projectTree.setPreferredSize(new Dimension(150, 100));
/*  341 */     this.projectTree.setRowHeight(22);
/*  342 */     this.projectTreeScrollPane.setViewportView(this.projectTree);
/*      */     
/*  344 */     this.jSplitPane1.setLeftComponent(this.projectTreeScrollPane);
/*      */     
/*  346 */     this.jSplitPane2.setDividerLocation(590);
/*  347 */     this.jSplitPane2.setOrientation(0);
/*  348 */     this.jSplitPane2.setAutoscrolls(true);
/*  349 */     this.jSplitPane2.setContinuousLayout(true);
/*  350 */     this.jSplitPane2.setMaximumSize(null);
/*  351 */     this.jSplitPane2.setName("jSplitPane2");
/*      */     
/*  353 */     this.desktopPanel.setName("desktopPanel");
/*  354 */     this.jSplitPane2.setLeftComponent(this.desktopPanel);
/*      */     
/*  356 */     this.jScrollPane1.setName("jScrollPane1");
/*      */     
/*  358 */     this.messageBox.setColumns(20);
/*  359 */     this.messageBox.setEditable(false);
/*  360 */     this.messageBox.setFont(resourceMap.getFont("messageBox.font"));
/*  361 */     this.messageBox.setRows(8);
/*  362 */     this.messageBox.setName("messageBox");
/*  363 */     this.jScrollPane1.setViewportView(this.messageBox);
/*      */     
/*  365 */     this.jSplitPane2.setRightComponent(this.jScrollPane1);
/*      */     
/*  367 */     this.jSplitPane1.setRightComponent(this.jSplitPane2);
/*      */     
/*  369 */     this.mainPanel.add(this.jSplitPane1, "Center");
/*      */     
/*  371 */     this.menuBar.setName("menuBar");
/*      */     
/*  373 */     fileMenu.setText(resourceMap.getString("fileMenu.text", new Object[0]));
/*  374 */     fileMenu.setName("fileMenu");
/*      */     
/*  376 */     this.openMenuItem.setAction(actionMap.get("showOpenDialog"));
/*  377 */     this.openMenuItem.setToolTipText(resourceMap.getString("openMenuItem.toolTipText", new Object[0]));
/*  378 */     this.openMenuItem.setName("openMenuItem");
/*  379 */     fileMenu.add(this.openMenuItem);
/*      */     
/*  381 */     this.saveMenuItem.setAction(actionMap.get("showSaveDialog"));
/*  382 */     this.saveMenuItem.setText(resourceMap.getString("saveMenuItem.text", new Object[0]));
/*  383 */     this.saveMenuItem.setToolTipText(resourceMap.getString("saveMenuItem.toolTipText", new Object[0]));
/*  384 */     this.saveMenuItem.setName("saveMenuItem");
/*  385 */     fileMenu.add(this.saveMenuItem);
/*      */     
/*  387 */     this.saveAsMenuItem.setAction(actionMap.get("showSaveAsDialog"));
/*  388 */     this.saveAsMenuItem.setText(resourceMap.getString("saveAsMenuItem.text", new Object[0]));
/*  389 */     this.saveAsMenuItem.setToolTipText(resourceMap.getString("saveAsMenuItem.toolTipText", new Object[0]));
/*  390 */     this.saveAsMenuItem.setName("saveAsMenuItem");
/*  391 */     fileMenu.add(this.saveAsMenuItem);
/*      */     
/*  393 */     exitMenuItem.setAction(actionMap.get("quit"));
/*  394 */     exitMenuItem.setName("exitMenuItem");
/*  395 */     fileMenu.add(exitMenuItem);
/*      */     
/*  397 */     this.menuBar.add(fileMenu);
/*      */     
/*  399 */     this.editMenu.setText(resourceMap.getString("editMenu.text", new Object[0]));
/*  400 */     this.editMenu.setName("editMenu");
/*      */     
/*  402 */     this.jMenuItem1.setText(resourceMap.getString("jMenuItem1.text", new Object[0]));
/*  403 */     this.jMenuItem1.setEnabled(false);
/*  404 */     this.jMenuItem1.setName("jMenuItem1");
/*  405 */     this.editMenu.add(this.jMenuItem1);
/*      */     
/*  407 */     this.jMenuItem2.setText(resourceMap.getString("jMenuItem2.text", new Object[0]));
/*  408 */     this.jMenuItem2.setEnabled(false);
/*  409 */     this.jMenuItem2.setName("jMenuItem2");
/*  410 */     this.editMenu.add(this.jMenuItem2);
/*      */     
/*  412 */     this.jMenuItem3.setText(resourceMap.getString("jMenuItem3.text", new Object[0]));
/*  413 */     this.jMenuItem3.setEnabled(false);
/*  414 */     this.jMenuItem3.setName("jMenuItem3");
/*  415 */     this.editMenu.add(this.jMenuItem3);
/*      */     
/*  417 */     this.jMenuItem4.setText(resourceMap.getString("jMenuItem4.text", new Object[0]));
/*  418 */     this.jMenuItem4.setEnabled(false);
/*  419 */     this.jMenuItem4.setName("jMenuItem4");
/*  420 */     this.editMenu.add(this.jMenuItem4);
/*      */     
/*  422 */     this.jMenuItem6.setText(resourceMap.getString("jMenuItem6.text", new Object[0]));
/*  423 */     this.jMenuItem6.setEnabled(false);
/*  424 */     this.jMenuItem6.setName("jMenuItem6");
/*  425 */     this.editMenu.add(this.jMenuItem6);
/*      */     
/*  427 */     this.menuBar.add(this.editMenu);
/*      */     
/*  429 */     this.viewMenu.setText(resourceMap.getString("viewMenu.text", new Object[0]));
/*  430 */     this.viewMenu.setName("viewMenu");
/*      */     
/*  432 */     this.viewBlockMenuItem.setAction(actionMap.get("switchToBlockView"));
/*  433 */     this.viewBlockMenuItem.setText(resourceMap.getString("viewBlockMenuItem.text", new Object[0]));
/*  434 */     this.viewBlockMenuItem.setName("viewBlockMenuItem");
/*  435 */     this.viewMenu.add(this.viewBlockMenuItem);
/*      */     
/*  437 */     this.viewGraphMenuItem.setAction(actionMap.get("switchToGraphView"));
/*  438 */     this.viewGraphMenuItem.setText(resourceMap.getString("viewGraphMenuItem.text", new Object[0]));
/*  439 */     this.viewGraphMenuItem.setName("viewGraphMenuItem");
/*  440 */     this.viewMenu.add(this.viewGraphMenuItem);
/*      */     
/*  442 */     this.viewRefreshMenuItem.setAction(actionMap.get("refreshView"));
/*  443 */     this.viewRefreshMenuItem.setText(resourceMap.getString("viewRefreshMenuItem.text", new Object[0]));
/*  444 */     this.viewRefreshMenuItem.setName("viewRefreshMenuItem");
/*  445 */     this.viewMenu.add(this.viewRefreshMenuItem);
/*      */     
/*  447 */     this.menuBar.add(this.viewMenu);
/*      */     
/*  449 */     this.networksMenu.setText(resourceMap.getString("networksMenu.text", new Object[0]));
/*  450 */     this.networksMenu.setName("networksMenu");
/*      */     
/*  452 */     this.adalineMenuItem.setAction(actionMap.get("showAdalineWizard"));
/*  453 */     this.adalineMenuItem.setText(resourceMap.getString("adalineMenuItem.text", new Object[0]));
/*  454 */     this.adalineMenuItem.setToolTipText(resourceMap.getString("adalineMenuItem.toolTipText", new Object[0]));
/*  455 */     this.adalineMenuItem.setName("adalineMenuItem");
/*  456 */     this.networksMenu.add(this.adalineMenuItem);
/*      */     
/*  458 */     this.perceptronMenuItem.setAction(actionMap.get("showPerceptronWizard"));
/*  459 */     this.perceptronMenuItem.setText(resourceMap.getString("perceptronMenuItem.text", new Object[0]));
/*  460 */     this.perceptronMenuItem.setToolTipText(resourceMap.getString("perceptronMenuItem.toolTipText", new Object[0]));
/*  461 */     this.perceptronMenuItem.setName("perceptronMenuItem");
/*  462 */     this.networksMenu.add(this.perceptronMenuItem);
/*      */     
/*  464 */     this.mlpMenuItem.setAction(actionMap.get("showMLPerceptronWizard"));
/*  465 */     this.mlpMenuItem.setText(resourceMap.getString("mlpMenuItem.text", new Object[0]));
/*  466 */     this.mlpMenuItem.setToolTipText(resourceMap.getString("mlpMenuItem.toolTipText", new Object[0]));
/*  467 */     this.mlpMenuItem.setName("mlpMenuItem");
/*  468 */     this.networksMenu.add(this.mlpMenuItem);
/*      */     
/*  470 */     this.hopfieldMenuItem.setAction(actionMap.get("showHopfieldWizard"));
/*  471 */     this.hopfieldMenuItem.setText(resourceMap.getString("hopfieldMenuItem.text", new Object[0]));
/*  472 */     this.hopfieldMenuItem.setToolTipText(resourceMap.getString("hopfieldMenuItem.toolTipText", new Object[0]));
/*  473 */     this.hopfieldMenuItem.setName("hopfieldMenuItem");
/*  474 */     this.networksMenu.add(this.hopfieldMenuItem);
/*      */     
/*  476 */     this.bamMenuItem.setAction(actionMap.get("showBAMWizard"));
/*  477 */     this.bamMenuItem.setText(resourceMap.getString("bamMenuItem.text", new Object[0]));
/*  478 */     this.bamMenuItem.setName("bamMenuItem");
/*  479 */     this.networksMenu.add(this.bamMenuItem);
/*      */     
/*  481 */     this.kohonenMenuItem.setAction(actionMap.get("showKohonenWizard"));
/*  482 */     this.kohonenMenuItem.setToolTipText(resourceMap.getString("kohonenMenuItem.toolTipText", new Object[0]));
/*  483 */     this.kohonenMenuItem.setName("kohonenMenuItem");
/*  484 */     this.networksMenu.add(this.kohonenMenuItem);
/*      */     
/*  486 */     this.supervisedHebbianMenuItem.setAction(actionMap.get("showHebbianWizard"));
/*  487 */     this.supervisedHebbianMenuItem.setText(resourceMap.getString("supervisedHebbianMenuItem.text", new Object[0]));
/*  488 */     this.supervisedHebbianMenuItem.setToolTipText(resourceMap.getString("supervisedHebbianMenuItem.toolTipText", new Object[0]));
/*  489 */     this.supervisedHebbianMenuItem.setName("supervisedHebbianMenuItem");
/*  490 */     this.networksMenu.add(this.supervisedHebbianMenuItem);
/*      */     
/*  492 */     this.unsupervisedHebbianMenuItem.setAction(actionMap.get("showUnsupervisedHebbianWizard"));
/*  493 */     this.unsupervisedHebbianMenuItem.setText(resourceMap.getString("unsupervisedHebbianMenuItem.text", new Object[0]));
/*  494 */     this.unsupervisedHebbianMenuItem.setName("unsupervisedHebbianMenuItem");
/*  495 */     this.networksMenu.add(this.unsupervisedHebbianMenuItem);
/*      */     
/*  497 */     this.maxnetMenuItem.setAction(actionMap.get("showMaxnetWizard"));
/*  498 */     this.maxnetMenuItem.setText(resourceMap.getString("maxnetMenuItem.text", new Object[0]));
/*  499 */     this.maxnetMenuItem.setName("maxnetMenuItem");
/*  500 */     this.networksMenu.add(this.maxnetMenuItem);
/*      */     
/*  502 */     this.competitiveMenuItem.setAction(actionMap.get("showCompetitiveNetworkWizard"));
/*  503 */     this.competitiveMenuItem.setText(resourceMap.getString("competitiveMenuItem.text", new Object[0]));
/*  504 */     this.competitiveMenuItem.setName("competitiveMenuItem");
/*  505 */     this.networksMenu.add(this.competitiveMenuItem);
/*      */     
/*  507 */     this.rbfMenuItem.setAction(actionMap.get("showRbfWizard"));
/*  508 */     this.rbfMenuItem.setName("rbfMenuItem");
/*  509 */     this.networksMenu.add(this.rbfMenuItem);
/*      */     
/*  511 */     this.instarMenuItem.setAction(actionMap.get("showInstarWizard"));
/*  512 */     this.instarMenuItem.setText(resourceMap.getString("instarMenuItem.text", new Object[0]));
/*  513 */     this.instarMenuItem.setName("instarMenuItem");
/*  514 */     this.networksMenu.add(this.instarMenuItem);
/*      */     
/*  516 */     this.outstarMenuItem.setAction(actionMap.get("showOutstarWizard"));
/*  517 */     this.outstarMenuItem.setText(resourceMap.getString("outstarMenuItem.text", new Object[0]));
/*  518 */     this.outstarMenuItem.setName("outstarMenuItem");
/*  519 */     this.networksMenu.add(this.outstarMenuItem);
/*      */     
/*  521 */     this.jSeparator1.setName("jSeparator1");
/*  522 */     this.networksMenu.add(this.jSeparator1);
/*      */     
/*  524 */     this.menuBar.add(this.networksMenu);
/*      */     
/*  526 */     this.trainingMenu.setText(resourceMap.getString("trainingMenu.text", new Object[0]));
/*  527 */     this.trainingMenu.setName("trainingMenu");
/*      */     
/*  529 */     this.trainingSetWizardMenuItem.setAction(actionMap.get("showTrainingSetWizard"));
/*  530 */     this.trainingSetWizardMenuItem.setText(resourceMap.getString("trainingSetWizardMenuItem.text", new Object[0]));
/*  531 */     this.trainingSetWizardMenuItem.setToolTipText(resourceMap.getString("trainingSetWizardMenuItem.toolTipText", new Object[0]));
/*  532 */     this.trainingSetWizardMenuItem.setName("trainingSetWizardMenuItem");
/*  533 */     this.trainingMenu.add(this.trainingSetWizardMenuItem);
/*      */     
/*  535 */     this.trainMenuItem.setAction(actionMap.get("trainNetwork"));
/*  536 */     this.trainMenuItem.setText(resourceMap.getString("trainMenuItem.text", new Object[0]));
/*  537 */     this.trainMenuItem.setToolTipText(resourceMap.getString("trainMenuItem.toolTipText", new Object[0]));
/*  538 */     this.trainMenuItem.setName("trainMenuItem");
/*  539 */     this.trainingMenu.add(this.trainMenuItem);
/*      */     
/*  541 */     this.menuBar.add(this.trainingMenu);
/*      */     
/*  543 */     this.toolsMenu.setText(resourceMap.getString("toolsMenu.text", new Object[0]));
/*  544 */     this.toolsMenu.setName("toolsMenu");
/*      */     
/*  546 */     this.imageRecognitionMenuItem.setAction(actionMap.get("imageRecognitionSample"));
/*  547 */     this.imageRecognitionMenuItem.setText(resourceMap.getString("imageRecognitionMenuItem.text", new Object[0]));
/*  548 */     this.imageRecognitionMenuItem.setName("imageRecognitionMenuItem");
/*  549 */     this.toolsMenu.add(this.imageRecognitionMenuItem);
/*      */     
/*  551 */     this.menuBar.add(this.toolsMenu);
/*      */     
/*  553 */     this.samplesMenu.setText(resourceMap.getString("samplesMenu.text", new Object[0]));
/*  554 */     this.samplesMenu.setName("samplesMenu");
/*      */     
/*  556 */     this.sampleBasicNeuron.setAction(actionMap.get("showBasicNeuronSample"));
/*  557 */     this.sampleBasicNeuron.setText(resourceMap.getString("sampleBasicNeuron.text", new Object[0]));
/*  558 */     this.sampleBasicNeuron.setName("sampleBasicNeuron");
/*  559 */     this.samplesMenu.add(this.sampleBasicNeuron);
/*      */     
/*  561 */     this.sampleKohonenMenuItem.setAction(actionMap.get("kohonenSample"));
/*  562 */     this.sampleKohonenMenuItem.setText(resourceMap.getString("sampleKohonenMenuItem.text", new Object[0]));
/*  563 */     this.sampleKohonenMenuItem.setToolTipText(resourceMap.getString("sampleKohonenMenuItem.toolTipText", new Object[0]));
/*  564 */     this.sampleKohonenMenuItem.setName("sampleKohonenMenuItem");
/*  565 */     this.samplesMenu.add(this.sampleKohonenMenuItem);
/*      */     
/*  567 */     this.sampleNFRMenuItem.setAction(actionMap.get("nfrSample"));
/*  568 */     this.sampleNFRMenuItem.setText(resourceMap.getString("sampleNFRMenuItem.text", new Object[0]));
/*  569 */     this.sampleNFRMenuItem.setToolTipText(resourceMap.getString("sampleNFRMenuItem.toolTipText", new Object[0]));
/*  570 */     this.sampleNFRMenuItem.setName("sampleNFRMenuItem");
/*  571 */     this.samplesMenu.add(this.sampleNFRMenuItem);
/*      */     
/*  573 */     this.sampleRecommenderMenuItem.setAction(actionMap.get("recommenderSample"));
/*  574 */     this.sampleRecommenderMenuItem.setName("sampleRecommenderMenuItem");
/*  575 */     this.samplesMenu.add(this.sampleRecommenderMenuItem);
/*      */     
/*  577 */     this.samplePerceptronMenuItem.setAction(actionMap.get("showPerceptronSample"));
/*  578 */     this.samplePerceptronMenuItem.setText(resourceMap.getString("samplePerceptronMenuItem.text", new Object[0]));
/*  579 */     this.samplePerceptronMenuItem.setName("samplePerceptronMenuItem");
/*  580 */     this.samplesMenu.add(this.samplePerceptronMenuItem);
/*      */     
/*  582 */     this.sampleBackpropMenuItem.setAction(actionMap.get("showBackpropagationSample"));
/*  583 */     this.sampleBackpropMenuItem.setText(resourceMap.getString("sampleBackpropMenuItem.text", new Object[0]));
/*  584 */     this.sampleBackpropMenuItem.setName("sampleBackpropMenuItem");
/*  585 */     this.samplesMenu.add(this.sampleBackpropMenuItem);
/*      */     
/*  587 */     this.menuBar.add(this.samplesMenu);
/*      */     
/*  589 */     helpMenu.setText(resourceMap.getString("helpMenu.text", new Object[0]));
/*  590 */     helpMenu.setName("helpMenu");
/*      */     
/*  592 */     this.jMenuItem7.setText(resourceMap.getString("jMenuItem7.text", new Object[0]));
/*  593 */     this.jMenuItem7.setName("jMenuItem7");
/*  594 */     this.jMenuItem7.addActionListener(showHelpContents());
/*  595 */     helpMenu.add(this.jMenuItem7);
/*      */     
/*  597 */     aboutMenuItem.setAction(actionMap.get("showAboutBox"));
/*  598 */     aboutMenuItem.setToolTipText(resourceMap.getString("aboutMenuItem.toolTipText", new Object[0]));
/*  599 */     aboutMenuItem.setName("aboutMenuItem");
/*  600 */     helpMenu.add(aboutMenuItem);
/*      */     
/*  602 */     this.menuBar.add(helpMenu);
/*      */     
/*  604 */     this.statusPanel.setName("statusPanel");
/*      */     
/*  606 */     statusPanelSeparator.setName("statusPanelSeparator");
/*      */     
/*  608 */     this.statusMessageLabel.setName("statusMessageLabel");
/*      */     
/*  610 */     this.statusAnimationLabel.setHorizontalAlignment(2);
/*  611 */     this.statusAnimationLabel.setName("statusAnimationLabel");
/*      */     
/*  613 */     this.progressBar.setName("progressBar");
/*      */     
/*  615 */     GroupLayout statusPanelLayout = new GroupLayout(this.statusPanel);
/*  616 */     this.statusPanel.setLayout(statusPanelLayout);
/*  617 */     statusPanelLayout.setHorizontalGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(statusPanelSeparator, -1, 622, 32767).addGroup(statusPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.statusMessageLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 452, 32767).addComponent(this.progressBar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.statusAnimationLabel).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  629 */     statusPanelLayout.setVerticalGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(statusPanelLayout.createSequentialGroup().addComponent(statusPanelSeparator, -2, 2, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(statusPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.statusMessageLabel).addComponent(this.statusAnimationLabel).addComponent(this.progressBar, -2, -1, -2)).addGap(3, 3, 3)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  641 */     this.treePopupMenu.setName("treePopupMenu");
/*      */     
/*  643 */     this.renameMenuItem.setAction(actionMap.get("renameTreeNode"));
/*  644 */     this.renameMenuItem.setName("renameMenuItem");
/*  645 */     this.treePopupMenu.add(this.renameMenuItem);
/*      */     
/*  647 */     this.removeMenuItem.setAction(actionMap.get("removeTreeNode"));
/*  648 */     this.removeMenuItem.setText(resourceMap.getString("removeMenuItem.text", new Object[0]));
/*  649 */     this.removeMenuItem.setName("removeMenuItem");
/*  650 */     this.treePopupMenu.add(this.removeMenuItem);
/*      */     
/*  652 */     setComponent(this.mainPanel);
/*  653 */     setMenuBar(this.menuBar);
/*  654 */     setStatusBar(this.statusPanel);
/*  655 */     setToolBar(this.jToolBar1);
/*      */   }
/*      */   
/*      */   public void addNewNetworkToProject(NeuralNetwork nnet) {
/*  659 */     int count = this.easyNeuronsProject.getNeuralNetworks().size() + 1;
/*  660 */     LabelsPlugin labels = (LabelsPlugin)nnet.getPlugin("LabelsPlugin");
/*  661 */     if ((labels.getLabel(nnet) == null) || (labels.getLabel(nnet).equals(""))) {
/*  662 */       labels.setLabel(nnet, "NewNetwork" + count);
/*      */     }
/*  664 */     addNetworkToProject(nnet);
/*      */   }
/*      */   
/*      */   private void addNetworkToProject(NeuralNetwork nnet) {
/*  668 */     this.easyNeuronsProject.addNeuralNetwork(nnet);
/*  669 */     updateProjectTree();
/*  670 */     openNetworkViewFrame(nnet);
/*      */   }
/*      */   
/*      */   public void updateProjectTree() {
/*  674 */     this.projectTree.setModel(this.easyNeuronsProject.getTreeModel());
/*      */     
/*      */ 
/*  677 */     int row = 0;
/*  678 */     while (row < this.projectTree.getRowCount()) {
/*  679 */       this.projectTree.expandRow(row);
/*  680 */       row++;
/*      */     }
/*      */   }
/*      */   
/*      */   public void updateFrameTitles() {
/*  685 */     JInternalFrame[] frames = this.desktopPanel.getAllFrames();
/*  686 */     for (int i = 0; i < frames.length; i++) {
/*  687 */       ((NeuralNetworkViewFrame)frames[i]).updateTitle();
/*      */     }
/*      */   }
/*      */   
/*      */   private void treeNodeDoubleClick(int selRow, TreePath selPath)
/*      */   {
/*  693 */     Object[] nodes = selPath.getPath();
/*  694 */     Object selectedNode = ((DefaultMutableTreeNode)nodes[(nodes.length - 1)]).getUserObject();
/*      */     
/*      */ 
/*  697 */     if ((selectedNode instanceof NeuralNetwork)) {
/*  698 */       NeuralNetwork nnet = (NeuralNetwork)selectedNode;
/*  699 */       openNetworkViewFrame(nnet);
/*      */     }
/*  701 */     else if ((selectedNode instanceof TrainingSet)) {
/*  702 */       TrainingSet trainingSet = (TrainingSet)selectedNode;
/*  703 */       openTrainingSetEditFrame(trainingSet);
/*      */     }
/*      */   }
/*      */   
/*      */   private void openNetworkViewFrame(NeuralNetwork nnet)
/*      */   {
/*  709 */     NeuralNetworkViewFrame networkViewFrame = new NeuralNetworkViewFrame(nnet, this.easyNeuronsProject.getTrainingSets());
/*      */     
/*      */ 
/*  712 */     networkViewFrame.addInternalFrameListener(new WindowObserver(networkViewFrame)
/*      */     {
/*      */       public void internalFrameActivated(InternalFrameEvent e) {
/*  715 */         EasyNeuronsApplicationView.this.netActiveWindow = this.nn;
/*  716 */         EasyNeuronsApplicationView.this.traActiveWindow = null;
/*      */       }
/*      */       
/*  719 */     });
/*  720 */     networkViewFrame.setVisible(true);
/*      */     
/*  722 */     this.desktopPanel.add(networkViewFrame);
/*      */     try {
/*  724 */       networkViewFrame.setSelected(true);
/*  725 */       networkViewFrame.setMaximum(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */   private void openTrainingSetEditFrame(TrainingSet trainingSet)
/*      */   {
/*  733 */     TrainingSetEditFrame trainingSetEditFrame = new TrainingSetEditFrame(trainingSet);
/*  734 */     trainingSetEditFrame.setVisible(true);
/*      */     
/*  736 */     trainingSetEditFrame.addInternalFrameListener(new WindowObserver(trainingSet)
/*      */     {
/*      */       public void internalFrameActivated(InternalFrameEvent e)
/*      */       {
/*  740 */         EasyNeuronsApplicationView.this.traActiveWindow = this.ts;
/*  741 */         EasyNeuronsApplicationView.this.netActiveWindow = null;
/*      */       }
/*      */       
/*  744 */     });
/*  745 */     this.desktopPanel.add(trainingSetEditFrame);
/*      */     try {
/*  747 */       trainingSetEditFrame.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */   }
/*      */   
/*      */   public static EasyNeuronsApplicationView getInstance() {
/*  753 */     return myInstance;
/*      */   }
/*      */   
/*      */   public void openNeuronPropertiesFrame(Neuron neuron) {
/*  757 */     NeuronPropertiesFrame neuronPropertiesFrame = new NeuronPropertiesFrame(neuron);
/*      */     
/*  759 */     neuronPropertiesFrame.setVisible(true);
/*      */     
/*  761 */     this.desktopPanel.add(neuronPropertiesFrame);
/*      */     try {
/*  763 */       neuronPropertiesFrame.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */   }
/*      */   
/*      */   private void showWizard(JDialog wizardDialog) {
/*  769 */     wizardDialog.setLocationRelativeTo(this.mainFrame);
/*  770 */     EasyNeuronsApplication.getApplication().show(wizardDialog);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showOpenDialog() {
/*  775 */     this.fileChooser.resetChoosableFileFilters();
/*  776 */     this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.NeuralNetworkBinaryFileFilter());
/*  777 */     this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.NeuralNetworkXmlFileFilter());
/*  778 */     this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.TrainingSetBinaryFileFilter());
/*  779 */     this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.TrainingSetXmlFileFilter());
/*  780 */     int option = this.fileChooser.showOpenDialog(this.mainFrame);
/*      */     
/*  782 */     if ((option != 1) || 
/*      */     
/*  784 */       (option == 0)) {
/*  785 */       File selectedFile = this.fileChooser.getSelectedFile();
/*  786 */       String fileExtension = FileUtils.getExtension(selectedFile);
/*      */       
/*  788 */       if (fileExtension != null) {
/*  789 */         if (FileUtils.isNeuralNetwork(fileExtension)) {
/*  790 */           String location = selectedFile.getPath();
/*  791 */           String fileName = selectedFile.getName();
/*  792 */           FileIO io = new FileIO();
/*  793 */           NeuralNetwork nnet = io.loadNeuralNetwork(location);
/*      */           
/*  795 */           addNetworkToProject(nnet);
/*      */           
/*  797 */           this.fileObserver.put(location, fileName);
/*      */         }
/*      */         
/*  800 */         if (FileUtils.isTrainingSet(fileExtension)) {
/*  801 */           String location = selectedFile.getPath();
/*  802 */           String fileName = selectedFile.getName();
/*  803 */           this.fileObserver.put(location, fileName);
/*  804 */           FileIO io = new FileIO();
/*  805 */           TrainingSet trainingSet = io.loadTrainingSet(location);
/*      */           
/*  807 */           updateTrainingSets(trainingSet);
/*  808 */           openTrainingSetEditFrame(trainingSet);
/*      */           
/*  810 */           this.fileObserver.put(location, fileName);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   @Action
/*      */   public void showSaveDialog()
/*      */   {
/*  821 */     if (this.netActiveWindow != null)
/*      */     {
/*      */ 
/*  824 */       if (this.fileObserver.containsKey(this.netActiveWindow.getFilePath()))
/*      */       {
/*      */ 
/*  827 */         FileIO io = new FileIO();
/*  828 */         io.saveNeuralNetwork(this.netActiveWindow.getNeuralNetwork(), this.netActiveWindow.getNeuralNetwork().toString(), this.netActiveWindow.getFilePath());
/*      */       } else {
/*  830 */         this.fileChooser.resetChoosableFileFilters();
/*  831 */         this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.NeuralNetworkBinaryFileFilter());
/*  832 */         this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.NeuralNetworkXmlFileFilter());
/*  833 */         int option = this.fileChooser.showSaveDialog(this.mainFrame);
/*  834 */         if (option == 0) {
/*  835 */           int count = this.fileChooser.getCurrentDirectory().toString().length();
/*  836 */           String name = this.fileChooser.getSelectedFile().toString().substring(count + 1);
/*  837 */           String location = this.fileChooser.getSelectedFile().toString() + this.fileChooser.getFileFilter().getDescription();
/*  838 */           FileIO io = new FileIO();
/*  839 */           io.saveNeuralNetwork(this.netActiveWindow.getNeuralNetwork(), name, location);
/*  840 */           this.fileObserver.put(location, name);
/*  841 */           showMessage("Neural network saved");
/*      */         }
/*  843 */         updateProjectTree();
/*  844 */         updateFrameTitles();
/*      */       }
/*      */     }
/*      */     
/*  848 */     if (this.traActiveWindow != null)
/*      */     {
/*  850 */       if (this.fileObserver.containsKey(this.traActiveWindow.getFilePath()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  859 */         FileIO io = new FileIO();
/*  860 */         io.saveTrainingSet(this.traActiveWindow, this.traActiveWindow.getLabel(), this.traActiveWindow.getFilePath());
/*      */       }
/*      */       else {
/*  863 */         this.fileChooser.resetChoosableFileFilters();
/*  864 */         this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.TrainingSetBinaryFileFilter());
/*  865 */         this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.TrainingSetXmlFileFilter());
/*  866 */         int option = this.fileChooser.showSaveDialog(this.mainFrame);
/*      */         
/*  868 */         if (option == 0) {
/*  869 */           int count = this.fileChooser.getCurrentDirectory().toString().length();
/*  870 */           String name = this.fileChooser.getSelectedFile().toString().substring(count + 1);
/*  871 */           String location = this.fileChooser.getSelectedFile().toString();
/*  872 */           FileIO io = new FileIO();
/*  873 */           io.saveTrainingSet(this.traActiveWindow, name, location);
/*  874 */           this.fileObserver.put(location, name);
/*  875 */           showMessage("Training set saved");
/*      */         }
/*  877 */         updateProjectTree();
/*  878 */         updateFrameTitles();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showSaveAsDialog() {
/*  885 */     if (this.netActiveWindow != null) {
/*  886 */       this.fileChooser.resetChoosableFileFilters();
/*  887 */       this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.NeuralNetworkBinaryFileFilter());
/*  888 */       this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.NeuralNetworkXmlFileFilter());
/*  889 */       int option = this.fileChooser.showSaveDialog(this.mainFrame);
/*  890 */       if (option == 0) {
/*  891 */         int count = this.fileChooser.getCurrentDirectory().toString().length();
/*  892 */         String name = this.fileChooser.getSelectedFile().toString().substring(count + 1);
/*  893 */         String location = this.fileChooser.getSelectedFile().toString() + this.fileChooser.getFileFilter().getDescription();
/*  894 */         FileIO io = new FileIO();
/*  895 */         io.saveNeuralNetwork(this.netActiveWindow.getNeuralNetwork(), name, location);
/*  896 */         this.fileObserver.put(location, name);
/*  897 */         showMessage("Neural network saved");
/*      */       }
/*  899 */       updateProjectTree();
/*  900 */       updateFrameTitles();
/*      */     }
/*  902 */     if (this.traActiveWindow != null) {
/*  903 */       this.fileChooser.resetChoosableFileFilters();
/*  904 */       this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.TrainingSetBinaryFileFilter());
/*  905 */       this.fileChooser.addChoosableFileFilter(new FileFilterAdapter.TrainingSetXmlFileFilter());
/*  906 */       int option = this.fileChooser.showSaveDialog(this.mainFrame);
/*  907 */       if (option == 0) {
/*  908 */         int count = this.fileChooser.getCurrentDirectory().toString().length();
/*  909 */         String name = this.fileChooser.getSelectedFile().toString().substring(count + 1);
/*  910 */         String location = this.fileChooser.getSelectedFile().toString();
/*  911 */         FileIO io = new FileIO();
/*  912 */         io.saveTrainingSet(this.traActiveWindow, name, location);
/*  913 */         this.fileObserver.put(location, name);
/*  914 */         showMessage("Training set saved");
/*      */       }
/*  916 */       updateProjectTree();
/*  917 */       updateFrameTitles();
/*      */     }
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showAdalineWizard() {
/*  923 */     AdalineWizard wizard = new AdalineWizard(this.mainFrame, true);
/*  924 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showPerceptronWizard() {
/*  929 */     PerceptronWizard wizard = new PerceptronWizard(this.mainFrame, true);
/*  930 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showMLPerceptronWizard() {
/*  935 */     MultiLayerPerceptronWizard wizard = new MultiLayerPerceptronWizard(this.mainFrame, true);
/*  936 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showHopfieldWizard() {
/*  941 */     org.neuroph.easyneurons.dialog.HopfieldWizard wizard = new org.neuroph.easyneurons.dialog.HopfieldWizard(this.mainFrame, true);
/*  942 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showBAMWizard() {
/*  947 */     BamWizard wizard = new BamWizard(this.mainFrame, true);
/*  948 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showKohonenWizard() {
/*  953 */     org.neuroph.easyneurons.dialog.KohonenWizard wizard = new org.neuroph.easyneurons.dialog.KohonenWizard(this.mainFrame, true);
/*  954 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showHebbianWizard() {
/*  959 */     SupervisedHebbianWizard wizard = new SupervisedHebbianWizard(this.mainFrame, true);
/*  960 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showUnsupervisedHebbianWizard() {
/*  965 */     UnsupervisedHebbianWizard wizard = new UnsupervisedHebbianWizard(this.mainFrame, true);
/*  966 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showCompetitiveNetworkWizard() {
/*  971 */     CompetitiveNetworkWizard wizard = new CompetitiveNetworkWizard(this.mainFrame, true);
/*  972 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showMaxnetWizard() {
/*  977 */     MaxnetWizard wizard = new MaxnetWizard(this.mainFrame, true);
/*  978 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showInstarWizard() {
/*  983 */     org.neuroph.easyneurons.dialog.InstarWizard wizard = new org.neuroph.easyneurons.dialog.InstarWizard(this.mainFrame, true);
/*  984 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showOutstarWizard() {
/*  989 */     org.neuroph.easyneurons.dialog.OutstarWizard wizard = new org.neuroph.easyneurons.dialog.OutstarWizard(this.mainFrame, true);
/*  990 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showRbfWizard() {
/*  995 */     RbfWizard wizard = new RbfWizard(this.mainFrame, true);
/*  996 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showTrainingSetWizard() {
/* 1001 */     TrainingSetWizard wizard = new TrainingSetWizard(this.mainFrame, true);
/* 1002 */     showWizard(wizard);
/*      */   }
/*      */   
/*      */   public void newAdalineNetwork(int inputNeurons) {
/* 1006 */     org.neuroph.nnet.Adaline nnet = NeuralNetworkFactory.createAdaline(inputNeurons);
/* 1007 */     addNewNetworkToProject(nnet);
/*      */   }
/*      */   
/*      */   public void newPerceptronNetwork(int inputNeurons, int outputNeurons, TransferFunctionType transferFunction, Class learningRule)
/*      */   {
/* 1012 */     Perceptron nnet = NeuralNetworkFactory.createPerceptron(inputNeurons, outputNeurons, transferFunction, learningRule);
/*      */     
/* 1014 */     addNewNetworkToProject(nnet);
/* 1015 */     showMessage("Created new Perceptron Network");
/*      */   }
/*      */   
/*      */   public void newInstarNetwork(int inputNeuronsNum) {
/* 1019 */     org.neuroph.nnet.Instar nnet = NeuralNetworkFactory.createInstar(inputNeuronsNum);
/* 1020 */     addNewNetworkToProject(nnet);
/* 1021 */     showMessage("Created new Instar Network");
/*      */   }
/*      */   
/*      */   public void newOutstarNetwork(int outputNeuronsNum) {
/* 1025 */     org.neuroph.nnet.Outstar nnet = NeuralNetworkFactory.createOutstar(outputNeuronsNum);
/* 1026 */     addNewNetworkToProject(nnet);
/* 1027 */     showMessage("Created new Outstar Network");
/*      */   }
/*      */   
/*      */   public void newMaxnetNetwork(int neuronsNum) {
/* 1031 */     org.neuroph.nnet.MaxNet nnet = NeuralNetworkFactory.createMaxNet(neuronsNum);
/* 1032 */     addNewNetworkToProject(nnet);
/* 1033 */     showMessage("Created new Maxnet Network");
/*      */   }
/*      */   
/*      */   public void newCompetitiveNetwork(int inputNeuronsNum, int outputNeuronsNum) {
/* 1037 */     org.neuroph.nnet.CompetitiveNetwork nnet = NeuralNetworkFactory.createCompetitiveNetwork(inputNeuronsNum, outputNeuronsNum);
/*      */     
/* 1039 */     addNewNetworkToProject(nnet);
/* 1040 */     showMessage("Created new Competitive Network");
/*      */   }
/*      */   
/*      */   public void newMLPerceptronNetwork(String neuronsNum, TransferFunctionType transferFunctionType)
/*      */   {
/* 1045 */     MultiLayerPerceptron nnet = NeuralNetworkFactory.createMLPerceptron(neuronsNum, transferFunctionType);
/*      */     
/* 1047 */     addNewNetworkToProject(nnet);
/* 1048 */     showMessage("Created new Multi Layer Perceptron Network");
/*      */   }
/*      */   
/*      */   public void newMLPerceptronNetwork(String neuronsNum, TransferFunctionType transferFunctionType, Class learningRule, boolean useBias, boolean connectI2O)
/*      */   {
/* 1053 */     MultiLayerPerceptron nnet = NeuralNetworkFactory.createMLPerceptron(neuronsNum, transferFunctionType, learningRule, useBias, connectI2O);
/*      */     
/* 1055 */     addNewNetworkToProject(nnet);
/* 1056 */     showMessage("Created new Multi Layer Perceptron Network");
/*      */   }
/*      */   
/*      */   public void newHopfieldNetwork(int inputNeurons) {
/* 1060 */     org.neuroph.nnet.Hopfield nnet = NeuralNetworkFactory.createHopfield(inputNeurons);
/* 1061 */     addNewNetworkToProject(nnet);
/* 1062 */     showMessage("Created new Hopfield Network");
/*      */   }
/*      */   
/*      */   public void newBamNetwork(int inputNeurons, int outputNeurons) {
/* 1066 */     org.neuroph.nnet.BAM nnet = NeuralNetworkFactory.createBam(inputNeurons, outputNeurons);
/* 1067 */     addNewNetworkToProject(nnet);
/* 1068 */     showMessage("Created new BAM Network");
/*      */   }
/*      */   
/*      */   public void newKohonenNetwork(int inputNeurons, int mapNeurons) {
/* 1072 */     Kohonen nnet = NeuralNetworkFactory.createKohonen(inputNeurons, mapNeurons);
/*      */     
/* 1074 */     addNewNetworkToProject(nnet);
/* 1075 */     showMessage("Created new Kohonen Network");
/*      */   }
/*      */   
/*      */   public void newHebbianNetwork(int inputNeurons, int outputNeurons, TransferFunctionType transferFunction)
/*      */   {
/* 1080 */     org.neuroph.nnet.SupervisedHebbianNetwork nnet = NeuralNetworkFactory.createSupervisedHebbian(inputNeurons, outputNeurons, transferFunction);
/*      */     
/* 1082 */     addNewNetworkToProject(nnet);
/* 1083 */     showMessage("Created new Supervised Hebbian Network");
/*      */   }
/*      */   
/*      */   public void newUnsupervisedHebbianNetwork(int inputNeurons, int outputNeurons, TransferFunctionType transferFunction)
/*      */   {
/* 1088 */     org.neuroph.nnet.UnsupervisedHebbianNetwork nnet = NeuralNetworkFactory.createUnsupervisedHebbian(inputNeurons, outputNeurons, transferFunction);
/*      */     
/* 1090 */     addNewNetworkToProject(nnet);
/* 1091 */     showMessage("Created new Unsupervised Hopfield Network");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void newRbfNetwork(int inputNeuronsNum, int rbfNeuronsNum, int outputNeuronsNum)
/*      */   {
/* 1098 */     org.neuroph.nnet.RbfNetwork nnet = NeuralNetworkFactory.createRbfNetwork(inputNeuronsNum, rbfNeuronsNum, outputNeuronsNum);
/*      */     
/* 1100 */     addNewNetworkToProject(nnet);
/* 1101 */     showMessage("Created new RBF Network");
/*      */   }
/*      */   
/*      */   public void showTrainingSetEditFrame(int inputs, int outputs, String type, String label)
/*      */   {
/* 1106 */     TrainingSet trainingSet = new TrainingSet(label);
/* 1107 */     TrainingSetEditFrame trainingSetEditFrame = new TrainingSetEditFrame(trainingSet, type, inputs, outputs);
/* 1108 */     trainingSetEditFrame.setVisible(true);
/*      */     
/* 1110 */     this.desktopPanel.add(trainingSetEditFrame);
/*      */     try {
/* 1112 */       trainingSetEditFrame.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */   }
/*      */   
/*      */   public void updateTrainingSets(TrainingSet trainingSet) {
/* 1118 */     if (!this.easyNeuronsProject.getTrainingSets().contains(trainingSet)) {
/* 1119 */       this.easyNeuronsProject.addTrainingSet(trainingSet);
/*      */     }
/* 1121 */     updateProjectTree();
/*      */   }
/*      */   
/*      */   public SupervisedTrainingMonitorFrame openMonitorFrame(NeuralNetworkTraining trainingController) {
/* 1125 */     SupervisedTrainingMonitorFrame monitorFrame = new SupervisedTrainingMonitorFrame(trainingController);
/*      */     
/* 1127 */     monitorFrame.setVisible(true);
/* 1128 */     this.desktopPanel.add(monitorFrame);
/*      */     try {
/* 1130 */       monitorFrame.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */     
/* 1134 */     return monitorFrame;
/*      */   }
/*      */   
/*      */ 
/*      */   public GraphFrame openErrorGraphFrame()
/*      */   {
/* 1140 */     JInternalFrame[] iframes = this.desktopPanel.getAllFrames();
/* 1141 */     for (int i = 0; i < iframes.length; i++) {
/* 1142 */       if ((iframes[i] instanceof GraphFrame))
/*      */       {
/*      */         try {
/* 1145 */           iframes[i].setSelected(true);
/*      */         }
/*      */         catch (PropertyVetoException e) {}
/*      */         
/* 1149 */         return (GraphFrame)iframes[i];
/*      */       }
/*      */     }
/*      */     
/* 1153 */     GraphFrame graphFrame = new GraphFrame();
/*      */     
/* 1155 */     graphFrame.setVisible(true);
/* 1156 */     this.desktopPanel.add(graphFrame);
/*      */     try {
/* 1158 */       graphFrame.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */     
/* 1162 */     return graphFrame;
/*      */   }
/*      */   
/*      */ 
/*      */   @Action
/*      */   public void trainNetwork()
/*      */   {
/* 1169 */     JInternalFrame selectedFrame = this.desktopPanel.getSelectedFrame();
/* 1170 */     if ((selectedFrame != null) && 
/* 1171 */       ((selectedFrame instanceof NeuralNetworkViewFrame))) {
/* 1172 */       ((NeuralNetworkViewFrame)selectedFrame).train();
/*      */     }
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void removeTreeNode()
/*      */   {
/* 1179 */     Object[] nodes = this.projectTree.getSelectionPath().getPath();
/* 1180 */     Object selectedNode = ((DefaultMutableTreeNode)nodes[(nodes.length - 1)]).getUserObject();
/*      */     
/*      */ 
/* 1183 */     if ((selectedNode instanceof NeuralNetwork)) {
/* 1184 */       NeuralNetwork nnet = (NeuralNetwork)selectedNode;
/* 1185 */       this.easyNeuronsProject.removeNeuralNetwork(nnet);
/* 1186 */       updateProjectTree();
/*      */     }
/* 1188 */     else if ((selectedNode instanceof TrainingSet)) {
/* 1189 */       TrainingSet trainingSet = (TrainingSet)selectedNode;
/* 1190 */       this.easyNeuronsProject.removeTrainingSet(trainingSet);
/* 1191 */       updateProjectTree();
/*      */     }
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void kohonenSample() {
/* 1197 */     int sampleSize = 100;
/* 1198 */     NeuralNetwork neuralNet = new Kohonen(new Integer(2).intValue(), new Integer(sampleSize).intValue());
/*      */     
/* 1200 */     ((LabelsPlugin)neuralNet.getPlugin("LabelsPlugin")).setLabel(neuralNet, "Kohonen sample");
/* 1201 */     this.easyNeuronsProject.addNeuralNetwork(neuralNet);
/*      */     
/* 1203 */     TrainingSet trainingSet = new TrainingSet();
/* 1204 */     trainingSet.setLabel("Sample training set");
/*      */     
/* 1206 */     for (int i = 0; i < sampleSize; i++) {
/* 1207 */       Vector<Double> trainVect = new Vector();
/* 1208 */       trainVect.add(Double.valueOf(Math.random()));
/* 1209 */       trainVect.add(Double.valueOf(Math.random()));
/* 1210 */       TrainingElement te = new TrainingElement(trainVect);
/* 1211 */       trainingSet.addElement(te);
/*      */     }
/*      */     
/* 1214 */     this.easyNeuronsProject.addTrainingSet(trainingSet);
/*      */     
/* 1216 */     updateProjectTree();
/*      */     
/* 1218 */     NeuralNetworkTraining controller = new NeuralNetworkTraining(neuralNet, trainingSet);
/*      */     
/* 1220 */     KohonenSample kohonenVisualizer = new KohonenSample(controller);
/*      */     
/* 1222 */     neuralNet.getLearningRule().addObserver(kohonenVisualizer);
/* 1223 */     neuralNet.addObserver(kohonenVisualizer);
/*      */     
/* 1225 */     kohonenVisualizer.setVisible(true);
/* 1226 */     this.desktopPanel.add(kohonenVisualizer);
/*      */     try {
/* 1228 */       kohonenVisualizer.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */     
/* 1232 */     showMessage("Created Kohonen Sample");
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void nfrSample() {
/* 1237 */     double[][] pointsSets = { { 0.0D, 0.0D, 20.0D, 22.0D }, { 20.0D, 22.0D, 40.0D, 42.0D }, { 40.0D, 42.0D, 80.0D, 82.0D }, { 80.0D, 82.0D, 100.0D, 100.0D } };
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1242 */     double[][] timeSets = { { 15.0D, 15.0D, 20.0D, 25.0D }, { 20.0D, 25.0D, 35.0D, 40.0D }, { 35.0D, 40.0D, 1000.0D, 1000.0D } };
/*      */     
/*      */ 
/*      */ 
/* 1246 */     NeuralNetwork nnet = new org.neuroph.nnet.NeuroFuzzyPerceptron(pointsSets, timeSets);
/* 1247 */     TrainingSet tSet = new TrainingSet();
/*      */     
/* 1249 */     Layer setLayer = nnet.getLayerAt(1);
/*      */     
/* 1251 */     int outClass = 0;
/*      */     
/* 1253 */     for (int i = 0; i <= 3; i++) {
/* 1254 */       Neuron icell = setLayer.getNeuronAt(i);
/* 1255 */       Trapezoid tfi = (Trapezoid)icell.getTransferFunction();
/* 1256 */       double r1i = tfi.getRightLow();
/* 1257 */       double l2i = tfi.getLeftHigh();
/* 1258 */       double r2i = tfi.getRightHigh();
/* 1259 */       double right_intersection_i = r2i + (r1i - r2i) / 2.0D;
/*      */       
/* 1261 */       for (int j = 6; j >= 4; j--) {
/* 1262 */         Neuron jcell = setLayer.getNeuronAt(j);
/* 1263 */         Trapezoid tfj = (Trapezoid)jcell.getTransferFunction();
/*      */         
/* 1265 */         double r1j = tfj.getRightLow();
/* 1266 */         double l2j = tfj.getLeftHigh();
/* 1267 */         double r2j = tfj.getRightHigh();
/* 1268 */         double right_intersection_j = r2j + (r1j - r2j) / 2.0D;
/*      */         String outputPattern;
/*      */         String outputPattern;
/* 1271 */         if (outClass <= 3) {
/* 1272 */           outputPattern = "1 0 0 0"; } else { String outputPattern;
/* 1273 */           if ((outClass >= 4) && (outClass <= 6)) {
/* 1274 */             outputPattern = "0 1 0 0"; } else { String outputPattern;
/* 1275 */             if ((outClass >= 7) && (outClass <= 9)) {
/* 1276 */               outputPattern = "0 0 1 0";
/*      */             } else
/* 1278 */               outputPattern = "0 0 0 1";
/*      */           }
/*      */         }
/* 1281 */         String inputPattern = Double.toString(l2i) + " " + Double.toString(l2j);
/*      */         
/* 1283 */         SupervisedTrainingElement tEl = new SupervisedTrainingElement(inputPattern, outputPattern);
/*      */         
/* 1285 */         tSet.addElement(tEl);
/*      */         
/* 1287 */         inputPattern = Double.toString(l2i) + " " + Double.toString(r2j);
/*      */         
/* 1289 */         tEl = new SupervisedTrainingElement(inputPattern, outputPattern);
/* 1290 */         tSet.addElement(tEl);
/*      */         
/* 1292 */         inputPattern = Double.toString(l2i) + " " + Double.toString(right_intersection_j);
/*      */         
/* 1294 */         tEl = new SupervisedTrainingElement(inputPattern, outputPattern);
/* 1295 */         tSet.addElement(tEl);
/*      */         
/* 1297 */         inputPattern = Double.toString(r2i) + " " + Double.toString(l2j);
/*      */         
/* 1299 */         tEl = new SupervisedTrainingElement(inputPattern, outputPattern);
/* 1300 */         tSet.addElement(tEl);
/*      */         
/* 1302 */         inputPattern = Double.toString(r2i) + " " + Double.toString(r2j);
/*      */         
/* 1304 */         tEl = new SupervisedTrainingElement(inputPattern, outputPattern);
/* 1305 */         tSet.addElement(tEl);
/*      */         
/* 1307 */         inputPattern = Double.toString(r2i) + " " + Double.toString(right_intersection_j);
/*      */         
/* 1309 */         tEl = new SupervisedTrainingElement(inputPattern, outputPattern);
/* 1310 */         tSet.addElement(tEl);
/*      */         
/* 1312 */         inputPattern = Double.toString(right_intersection_i) + " " + Double.toString(l2j);
/*      */         
/* 1314 */         tEl = new SupervisedTrainingElement(inputPattern, outputPattern);
/* 1315 */         tSet.addElement(tEl);
/*      */         
/* 1317 */         inputPattern = Double.toString(right_intersection_i) + " " + Double.toString(r2j);
/*      */         
/* 1319 */         tEl = new SupervisedTrainingElement(inputPattern, outputPattern);
/* 1320 */         tSet.addElement(tEl);
/*      */         
/* 1322 */         inputPattern = Double.toString(right_intersection_i) + " " + Double.toString(right_intersection_j);
/*      */         
/* 1324 */         tEl = new SupervisedTrainingElement(inputPattern, outputPattern);
/* 1325 */         tSet.addElement(tEl);
/*      */         
/* 1327 */         outClass++;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1333 */     ((LabelsPlugin)nnet.getPlugin("LabelsPlugin")).setLabel(nnet, "NFR sample");
/* 1334 */     tSet.setLabel("NFR tset");
/* 1335 */     this.easyNeuronsProject.addNeuralNetwork(nnet);
/* 1336 */     this.easyNeuronsProject.addTrainingSet(tSet);
/*      */     
/* 1338 */     updateProjectTree();
/*      */     
/* 1340 */     NeuralNetworkTraining controller = new NeuralNetworkTraining(nnet, tSet);
/*      */     
/*      */ 
/* 1343 */     NFRSample frame = new NFRSample(controller);
/*      */     
/* 1345 */     frame.setVisible(true);
/* 1346 */     this.desktopPanel.add(frame);
/*      */     try {
/* 1348 */       frame.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */   }
/*      */   
/*      */ 
/*      */   @Action
/*      */   public void showAboutBox()
/*      */   {
/* 1357 */     if (this.aboutBox == null) {
/* 1358 */       this.aboutBox = new AboutBox(this.mainFrame);
/* 1359 */       this.aboutBox.setLocationRelativeTo(this.mainFrame);
/*      */     }
/* 1361 */     EasyNeuronsApplication.getApplication().show(this.aboutBox);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void renameTreeNode() {
/* 1366 */     Object[] nodes = this.projectTree.getSelectionPath().getPath();
/* 1367 */     Object selectedNode = ((DefaultMutableTreeNode)nodes[(nodes.length - 1)]).getUserObject();
/*      */     
/*      */ 
/* 1370 */     RenameNodeDialog dialog = new RenameNodeDialog(this.mainFrame, true, selectedNode);
/* 1371 */     dialog.setLocationRelativeTo(this.mainFrame);
/* 1372 */     EasyNeuronsApplication.getApplication().show(dialog);
/*      */   }
/*      */   
/*      */   public void treeNodesChanged(TreeModelEvent e)
/*      */   {
/* 1377 */     Object[] nodes = this.projectTree.getSelectionPath().getPath();
/* 1378 */     Object selectedNode = ((DefaultMutableTreeNode)nodes[(nodes.length - 1)]).getUserObject();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1387 */     String newLabel = selectedNode.toString();
/*      */     
/* 1389 */     if ((selectedNode instanceof NeuralNetwork)) {
/* 1390 */       NeuralNetwork nnet = (NeuralNetwork)selectedNode;
/*      */       
/* 1392 */       ((LabelsPlugin)nnet.getPlugin("LabelsPlugin")).setLabel(nnet, newLabel);
/*      */ 
/*      */     }
/* 1395 */     else if ((selectedNode instanceof TrainingSet)) {
/* 1396 */       TrainingSet trainingSet = (TrainingSet)selectedNode;
/* 1397 */       trainingSet.setLabel(newLabel);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public JTree getProjectTree()
/*      */   {
/* 1404 */     return this.projectTree;
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void switchToGraphView() {
/* 1409 */     JInternalFrame iframe = this.desktopPanel.getSelectedFrame();
/*      */     
/* 1411 */     if ((iframe instanceof NeuralNetworkViewFrame)) {
/* 1412 */       ((NeuralNetworkViewFrame)iframe).switchToView(2);
/*      */     }
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void switchToBlockView()
/*      */   {
/* 1419 */     JInternalFrame iframe = this.desktopPanel.getSelectedFrame();
/*      */     
/* 1421 */     if ((iframe instanceof NeuralNetworkViewFrame)) {
/* 1422 */       ((NeuralNetworkViewFrame)iframe).switchToView(1);
/*      */     }
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void refreshView()
/*      */   {
/* 1429 */     JInternalFrame iframe = this.desktopPanel.getSelectedFrame();
/*      */     
/* 1431 */     if ((iframe instanceof NeuralNetworkViewFrame)) {
/* 1432 */       ((NeuralNetworkViewFrame)iframe).refresh();
/*      */     }
/*      */   }
/*      */   
/*      */   public void showMessage(String message) {
/* 1437 */     this.messageBox.append(message + "\r\n");
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showBasicNeuronSample() {
/* 1442 */     BasicNeuronSample sample = new BasicNeuronSample();
/*      */     
/* 1444 */     sample.setVisible(true);
/* 1445 */     this.desktopPanel.add(sample);
/*      */     try {
/* 1447 */       sample.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */     
/* 1451 */     showMessage("Started Basic Neuron Sample");
/*      */   }
/*      */   
/*      */   public ActionListener showHelpContents() {
/* 1455 */     String path = "org/neuroph/easyneurons/help/EasyNeurons.hs";
/* 1456 */     ClassLoader loader = getClass().getClassLoader();
/*      */     
/* 1458 */     HelpSet hs = null;
/*      */     try
/*      */     {
/* 1461 */       java.net.URL hsURL = HelpSet.findHelpSet(loader, path);
/* 1462 */       hs = new HelpSet(loader, hsURL);
/*      */     } catch (Exception ee) {
/* 1464 */       ee.printStackTrace();
/*      */     }
/*      */     
/* 1467 */     javax.help.HelpBroker hb = hs.createHelpBroker();
/*      */     
/* 1469 */     return new javax.help.CSH.DisplayHelpFromSource(hb);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void recommenderSample()
/*      */   {
/* 1475 */     NeuralNetwork nnet = new RecommenderNetwork();
/* 1476 */     ((RecommenderNetwork)nnet).createDemoNetwork();
/* 1477 */     TrainingSet tSet = new TrainingSet();
/*      */     
/* 1479 */     ((LabelsPlugin)nnet.getPlugin("LabelsPlugin")).setLabel(nnet, "Recommender sample");
/* 1480 */     tSet.setLabel("E-commerce tset");
/* 1481 */     this.easyNeuronsProject.addNeuralNetwork(nnet);
/* 1482 */     this.easyNeuronsProject.addTrainingSet(tSet);
/*      */     
/* 1484 */     updateProjectTree();
/*      */     
/* 1486 */     NeuralNetworkTraining controller = new NeuralNetworkTraining(nnet, tSet);
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void imageRecognitionSample() {
/* 1491 */     ImageRecognitionFrame sample = new ImageRecognitionFrame();
/* 1492 */     sample.setVisible(true);
/* 1493 */     this.desktopPanel.add(sample);
/*      */     try {
/* 1495 */       sample.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/*      */   }
/*      */   
/*      */   public EasyNeuronsProject getProject()
/*      */   {
/* 1502 */     return this.easyNeuronsProject;
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showPerceptronSample() {
/* 1507 */     NeuralNetwork neuralNet = new Perceptron(new Integer(2).intValue(), new Integer(1).intValue());
/* 1508 */     neuralNet.setLearningRule(new org.neuroph.nnet.learning.BinaryDeltaRule());
/* 1509 */     ((LabelsPlugin)neuralNet.getPlugin("LabelsPlugin")).setLabel(neuralNet, "PerceptronSampleNetwork");
/* 1510 */     this.easyNeuronsProject.addNeuralNetwork(neuralNet);
/*      */     
/* 1512 */     TrainingSetObserver trainingSet = new TrainingSetObserver()
/*      */     {
/*      */       public void update(Observable o, Object arg)
/*      */       {
/* 1516 */         TrainingSet t = new TrainingSet();
/* 1517 */         EasyNeuronsApplicationView.this.easyNeuronsProject.removeTrainingSet(getTrainingSet());
/*      */         
/* 1519 */         super.update(o, arg);
/* 1520 */         t = getTrainingSet();
/* 1521 */         t.setLabel("Perceptron Sample Training Set");
/* 1522 */         EasyNeuronsApplicationView.this.easyNeuronsProject.addTrainingSet(t);
/* 1523 */         EasyNeuronsApplicationView.this.updateProjectTree();
/*      */       }
/* 1525 */     };
/* 1526 */     PerceptronSampleTrainingSet pst = new PerceptronSampleTrainingSet();
/* 1527 */     pst.addObserver(trainingSet);
/*      */     
/* 1529 */     TrainingSet ts = trainingSet.getTrainingSet();
/*      */     
/* 1531 */     NeuralNetworkTraining nnTraining = new NeuralNetworkTraining(neuralNet, ts);
/*      */     
/* 1533 */     PerceptronSampleFrame perceptronVisualizer = new PerceptronSampleFrame(nnTraining, pst);
/* 1534 */     neuralNet.getLearningRule().addObserver(perceptronVisualizer);
/* 1535 */     neuralNet.addObserver(perceptronVisualizer);
/*      */     
/* 1537 */     perceptronVisualizer.setVisible(true);
/* 1538 */     this.desktopPanel.add(perceptronVisualizer);
/*      */     try
/*      */     {
/* 1541 */       perceptronVisualizer.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/* 1544 */     showMessage("Started Perceptron Sample");
/*      */   }
/*      */   
/*      */   @Action
/*      */   public void showBackpropagationSample() {
/* 1549 */     MarkovNeuralNet markovNeuralNet = new MarkovNeuralNet()
/*      */     {
/*      */       public void update(Observable o, Object arg)
/*      */       {
/* 1553 */         NeuralNetwork net = getNnet();
/* 1554 */         EasyNeuronsApplicationView.this.easyNeuronsProject.removeNeuralNetwork(net);
/*      */         
/* 1556 */         super.update(o, arg);
/* 1557 */         net = getNnet();
/* 1558 */         if (net == null) { EasyNeuronsApplicationView.this.updateProjectTree();
/*      */         } else {
/* 1560 */           ((LabelsPlugin)net.getPlugin("LabelsPlugin")).setLabel(net, "Backpropagation Sample");
/* 1561 */           EasyNeuronsApplicationView.this.easyNeuronsProject.addNeuralNetwork(net);
/* 1562 */           EasyNeuronsApplicationView.this.updateProjectTree();
/*      */         }
/*      */         
/*      */       }
/* 1566 */     };
/* 1567 */     TrainingSetObserver trainingSet = new TrainingSetObserver()
/*      */     {
/*      */       public void update(Observable o, Object arg)
/*      */       {
/* 1571 */         TrainingSet t = getTrainingSet();
/* 1572 */         EasyNeuronsApplicationView.this.easyNeuronsProject.removeTrainingSet(t);
/* 1573 */         super.update(o, arg);
/* 1574 */         t = getTrainingSet();
/* 1575 */         if (t.isEmpty()) { EasyNeuronsApplicationView.this.updateProjectTree();
/*      */         } else {
/* 1577 */           t.setLabel("Backpropagation Sample Training Set");
/* 1578 */           EasyNeuronsApplicationView.this.easyNeuronsProject.addTrainingSet(t);
/* 1579 */           EasyNeuronsApplicationView.this.updateProjectTree();
/*      */         }
/*      */         
/*      */       }
/* 1583 */     };
/* 1584 */     PerceptronSampleTrainingSet pst = new PerceptronSampleTrainingSet();
/* 1585 */     pst.addObserver(trainingSet);
/* 1586 */     pst.addObserver(markovNeuralNet);
/*      */     
/* 1588 */     NeuralNetwork nnet = markovNeuralNet.getNnet();
/* 1589 */     nnet.setLearningRule(new org.neuroph.nnet.learning.BackPropagation());
/*      */     
/* 1591 */     TrainingSet ts = trainingSet.getTrainingSet();
/*      */     
/* 1593 */     BackpropagationSample backpropagationVisualizer = new BackpropagationSample(pst);
/*      */     
/* 1595 */     backpropagationVisualizer.setVisible(true);
/* 1596 */     this.desktopPanel.add(backpropagationVisualizer);
/*      */     try
/*      */     {
/* 1599 */       backpropagationVisualizer.setSelected(true);
/*      */     }
/*      */     catch (PropertyVetoException e) {}
/* 1602 */     showMessage("Started Multi Layer Perceptron with Backpropagation Sample");
/*      */   }
/*      */   
/*      */ 
/*      */   private JMenuItem jMenuItem1;
/*      */   
/*      */   private JMenuItem jMenuItem2;
/*      */   
/*      */   private JMenuItem jMenuItem3;
/*      */   
/*      */   private JMenuItem jMenuItem4;
/*      */   
/*      */   private JMenuItem jMenuItem6;
/*      */   
/*      */   private JMenuItem jMenuItem7;
/*      */   
/*      */   private JScrollPane jScrollPane1;
/*      */   
/*      */   private JSeparator jSeparator1;
/*      */   
/*      */   private JSplitPane jSplitPane1;
/*      */   
/*      */   private JSplitPane jSplitPane2;
/*      */   
/*      */   private JToolBar jToolBar1;
/*      */   
/*      */   private JMenuItem kohonenMenuItem;
/*      */   
/*      */   private JPanel mainPanel;
/*      */   
/*      */   private JMenuItem maxnetMenuItem;
/*      */   private JMenuBar menuBar;
/*      */   private JTextArea messageBox;
/*      */   private JMenuItem mlpMenuItem;
/*      */   private JMenu networksMenu;
/*      */   private JButton newTrainingSetButton;
/*      */   private JButton openButton;
/*      */   private JMenuItem openMenuItem;
/*      */   private JMenuItem outstarMenuItem;
/*      */   private JMenuItem perceptronMenuItem;
/*      */   private JProgressBar progressBar;
/*      */   private JTree projectTree;
/*      */   private JScrollPane projectTreeScrollPane;
/*      */   private JMenuItem rbfMenuItem;
/*      */   private JMenuItem removeMenuItem;
/*      */   private JMenuItem renameMenuItem;
/*      */   private JMenuItem sampleBackpropMenuItem;
/*      */   private JMenuItem sampleBasicNeuron;
/*      */   private JMenuItem sampleKohonenMenuItem;
/*      */   private JMenuItem sampleNFRMenuItem;
/*      */   private JMenuItem samplePerceptronMenuItem;
/*      */   private JMenuItem sampleRecommenderMenuItem;
/*      */   private JMenu samplesMenu;
/*      */   private JMenuItem saveAsMenuItem;
/*      */   private JButton saveButton;
/*      */   private JMenuItem saveMenuItem;
/*      */   private JLabel statusAnimationLabel;
/*      */   private JLabel statusMessageLabel;
/*      */   private JPanel statusPanel;
/*      */   private JMenuItem supervisedHebbianMenuItem;
/*      */   private JMenu toolsMenu;
/*      */   private JMenuItem trainMenuItem;
/*      */   private JMenu trainingMenu;
/*      */   private JMenuItem trainingSetWizardMenuItem;
/*      */   private JPopupMenu treePopupMenu;
/*      */   private JMenuItem unsupervisedHebbianMenuItem;
/*      */   private JMenuItem viewBlockMenuItem;
/*      */   private JMenuItem viewGraphMenuItem;
/*      */   private JMenu viewMenu;
/*      */   private JMenuItem viewRefreshMenuItem;
/*      */   private final Timer messageTimer;
/*      */   private final Timer busyIconTimer;
/*      */   private final Icon idleIcon;
/* 1675 */   private final Icon[] busyIcons = new Icon[15];
/* 1676 */   private int busyIconIndex = 0;
/*      */   private JDialog aboutBox;
/*      */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\EasyNeuronsApplicationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */