package com.coin.manager.parser;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.entity.ExternalWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


public abstract class ContentParser {
    public abstract ExternalContent getNewContent(ExternalWriter externalWriter);
}
