DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM tea;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- password
INSERT INTO users (name, email, password)
VALUES ('User', 'user@gmail.com', 'password');
-- admin
INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 100000);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 100001);

INSERT INTO tea (name, category, country, description, rate, count_connoisseurs) VALUES
  ('Баймаохоу', 'Белый', 'Китай', 'Очень вкусный', 0, 0),
  ('Молочный улун', 'Светлый улун', 'Китай', 'Очень вкусный', 0, 0),
  ('Ассам Мангалам', 'Черный', 'Индия', 'Очень вкусный', 0, 0);

INSERT INTO comments (created, message, user_id, tea_id) VALUES
  ('2016-06-12 10:00:00', 'Это жемчужина чаев', '100000', '100003'),
  ('2016-06-11 08:00:00', 'Самый лучший чай', '100000', '100002');