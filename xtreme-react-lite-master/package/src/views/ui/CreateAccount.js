import React, { useState } from 'react';
import { Container, Row, Col, Button, Form, FormGroup, Label, Input, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import axios from 'axios';

const CreateAccount = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [modal, setModal] = useState(false);
    const [errorModal, setErrorModal] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');

    const toggleModal = () => setModal(!modal);
    const toggleErrorModal = () => setErrorModal(!errorModal);

    const isValidName = (name) => /^[a-zA-Z]+$/.test(name);

    const handleSubmit = (e) => {
        e.preventDefault();
        if (password !== confirmPassword) {
            setErrorMessage("Passwords do not match!");
            toggleErrorModal();
        } else if (!isValidName(firstName) || !isValidName(lastName)) {
            setErrorMessage("First name and last name should only contain letters.");
            toggleErrorModal();
        } else {
            const accountData = { firstName, lastName, username, email, password };
            axios.post('http://localhost:5000/save-account', accountData)
                .then((response) => {
                    console.log(response.data);
                    toggleModal();
                })
                .catch((error) => {
                    console.error('There was an error saving the account data!', error);
                });
        }
    };

    return (
        <Container className="d-flex justify-content-center min-vh-100">
            <div style={{ width: '100%', maxWidth: '630px' }}>
                <header className="my-3 text-center">
                    <h1>Create a New Account</h1>
                </header>
                <main>
                    <Form onSubmit={handleSubmit}>
                        <FormGroup row className="mb-2">
                            <Label for="firstName" sm={4}>First Name</Label>
                            <Col sm={7}>
                                <Input
                                    type="text"
                                    id="firstName"
                                    placeholder="Enter your first name"
                                    value={firstName}
                                    onChange={(e) => setFirstName(e.target.value)}
                                    size="sm"
                                    required
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup row className="mb-2">
                            <Label for="lastName" sm={4}>Last Name (optional)</Label>
                            <Col sm={7}>
                                <Input
                                    type="text"
                                    id="lastName"
                                    placeholder="Enter your last name"
                                    value={lastName}
                                    onChange={(e) => setLastName(e.target.value)}
                                    size="sm"
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup row className="mb-2">
                            <Label for="username" sm={4}>Username</Label>
                            <Col sm={7}>
                                <Input
                                    type="text"
                                    id="username"
                                    placeholder="Enter your username"
                                    value={username}
                                    onChange={(e) => setUsername(e.target.value)}
                                    size="sm"
                                    required
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup row className="mb-2">
                            <Label for="email" sm={4}>Email</Label>
                            <Col sm={7}>
                                <Input
                                    type="email"
                                    id="email"
                                    placeholder="Enter your email"
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                    size="sm"
                                    required
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup row className="mb-2">
                            <Label for="password" sm={4}>Password</Label>
                            <Col sm={7}>
                                <Input
                                    type="password"
                                    id="password"
                                    placeholder="Enter your password"
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                    size="sm"
                                    required
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup row className="mb-2">
                            <Label for="confirmPassword" sm={4}>Confirm Password</Label>
                            <Col sm={7}>
                                <Input
                                    type="password"
                                    id="confirmPassword"
                                    placeholder="Re-Enter your password"
                                    value={confirmPassword}
                                    onChange={(e) => setConfirmPassword(e.target.value)}
                                    size="sm"
                                    required
                                />
                            </Col>
                        </FormGroup>
                        <div className="d-flex justify-content-center mt-2">
                            <Button color="primary" type="submit">Create Account</Button>
                        </div>
                    </Form>
                </main>

                <Modal isOpen={modal} toggle={toggleModal}>
                    <ModalHeader toggle={toggleModal}>Account Created</ModalHeader>
                    <ModalBody>
                        {`Account for "${firstName} ${lastName}" was successfully created!`}
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={toggleModal}>OK</Button>
                    </ModalFooter>
                </Modal>
                <Modal isOpen={errorModal} toggle={toggleErrorModal}>
                    <ModalHeader toggle={toggleErrorModal}>Error</ModalHeader>
                    <ModalBody>
                        {errorMessage}
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={toggleErrorModal}>OK</Button>
                    </ModalFooter>
                </Modal>
            </div>
        </Container>
    );
};

export default CreateAccount;
