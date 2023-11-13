
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS movies;


CREATE TABLE genres(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE movies(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL,
    details TEXT NOT NULL,
    releaseDate DATE NOT NULL,
    genres_id INT NOT NULL,
    FOREIGN KEY (genres_id) REFERENCES genres(id) ON DELETE SET NULL ON UPDATE CASCADE
);


INSERT INTO genres (nom, description) VALUES ("fantastique", "des dragons des mgiciens");
INSERT INTO genres (nom, description) VALUES ("policier", "en enquête incroyable");

INSERT INTO movies (nom, details, releaseDate, genres_id) VALUES ("Harry Potter", "ecole des sortiés", "2003-01-01", 1 );
INSERT INTO movies (nom, details, releaseDate, genres_id) VALUES ("Harry Potter", "Prisonier d'escaban", "2001-01-01", 2);

SELECT m.nom, m.details, m.releaseDate FROM movies m JOIN genres g ON m.genres_id = g.id;
