import axios from 'axios';

const API_URL = 'http://localhost:4000/api/products'; // Adjust the URL if different

export const getProducts = async () => {
  try {
    const response = await axios.get(API_URL);
    return response.data; // Return the data from the API response
  } catch (error) {
    console.error('Error fetching products:', error);
    throw error;
  }
};
