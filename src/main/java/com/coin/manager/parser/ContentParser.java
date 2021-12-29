package com.coin.manager.parser;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.entity.ExternalContentKey;
import com.coin.manager.entity.ExternalWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


public interface ContentParser {
    public ExternalContent getRecentContentByWriter(ExternalWriter externalWriter);
}
