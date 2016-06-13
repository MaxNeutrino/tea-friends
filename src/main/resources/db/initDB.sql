DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS tea CASCADE;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS user_wish_tea;
DROP TABLE IF EXISTS user_drunk_tea;
DROP TABLE IF EXISTS tea_rate;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now()
);

CREATE UNIQUE INDEX unique_email ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE tea
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR NOT NULL,
  category VARCHAR NOT NULL,
  country VARCHAR NOT NULL,
  description VARCHAR NOT NULL,
  rate INTEGER,
  count_connoisseurs INTEGER
);

CREATE TABLE comments
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  created TIMESTAMP DEFAULT now(),
  message VARCHAR NOT NULL,
  user_id INTEGER NOT NULL,
  tea_id INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (tea_id) REFERENCES tea (id) ON DELETE CASCADE
);

CREATE TABLE user_wish_tea
(
  user_id INTEGER NOT NULL,
  tea_id INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (tea_id) REFERENCES tea (id) ON DELETE CASCADE,
  CONSTRAINT wish_tea_pkey PRIMARY KEY (user_id, tea_id)
);

CREATE TABLE user_drunk_tea
(
  user_id INTEGER NOT NULL,
  tea_id INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (tea_id) REFERENCES tea (id) ON DELETE CASCADE,
  CONSTRAINT drunk_tea_pkey PRIMARY KEY (user_id, tea_id)
);

CREATE TABLE tea_rate
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  rate INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  tea_id INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (tea_id) REFERENCES tea (id) ON DELETE CASCADE
)
