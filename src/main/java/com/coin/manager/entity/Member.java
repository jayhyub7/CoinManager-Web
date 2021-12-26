package com.coin.manager.entity;

import com.coin.manager.form.MemberForm;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;


@Entity
@Data
public class Member {

    public Member() {}

    public Member(MemberForm memberForm) {
        this.email = memberForm.getEmail();
        this.name = memberForm.getName();
        this.password = memberForm.getPassword();
    }

    public static Member CreateMember(MemberForm memberForm) {
        return new Member(memberForm);
    }

    @Id
    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String password;

    @Column
    private Date insDate;

    @Column
    private Date updDate;

    @PrePersist
    void insDate() {
        this.insDate = new Date();
    }

    @PreUpdate
    void updDate() {
        this.updDate = new Date();
    }

}
