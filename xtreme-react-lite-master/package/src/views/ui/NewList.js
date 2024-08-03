import React, { useState } from 'react';
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
        <div className="new-list-container">
            <header className="new-list-header">
                <h1>Create New List</h1>
            </header>
            <main className="new-list-main">
                <div className="list-name-form">
                    <input
                        type="text"
                        placeholder="List Name"
                        value={listName}
                        onChange={(e) => setListName(e.target.value)}
                    />
                </div>
                <div className="item-list">
                    <h2>Your List</h2>
                    {listName && <h3>{listName}</h3>}
                    {items.length === 0 ? (
                        <p>No items added yet.</p>
                    ) : (
                        <ul>
                            {items.map((item, index) => (
                                <li key={index}>
                                    {item.name} {item.brand && `- ${item.brand}`} {item.size && `- ${item.size}`}
                                </li>
                            ))}
                        </ul>
                    )}
                </div>
                <div className="add-item-form">
                    <h2>Add Item</h2>
                    <input
                        type="text"
                        placeholder="Item Name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                    <input
                        type="text"
                        placeholder="Brand (if applicable)"
                        value={brand}
                        onChange={(e) => setBrand(e.target.value)}
                    />
                    <input
                        type="text"
                        placeholder="Size (if applicable)"
                        value={size}
                        onChange={(e) => setSize(e.target.value)}
                    />
                    <button onClick={addItem}>Add Item</button>
                </div>
            </main>
        </div>
    );
};

export default NewList;
