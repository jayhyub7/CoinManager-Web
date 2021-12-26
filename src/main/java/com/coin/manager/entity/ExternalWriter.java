package com.coin.manager.entity;

import com.coin.manager.form.ExternalWriterForm;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class ExternalWriter {
    public ExternalWriter() {}

    public ExternalWriter(ExternalWriterForm externalWriterForm) {
        this.externalSite = externalWriterForm.getExternalSite();
        this.nickName = externalWriterForm.getNickName();

    }

    public static ExternalWriter CreateExternalWriter(ExternalWriterForm externalWriterForm) {
        return new ExternalWriter(externalWriterForm);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(length = 20, nullable = false)
    private String externalSite;

    @Column(length = 50, nullable = false)
    private String nickName;

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
