const express = require('express');
const router = express.Router();
const List = require('../models/List');

// POST route to save a new list
router.post('/save', async (req, res) => {
  const { sessionId, name, items } = req.body;

  try {
    const newList = new List({ sessionId, name, items });
    await newList.save();
    res.status(200).json({ message: 'List saved successfully', list: newList });
  } catch (error) {
    console.error('Error saving list:', error);
    res.status(500).json({ message: 'Error saving list', error: error.message });
  }
});

// GET route to retrieve all lists for a specific sessionId
router.get('/my-lists/:sessionId', async (req, res) => {
  const { sessionId } = req.params;

  try {
    const lists = await List.find({ sessionId: sessionId });
    if (!lists || lists.length === 0) {
      return res.status(404).json({ message: 'No lists found for this session.' });
    }
    res.status(200).json(lists);
  } catch (error) {
    console.error('Error fetching lists:', error);
    res.status(500).json({ message: 'Error fetching lists', error: error.message });
  }
});

// GET route to fetch items for a specific list
router.get('/:listId/items', async (req, res) => {
  const { listId } = req.params;

  try {
    const list = await List.findById(listId);
    if (!list) {
      return res.status(404).json({ message: 'List not found' });
    }
    res.status(200).json(list.items);
  } catch (error) {
    console.error('Error fetching items:', error);
    res.status(500).json({ message: 'Error fetching items', error: error.message });
  }
});

module.exports = router;