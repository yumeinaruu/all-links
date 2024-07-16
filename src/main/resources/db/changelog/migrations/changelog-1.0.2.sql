--liquibase formatted sql

--changeset yumeinaruu:2
--comment table links created
create table links
(
    id      bigserial not null
        constraint links_pk
            primary key,
    service varchar   not null,
    link    varchar   not null,
    user_id integer
        constraint links_users_id_fk
            references users
            on update cascade on delete cascade
);