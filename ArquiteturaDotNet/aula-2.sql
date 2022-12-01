
-- Criação do Banco via Docker
--
-- docker run -e ACCEPT_EULA=Y -e MSSQL_SA_PASSWORD=Infnet@123 -e MSSQL_PID=Express -p 1433:1433 --name sqlserver-dev -d mcr.microsoft.com/mssql/server:2017-latest
--
--
-- ========== Acesso ao banco de dados ===================
-- Caso tenha instalado a partir do docker-compose utilize as seguintes credenciais
-- Host: localhost
-- Authentication: SQL Server Authentication 
-- Port: 1433
-- Username: sa
-- Password: Infnet@123
--
--
-- =================== Conectando via sqlcmd ========================
--
-- docker exec -it sqlserver-dev bash -c '/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P "Infnet@123"'
--
--
-- =================== Criando estrutura ============================
--Rode linha por linha, se estiver usando dbeaver selecione o comando e uutilize CTRL + Enter

-- Rode a linha abaixo primeiro
create database ToDoDb;


-- Rode a linha abaixo em segundo
use ToDoDb;


-- Rode a linha abaixo para criar tabela
create table Items(
	Id uniqueidentifier not null primary key,
	Description varchar(256) not null,
	Done bit not null,
	CreatedAt Datetime not null
);


-- =================== Inserindo registros iniciais ============================
-- Rode as duas linhas abaixo
insert into Items values ('4380393a-67e1-44b7-99a1-fbb2ce969221', 'Entrar na aula', 1, GetDate());
insert into Items values ('28a32095-6363-4b65-8668-a9035e6ef7a1', 'Aprender principios .NET', 0, GetDate());
insert into Items values ('bfd6863f-a82d-48fb-bca6-7e90d4f6921a', 'Aprender NodeJS com Express', 0, GetDate());
insert into Items values ('bc890193-3790-4d2d-9b56-83bd21143361', 'Aprender Java com Spring', 0, GetDate());
insert into Items values ('b50f03ea7-d189-4dd8-b949-f9c3c4c6b929', 'Aprender Java com Quarkus', 0, GetDate());



