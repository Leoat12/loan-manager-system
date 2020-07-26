INSERT INTO `client` (`id`,`address`, `balance`, `name`) VALUES 
(1,'Rua Exemplo 1', 2578, 'Isabel Antônia'),
(2,'Rua Exemplo 2', 36480, 'Carlos Alberto'),
(3,'Rua Exemplo 3', 15882, 'Eugênio Gomes'),
(4,'Rua Exemplo 4', 16548, 'Ricardo Ferraz');

INSERT INTO `collector` (`id`,`name`) VALUES 
(1,'Lara Gabriela'),
(2,'Renan Pinheiro'),
(3,'Augusta Macedo'),
(4,'Leonam Prado');

INSERT INTO `loan_contract` (`transaction_id`, `amount_given`, `date_loan_given`, `interest_rate`, `fk_client`, `fk_collector`) VALUES
(1, 1000, '2020-07-25', 8, 3, 2),
(2, 5000, '2020-07-25', 3, 3, 2),
(3, 5500, '2020-07-25', 4, 4, 4);
