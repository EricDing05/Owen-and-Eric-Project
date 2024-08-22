const express = require('express');
const router = express.Router();
const Product = require('../models/Product');

// GET all products
router.get('/', async (req, res) => {
  try {
    const products = await Product.find();
    res.json(products);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

router.get('/search', async (req, res) => {
    const searchText = req.query.q;

    try {
        const searchResults = await Product.find({
            $text: { $search: searchText }
        }).limit(5); // Adjust limit as needed

        res.json(searchResults);
    } catch (err) {
        console.error('Error during product search:', err);
        res.status(500).json({ error: err.message });
    }
});


module.exports = router;
