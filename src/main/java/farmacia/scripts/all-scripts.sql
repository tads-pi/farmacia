DROP SCHEMA IF EXISTS db_farmacia;
CREATE DATABASE IF NOT EXISTS db_farmacia;

USE db_farmacia;

DROP TABLE IF EXISTS db_farmacia.tb_cliente;

CREATE TABLE IF NOT EXISTS db_farmacia.tb_cliente(
    id_cliente INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    --
    nome VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    endereco VARCHAR(45) NOT NULL,
    numero_de_telefone VARCHAR(45) NOT NULL,
    genero VARCHAR(5) NOT NULL,
    estado_civil VARCHAR(45) NOT NULL,
    data_de_nascimento DATE NOT NULL,
    --
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS db_farmacia.tb_funcionario(
    id_funcionario INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    --
    nome VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    cargo VARCHAR(45) NOT NULL,
    --
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

DROP TABLE IF EXISTS db_farmacia.tb_produto;

CREATE TABLE IF NOT EXISTS db_farmacia.tb_produto(
    id_produto INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    --
    nome VARCHAR(45) NOT NULL,
    valor_unitario DECIMAL(10, 2) NOT NULL,
    tipo_de_produto VARCHAR(25) NOT NULL,
    --
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

DROP TABLE IF EXISTS db_farmacia.tb_inventario;

CREATE TABLE IF NOT EXISTS db_farmacia.tb_inventario(
    id_inventario INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    --
    id_produto INT NOT NULL,
    quantidade DECIMAL(10, 2) NOT NULL,
    --
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

DROP TABLE IF EXISTS db_farmacia.tb_venda;

CREATE TABLE IF NOT EXISTS db_farmacia.tb_venda(
    id_venda INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    --
    id_cliente INT NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    --
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

DROP TABLE IF EXISTS db_farmacia.tb_item_venda;

CREATE TABLE IF NOT EXISTS db_farmacia.tb_item_venda(
    id_item_venda INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    --
    id_produto INT NOT NULL,
    id_venda INT NOT NULL,
    quantidade DECIMAL(10, 2) NOT NULL,
    valor_unitario DECIMAL(10, 2) NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL,
    --
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO
    tb_cliente (
        nome,
        email,
        cpf,
        endereco,
        numero_de_telefone,
        genero,
        estado_civil,
        data_de_nascimento
    )
VALUES
    (
        "Teste Teste",
        "email@example.com",
        "012.345.678-90",
        "Rua Tal Tal Tal, Nº 50",
        "(11)91234-5678",
        "-",
        "Solteiro (a)",
        CURRENT_TIMESTAMP
    );

INSERT INTO
    tb_cliente (
        nome,
        email,
        cpf,
        endereco,
        numero_de_telefone,
        genero,
        estado_civil,
        data_de_nascimento
    )
VALUES
    (
        "Neymar Jr.",
        "email@example.com",
        "000.000.000-00",
        "Rua Fulano De Tal, Nº 150",
        "(11)90000-0000",
        "M",
        "Solteiro (a)",
        "02/05/1992"
    );

INSERT INTO
    tb_cliente (
        nome,
        email,
        cpf,
        endereco,
        numero_de_telefone,
        genero,
        estado_civil,
        data_de_nascimento
    )
VALUES
    (
        "Faustão",
        "emaildofaustao@gmail.com",
        "111.111.111-11",
        "Rua Do Faustão, Nº 1",
        "(11)91234-5678",
        "M",
        "Casado (a)",
        "05/02/1950"
    );

INSERT INTO
    tb_funcionario (
        nome,
        email,
        cpf,
        cargo
    )
VALUES
    (
        "Kaua Calixto",
        "emaildocalixto@gmail.com",
        "0123.0123.0123-01",
        "Vendedor(a)"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Ozempic 1mg Novo Nordisk 3ml de Solução Injetável + 1 Sistema para Aplicação 1mg + 4 Agulhas",
        1043.89,
        "mg,ml"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Forxiga 10mg 30 Comprimidos Revestidos",
        154.99,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Glifage XR 500mg Merck S/A 30 comprimidos",
        8.07,
        "mg"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Orlistate 120mg Genérico 60 Cápsulas",
        85.29,
        "mg,Cápsulas"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Omeprazol 20mg Genérico Cimed 56 Cápsulas",
        6.99,
        "mg,Cápsulas"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Tadalafila 5mg Genérico EMS 30 Comprimidos Revestidos",
        14.19,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Xigduo XR 5mg + 1000mg Astrazeneca 60 Comprimidos",
        172.24,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Xigduo XR 10mg + 1000mg Astrazeneca 30 Comprimidos",
        173.29,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Fluconazol 150mg Genérico Cimed 2 Comprimidos",
        6.72,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Qlaira Bayer 28 Comprimidos",
        52.89,
        "Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Losartana 50mg Genérico Neo Química 30 Comprimidos Revestidos",
        7.29,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Neosoro Adulto Solução Nasal Neo Química 30ml",
        5.45,
        "ml"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Azitromicina Di-Hidratada 500mg Genérico EMS 5 Comprimidos",
        14.45,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Rosuvastatina Cálcica 20mg Genérico Althaia 30 Comprimidos",
        33.69,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Rosuvastatina Cálcica 10mg Genérico Althaia 30 Comprimidos",
        27.51,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Fumarato De Quetiapina 25mg Medley 30 Comprimidos",
        22.69,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Ozempic 0,25mg + 0,5mg Novo Nordisk Caixa com 1 Sistema de Aplicação 1,5ml + 6 Agulhas",
        820.59,
        "mg,ml"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Desvenlafaxina 100mg Genérico Eurofarma 30 Comprimidos Revestidos",
        43.79,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Budesonida 32mcg Genérico Ems 120 Doses Spray Nasal",
        13.39,
        "g"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Succinato de Metoprolol 50mg Genérico Neo Química 30 Comprimidos Revestidos",
        14.79,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Sinvastatina 20mg Genérico Cimed 30 Comprimidos",
        8.39,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Aciclovir 200mg Genérico Cimed 30 Comprimidos",
        32.66,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Dexilant 60mg Takeda 60 Cápsulas",
        169.28,
        "mg,Cápsulas"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Maleato de Dexclorfeniramina + Betametasona Xarope Genérico Prati 120ml",
        11.19,
        "ml"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Drospirenona + Etinilestradiol 3/ 0,03mg Genérico Germed 21 Comprimidos Revestidos",
        14.39,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Pregabalina 75mg Genérico Medley 30 Cápsulas",
        33.85,
        "mg,Cápsulas"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Solução Injetável Saxenda 6mg/ml Nordisk 3 Canetas Descartáveis",
        700.99,
        "mg,ml"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Solução Injetável Trulicity 1,5mg/ 0,5ml Eli Lilly 2 Canetas Descartáveis",
        288.09,
        "mg,ml"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Besilato de Anlodipino 5mg Genérico Cimed 30 Comprimidos",
        4.99,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Jardiance 25mg Boehringer 30 Comprimidos Revestidos",
        238.19,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Prednisona 20mg Genérico Neo Química 10 comprimidos",
        13.06,
        "mg"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Sildenafila 50mg Genérico Neo Química 4 Comprimidos Revestidos",
        11.99,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Daflon 1000mg Servier 30 comprimidos revestidos",
        121.99,
        "mg"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Isotretinoina 20mg Nova Química 30 Comprimidos",
        59.99,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    ("Xarelto 20mg 28 comprimidos", 267.89, "mg");

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Venvanse 50mg Shire 28 Cápsulas",
        449.89,
        "mg,Cápsulas"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Domperidona 10mg Genérico 60 Comprimidos",
        13.16,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Dramin B6 50mg/10mg Hypera 30 Comprimidos",
        19.99,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    ("Avamys Spray Nasal GSK 120 Doses", 68.29, "g");

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Deposteron Injetável Germed 3 X 2ml",
        182.19,
        "ml"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Espironolactona 25mg Genérico Eurofarma 30 Comprimidos",
        12.07,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Cloridrato Venlafaxina 75mg Medley 30 Comprimidos",
        43.89,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Scalid 100mg União Química 12 Comprimidos",
        6.29,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    ("Koide-D Xarope Eurofarma 120ml", 39.00, "ml");

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Aradois 50mg Biolab 30 Comprimidos",
        10.35,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Aspirina Prevent 100mg Bayer 30 Comprimidos",
        18.49,
        "mg,Comprimidos"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    (
        "Pantoprazol Genérico 40mg 28 comprimidos",
        22.19,
        "mg"
    );

INSERT INTO
    tb_produto(nome, valor_unitario, tipo_de_produto)
VALUES
    ("Evra 3 adesivos", 92.09, "g");

    INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (1, 61);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (2, 97);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (3, 16);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (4, 79);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (5, 60);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (6, 41);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (7, 94);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (8, 14);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (9, 34);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (10, 4);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (11, 0);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (12, 85);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (13, 33);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (14, 48);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (15, 78);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (16, 12);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (17, 79);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (18, 91);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (19, 36);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (20, 59);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (21, 25);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (22, 11);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (23, 74);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (24, 31);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (25, 25);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (26, 82);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (27, 44);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (28, 72);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (29, 68);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (30, 9);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (31, 83);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (32, 95);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (33, 84);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (34, 62);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (35, 36);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (36, 77);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (37, 72);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (38, 75);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (39, 70);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (40, 81);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (41, 98);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (42, 49);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (43, 10);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (44, 44);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (45, 18);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (46, 18);

INSERT INTO
    tb_inventario(id_produto, quantidade)
VALUES
    (47, 32);

    INSERT INTO `db_farmacia`.`tb_venda` (`id_venda`,`id_cliente`,`total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (1,1,1147.66,'2022-11-19 22:44:38','2022-11-19 22:44:38',1);
INSERT INTO `db_farmacia`.`tb_venda` (`id_venda`,`id_cliente`,`total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (2,2,279.16,'2022-11-19 22:45:47','2022-11-19 22:45:47',1);
INSERT INTO `db_farmacia`.`tb_venda` (`id_venda`,`id_cliente`,`total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (3,2,2537.66,'2022-11-20 00:58:02','2022-11-20 00:58:02',1);
INSERT INTO `db_farmacia`.`tb_venda` (`id_venda`,`id_cliente`,`total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (4,1,1509.00,'2022-11-20 01:09:03','2022-11-20 01:09:03',1);
INSERT INTO `db_farmacia`.`tb_venda` (`id_venda`,`id_cliente`,`total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (5,3,1368.63,'2022-11-20 01:18:48','2022-11-20 01:18:48',1);
INSERT INTO `db_farmacia`.`tb_venda` (`id_venda`,`id_cliente`,`total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (6,1,463.71,'2022-11-20 01:24:20','2022-11-20 01:24:20',1);

INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (3  ,   6   ,   1   ,2.00,241.49,482.98,'2022-11-19 22:44:38','2022-11-19 22:44:38',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (4  ,   14  ,   1   ,3.00,55.95,167.85,'2022-11-19 22:44:38','2022-11-19 22:44:38',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (5  ,   20  ,   1   ,2.00,13.99,27.98,'2022-11-19 22:44:38','2022-11-19 22:44:38',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (6  ,   26  ,   1   ,1.00,47.87,47.87,'2022-11-19 22:44:38','2022-11-19 22:44:38',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (7  ,   33  ,   1   ,1.00,157.99,157.99,'2022-11-19 22:44:38','2022-11-19 22:44:38',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (8  ,   46  ,   1   ,1.00,262.99,262.99,'2022-11-19 22:44:38','2022-11-19 22:44:38',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (9  ,   3   ,   2   ,2.00,34.99,69.98,'2022-11-19 22:45:47','2022-11-19 22:45:47',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (10 ,   7   ,   2   ,1.00,59.90,59.90,'2022-11-19 22:45:47','2022-11-19 22:45:47',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (11 ,   13  ,   2   ,1.00,58.50,58.50,'2022-11-19 22:45:47','2022-11-19 22:45:47',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (12 ,   31  ,   2   ,1.00,79.99,79.99,'2022-11-19 22:45:47','2022-11-19 22:45:47',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (13 ,   47  ,   2   ,1.00,10.79,10.79,'2022-11-19 22:45:47','2022-11-19 22:45:47',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (14 ,   46  ,   3   ,1.00,262.99,262.99,'2022-11-20 00:58:03','2022-11-20 00:58:03',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (15 ,   32  ,   3   ,3.00,118.69,356.07,'2022-11-20 00:58:03','2022-11-20 00:58:03',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (16 ,   36  ,   3   ,3.00,6.99,20.97,'2022-11-20 00:58:03','2022-11-20 00:58:03',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (17 ,   15  ,   3   ,3.00,89.89,269.67,'2022-11-20 00:58:03','2022-11-20 00:58:03',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (18 ,   4   ,   3   ,3.00,106.90,320.70,'2022-11-20 00:58:03','2022-11-20 00:58:03',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (19 ,   1   ,   3   ,3.00,150.90,452.70,'2022-11-20 00:58:03','2022-11-20 00:58:03',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (20 ,   2   ,   3   ,3.00,36.99,110.97,'2022-11-20 00:58:03','2022-11-20 00:58:03',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (21 ,   8   ,   3   ,2.00,16.39,32.78,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (22 ,   18  ,   3   ,2.00,161.90,323.80,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (23 ,   24  ,   3   ,1.00,59.79,59.79,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (24 ,   28  ,   3   ,1.00,7.69,7.69,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (25 ,   32  ,   3   ,1.00,118.69,118.69,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (26 ,   36  ,   3   ,1.00,6.99,6.99,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (27 ,   40  ,   3   ,1.00,18.90,18.90,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (28 ,   43  ,   3   ,1.00,113.90,113.90,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (29 ,   45  ,   3   ,1.00,17.89,17.89,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (30 ,   47  ,   3   ,1.00,10.79,10.79,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (31 ,   47  ,   3   ,3.00,10.79,32.37,'2022-11-20 00:58:04','2022-11-20 00:58:04',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (32 ,   1   ,   4   ,10.00,150.90,1509.00,'2022-11-20 01:09:03','2022-11-20 01:09:03',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (33 ,   2   ,   5   ,37.00,36.99,1368.63,'2022-11-20 01:18:48','2022-11-20 01:18:48',1);
INSERT INTO `db_farmacia`.`tb_item_venda` (`id_item_venda`,`id_produto`,`id_venda`,`quantidade`,`valor_unitario`,`valor_total`,`criado_em`,`atualizado_em`,`ativo`) VALUES (34 ,   48  ,   6   ,29.00,9.99,463.71,'2022-11-20 01:24:20','2022-11-20 01:24:20',1);