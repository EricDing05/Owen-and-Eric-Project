import React from 'react';
import { Container, Row, Col, Table } from 'reactstrap';

const PriceComparison = () => {
  const initialItems = [
    { id: 1, name: 'Apples', brand: 'Brand A', quantity: 10 },
    { id: 2, name: 'Bananas', brand: 'Brand B', quantity: 5 },
    { id: 3, name: 'Carrots', brand: 'Brand C', quantity: 8 },
  ];

  const initialStores = [
    { id: 1, name: 'Store 1', prices: { 1: 2.5, 2: 1.5, 3: 0.5 } },
    { id: 2, name: 'Store 2', prices: { 1: 2.8, 2: 1.4, 3: 0.6 } },
    { id: 3, name: 'Store 3', prices: { 1: 2.2, 2: 1.6, 3: 0.7 } },
    { id: 4, name: 'Store 4', prices: { 1: 2.9, 2: 1.3, 3: 0.8 } },
    { id: 5, name: 'Store 5', prices: { 1: 2.4, 2: 1.7, 3: 0.9 } },
    { id: 6, name: 'Store 6', prices: { 1: 2.7, 2: 1.2, 3: 1.0 } },
  ];

  const calculateTotal = (storePrices) => {
    return Object.values(storePrices).reduce((acc, price) => acc + (parseFloat(price) || 0), 0);
  };

  const storeTotals = initialStores.map(store => ({
    ...store,
    total: calculateTotal(store.prices),
  }));

  const bestStore = storeTotals.reduce((prev, current) => (prev.total < current.total) ? prev : current);

  return (
    <Container>
      <h3 className="mb-3">Price Comparison</h3>
      <Row>
        <Col md="4" className="mb-4">
          <div style={{ border: '3px solid green', padding: '3px' }}>
            <h5>Best Price: {bestStore.name}</h5>
            <Table striped>
              <thead>
                <tr>
                  <th>Item</th>
                  <th>Brand</th>
                  <th>Quantity</th>
                  <th>Price</th>
                </tr>
              </thead>
              <tbody>
                {initialItems.map(item => (
                  <tr key={item.id}>
                    <td>{item.name}</td>
                    <td>{item.brand}</td>
                    <td>{item.quantity}</td>
                    <td>${bestStore.prices[item.id].toFixed(2)}</td>
                  </tr>
                ))}
              </tbody>
            </Table>
            <h6>Total: ${bestStore.total.toFixed(2)}</h6>
          </div>
        </Col>
        {storeTotals.filter(store => store.id !== bestStore.id).map(store => (
          <Col key={store.id} md="4" className="mb-4">
            <div style={{ border: '3px solid red', padding: '3px' }}>
              <h5>{store.name}</h5>
              <Table striped>
                <thead>
                  <tr>
                    <th>Item</th>
                    <th>Brand</th>
                    <th>Quantity</th>
                    <th>Price</th>
                  </tr>
                </thead>
                <tbody>
                  {initialItems.map(item => (
                    <tr key={item.id}>
                      <td>{item.name}</td>
                      <td>{item.brand}</td>
                      <td>{item.quantity}</td>
                      <td>${store.prices[item.id].toFixed(2)}</td>
                    </tr>
                  ))}
                </tbody>
              </Table>
              <h6>Total: ${store.total.toFixed(2)}</h6>
            </div>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default PriceComparison;
