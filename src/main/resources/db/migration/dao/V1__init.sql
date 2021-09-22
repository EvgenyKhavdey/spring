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
('Max', '$2a$10$iAL3CKEsE6cjuORoVQjUMeWexzzlaVWVlx.oxgq8gSCJTdJ3a0nfO', 'max@gmail.com'),
('Nik', '$2a$10$3/Dm8JJcFf.2uE0z4ZG4m.RZKuPRMqsD1/OE/ogcb5APD1hP/W1fW', 'nik@gmail.com'),
('Gon', '$2a$10$CaFetNU3e5Q1E8gHKrgFt.JnH.k06rop/jI12mYDEZbv7s5rX5Rvy', 'gon@gmail.com');

insert into users_roles (user_id, role_id)
values
(1, 2),
(2, 1),
(3, 1);

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