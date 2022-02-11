drop table if exists `user2` cascade;
create table `user2`
(
    id integer auto_increment,
    first_name varchar (255),
    last_name varchar (255),
    user_name varchar (255) not null,
    number_properties bigint,
    net_worth bigint,
    primary key (id)
);