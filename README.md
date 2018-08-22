# java

Para Instalar deve-se adicionar todos os projetos importando como Existing Maven Projects

Após isso criar no PostgreSQL um DataBase chamado "bolcavalores"

Rodar Acoes, Mercado, Comprador e AutoBooking a primeira vez para criar as tabelas.

Adicionar no Banco (Script SQL) ou via Posmans utilizando o serviço Rest para cadastro (PostMan ou SoapUI)

Sobre as estruturas escolhidas

JPA para persistencia

RestTamplate para fazer as consultas no WebServices

Não utilizei JMS pois como o preço variava de 5 em 5 segundos preferi optar por uma forma sincrona.

Não tive tempo de fazer os tratamentos que entendo serem necessários para tratar comcorrencia e validação de todos os dados.
