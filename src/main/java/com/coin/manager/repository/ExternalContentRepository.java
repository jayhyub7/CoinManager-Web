package com.coin.manager.repository;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.entity.ExternalContentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalContentRepository extends JpaRepository<ExternalContent, ExternalContentKey> {

    boolean existsById(ExternalContentKey id);

}
