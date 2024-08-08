import React, { useState } from 'react';
import { Container, Row, Col, Button, Form, FormGroup, Label, Input, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [modal, setModal] = useState(false);

    const toggleModal = () => setModal(!modal);

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log({ username, password });
        toggleModal();
    };

    return (
        <Container className="d-flex justify-content-center min-vh-100">
            <div style={{ width: '100%', maxWidth: '630px' }}>
                <header className="my-3 text-center">
                    <h1>Login</h1>
                </header>
                <main>
                    <Form onSubmit={handleSubmit}>
                        <FormGroup row className="mb-2">
                            <Label for="username" sm={4}>Username</Label>
                            <Col sm={7}>
                                <Input
                                    type="text"
                                    id="username"
                                    placeholder="Your Username"
                                    value={username}
                                    onChange={(e) => setUsername(e.target.value)}
                                    size="sm"
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup row className="mb-2">
                            <Label for="password" sm={4}>Password</Label>
                            <Col sm={7}>
                                <Input
                                    type="password"
                                    id="password"
                                    placeholder="Your Password"
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                    size="sm"
                                />
                            </Col>
                        </FormGroup>
                        <div className="d-flex justify-content-center mt-2">
                            <Button color="primary" type="submit">Login</Button>
                        </div>
                    </Form>
                </main>

                <Modal isOpen={modal} toggle={toggleModal}>
                    <ModalHeader toggle={toggleModal}>Login Successful</ModalHeader>
                    <ModalBody>
                        {`Welcome, ${username}!`}
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={toggleModal}>OK</Button>
                    </ModalFooter>
                </Modal>
            </div>
        </Container>
    );
};

export default Login;
