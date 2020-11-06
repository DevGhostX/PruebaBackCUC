insert into cliente (apellido, dni, email, nombre, telefono) values ('Jearum', '715907568', 'tjearum0@archive.org', 'Tess', '8143544083');
insert into cliente (apellido, dni, email, nombre, telefono) values ('Elster', '750261567', 'kelster1@instagram.com', 'Kirstyn', '5671574007');
insert into cliente (apellido, dni, email, nombre, telefono) values ('Rizzello', '354245861', 'krizzello2@forbes.com', 'Kally', '4856368492');
insert into cliente (apellido, dni, email, nombre, telefono) values ('McReynold', '448847228', 'jmcreynold3@linkedin.com', 'Jemie', '3342028037');
insert into cliente (apellido, dni, email, nombre, telefono) values ('Venard', '429529447', 'mvenard4@dropbox.com', 'Margy', '2169988170');
insert into cliente (apellido, dni, email, nombre, telefono) values ('Noen', '674500214', 'tnoen5@meetup.com', 'Tabb', '5028178091');

insert into usuario (username, password) values ('user', '$2a$10$pghsonXOXriqPOAYsZ1FPe4DGjwDU/.YEV3eUKCwNMQXPzCTYKsoa');
insert into usuario (username, password) values ('admin', '$2a$10$Yl1evhuM9F.SJ5MW.GddyOWlSxnFFAJ8P1860AypreUP3OkkBZSAC');

insert into producto (nombre, precio) values ('Salmon - Atlantic, Skin On', 32.91);
insert into producto (nombre, precio) values ('Spring Roll Veg Mini', 95.85);
insert into producto (nombre, precio) values ('Nantucket - Pomegranate Pear', 90.53);
insert into producto (nombre, precio) values ('Wine - Sherry Dry Sack, William', 87.47);
insert into producto (nombre, precio) values ('Steam Pan Full Lid', 95.94);
insert into producto (nombre, precio) values ('Cheese - Gouda', 81.14);

insert into venta (fecha, id_cliente) values (getdate(), 1);

insert into detalle_venta (id_producto, id_venta) values (1, 1);
insert into detalle_venta (id_producto, id_venta) values (3, 1);
insert into detalle_venta (id_producto, id_venta) values (4, 1);

insert into venta (fecha, id_cliente) values (getdate(), 2);

insert into detalle_venta (id_producto, id_venta) values (5, 2);
insert into detalle_venta (id_producto, id_venta) values (6, 2);
insert into detalle_venta (id_producto, id_venta) values (2, 2);