INSERT INTO EMPRESA(id) VALUES (1);

INSERT INTO PESSOA(id_empresa, nome) VALUES (1, 'Jonas');

INSERT INTO USUARIO(id_pessoa, email, password) VALUES(1, 'jonas@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO PERFIL_USUARIO(id, nome) VALUES(1, 'ROLE_ADMIN');

INSERT INTO MENU (id, nome) VALUES (1, 'Dashboard');
INSERT INTO MENU (id, nome) VALUES (2, 'Caixa');
INSERT INTO MENU (id, nome) VALUES (3, 'Clinica');
INSERT INTO MENU (id, nome) VALUES (4, 'Cadastro');
INSERT INTO MENU (id, id_menu_pai, nome) VALUES (30, 4, 'Espécie');
INSERT INTO MENU (id, id_menu_pai, nome) VALUES (31, 4, 'Raça');


INSERT INTO PERFIL (id, nome, id_empresa) VALUES (1, 'Admin', 1);
INSERT INTO PERFIL (id, nome, id_empresa) VALUES (2, 'Caixa', 1);
INSERT INTO PERFIL (id, nome, id_empresa) VALUES (3, 'Veterinário', 1);

INSERT INTO FUNCIONALIDADE (id, nome) VALUES (1, 'Financeiro');
INSERT INTO FUNCIONALIDADE (id, nome) VALUES (2, 'Abrir Caixa');
INSERT INTO FUNCIONALIDADE (id, nome) VALUES (3, 'Fechar Caixa');
INSERT INTO FUNCIONALIDADE (id, nome) VALUES (4, 'Consultar Animal');

INSERT INTO PERFIL_FUNCIONALIDADE (id, id_perfil, id_funcionalidade) VALUES (1, 1, 1);
INSERT INTO PERFIL_FUNCIONALIDADE (id, id_perfil, id_funcionalidade) VALUES (2, 2, 2);
INSERT INTO PERFIL_FUNCIONALIDADE (id, id_perfil, id_funcionalidade) VALUES (3, 2, 3);
INSERT INTO PERFIL_FUNCIONALIDADE (id, id_perfil, id_funcionalidade) VALUES (4, 3, 4);


INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (1, 1, 'Cão');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (2, 1, 'Gato');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (3, 1, 'Rato');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (4, 1, 'Cão');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (5, 1, 'Gato');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (6, 1, 'Rato');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (7, 1, 'Cão');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (8, 1, 'Gato');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (9, 1, 'Rato');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (10, 1, 'Cão');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (11, 1, 'Gato');
INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (12, 1, 'Rato');