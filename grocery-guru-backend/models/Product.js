const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ProductSchema = new Schema({
  price: { type: Number, required: true },
  imageUrl: { type: String, required: true },
  name: { type: String, required: true },
  description: { type: String },
  storeName: { type: String, required: true }
});

module.exports = mongoose.model('Product', ProductSchema);
