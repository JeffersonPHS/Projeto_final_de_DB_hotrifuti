Projeto Hortifruti - Gestão de Estoque

Este repositório contém uma aplicação Web em Java desenvolvida para a disciplina de Banco de Dados do IFPB. O projeto consiste em um sistema para gerenciamento de um Hortifruti, implementando um CRUD completo integrado a um banco de dados relacional.
🚀 Funcionalidades

    Modelo Físico: Script SQL completo com banco de dados normalizado.

    Operações CRUD: Cadastro, listagem, edição e remoção de [NOME DA ENTIDADE, ex: Produtos].

    Arquitetura DAO: Camada de persistência isolada para comunicação com o banco de dados.

    Interface Web: Telas interativas utilizando Servlets e JSP.

🛠️ Tecnologias Utilizadas

    Linguagem: Java

    Tecnologias Web: Servlets e JSP

    Banco de Dados: PostgreSQL (gerenciado via pgAdmin)

    Servidor: Apache Tomcat

    Ambiente de Desenvolvimento: Linux

📂 Estrutura do Repositório

    /src: Código-fonte Java (Classes de modelo, DAOs e Servlets).

    /webapp: Páginas JSP e arquivos estáticos (CSS/JS).

    /sql: Contém o arquivo script.sql para criação das tabelas.

📊 Banco de Dados

O banco de dados foi projetado seguindo as regras de normalização. O script de criação está localizado em /sql/script.sql.

Exemplo de estrutura da tabela principal:
SQL

CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL
);

🎬 Apresentação e Demonstração

🔧 Como Executar o Projeto

    Clonar o repositório:
    Bash

    git clone https://github.com/seu-usuario/projeto-hortifruti.git

    Configurar o Banco de Dados:

        Abra o pgAdmin.

        Crie um banco de dados chamado hortifruti_db.

        Execute os comandos contidos no arquivo script.sql.

    Configurar a Conexão:

        No arquivo de conexão Java (ex: ConnectionFactory.java), verifique se o usuário e a senha do PostgreSQL estão corretos.

    Rodar no Tomcat:

        Importe o projeto na sua IDE e execute-o em um servidor Apache Tomcat.

        Acesse no navegador: http://localhost:8080/nome-do-projeto
