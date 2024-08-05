import React, { useState } from 'react';
import { Table, Button, Container } from 'reactstrap';

const lists = [
  { id: 1, name: 'My List #1' },
  { id: 2, name: 'My List #2' },
  { id: 3, name: 'My List #3' },
];

const MyLists = () => {
  const [selectedList, setSelectedList] = useState(null);

  const handleNavigate = (list) => {
    setSelectedList(list);
  };

  const handleBack = () => {
    setSelectedList(null);
  };

  const MyList = ({ list }) => {
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
        <h3 className="mb-3">My List: {list.name}</h3>
        <Button color="secondary" onClick={handleBack}>Back to My Lists</Button>
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

  return (
    <Container>
      {selectedList ? (
        <MyList list={selectedList} />
      ) : (
        <>
          <h3 className="mb-3">My Lists</h3>
          <Table striped>
            <thead>
              <tr>
                <th>My List</th>
                <th>Search List</th>
              </tr>
            </thead>
            <tbody>
              {lists.map((list) => (
                <tr key={list.id}>
                  <td>
                    <Button color="primary" onClick={() => handleNavigate(list)}>
                      {list.name}
                    </Button>
                  </td>
                  <td><Button color="info">Search List</Button></td>
                </tr>
              ))}
            </tbody>
          </Table>
        </>
      )}
    </Container>
  );
};

export default MyLists;
