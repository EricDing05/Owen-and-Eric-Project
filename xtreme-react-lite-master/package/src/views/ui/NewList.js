import React, { useState } from 'react';
import axios from 'axios';  // Import axios for making API requests
import { Container, Row, Col, Button, Form, FormGroup, Label, Input, ListGroup, ListGroupItem, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import axios from 'axios';

const NewList = () => {
    const [listName, setListName] = useState('');
    const [items, setItems] = useState([]);
    const [name, setName] = useState('');
    const [brand, setBrand] = useState('');
    const [size, setSize] = useState('');
    const [unit, setUnit] = useState('');
    const [modal, setModal] = useState(false);
    const [suggestions, setSuggestions] = useState([]);

    const toggleModal = () => setModal(!modal);

    const addItem = () => {
        if (name) {
            const item = { name, brand };
            if (size) {
                item.size = `${size} ${unit}`;
            }
            setItems([...items, item]);
            setName('');
            setBrand('');
            setSize('');
            setUnit('');
            setSuggestions([]);
        }
    };

    const removeItem = (index) => {
        const newItems = items.filter((item, i) => i !== index);
        setItems(newItems);
    };

    const saveList = async () => {
        if (!listName) {
            alert('Please enter a list name');
            return;
        }

        const newList = {
            userId: 'user_id_placeholder',  // Replace this with the actual user ID if you have authentication
            name: listName,
            items: items
        };

        try {
            const response = await axios.post('http://localhost:4000/api/lists/save', newList); // Save the list to the backend
            console.log('List saved:', response.data);
            toggleModal();
        } catch (error) {
            console.error('Error saving list:', error);
            alert('There was an error saving your list. Please try again.');
        }
    };
//TODO

    const handleNameChange = (e) => {
            const value = e.target.value;
            setName(value);

            if (value.length > 2) {
                axios.get(`/api/products/search?q=${value}`)
                    .then(response => {
                        setSuggestions(response.data);
                    })
                    .catch(error => {
                        console.error('Error fetching search results:', error);
                    });
            } else {
                setSuggestions([]);
            }
        };

    const selectSuggestion = (suggestion) => {
        setName(suggestion.name);
        setSuggestions([]);
    };


    return (
        <Container className="d-flex justify-content-center align-items-center min-vh-50">
            <div style={{ width: '100%', maxWidth: '630px' }}>
                <header className="my-4 text-center">
                    <h1>Create a New Grocery List</h1>
                </header>
                <main>
                    <Row className="mb-4 justify-content-center">
                        <Col md="12">
                            <Form>
                                <FormGroup row>
                                    <Label for="listName" sm={3}>List Name</Label>
                                    <Col sm={9}>
                                        <Input
                                            type="text"
                                            id="listName"
                                            placeholder="Ex. Weekly Essentials"
                                            value={listName}
                                            onChange={(e) => setListName(e.target.value)}
                                            size="sm"
                                        />
                                    </Col>
                                </FormGroup>
                            </Form>
                        </Col>
                    </Row>
                    <Row className="mb-4 justify-content-center text-center">
                        <Col md="12">
                            <h2>Your List</h2>
                            {listName && <h3>{listName}</h3>}
                            {items.length === 0 ? (
                                <p>No items added yet.</p>
                            ) : (
                                <ListGroup>
                                    {items.map((item, index) => (
                                        <ListGroupItem key={index} className="d-flex justify-content-between align-items-center">
                                            {item.name} {item.brand && `- ${item.brand}`} {item.size && `${item.size}`}
                                            <Button color="danger" size="sm" onClick={() => removeItem(index)}>Remove</Button>
                                        </ListGroupItem>
                                    ))}
                                </ListGroup>
                            )}
                        </Col>
                    </Row>
                    <Row className="justify-content-center">
                        <Col md="12">
                            <h2>Add Item</h2>
                            <Form>
                                <FormGroup row>
                                    <Label for="itemName" sm={3}>Item Name</Label>
                                    <Col sm={9}>
                                        <Input
                                            type="text"
                                            id="itemName"
                                            placeholder="Ex. Oranges"
                                            value={name}
                                            onChange={(e) => setName(e.target.value)}
                                            size="sm"
                                        />
                                         {suggestions.length > 0 && (
                                                                                    <ListGroup className="mt-2">
                                                                                        {suggestions.map((suggestion, index) => (
                                                                                            <ListGroupItem key={index} onClick={() => selectSuggestion(suggestion)}>
                                                                                                {suggestion.name}
                                                                                            </ListGroupItem>
                                                                                        ))}
                                                                                    </ListGroup>
                                                                                )}
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Label for="itemBrand" sm={3}>Brand (optional)</Label>
                                    <Col sm={9}>
                                        <Input
                                            type="text"
                                            id="itemBrand"
                                            placeholder="Ex. Sunkist"
                                            value={brand}
                                            onChange={(e) => setBrand(e.target.value)}
                                            size="sm"
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Label for="itemSize" sm={3}>Amount (optional)</Label>
                                    <Col sm={5}>
                                        <Input
                                            type="text"
                                            id="itemSize"
                                            placeholder="Ex. 2"
                                            value={size}
                                            onChange={handleAmountChange}
                                            size="sm"
                                        />
                                    </Col>
                                    <Col sm={4}>
                                        <Input
                                            type="select"
                                            id="unit"
                                            value={unit}
                                            onChange={(e) => setUnit(e.target.value)}
                                            size="sm"
                                            disabled={!size}
                                        >
                                            <option value="">Select unit</option>
                                            <option>units</option>
                                            <option>grams</option>
                                            <option>Kg</option>
                                            <option>lbs</option>
                                            <option>Oz</option>
                                            <option>mL</option>
                                            <option>Liters</option>
                                        </Input>
                                    </Col>
                                </FormGroup>
                                <div className="d-flex justify-content-between mt-2">
                                    <Button color="primary" onClick={saveList}>Save List</Button>
                                    <Button color="primary" onClick={addItem}>Add Item</Button>
                                </div>
                            </Form>
                        </Col>
                    </Row>
                </main>
                <Modal isOpen={modal} toggle={toggleModal}>
                    <ModalHeader toggle={toggleModal}>List Saved</ModalHeader>
                    <ModalBody>
                        {`"${listName}" was saved!`}
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={toggleModal}>OK</Button>
                    </ModalFooter>
                </Modal>
            </div>
        </Container>
    );
};

export default NewList;