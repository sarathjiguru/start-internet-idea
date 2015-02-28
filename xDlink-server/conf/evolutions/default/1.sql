# --- First database schema


# --- !Ups


create table user_access (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_ua PRIMARY KEY (id)
  );



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists user_access;


SET REFERENTIAL_INTEGRITY TRUE;



