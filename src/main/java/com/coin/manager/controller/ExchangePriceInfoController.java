package com.coin.manager.controller;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.service.ExchangePriceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@ResponseBody
@RequestMapping("exchange-price-info")
public class ExchangePriceInfoController {

    private final ExchangePriceInfoService exchangePriceInfoService;

    @GetMapping("/new-content/list")
    public List<String> newContentList(String memberEmail) throws Exception {
        
        return null;
    }
}
