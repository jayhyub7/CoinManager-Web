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
        this.id = new ExternalWriterKey(
                externalWriterForm.getMemberEmail(),
                externalWriterForm.getExternalSite(),
                externalWriterForm.getNickName()
                );
    }

    public static ExternalWriter CreateExternalWriter(ExternalWriterForm externalWriterForm) {
        return new ExternalWriter(externalWriterForm);
    }

    @EmbeddedId
    private ExternalWriterKey id;

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
