CREATE DATABASE pelicula;
USE pelicula;
CREATE TABLE pelicula (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(255) DEFAULT NULL,
  descripcion text DEFAULT NULL,
  fecha date DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;