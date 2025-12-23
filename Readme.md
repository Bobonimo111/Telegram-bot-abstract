## Objetivo
#### Estudar e aplicar patterns além de entender o funcionamento da API do telegram e como posso interagir com ela junto ao meu código

## Como usar ?
- Gere bot no bot father do telegram 
- adicione a chave do bot application.properties a variavel telegram-api-key
- Ao iniciar no seu bot use /start ira aparecer um menu para testar o callBack

para adicionar mais comandos use da sua engenhosidade como programador e set as interfaces corretamente 

## Design Patterns
- Strategy
- Factory abstract
- Simple Factory
- Chain of Responsibility

## Componentes do desenvolvimento
- Spring Boot (Injeção de dependencias)
- Open Feign (Consumo e interração com API)
- Lombok

## Onde cada coisa foi aplicada e por qual motivo ?

O padrão strategy foi aplicado nos arquivos [CallbackController.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/controllers/CallbackController.java) e
[CommandController.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/controllers/CommandController.java) que podem ser chamados pela simple factory [InteractionControllerFactory.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/controllers/InteractionControllerFactory.java)

Os arquivos callBackController e commandController tem como objetivo definir o arquivo de contexto para cada tipo de mensagem.

Eles instanciam cada uma AbstractionFactory designada senda elas as [CommandsFactory.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/commands/CommandsFactory.java)e [CallBackFactory.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/callback/CallBackFactory.java)
, que elas sim tem capacidade de chamar as mensagens ou não que serão retornadas para o bot.

O padrão chain of Reposability foi criado para os middlewares onde é possivel ver nos arquivos [MiddleWareChain.java](src/main/java/com/william/telegramBot/telegram_bot/middlewares/MiddleWareChain.java) e [MiddleWareChainFactory.java](src/main/java/com/william/telegramBot/telegram_bot/middlewares/MiddleWareChainFactory.java)  

## Criando coisas novas 

Toda mensagem ou callBack deve estar anotado de @Componente para poder ser gerenciado pelo spring,
e implementado a interface [IInterraction.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/IInterraction.java) passando o seu contexto designado
além disso para criar novos contextos deve apenas adicinar uma nova regrar no arquivo [InteractionControllerFactory.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/controllers/InteractionControllerFactory.java) e criar um arquivo de contexto que Implemente IInterractionContext[IInterractionContext.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/IInterractionContext.java) 
que por sua vez implemente [IInterraction.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/IInterraction.java) e a ele proprio, essa estrutra é feita para o contexto ser acessivel aos middlewares, que devem por sua vez ser configurados no [InteractionControllerFactory.java](src/main/java/com/william/telegramBot/telegram_bot/interactions/controllers/InteractionControllerFactory.java)  