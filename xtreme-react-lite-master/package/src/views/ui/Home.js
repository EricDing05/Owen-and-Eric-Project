import React from 'react';
import { Container, Row, Col, Button } from 'reactstrap';
import { Link } from 'react-router-dom';
import ProductsList from '../../components/ProductsList.js'

const Home = () => {
    return (
        <Container className="d-flex justify-content-center min-vh-100">
            <div style={{ width: '100%', maxWidth: '630px' }}>
                <Row className="justify-content-center">
                    <Col md="12" className="text-center">
                        <header className="my-3">
                            <h1>Welcome to Grocery Guru</h1>
                        </header>
                        <ProductsList />
                        <main>
                            <p>Grocery Guru helps you find the best prices for your grocery list across different stores.
                            Simply create a list, and we'll show you the price of that list at every store.</p>
                            <Link to="/newlist">
                                <Button color="primary">Get Started</Button>
                            </Link>
                        </main>
                    </Col>
                </Row>
            </div>
        </Container>
    );
};

export default Home;
