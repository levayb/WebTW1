
CREATE TABLE IF NOT EXISTS accounts (
    id SERIAL PRIMARY KEY,
    username TEXT UNIQUE NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    mentor BOOLEAN DEFAULT false
);

CREATE TABLE IF NOT EXISTS assignments (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL,
    imgsrc TEXT NOT NULL,
    about TEXT NOT NULL,
    origin TEXT NOT NULL,
    spread TEXT NOT NULL
);

INSERT INTO accounts (username, email, password, mentor) VALUES
	('admin', 'ad@mi.n', 'admin', 'true') ON CONFLICT DO NOTHING
