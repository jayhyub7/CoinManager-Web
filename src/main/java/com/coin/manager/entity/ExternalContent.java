package com.coin.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class ExternalContent {

    @EmbeddedId
    private ExternalContentKey id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 5000, nullable = false)
    private String content;

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
