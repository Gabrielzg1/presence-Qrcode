# Backend para Sistema de Validação de Presença via QR Code

## Sobre

Este repositório contém o backend de um sistema destinado à validação de presença de alunos em ambientes educacionais utilizando QR Code. O sistema permite que instituições de ensino automatizem o processo de registro de presença, tornando-o mais eficiente e reduzindo as chances de erros manuais.

## Tecnologias Utilizadas

O backend foi desenvolvido com o uso de várias tecnologias e frameworks, incluindo:

- **Spring Boot**: Para facilitar a criação de aplicações stand-alone que podem ser facilmente executadas.
- **Spring Data JPA**: Para a persistência de dados em SQL com API Java Persistence API.
- **Spring Web**: Para criar APIs RESTful.
- **H2 Database**: Um banco de dados em memória para testes e desenvolvimento.
- **Lombok**: Para reduzir o boilerplate code em objetos Java.
- **ZXing ("Zebra Crossing")**: Uma biblioteca para gerar e interpretar QR Codes.
- **JSON**: Para manipulação de dados no formato JSON.

## Configuração e Instalação

Para executar este projeto localmente, siga os passos abaixo:

1. Clone o repositório para sua máquina local:

2. Abra o projeto no seu IDE de preferência e aguarde a sincronização das dependências Maven.

3. Configure um banco de dados H2 ou outro de sua preferência ajustando o arquivo `application.properties`.

4. Execute o projeto através do IDE 

## Funcionalidades

O sistema de backend oferece funcionalidades como:

- **Geração de QR Codes**: Para cada aula ou evento, um QR Code único é gerado para os alunos escanearem.
- **Validação de Presença**: Quando um aluno escaneia o QR Code, o sistema valida a presença automaticamente.
- **Administração de Aulas e Eventos**: Permite a criação e gerenciamento de aulas ou eventos pelos quais os QR Codes são gerados.
- **Relatórios de Presença**: Geração de relatórios de presença para análise e acompanhamento acadêmico.

