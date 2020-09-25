CREATE DATABASE ice_cream_shop;
use ice_cream_shop;

CREATE TABLE users(
user_id int primary key auto_increment,
user_name varchar(100) NOT NULL,
user_password varchar(100) NOT NULL,
user_email varchar(225) NOT NULL
);

CREATE TABLE category(
category_id int primary Key auto_increment,
category_name varchar(100) NOT NULL
);

CREATE TABLE ice_cream(
ice_cream_id int PRIMARY KEY auto_increment,
category_id int,
name varchar(255) NOT NULL,
discount int,
ice_description text,
price double(10,3) NOT NULL,
scr text,
sold_quantity int,
foreign key (category_id) references category(category_id)
 );
 
 CREATE TABLE orders(
 order_id int primary key auto_increment,
 name_customer varchar(50), 
 address_customer varchar(200),
 numberphone_customer varchar(20),
 total_money double(10,3)
 );
 
 CREATE TABLE item(
 item_id int primary key auto_increment,
 order_id int ,
 ice_cream_id int,
 pice_discount double(10,3) NOT NULL,
 quality int NOT NULL,
 total_money double (10,3)
 foreign key (order_id) references orders (order_id),
 foreign key (ice_cream_id) references ice_cream(ice_cream_id)
 );
 
 