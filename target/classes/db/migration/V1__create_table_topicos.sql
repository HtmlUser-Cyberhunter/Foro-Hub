create table topicos(
id bigint not null auto_increment,
titulo varchar(255) not null,
mensaje TEXT NOT NULL not null,
fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP not null,
estatus varchar(50) DEFAULT 'NO RESPONDIDO' not null,
autor varchar(255) not null,
curso varchar(255) not null,

primary key(id)

);