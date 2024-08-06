const mongoose = require('mongoose');
const fs = require('fs');
const path = require('path');
const Product = require('./models/Product'); // Ensure the path is correct

const dbUri = 'mongodb+srv://ericding555:gNqp3LiMxeqC3pEU@cluster0.zwri3gv.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';

mongoose.connect(dbUri)
  .then(async () => {
    console.log('MongoDB connected...');

    // Clear existing data in the Product collection
    await Product.deleteMany({})
      .then(() => {
        console.log('Existing data cleared.');
      })
      .catch(err => {
        console.error('Error clearing existing data:', err);
      });

    // Use the absolute path to the 'data' directory
    const directoryPath = '/Users/ericding/IdeaProjects/App/.idea/data'; // <-- Replace with your actual absolute path
    const files = fs.readdirSync(directoryPath); // Read all files in the directory

    for (const file of files) {
      const filePath = path.join(directoryPath, file);
      if (path.extname(filePath) === '.json') { // Ensure the file is a JSON file
        console.log(`Processing file: ${file}`);

        // Read the JSON file
        const rawData = fs.readFileSync(filePath, 'utf-8');

        // Skip empty or null files
        if (!rawData || rawData.trim() === '') {
          console.log(`Skipping empty or null file: ${file}`);
          continue;
        }

        try {
          const parsedData = JSON.parse(rawData);
          const data = parsedData.products;

          // Check if the data is an array
          if (!Array.isArray(data)) {
            throw new Error('JSON data is not an array');
          }

          // Validate the data format to ensure all required fields are present
          data.forEach(product => {
            if (!product.price || !product.imageUrl || !product.name || !product.storeName) {
              throw new Error('Missing required fields in the JSON data');
            }
          });

          // Insert data into the database
          await Product.insertMany(data)
            .then(() => {
              console.log(`Data successfully uploaded from file: ${file}`);
            })
            .catch(err => {
              console.error(`Error uploading data from file: ${file}`, err);
            });
        } catch (err) {
          console.error(`Error processing file: ${file}`, err);
        }
      }
    }

    mongoose.connection.close();
  })
  .catch(err => {
    console.error('MongoDB connection error:', err);
    mongoose.connection.close();
  });
