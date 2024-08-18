const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const bodyParser = require('body-parser');

const app = express();
const port = process.env.PORT || 4000;

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Connect to MongoDB
const dbUri = 'mongodb+srv://ericding555:gNqp3LiMxeqC3pEU@cluster0.zwri3gv.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';
mongoose.connect(dbUri, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('MongoDB connected...'))
  .catch(err => console.error(err));

// Routes
const productsRouter = require('./routes/products'); // Adjust the path as necessary
const listsRouter = require('./routes/lists'); // Add this line to import your lists routes

app.use('/api/lists', listsRouter); // Add this line to use the lists routes
app.use('/api/products', productsRouter);

app.get('/', (req, res) => {
  res.send('Welcome to Grocery Guru Backend');
});

// Start the server
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
