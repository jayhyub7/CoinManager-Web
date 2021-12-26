package com.coin.manager.parser;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.exception.SuchNoExternalSiteCodeException;

public interface ContentParser {
    ContentParser getContentParser(String externalSiteCode);

    public class ContentParserFactory implements ContentParser {
        @Override
        ContentParser getContentParser(String externalSiteCode) {
            if ("COINPAN".equals(externalSiteCode)) {
                return new CoinpanContentParser();
            } else {
                throw new SuchNoExternalSiteCodeException();
            }

        }
    }
}
