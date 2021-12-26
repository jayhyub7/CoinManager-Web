package com.coin.manager.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ExternalWriterKey implements Serializable {

    public ExternalWriterKey(){}

    public ExternalWriterKey(String memberEmail, String externalSite, String nickName) {
        this.memberEmail = memberEmail;
        this.externalSite = externalSite;
        this.nickName = nickName;
    }

    @Column(length = 50, nullable = false)
    private String memberEmail;

    @Column(length = 20, nullable = false)
    private String externalSite;

    @Column(length = 50, nullable = false)
    private String nickName;

}