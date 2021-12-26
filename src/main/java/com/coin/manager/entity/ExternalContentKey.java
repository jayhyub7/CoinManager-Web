package com.coin.manager.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ExternalContentKey implements Serializable {

    public ExternalContentKey() {}

    public ExternalContentKey(String externalSiteCode, String contentId) {
        this.externalSiteCode = externalSiteCode;
        this.contentId = contentId;
    }

    @Column(length = 20, nullable = false)
    private String externalSiteCode;

    @Column(length = 20, nullable = false)
    private String contentId;


}