--liquibase formatted sql

--changeset Artem.Vartanov :Create_tables

insert into categories (title)
values ('Vegetable'),
       ('Meat'),
       ('Fruits'),
       ('chocolate_bars');
       ('Breed')
       ('milk_products')
       ('snack')
       ('sweet_water')


INSERT INTO products (title, price)
VALUES ('Onion', 85,1),
       ('Garlic', 120,1),
       ('Orange', 200,3),
       ('Potato', 100,1),
       ('Melon', 100,3),
       ('Watermelon ',140,3),
       ('Tomato', 70,1),
       ('Breed', 30,1,5),
       ('Cheese', 350,6),
       ('Milk', 75,6),
       ('Meat', 400,2),
       ('Lemon', 60,3),
       ('Weed', 1500,1),
       ('Cheeps', 105,7),
       ('Lemonade', 75,8),
       ('IceCream', 70,6),
       ('Snickers', 65,4),
       ('Mars', 60,4),
       ('Sausage', 200,2),
       ('ProteinBar', 150,4);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

 INSERT INTO  users (username, password, email)
              VALUES ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'bob_johnson@gmail.com'),
                     ('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'john_johnson@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);