CREATE DATABASE thepetz CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS empresa
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_criacao timestamp default current_timestamp
);

CREATE TABLE IF NOT EXISTS pessoa
(
    id              bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cpf_cnpj        varchar(255),
    data_criacao    timestamp default current_timestamp,
    data_nascimento timestamp,
    nome            varchar(255),
    rg_ie           varchar(255),
    id_empresa      bigint,
    FOREIGN KEY (id_empresa) REFERENCES empresa (id)
);

CREATE TABLE IF NOT EXISTS cliente
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_criacao timestamp default current_timestamp,
    id_pessoa    bigint,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa (id)
);

CREATE TABLE IF NOT EXISTS especie
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_criacao timestamp default current_timestamp,
    nome         varchar(255),
    id_empresa   bigint not null,
    FOREIGN KEY (id_empresa) REFERENCES empresa (id)
);

CREATE TABLE IF NOT EXISTS raca
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_criacao timestamp default current_timestamp,
    nome         varchar(255),
    id_especie   bigint,
    FOREIGN KEY (id_especie) REFERENCES especie (id)
);

CREATE TABLE IF NOT EXISTS tipo_contato
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_criacao timestamp default current_timestamp,
    nome         varchar(255)
);

CREATE TABLE IF NOT EXISTS contato
(
    id              bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    observacao      varchar(255),
    valor           varchar(255),
    id_tipo_contato bigint,
    FOREIGN KEY (id_tipo_contato) REFERENCES tipo_contato (id)
);

CREATE TABLE IF NOT EXISTS pelagem
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome         varchar(255),
    id_empresa   bigint not null,
    data_criacao timestamp default current_timestamp,
    FOREIGN KEY (id_empresa) REFERENCES empresa (id)
);

CREATE TABLE IF NOT EXISTS animal
(
    id              bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_nascimento timestamp,
    nome            varchar(255),
    sexo            varchar(255),
    id_cliente      bigint not null,
    id_especie      bigint not null,
    id_pelagem      bigint not null,
    id_raca         bigint not null,
    FOREIGN KEY (id_cliente) REFERENCES cliente (id),
    FOREIGN KEY (id_especie) REFERENCES especie (id),
    FOREIGN KEY (id_pelagem) REFERENCES pelagem (id),
    FOREIGN KEY (id_raca) REFERENCES raca (id)
);

CREATE TABLE IF NOT EXISTS estado
(
    id    bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome  varchar(255),
    sigla varchar(255)
);


CREATE TABLE IF NOT EXISTS endereco
(
    id          bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    bairro      varchar(255),
    cep         varchar(255),
    complemento varchar(255),
    logradouro  varchar(255),
    municipio   varchar(255),
    numero      varchar(255),
    id_estado   bigint,
    FOREIGN KEY (id_estado) REFERENCES estado (id)
);


CREATE TABLE IF NOT EXISTS funcionalidade
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_criacao timestamp default current_timestamp,
    nome         varchar(255)
);

CREATE TABLE IF NOT EXISTS menu
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    data_criacao timestamp default current_timestamp,
    nome         varchar(255),
    id_menu_pai  bigint,
    FOREIGN KEY (id_menu_pai) REFERENCES menu (id)
);

CREATE TABLE IF NOT EXISTS perfil
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome         varchar(255),
    data_criacao timestamp default current_timestamp,
    id_empresa   bigint
);

CREATE TABLE IF NOT EXISTS perfil_funcionalidade
(
    id                bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_funcionalidade bigint,
    id_perfil         bigint,
    data_criacao      timestamp default current_timestamp,
    FOREIGN KEY (id_perfil) REFERENCES perfil (id),
    FOREIGN KEY (id_funcionalidade) REFERENCES funcionalidade (id)
);

CREATE TABLE IF NOT EXISTS perfil_usuario
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome         varchar(255),
    descricao    varchar(255),
    data_criacao timestamp default current_timestamp
);


CREATE TABLE IF NOT EXISTS pessoa_contato
(
    id_pessoa  bigint not null,
    id_contato bigint not null,
    PRIMARY KEY (id_pessoa, id_contato),
    FOREIGN KEY (id_pessoa) REFERENCES pessoa (id),
    FOREIGN KEY (id_contato) REFERENCES contato (id)
);

CREATE TABLE IF NOT EXISTS pessoa_endereco
(
    id_pessoa   bigint not null,
    id_endereco bigint not null,
    PRIMARY KEY (id_pessoa, id_endereco),
    FOREIGN KEY (id_pessoa) REFERENCES pessoa (id),
    FOREIGN KEY (id_endereco) REFERENCES endereco (id)
);

CREATE TABLE IF NOT EXISTS grupo_produto
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome         varchar(255),
    status       boolean,
    id_empresa   bigint not null,
    id_grupo_pai bigint,
    FOREIGN KEY (id_empresa) REFERENCES empresa (id),
    FOREIGN KEY (id_grupo_pai) REFERENCES grupo_produto (id)
);

CREATE TABLE IF NOT EXISTS marca
(
    id           bigint       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome         varchar(255) not null,
    id_empresa   bigint       not null,
    data_criacao timestamp default current_timestamp,
    FOREIGN KEY (id_empresa) REFERENCES empresa (id)
);

CREATE TABLE IF NOT EXISTS produto
(
    id               bigint       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    gtin             bigint,
    nome             varchar(255) not null,
    status           boolean      not null,
    tipo_produto     integer      not null,
    unidade_venda    varchar(255),
    valor_custo      decimal(19, 2),
    valor_venda      decimal(19, 2),
    id_empresa       bigint       not null,
    id_grupo_produto bigint,
    id_marca         bigint,
    quantidade_minima decimal(19, 2),
    quantidade_maxima decimal(19, 2),
    controla_estoque  boolean      not null,
    FOREIGN KEY (id_empresa) REFERENCES empresa (id),
    FOREIGN KEY (id_grupo_produto) REFERENCES grupo_produto (id),
    FOREIGN KEY (id_marca) REFERENCES marca (id)
);

CREATE TABLE IF NOT EXISTS produto_estoque
(
    id              bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_produto       bigint,
    estoque_atual   decimal(19,2),
    data_criacao timestamp default current_timestamp,
    FOREIGN KEY (id_produto) REFERENCES produto (id)
);

CREATE TABLE IF NOT EXISTS usuario
(
    id           bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email        varchar(255) UNIQUE,
    password     varchar(255),
    id_pessoa    bigint,
    data_criacao timestamp default current_timestamp,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa (id)
);

CREATE TABLE IF NOT EXISTS usuario_perfil
(
    id_usuario bigint not null,
    id_perfil  bigint not null,
    FOREIGN KEY (id_usuario) REFERENCES usuario (id),
    FOREIGN KEY (id_perfil) REFERENCES perfil (id)
);


-- inserts básicos
INSERT INTO EMPRESA(id) VALUES (1);
INSERT INTO PESSOA(id, id_empresa, nome, data_nascimento, cpf_cnpj, rg_ie) VALUES (1, 1, 'Pessoa 1', '1995-02-07', '09804970980', '3721235');
INSERT INTO USUARIO(id_pessoa, email, password) VALUES(1, 'enail@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq'); -- senha 123456
INSERT INTO PERFIL_USUARIO(id, nome) VALUES(1, 'ROLE_ADMIN');
INSERT INTO ESTADO (id, nome, sigla) VALUES (1, 'Paraiba', 'PB');

