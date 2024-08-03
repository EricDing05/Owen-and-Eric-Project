import React from 'react';
import { Container, Row, Col, Button, Form, FormGroup, Label, Input, ListGroup, ListGroupItem } from 'reactstrap';

const Home = () => {
    return (
        <div className="home-container">
            <header className="home-header">
                <h1>Welcome to Grocery Guru</h1>
            </header>
            <main className="home-main">
                <p>Grocery Guru helps you find the best prices for your grocery list across different stores.
                Simply create a list, and we'll show you the price of that list at every store.</p>
            </main>
        </div>
    );
};

export default Home;
