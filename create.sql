create table bill (total_amount float(53), id bigint not null auto_increment, id_user bigint, description varchar(255), primary key (id)) engine=InnoDB;
create table user (age integer, id bigint not null auto_increment, email varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
alter table bill add constraint FK6qvanc7ss938l25j6i4ekqfit foreign key (id_user) references user (id);
