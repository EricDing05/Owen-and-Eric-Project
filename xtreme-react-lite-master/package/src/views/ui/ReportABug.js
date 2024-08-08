import React from 'react';
import { Container, Row, Col, Button } from 'reactstrap';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <Container className="d-flex justify-content-center min-vh-100">
            <div style={{ width: '100%', maxWidth: '630px' }}>
                <Row className="justify-content-center">
                    <Col md="12" className="text-center">
                        <header className="my-3">
                            <h1>Found a Bug? Help Us Help You by Reporting It!</h1>
                        </header>
                        <main>
                            <p>Your feedback is invaluable to us in ensuring a smooth and efficient experience. If you encounter any bugs or issues, please let us know so we can address them promptly. Email us at grocerygurubugreport@gmail.com</p>

                        </main>
                    </Col>
                </Row>
            </div>
        </Container>
    );
};

export default Home;
