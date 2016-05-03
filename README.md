# PocketSenado
Aplicação para Android, nativa, que tem como objetivo principal trazer informações sobre o Senado Federal. A ideia, ainda em desenvolvimento inicial, tem como proposta oferecer as seguintes funcionalidades:é trazer os dados principais sobre os senadores, assim como as comissões das quais eles fazem parte, os seus projetos e propostas, dados sobre a agenda do senado, etc.

- Dados principais dos senadores
- Comissões das quais eles fazem parte
- Seus projetos e suas propostas
- Relatorias de cada senador
- Comissões permanentes, temporárias e CPIs
- Agenda do senado
- Progresso de matérias

![](https://raw.githubusercontent.com/somewild1/PocketSenado/master/screenshots/prints.png)

**OBS:** algumas funcionalidades apresentadas nas screenshots podem ser alteradas, visto que o aplicativo está em seu estágio inicial e algumas ideias podem não ser implementadas.

## Desenvolvimento
A aplicação está sendo desenvolvida utilizando o Android Studio na versão 2.0. Para contribuir com o projeto, simplesmente clone o repositório e importe-o em seu Android Studio.

A API utilizada para buscar os dados sobre o senado pode ser encontrada [neste link](http://legis.senado.gov.br/dadosabertos/docs/resources.html), utilizando Enunciate, ou mesmo [aqui](http://legis.senado.gov.br/dadosabertos/docs/ui/index.html), utilizando Swagger UI.

## Bibliotecas utilizadas
- [CircleImageView](https://github.com/hdodenhof/CircleImageView)
- [Picasso](http://square.github.io/picasso/)
