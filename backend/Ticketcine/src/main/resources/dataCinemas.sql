/*CINEMA TABLE'S INSERTS*/
insert into cinema (id,name,city,direction,state, active) values
( 1, 'Cinemacenter' , 'San Fernando del Valle de Catamarca' , 'Intendente Mamerto Medina 220', 'Catamarca', 1),
(2, 'Centro Cultural San Agustín' , 'Santa Maria' , 'San Martin 173' ,'Catamarca', 1),
(3, 'Los Cines De La Costa','Resistencia', 'Av. Sarmiento 2600','Chaco', 1),
(4,'Deborah Jones De Williams','Sarmiento','Reg. Inf. Mec. 25 Esquina 20 De Junio', 'Chubut', 1),
(5, 'Fantasio','Bella Vista','Reg. Inf. Mec. 25 Esquina 20 De Junio', 'Corrientes', 1),
(6, 'Luna De Avellaneda', 'General Obligado', 'Av.Santa Fe 1290' ,'Santa Fe', 1),
(7, 'Hoyts', 'San Isidro 656' ,'Buenos Aires', 'Perez Reverte 555', 1),
(8 , 'Atlantic', 'Villa Gesell', 'Villa Gesell 2300','Buenos Aires', 1),
(9 , 'Centro Cine Teatro Español','Chacabuco','Corrientes 242', 'Buenos Aires', 1),
(10, 'Cine Teatro Sociedad Italiana','Maipu', 'Av.Maipu 1456', 'Buenos Aires', 1),
(11 , 'Cpm Cinemas Catan Shopping','La Matanza', 'Huo del Carril 1221', 'Buenos Aires', 1),
(12 , 'Cine San Martin', 'Las Flores', 'Las Flores 2121' , 'Buenos Aires', 1);

/*SCREEN TABLE'S INSERTS*/
INSERT INTO screen (id, active, name, cinema_id, screening) 
VALUES 
('1', 1, 'Screen 1', '1', '2D'),
('2', 1, 'Screen 2', '1', '3D'),
('3', 1, 'Screen 1', '2', '2D'),
('4', 1, 'Screen 1', '3', '3D'),
('5', 1, 'Screen 1', '1', '2D'),
('6', 1, 'Screen 2', '1', '3D'),
('7', 1, 'Screen 1', '2', '2D'),
('8', 1, 'Screen 1', '3', '3D'),
('9', 1, 'Screen 1', '1', '2D'),
('10', 1, 'Screen 2', '1', '3D'),
('11', 1, 'Screen 1', '2', '2D'),
('12', 1, 'Screen 1', '3', '3D');

/*Para movies... para que sea más larga, JAJAJA*/
ALTER TABLE movie MODIFY COLUMN description VARCHAR(1024); -- Ajusta el tamaño según sea necesario