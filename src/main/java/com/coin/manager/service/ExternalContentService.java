package com.coin.manager.service;

import com.coin.manager.entity.ExternalWriter;
import com.coin.manager.exception.DuplicateExternalIdException;
import com.coin.manager.exception.SuchNoExternalSiteException;
import com.coin.manager.form.ExternalWriterForm;
import com.coin.manager.parser.CoinpanContentParser;
import com.coin.manager.parser.ExternalContentParser;
import com.coin.manager.repository.ExternalWriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExternalContentService {
    private final ExternalWriterRepository externalWriterRepository;

    @Transactional
    public ExternalWriter regsterWriter(ExternalWriterForm externalWriterForm) throws Exception {
        String externalSite = externalWriterForm.getExternalSite();
        String nickName = externalWriterForm.getNickName();

        if (externalWriterRepository.existsByExternalSiteAndNickName(externalSite, nickName)) {
            throw new DuplicateExternalIdException();
        }

        ExternalContentParser externalContentParser = null;
        if ("COINPAN".equals(externalSite)) {
            externalContentParser = new CoinpanContentParser();
        } else {
            throw new SuchNoExternalSiteException();
        }
        //닉네임으로 해당 사이트의 ID 를 얻는다.
        String externalId = externalContentParser.getExternalId(nickName);
        ExternalWriter externalWriter = externalWriterRepository.save(ExternalWriter.CreateExternalWriter(externalWriterForm));
        
        return externalWriter;
    }

}
