drop table tbl_user if exists;
drop table tbl_user_friends if exists;
drop table tbl_user_subscription if exists;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table tbl_user (
    id bigint auto_increment  not null,
    email varchar(255),
    created_on timestamp,
    updated_on timestamp,
    primary key (id)
    );
create table tbl_user_friends (
       user_id bigint not null,
        friend_id bigint not null,
        primary key (user_id, friend_id)
    );
create table tbl_user_subscription (
    id bigint auto_increment not null,
    status varchar(255),
    subscribed_to bigint,
    user_id bigint,
    created_on timestamp,
    updated_on timestamp,
    primary key (id)
);
alter table tbl_user_friends 
       add constraint FKglvxtgyfa7nnd7hbn0wug2w5r 
       foreign key (friend_id) 
       references tbl_user;

alter table tbl_user_friends 
       add constraint FKv2yssm7077rxsg11io7myjj5 
       foreign key (user_id) 
       references tbl_user;

alter table tbl_user_subscription 
       add constraint FKl0yjq8rax96a5sm3hd8so8xat 
       foreign key (subscribed_to) 
       references tbl_user;

alter table tbl_user_subscription 
       add constraint FK4rvixs1fm01ismos6biqi9kot 
       foreign key (user_id) 
       references tbl_user;