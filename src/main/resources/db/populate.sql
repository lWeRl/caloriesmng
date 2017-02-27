DELETE FROM users;
DELETE FROM user_roles;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users(name, email, password) VALUES ('User', 'user@test.ru', 'user');
INSERT INTO users(name, email, password) VALUES ('Admin', 'admin@test.ru', 'admin');

INSERT INTO user_roles(user_id, role) VALUES (100000, 'USER');
INSERT INTO user_roles(user_id, role) VALUES (100001, 'ADMIN');

INSERT INTO meals (date, description, calories, user_id) VALUES ('2017-01-06 09:00:00', 'завтрак', 500, 100000);
INSERT INTO meals (date, description, calories, user_id) VALUES ('2017-01-06 13:00:00', 'обед', 1000, 100000);
INSERT INTO meals (date, description, calories, user_id) VALUES ('2017-01-07 00:00:00', 'ужин', 600, 100000);
INSERT INTO meals (date, description, calories, user_id) VALUES ('2017-01-07 13:00:00', 'еще обед', 1300, 100000);
INSERT INTO meals (date, description, calories, user_id) VALUES ('2017-01-06 14:00:00', 'еда админа', 2000, 100001);