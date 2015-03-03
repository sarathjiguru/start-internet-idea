# --- First database schema


# --- !Ups


create table user_access (
  id    varchar(255) not null,
  device_model  varchar(255),
  constraint pk_ua PRIMARY KEY (id)
  );

create table google_id (
  id    varchar(255) not null,
  registration_id   varchar(255),
  constraint pk_gi PRIMARY KEY (id)
  );



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists user_access;


SET REFERENTIAL_INTEGRITY TRUE;

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists google_id;


SET REFERENTIAL_INTEGRITY TRUE;


