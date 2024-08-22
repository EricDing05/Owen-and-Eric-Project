import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { Container, Row, Col, Button, Table } from 'reactstrap';
import axios from 'axios';
import { getSessionId } from '../../utils';  // Ensure you have this utility function
import MyList from './MyList';

const MyLists = () => {
  const [lists, setLists] = useState([]);
  const [selectedList, setSelectedList] = useState(null);
  const [items, setItems] = useState([]);

  useEffect(() => {
    // Fetch lists from the backend when the component mounts
    const fetchLists = async () => {
      const sessionId = getSessionId();  // Assuming you have this utility function
      try {
        const response = await axios.get(`http://localhost:4000/api/lists/my-lists/${sessionId}`);
        setLists(response.data);
      } catch (error) {
        console.error('Error fetching lists:', error);
      }
    };

    fetchLists();
  }, []);

  const handleNavigate = async (list) => {
    setSelectedList(list);

    // Fetch items for the selected list from the backend
    try {
      const response = await axios.get(`http://localhost:4000/api/lists/${list._id}/items`);
      setItems(response.data);
    } catch (error) {
      console.error('Error fetching items:', error);
    }
  };

  const handleBack = () => {
    setSelectedList(null);
    setItems([]);
  };

  return (
    <Container>
      {selectedList ? (
        <MyList list={selectedList} items={items} setItems={setItems} handleBack={handleBack} />
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
                <tr key={list._id}>
                  <td>
                    <Button color="primary" onClick={() => handleNavigate(list)}>
                      {list.name}
                    </Button>
                  </td>
                  <td>
                    <Link to="/searchlist">
                      <Button color="info">Search List</Button>
                    </Link>
                  </td>
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