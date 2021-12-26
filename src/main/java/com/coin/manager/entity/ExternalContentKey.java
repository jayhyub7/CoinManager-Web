package com.coin.manager.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ExternalContentKey implements Serializable {

    @Column(length = 20, nullable = false)
    private String externalSite;

    @Column(length = 20, nullable = false)
    private String contentId;

    public ExternalContentKey(String externalSite, String contentId) {
        this.externalSite = externalSite;
        this.contentId = contentId;
    }
}