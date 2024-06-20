# GitHub Popular Repositories

Este projeto é um aplicativo Android em Kotlin para consultar a API do GitHub e listar os repositórios mais populares em Java. O aplicativo também permite visualizar as Pull Requests de cada repositório.

## Arquitetura

O projeto segue uma arquitetura dividida em quatro partes:
- **app**: Contém a atividade principal e a configuração do Dagger Hilt.
- **data**: Contém a definição da API e modelos de dados.
- **domain**: Contém a lógica de negócio e o repositório.
- **ui**: Contém a ViewModel, adaptadores e atividades.

## Bibliotecas Utilizadas

- Retrofit e OkHttp para chamadas de API.
- RxJava para programação reativa.
- Dagger Hilt para injeção de dependência.
- Glide para carregamento de imagens.
- Mockk para testes unitários.
- Espresso para testes de UI.

## Funcionalidades

- Lista de repositórios populares em Java com paginação e endless scroll.
- Exibição do nome, descrição, autor, número de estrelas e forks de cada repositório.
- Visualização das Pull Requests de um repositório.
- Abertura da página do Pull Request no navegador ao clicar no item.

## Testes

Os testes unitários são escritos com Mockk e os testes de UI são escritos com Espresso.

## Configuração

1. Clone o repositório.
2. Abra o projeto no Android Studio.
3. Sincronize os arquivos Gradle.
4. Execute o aplicativo.

## Melhorias Futuras

- Adicionar mais testes unitários e de UI.
- Melhorar o tratamento de erros.
- Implementar cache de API.

