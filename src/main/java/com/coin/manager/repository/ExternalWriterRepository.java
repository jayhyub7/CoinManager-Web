package com.coin.manager.repository;

import com.coin.manager.entity.ExternalWriter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalWriterRepository extends JpaRepository<ExternalWriter, Long> {

    boolean existsByExternalSiteAndNickName(String externalSite, String nickName);
}
