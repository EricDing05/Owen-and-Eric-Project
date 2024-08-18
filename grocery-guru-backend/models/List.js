const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ListSchema = new Schema({
  userId: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true }, // Assuming you have user authentication
  name: { type: String, required: true }, // Name of the list
  items: [
    {
      name: { type: String, required: true },
      brand: String,
      size: String,
    }
  ],
  createdAt: { type: Date, default: Date.now }
});

const List = mongoose.model('List', ListSchema);
module.exports = List;