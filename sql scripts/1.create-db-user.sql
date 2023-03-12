CREATE USER 'customerdbuser'@'localhost' IDENTIFIED BY 'customerdbuser';
GRANT ALL PRIVILEGES ON * . * TO 'customerdbuser'@'localhost';
ALTER USER 'customerdbuser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'customerdbuser';