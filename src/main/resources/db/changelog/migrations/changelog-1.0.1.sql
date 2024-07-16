--liquibase formatted sql

--changeset yumeinaruu:1
--comment table users created
create table users
(
    id          bigserial                   not null
        constraint users_pk
            primary key,
    username    varchar                     not null,
    description text,
    created     timestamp without time zone not null,
    changed     timestamp without time zone
);
