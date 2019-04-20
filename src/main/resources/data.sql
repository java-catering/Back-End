INSERT INTO role (name) VALUES ('client');
INSERT INTO role (name) VALUES ('admin');

INSERT INTO user (first_name, last_name, email, password, role_id) VALUES
('Eric', 'Gomez', 'eric@example.com', '123', 2);

INSERT INTO user (first_name, last_name, email, password) VALUES
('Stan', 'Smith', 'stan@cia.com', 123),
('Scuba', 'Steve', 'steve@scuba.com', 123);

