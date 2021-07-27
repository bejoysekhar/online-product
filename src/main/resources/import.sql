insert into product(name, description) values('Product 1', 'Product 1 description');
insert into product(name, description) values('Product 2', 'Product 2 description');
insert into product(name, description) values('Product 3', 'Product 3 description');
insert into product(name, description) values('Product 4', 'Product 4 description');
insert into product(name, description) values('Product 5', 'Product 5 description');
insert into product(name, description) values('Product 6', 'Product 6 description');

insert into cart(id)  values(1);
insert into cart(id)  values(2);
insert into cart(id)  values(3);


insert into user(name, cart_id) values('Name1', 1);
insert into user(name, cart_id) values('Name2', 2);
insert into user(name, cart_id) values('Name3', 3);
insert into user(name) values('Name4');
insert into user(name) values('Name5');


insert into item(product_id, quantity, cart_id) values(1, 1, 1);
insert into item(product_id, quantity, cart_id) values(2, 2, 1);

insert into item(product_id, quantity, cart_id) values(3, 1, 2);
insert into item(product_id, quantity, cart_id) values(4, 2, 2);

insert into item(product_id, quantity, cart_id) values(5, 1, 3);
insert into item(product_id, quantity, cart_id) values(6, 2, 3);