import React, { useState } from 'react';
import { Container, Table, Button } from 'reactstrap';


//this to be updated to be dynamic
const MyList = () => {
  const initialItems = [
    { id: 1, name: 'Item 1', brand: 'Brand A', quantity: 10 },
    { id: 2, name: 'Item 2', brand: 'Brand B', quantity: 5 },
    { id: 3, name: 'Item 3', brand: 'Brand C', quantity: 8 },
  ];

  const [items, setItems] = useState(initialItems);

  const handleRemove = (itemId) => {
    const newItems = items.filter(item => item.id !== itemId);
    setItems(newItems);
  };

  return (
    <Container>
      <h3 className="mb-3">My List</h3>
      <Table striped>
        <thead>
          <tr>
            <th>Item Name</th>
            <th>Brand</th>
            <th>Quantity</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {items.map((item) => (
            <tr key={item.id}>
              <td>{item.name}</td>
              <td>{item.brand}</td>
              <td>{item.quantity}</td>
              <td>
                <Button color="danger" onClick={() => handleRemove(item.id)}>Remove</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
  );
};

export default MyList;
