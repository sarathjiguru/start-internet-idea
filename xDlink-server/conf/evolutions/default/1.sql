# --- First database schema


# --- !Ups


create table USER_ACCESS (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_ua PRIMARY KEY (id)
  );



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists USER_ACCESS;


SET REFERENTIAL_INTEGRITY TRUE;



