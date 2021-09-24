create table product
(
    id          bigserial primary key,
    title       varchar(255),
    cost        int,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

insert into product(title, cost)
values ('Хлеб Бородинский', 51),
       ('Хлеб Ржаной', 42),
       ('Каша Рисовая', 45),
       ('Каша Гречневая', 49),
       ('Мясо Птицы', 236),
       ('Мясо Говядина', 412),
       ('Колбаса', 291),
       ('Сосиски', 264),
       ('Рыба', 892),
       ('Сыр', 167),
       ('Йогурт', 89),
       ('Творог', 136),
       ('Молоко', 72),
       ('Шоколад', 129),
       ('Конфеты', 108),
       ('Яйца', 77),
       ('Майонез', 36);

create table order_items
(
    id             bigserial primary key,
    title          varchar(255),
    quantity       int,
    price_per_item int,
    price          int
);

create table users (
                       id                    bigserial,
                       username              varchar(30) not null,
                       password              varchar(80) not null,
                       email                 varchar(50) unique,
                       primary key (id)
);

create table roles (
                       id                    serial,
                       name                  varchar(50) not null,
                       primary key (id)
);

CREATE TABLE users_roles (
                             user_id               bigint not null,
                             role_id               int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)
);

insert into roles (name)
values
    ('ROLE_USER'), ('ROLE_SUPERADMIN');

insert into users (username, password, email)
values
    ('Max', '$2a$10$0mZas6NX2LUYDh9JX4PYuexwOlgjSK.3SCPQNczR7eK2X8RvT.ESy', 'max@gmail.com'),
    ('Nik', '$2a$10$.QUl8A8cdL/YEN3Vy.369Ofkmsk6sFevABezTlb5k8CxPk6jKOVBu', 'nik@gmail.com'),
    ('Gon', '$2a$10$p71rtTZ2Hg6PqNDxNSxUtOwZy0.RHbEm5qJRkTZ.2ehgawWJLTZ3u', 'gon@gmail.com');

insert into users_roles (user_id, role_id)
values
    (1, 2),
    (2, 1),
    (3, 1);