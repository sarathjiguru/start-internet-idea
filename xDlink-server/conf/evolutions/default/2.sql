# --- Sample dataset

# --- !Ups

insert into user_access (id,device_model,registration_id) values (1,'xdapp.test.first.insert', "<not a real registration id>");


# --- !Downs

delete from user_access;