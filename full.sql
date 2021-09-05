BEGIN;

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255), cost int);
INSERT INTO product (title, cost) VALUES
('Хлеб', 51),
('Мясо', 412),
('Рыба', 892),
('Сыр', 167),
('Молоко', 72);

DROP TABLE IF EXISTS person CASCADE;
CREATE TABLE person (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO person (name) VALUES
('Alexander'),
('Sergey'),
('Dmitriy');

DROP TABLE IF EXISTS product_person CASCADE;
CREATE TABLE product_person (product_id bigint, person_id bigint, FOREIGN KEY (product_id) REFERENCES product (id), FOREIGN KEY (person_id) REFERENCES person (id));
INSERT INTO product_person (product_id, person_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(1, 2),
(2, 2),
(4, 2),
(1, 3),
(2, 3);

COMMIT;