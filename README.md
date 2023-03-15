
# Sistema de Gestão Clínica - Instituto Metamorfose
Este projeto consiste na implementação completa do sistema de gerenciamento do Instituto Metamorfose. Sendo ele implementado uma parte no repositório público, e o restante dos módulos estaram no repositório privado.


![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
> 🚧  Projeto sendo aperfeiçoado...  🚧

## Descrição

A clínica possui diversas rotinas, quevão desde a gestão dos pacientes, controle de agendamentos, fluxo de atividades diários repassados ao final de cada expeiente, contorles financeiros e de estoques.
O projeto conta com dois perfis application.properties, sendo o perfil de testes e o perfil de desenvolvimento.

>### Módulos do sistema.
<hr>
##### :hammer: Repositório público

- `CRUD Funcionários`: Controle total dos funcionários
- `CRUD Especialistas`: Controle total dos especialistas
- `CRUD pacientes`: Controle total dos funcionários
- `Agendamentos (Simples)`: Controle de marcação e agendamento de consultas
<hr>
##### :hammer: Repositório Privado

- `CRUD Funcionários`: Controle total dos funcionários
- `CRUD Especialistas`: Controle total dos especialistas
- `CRUD pacientes`: Controle total dos funcionários
- `Agendamentos Completo`: Controle de marcação e agendamento de consultas
- `Financeiro Atendimento`: Financeiro para prestação de contas com os especialistas no final do atendimento
- `CRUD de Serviços`: Controle dos serviços ofertados pela clínica
- `Gestão Financeira`: Controle Financeiro da empresa - Gestão de entradas e saida, Fluxo de caixa
- `Controle de Estoque`: Gestão do estoque da empresa;
- `Controle de rotina`: Gestão da rotina de atividades realizada pelos funcionários
- 'Sistema de Login'

<hr>


### Tecnologias utilizadas

- Spring Framework
- Java 17
- Angular
- JPA/Hibernate
- Lombok
- Apache Tomcat 9
- API Rest

## Ferramentas Usadas Para Implementação
* ### IntelliJ IDEA

## Padrão de Projeto Aplicado
* MVC(MODEL,VIEW,CONTROLLER) em um sistema desktop java;
    * O princípio básico do MVC é a divisão da aplicação em três camadas: a camada de interação do usuário (view), a camada de manipulação dos dados (model) e a camada de            controle (controller);
    * MODEL
        1. A responsabilidade dos models é representar o negócio. Também é responsável pelo acesso e manipulação dos dados na sua aplicação.
    * CONTROLER
        1. É a camada de controle, responsável por ligar o model e a view, fazendo com que os models possam ser repassados para as views e vice-versa.
    * VIEW
        1. A view é responsável pela interface que será apresentada, mostrando as informações do model para o usuário.

## Padrão DTO
* Padrão para controle dos dados da Entidade

# Para executar o projeto, siga os seguintes passos:

# Para executar o projeto, siga os seguintes passos:

1. Clone o repositório em sua máquina
2. Abra o projeto em sua IDE de preferência
3. Configure o banco de dados MySQL em sua máquina e atualize as configurações do arquivo `application.properties` com as informações de conexão do seu banco de dados
4. Acesse a aplicação em seu navegador através do endereço `http://localhost:8080`

## Contribuição
Este projeto foi desenvolvido por Rafael Aguiar. Se você deseja contribuir para o projeto, sinta-se à vontade para fazer um fork do repositório e submeter um pull request com suas alterações. Será um prazer receber contribuições da comunidade!