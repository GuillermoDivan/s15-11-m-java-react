-- Inserts para la tabla 'cinema' con ciudades de Argentina y IDs numéricos
INSERT INTO ticketcine.cinema (id, city, direction, name, state, active)
VALUES
    (1, 'Buenos Aires', 'Calle 1', 'Cine Buenos Aires 1', 'Buenos Aires', 1),
    (2, 'Córdoba', 'Calle 2', 'Cine Córdoba 2', 'Córdoba', 1),
    (3, 'Rosario', 'Calle 3', 'Cine Rosario 3', 'Santa Fe', 1),
    (4, 'Mendoza', 'Calle 4', 'Cine Mendoza 4', 'Mendoza', 1),
    (5, 'Salta', 'Calle 5', 'Cine Salta 5', 'Salta', 1),
    (6, 'San Juan', 'Calle 6', 'Cine San Juan 6', 'San Juan', 1),
    (7, 'La Plata', 'Calle 7', 'Cine La Plata 7', 'Buenos Aires', 1),
    (8, 'Santa Fe', 'Calle 8', 'Cine Santa Fe 8', 'Santa Fe', 1),
    (9, 'San Miguel de Tucumán', 'Calle 9', 'Cine Tucumán 9', 'Tucumán', 1),
    (10, 'Mar del Plata', 'Calle 10', 'Cine Mar del Plata 10', 'Buenos Aires', 1),
    (11, 'San Juan', 'Calle 11', 'Cine San Juan 11', 'San Juan', 1),
    (12, 'Resistencia', 'Calle 12', 'Cine Resistencia 12', 'Chaco', 1),
    (13, 'Corrientes', 'Calle 13', 'Cine Corrientes 13', 'Corrientes', 1),
    (14, 'Posadas', 'Calle 14', 'Cine Posadas 14', 'Misiones', 1),
    (15, 'Neuquén', 'Calle 15', 'Cine Neuquén 15', 'Neuquén', 1);

-- Inserts para la tabla 'screen' con IDs numéricos
INSERT INTO ticketcine.screen (id, active, name, cinema_id, screening)
VALUES
    (1, 1, 'Screen 1', 1, 'Screening 1'),
    (2, 1, 'Screen 2', 1, 'Screening 2'),
    (3, 1, 'Screen 3', 1, 'Screening 3'),
    (4, 1, 'Screen 4', 1, 'Screening 4'),
    (5, 1, 'Screen 5', 1, 'Screening 5'),
    (6, 1, 'Screen 6', 2, 'Screening 6'),
    (7, 1, 'Screen 7', 2, 'Screening 7'),
    (8, 1, 'Screen 8', 2, 'Screening 8'),
    (9, 1, 'Screen 9', 2, 'Screening 9'),
    (10, 1, 'Screen 10', 3, 'Screening 10'),
    (11, 1, 'Screen 11', 3, 'Screening 11'),
    (12, 1, 'Screen 12', 3, 'Screening 12'),
    (13, 1, 'Screen 13', 4, 'Screening 13'),
    (14, 1, 'Screen 14', 4, 'Screening 14'),
    (15, 1, 'Screen 15', 4, 'Screening 15');

-- Inserts para la tabla 'seat' con IDs numéricos
INSERT INTO ticketcine.seat (id, availability, reserved, seat_number, screen_id, cinema_id, ticket_id)
VALUES
    -- Asientos para Screen 1
    (1, 1, 0, 'Fila 1, Asiento 1', 1, 1, NULL),
    (2, 1, 0, 'Fila 2, Asiento 2', 1, 1, NULL),
    (3, 1, 0, 'Fila 3, Asiento 3', 1, 1, NULL),
    -- Asientos para Screen 2
    (4, 1, 0, 'Fila 1, Asiento 1', 2, 1, NULL),
    (5, 1, 0, 'Fila 2, Asiento 2', 2, 1, NULL),
    (6, 1, 0, 'Fila 3, Asiento 3', 2, 1, NULL),
    -- Asientos para Screen 3
    (7, 1, 0, 'Fila 1, Asiento 1', 3, 1, NULL),
    (8, 1, 0, 'Fila 2, Asiento 2', 3, 1, NULL),
    (9, 1, 0, 'Fila 3, Asiento 3', 3, 1, NULL);


ALTER TABLE movie MODIFY COLUMN description VARCHAR(10000); -- Ajusta el tamaño según sea necesario