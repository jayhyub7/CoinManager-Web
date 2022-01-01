package com.coin.manager.exchange_connector;

import com.coin.manager.entity.Candle;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class BinanceConnector implements ExchangeConnector {
    private final String API_URL = "https://api.binance.com";
    @Override
    public double getBitCoinPrice() {
        String action = "/api/v3/ticker";
        Map<String, Object> result = callApi(action, HttpMethod.GET);
        return 0;
    }

    private Map<String, Object> callApi(String action, HttpMethod method) {
        RestTemplate template = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(API_URL + action).build();
        ResponseEntity<String> result = template.exchange(uri.toString(), method, entity, String.class);
        System.out.println(result);
        System.out.println(result);
        System.out.println(result);
        System.out.println(result);
        return null;
    }
}
