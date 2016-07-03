/*     */ package org.neuroph.contrib;
/*     */ 
/*     */ import org.neuroph.core.Layer;
/*     */ import org.neuroph.core.NeuralNetwork;
/*     */ import org.neuroph.util.ConnectionFactory;
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
/*     */ public class IACNetwork
/*     */   extends NeuralNetwork
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public IACNetwork()
/*     */   {
/*  54 */     createNetwork();
/*     */   }
/*     */   
/*     */ 
/*     */   private void createNetwork()
/*     */   {
/*  60 */     addLayer(new Layer());
/*  61 */     addLayer(new Layer());
/*  62 */     addLayer(new Layer());
/*  63 */     addLayer(new Layer());
/*  64 */     addLayer(new Layer());
/*  65 */     addLayer(new Layer());
/*     */     
/*  67 */     addLayer(new Layer());
/*     */     
/*  69 */     LabelsPlugin labels = (LabelsPlugin)getPlugin("LabelsPlugin");
/*     */     
/*  71 */     Layer layer = getLayerAt(0);
/*     */     
/*  73 */     IACNeuron neuron = new IACNeuron();
/*  74 */     labels.setLabel(neuron, "Art");
/*  75 */     layer.addNeuron(neuron);
/*     */     
/*  77 */     neuron = new IACNeuron();
/*  78 */     labels.setLabel(neuron, "Rick");
/*  79 */     layer.addNeuron(neuron);
/*     */     
/*  81 */     neuron = new IACNeuron();
/*  82 */     labels.setLabel(neuron, "Sam");
/*  83 */     layer.addNeuron(neuron);
/*     */     
/*  85 */     neuron = new IACNeuron();
/*  86 */     labels.setLabel(neuron, "Ralph");
/*  87 */     layer.addNeuron(neuron);
/*     */     
/*  89 */     neuron = new IACNeuron();
/*  90 */     labels.setLabel(neuron, "Lance");
/*  91 */     layer.addNeuron(neuron);
/*     */     
/*  93 */     ConnectionFactory.fullConnect(layer, -0.3D);
/*     */     
/*     */ 
/*  96 */     layer = getLayerAt(1);
/*     */     
/*  98 */     neuron = new IACNeuron();
/*  99 */     labels.setLabel(neuron, "Jets");
/* 100 */     layer.addNeuron(neuron);
/*     */     
/* 102 */     neuron = new IACNeuron();
/* 103 */     labels.setLabel(neuron, "Sharks");
/* 104 */     layer.addNeuron(neuron);
/*     */     
/* 106 */     ConnectionFactory.fullConnect(layer, -0.3D);
/*     */     
/*     */ 
/*     */ 
/* 110 */     layer = getLayerAt(2);
/*     */     
/* 112 */     neuron = new IACNeuron();
/* 113 */     labels.setLabel(neuron, "20's");
/* 114 */     layer.addNeuron(neuron);
/*     */     
/* 116 */     neuron = new IACNeuron();
/* 117 */     labels.setLabel(neuron, "30's");
/* 118 */     layer.addNeuron(neuron);
/*     */     
/* 120 */     neuron = new IACNeuron();
/* 121 */     labels.setLabel(neuron, "40's");
/* 122 */     layer.addNeuron(neuron);
/*     */     
/* 124 */     ConnectionFactory.fullConnect(layer, -0.3D);
/*     */     
/*     */ 
/*     */ 
/* 128 */     layer = getLayerAt(3);
/*     */     
/* 130 */     neuron = new IACNeuron();
/* 131 */     labels.setLabel(neuron, "J.H.");
/* 132 */     layer.addNeuron(neuron);
/*     */     
/* 134 */     neuron = new IACNeuron();
/* 135 */     labels.setLabel(neuron, "H.S.");
/* 136 */     layer.addNeuron(neuron);
/*     */     
/* 138 */     neuron = new IACNeuron();
/* 139 */     labels.setLabel(neuron, "College");
/* 140 */     layer.addNeuron(neuron);
/*     */     
/* 142 */     ConnectionFactory.fullConnect(layer, -0.3D);
/*     */     
/*     */ 
/*     */ 
/* 146 */     layer = getLayerAt(4);
/*     */     
/* 148 */     neuron = new IACNeuron();
/* 149 */     labels.setLabel(neuron, "Single");
/* 150 */     layer.addNeuron(neuron);
/*     */     
/* 152 */     neuron = new IACNeuron();
/* 153 */     labels.setLabel(neuron, "Married");
/* 154 */     layer.addNeuron(neuron);
/*     */     
/* 156 */     neuron = new IACNeuron();
/* 157 */     labels.setLabel(neuron, "Divorced");
/* 158 */     layer.addNeuron(neuron);
/*     */     
/* 160 */     ConnectionFactory.fullConnect(layer, -0.3D);
/*     */     
/*     */ 
/*     */ 
/* 164 */     layer = getLayerAt(5);
/*     */     
/* 166 */     neuron = new IACNeuron();
/* 167 */     labels.setLabel(neuron, "Pusher");
/* 168 */     layer.addNeuron(neuron);
/*     */     
/* 170 */     neuron = new IACNeuron();
/* 171 */     labels.setLabel(neuron, "Burglar");
/* 172 */     layer.addNeuron(neuron);
/*     */     
/* 174 */     neuron = new IACNeuron();
/* 175 */     labels.setLabel(neuron, "Bookie");
/* 176 */     layer.addNeuron(neuron);
/*     */     
/* 178 */     ConnectionFactory.fullConnect(layer, -0.3D);
/*     */     
/*     */ 
/*     */ 
/* 182 */     layer = getLayerAt(6);
/*     */     
/* 184 */     neuron = new IACNeuron();
/* 185 */     layer.addNeuron(neuron);
/* 186 */     createConnection(neuron, getLayerAt(0).getNeuronAt(0), 0.1D);
/* 187 */     createConnection(neuron, getLayerAt(1).getNeuronAt(0), 0.1D);
/* 188 */     createConnection(neuron, getLayerAt(2).getNeuronAt(2), 0.1D);
/* 189 */     createConnection(neuron, getLayerAt(3).getNeuronAt(0), 0.1D);
/* 190 */     createConnection(neuron, getLayerAt(4).getNeuronAt(0), 0.1D);
/* 191 */     createConnection(neuron, getLayerAt(5).getNeuronAt(0), 0.1D);
/*     */     
/* 193 */     createConnection(getLayerAt(0).getNeuronAt(0), neuron, 0.1D);
/* 194 */     createConnection(getLayerAt(1).getNeuronAt(0), neuron, 0.1D);
/* 195 */     createConnection(getLayerAt(2).getNeuronAt(2), neuron, 0.1D);
/* 196 */     createConnection(getLayerAt(3).getNeuronAt(0), neuron, 0.1D);
/* 197 */     createConnection(getLayerAt(4).getNeuronAt(0), neuron, 0.1D);
/* 198 */     createConnection(getLayerAt(5).getNeuronAt(0), neuron, 0.1D);
/*     */     
/*     */ 
/* 201 */     neuron = new IACNeuron();
/* 202 */     layer.addNeuron(neuron);
/* 203 */     createConnection(neuron, getLayerAt(0).getNeuronAt(1), 0.1D);
/* 204 */     createConnection(neuron, getLayerAt(1).getNeuronAt(1), 0.1D);
/* 205 */     createConnection(neuron, getLayerAt(2).getNeuronAt(1), 0.1D);
/* 206 */     createConnection(neuron, getLayerAt(3).getNeuronAt(1), 0.1D);
/* 207 */     createConnection(neuron, getLayerAt(4).getNeuronAt(2), 0.1D);
/* 208 */     createConnection(neuron, getLayerAt(5).getNeuronAt(1), 0.1D);
/*     */     
/* 210 */     createConnection(getLayerAt(0).getNeuronAt(1), neuron, 0.1D);
/* 211 */     createConnection(getLayerAt(1).getNeuronAt(1), neuron, 0.1D);
/* 212 */     createConnection(getLayerAt(2).getNeuronAt(1), neuron, 0.1D);
/* 213 */     createConnection(getLayerAt(3).getNeuronAt(1), neuron, 0.1D);
/* 214 */     createConnection(getLayerAt(4).getNeuronAt(2), neuron, 0.1D);
/* 215 */     createConnection(getLayerAt(5).getNeuronAt(1), neuron, 0.1D);
/*     */     
/* 217 */     neuron = new IACNeuron();
/* 218 */     layer.addNeuron(neuron);
/* 219 */     createConnection(neuron, getLayerAt(0).getNeuronAt(2), 0.1D);
/* 220 */     createConnection(neuron, getLayerAt(1).getNeuronAt(0), 0.1D);
/* 221 */     createConnection(neuron, getLayerAt(2).getNeuronAt(0), 0.1D);
/* 222 */     createConnection(neuron, getLayerAt(3).getNeuronAt(2), 0.1D);
/* 223 */     createConnection(neuron, getLayerAt(4).getNeuronAt(0), 0.1D);
/* 224 */     createConnection(neuron, getLayerAt(5).getNeuronAt(2), 0.1D);
/*     */     
/* 226 */     createConnection(getLayerAt(0).getNeuronAt(2), neuron, 0.1D);
/* 227 */     createConnection(getLayerAt(1).getNeuronAt(0), neuron, 0.1D);
/* 228 */     createConnection(getLayerAt(2).getNeuronAt(0), neuron, 0.1D);
/* 229 */     createConnection(getLayerAt(3).getNeuronAt(2), neuron, 0.1D);
/* 230 */     createConnection(getLayerAt(4).getNeuronAt(0), neuron, 0.1D);
/* 231 */     createConnection(getLayerAt(5).getNeuronAt(2), neuron, 0.1D);
/*     */     
/* 233 */     neuron = new IACNeuron();
/* 234 */     layer.addNeuron(neuron);
/* 235 */     createConnection(neuron, getLayerAt(0).getNeuronAt(3), 0.1D);
/* 236 */     createConnection(neuron, getLayerAt(1).getNeuronAt(0), 0.1D);
/* 237 */     createConnection(neuron, getLayerAt(2).getNeuronAt(1), 0.1D);
/* 238 */     createConnection(neuron, getLayerAt(3).getNeuronAt(0), 0.1D);
/* 239 */     createConnection(neuron, getLayerAt(4).getNeuronAt(0), 0.1D);
/* 240 */     createConnection(neuron, getLayerAt(5).getNeuronAt(0), 0.1D);
/*     */     
/* 242 */     createConnection(getLayerAt(0).getNeuronAt(3), neuron, 0.1D);
/* 243 */     createConnection(getLayerAt(1).getNeuronAt(0), neuron, 0.1D);
/* 244 */     createConnection(getLayerAt(2).getNeuronAt(1), neuron, 0.1D);
/* 245 */     createConnection(getLayerAt(3).getNeuronAt(0), neuron, 0.1D);
/* 246 */     createConnection(getLayerAt(4).getNeuronAt(0), neuron, 0.1D);
/* 247 */     createConnection(getLayerAt(5).getNeuronAt(0), neuron, 0.1D);
/*     */     
/* 249 */     neuron = new IACNeuron();
/* 250 */     layer.addNeuron(neuron);
/* 251 */     createConnection(neuron, getLayerAt(0).getNeuronAt(4), 0.1D);
/* 252 */     createConnection(neuron, getLayerAt(1).getNeuronAt(0), 0.1D);
/* 253 */     createConnection(neuron, getLayerAt(2).getNeuronAt(0), 0.1D);
/* 254 */     createConnection(neuron, getLayerAt(3).getNeuronAt(0), 0.1D);
/* 255 */     createConnection(neuron, getLayerAt(4).getNeuronAt(1), 0.1D);
/* 256 */     createConnection(neuron, getLayerAt(5).getNeuronAt(1), 0.1D);
/*     */     
/* 258 */     createConnection(getLayerAt(0).getNeuronAt(4), neuron, 0.1D);
/* 259 */     createConnection(getLayerAt(1).getNeuronAt(0), neuron, 0.1D);
/* 260 */     createConnection(getLayerAt(2).getNeuronAt(0), neuron, 0.1D);
/* 261 */     createConnection(getLayerAt(3).getNeuronAt(0), neuron, 0.1D);
/* 262 */     createConnection(getLayerAt(4).getNeuronAt(1), neuron, 0.1D);
/* 263 */     createConnection(getLayerAt(5).getNeuronAt(1), neuron, 0.1D);
/*     */     
/* 265 */     ConnectionFactory.fullConnect(layer, -0.3D);
/*     */     
/*     */ 
/*     */ 
/* 269 */     labels.setLabel(this, "IAC Test");
/* 270 */     setInputNeurons(getLayerAt(0).getNeurons());
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\IACNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */