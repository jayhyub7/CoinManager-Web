package com.coin.manager.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ExternalContentKey implements Serializable {

    public ExternalContentKey() {}

    public ExternalContentKey(String externalSite, String contentId) {
        this.externalSite = externalSite;
        this.contentId = contentId;
    }

    @Column(length = 20, nullable = false)
    private String externalSite;

    @Column(length = 20, nullable = false)
    private String contentId;


}