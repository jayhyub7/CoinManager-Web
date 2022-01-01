package com.coin.manager.exchange_connector;

import com.coin.manager.parser.CoinpanContentParser;
import com.coin.manager.parser.ContentParser;

public class ExchangeConnectorFactory {

    public ExchangeConnector getExchangeConnector(String exchangeCode) {
        if (exchangeCode.equalsIgnoreCase("BINANCE")) {
            return new BinanceConnector();
        }

        return null;
    }
}
