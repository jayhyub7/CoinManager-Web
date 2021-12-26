package com.coin.manager.exception;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalException {

    @ExceptionHandler(DuplicateEmailException.class)
    public JSONObject duplicateEmailException(){
        return ErrorResponse.jsonErrorResponse(400, "중복된 이메일 입니다.");
    }

    @ExceptionHandler(DuplicateExternalIdException.class)
    public JSONObject duplicateExternalIdException(){
        return ErrorResponse.jsonErrorResponse(400, "중복된 외부 사이트 아이디입니다.");
    }

    @ExceptionHandler(SuchNoMemberException.class)
    public JSONObject suchNoMemberException(){
        return ErrorResponse.jsonErrorResponse(400, "존재하지 않는 회원입니다.");
    }
    @ExceptionHandler(SuchNoExternalSiteCodeException.class)
    public JSONObject suchNoExternalSiteCodeException(){
        return ErrorResponse.jsonErrorResponse(400, "설정되지 않은 외부사이트 입니다.");
    }
    @ExceptionHandler(BusinessLogicException.class)
    public JSONObject businessLogicException(String message){
        return ErrorResponse.jsonErrorResponse(400, message);
    }
}