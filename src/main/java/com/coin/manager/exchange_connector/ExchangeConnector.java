package com.coin.manager.exchange_connector;

import com.coin.manager.entity.Candle;

public interface ExchangeConnector {
    /**
     * BTC ์์ธ์กฐํ
     * */
    public double getBitCoinPrice();
}
