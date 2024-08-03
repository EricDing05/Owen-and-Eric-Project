import React from 'react';
import { Table, Button, Container } from 'reactstrap';

const lists = [
  { id: 1, name: 'My List #1' },   // can make this a variable to have the number of lists that are displayed vary
  { id: 2, name: 'My List #2' },
  { id: 3, name: 'My List #3' },
];

const MyLists = () => {
  return (
    <Container>
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
              <td><Button color="primary">{list.name}</Button></td>
              <td><Button color="info">Search List</Button></td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
  );
};

export default MyLists;
