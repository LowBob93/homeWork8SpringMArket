
CREATE TABLE products
(
    id    bigserial primary key,
    title VARCHAR(255),
    price int
);

INSERT INTO products (title, price)
VALUES ('Onion', 85),
       ('Garlic', 120),
       ('Orange', 200),
       ('Potato', 100),
       ('Melon', 100),
       ('Watermelon ',140),
       ('Tomato', 70),
       ('Breed', 30),
       ('Cheese', 350),
       ('Milk', 75),
       ('Meat', 400),
       ('Lemon', 60),
       ('Weed', 1500),
       ('Cheeps', 105),
       ('Lemonade', 75),
       ('IceCream', 70),
       ('Snickers', 65),
       ('Mars', 60),
       ('Sausage', 200),
       ('ProteinBar', 150);