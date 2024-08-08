import React, { useEffect, useState } from 'react';
import { getProducts } from '../services/api';

const ProductsList = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
      const fetchProducts = async () => {
        try {
          const data = await getProducts();
          console.log('Fetched products:', data); // Add this line to log fetched data
          setProducts(data);
        } catch (error) {
          console.error('Error fetching products:', error); // Add this line to log any errors
        }
      };

    fetchProducts();
  }, []);

  return (
    <div>
      <h1>Product List</h1>
      <ul>
        {products.map(product => (
          <li key={product._id}>
            <h2>{product.name}</h2>
            <p>{product.description}</p>
            <img src={product.imageUrl} alt={product.name} width="200" />
            <p>Price: ${product.price}</p>
            <p>Store: {product.storeName}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductsList;
