import React, { useState } from 'react';
import { Container, Row, Col, Button, Form, FormGroup, Label, Input, ListGroup, ListGroupItem } from 'reactstrap';
import './NewList.css';


const NewList = () => {
    const [listName, setListName] = useState('');
    const [items, setItems] = useState([]);
    const [name, setName] = useState('');
    const [brand, setBrand] = useState('');
    const [size, setSize] = useState('');

    const addItem = () => {
        if (name) {
            setItems([...items, { name, brand, size }]);
            setName('');
            setBrand('');
            setSize('');
        }
    };

    return (
        <Container>
                    <header className="my-4">
                        <h1>Create New List</h1>
                    </header>
                    <main>
                        <Row className="mb-4">
                            <Col md="6">
                                <Form>
                                    <FormGroup>
                                        <Label for="listName">List Name</Label>
                                        <Input
                                            type="text"
                                            id="listName"
                                            placeholder="List Name"
                                            value={listName}
                                            onChange={(e) => setListName(e.target.value)}
                                        />
                                    </FormGroup>
                                </Form>
                            </Col>
                        </Row>
                        <Row className="mb-4">
                            <Col>
                                <h2>Your List</h2>
                                {listName && <h3>{listName}</h3>}
                                {items.length === 0 ? (
                                    <p>No items added yet.</p>
                                ) : (
                                    <ListGroup>
                                        {items.map((item, index) => (
                                            <ListGroupItem key={index}>
                                                {item.name} {item.brand && `- ${item.brand}`} {item.size && `- ${item.size}`}
                                            </ListGroupItem>
                                        ))}
                                    </ListGroup>
                                )}
                            </Col>
                        </Row>
                        <Row>
                            <Col md="6">
                                <h2>Add Item</h2>
                                <Form>
                                    <FormGroup>
                                        <Label for="itemName">Item Name</Label>
                                        <Input
                                            type="text"
                                            id="itemName"
                                            placeholder="Item Name"
                                            value={name}
                                            onChange={(e) => setName(e.target.value)}
                                        />
                                    </FormGroup>
                                    <FormGroup>
                                        <Label for="itemBrand">Brand (if applicable)</Label>
                                        <Input
                                            type="text"
                                            id="itemBrand"
                                            placeholder="Brand (if applicable)"
                                            value={brand}
                                            onChange={(e) => setBrand(e.target.value)}
                                        />
                                    </FormGroup>
                                    <FormGroup>
                                        <Label for="itemSize">Size (if applicable)</Label>
                                        <Input
                                            type="text"
                                            id="itemSize"
                                            placeholder="Size (if applicable)"
                                            value={size}
                                            onChange={(e) => setSize(e.target.value)}
                                        />
                                    </FormGroup>
                                    <Button color="primary" onClick={addItem}>Add Item</Button>
                                </Form>
                            </Col>
                        </Row>
                    </main>
                </Container>
    );
};

export default NewList;
