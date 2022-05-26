INSERT INTO personas(nombre, apellido_paterno, apellido_materno, identificacion) VALUES ('CRISTHIAN', 'VILLEGAS', 'GARCIA', 'A12345');
INSERT INTO personas(nombre, apellido_paterno, apellido_materno, identificacion) VALUES ('LUIS MIGUEL', 'WAYNE', null, 'A123456');
INSERT INTO personas(nombre, apellido_paterno, apellido_materno, identificacion) VALUES ('ESMERALDA', 'GARCIA', null, 'A123457');
INSERT INTO personas(nombre, apellido_paterno, apellido_materno, identificacion) VALUES ('ANGELA', 'BALLADO', 'LAURIANI', 'A123458');

INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 1000.0, 1);
INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 2000.0, 2);
INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 3000.0, 4);
INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 4000.0, 3);
INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 12300.0, 3);
INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 800.0, 1);
INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 500.0, 2);
INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 4500.0, 2);
INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 12500.0, 3);
INSERT INTO facturas(fecha, monto, fk_persona) VALUES (NOW(), 1000.0, 1);