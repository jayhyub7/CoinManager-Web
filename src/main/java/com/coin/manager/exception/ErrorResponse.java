package com.coin.manager.exception;

import org.json.simple.JSONObject;

public class ErrorResponse {

    public static JSONObject jsonErrorResponse(int errorCode, String errorMessage) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("responseCode", errorCode);
        jsonObject.put("errorMessage", errorMessage);
        return jsonObject;
    }
}