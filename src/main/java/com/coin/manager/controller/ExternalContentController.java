package com.coin.manager.controller;

import com.coin.manager.entity.ExternalWriter;
import com.coin.manager.form.ExternalWriterForm;
import com.coin.manager.service.ExternalContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@ResponseBody
@RequestMapping("external-content")
public class ExternalContentController {
    private final ExternalContentService externalContentService;

    @PostMapping("/regster-writer")
    public ExternalWriter regsterWriter(@RequestBody @Valid ExternalWriterForm externalWriterForm) throws Exception {
        ExternalWriter writer = externalContentService.regsterWriter(externalWriterForm);
        return writer;
    }
}
