package com.coin.manager.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class MemberForm {

    @NotEmpty(message = "이메일은 필수 입니다")
    @Size(max = 50, message = "이메일은 50자리를 초과할 수 없습니다.")
    private String email;

    @NotEmpty(message = "이름은 필수 입니다")
    @Size(max = 20, message = "이름은 100자리를 초과할 수 없습니다.")
    private String name;

    @NotEmpty(message = "비밀번호는 필수 입니다")
    @Size(max = 20, message = "비밀번호는 100자리를 초과할 수 없습니다.")
    private String password;

}
