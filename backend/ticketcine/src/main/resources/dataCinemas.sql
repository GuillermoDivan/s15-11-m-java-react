/*CINEMA TABLE'S INSERTS*/
insert into cinema (id,name,city,direction,state) values 
( 1, 'Cinemacenter' , 'San Fernando del Valle de Catamarca' , 'Intendente Mamerto Medina 220', 'Catamarca'), 
(2, 'Centro Cultural San Agustín' , 'Santa Maria' , 'San Martin 173' ,'Catamarca' ), 
(3, 'Los Cines De La Costa','Resistencia', 'Av. Sarmiento 2600','Chaco'),
(4,'Deborah Jones De Williams','Sarmiento','Reg. Inf. Mec. 25 Esquina 20 De Junio', 'Chubut'),
(5, 'Fantasio','Bella Vista','Reg. Inf. Mec. 25 Esquina 20 De Junio', 'Corrientes'),
(6, 'Luna De Avellaneda', 'General Obligado', 'Av.Santa Fe 1290' ,'Santa Fe'),
(7, 'Hoyts', 'San Isidro 656' ,'Buenos Aires', 'Perez Reverte 555'),
(8 , 'Atlantic', 'Villa Gesell', 'Villa Gesell 2300','Buenos Aires'),
(9 , 'Centro Cine Teatro Español','Chacabuco','Corrientes 242', 'Buenos Aires'),
(10, 'Cine Teatro Sociedad Italiana','Maipu', 'Av.Maipu 1456', 'Buenos Aires'),
(11 , 'Cpm Cinemas Catan Shopping','La Matanza', 'Huo del Carril 1221', 'Buenos Aires'),
(12 , 'Cine San Martin', 'Las Flores', 'Las Flores 2121' , 'Buenos Aires');

/*SCREEN TABLE'S INSERTS*/
INSERT INTO screen (id, active, name, cinema_id, screening) 
VALUES 
('1', 1, 'Screen 1', '1', '2D'),
('2', 1, 'Screen 2', '1', '3D'),
('3', 1, 'Screen 1', '2', '2D'),
('4', 1, 'Screen 1', '3', '3D');
('1', 1, 'Screen 1', '1', '2D'),
('2', 1, 'Screen 2', '1', '3D'),
('3', 1, 'Screen 1', '2', '2D'),
('4', 1, 'Screen 1', '3', '3D'); 
('1', 1, 'Screen 1', '1', '2D'),
('2', 1, 'Screen 2', '1', '3D'),
('3', 1, 'Screen 1', '2', '2D'),
('4', 1, 'Screen 1', '3', '3D');
