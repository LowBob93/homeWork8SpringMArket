
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

       CREATE TABLE users
       (
           id         bigserial primary key,
           username   varchar(30) unique,
           password   varchar(80) not null,
           email      varchar(50) unique,
           created_at timestamp default current_timestamp,
           updated_at timestamp default current_timestamp
       );

       INSERT INTO  users (username, password, email)
              VALUES ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
                     ('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');


       CREATE TABLE roles
       (
           id         bigserial primary key,
           name       varchar(50) not null,
           created_at timestamp default current_timestamp,
           updated_at timestamp default current_timestamp
       );
       INSERT INTO  roles (name)
              VALUES ('ROLE_USER'),
                     ('ROLE_ADMIN');


       CREATE TABLE users_roles
       (
           user_id bigint not null references users (id),
           role_id bigint not null references roles (id),
           primary key (user_id, role_id)
       );


       INSERT INTO  users_roles (user_id, role_id)
       VALUES (1, 1),
              (2, 2);