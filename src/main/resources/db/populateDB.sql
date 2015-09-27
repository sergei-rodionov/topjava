DELETE FROM meals;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- password
INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');
-- admin
INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 100000);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 100001);

-- meals
INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Завтрак', 200, '2015-05-28 09:00:00+03', 100000);
INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Обед', 1200, '2015-05-28 13:00:00+03', 100000);
INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Ужин', 500, '2015-05-28 19:00:00+03', 100000);

INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Завтрак', 200, '2015-05-29 09:00:00+03', 100000);
INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Обед', 1350, '2015-05-29 13:00:00+03', 100000);
INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Ужин', 500, '2015-05-29 19:00:00+03', 100000);

INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Завтрак admin', 500, '2015-05-28 09:30:00+03', 100001);
INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Обед admin', 1000, '2015-05-28 13:20:00+03', 100001);
INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Ужин admin', 200, '2015-05-28 19:01:00+03', 100001);

INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Завтрак admin', 500, '2015-05-30 09:30:00+03', 100001);
INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Обед admin', 1100, '2015-05-30 13:20:00+03', 100001);
INSERT INTO meals (description, calories, datetime, user_id)
VALUES ('Ужин admin', 500, '2015-05-30 19:01:00+03', 100001);