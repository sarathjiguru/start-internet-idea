# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table KunderaExamples@cassandra_pu.users (
  user_id                   varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  city                      varchar(255),
  constraint pk_users primary key (user_id))
;

create sequence KunderaExamples@cassandra_pu.users_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists KunderaExamples@cassandra_pu.users;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists KunderaExamples@cassandra_pu.users_seq;

