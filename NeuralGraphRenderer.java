/*      */ package org.neuroph.easyneurons;
/*      */ 
/*      */ import edu.uci.ics.jung.algorithms.layout.CircleLayout;
/*      */ import edu.uci.ics.jung.algorithms.layout.DAGLayout;
/*      */ import edu.uci.ics.jung.algorithms.layout.FRLayout;
/*      */ import edu.uci.ics.jung.algorithms.layout.GraphElementAccessor;
/*      */ import edu.uci.ics.jung.algorithms.layout.KKLayout;
/*      */ import edu.uci.ics.jung.algorithms.layout.Layout;
/*      */ import edu.uci.ics.jung.algorithms.layout.StaticLayout;
/*      */ import edu.uci.ics.jung.algorithms.layout.TreeLayout;
/*      */ import edu.uci.ics.jung.algorithms.util.SelfLoopEdgePredicate;
/*      */ import edu.uci.ics.jung.graph.DirectedSparseGraph;
/*      */ import edu.uci.ics.jung.graph.Graph;
/*      */ import edu.uci.ics.jung.graph.util.Context;
/*      */ import edu.uci.ics.jung.graph.util.EdgeType;
/*      */ import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
/*      */ import edu.uci.ics.jung.visualization.MultiLayerTransformer;
/*      */ import edu.uci.ics.jung.visualization.RenderContext;
/*      */ import edu.uci.ics.jung.visualization.VisualizationViewer;
/*      */ import edu.uci.ics.jung.visualization.control.AbstractPopupGraphMousePlugin;
/*      */ import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
/*      */ import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
/*      */ import edu.uci.ics.jung.visualization.control.ScalingControl;
/*      */ import edu.uci.ics.jung.visualization.decorators.AbstractVertexShapeTransformer;
/*      */ import edu.uci.ics.jung.visualization.decorators.EdgeShape.CubicCurve;
/*      */ import edu.uci.ics.jung.visualization.decorators.EdgeShape.Line;
/*      */ import edu.uci.ics.jung.visualization.decorators.EdgeShape.QuadCurve;
/*      */ import edu.uci.ics.jung.visualization.decorators.GradientEdgePaintTransformer;
/*      */ import edu.uci.ics.jung.visualization.layout.LayoutTransition;
/*      */ import edu.uci.ics.jung.visualization.picking.PickedInfo;
/*      */ import edu.uci.ics.jung.visualization.picking.PickedState;
/*      */ import edu.uci.ics.jung.visualization.util.Animator;
/*      */ import edu.uci.ics.jung.visualization.util.VertexShapeFactory;
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Color;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.GradientPaint;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Insets;
/*      */ import java.awt.LayoutManager;
/*      */ import java.awt.Paint;
/*      */ import java.awt.Point;
/*      */ import java.awt.Shape;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseListener;
/*      */ import java.awt.geom.Point2D;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.NumberFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.Vector;
/*      */ import javax.swing.AbstractButton;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.Box;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import org.apache.commons.collections15.Predicate;
/*      */ import org.apache.commons.collections15.Transformer;
/*      */ import org.apache.commons.collections15.functors.ConstantTransformer;
/*      */ import org.neuroph.core.Connection;
/*      */ import org.neuroph.core.Layer;
/*      */ import org.neuroph.core.NeuralNetwork;
/*      */ import org.neuroph.core.Neuron;
/*      */ import org.neuroph.core.Weight;
/*      */ import org.neuroph.easyneurons.view.KohonenLayout;
/*      */ import org.neuroph.easyneurons.view.NetworkLayout;
/*      */ import org.neuroph.easyneurons.view.RowLayersLayout;
/*      */ import org.neuroph.easyneurons.view.SquareLayersLayout;
/*      */ import org.neuroph.util.NeuralNetworkType;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NeuralGraphRenderer
/*      */   implements ActionListener
/*      */ {
/*      */   protected JCheckBox v_color;
/*      */   protected JCheckBox e_color;
/*      */   protected JCheckBox v_stroke;
/*      */   protected JCheckBox e_uarrow_pred;
/*      */   protected JCheckBox e_darrow_pred;
/*      */   protected JCheckBox v_shape;
/*      */   protected JCheckBox v_size;
/*      */   protected JCheckBox v_aspect;
/*      */   protected JCheckBox v_labels;
/*      */   protected JRadioButton e_line;
/*      */   protected JRadioButton e_bent;
/*      */   protected JRadioButton e_wedge;
/*      */   protected JRadioButton e_quad;
/*      */   protected JRadioButton e_cubic;
/*      */   protected JCheckBox e_labels;
/*      */   protected JCheckBox font;
/*      */   protected JCheckBox e_show_d;
/*      */   protected JCheckBox e_show_u;
/*      */   protected JCheckBox v_small;
/*      */   protected JCheckBox zoom_at_mouse;
/*      */   protected JCheckBox fill_edges;
/*      */   protected JRadioButton layout_FR;
/*      */   protected JRadioButton layout_KK;
/*      */   protected JRadioButton layout_Circle;
/*      */   protected JComboBox layoutCombo;
/*      */   protected JRadioButton no_gradient;
/*      */   protected JRadioButton gradient_relative;
/*      */   protected static final int GRADIENT_NONE = 0;
/*      */   protected static final int GRADIENT_RELATIVE = 1;
/*  193 */   protected static int gradient_level = 0;
/*      */   
/*      */   protected SeedFillColor<Neuron> seedFillColor;
/*      */   
/*      */   protected SeedDrawColor<Neuron> seedDrawColor;
/*      */   
/*      */   protected EdgeWeightStrokeFunction<Connection> ewcs;
/*      */   protected VertexStrokeHighlight<Neuron, Connection> vsh;
/*      */   protected Transformer<Neuron, String> vs;
/*      */   protected Transformer<Neuron, String> vs_none;
/*      */   protected Transformer<Connection, String> es;
/*      */   protected Transformer<Connection, String> es_none;
/*      */   protected VertexFontTransformer<Neuron> vff;
/*      */   protected EdgeFontTransformer<Connection> eff;
/*      */   protected VertexShapeSizeAspect<Neuron, Connection> vssa;
/*      */   protected DirectionDisplayPredicate<Neuron, Connection> show_edge;
/*      */   protected DirectionDisplayPredicate<Neuron, Connection> show_arrow;
/*      */   protected VertexDisplayPredicate<Neuron, Connection> show_vertex;
/*      */   protected Predicate<Context<Graph<Neuron, Connection>, Connection>> self_loop;
/*      */   protected GradientPickedEdgePaintFunction<Neuron, Connection> edgeDrawPaint;
/*      */   protected GradientPickedEdgePaintFunction<Neuron, Connection> edgeFillPaint;
/*  214 */   protected static final Object ACTIVATION_KEY = "neuron_activation";
/*  215 */   protected static final Object WEIGHT_KEY = "connection_weight";
/*      */   
/*  217 */   protected static final Object TRANSPARENCY = "transparency";
/*      */   
/*      */   protected VisualizationViewer vv;
/*      */   protected DefaultModalGraphMouse<Neuron, Connection> graphMouse;
/*  221 */   protected Set<Neuron> seedVertices = new HashSet();
/*      */   
/*      */   protected Transformer affineTransformer;
/*      */   
/*      */   protected Transformer<Neuron, Double> voltages;
/*      */   
/*  227 */   protected Map<Neuron, Connection> transparency = new HashMap();
/*  228 */   protected Map<Connection, Number> edge_weight = new HashMap();
/*      */   
/*      */   protected Graph<Neuron, Connection> graph;
/*      */   
/*      */   protected NeuralNetwork neuralNet;
/*      */   
/*      */   protected JPanel graphPanel;
/*      */   protected Layout<Neuron, Connection> layout;
/*      */   protected Transformer<Neuron, Point2D> staticTranformer;
/*      */   private NetworkLayout netLayout;
/*      */   
/*      */   public NeuralGraphRenderer(NeuralNetwork neuralNet)
/*      */   {
/*  241 */     this.neuralNet = neuralNet;
/*      */     
/*  243 */     this.v_labels = new JCheckBox("show activation levels");
/*  244 */     this.v_labels.addActionListener(this);
/*      */     
/*  246 */     this.e_labels = new JCheckBox("show weights");
/*  247 */     this.e_labels.addActionListener(this);
/*      */     
/*  249 */     this.staticTranformer = new Transformer() {
/*  250 */       int layerY = 70;
/*      */       
/*      */ 
/*      */ 
/*      */       public Point2D transform(Neuron n)
/*      */       {
/*  256 */         Dimension size = NeuralGraphRenderer.this.layout.getSize();
/*  257 */         int x = size.width / 2;
/*  258 */         int y = this.layerY;
/*      */         
/*  260 */         Layer parentLayer = n.getParentLayer();
/*  261 */         int parentLayerSize = parentLayer.getNeuronsCount();
/*  262 */         int neuronIdx = parentLayer.indexOf(n);
/*  263 */         int layerIdx = parentLayer.getParentNetwork().indexOf(parentLayer);
/*  264 */         int layerLayout = NeuralGraphRenderer.this.netLayout.getLayerLayout(layerIdx);
/*      */         
/*  266 */         y = (layerIdx + 1) * 70;
/*      */         
/*  268 */         if (layerLayout == 1) {
/*  269 */           if (parentLayerSize % 2 != 0) {
/*  270 */             if (neuronIdx <= parentLayerSize / 2) {
/*  271 */               x = size.width / 2 - 70 * (parentLayerSize / 2 - neuronIdx) - 35;
/*      */             } else {
/*  273 */               x = size.width / 2 + 70 * (neuronIdx - parentLayerSize / 2 - 1) + 35;
/*      */             }
/*      */           }
/*  276 */           else if (neuronIdx < parentLayerSize / 2) {
/*  277 */             x = size.width / 2 - 70 * (parentLayerSize / 2 - neuronIdx);
/*      */           } else {
/*  279 */             x = size.width / 2 + 70 * (neuronIdx - parentLayerSize / 2);
/*      */           }
/*      */           
/*      */ 
/*  283 */           if (y > this.layerY) this.layerY = y;
/*      */         }
/*      */         else {
/*  286 */           int rowNeurons = (int)Math.sqrt(parentLayerSize);
/*  287 */           y = this.layerY + (neuronIdx / rowNeurons + 1) * 70;
/*      */           
/*  289 */           if (rowNeurons % 2 != 0) {
/*  290 */             if (neuronIdx % rowNeurons % 2 <= rowNeurons / 2) {
/*  291 */               x = size.width / 2 - 70 * (rowNeurons / 2 - neuronIdx % rowNeurons) - 35;
/*      */             } else {
/*  293 */               x = size.width / 2 + 70 * (rowNeurons / 2 - neuronIdx % rowNeurons) - 35;
/*      */             }
/*      */           }
/*  296 */           else if (neuronIdx % rowNeurons % 2 <= rowNeurons / 2) {
/*  297 */             x = size.width / 2 - 70 * (rowNeurons / 2 - neuronIdx % rowNeurons);
/*      */           } else {
/*  299 */             x = size.width / 2 + 70 * (rowNeurons / 2 - neuronIdx % rowNeurons);
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  304 */         Point2D neuronLocation = new Point(x, y);
/*  305 */         return neuronLocation;
/*      */       }
/*      */       
/*  308 */     };
/*  309 */     this.graph = createGraph();
/*  310 */     this.layout = new StaticLayout(this.graph, this.staticTranformer);
/*      */     try
/*      */     {
/*  313 */       this.vv = new VisualizationViewer(this.layout);
/*      */     } catch (Exception ex) {
/*  315 */       ex.printStackTrace();
/*      */     }
/*  317 */     createGraphPanel();
/*      */   }
/*      */   
/*      */   public JPanel getGraphPanel() {
/*  321 */     return this.graphPanel;
/*      */   }
/*      */   
/*      */   public void createGraphPanel() {
/*  325 */     this.graph = createGraph();
/*      */     
/*  327 */     setNetLayout(this.neuralNet.getNetworkType());
/*      */     
/*      */ 
/*  330 */     this.layout = new StaticLayout(this.graph, this.staticTranformer);
/*  331 */     this.vv = new VisualizationViewer(this.layout);
/*      */     
/*      */ 
/*      */ 
/*  335 */     PickedState<Neuron> picked_state = this.vv.getPickedVertexState();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  340 */     this.seedFillColor = new SeedFillColor(picked_state);
/*  341 */     this.seedDrawColor = new SeedDrawColor(picked_state);
/*  342 */     this.ewcs = new EdgeWeightStrokeFunction(this.edge_weight);
/*      */     
/*  344 */     this.vsh = new VertexStrokeHighlight(this.graph, picked_state);
/*  345 */     this.vff = new VertexFontTransformer(null);
/*  346 */     this.eff = new EdgeFontTransformer(null);
/*  347 */     this.vs_none = new ConstantTransformer(null);
/*  348 */     this.es_none = new ConstantTransformer(null);
/*  349 */     this.vssa = new VertexShapeSizeAspect(this.graph, this.voltages);
/*  350 */     this.show_edge = new DirectionDisplayPredicate(true, true);
/*  351 */     this.show_arrow = new DirectionDisplayPredicate(true, false);
/*  352 */     this.show_vertex = new VertexDisplayPredicate(false);
/*      */     
/*  354 */     this.vv.getRenderContext().setVertexFontTransformer(this.vff);
/*  355 */     this.vv.getRenderContext().setVertexShapeTransformer(this.vssa);
/*  356 */     this.vv.getRenderContext().setVertexStrokeTransformer(this.vsh);
/*      */     
/*  358 */     this.vv.getRenderContext().setEdgeFontTransformer(this.eff);
/*  359 */     this.vv.getRenderContext().setEdgeStrokeTransformer(this.ewcs);
/*      */     
/*  361 */     this.vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
/*      */     
/*  363 */     this.graphPanel = new JPanel();
/*  364 */     this.graphPanel.setLayout(new BorderLayout());
/*      */     
/*  366 */     this.vv.setBackground(Color.white);
/*      */     
/*  368 */     GraphZoomScrollPane scrollPane = new GraphZoomScrollPane(this.vv);
/*  369 */     scrollPane.setPreferredSize(new Dimension(930, 400));
/*  370 */     this.graphPanel.add(scrollPane);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  378 */     this.graphMouse = new DefaultModalGraphMouse();
/*  379 */     this.vv.setGraphMouse(this.graphMouse);
/*  380 */     this.graphMouse.add(new PopupGraphMousePlugin());
/*      */     
/*  382 */     this.vssa.setScaling(false);
/*      */     
/*  384 */     this.vv.setVertexToolTipTransformer(new VoltageTips());
/*  385 */     addControls(this.graphPanel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Graph createGraph()
/*      */   {
/*  394 */     Graph<Neuron, Connection> g = new DirectedSparseGraph();
/*      */     
/*  396 */     Iterator<Layer> li = this.neuralNet.getLayersIterator();
/*  397 */     while (li.hasNext()) {
/*  398 */       Layer l = (Layer)li.next();
/*  399 */       Iterator<Neuron> ni = l.getNeuronsIterator();
/*  400 */       while (ni.hasNext()) {
/*  401 */         Neuron neuron = (Neuron)ni.next();
/*  402 */         g.addVertex(neuron);
/*      */         
/*  404 */         Iterator<Connection> ci = neuron.getInputConnections().iterator();
/*  405 */         while (ci.hasNext()) {
/*  406 */           Connection connection = (Connection)ci.next();
/*  407 */           Neuron fromNeuron = connection.getConnectedNeuron();
/*  408 */           g.addEdge(connection, fromNeuron, neuron);
/*      */           
/*      */ 
/*  411 */           this.edge_weight.put(connection, Double.valueOf(connection.getWeight().getValue()));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  416 */     this.voltages = new Transformer()
/*      */     {
/*      */       public Double transform(Neuron n)
/*      */       {
/*  420 */         return Double.valueOf(n.getOutput());
/*      */       }
/*      */       
/*  423 */     };
/*  424 */     this.vs = new Transformer()
/*      */     {
/*      */       public String transform(Neuron n) {
/*  427 */         NumberFormat numberFormat = DecimalFormat.getNumberInstance();
/*  428 */         numberFormat.setMaximumFractionDigits(4);
/*      */         
/*  430 */         return numberFormat.format(n.getOutput());
/*      */       }
/*  432 */     };
/*  433 */     this.es = new Transformer()
/*      */     {
/*      */       public String transform(Connection c) {
/*  436 */         NumberFormat numberFormat = DecimalFormat.getNumberInstance();
/*  437 */         numberFormat.setMaximumFractionDigits(5);
/*      */         
/*  439 */         return numberFormat.format(c.getWeight().getValue());
/*      */       }
/*  441 */     };
/*  442 */     return g;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void addControls(JPanel jp)
/*      */   {
/*  450 */     JPanel control_panel = new JPanel();
/*  451 */     jp.add(control_panel, "East");
/*      */     
/*  453 */     control_panel.setLayout(new GridBagLayout());
/*      */     
/*  455 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  456 */     gridBagConstraints.fill = 2;
/*  457 */     gridBagConstraints.insets = new Insets(5, 5, 0, 5);
/*  458 */     gridBagConstraints.anchor = 17;
/*      */     
/*      */ 
/*      */ 
/*  462 */     Box vertex_panel = Box.createVerticalBox();
/*  463 */     vertex_panel.setBorder(BorderFactory.createTitledBorder("Neurons"));
/*  464 */     Box edge_panel = Box.createVerticalBox();
/*  465 */     edge_panel.setBorder(BorderFactory.createTitledBorder("Connections"));
/*      */     
/*  467 */     Box edges_and_vertex_panel = Box.createVerticalBox();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  477 */     edges_and_vertex_panel.add(vertex_panel);
/*  478 */     edges_and_vertex_panel.add(edge_panel);
/*      */     
/*      */ 
/*  481 */     gridBagConstraints.gridx = 0;
/*  482 */     gridBagConstraints.gridy = 0;
/*  483 */     control_panel.add(edges_and_vertex_panel, gridBagConstraints);
/*      */     
/*  485 */     gridBagConstraints.gridx = 0;
/*  486 */     gridBagConstraints.gridy = 1;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  495 */     this.v_color = new JCheckBox("vertex seed coloring");
/*  496 */     this.v_color.addActionListener(this);
/*      */     
/*      */ 
/*      */ 
/*  500 */     this.v_shape = new JCheckBox("vertex degree shapes");
/*  501 */     this.v_shape.addActionListener(this);
/*  502 */     this.v_size = new JCheckBox("activation size");
/*  503 */     this.v_size.addActionListener(this);
/*  504 */     this.v_size.setSelected(false);
/*  505 */     this.v_aspect = new JCheckBox("vertex degree ratio stretch");
/*  506 */     this.v_aspect.addActionListener(this);
/*  507 */     this.v_small = new JCheckBox("filter vertices of degree < 4");
/*      */     
/*  509 */     this.v_small.addActionListener(this);
/*      */     
/*      */ 
/*      */ 
/*  513 */     vertex_panel.add(this.v_labels);
/*      */     
/*  515 */     vertex_panel.add(this.v_size);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  568 */     this.e_color = new JCheckBox("weight highlighting");
/*  569 */     this.e_color.addActionListener(this);
/*  570 */     this.e_uarrow_pred = new JCheckBox("undirected");
/*  571 */     this.e_uarrow_pred.addActionListener(this);
/*  572 */     this.e_darrow_pred = new JCheckBox("directed");
/*  573 */     this.e_darrow_pred.addActionListener(this);
/*  574 */     this.e_darrow_pred.setSelected(true);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  580 */     this.e_show_d = new JCheckBox("directed");
/*  581 */     this.e_show_d.addActionListener(this);
/*  582 */     this.e_show_d.setSelected(true);
/*  583 */     this.e_show_u = new JCheckBox("undirected");
/*  584 */     this.e_show_u.addActionListener(this);
/*  585 */     this.e_show_u.setSelected(true);
/*  586 */     JPanel show_edge_panel = new JPanel(new GridLayout(1, 0));
/*  587 */     show_edge_panel.setBorder(BorderFactory.createTitledBorder("Show edges"));
/*      */     
/*  589 */     show_edge_panel.add(this.e_show_u);
/*  590 */     show_edge_panel.add(this.e_show_d);
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
/*  601 */     this.e_color.setAlignmentX(0.0F);
/*  602 */     edge_panel.add(this.e_color);
/*  603 */     this.e_labels.setAlignmentX(0.0F);
/*  604 */     edge_panel.add(this.e_labels);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  625 */     this.zoom_at_mouse = new JCheckBox("<html><center>zoom at mouse<p>(wheel only)</center></html>");
/*      */     
/*  627 */     this.zoom_at_mouse.addActionListener(this);
/*      */     
/*  629 */     final ScalingControl scaler = new CrossoverScalingControl();
/*      */     
/*  631 */     JButton plus = new JButton("+");
/*  632 */     plus.addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent e) {
/*  635 */         scaler.scale(NeuralGraphRenderer.this.vv, 1.1F, NeuralGraphRenderer.this.vv.getCenter());
/*      */       }
/*  637 */     });
/*  638 */     JButton minus = new JButton("-");
/*  639 */     minus.addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent e) {
/*  642 */         scaler.scale(NeuralGraphRenderer.this.vv, 0.9090909F, NeuralGraphRenderer.this.vv.getCenter());
/*      */       }
/*      */       
/*  645 */     });
/*  646 */     JPanel zoomPanel = new JPanel();
/*  647 */     zoomPanel.setAlignmentX(1.0F);
/*  648 */     zoomPanel.setBorder(BorderFactory.createTitledBorder("Zoom"));
/*  649 */     zoomPanel.add(plus);
/*  650 */     zoomPanel.add(minus);
/*      */     
/*  652 */     gridBagConstraints.fill = 2;
/*  653 */     gridBagConstraints.insets = new Insets(5, 5, 0, 5);
/*  654 */     gridBagConstraints.anchor = 17;
/*      */     
/*  656 */     gridBagConstraints.gridx = 0;
/*  657 */     gridBagConstraints.gridy = 0;
/*      */     
/*  659 */     JComboBox modeBox = this.graphMouse.getModeComboBox();
/*  660 */     modeBox.setAlignmentX(1.0F);
/*      */     
/*  662 */     JPanel modePanel = new JPanel(new BorderLayout())
/*      */     {
/*      */       public Dimension getMaximumSize() {
/*  665 */         return getPreferredSize();
/*      */       }
/*  667 */     };
/*  668 */     modePanel.setBorder(BorderFactory.createTitledBorder("Mouse Mode"));
/*  669 */     modePanel.add(modeBox);
/*      */     
/*  671 */     gridBagConstraints.gridx = 0;
/*  672 */     gridBagConstraints.gridy = 2;
/*  673 */     control_panel.add(modePanel, gridBagConstraints);
/*      */     
/*  675 */     gridBagConstraints.gridx = 0;
/*  676 */     gridBagConstraints.gridy = 3;
/*  677 */     control_panel.add(zoomPanel, gridBagConstraints);
/*      */     
/*      */ 
/*  680 */     this.font = new JCheckBox("bold text");
/*  681 */     this.font.addActionListener(this);
/*  682 */     gridBagConstraints.gridx = 0;
/*  683 */     gridBagConstraints.gridy = 4;
/*  684 */     control_panel.add(this.font, gridBagConstraints);
/*      */   }
/*      */   
/*      */   private void setNetLayout(NeuralNetworkType type)
/*      */   {
/*  689 */     if (type == null) {
/*  690 */       this.netLayout = new RowLayersLayout();
/*  691 */       return;
/*      */     }
/*      */     
/*  694 */     switch (type) {
/*      */     case ADALINE: 
/*  696 */       this.netLayout = new RowLayersLayout();
/*  697 */       break;
/*      */     case PERCEPTRON: 
/*  699 */       this.netLayout = new RowLayersLayout();
/*  700 */       break;
/*      */     case MULTI_LAYER_PERCEPTRON: 
/*  702 */       this.netLayout = new RowLayersLayout();
/*  703 */       break;
/*      */     case HOPFIELD: 
/*  705 */       this.netLayout = new SquareLayersLayout();
/*  706 */       break;
/*      */     case KOHONEN: 
/*  708 */       this.netLayout = new KohonenLayout();
/*  709 */       break;
/*      */     case NEURO_FUZZY_REASONER: 
/*  711 */       this.netLayout = new RowLayersLayout();
/*  712 */       break;
/*      */     
/*      */     default: 
/*  715 */       this.netLayout = new RowLayersLayout();
/*      */     }
/*      */   }
/*      */   
/*      */   private static Class<?>[] getLayoutOptions()
/*      */   {
/*  721 */     List<Class<?>> layouts = new ArrayList();
/*  722 */     layouts.add(DAGLayout.class);
/*  723 */     layouts.add(KKLayout.class);
/*  724 */     layouts.add(FRLayout.class);
/*  725 */     layouts.add(CircleLayout.class);
/*  726 */     layouts.add(TreeLayout.class);
/*  727 */     return (Class[])layouts.toArray(new Class[0]);
/*      */   }
/*      */   
/*      */   private static final class VertexFontTransformer<V>
/*      */     implements Transformer<V, Font>
/*      */   {
/*  733 */     protected boolean bold = false;
/*  734 */     Font f = new Font("Helvetica", 0, 12);
/*  735 */     Font b = new Font("Helvetica", 1, 12);
/*      */     
/*      */     public void setBold(boolean bold)
/*      */     {
/*  739 */       this.bold = bold;
/*      */     }
/*      */     
/*      */ 
/*      */     public Font transform(V v)
/*      */     {
/*  745 */       if (this.bold) {
/*  746 */         return this.b;
/*      */       }
/*  748 */       return this.f;
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class EdgeFontTransformer<E>
/*      */     implements Transformer<E, Font>
/*      */   {
/*  755 */     protected boolean bold = false;
/*  756 */     Font f = new Font("Helvetica", 0, 12);
/*  757 */     Font b = new Font("Helvetica", 1, 12);
/*      */     
/*      */     public void setBold(boolean bold)
/*      */     {
/*  761 */       this.bold = bold;
/*      */     }
/*      */     
/*      */ 
/*      */     public Font transform(E e)
/*      */     {
/*  767 */       if (this.bold) {
/*  768 */         return this.b;
/*      */       }
/*  770 */       return this.f;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void actionPerformed(ActionEvent e)
/*      */   {
/*  777 */     AbstractButton source = (AbstractButton)e.getSource();
/*      */     
/*  779 */     if (source == this.e_line)
/*      */     {
/*  781 */       if (source.isSelected())
/*      */       {
/*  783 */         this.vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
/*      */       }
/*      */     }
/*  786 */     else if (source == this.e_quad)
/*      */     {
/*  788 */       if (source.isSelected())
/*      */       {
/*  790 */         this.vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.QuadCurve());
/*      */       }
/*      */     }
/*  793 */     else if (source == this.e_cubic)
/*      */     {
/*  795 */       if (source.isSelected())
/*      */       {
/*  797 */         this.vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.CubicCurve());
/*      */       }
/*      */     }
/*  800 */     else if (source == this.v_labels)
/*      */     {
/*  802 */       if (source.isSelected()) {
/*  803 */         this.vv.getRenderContext().setVertexLabelTransformer(this.vs);
/*      */       } else {
/*  805 */         this.vv.getRenderContext().setVertexLabelTransformer(this.vs_none);
/*      */       }
/*  807 */     } else if (source == this.e_labels)
/*      */     {
/*  809 */       if (source.isSelected()) {
/*  810 */         this.vv.getRenderContext().setEdgeLabelTransformer(this.es);
/*      */       } else {
/*  812 */         this.vv.getRenderContext().setEdgeLabelTransformer(this.es_none);
/*      */       }
/*  814 */     } else if (source == this.font)
/*      */     {
/*  816 */       this.vff.setBold(source.isSelected());
/*  817 */       this.eff.setBold(source.isSelected());
/*      */     }
/*  819 */     else if (source == this.e_color)
/*      */     {
/*  821 */       this.ewcs.setWeighted(source.isSelected());
/*      */     }
/*  823 */     else if (source == this.v_size)
/*      */     {
/*  825 */       this.vssa.setScaling(source.isSelected());
/*      */     }
/*  827 */     else if (source == this.v_stroke)
/*      */     {
/*  829 */       this.vsh.setHighlight(source.isSelected());
/*      */     }
/*  831 */     this.vv.repaint();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected class PopupGraphMousePlugin
/*      */     extends AbstractPopupGraphMousePlugin
/*      */     implements MouseListener
/*      */   {
/*      */     public PopupGraphMousePlugin()
/*      */     {
/*  842 */       this(4);
/*      */     }
/*      */     
/*  845 */     public PopupGraphMousePlugin(int modifiers) { super(); }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     protected void handlePopup(MouseEvent e)
/*      */     {
/*  857 */       VisualizationViewer<Neuron, Connection> vv = (VisualizationViewer)e.getSource();
/*      */       
/*  859 */       Point2D p = e.getPoint();
/*      */       
/*  861 */       GraphElementAccessor<Neuron, Connection> pickSupport = vv.getPickSupport();
/*      */     }
/*      */   }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static final class VertexShapeSizeAspect<V, E>
/*      */     extends AbstractVertexShapeTransformer<V>
/*      */     implements Transformer<V, Shape>
/*      */   {
/*  916 */     protected boolean stretch = false;
/*  917 */     protected boolean scale = false;
/*  918 */     protected boolean funny_shapes = false;
/*      */     
/*      */     protected Transformer<V, Double> voltages;
/*      */     protected Graph<V, E> graph;
/*      */     
/*      */     public VertexShapeSizeAspect(Graph<V, E> graphIn, Transformer<V, Double> voltagesIn)
/*      */     {
/*  925 */       this.graph = graphIn;
/*  926 */       this.voltages = voltagesIn;
/*  927 */       setSizeTransformer(new Transformer()
/*      */       {
/*      */         public Integer transform(V v) {
/*  930 */           if (NeuralGraphRenderer.VertexShapeSizeAspect.this.scale) {
/*  931 */             return Integer.valueOf((int)(((Double)NeuralGraphRenderer.VertexShapeSizeAspect.this.voltages.transform(v)).doubleValue() * 30.0D) + 20);
/*      */           }
/*  933 */           return Integer.valueOf(20);
/*      */         }
/*  935 */       });
/*  936 */       setAspectRatioTransformer(new Transformer()
/*      */       {
/*      */         public Float transform(V v) {
/*  939 */           if (NeuralGraphRenderer.VertexShapeSizeAspect.this.stretch) {
/*  940 */             return Float.valueOf((NeuralGraphRenderer.VertexShapeSizeAspect.this.graph.inDegree(v) + 1) / (NeuralGraphRenderer.VertexShapeSizeAspect.this.graph.outDegree(v) + 1));
/*      */           }
/*      */           
/*  943 */           return Float.valueOf(1.0F);
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*      */     public void setStretching(boolean stretch)
/*      */     {
/*  950 */       this.stretch = stretch;
/*      */     }
/*      */     
/*      */     public void setScaling(boolean scale)
/*      */     {
/*  955 */       this.scale = scale;
/*      */     }
/*      */     
/*      */     public void useFunnyShapes(boolean use)
/*      */     {
/*  960 */       this.funny_shapes = use;
/*      */     }
/*      */     
/*      */ 
/*      */     public Shape transform(V v)
/*      */     {
/*  966 */       if (this.funny_shapes)
/*      */       {
/*  968 */         if (this.graph.degree(v) < 5)
/*      */         {
/*  970 */           int sides = Math.max(this.graph.degree(v), 3);
/*  971 */           return this.factory.getRegularPolygon(v, sides);
/*      */         }
/*      */         
/*  974 */         return this.factory.getRegularStar(v, this.graph.degree(v));
/*      */       }
/*      */       
/*  977 */       return this.factory.getEllipse(v);
/*      */     }
/*      */   }
/*      */   
/*      */   private final class SeedFillColor<V> implements Transformer<V, Paint>
/*      */   {
/*      */     protected PickedInfo<V> pi;
/*      */     protected static final float dark_value = 0.8F;
/*      */     protected static final float light_value = 0.2F;
/*      */     protected boolean seed_coloring;
/*      */     
/*      */     public SeedFillColor()
/*      */     {
/*  990 */       this.pi = pi;
/*  991 */       this.seed_coloring = false;
/*      */     }
/*      */     
/*      */     public void setSeedColoring(boolean b)
/*      */     {
/*  996 */       this.seed_coloring = b;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Paint transform(V v)
/*      */     {
/* 1007 */       float alpha = (float)((Connection)NeuralGraphRenderer.this.transparency.get(v)).getWeight().getValue();
/* 1008 */       if (this.pi.isPicked(v))
/*      */       {
/* 1010 */         return new Color(1.0F, 1.0F, 0.0F, alpha);
/*      */       }
/*      */       
/*      */ 
/* 1014 */       if ((this.seed_coloring) && (NeuralGraphRenderer.this.seedVertices.contains(v)))
/*      */       {
/* 1016 */         Color dark = new Color(0.0F, 0.0F, 0.8F, alpha);
/* 1017 */         Color light = new Color(0.0F, 0.0F, 0.2F, alpha);
/* 1018 */         return new GradientPaint(0.0F, 0.0F, dark, 10.0F, 0.0F, light, true);
/*      */       }
/*      */       
/* 1021 */       return new Color(1.0F, 0.0F, 0.0F, alpha);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static final class EdgeWeightStrokeFunction<E>
/*      */     implements Transformer<E, Stroke>
/*      */   {
/* 1030 */     protected static final Stroke basic = new BasicStroke(1.0F);
/* 1031 */     protected static final Stroke heavy = new BasicStroke(2.0F);
/* 1032 */     protected static final Stroke dotted = RenderContext.DOTTED;
/*      */     
/* 1034 */     protected boolean weighted = false;
/*      */     protected Map<E, Number> edge_weight;
/*      */     
/*      */     public EdgeWeightStrokeFunction(Map<E, Number> edge_weight)
/*      */     {
/* 1039 */       this.edge_weight = edge_weight;
/*      */     }
/*      */     
/*      */     public void setWeighted(boolean weighted)
/*      */     {
/* 1044 */       this.weighted = weighted;
/*      */     }
/*      */     
/*      */ 
/*      */     public Stroke transform(E e)
/*      */     {
/* 1050 */       if (this.weighted)
/*      */       {
/* 1052 */         if (drawHeavy(e)) {
/* 1053 */           return heavy;
/*      */         }
/* 1055 */         return dotted;
/*      */       }
/*      */       
/* 1058 */       return basic;
/*      */     }
/*      */     
/*      */     protected boolean drawHeavy(E e)
/*      */     {
/* 1063 */       double value = ((Number)this.edge_weight.get(e)).doubleValue();
/* 1064 */       if (value > 0.7D) {
/* 1065 */         return true;
/*      */       }
/* 1067 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static final class VertexStrokeHighlight<V, E>
/*      */     implements Transformer<V, Stroke>
/*      */   {
/* 1075 */     protected boolean highlight = false;
/* 1076 */     protected Stroke heavy = new BasicStroke(5.0F);
/* 1077 */     protected Stroke medium = new BasicStroke(3.0F);
/* 1078 */     protected Stroke light = new BasicStroke(1.0F);
/*      */     protected PickedInfo<V> pi;
/*      */     protected Graph<V, E> graph;
/*      */     
/*      */     public VertexStrokeHighlight(Graph<V, E> graph, PickedInfo<V> pi)
/*      */     {
/* 1084 */       this.graph = graph;
/* 1085 */       this.pi = pi;
/*      */     }
/*      */     
/*      */     public void setHighlight(boolean highlight)
/*      */     {
/* 1090 */       this.highlight = highlight;
/*      */     }
/*      */     
/*      */ 
/*      */     public Stroke transform(V v)
/*      */     {
/* 1096 */       if (this.highlight)
/*      */       {
/* 1098 */         if (this.pi.isPicked(v)) {
/* 1099 */           return this.heavy;
/*      */         }
/*      */         
/* 1102 */         for (V w : this.graph.getNeighbors(v))
/*      */         {
/*      */ 
/*      */ 
/* 1106 */           if (this.pi.isPicked(w))
/* 1107 */             return this.medium;
/*      */         }
/* 1109 */         return this.light;
/*      */       }
/*      */       
/*      */ 
/* 1113 */       return this.light;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static final class DirectionDisplayPredicate<V, E>
/*      */     implements Predicate<Context<Graph<V, E>, E>>
/*      */   {
/*      */     protected boolean show_d;
/*      */     
/*      */     protected boolean show_u;
/*      */     
/*      */ 
/*      */     public DirectionDisplayPredicate(boolean show_d, boolean show_u)
/*      */     {
/* 1129 */       this.show_d = show_d;
/* 1130 */       this.show_u = show_u;
/*      */     }
/*      */     
/*      */     public void showDirected(boolean b)
/*      */     {
/* 1135 */       this.show_d = b;
/*      */     }
/*      */     
/*      */     public void showUndirected(boolean b)
/*      */     {
/* 1140 */       this.show_u = b;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean evaluate(Context<Graph<V, E>, E> context)
/*      */     {
/* 1146 */       Graph<V, E> graph = (Graph)context.graph;
/* 1147 */       E e = context.element;
/* 1148 */       if ((graph.getEdgeType(e) == EdgeType.DIRECTED) && (this.show_d)) {
/* 1149 */         return true;
/*      */       }
/* 1151 */       if ((graph.getEdgeType(e) == EdgeType.UNDIRECTED) && (this.show_u)) {
/* 1152 */         return true;
/*      */       }
/* 1154 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static final class VertexDisplayPredicate<V, E>
/*      */     implements Predicate<Context<Graph<V, E>, V>>
/*      */   {
/*      */     protected boolean filter_small;
/*      */     protected static final int MIN_DEGREE = 4;
/*      */     
/*      */     public VertexDisplayPredicate(boolean filter)
/*      */     {
/* 1167 */       this.filter_small = filter;
/*      */     }
/*      */     
/*      */     public void filterSmall(boolean b)
/*      */     {
/* 1172 */       this.filter_small = b;
/*      */     }
/*      */     
/*      */     public boolean evaluate(Context<Graph<V, E>, V> context)
/*      */     {
/* 1177 */       Graph<V, E> graph = (Graph)context.graph;
/* 1178 */       V v = context.element;
/*      */       
/* 1180 */       if (this.filter_small) {
/* 1181 */         return graph.degree(v) >= 4;
/*      */       }
/* 1183 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   private final class SeedDrawColor<V> implements Transformer<V, Paint>
/*      */   {
/*      */     protected PickedInfo<V> pi;
/*      */     protected static final float dark_value = 0.8F;
/*      */     protected static final float light_value = 0.2F;
/*      */     protected boolean seed_coloring;
/*      */     
/*      */     public SeedDrawColor()
/*      */     {
/* 1196 */       this.pi = pi;
/* 1197 */       this.seed_coloring = false;
/*      */     }
/*      */     
/*      */     public void setSeedColoring(boolean b)
/*      */     {
/* 1202 */       this.seed_coloring = b;
/*      */     }
/*      */     
/*      */ 
/*      */     public Paint transform(V v)
/*      */     {
/* 1208 */       return Color.BLACK;
/*      */     }
/*      */   }
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
/*      */   public class GradientPickedEdgePaintFunction<V, E>
/*      */     extends GradientEdgePaintTransformer<V, E>
/*      */   {
/*      */     private Transformer<E, Paint> defaultFunc;
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
/* 1236 */     protected boolean fill_edge = false;
/* 1237 */     Predicate<Context<Graph<V, E>, E>> selfLoop = new SelfLoopEdgePredicate();
/*      */     
/*      */ 
/*      */     public GradientPickedEdgePaintFunction(VisualizationViewer<V, E> defaultEdgePaintFunction)
/*      */     {
/* 1242 */       super(Color.BLACK, vv);
/* 1243 */       this.defaultFunc = defaultEdgePaintFunction;
/*      */     }
/*      */     
/*      */     public void useFill(boolean b)
/*      */     {
/* 1248 */       this.fill_edge = b;
/*      */     }
/*      */     
/*      */     public Paint transform(E e)
/*      */     {
/* 1253 */       if (NeuralGraphRenderer.gradient_level == 0) {
/* 1254 */         return (Paint)this.defaultFunc.transform(e);
/*      */       }
/* 1256 */       return super.transform(e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     protected Color getColor2(E e)
/*      */     {
/* 1263 */       return this.vv.getPickedEdgeState().isPicked(e) ? Color.CYAN : this.c2;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public class VoltageTips<E>
/*      */     implements Transformer<Neuron, String>
/*      */   {
/*      */     public VoltageTips() {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public String transform(Neuron vertex)
/*      */     {
/* 1281 */       return "Voltage:" + NeuralGraphRenderer.this.voltages.transform(vertex);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private final class LayoutChooser
/*      */     implements ActionListener
/*      */   {
/*      */     private final JComboBox jcb;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private final VisualizationViewer<Neuron, Connection> vv;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private LayoutChooser(VisualizationViewer<Neuron, Connection> jcb)
/*      */     {
/* 1313 */       this.jcb = jcb;
/* 1314 */       this.vv = vv;
/*      */     }
/*      */     
/*      */ 
/*      */     public void actionPerformed(ActionEvent arg0)
/*      */     {
/* 1320 */       Object[] constructorArgs = { NeuralGraphRenderer.this.graph };
/*      */       
/* 1322 */       Class<? extends Layout<Neuron, Connection>> layoutC = (Class)this.jcb.getSelectedItem();
/*      */       
/*      */ 
/*      */       try
/*      */       {
/* 1327 */         Constructor<? extends Layout<Neuron, Connection>> constructor = layoutC.getConstructor(new Class[] { Graph.class });
/*      */         
/* 1329 */         Object o = constructor.newInstance(constructorArgs);
/* 1330 */         Layout<Neuron, Connection> l = (Layout)o;
/* 1331 */         l.setInitializer(this.vv.getGraphLayout());
/* 1332 */         l.setSize(this.vv.getSize());
/*      */         
/* 1334 */         LayoutTransition<Neuron, Connection> lt = new LayoutTransition(this.vv, this.vv.getGraphLayout(), l);
/*      */         
/* 1336 */         Animator animator = new Animator(lt);
/* 1337 */         animator.start();
/* 1338 */         this.vv.getRenderContext().getMultiLayerTransformer().setToIdentity();
/* 1339 */         this.vv.repaint();
/*      */ 
/*      */       }
/*      */       catch (Exception e)
/*      */       {
/* 1344 */         e.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\NeuralGraphRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */