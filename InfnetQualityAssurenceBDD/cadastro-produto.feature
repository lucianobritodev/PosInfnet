#enconding: UTF-8
#language: pt-br

Funcionalidade: Cadastro de Produtos
    Possibilitar registros de novos produtos em loja online.


Contexto:
    Dado que "Fulano" possua ou não uma conta no sistema


Cenario: "Fulano" não cadastrado
    E ele acessa página de login
    E preenche os campos
    Quando ele acionar o botão de acesso
    Então ele deve ser redirecionado para página de cadastro.


Cenario: "Fulano" cadastrado efetuando login
    E ele acessa página de login
    E preenche os campos
    Quando ele acionar o botão de acesso
    Então ele deve ser redirecionado para página principal da aplicação.


Cenario: "Fulano" cadastrado, mas sem privilégio de escrita
    E ele estando logado na aplicação
    E acessa a página de cadastro de produtos
    E preenche os campos para cadastro de produto
    Quando ele acionar o botão de salvar
    Então ele deve receber uma mensagem.


Cenario: Dados de cadastro de produto incorretos
    E "Fulano" estando logado na aplicação
    E acessa a página de cadastro de produtos
    E preencha os campos para cadastro de produto incorretamente
    Quando ele acionar o botão de salvar
    Então o cadastro do produto não deve ser realizado.


Cenario: Cadastro de produto deve ser realizado
    E "Fulano" estando logado na aplicação
    E acessa a página de cadastro de produtos
    E preenchendo os campos para cadastro de produto corretamente
    Quando ele acionar o botão de salvar
    Então o cadastro do produto deve ser realizado com sucesso.