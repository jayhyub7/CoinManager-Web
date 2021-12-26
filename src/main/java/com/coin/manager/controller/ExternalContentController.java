package com.coin.manager.controller;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.entity.ExternalWriter;
import com.coin.manager.form.ExternalWriterForm;
import com.coin.manager.service.ExternalContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@ResponseBody
@RequestMapping("external-content")
public class ExternalContentController {
    private final ExternalContentService externalContentService;

    @PostMapping("/writer/regster")
    public ExternalWriter regsterWriter(@RequestBody @Valid ExternalWriterForm externalWriterForm) throws Exception {
        ExternalWriter writer = externalContentService.regsterWriter(externalWriterForm);
        return writer;
    }

    @GetMapping("/witer/list")
    public List<ExternalWriter> writerList(String memberId) throws Exception {
        List<ExternalWriter> list = externalContentService.getWriterList(memberId);
        return list;
    }

    @GetMapping("/new-content/list")
    public List<ExternalContent> newContentList(String memberEmail) throws Exception {
        List<ExternalContent> content = externalContentService.newContentList(memberEmail);
        return content;
    }

}
