package com.coin.manager.service;

import com.coin.manager.entity.BitInfo;
import com.coin.manager.exchange_connector.ExchangeConnector;
import com.coin.manager.exchange_connector.ExchangeConnectorFactory;

public class ExchangePriceInfoService {

    public BitInfo getBitInfo() {
        ExchangeConnectorFactory exchangeConnectorFactory = new ExchangeConnectorFactory();
        ExchangeConnector binanceConnector = exchangeConnectorFactory.getExchangeConnector("BINANCE");
        ExchangeConnector upbitConnector = exchangeConnectorFactory.getExchangeConnector("UPBIT");
        BitInfo bitInfo = new BitInfo();
        bitInfo.setBinancePrice(binanceConnector.getBitCoinPrice());
        bitInfo.setUpbitPrice(upbitConnector.getBitCoinPrice());
        return null;
    }
}
