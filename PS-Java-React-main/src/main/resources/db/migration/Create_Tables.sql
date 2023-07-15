CREATE TABLE conta (
                       id_conta INT AUTO_INCREMENT PRIMARY KEY,
                       nome_responsavel VARCHAR(50) NOT NULL
);

CREATE TABLE transferencia (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               data_transferencia TIMESTAMP NOT NULL,
                               valor DECIMAL(10,2) NOT NULL,
                               tipo VARCHAR(15) NOT NULL,
                               nome_operador_transacao VARCHAR(50),
                               conta_id INT NOT NULL,
                               CONSTRAINT FK_CONTA
                                   FOREIGN KEY (conta_id)
                                       REFERENCES conta(id_conta)
);
