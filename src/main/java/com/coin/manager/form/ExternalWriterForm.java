package com.coin.manager.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ExternalWriterForm {

    @NotEmpty(message = "멤버 이메일은 필수 입니다.")
    @Size(max = 50, message = "멤버 이메일은 50자리를 초과할 수 없습니다.")
    private String memberEmail;

    @NotEmpty(message = "외부사이트 코드는 필수 입니다")
    @Size(max = 20, message = "외부사이트 코드는 20자리를 초과할 수 없습니다.")
    private String externalSiteCode;

    @NotEmpty(message = "닉네임은 필수 입니다")
    @Size(max = 50, message = "닉네임은 50자리를 초과할 수 없습니다.")
    private String nickName;
}
