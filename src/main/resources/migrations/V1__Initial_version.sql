drop table if exists test cascade;
create table test
(
    id       bigint not null,
    strField varchar(255),
    intField integer,
    primary key (id)
);
