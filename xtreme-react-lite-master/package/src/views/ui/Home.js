import React from 'react';
import { Container, Row, Col, Button } from 'reactstrap';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <Container className="pageWrapper home-container">
            <Row>
                <Col>
                    <header className="home-header">
                        <h1>Welcome to Grocery Guru</h1>
                    </header>
                </Col>
            </Row>
            <Row className="contentArea">
                <Col>
                    <main className="home-main">
                        <p>Grocery Guru helps you find the best prices for your grocery list across different stores.
                        Simply create a list, and we'll show you the price of that list at every store.</p>
                        <Link to="/newlist">
                            <Button color="primary">Get Started</Button>
                        </Link>
                    </main>
                </Col>
            </Row>
        </Container>
    );
};

export default Home;
