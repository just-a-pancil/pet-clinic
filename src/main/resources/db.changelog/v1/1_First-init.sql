CREATE TABLE `sys`.`users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);


CREATE TABLE `pet-clinic`.`roles` (
  `id` BIGINT(20) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

  ALTER TABLE `pet-clinic`.`roles` 
CHANGE COLUMN `id` `id` BIGINT NOT NULL AUTO_INCREMENT ;


CREATE TABLE `pet-clinic`.`users_roles` (
  `user_id` BIGINT(20) NOT NULL,
  `role_id` BIGINT(20) NOT NULL);

ALTER TABLE `pet-clinic`.`users_roles` 
ADD INDEX `fk_users_idx` (`user_id` ASC) VISIBLE,
ADD INDEX `fk_roles_idx` (`role_id` ASC) VISIBLE;
;
ALTER TABLE `pet-clinic`.`users_roles` 
ADD CONSTRAINT `fk_users`
  FOREIGN KEY (`user_id`)
  REFERENCES `pet-clinic`.`users` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_roles`
  FOREIGN KEY (`role_id`)
  REFERENCES `pet-clinic`.`roles` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

