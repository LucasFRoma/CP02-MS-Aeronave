# CP02-MS-Aeronave

📝 Descrição do Projeto
Este projeto constitui a segunda API do Check Point 2, focada no domínio de aeronaves. A API foi expandida para incluir um banco de dados relacional com entidades de 5 atributos cada e pelo menos um campo opcional (nullable), além de documentação estruturada.

🛠️ Tecnologias Utilizadas
Java e Spring Boot.

Spring Data JPA.

MySQL.

Docker.

🚀 Como Rodar a Aplicação
Pré-requisitos
Ter o Docker instalado e em execução.

1. Subir o Banco de Dados com Docker
Utilize o comando Docker abaixo para iniciar o banco de dados MySQL desta aplicação:

Bash

docker run --name mysql-aeronave-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=aeronave_db -p 3307:3306 -d mysql:latest
2. Executar a Aplicação
Certifique-se de alterar as configurações de porta para a porta 8080 no arquivo application.properties e execute o comando abaixo na pasta raiz:

Bash

./mvnw spring-boot:run
📖 Documentação e Endpoints
Swagger/OpenAPI: A documentação completa das rotas está disponível para testes.

URL base: http://localhost:8080/.
