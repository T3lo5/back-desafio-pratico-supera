CREATE TABLE conta
(
    id_conta INT AUTO_INCREMENT PRIMARY KEY,
    nome_responsavel VARCHAR(50) NOT NULL
);

CREATE TABLE transferencia
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_transferencia DATETIME NOT NULL,
    valor DECIMAL(20,2) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    nome_operador_transacao VARCHAR(50),
    conta_id INT NOT NULL,
    CONSTRAINT FK_CONTA
        FOREIGN KEY (conta_id)
            REFERENCES conta(id_conta)
);

INSERT INTO conta (nome_responsavel) VALUES ('Fulano');
INSERT INTO conta (nome_responsavel) VALUES ('Sicrano');

INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2019-01-01 12:00:00', 30895.46, 'DEPOSITO', NULL, 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2019-02-03 09:53:27', 12.24, 'DEPOSITO', NULL, 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2019-05-04 08:12:45', -500.50, 'SAQUE', NULL, 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2019-08-07 08:12:45', -530.50, 'SAQUE', NULL, 2);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2020-06-08 10:15:01', 3241.23, 'TRANSFERENCIA', 'Beltrano', 1);
INSERT INTO transferencia (data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES ('2021-04-01 12:12:04', 25173.09, 'TRANSFERENCIA', 'Ronnyscley', 2);
