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

// Fuzzy search route
router.get('/search', async (req, res) => {
    const searchText = req.query.q;

    try {
        const searchResults = await Product.aggregate([
            {
                $search: {
                    "index": "default",  // Replace "default" with your index name if needed
                    "text": {
                        "query": searchText,
                        "path": "name",
                        "fuzzy": {
                            "maxEdits": 20,       // Number of allowed character edits (1 or 2)
                            "prefixLength": 0    // Number of initial characters that must match exactly
                        }
                    }
                }
            },
            { $limit: 10 } // Limit the number of results
        ]);

        res.json(searchResults);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});



module.exports = router;
