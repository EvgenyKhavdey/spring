create table product
(
    id     bigserial primary key,
    title  text,
    cost   int
);

insert into product(title, cost)
values ('Хлеб Бородинский', 51),
       ('Хлеб Ржаной', 42),
       ('Мясо Птицы', 236),
       ('Мясо Говядина', 412),
       ('Рыба', 892),
       ('Сыр', 167),
       ('Молоко', 72);