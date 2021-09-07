create table product
(
    id    bigserial primary key,
    title  text,
    cost int
);

insert into product(title, cost)
values ('Хлеб', 51),
       ('Мясо', 412),
       ('Рыба', 892),
       ('Сыр', 167),
       ('Молоко', 72);

create table person
(
    id    bigserial primary key,
    name  text
);

insert into person(name)
values ('Alexander'),
       ('Sergey'),
       ('Dmitriy');

create table product_person
(
    product_id bigint,
    person_id bigint,
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (person_id) REFERENCES person (id)
);

insert into product_person(product_id,person_id )
values (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (1, 2),
       (2, 2),
       (4, 2),
       (1, 3),
       (2, 3);