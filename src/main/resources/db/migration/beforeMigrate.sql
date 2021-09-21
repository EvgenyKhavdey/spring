create table score
(
    id    bigserial primary key,
    name  text,
    ball  int
);

insert into score(name, ball)
values ('Max', 15),
       ('Nik', 20),
       ('Gon', 30);