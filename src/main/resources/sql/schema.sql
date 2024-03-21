CREATE TABLE authors
(
    id          SERIAL PRIMARY KEY,
    author_name VARCHAR(200) NOT NULL,
    gender      VARCHAR(15)  NOT NULL
);

CREATE TABLE books(
    id SERIAL PRIMARY KEY ,
    title varchar(50) NOT NULL ,
    published_date timestamp NOT NULL ,
    author_id INT REFERENCES authors(id) ON DELETE CASCADE
);

CREATE TABLE categories(
    id SERIAL PRIMARY KEY ,
    category_name varchar(255) NOT NULL
);

CREATE TABLE book_category(
    book_id INT REFERENCES books(id) ON DELETE CASCADE ,
    category_id INT REFERENCES  categories(id) ON DELETE CASCADE
);

SELECT c.id, c.category_name FROM categories c
JOIN book_category bc ON c.id = bc.category_id
WHERE bc.book_id = 1;

INSERT INTO books (title, published_date, author_id)
VALUES ('Kolab Pailenn', now(), 4)
RETURNING id;

INSERT INTO book_category
VALUES (4, 2)