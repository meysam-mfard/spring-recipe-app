CREATE DATABASE recipe_app_dev;
CREATE DATABASE recipe_app_prod;

#Create database service accounts
CREATE USER 'recipe_app_dev_user'@'localhost' IDENTIFIED BY 'pass';
CREATE USER 'recipe_app_prod_user'@'localhost' IDENTIFIED BY 'pass';
CREATE USER 'recipe_app_dev_user'@'%' IDENTIFIED BY 'pass';
CREATE USER 'recipe_app_prod_user'@'%' IDENTIFIED BY 'pass';

#Database grants
GRANT SELECT ON recipe_app_dev.* to 'recipe_app_dev_user'@'localhost';
GRANT INSERT ON recipe_app_dev.* to 'recipe_app_dev_user'@'localhost';
GRANT DELETE ON recipe_app_dev.* to 'recipe_app_dev_user'@'localhost';
GRANT UPDATE ON recipe_app_dev.* to 'recipe_app_dev_user'@'localhost';
GRANT SELECT ON recipe_app_prod.* to 'recipe_app_prod_user'@'localhost';
GRANT INSERT ON recipe_app_prod.* to 'recipe_app_prod_user'@'localhost';
GRANT DELETE ON recipe_app_prod.* to 'recipe_app_prod_user'@'localhost';
GRANT UPDATE ON recipe_app_prod.* to 'recipe_app_prod_user'@'localhost';
GRANT SELECT ON recipe_app_dev.* to 'recipe_app_dev_user'@'%';
GRANT INSERT ON recipe_app_dev.* to 'recipe_app_dev_user'@'%';
GRANT DELETE ON recipe_app_dev.* to 'recipe_app_dev_user'@'%';
GRANT UPDATE ON recipe_app_dev.* to 'recipe_app_dev_user'@'%';
GRANT SELECT ON recipe_app_prod.* to 'recipe_app_prod_user'@'%';
GRANT INSERT ON recipe_app_prod.* to 'recipe_app_prod_user'@'%';
GRANT DELETE ON recipe_app_prod.* to 'recipe_app_prod_user'@'%';
GRANT UPDATE ON recipe_app_prod.* to 'recipe_app_prod_user'@'%';