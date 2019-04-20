INSERT INTO role (name) VALUES ('client');
INSERT INTO role (name) VALUES ('admin');

INSERT INTO user (first_name, last_name, email, password, role_id) VALUES
('Eric', 'Gomez', 'eric@example.com', '123', 2);

INSERT INTO user (first_name, last_name, email, password) VALUES
('Stan', 'Smith', 'stan@cia.com', 123),
('Scuba', 'Steve', 'steve@scuba.com', 123);

INSERT INTO product (title, unit_price, description, is_available) VALUES
('Cheeseburger', 9.99, 'Hello, World!', TRUE),
('Tamale', 19.99, 'Hello, World!', TRUE),
('Le Guac', 9.99, 'Hello, World!', TRUE),
('Pizza', 39.99, 'Hello, World!', TRUE);

INSERT INTO purchase (total, user_id) VALUES
(19.99, 2),
(34.99, 3);

INSERT INTO purchase_product (product_id, purchase_id) VALUES
(1, 1),
(3, 1),
(4, 1),
(1, 2),
(2, 2),
(4, 2);