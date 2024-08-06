const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');

const app = express();
const port = process.env.PORT || 3000;

// Middleware
app.use(cors());
app.use(bodyParser.json());

// Connect to MongoDB
const dbUri = 'mongodb+srv://ericding555:gNqp3LiMxeqC3pEU@cluster0.zwri3gv.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0'; // Replace with your actual connection string
mongoose.connect(dbUri)
  .then(() => console.log('MongoDB connected...'))
  .catch(err => console.error(err));

// Define routes
app.get('/', (req, res) => {
  res.send('Welcome to Grocery Guru Backend');
});

// Start the server
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
