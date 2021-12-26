package com.coin.manager.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class ExternalContent {

    @EmbeddedId
    private ExternalContentKey id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 5000, nullable = false)
    private String content;
}
