CREATE DATABASE hexa;
USE hexa;
CREATE TABLE honey (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  characteristics VARCHAR(5000) NOT NULL,
  price DOUBLE NOT NULL,
  stock INT(6) NOT NULL
);

INSERT INTO honey (name, characteristics, price, stock) VALUES
	('Lavender Honey', '250g sweet honey with a hint of lavender aroma.', 29.00, 10),
    ('Acacia Honey', 'Delicate honey with a light floral flavor, 250g.', 42.00, 20),
    ('Heather Honey', 'Rich and malty honey with a hint of heather, 250g.', 28.00, 8),
    ('Buckwheat Honey', 'Dark and robust honey from buckwheat flowers, 250g.', 18.00, 3),
	('Orange Blossom Honey', '250g citrusy honey with a touch of orange blossom.', 20.00, 15);
    
    