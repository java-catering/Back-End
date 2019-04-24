create table role (id bigint not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, created TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, email varchar(255) not null, first_name varchar(255) not null, last_name varchar(255) not null, password varchar(255) not null, role_id bigint, primary key (id)) engine=InnoDB;
create table product (id bigint not null auto_increment, description varchar(255), is_available bit not null, title varchar(255) not null, unit_price DECIMAL(8, 2) not null, primary key (id)) engine=InnoDB;
create table purchase (id bigint not null auto_increment, created TIMESTAMP DEFAULT CURRENT_TIMESTAMP, status varchar(255) not null, total double precision not null, user_id bigint, primary key (id)) engine=InnoDB;
create table purchase_product (id bigint not null auto_increment, product_id bigint, purchase_id bigint, primary key (id)) engine=InnoDB;

alter table user add constraint FKn82ha3ccdebhokx3a8fgdqeyy foreign key (role_id) references role (id);
alter table purchase add constraint FK86i0stm7cqsglqptdvjij1k3m foreign key (user_id) references user (id);
alter table purchase_product add constraint FKl1da8u1v57wry7sunkkgmjr8o foreign key (product_id) references product (id);
alter table purchase_product add constraint FK1te3j5efipmc5c19wve8c90qd foreign key (purchase_id) references purchase (id);

