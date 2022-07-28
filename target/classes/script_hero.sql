drop table if exists heroes;

create table heroes(
    id BIGSERIAL primary key not null,
    race VARCHAR(50) not null,
    name VARCHAR(50) not null,
    clas VARCHAR(50) not null,
    level double precision,
    attack int,
    experience double precision,
    defense int,
    hit_points int,
    weapon VARCHAR(50),
    armor VARCHAR(50),
    helm VARCHAR(50)
);

