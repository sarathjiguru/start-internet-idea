# --- First database schema


# --- !Ups


create table user_access (
  id    varchar(255) not null,
  device_model  varchar(255),
  registration_id   TEXT,
  constraint pk_ua PRIMARY KEY (id)
  );



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists user_access;


SET REFERENTIAL_INTEGRITY TRUE;



