package com.coin.manager.exchange_connector;

import com.coin.manager.entity.Candle;

public interface ExchangeConnector {
    /**
     * BTC 시세조회
     * */
    public double getBitCoinPrice();
}
