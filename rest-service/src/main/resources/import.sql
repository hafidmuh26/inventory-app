-- password = password
INSERT INTO `user` (id, username, password, activated) VALUES ('1', 'admin', '{bcrypt}$2y$10$NkcV4yvFbQ89UcXJY8atle.SWYmYwz6y2bZlyUq4IV/uaQY7ZbdjS', true),('2', 'user', '{bcrypt}$2y$10$NkcV4yvFbQ89UcXJY8atle.SWYmYwz6y2bZlyUq4IV/uaQY7ZbdjS', true);

INSERT INTO `role` (id, name) VALUES (1,'ADMIN'), (2,'USER');

-- INSERT INTO `user_role` (user_id, role_id) VALUES (1,1), (1,2), (2,2);

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('2', '2');

INSERT INTO `item` (id, created_date, name_item) VALUES (1,'2020-03-04 11:32:54.164361', 'Beras'), (2,'2020-03-04 11:32:54.208308','Kopi Hitam'), (3,'2020-03-04 11:32:54.226486','Mie Instan'), (4,'2020-03-04 11:32:54.243718','Mie Goreng'),  (5,'2020-03-04 11:32:54.258374','Minyak Goreng');

INSERT INTO `unit` (`id`, `created_date`, `modified_date`, `description`, `name_unit`) VALUES (1,'2020-03-04 11:32:54.278230',NULL,'Kilogram','Kg'),(2,'2020-03-04 11:32:54.290585',NULL,'Gram','g'),(3,'2020-03-04 11:32:54.304601',NULL,'Liter','l'),(4,'2020-03-04 11:32:54.319158',NULL,'Pack','Pack');

INSERT INTO `stock` (id, created_date, quantity, item_id,unit_id) VALUES  (1,'2020-03-04 11:32:54.329849',2,1,1), (2,'2020-03-04 11:32:54.416795',500,2,2), (3,'2020-03-04 11:32:54.454436',40,3,4),(4,'2020-03-04 11:32:54.476831',40,4,4), (5,'2020-03-04 11:32:54.507603',5,5,3);

INSERT INTO `transaction` (`id`, `created_date`, `modified_date`, `amount`, `description`, `type_transaction`) VALUES (1,'2020-04-19 20:33:01.693913',NULL,50000,'Buy Mie Goreng 1 Box','PURCHASING'),(2,'2020-04-19 20:34:02.036538',NULL,45000,'Buy Kopi Hitam 3 Pack','PURCHASING'),(3,'2020-04-19 20:34:25.452673',NULL,50000,'Sell Kopi Hitam 3 Pack','SELLING'),(4,'2020-04-19 20:35:11.561111',NULL,150000,'Sell Beras 50Kg','SELLING');
















