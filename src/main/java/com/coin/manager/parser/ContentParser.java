package com.coin.manager.parser;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.entity.ExternalContentKey;
import com.coin.manager.entity.ExternalWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


public interface ContentParser {

    /**
     * 상세내용을 제외하고 중복 여부를 체크할 수 있는 데이터만 얻는다.
     * */
    public ExternalContent getRecentContentIndexByWriter(ExternalWriter externalWriter);

    /**
     * 상세내용을 포함한 전체 Content 데이터를 얻는다.
     * */
    ExternalContent getContentDetail(ExternalContent item);
}
