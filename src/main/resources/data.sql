INSERT INTO EMPRESA(id) VALUES (1);
INSERT INTO EMPRESA(id) VALUES (2);

INSERT INTO PESSOA(id, id_empresa, nome, data_nascimento, cpf_cnpj, rg_ie) VALUES (1, 1, 'Jonas', '1995-02-07', '09804970980', '3721235');
INSERT INTO PESSOA(id, id_empresa, nome, data_nascimento, cpf_cnpj, rg_ie) VALUES (2, 1, 'Marciele',  '1993-08-03', '09104970980', '3798735');

INSERT INTO USUARIO(id_pessoa, email, password) VALUES(1, 'jonas@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO PERFIL_USUARIO(id, nome) VALUES(1, 'ROLE_ADMIN');
INSERT INTO USUARIO_PERFIL(id_usuario, id_perfil) VALUES (1, 1);

INSERT INTO ESPECIE (id, id_empresa, nome) VALUES (1, 1, 'Espécie 1');
INSERT INTO RACA (id, id_especie, nome) VALUES (1, 1, 'Raça 1');
INSERT INTO PELAGEM (id, id_empresa, nome) VALUES (1, 1, 'Pelagem 1');


INSERT INTO ANIMAL (id, id_pessoa, nome, sexo, data_nascimento, id_especie, id_pelagem, id_raca) VALUES (1, 2, 'Animal 1', 'M', '2020-02-18', 1, 1, 1);

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

INSERT INTO TIPO_CONTATO (id, nome) VALUES (1, 'Celular');
INSERT INTO ESTADO (id, nome, sigla) VALUES (1, 'Paraiba', 'PB');
INSERT INTO CLIENTE (id, id_pessoa) VALUES (1, 2);
INSERT INTO ENDERECO (id, logradouro, numero, cep, complemento, bairro, municipio, id_estado) VALUES (1, 'Rua teste', '1', '58301000', 'sem complemento', 'bairro', 'municipio', 1);
INSERT INTO CONTATO (id, valor, id_tipo_contato, observacao) VALUES (1, '83988888888', 1, 'Observação');

INSERT INTO PESSOA_CONTATO (id_pessoa, id_contato) VALUES (2, 1);
INSERT INTO PESSOA_ENDERECO (id_pessoa, id_endereco) VALUES (2, 1);

