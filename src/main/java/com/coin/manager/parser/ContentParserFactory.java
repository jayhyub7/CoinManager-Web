package com.coin.manager.parser;

public class ContentParserFactory {

    public ContentParser getContentParser(String externalSiteCode) {
        if (externalSiteCode.equalsIgnoreCase("COINPAN")) {
            return new CoinpanContentParser();
        }

        return null;
    }

}
