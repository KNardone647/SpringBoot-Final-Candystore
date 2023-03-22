INSERT INTO products (product_id , product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) 
VALUES(1, 'Coke', 1.50, 15, 'none', 'water, carbonation, syrup', 'Coca Cola', 'Soda');
INSERT INTO products (product_id , product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) 
VALUES(2, 'Sprite', 2.50, 11, 'none', 'water, carbonation, syrup', 'Coca Cola', 'Soda');
INSERT INTO products (product_id , product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) 
VALUES(3, 'Orange Soda', 3.50, 5, 'none', 'water, carbonation, syrup', 'Coca Cola', 'Soda');
INSERT INTO products (product_id , product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) 
VALUES(4, 'Chocolate Fudge', 5.50, 10, 'none', 'sugar, chocolate', 'Made In Shop', 'Chocolate');
INSERT INTO products (product_id , product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) 
VALUES(5, 'Candy Cane', 1.50, 30, 'none', 'food coloring, sugar, syrup', 'Made In Shop', 'Candy');
INSERT INTO products (product_id , product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) 
VALUES(6, 'Taffy', 2.50, 35, 'none', 'water, carbonation, syrup', 'Made In Shop', 'Candy');
INSERT INTO products (product_id , product_name, cost, inventory, common_allergiens, ingredients, brand, type_product) 
VALUES(7, 'Chocolate Ice Cream', 5.50, 20, 'dairy', 'milk, chocolate, sugar', 'Ben and Jerry', 'Ice Cream');

INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES(1, 'Melissa', 'Jones','755.223.5969');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES(2, 'Esmery', 'Ramirez', '755.223.5769');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES(3, 'John', 'Petter', '400.223.5888');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES(4, 'Melissa', 'Burns', '755.300.5969');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES(5, 'Jody', 'Peterson', '655.223.4000');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES(6, 'Michael', 'Fox', '755.888.5000');
INSERT INTO customers (customer_id, first_name, last_name, phone) VALUES(7, 'Jamie', 'Fox', '929.223.5969');

INSERT INTO orders (order_id , customer_id, size, order_date) VALUES(1, 2, 'medium', '2022-12-31');
INSERT INTO orders (order_id , customer_id, size, order_date) VALUES(2, 2, 'medium', '2021-12-14');
INSERT INTO orders (order_id , customer_id, size, order_date) VALUES(3, 4, 'large', '2023-01-04');
INSERT INTO orders (order_id , customer_id, size, order_date) VALUES(4, 3, 'large', '2023-02-08');
INSERT INTO orders (order_id , customer_id, size, order_date) VALUES(5, 6, 'small', '2022-12-05');
INSERT INTO orders (order_id , customer_id, size, order_date) VALUES(6, 1, 'small', '2023-03-15');
INSERT INTO orders (order_id , customer_id, size, order_date) VALUES(7, 2, 'small', '2022-12-31');

INSERT INTO orderDetials (order_id , product_id, quantity, paid_each) VALUES(2, 6, 1, 2.50);
INSERT INTO orderDetials (order_id , product_id, quantity, paid_each) VALUES(1, 4, 3, 22.00);
INSERT INTO orderDetials (order_id , product_id, quantity, paid_each) VALUES(3, 3, 1, 3.50);
INSERT INTO orderDetials (order_id , product_id, quantity, paid_each) VALUES(4, 7, 2, 11.00);
INSERT INTO orderDetials (order_id , product_id, quantity, paid_each) VALUES(5, 5, 2, 3.00);
INSERT INTO orderDetials (order_id , product_id, quantity, paid_each) VALUES(6, 5, 3, 4.50);
INSERT INTO orderDetials (order_id , product_id, quantity, paid_each) VALUES(7, 1, 2, 3.00);

