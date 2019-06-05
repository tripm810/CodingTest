CREATE DATABASE test;
CREATE TABLE `user`(
  user_id int(11) NOT NULL AUTO_INCREMENT,
  mobile_number varchar(255) NOT NULL ,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  date_of_birth varchar(255) NOT NULL,
  gender varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  PRIMARY KEY (user_id)
);
