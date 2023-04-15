/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  BYRON
 * Created: 7/03/2023
 */

/* Creando algunos usuarios con sus roles */
-- INSERT INTO usuario (nombre, email, nombre_usuario, password) VALUES ('Byron','byron@micorreo.com','byron','20120815');
-- INSERT INTO usuario (nombre, email, nombre_usuario, password) VALUES ('Administrador','admin@micorreo.com','admin','20120815');
-- INSERT INTO usuario (nombre, apellido, email, telefono, nombre_usuario, password, fecha_registro, estado) VALUES ('Administrador', 'Administrador', 'admin@micorreo.com', '00001111', 'admin', '$2a$10$NY3DPh6qR68OgCB2L3A/LO/zDmHztsk2lUW35cXBBZa1GwXjOOp6G','2023-03-29',true)
INSERT INTO usuario (dpi, nombre, apellido, direccion, email, telefono, nombre_usuario, password, fecha_registro, estado) VALUES (1234567890123, 'Administrador', 'Administrador','Direccion', 'admin@micorreo.com', '00001111', 'admin', '$2a$10$NY3DPh6qR68OgCB2L3A/LO/zDmHztsk2lUW35cXBBZa1GwXjOOp6G','2023-03-29',true)

INSERT INTO rol (rol_nombre) VALUES ('ROLE_USER');
INSERT INTO rol (rol_nombre) VALUES ('ROLE_ADMIN');
INSERT INTO rol (rol_nombre) VALUES ('ROLE_PRODUCTOR');

INSERT INTO usuario_rol (usuario_id, rol_id) VALUES (1,1);
INSERT INTO usuario_rol (usuario_id, rol_id) VALUES (1,2);
-- INSERT INTO usuario_rol (usuario_id, rol_id) VALUES (2,2);

