INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);

INSERT INTO user (idUser, activated, password, userName)
VALUES (1, 1,'password','admin1');

INSERT INTO user (idUser, activated, password, userName)
VALUES (2, 1,'password','admin2');


INSERT INTO role (idRole, roleName, userId)
VALUES (1,'ROLE_ADMIN_CAT', 1);

INSERT INTO role (idRole, roleName, userId)
VALUES (2, 'ROLE_ADMIN_PROD', 1);

INSERT INTO role (idRole, roleName, userId)
VALUES (3, 'ROLE_ADMIN_PROD', 2);