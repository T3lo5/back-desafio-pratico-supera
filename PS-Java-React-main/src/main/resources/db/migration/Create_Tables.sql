CREATE TABLE conta (
                       id_conta INT AUTO_INCREMENT PRIMARY KEY,
                       nome_responsavel VARCHAR(50) NOT NULL
);

CREATE TABLE transferencia (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               dataTransferencia DATETIME NOT NULL,
                               valor DECIMAL(10, 2) NOT NULL,
                               tipo VARCHAR(50) NOT NULL,
                               nomeOperadorTransacao VARCHAR(100) NOT NULL,
                               contaId INT NOT NULL,
                               FOREIGN KEY (contaId) REFERENCES conta(id)
);
