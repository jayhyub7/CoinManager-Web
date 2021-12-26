package com.coin.manager.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ExternalContentForm {
    @NotEmpty(message = "외부사이트 코드는 필수 입니다")
    @Size(max = 20, message = "외부사이트 코드는 20자리를 초과할 수 없습니다.")
    private String externalSiteCode;

    @NotEmpty(message = "콘텐츠아이디는 필수 입니다")
    @Size(max = 20, message = "콘텐츠아이디는 20자리를 초과할 수 없습니다.")
    private String contentId;

    @NotEmpty(message = "타이틀은 필수 입니다")
    @Size(max = 100, message = "타이틀은 20자리를 초과할 수 없습니다.")
    private String title;

    @NotEmpty(message = "컨텐츠는 필수 입니다")
    @Size(max = 100, message = "컨텐츠는 5000자리를 초과할 수 없습니다.")
    private String content;

}
