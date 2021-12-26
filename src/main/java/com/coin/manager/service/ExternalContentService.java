package com.coin.manager.service;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.entity.ExternalWriter;
import com.coin.manager.entity.ExternalWriterKey;
import com.coin.manager.exception.BusinessLogicException;
import com.coin.manager.exception.DuplicateExternalIdException;
import com.coin.manager.exception.SuchNoExternalSiteException;
import com.coin.manager.exception.SuchNoMemberException;
import com.coin.manager.form.ExternalWriterForm;
import com.coin.manager.parser.CoinpanContentParser;
import com.coin.manager.parser.ExternalContentParser;
import com.coin.manager.repository.ExternalWriterRepository;
import com.coin.manager.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalContentService {
    private final ExternalWriterRepository externalWriterRepository;
    private final MemberRepository memberRepository;

    private final List<String> externalSiteList =Arrays.asList(new String[]{"COINPAN"});

    @Transactional
    public ExternalWriter regsterWriter(ExternalWriterForm externalWriterForm) throws Exception {
        String memberEmail = externalWriterForm.getMemberEmail();
        String externalSite = externalWriterForm.getExternalSite();
        String nickName = externalWriterForm.getNickName();

        if (memberRepository.findByEmail(memberEmail).isEmpty()) {
            throw new SuchNoMemberException();
        }

        ExternalWriterKey id = new ExternalWriterKey(memberEmail, externalSite, nickName);;
        if (externalWriterRepository.existsById(id)) {
            throw new DuplicateExternalIdException();
        }

        ExternalWriter externalWriter = externalWriterRepository.save(ExternalWriter.CreateExternalWriter(externalWriterForm));
        
        return externalWriter;
    }

    public List<ExternalWriter> getWriterList(String memberEmail) {
        List<ExternalWriter> writerList = externalWriterRepository.findByMemberEmail(memberEmail);
        return writerList;
    }

    public List<ExternalContent> newContentList(String memberEmail) {

        if (memberRepository.findByEmail(memberEmail).isEmpty()) {
            throw new SuchNoMemberException();
        }

        List<ExternalContent> newContentList = new ArrayList<>();
        for (String externalSite : externalSiteList) {
            
        }
        return newContentList;
    }
}
