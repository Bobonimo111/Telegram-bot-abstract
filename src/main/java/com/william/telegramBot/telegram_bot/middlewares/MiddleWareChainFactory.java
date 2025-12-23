package com.william.telegramBot.telegram_bot.middlewares;


import org.springframework.stereotype.Service;

import java.util.List;

//Quero garantir a ordem de execução dos middlewares
@Service
public class MiddleWareChainFactory {

    public MiddleWareChainFactory() {

    }

    public MiddleWareChain executor(){
        //Isso me garante que cada middleware vai ser executado posterior ao outro
        //Adicione os middlewares criados aq
        return new MiddleWareChain(List.of(

        ));
    }
}
