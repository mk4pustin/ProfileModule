CREATE TABLE flowers (
    flower_id SERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE,
    price INTEGER NOT NULL
);

CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    phone TEXT NOT NULL UNIQUE
);

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL REFERENCES customers(customer_id),
    flower_id INTEGER NOT NULL REFERENCES flowers(flower_id),
    quantity INTEGER NOT NULL CHECK (quantity > 0 AND quantity <= 1000),
	order_date TIMESTAMP NOT NULL DEFAULT NOW()
);

INSERT INTO flowers (name, price) VALUES 
    ('Розы', 100),
    ('Лилии', 50),
    ('Ромашки', 25);

INSERT INTO customers (name, phone) VALUES 
    ('Иванов Иван Иванович', '+79991112233'),
    ('Петров Петр Петрович', '+79994445566');

INSERT INTO orders (customer_id, flower_id, quantity) VALUES 
    (1, 1, 1),
    (2, 2, 2),
    (1, 3, 3),
    (2, 3, 3);

SELECT order_id, orders.customer_id, order_date, flower_id, name, phone
	FROM orders
	JOIN customers ON orders.customer_id = customers.customer_id
	WHERE orders.order_id = 1;
	
SELECT *
	FROM orders
	WHERE customer_id = 1 AND order_date >= NOW() - INTERVAL '1 month';

SELECT flowers.name, orders.quantity 
	FROM orders
	JOIN flowers ON orders.flower_id = flowers.flower_id
	WHERE orders.quantity = (
		SELECT MAX(quantity) FROM orders
);

SELECT SUM(orders.quantity * flowers.price) AS total_revenue
	FROM orders
	JOIN flowers ON orders.flower_id = flowers.flower_id;



