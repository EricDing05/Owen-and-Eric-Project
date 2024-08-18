import React from 'react';
import { Container, Table, Button } from 'reactstrap';

const MyList = ({ list, items, setItems, handleBack }) => {
  const handleRemove = (itemId) => {
    const newItems = items.filter(item => item._id !== itemId); // Use _id as the unique identifier
    setItems(newItems);

    // Optionally, update the backend to remove the item
    // axios.delete(`http://localhost:4000/api/lists/${list._id}/items/${itemId}`)
    //   .catch(error => console.error('Error removing item:', error));
  };

  return (
    <Container>
      <h3 className="mb-3">My List: {list.name}</h3>
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
            <tr key={item._id}>
              <td>{item.name}</td>
              <td>{item.brand}</td>
              <td>{item.size}</td> {/* Assuming size is used for quantity */}
              <td>
                <Button color="danger" onClick={() => handleRemove(item._id)}>Remove</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
      <div className="d-flex justify-content-between mt-3">
        <Button color="secondary" onClick={handleBack}>Back to My Lists</Button>
        {/* Other buttons like Undo can go here */}
      </div>
    </Container>
  );
};

export default MyList;