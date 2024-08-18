const express = require('express');
const router = express.Router();
const List = require('../models/List');

// POST route to save a new list
router.post('/save', async (req, res) => {
  const { userId, name, items } = req.body;

  try {
    const newList = new List({ userId, name, items });
    await newList.save();
    res.status(200).json({ message: 'List saved successfully', list: newList });
  } catch (error) {
    console.error('Error saving list:', error);
    res.status(500).json({ message: 'Error saving list', error: error.message });
  }
});

module.exports = router;