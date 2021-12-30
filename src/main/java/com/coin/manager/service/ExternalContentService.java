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
        System.out.println(externalSiteCodeList);
        for (String externalSiteCode : externalSiteCodeList) {
            ContentParser parser = contentParserFactory.getContentParser(externalSiteCode);
            List<ExternalWriter> writerList = externalWriterRepository.findByMemberMemberEmailAndExternalSiteCode(memberEmail, externalSiteCode);
            System.out.println(writerList);
            System.out.println(writerList);
            for (ExternalWriter writer : writerList) {
                System.out.println("진입함");
                ExternalContent recentContent = parser.getRecentContentIndexByWriter(writer);
                if (externalContentRepository.existsById(recentContent.getId())) {
                    System.out.println("컨티뉴");    
                    continue;
                }
                ExternalContent newContent = parser.getContentDetail(recentContent);
                System.out.println(newContent);
                if (true) return null;

                externalContentRepository.save(newContent);
            }
        }

        return newContentList;
    }
}
