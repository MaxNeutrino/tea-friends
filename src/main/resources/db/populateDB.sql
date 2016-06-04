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

INSERT INTO tea (name, category, country, description) VALUES
  ('Баймаохоу', 'Белый', 'Китай', 'Очень вкусный'),
  ('Молочный улун', 'Светлый улун', 'Китай', 'Очень вкусный');