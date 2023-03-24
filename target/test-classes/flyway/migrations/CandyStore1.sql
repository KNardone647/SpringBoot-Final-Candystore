DROP TABLE IF EXISTS orderDetials;
DROP TABLE IF EXISTS orders; 
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products; 


CREATE TABLE products(
product_id INT AUTO_INCREMENT NOT NULL,
product_name VARCHAR(128) NOT NULL,
cost DECIMAL(5,2),
inventory INT,
common_allergiens VARCHAR(128),
ingredients TEXT,
brand TEXT, 
type_product varchar(50),
PRIMARY KEY(product_id) 

);



CREATE TABLE customers(
customer_id INT AUTO_INCREMENT NOT NULL, 
first_name varchar(50) NOT NULL, 
last_name varchar(50) NOT NULL, 
phone varchar(20),
PRIMARY KEY(customer_id) 

);

CREATE TABLE orders(
order_id INT AUTO_INCREMENT NOT NULL, 
customer_id INT NOT NULL,
FOREIGN KEY(customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE,
size TEXT,
order_date DATE NOT NULL,
PRIMARY KEY(order_id)

);


CREATE TABLE orderDetials(
order_id INT NOT NULL, 
product_id INT NOT NULL,
FOREIGN KEY(order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
FOREIGN KEY(product_id) REFERENCES products(product_id) ON DELETE CASCADE,
quantity int, 
paid_each decimal(5,2)

);

