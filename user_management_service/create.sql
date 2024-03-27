create table roles (id serial not null, name varchar(20) check (name in ('DRIVER','RIDER','ADMIN')), primary key (id));
create table user_roles (role_id integer not null, user_id bigint not null, primary key (role_id, user_id));
create table users (id bigserial not null, username varchar(20), email varchar(50), password varchar(120), primary key (id), unique (username), unique (email));
alter table if exists user_roles add constraint FKh8ciramu9cc9q3qcqiv4ue8a6 foreign key (role_id) references roles;
alter table if exists user_roles add constraint FKhfh9dx7w3ubf1co1vdev94g3f foreign key (user_id) references users;
