package com.coin.manager.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class BitInfo {

    private double binancePrice;
    private double upbitPrice;
}
