# --- First database schema


# --- !Ups


create table USER_ACCESS (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id)
  );

create sequence USER_ACCESS_seq start with 1000;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists USER_ACCESS;


SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists USER_ACCESS_seq;

