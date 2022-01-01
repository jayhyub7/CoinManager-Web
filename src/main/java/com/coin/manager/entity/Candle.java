package com.coin.manager.entity;

import lombok.Data;

@Data
public class Candle {
    /** 마켓명 */
    private String market;
    /** 시가 */
    private double openPrice;
    /** 고가 */
    private double highPrice;
    /** 종가 */
    private double tradePrice;
    /** 저가 */
    private double lowPrice;
    /** 분단위 */
    private double minuteUnit;
}
