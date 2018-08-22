select * from acoes;

insert into acoes (codigo, id_comprador, iniciar, nome, valor, preco_compra, preco_venda) values ('1', null, false, 'PETROBRAS', 18.48, 18.48, 18.56);
insert into acoes (codigo, id_comprador, iniciar, nome, valor, preco_compra, preco_venda) values ('2', null, false, 'VALE EM', 45.67, 45.67, 46.66);
insert into acoes (codigo, id_comprador, iniciar, nome, valor, preco_compra, preco_venda) values ('3', null, false, 'ITAU UNICLASS', 79.39, 79.39, 80.98);
insert into acoes (codigo, id_comprador, iniciar, nome, valor, preco_compra, preco_venda) values ('4', null, false, 'FORD MOTORS', 49.16, 49.16, 51.13);
insert into acoes (codigo, id_comprador, iniciar, nome, valor, preco_compra, preco_venda) values ('5', null, false, 'AMBEV S/A ON', 39.12, 39.12, 41.10);
insert into acoes (codigo, id_comprador, iniciar, nome, valor, preco_compra, preco_venda) values ('6', null, false, 'BRADESCO PN', 28.62, 28.62, 29.48);
insert into acoes (codigo, id_comprador, iniciar, nome, valor, preco_compra, preco_venda) values ('7', null, false, 'MAGAZ LUIZA ON', 133.65, 133.65, 139.47); 

Select * from comprador;

insert into comprador (id, acoes, nome, saldo, volume) values ('1', '1', 'Mifael', 100000, 0);
insert into comprador (id, acoes, nome, saldo, volume) values ('2', '2', 'Felipe', 1000000, 0);
insert into comprador (id, acoes, nome, saldo, volume) values ('3', '3', 'Jocélli', 1100000, 0);

update acoes set id_comprador = '1', iniciar = true where codigo = '1';

Select * from log_negociacao;