insert into product(name, description) values('Dell', 'Dell Laptop');
insert into product(name, description) values('HP', 'HP Laptop');
insert into product(name, description) values('iPad', 'iPad Pro');
insert into product(name, description) values('iPhone', 'iPhone 11');
insert into product(name, description) values('Spider Man', 'Spider Man Toy');
insert into product(name, description) values('Space Puzzle', '1000 Pieces puzzle');

insert into cart(id)  values(1);
insert into cart(id)  values(2);
insert into cart(id)  values(3);
insert into cart(id)  values(4);
insert into cart(id)  values(5);


insert into user(id, name, cart_id) values(1, 'John', 1);
insert into user(id, name, cart_id) values(2, 'Dan', 2);
insert into user(id, name, cart_id) values(3, 'Diana', 3);
insert into user(id, name, cart_id) values(4, 'Kate', 4);
insert into user(id, name, cart_id) values(5, 'James', 5);


insert into item(product_id, quantity, cart_id) values(1, 1, 1);
insert into item(product_id, quantity, cart_id) values(2, 2, 1);

insert into item(product_id, quantity, cart_id) values(3, 1, 2);
insert into item(product_id, quantity, cart_id) values(4, 2, 2);

insert into item(product_id, quantity, cart_id) values(5, 1, 3);
insert into item(product_id, quantity, cart_id) values(6, 2, 3);