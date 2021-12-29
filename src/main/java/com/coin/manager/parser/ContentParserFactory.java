package com.coin.manager.parser;

import com.coin.manager.exception.SuchNoExternalSiteCodeException;
import com.coin.manager.repository.MemberRepository;

public class ContentParserFactory {

    public ContentParser getContentParser(String externalSiteCode) {
        if (externalSiteCode.equalsIgnoreCase("COINPAN")) {
            return new CoinpanContentParser();
        }

        return null;
    }

}
