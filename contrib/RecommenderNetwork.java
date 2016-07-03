/*     */ package org.neuroph.contrib;
/*     */ 
/*     */ import java.util.Vector;
/*     */ import org.neuroph.core.Layer;
/*     */ import org.neuroph.core.NeuralNetwork;
/*     */ import org.neuroph.core.Neuron;
/*     */ import org.neuroph.nnet.learning.UnsupervisedHebbianLearning;
/*     */ import org.neuroph.util.LayerFactory;
/*     */ import org.neuroph.util.NeuralNetworkFactory;
/*     */ import org.neuroph.util.NeuralNetworkType;
/*     */ import org.neuroph.util.NeuronProperties;
/*     */ import org.neuroph.util.TransferFunctionType;
/*     */ import org.neuroph.util.plugins.LabelsPlugin;
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
/*     */ public class RecommenderNetwork
/*     */   extends NeuralNetwork
/*     */ {
/*  42 */   int outputLayerIdx = 5; int promoLayerIdx = 4; int priceLayerIdx = 3; int brandLayerIdx = 2; int typeLayerIdx = 1; int inputLayerIdx = 0;
/*     */   
/*     */ 
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */ 
/*     */   public RecommenderNetwork()
/*     */   {
/*  50 */     for (int i = 0; i < 6; i++) {
/*  51 */       addLayer(new Layer());
/*     */     }
/*     */   }
/*     */   
/*     */   public void createDemoNetwork() {
/*  56 */     int productsCount = 20;
/*  57 */     int typesCount = 3;
/*  58 */     int brandsCount = 3;
/*  59 */     int priceCount = 3;
/*  60 */     int promoCount = 3;
/*     */     
/*  62 */     setNetworkType(NeuralNetworkType.RECOMMENDER);
/*  63 */     getLayers().clear();
/*     */     
/*  65 */     NeuronProperties neuronProperties = new NeuronProperties();
/*  66 */     neuronProperties.setProperty("transferFunction", TransferFunctionType.RAMP);
/*     */     
/*  68 */     neuronProperties.setProperty("transferFunction.slope", new Double(1.0D));
/*     */     
/*     */ 
/*  71 */     Layer inputLayer = LayerFactory.createLayer(productsCount, neuronProperties);
/*     */     
/*  73 */     addLayer(inputLayer);
/*  74 */     createProductLabels(inputLayer);
/*     */     
/*     */ 
/*     */ 
/*  78 */     Layer typeLayer = LayerFactory.createLayer(typesCount, neuronProperties);
/*     */     
/*  80 */     createTypeLabels(typeLayer);
/*  81 */     addLayer(typeLayer);
/*     */     
/*     */ 
/*     */ 
/*  85 */     Layer brandLayer = LayerFactory.createLayer(brandsCount, neuronProperties);
/*     */     
/*  87 */     createBrandLabels(brandLayer);
/*  88 */     addLayer(brandLayer);
/*     */     
/*     */ 
/*     */ 
/*  92 */     Layer priceLayer = LayerFactory.createLayer(priceCount, neuronProperties);
/*  93 */     createPriceLabels(priceLayer);
/*  94 */     addLayer(priceLayer);
/*     */     
/*     */ 
/*  97 */     Layer promoLayer = LayerFactory.createLayer(promoCount, neuronProperties);
/*  98 */     createPromoLabels(promoLayer);
/*  99 */     addLayer(promoLayer);
/*     */     
/*     */ 
/* 102 */     Layer outputLayer = LayerFactory.createLayer(productsCount, neuronProperties);
/*     */     
/* 104 */     addLayer(outputLayer);
/* 105 */     createProductLabels(outputLayer);
/*     */     
/* 107 */     createTypeConnections();
/* 108 */     createBrandConnections();
/* 109 */     createPriceConnections();
/* 110 */     createPromoConnections();
/*     */     
/*     */ 
/*     */ 
/* 114 */     for (Neuron neuron : getLayerAt(this.outputLayerIdx).getNeurons()) {
/* 115 */       neuron.addInputConnection(neuron, 1.0D);
/*     */     }
/*     */     
/*     */ 
/* 119 */     NeuralNetworkFactory.setDefaultIO(this);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */     setLearningRule(new UnsupervisedHebbianLearning(this));
/*     */   }
/*     */   
/*     */   private void createTypeConnections()
/*     */   {
/* 130 */     for (int i = 0; i < 7; i++) {
/* 131 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(i);
/* 132 */       Neuron toNeuron = getLayerAt(this.typeLayerIdx).getNeuronAt(0);
/* 133 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 137 */     for (int i = 7; i < 14; i++) {
/* 138 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(i);
/* 139 */       Neuron toNeuron = getLayerAt(this.typeLayerIdx).getNeuronAt(1);
/* 140 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 144 */     for (int i = 14; i < 20; i++) {
/* 145 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(i);
/* 146 */       Neuron toNeuron = getLayerAt(this.typeLayerIdx).getNeuronAt(2);
/* 147 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 152 */     for (int i = 0; i < 7; i++) {
/* 153 */       Neuron fromNeuron = getLayerAt(this.typeLayerIdx).getNeuronAt(0);
/* 154 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(i);
/* 155 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 159 */     for (int i = 7; i < 14; i++) {
/* 160 */       Neuron fromNeuron = getLayerAt(this.typeLayerIdx).getNeuronAt(1);
/* 161 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(i);
/* 162 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 166 */     for (int i = 14; i < 20; i++) {
/* 167 */       Neuron fromNeuron = getLayerAt(this.typeLayerIdx).getNeuronAt(2);
/* 168 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(i);
/* 169 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */   }
/*     */   
/*     */   private void createBrandConnections() {
/* 174 */     int[] samsung = { 0, 1, 7, 8, 9, 14, 15 };
/* 175 */     int[] lg = { 2, 3, 10, 11, 16, 17 };
/* 176 */     int[] sony = { 4, 5, 6, 12, 13, 18, 19 };
/*     */     
/*     */ 
/* 179 */     for (int i = 0; i < 7; i++) {
/* 180 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(samsung[i]);
/* 181 */       Neuron toNeuron = getLayerAt(this.brandLayerIdx).getNeuronAt(0);
/* 182 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 186 */     for (int i = 0; i < 6; i++) {
/* 187 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(lg[i]);
/* 188 */       Neuron toNeuron = getLayerAt(this.brandLayerIdx).getNeuronAt(1);
/* 189 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 193 */     for (int i = 0; i < 7; i++) {
/* 194 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(sony[i]);
/* 195 */       Neuron toNeuron = getLayerAt(this.brandLayerIdx).getNeuronAt(2);
/* 196 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 201 */     for (int i = 0; i < 7; i++) {
/* 202 */       Neuron fromNeuron = getLayerAt(this.brandLayerIdx).getNeuronAt(0);
/* 203 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(samsung[i]);
/* 204 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 208 */     for (int i = 0; i < 6; i++) {
/* 209 */       Neuron fromNeuron = getLayerAt(this.brandLayerIdx).getNeuronAt(1);
/* 210 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(lg[i]);
/* 211 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 215 */     for (int i = 0; i < 7; i++) {
/* 216 */       Neuron fromNeuron = getLayerAt(this.brandLayerIdx).getNeuronAt(2);
/* 217 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(sony[i]);
/* 218 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */   }
/*     */   
/*     */   private void createPriceConnections() {
/* 223 */     int[] low = { 0, 2, 4, 7, 10, 16, 18 };
/* 224 */     int[] mid = { 3, 5, 8, 11, 12, 14, 19 };
/* 225 */     int[] high = { 1, 6, 9, 13, 15, 17 };
/*     */     
/*     */ 
/* 228 */     for (int i = 0; i < 7; i++) {
/* 229 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(low[i]);
/* 230 */       Neuron toNeuron = getLayerAt(this.priceLayerIdx).getNeuronAt(0);
/* 231 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 235 */     for (int i = 0; i < 7; i++) {
/* 236 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(mid[i]);
/* 237 */       Neuron toNeuron = getLayerAt(this.priceLayerIdx).getNeuronAt(1);
/* 238 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 242 */     for (int i = 0; i < 6; i++) {
/* 243 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(high[i]);
/* 244 */       Neuron toNeuron = getLayerAt(this.priceLayerIdx).getNeuronAt(2);
/* 245 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 250 */     for (int i = 0; i < 7; i++) {
/* 251 */       Neuron fromNeuron = getLayerAt(this.priceLayerIdx).getNeuronAt(0);
/* 252 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(low[i]);
/* 253 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 257 */     for (int i = 0; i < 7; i++) {
/* 258 */       Neuron fromNeuron = getLayerAt(this.priceLayerIdx).getNeuronAt(1);
/* 259 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(mid[i]);
/* 260 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 264 */     for (int i = 0; i < 6; i++) {
/* 265 */       Neuron fromNeuron = getLayerAt(this.priceLayerIdx).getNeuronAt(2);
/* 266 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(high[i]);
/* 267 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */   }
/*     */   
/*     */   private void createPromoConnections()
/*     */   {
/* 273 */     int[] sales = { 0, 10, 19 };
/* 274 */     int[] new_products = { 6, 9 };
/* 275 */     int[] bestsellers = { 3, 12, 14 };
/*     */     
/*     */ 
/* 278 */     for (int i = 0; i < sales.length; i++) {
/* 279 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(sales[i]);
/* 280 */       Neuron toNeuron = getLayerAt(this.promoLayerIdx).getNeuronAt(0);
/* 281 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 285 */     for (int i = 0; i < new_products.length; i++) {
/* 286 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(new_products[i]);
/* 287 */       Neuron toNeuron = getLayerAt(this.promoLayerIdx).getNeuronAt(1);
/* 288 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 292 */     for (int i = 0; i < bestsellers.length; i++) {
/* 293 */       Neuron fromNeuron = getLayerAt(this.inputLayerIdx).getNeuronAt(bestsellers[i]);
/* 294 */       Neuron toNeuron = getLayerAt(this.promoLayerIdx).getNeuronAt(2);
/* 295 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 299 */     for (int i = 0; i < sales.length; i++) {
/* 300 */       Neuron fromNeuron = getLayerAt(this.promoLayerIdx).getNeuronAt(0);
/* 301 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(sales[i]);
/* 302 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 306 */     for (int i = 0; i < new_products.length; i++) {
/* 307 */       Neuron fromNeuron = getLayerAt(this.promoLayerIdx).getNeuronAt(1);
/* 308 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(new_products[i]);
/* 309 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */     
/*     */ 
/* 313 */     for (int i = 0; i < bestsellers.length; i++) {
/* 314 */       Neuron fromNeuron = getLayerAt(this.promoLayerIdx).getNeuronAt(2);
/* 315 */       Neuron toNeuron = getLayerAt(this.outputLayerIdx).getNeuronAt(bestsellers[i]);
/* 316 */       createConnection(fromNeuron, toNeuron, 0.1D);
/*     */     }
/*     */   }
/*     */   
/*     */   private void createProductLabels(Layer layer) {
/* 321 */     LabelsPlugin labelsPlugin = (LabelsPlugin)getPlugin("LabelsPlugin");
/*     */     
/* 323 */     labelsPlugin.setLabel(layer.getNeuronAt(0), "Samsung LCD TV LE-32A330");
/* 324 */     labelsPlugin.setLabel(layer.getNeuronAt(1), "Samsung LCD TV LE-32A558");
/* 325 */     labelsPlugin.setLabel(layer.getNeuronAt(2), "LG LCD TV 32LG2000");
/* 326 */     labelsPlugin.setLabel(layer.getNeuronAt(3), "LG LCD TV 32LG5010");
/* 327 */     labelsPlugin.setLabel(layer.getNeuronAt(4), "Sony LCD TV KDL-32L4000K");
/* 328 */     labelsPlugin.setLabel(layer.getNeuronAt(5), "Sony LCD TV KDL-32S4000");
/* 329 */     labelsPlugin.setLabel(layer.getNeuronAt(6), "Sony LCD TV KDL-32W4000K");
/* 330 */     labelsPlugin.setLabel(layer.getNeuronAt(7), "Samsung Digital Camera S760");
/* 331 */     labelsPlugin.setLabel(layer.getNeuronAt(8), "Samsung Digital Camera L100");
/* 332 */     labelsPlugin.setLabel(layer.getNeuronAt(9), "Samsung Digital Camera S850");
/* 333 */     labelsPlugin.setLabel(layer.getNeuronAt(10), "LG Digital Camera DMCLS80E");
/* 334 */     labelsPlugin.setLabel(layer.getNeuronAt(11), "LG Digital Camera DMCLZ8E");
/* 335 */     labelsPlugin.setLabel(layer.getNeuronAt(12), "Sony Digital Camera DSCW120S");
/* 336 */     labelsPlugin.setLabel(layer.getNeuronAt(13), "Sony Digital Camera DSCW130S");
/* 337 */     labelsPlugin.setLabel(layer.getNeuronAt(14), "Samsung Mobile Phone E251");
/* 338 */     labelsPlugin.setLabel(layer.getNeuronAt(15), "Samsung Mobile Phone U600");
/* 339 */     labelsPlugin.setLabel(layer.getNeuronAt(16), "Sony Mobile Phone KP100");
/* 340 */     labelsPlugin.setLabel(layer.getNeuronAt(17), "Sony Mobile Phone KE850");
/* 341 */     labelsPlugin.setLabel(layer.getNeuronAt(18), "LG Mobile Phone K330");
/* 342 */     labelsPlugin.setLabel(layer.getNeuronAt(19), "LG Mobile Phone K660");
/*     */   }
/*     */   
/*     */   private void createTypeLabels(Layer layer) {
/* 346 */     LabelsPlugin labelsPlugin = (LabelsPlugin)getPlugin("LabelsPlugin");
/*     */     
/* 348 */     labelsPlugin.setLabel(layer.getNeuronAt(0), "LCD TV");
/* 349 */     labelsPlugin.setLabel(layer.getNeuronAt(1), "Digital Camera");
/* 350 */     labelsPlugin.setLabel(layer.getNeuronAt(2), "Mobile Phone");
/*     */   }
/*     */   
/*     */   private void createBrandLabels(Layer layer) {
/* 354 */     LabelsPlugin labelsPlugin = (LabelsPlugin)getPlugin("LabelsPlugin");
/*     */     
/* 356 */     labelsPlugin.setLabel(layer.getNeuronAt(0), "Samsung");
/* 357 */     labelsPlugin.setLabel(layer.getNeuronAt(1), "LG");
/* 358 */     labelsPlugin.setLabel(layer.getNeuronAt(2), "Sony");
/*     */   }
/*     */   
/*     */   private void createPriceLabels(Layer layer) {
/* 362 */     LabelsPlugin labelsPlugin = (LabelsPlugin)getPlugin("LabelsPlugin");
/*     */     
/* 364 */     labelsPlugin.setLabel(layer.getNeuronAt(0), "Low Price");
/* 365 */     labelsPlugin.setLabel(layer.getNeuronAt(1), "Mid Price");
/* 366 */     labelsPlugin.setLabel(layer.getNeuronAt(2), "High Price");
/*     */   }
/*     */   
/*     */   private void createPromoLabels(Layer layer) {
/* 370 */     LabelsPlugin labelsPlugin = (LabelsPlugin)getPlugin("LabelsPlugin");
/*     */     
/* 372 */     labelsPlugin.setLabel(layer.getNeuronAt(0), "Sales");
/* 373 */     labelsPlugin.setLabel(layer.getNeuronAt(1), "New");
/* 374 */     labelsPlugin.setLabel(layer.getNeuronAt(2), "Bestseller");
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\RecommenderNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */