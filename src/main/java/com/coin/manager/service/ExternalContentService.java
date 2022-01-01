package com.coin.manager.service;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.entity.ExternalWriter;
import com.coin.manager.entity.ExternalWriterKey;
import com.coin.manager.exception.DuplicateExternalIdException;
import com.coin.manager.exception.SuchNoMemberException;
import com.coin.manager.form.ExternalWriterForm;
import com.coin.manager.parser.ContentParser;
import com.coin.manager.parser.ContentParserFactory;
import com.coin.manager.repository.ExternalContentRepository;
import com.coin.manager.repository.ExternalWriterRepository;
import com.coin.manager.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalContentService {
    private final ExternalWriterRepository externalWriterRepository;
    private final MemberRepository memberRepository;
    private final ExternalContentRepository externalContentRepository;

    private final List<String> externalSiteCodeList =Arrays.asList(new String[]{"COINPAN"});

    @Transactional
    public ExternalWriter regsterWriter(ExternalWriterForm externalWriterForm) throws Exception {
        String memberEmail = externalWriterForm.getMemberEmail();
        String externalSiteCode = externalWriterForm.getExternalSiteCode();
        String nickName = externalWriterForm.getNickName();

        if (memberRepository.findByEmail(memberEmail).isEmpty()) {
            throw new SuchNoMemberException();
        }

        ExternalWriterKey id = new ExternalWriterKey(memberEmail, externalSiteCode, nickName);;
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
        ContentParserFactory contentParserFactory = new ContentParserFactory();

        for (String externalSiteCode : externalSiteCodeList) {
            ContentParser parser = contentParserFactory.getContentParser(externalSiteCode);
            List<ExternalWriter> writerList = externalWriterRepository.findByMemberMemberEmailAndExternalSiteCode(memberEmail, externalSiteCode);
            for (ExternalWriter writer : writerList) {

                ExternalContent recentContent = parser.getRecentContentIndexByWriter(writer);
                if (externalContentRepository.existsById(recentContent.getId())) {
                    continue;
                }
                ExternalContent newContent = parser.getContentDetail(recentContent);
                log.info(newContent.getId().getNickName() + ": " + newContent.getTitle() + " 등록됨");
                externalContentRepository.save(newContent);
            }
        }

        return newContentList;
    }
}
